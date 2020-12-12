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
import modele.parser.exception.PlyParserException;
import modele.parser.exception.UnsupportedFileFormat;

public class PlyParser {
	
	private int xpos;
	private int ypos;
	private int zpos;
	
	private int idx;
	
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
	
	public static Ply loadPly(File file) throws PlyParserException {
		PlyParser pp = new PlyParser();
		Ply res = new Ply();
		res.setName(file.getName());
		pp.loadPly(res,file);
		return res;
	}
	
	public static Ply loadHeader(File file) throws PlyParserException {
		PlyParser pp = new PlyParser();
		Ply res = new Ply();
		res.setName(file.getName());
		pp.loadHeader(res,file);
		return res;
	}
	
	public void loadPly(Ply res,String filename) throws PlyParserException {
		String url = "ressources/plys/";
		loadPly(res,new File(url+filename+".ply"));
	}
	
	public void loadPly(Ply res,File fichier) throws PlyParserException {
		idx = 0;
		vertex = -1;
		face = -1;
		
		String[] lines = getLines(fichier);
		
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
	
	public static Ply loadHeader(String nom) throws PlyParserException {
		PlyParser pp = new PlyParser();
		Ply ply = new Ply();
		ply.setName(nom);
		pp.loadHeader(ply, nom);
		return ply;
	}
	
	public void loadHeader(Ply res,String filename) throws PlyParserException {
		String url = "ressources/plys/";
		loadHeader(res,new File(url+filename+".ply"));
	}
	
	public void loadHeader(Ply res,File fichier) throws PlyParserException {
		idx = 0;
		vertex = -1;
		face = -1;
		
		String[] lines = getLines(fichier);
		
		if(!(lines.length<12)) {
			if(handleHeader(lines)) {
				res.setVertex(vertex);
				res.setNbFace(face);
				res.setComment(comment);
			}
		}
	}

	private String[] getLines(File fichier) {
		try(Scanner sc = new Scanner(fichier)) {
			StringBuilder content = new StringBuilder();
			while(sc.hasNextLine())content.append(sc.nextLine()+System.lineSeparator());
			return content.toString().split(System.lineSeparator());
		} catch (FileNotFoundException e) {e.printStackTrace();}
		return null;
	}
	

	private boolean handleHeader(String[] lines) throws PlyParserException {
		comment = new ArrayList<>();
		ParserHeader ph = new ParserHeader(vertex,face,comment,lines);
		boolean res = ph.handleHeader();
		
		xpos = ph.getXpos();
		ypos = ph.getYpos();
		zpos = ph.getZpos();
		idx = ph.getIdx();
		vertex = ph.getVertex();
		face = ph.getFace();
		comment = ph.getComment();
		
		return res;
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
		points = new HashSet<>();
		pointsTotaux = new ArrayList<>();
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
			} catch(NumberFormatException e) {
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
		faces= new ArrayList<>();
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
			try {
				Integer.parseInt(string);
			} catch(NumberFormatException e) {
				return false;
			}
		}
		ArrayList<Point> pointss = new ArrayList<>();
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
