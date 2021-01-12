package utils;

/**
 * Extendable class to convert a class into an Observer
 * <p>This class is used to convert any other class into an Observer from the Observer Pattern</p>
 * @author Groupe G1
 */
public interface Observer {
	void update(Subject subj);
	void update(Subject subj, Object data);
}

