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
	
	private int pred;
	private int pgreen;
	private int pblue;
	private boolean isColored;
	
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
		initGlobal();
		
		if(!checkType(lines[0])) return false;
		if(!checkFormat(lines[1])) return false;
		idx=1;
		while(!endHeader) {
			idx++;
			String[] line = lines[idx].split(" ");
			switch (line[0]) {
			case "end_header":
				endHeader = true;
				idx++;
				break;
			case "comment":
				comment.add(lines[idx].substring(8));
				break;
			case "element":
				if(!handleElement(line)) {
					return false;
				}
				break;
			case "property":
				return false;
			default:
				break;
			}
			
		}
		return checkHeader(lines);
	}

	private void initGlobal() {
		comment = new ArrayList<>();
		extraPropertys = 0;
		extraElements = 0;
		xpos = -1;
		ypos = -1;
		zpos = -1;
		
		isColored = false;
		pred = -1;
		pgreen = -1;
		pblue = -1;
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
	
	private boolean handleElement(String[] line) throws ElementPropertiesError, PropertyPropertiesError {
		if(line.length==3 && line[1].equals("vertex") && Integer.parseInt(line[2])>2) {
			return handleVertex(line[2]);
		} else if(line.length==3 && line[1].equals("face") && Integer.parseInt(line[2])>0) {
			return handleFace(line[2]);
		} else if(line.length==3) {
			extraElements += Integer.parseInt(line[2]);
			extraPropertys++;
			return handleExtraElement();
		} else {
			throw new ElementPropertiesError();
		}
	}

	private boolean handleVertex(String fline) throws PropertyPropertiesError {
		vertex = getNbVertex(fline);
		boolean endVertex = false;
		while(!endVertex) {
			idx++;
			String[] line = lines[idx].split(" ");
			switch (line[0]) {
				case "end_header":
					return false;
				case "element":
					endVertex = true;
					idx--;
					break;
				case "property":
					handleVertexProperty(line);
					break;
				default:
					break;
			}
		}
		return true;
	}
	
	private int getNbVertex(String vert) {
		if(vert.matches("[0-9]+")) {
			pointPos = idx;
			return Integer.parseInt(vert);
		}
		return -1;
	}
	
	private boolean handleVertexProperty(String[] line) throws PropertyPropertiesError {
		if(line.length==3&&(line[1].equals("float")||line[1].equals("float32"))) {
			return handleFloat(line);
		} else if(line.length==3&&(line[1].equals("uchar"))) {	
			return handleColor(line);
		} else {
			throw new PropertyPropertiesError("header:vertex");
		}
	}
	
	private boolean handleFloat(String[] line) throws PropertyPropertiesError {
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
		return true;
	}

	private boolean handleColor(String[] line) throws PropertyPropertiesError {
		if(line[2].equals("red")&&pred==-1) {
			pred=idx-pointPos-1;
		} else if(line[2].equals("green")&&pgreen==-1) {
			pgreen=idx-pointPos-1;
		} else if(line[2].equals("blue")&&pblue==-1) {
			pblue=idx-pointPos-1;
		} else {
			throw new PropertyPropertiesError("couleur:"+line[2]);
		}
		extraPropertys++;
		return true;
	}

	private boolean handleFace(String fline) throws PropertyPropertiesError {
		face = getNbFace(fline);
		boolean endFace = false;
		while(!endFace) {
			idx++;
			String[] line = lines[idx].split(" ");
			switch (line[0]) {
				case "end_header":
					endFace = true;
				case "element":
					endFace = true;
					idx--;
					break;
				case "property":
					handleFaceProperty(line);
					break;
				default:
					break;
			}
		}
		return true;
	}

	private int getNbFace(String face) {
		if(face.matches("[0-9]+"))return Integer.parseInt(face);
		else return -1;
	}

	private boolean handleFaceProperty(String[] line) throws PropertyPropertiesError {
		if(!(line.length>3&&line[1].equals("list"))) {
			throw new PropertyPropertiesError("header:face");
		}
		return true;
	}

	private boolean handleExtraElement() {
		boolean endExtra = false;
		while(!endExtra) {
			idx++;
			String[] line = lines[idx].split(" ");
			switch (line[0]) {
				case "end_header":
					endExtra = true;;
				case "element":
					endExtra = true;
					idx--;
					break;
				case "property":
					extraPropertys++;
					break;
				default:
					break;
			}
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
		if(pred+pgreen+pblue!=-3)isColored = true;
		if((pred==-1||pgreen==-1||pblue==-1)&&isColored) {
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

	public int getRpos() {
		return pred;
	}
	
	public int getGpos() {
		return pgreen;
	}
	
	public int getBpos() {
		return pblue;
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
	
	public boolean isColored() {
		return isColored;
	}
	
}
