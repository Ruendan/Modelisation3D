package utils;

public interface Observer {
	void update(Subject subj);
	void update(Subject subj, Object data);
}
