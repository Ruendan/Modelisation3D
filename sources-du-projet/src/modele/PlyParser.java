package modele;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PlyParser {
	
	private static String url = "ressources/plys/";
	boolean headCorrect;
	
	private int nbPointInFace;
	
	private List<Point> points;
	private List<Face> faces;
	
	private Scanner sc;
	
	public static Ply loadPly(String nom) {
		PlyParser pp = new PlyParser();
		Ply ply = new Ply();
		pp.loadPly(ply, nom);
		return ply;
	}
	
	public void loadPly(Ply res,String filename) {
		loadPly(res,new File(url+filename));
	}
	
	public void loadPly(Ply res,File fichier) {
		headCorrect = true;
		boolean header = true;
		String line = "";
		try(Scanner sc = new Scanner(fichier)){
			
			if(checkType(sc)) {
				line = nextOne(sc);
				if(line==null)headCorrect = false;
				else if(line.contains("format")) {
					if(checkFormat(line)) {
						headCorrect = true;
						//res.setFormat("ascii 1.0");
					}
					headCorrect = false;
				}
				
				if(headCorrect) {
					line = nextOne(sc);
					if(line==null)headCorrect = false;
					else if(line.contains("element vertex")) {
						int vert = checkVertex(line);
						if(vert>0)res.setVertex(vert);
						else headCorrect = false;
					}
				}
				
				if(headCorrect) {
					line = nextOne(sc);
					if(line==null||!line.equals("property float32 x"))headCorrect = false;
				}
				
				if(headCorrect) {
					line = nextOne(sc);
					if(line==null||!line.equals("property float32 y"))headCorrect = false;
				}
				
				if(headCorrect) {
					line = nextOne(sc);
					if(line==null||!line.equals("property float32 z"))headCorrect = false;
				}
				
				if(headCorrect) {
					line = nextOne(sc);
					if(line==null)headCorrect = false;
					else if(line.contains("element face")) {
						int face = checkFace(line);
						if(face>0)res.setFace(face);
						else headCorrect = false;
					}
				}
				
				while(header&&headCorrect) {
					line = nextOne(sc);
					if(line==null||!line.equals("property list uint8 int32 vertex_indices"))headCorrect = false;
				}
			}
			if(!header&&headCorrect) {
				if(fillPoint(sc,res)) {
					res.setPoints(this.points);
					if(fillFace(sc,res))res.setFaces(this.faces);
				}
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
	}
	
	private boolean fillFace(Scanner sc2, Ply ply) {
		faces= new ArrayList<Face>();
		String line;
		for (int i = 0; i < ply.getFace(); i++) {
			if(sc.hasNextLine()) {
				line = sc.nextLine();
				if(!addFaces(line))return false;
			} else return false;
		}
		return true;
	}

	private boolean addFaces(String line) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < nbPointInFace; i++) {
			sb.append("([0-9]+)");
			if(i<nbPointInFace-1)sb.append("\\s");
		}
		if(!line.matches(sb.toString()))return false;
		int deb = line.indexOf(" ")+1;
		int space = 0;
		ArrayList<Integer> pointss = new ArrayList<Integer>();
		for (int i = 0; i < nbPointInFace; i++) {
			if(i<nbPointInFace-1) {
				space = line.indexOf(" ", deb);
				pointss.add(Integer.parseInt(line.substring(deb, space)));
			} else {
				pointss.add(Integer.parseInt(line.substring(deb)));
			}
		}
		return addFace(new Face(nbPointInFace, pointss));	 
	}

	private boolean addFace(Face face) {
		return faces.add(face);
	}

	private boolean fillPoint(Scanner sc,Ply ply) {
		points= new ArrayList<Point>();
		String line;
		for (int i = 0; i < ply.getVertex(); i++) {
			if(sc.hasNextLine()) {
				line = sc.nextLine();
				if(!addPoint(line))return false;
			} else return false;
		}
		return true;
	}

	private boolean addPoint(String line) {
		if(line.matches("([0-9]+)(.([0-9]+)?)\\s([0-9]+)(.([0-9]+)?)\\s([0-9]+)(.([0-9]+)?)")) {
			int space = line.indexOf(" ");
			double x = Double.parseDouble(line.substring(0, space));
			int deb = space+1;
			space = line.indexOf(" ", deb);
			double y = Double.parseDouble(line.substring(deb,space));
			deb = space +1;
			double z = Double.parseDouble(line.substring(deb));
			return addPoint(new Point(x, y, z));
		} return false;
	}

	private boolean addPoint(Point point) {
		return points.add(point);
	}

	private int checkFace(String line) {
		String face = line.substring(13);
		if(face.matches("[0-9]+"))return Integer.parseInt(face);
		else return -1;
	}

	private int checkVertex(String line) {
		String vert = line.substring(15);
		if(vert.matches("[0-9]+"))return Integer.parseInt(vert);
		else return -1;
	}

	private boolean checkFormat(String line) {
		return line.substring(7,12).equals("ascii 1.0");
	}

	private String nextOne(Scanner sc) {
		String line = "";
		if(headCorrect&&sc.hasNextLine()) {
			line = sc.nextLine();
			if(line.contains("comment"))return nextOne(sc);
			else return line;
		} else return null;
	}

	private boolean checkType(Scanner sc) {
		String line;
		if(headCorrect&&sc.hasNextLine()) {
			line = sc.nextLine();
			if(line.equals("ply"))return true;
			else return false;
		} else return false;
	}
}
