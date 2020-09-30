 package modele;

public class Tested {
	
	private boolean enCours;
	
	public Tested() {
		enCours = false;
		System.out.println("The project is ready to begin !");
	}
	
	public void start() {
		enCours = true;
		display();
	}
	
	public void stop() {
		enCours = false;
		display();
	}
	
	public boolean isRunning(){
		display();
		return enCours;
	}
	
	public void display() {
		System.out.println("The project is " + (enCours?"Running !":"Waiting..."));
	}
}
