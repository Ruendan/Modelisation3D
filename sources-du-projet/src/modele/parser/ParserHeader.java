package modele.parser;

import java.util.ArrayList;

import modele.parser.exception.ElementPropertiesError;
import modele.parser.exception.NotPlyFileException;
import modele.parser.exception.PlyParserException;
import modele.parser.exception.PropertyPropertiesError;
import modele.parser.exception.UnsupportedFileFormat;

public class ParserHeader {
	
	private int pointPos;
	private int xpos;
	private int ypos;
	private int zpos;
	
	private boolean midHeader;
	
	private int extraElements;
	private int extraPropertys;
	
	private int idx;
	
	private int vertex;
	private int face;
	
	private ArrayList<String> comment;
	
	private String[] lines;
	
	public ParserHeader(int vertex, int face, ArrayList<String> comment, String[] lines) {
		pointPos = 0;
		idx = 0;
		vertex = -1;
		face = -1;
		
		this.vertex = vertex;
		this.face = face;
		this.comment = comment;
		this.lines = lines;
	}

	public boolean handleHeader() throws PlyParserException {
		return handleHeader(lines);
	}
	
	boolean handleHeader(String[] lines) throws PlyParserException {
		boolean endHeader = false;
		comment = new ArrayList<>();
		extraPropertys = 0;
		extraElements = 0;
		xpos = -1;
		ypos = -1;
		zpos = -1;
		
		if(!checkType(lines[0])) return false;
		if(!checkFormat(lines[1])) return false;
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
				if(!handleElement(line)) return false;
				break;
			case "property":
				if(!handleProperty(line)) return false;
				break;
			default:
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
		if(line.length==3 && line[1].equals("vertex") && Integer.parseInt(line[2])>2) {
			vertex = handleVertex(line[2]);
		} else if(line.length==3 && line[1].equals("face") && Integer.parseInt(line[2])>0) {
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
			if(line[2].equals("x")&&xpos==-1) {
				xpos=idx-pointPos-1;
			}
			else if(line[2].equals("y")&&ypos==-1) {
				ypos=idx-pointPos-1;
			}
			else if(line[2].equals("z")&&zpos==-1) {
				zpos=idx-pointPos-1;
			}
			else {
				throw new PropertyPropertiesError("xyz");
			}
		} else if(line.length==3&&!midHeader) {
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

	public int getVertex() {
		return vertex;
	}

	public ArrayList<String> getComment() {
		return comment;
	}

	public int getFace() {
		return face;
	}

	public int getIdx() {
		return idx;
	}

	public int getXpos() {
		return xpos;
	}
	
	public int getYpos() {
		return ypos;
	}
	
	public int getZpos() {
		return zpos;
	}
	
}
