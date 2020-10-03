package modele.parser;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import modele.Face;
import modele.Ply;
import modele.Point;

public class PlyParser {
	
	private static String url = "ressources/plys/";
	boolean headCorrect;
	
	
	private int xyz;
	private int idx;
	private int extraPropertys;
	
	private int vertex;
	private int face;
	
	private ArrayList<String> comment;
	private List<Point> points;
	private List<Face> faces;
	
	public static Ply loadPly(String nom) {
		PlyParser pp = new PlyParser();
		Ply ply = new Ply();
		pp.loadPly(ply, nom);
		return ply;
	}
	
	public void loadPly(Ply res,String filename) {
		loadPly(res,new File(url+filename+".ply"));
	}
	
	public void loadPly(Ply res,File fichier) {
		xyz = 0;
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
	
	private boolean handleHeader(String[] lines) {
		boolean endHeader = false;
		comment = new ArrayList<String>();
		extraPropertys = 0;
		
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

	private boolean checkType(String line) {
		if(line.equals("ply"))return true;
		else {
			System.out.println("Le fichier lu ne correspond pas à un fichier de polygones (.ply).");
			return false;
		}
	}
	
	private boolean checkFormat(String line) {
		if(line.equals("format ascii 1.0"))return true;
		System.out.println("Le format de ce fichier n'est pas supporté.");
		return false;
	}
	
	private boolean handleElement(String[] line) {
		if(line.length==3&&line[1].equals("vertex")&&Integer.parseInt(line[2])>2) {
			vertex = handleVertex(line[2]);
		} else if(line.length==3&&line[1].equals("face")&&Integer.parseInt(line[2])>0) {
			face = handleFace(line[2]);
		} else {
			System.out.println("Les propriétés \"element\" ne sont pas conformes.");
			return false;
		}
		return true;
	}

	private int handleVertex(String vert) {
		if(vert.matches("[0-9]+"))return Integer.parseInt(vert);
		else return -1;
	}
	
	private int handleFace(String face) {
		if(face.matches("[0-9]+"))return Integer.parseInt(face);
		else return -1;
	}

	private boolean handleProperty(String[] line) {
		if(line.length==3&&(line[1].equals("float")||line[1].equals("float32"))) {
			if(line[2].equals("x")&&xyz!=1)xyz+=1;
			else if(line[2].equals("y")&&xyz!=2)xyz+=2;
			else if(line[2].equals("z")&&xyz!=4)xyz+=4;
			else {
				System.out.println("Les propriétés \"property\" ne sont pas conformes.");
				return false;
			}
		} else if((line.length>3&&line[1].equals("list"))||line.length==3) {
			extraPropertys++;
		} else {
			System.out.println("Les propriétés \"property\" ne sont pas conformes.");
			return false;
		} 
		return true;
	}

	private boolean checkHeader(String[] lines) {
		if(lines.length!=(vertex+face+8+comment.size()+extraPropertys)) {
			System.out.println("Le format de ce fichier n'est pas supporté.");
			return false;
		}
		if(xyz!=7) {
			System.out.println("Les propriétés \"property\" ne sont pas conformes.");
			return false;
		}
		if(vertex==-1||face==-1) {
			System.out.println("Les propriétés \"element\" ne sont pas conformes.");
			return false;
		}
		return true;
	}
	
	
	private boolean handleBody(String[] lines) {
		if(!handlePoint(lines)) {
			System.out.println("Le format de ce fichier n'est pas supporté.");
			return false;
		}
		if(!handleFace(lines)) {
			System.out.println("Le format de ce fichier n'est pas supporté.");
			return false;
		}
		return true;
	}
	
	private boolean handlePoint(String[] lines) {
		points = new ArrayList<Point>();
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
		double x = Double.parseDouble(tab[0]);
		double y = Double.parseDouble(tab[1]);
		double z = Double.parseDouble(tab[2]);
		return addPoint(new Point(x,y,z));
	}

	private boolean addPoint(Point point) {
		return points.add(point);
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
		for (int i = 1; i < nbPointInFace+1; i++) {
			pointss.add(points.get(Integer.parseInt(tab[i])));
		}
		return addFace(new Face(nbPointInFace, pointss));	 
	}

	private boolean addFace(Face face) {
		return faces.add(face);
	}

}
