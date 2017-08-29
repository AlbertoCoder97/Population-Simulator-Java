package utils;

import classi.Morigerato;
import classi.Popolazione;
import classi.Prudente;
import classi.Spregiudicata;
import interfacce.Human;

import java.util.TimerTask;

import classi.Avventuriero;

public class PopulationUtils {
	
	public static void inizio(Popolazione popolazione) {
		for (int i = 0; i <= 500; i++) {
			Human uomo = new Morigerato(popolazione, 50, 50);
			popolazione.aggiungiPersona(uomo);
		}
		
		for (int i = 0; i <= 500; i++) {
			Human uomo = new Avventuriero(popolazione, 50 , 50);
			popolazione.aggiungiPersona(uomo);
		}
		
		for (int i = 0; i <= 500; i++) {
			Human uomo = new Prudente(popolazione, 50 , 50);
			popolazione.aggiungiPersona(uomo);
		}
		
		for (int i = 0; i <= 500; i++) {
			Human uomo = new Spregiudicata(popolazione, 50 , 50);
			popolazione.aggiungiPersona(uomo);
		
		}
		
		startTimer(popolazione);
	}
		
	public static void startTimer(Popolazione popolazione) {
		main.main.timerupdate.schedule(new TimerTask() {
			@Override
			public void run() {
				popolazione.update();
				System.out.println("Numero uomini " + popolazione.getListaUomini().size());
				System.out.println("Numero donne " + popolazione.getListaDonne().size());
				fine(popolazione);
			}
		}, 0, 10);
	}
	
	public static void fine(Popolazione popolazione) {
		if (popolazione.percPrudenti() == 5 && popolazione.percMorigerati() == 5) {
			main.main.timerupdate.cancel();
			System.out.println("\n Simulazione avvenuta con successo \n");
		}else {
			System.out.println("\n SIMULAZIONE NON ANCORA AVVENUTA CON SUCCESSO!!! \n");
		}
	}
	

}
