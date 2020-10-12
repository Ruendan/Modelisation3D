package modele.parser;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

import modele.modelisation.Face;
import modele.modelisation.Ply;
import modele.modelisation.Point;
import modele.parser.exception.ElementPropertiesError;
import modele.parser.exception.UnsupportedFileFormat;
import modele.parser.exception.NotPlyFileException;
import modele.parser.exception.PlyParserException;
import modele.parser.exception.PropertyPropertiesError;

public class PlyParser {
	
	private static String url = "ressources/plys/";
	boolean headCorrect;
	
	
	private int pointPos;
	private int xpos;
	private int ypos;
	private int zpos;
	private boolean midHeader;
	private int extraElements;
	
	private int idx;
	private int extraPropertys;
	
	private int vertex;
	private int face;
	
	private ArrayList<String> comment;
	private Set<Point> points;
	private List<Point> pointsTotaux;
	private List<Face> faces;
	
	public static Ply loadPly(String nom) throws PlyParserException {
		PlyParser pp = new PlyParser();
		Ply ply = new Ply();
		ply.setName(nom);
		pp.loadPly(ply, nom);
		return ply;
	}
	
	public void loadPly(Ply res,String filename) throws PlyParserException {
		loadPly(res,new File(url+filename+".ply"));
	}
	
	public void loadPly(Ply res,File fichier) throws PlyParserException {
		pointPos = 0;
		idx = 0;
		vertex = -1;
		face = -1;
		
		String[] lines = new String[0];
		
		try(Scanner sc = new Scanner(fichier)) {
			StringBuilder content = new StringBuilder();
			while(sc.hasNextLine())content.append(sc.nextLine()+"\n");
			lines = content.toString().split(""+'\n');
		} catch (FileNotFoundException e) {e.printStackTrace();}
		if(!(lines.length<12)) {
			if(handleHeader(lines)&&handleBody(lines)) {
				res.setVertex(vertex);
				res.setNbFace(face);
				res.setPoints(points);
				res.setFaces(faces);
				res.setComment(comment);
			}
		}
	}
	
	private boolean handleHeader(String[] lines) throws PlyParserException {
		boolean endHeader = false;
		comment = new ArrayList<String>();
		extraPropertys = 0;
		extraElements = 0;
		xpos = -1;
		ypos = -1;
		zpos = -1;
		
		if(!checkType(lines[0]))return false;
		if(!checkFormat(lines[1]))return false;
		idx=2;
		while(!endHeader) {
			String[] line = lines[idx].split(" ");
			switch (line[0]) {
			case "end_header":
				endHeader = true;
				break;
			case "comment":
				comment.add(lines[idx].substring(8));
				break;
			case "element":
				if(!handleElement(line))return false;
				break;
			case "property":
				if(!handleProperty(line))return false;
				break;
			}
			idx++;
		}
		return checkHeader(lines);
	}

	private boolean checkType(String line) throws NotPlyFileException{
		if(line.equals("ply"))return true;
		else {
			throw new NotPlyFileException();
		}
	}
	
	private boolean checkFormat(String line) throws UnsupportedFileFormat {
		if(line.equals("format ascii 1.0"))return true;
		throw new UnsupportedFileFormat();
	}
	
	private boolean handleElement(String[] line) throws ElementPropertiesError {
		if(line.length==3&&line[1].equals("vertex")&&Integer.parseInt(line[2])>2) {
			vertex = handleVertex(line[2]);
		} else if(line.length==3&&line[1].equals("face")&&Integer.parseInt(line[2])>0) {
			face = handleFace(line[2]);
		} else if(midHeader && line.length==3) {
			extraElements += Integer.parseInt(line[2]);
			extraPropertys++;
		} else {
			throw new ElementPropertiesError();
		}
		return true;
	}

	private int handleVertex(String vert) {
		if(vert.matches("[0-9]+")) {
			pointPos = idx;
			return Integer.parseInt(vert);
		}
		return -1;
	}
	
	private int handleFace(String face) {
		if(face.matches("[0-9]+"))return Integer.parseInt(face);
		else return -1;
	}

	private boolean handleProperty(String[] line) throws PropertyPropertiesError {
		if(line.length==3&&(line[1].equals("float")||line[1].equals("float32"))) {
			if(line[2].equals("x")&&xpos==-1)xpos=idx-pointPos-1;
			else if(line[2].equals("y")&&ypos==-1)ypos=idx-pointPos-1;
			else if(line[2].equals("z")&&zpos==-1)zpos=idx-pointPos-1;
			else {
				throw new PropertyPropertiesError("xyz");
			}
		} else if(line.length==3&&!midHeader){
			extraPropertys++;
		} else if(line.length>3&&line[1].equals("list")&&!midHeader) {
			midHeader = true;
		} else if(midHeader)extraPropertys++; 
		else {
			throw new PropertyPropertiesError("header");
		} 
		return true;
	}

	private boolean checkHeader(String[] lines) throws UnsupportedFileFormat, PropertyPropertiesError, ElementPropertiesError {
		if(lines.length!=(vertex+face+9+comment.size()+extraPropertys+extraElements)) {
			throw new UnsupportedFileFormat("total"+vertex+face+9+comment.size()+extraPropertys+extraElements);
		}
		if(xpos==-1||ypos==-1||zpos==-1) {
			throw new PropertyPropertiesError();
		}
		if(vertex==-1||face==-1) {
			throw new ElementPropertiesError();
		}
		return true;
	}
	
	
	private boolean handleBody(String[] lines) throws UnsupportedFileFormat {
		if(!handlePoint(lines)) {
			throw new UnsupportedFileFormat("points");
		}
		if(!handleFace(lines)) {
			throw new UnsupportedFileFormat("faces");
		}
		return true;
	}
	
	private boolean handlePoint(String[] lines) {
		points = new HashSet<Point>();
		pointsTotaux = new ArrayList<Point>();
		for (int i = 0; i < vertex; i++) {
			if(!addPoint(lines[idx]))return false;
			idx++;
		}
		return true;
	}

	private boolean addPoint(String line) {
		String tab[] = line.split(" ");
		for (String string : tab) {
			try {
				Double.parseDouble(string);
			} catch(Exception e) {
				return false;
			}
		}
		double x = Double.parseDouble(tab[xpos]);
		double y = Double.parseDouble(tab[ypos]);
		double z = Double.parseDouble(tab[zpos]);
		return addPoint(new Point(x,y,z));
	}

	private boolean addPoint(Point point) {
		return points.add(point) && pointsTotaux.add(point);
	}
	
	
	private boolean handleFace(String[] lines) {
		faces= new ArrayList<Face>();
		for (int i = 0; i < face; i++) {
			if(!addFaces(lines[idx]))return false;
			idx++;
		}
		return true;
	}

	private boolean addFaces(String line) {
		int nbPointInFace;
		
		String tab[] = line.split(" ");
		for (String string : tab) {
			try{
				Integer.parseInt(string);
			}catch(Exception e) {
				return false;
			}
		}
		ArrayList<Point> pointss = new ArrayList<Point>();
		nbPointInFace = Integer.parseInt(tab[0]);
		if(nbPointInFace==2) {
			face--;
			return true;
		}
		for (int i = 1; i < nbPointInFace+1; i++) {
			pointss.add(pointsTotaux.get(Integer.parseInt(tab[i])));
		}
		return addFace(new Face(nbPointInFace, pointss));	 
	}

	private boolean addFace(Face face) {
		return faces.add(face);
	}

}
