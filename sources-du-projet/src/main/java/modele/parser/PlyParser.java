package modele.parser;

import java.awt.Color;
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

public final class PlyParser {
	
	private int idx;
	private ParserHeader header;
	private Ply ply;
	private String[] lines;
	private int ligneentrop;
	
	private List<Color> couleursPoints;
	private Set<Point> points;
	private List<Point> pointsTotaux;
	private List<Face> faces;
	
	private static PlyParser instance;
	
	private PlyParser() {}
	
	public static PlyParser getInstance() {
		if(instance==null)instance = new PlyParser();
		return instance;
	}
	
	public Ply loadPly(String nom) throws PlyParserException, FileNotFoundException {
		final String url = "/resources/plys/";
		return loadPly(new File("."+url+nom+".ply"));
	}
	
	public Ply loadPly(File fichier) throws PlyParserException, FileNotFoundException {
		ply = new Ply();
		
		ligneentrop = 0;
		ply.setName(fichier.getName());
		idx = 0;
		
		lines = getLines(fichier);
		
		if(lines.length>12 && handleHeader() && handleBody()) {
			ply.setVertex(header.getVertex());
			ply.setNbFace(header.getFace());
			ply.setPoints(points);
			ply.setFaces(faces);
			ply.setComment(header.getComment());
			if(header.isColoredByPoint()||header.isColoredByFace())ply.setColored(true);
		}
		return ply;
	}
	
	public Ply loadHeader(File file) throws PlyParserException, FileNotFoundException {
		final Ply res = new Ply();
		res.setName(file.getName());
		this.loadHeader(res,file);
		return res;
	}
	
	public void loadHeader(Ply res,File fichier) throws PlyParserException, FileNotFoundException {
		ply = res;
		idx = 0;
		lines = getLines(fichier);
		
		if(lines.length>12 && handleHeader()) {
			ply.setVertex(header.getVertex());
			ply.setNbFace(header.getFace()-ligneentrop);
			ply.setComment(header.getComment());
		}
	}

	private String[] getLines(File fichier) throws FileNotFoundException {
		final StringBuilder content = new StringBuilder();
		final Scanner sc = new Scanner(fichier);
		while(sc.hasNextLine())content.append(sc.nextLine()+System.lineSeparator());
		sc.close();
		return content.toString().split(System.lineSeparator());
	}
	
	private boolean handleHeader() throws PlyParserException {
		final List<String> comment = new ArrayList<>();
		header = new ParserHeader(comment,lines);
		
		final int res = header.handleHeader();
		idx = res;
		return res>0;
	}

	private boolean handleBody() throws UnsupportedFileFormat {
		if(!handlePoint()) {
			throw new UnsupportedFileFormat("points");
		}
		if(!handleFace()) {
			throw new UnsupportedFileFormat("faces");
		}
		return true;
	}
	
	private boolean handlePoint() {
		points = new HashSet<>();
		pointsTotaux = new ArrayList<>();
		couleursPoints = new ArrayList<>();
		for (int i = 0; i < header.getVertex(); i++) {
			if(!addPoint(lines[idx])) {
				return false;
			}
			idx++;
		}
		return true;
	}

	private boolean addPoint(String line) {
		final String tab[] = line.split(" ");
		for (final String string : tab) {
			try {
				Double.parseDouble(string);
			} catch(NumberFormatException e) {
				return false;
			}
		}
		
		final double x = Double.parseDouble(tab[header.getXpos()]);
		final double y = Double.parseDouble(tab[header.getYpos()]);
		final double z = Double.parseDouble(tab[header.getZpos()]);
		if(header.isColoredByPoint()&&!addPointColor(tab))ply.setColored(false);
		return addPoint(new Point(x,y,z));
	}

	private boolean addPointColor(String[] tab) {
		return couleursPoints.add(new Color(Integer.parseInt(tab[header.getRpos()]),
									Integer.parseInt(tab[header.getGpos()]),
									Integer.parseInt(tab[header.getBpos()])));
	}

	private boolean addPoint(Point point) {
		return points.add(point) && pointsTotaux.add(point);
	}
	
	private boolean handleFace() {
		faces= new ArrayList<>();
		for (int i = 0; i < header.getFace(); i++) {
			if(!addFaces(lines[idx]))return false;
			idx++;
		}
		return true;
	}

	private boolean addFaces(String line) {
		
		final String tab[] = line.split(" ");
		if(!testPoint(tab))return false;
		final ArrayList<Point> pointss = new ArrayList<>();
		final int nbPointInFace = Integer.parseInt(tab[0]);
		final int nbMinPoint = 3;
		if(nbPointInFace<nbMinPoint) {
			ligneentrop++;
			return true;
		}
		if(header.isColoredByPoint())return addFaceWithPointColor(tab,nbPointInFace,pointss);
		for (int i = 1; i < nbPointInFace+1; i++) {
			pointss.add(pointsTotaux.get(Integer.parseInt(tab[i])));
		}
		if(header.isColoredByFace())return addFaceWithColor(tab,new Face(nbPointInFace, pointss));
		return faces.add(new Face(nbPointInFace, pointss));	 
	}

	private boolean addFaceWithColor(String[] tab,Face face) {
		final int x = tab.length-(4-header.getRpos()), y = tab.length-(4-header.getGpos()), z = tab.length-(4-header.getBpos());
		face.setCouleur(new Color(Integer.parseInt(tab[x]),Integer.parseInt(tab[y]),Integer.parseInt(tab[z])));
		return faces.add(face);
	}

	private boolean addFaceWithPointColor(String[] tab, int nbPointInFace, List<Point> pointss) {
		int red=0,green=0,blue=0;
		int idx;
		Color temp;
		for (int i = 1; i < nbPointInFace+1; i++) {
			idx = Integer.parseInt(tab[i]);
			pointss.add(pointsTotaux.get(idx));
			temp = couleursPoints.get(idx);
			red+=temp.getRed();
			
			green+=temp.getGreen();
			blue+=temp.getBlue();
		}
		red/=nbPointInFace;
		green/=nbPointInFace;
		blue/=nbPointInFace;
		final Face face = new Face(nbPointInFace, pointss);
		face.setCouleur(new Color(red,green,blue));
		
		return faces.add(face);
	}

	private boolean testPoint(String[] tab) {
		for (final String string : tab) {
			try {
				Integer.parseInt(string);
			} catch(NumberFormatException e) {
				return false;
			}
		}
		return true;
	}

}
