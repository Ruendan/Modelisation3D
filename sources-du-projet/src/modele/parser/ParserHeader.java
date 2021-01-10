package modele.parser;

import java.util.ArrayList;
import java.util.List;

import modele.parser.exception.ElementPropertiesError;
import modele.parser.exception.NotPlyFileException;
import modele.parser.exception.PlyParserException;
import modele.parser.exception.PropertyPropertiesError;
import modele.parser.exception.UnsupportedFileFormat;

public class ParserHeader {
	
	private int tempPos;
	
	private int xpos;
	private int ypos;
	private int zpos;
	
	private int pred;
	private int pgreen;
	private int pblue;
	private boolean isColoredByPoint;
	private boolean isColoredByFace;
	
	private int extraElements;
	private int extraPropertys;
	
	private int idx;
	
	
	private int nbVertex;
	private int face;
	
	private static final String END_HEADER = "end_header", ELEMENT = "element", PROPERTY = "property",LIST = "list",
			VERTEX = "vertex", FACE = "face", RED = "red", GREEN = "green", BLUE = "blue";
	private static final int PROPERTY_POS = 1, VALUE_POS = 2, BASICS_LEN = 3;
	
	private List<String> comment;
	
	private final String[] lines;
	
	public ParserHeader(List<String> comment, String[] lines) {
		tempPos = 0;
		idx = 0;
		
		this.nbVertex = -1;
		this.face = -1;
		this.comment = comment;
		this.lines = lines;
	}

	public int handleHeader() throws PlyParserException {
		return handleHeader(lines);
	}
	
	private int handleHeader(String[] lines) throws PlyParserException {
		boolean endHeader = false;
		initGlobal();
		
		if(!checkType(lines[0])) return -1;
		if(!checkFormat(lines[1])) return -1;
		idx=1;
		String[] line;
		while(!endHeader) {
			idx++;
			line = lines[idx].split(" ");
			switch (line[0]) {
			case END_HEADER:
				endHeader = true;
				idx++;
				break;
			case "comment":
				comment.add(lines[idx].substring(8));
				break;
			case "element":
				if(!handleElement(line)) {
					return -1;
				}
				break;
			case "property":
				return -1;
			default:
				break;
			}
		}
		if(checkHeader(lines))return idx;
		return -1;
	}

	private void initGlobal() {
		comment = new ArrayList<>();
		extraPropertys = 0;
		extraElements = 0;
		xpos = -1;
		ypos = -1;
		zpos = -1;
		
		isColoredByPoint = false;
		isColoredByFace = false;
		pred = -1;
		pgreen = -1;
		pblue = -1;
	}

	private boolean checkType(String line) throws NotPlyFileException{
		if("ply".equals(line))return true;
		else {
			throw new NotPlyFileException();
		}
	}
	
	private boolean checkFormat(String line) throws UnsupportedFileFormat {
		if("format ascii 1.0".equals(line))return true;
		throw new UnsupportedFileFormat();
	}
	
	private boolean handleElement(String[] line) throws ElementPropertiesError, PropertyPropertiesError {
		if(line.length==BASICS_LEN && VERTEX.equals(line[PROPERTY_POS]) && Integer.parseInt(line[VALUE_POS])>VALUE_POS) {
			return handleVertex(line[VALUE_POS]);
		} else if(line.length==BASICS_LEN && FACE.equals(line[PROPERTY_POS]) && Integer.parseInt(line[VALUE_POS])>0) {
			return handleFace(line[VALUE_POS]);
		} else if(line.length==BASICS_LEN) {
			extraElements += Integer.parseInt(line[2]);
			extraPropertys++;
			return handleExtraElement();
		} else {
			throw new ElementPropertiesError();
		}
	}

	private boolean handleVertex(String fline) throws PropertyPropertiesError {
		nbVertex = getNbVertex(fline);
		boolean endVertex = false;
		String[] line;
		while(!endVertex) {
			idx++;
			line = lines[idx].split(" ");
			switch (line[0]) {
				case END_HEADER:
					return false;
				case ELEMENT:
					endVertex = true;
					idx--;
					break;
				case PROPERTY:
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
			tempPos = idx;
			return Integer.parseInt(vert);
		}
		return -1;
	}
	
	private boolean handleVertexProperty(String[] line) throws PropertyPropertiesError {
		if(line.length==3&&("float".equals(line[1])||"float32".equals(line[1]))) {
			return handleFloat(line);
		} else if(line.length==3&&("uchar".equals(line[1]))) {	
			return handlePointColor(line);
		} else {
			throw new PropertyPropertiesError("header:vertex");
		}
	}
	
	private boolean handleFloat(String[] line) throws PropertyPropertiesError {
		if(line[2].charAt(0)=='x'&&xpos==-1) {
			xpos=idx-tempPos-1;
		}
		else if(line[2].charAt(0)=='y'&&ypos==-1) {
			ypos=idx-tempPos-1;
		}
		else if(line[2].charAt(0)=='z'&&zpos==-1) {
			zpos=idx-tempPos-1;
		}
		else {
			throw new PropertyPropertiesError("xyz");
		}
		return true;
	}

	private boolean handlePointColor(String[] line) throws PropertyPropertiesError {
		if(RED.equals(line[VALUE_POS])&&pred==-1) {
			pred=idx-tempPos-1;
		} else if(GREEN.equals(line[VALUE_POS])&&pgreen==-1) {
			pgreen=idx-tempPos-1;
		} else if(BLUE.equals(line[VALUE_POS])&&pblue==-1) {
			pblue=idx-tempPos-1;
		} else {
			throw new PropertyPropertiesError("couleur:"+line[2]);
		}
		isColoredByPoint = true;
		extraPropertys++;
		return true;
	}

	private boolean handleFace(String fline) throws PropertyPropertiesError {
		face = getNbFace(fline);
		boolean endFace = false;
		String[] line;
		while(!endFace) {
			idx++;
			line = lines[idx].split(" ");
			switch (line[0]) {
				case END_HEADER:
					endFace = true;
					idx--;
					break;
				case ELEMENT:
					endFace = true;
					idx--;
					break;
				case PROPERTY:
					handleFaceProperty(line);
					break;
				default:
					break;
			}
		}
		return true;
	}

	private int getNbFace(String face) {
		if(face.matches("[0-9]+")) {
			tempPos = idx;
			return Integer.parseInt(face);
		}
		else return -1;
	}

	private boolean handleFaceProperty(String[] line) throws PropertyPropertiesError {
		if(line.length>BASICS_LEN&&LIST.equals(line[PROPERTY_POS])) {
			return true;
		} else if(line.length==3&&("uchar".equals(line[1]))){
			return handleFaceColor(line);
		}
		throw new PropertyPropertiesError("header:face");
	}

	private boolean handleFaceColor(String[] line) throws PropertyPropertiesError {
		if(RED.equals(line[VALUE_POS])&&pred==-1) {
			pred=idx-tempPos-1;
		} else if(GREEN.equals(line[VALUE_POS])&&pgreen==-1) {
			pgreen=idx-tempPos-1;
		} else if(BLUE.equals(line[VALUE_POS])&&pblue==-1) {
			pblue=idx-tempPos-1;
		} else {
			throw new PropertyPropertiesError("couleur face:"+line[2]);
		}
		isColoredByFace = true;
		extraPropertys++;
		return true;
	}

	private boolean handleExtraElement() {
		boolean endExtra = false;
		String[] line;
		while(!endExtra) {
			idx++;
			line = lines[idx].split(" ");
			switch (line[0]) {
				case END_HEADER:
					endExtra = true;
					idx--;
					break;
				case ELEMENT:
					endExtra = true;
					idx--;
					break;
				case PROPERTY:
					extraPropertys++;
					break;
				default:
					break;
			}
		}
		return true;
	}

	private boolean checkHeader(String[] lines) throws UnsupportedFileFormat, PropertyPropertiesError, ElementPropertiesError {
		if(lines.length!=(nbVertex+face+9+comment.size()+extraPropertys+extraElements)) {
			throw new UnsupportedFileFormat("total"+nbVertex+face+9+comment.size()+extraPropertys+extraElements);
		}
		if(xpos==-1||ypos==-1||zpos==-1) {
			throw new PropertyPropertiesError();
		}
		if(nbVertex==-1||face==-1) {
			throw new ElementPropertiesError();
		}
		if((pred==-1||pgreen==-1||pblue==-1)&&(isColoredByPoint^isColoredByFace)) {
			throw new ElementPropertiesError();
		}
		return true;
	}

	public int getVertex() {
		return nbVertex;
	}

	public List<String> getComment() {
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
	
	public boolean isColoredByPoint() {
		return isColoredByPoint;
	}

	public boolean isColoredByFace() {
		return isColoredByFace;
	}
	
}
