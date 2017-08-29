package main;


import java.util.Timer;


import classi.Popolazione;
import utils.PopulationUtils;

public class main {
	
	//Timer che permette l' aggiornamento della popolazione
	public static Timer timerupdate = new Timer();
	
	public static void main(String[] args) {
		
		//Inizializza la popolazione
		Popolazione popolazione = new Popolazione();
		PopulationUtils.inizio(popolazione);
	}
}
