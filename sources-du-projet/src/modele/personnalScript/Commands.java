package modele.personnalScript;

import modele.modelisation.Figure;

public class Commands {
	private Move move;
	private double time;
	private long speed;
	private double movementValue;
	private boolean isRunning;
	
	private static final double DEFAULTVALUE = 5;
	
	public Commands(Move move, double movementValue, double speed, double time) {
		this.move = move;
		this.time = time;
		this.movementValue = movementValue;
		this.isRunning = false;
	}
	
	public Commands(Move move, double speed, double time) {
		this(move, DEFAULTVALUE, speed, time);
	}
	
	public void executeCommand(Figure fig) {
		isRunning = true;
		double endTime = System.currentTimeMillis() + time;
		while (System.currentTimeMillis() < endTime) {
			move.moveFigure(fig, this.movementValue);
			try {
				Thread.sleep(speed);
			} catch (InterruptedException e) {
				break;
			}
		}
		isRunning = false;
	}
	
	public boolean isRunning() {
		return isRunning;
	}
	
	public String toString() {
		return "Movement : " + this.move.toString() + " During " + time + " seconds"; 
	}
}
