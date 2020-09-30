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
					} else headCorrect = false;
				}
				if(headCorrect) {
					line = nextOne(sc);
					if(line==null)headCorrect = false;
					else if(line.contains("element vertex")) {
						int vert = checkVertex(line);
						if(vert>0) {
							res.setVertex(vert);
						}
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
						if(face>0) {
							res.setFace(face);
						}
						else headCorrect = false;
					}
				}
				
				while(header&&headCorrect) {
					line = nextOne(sc);
					if(line==null)headCorrect = false;
					if(line.equals("end_header"))header = false;
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
	
	private boolean fillFace(Scanner sc, Ply ply) {
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
		String tab[] = line.split(" ");
		for (String string : tab) {
			try{
				Integer.parseInt(string);
			}catch(Exception e) {
				return false;
			}
		}
		ArrayList<Integer> pointss = new ArrayList<Integer>();
		nbPointInFace = Integer.parseInt(tab[0]);
		for (int i = 1; i < nbPointInFace+1; i++) {
			pointss.add(Integer.parseInt(tab[i]));
		}
		return addFace(new Face(nbPointInFace, pointss));	 
	}

	private boolean addFace(Face face) {
		return faces.add(face);
	}

	private boolean fillPoint(Scanner sc,Ply ply) {
		
		points = new ArrayList<Point>();
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
		String tab[] = line.split(" ");
		for (String string : tab) {
			try{
				Double.parseDouble(string);
			}catch(Exception e) {
				return false;
			}
		}
		return addPoint(new Point(Double.parseDouble(tab[0]), Double.parseDouble(tab[1]), Double.parseDouble(tab[2])));
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
		return line.substring(7,16).equals("ascii 1.0");
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
