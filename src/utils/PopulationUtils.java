package utils;

import classi.Morigerato;
import classi.Popolazione;
import classi.Prudente;
import classi.Spregiudicata;
import interfacce.Donna;
import interfacce.Human;
import interfacce.Uomo;
import main.main.Sesso;

import classi.Avventuriero;
import classi.Evoluzione;

public class PopulationUtils {
	
	public static int counter = 0;
	
	public static void setupPopolazione(Popolazione popolazione) {
		Evoluzione evoluzione = popolazione.getEvoluzione();
		for (int i = 0; i <= main.main.GRANDEZZA_POPOLAZIONE_INIZIALE; i++) {
			aggiungiPersona(popolazione, new Morigerato(evoluzione, popolazione,50,50));
			aggiungiPersona(popolazione, new Avventuriero(evoluzione, popolazione,50,50));
			aggiungiPersona(popolazione, new Prudente(evoluzione, popolazione,50,50));
			aggiungiPersona(popolazione, new Spregiudicata(evoluzione, popolazione,50,50));
		}
	}
	
	//Questo metodo aggiunge un uomo o una donna dalla rispettiva lista
		public static void aggiungiPersona(Popolazione popolazione, Human umano) {
			if (umano != null) {
				if (umano.getSesso() == Sesso.Uomo) {
					popolazione.getListaUomini().add((Uomo) umano);
				}else {
					popolazione.getListaDonne().add((Donna) umano);
				}
			}
		}
		
		
	//Questo metodo rimuove un uomo o una donna dalla rispettiva lista
	public static void rimuoviPersona(Popolazione popolazione, Human umano) {
		if (umano != null) {
			if (umano.getSesso() == Sesso.Uomo) {
				popolazione.getListaUomini().remove(umano);
			}else {
				popolazione.getListaDonne().remove(umano);
			}
		}
	}
	
	//Questo metodo serve per avviare la prima popolazione! SOLO la prima
	public static void avviaPopolazione(Popolazione popolazione) {
		setupPopolazione(popolazione);
		popolazione.startTimer();
	}
	
	//Questo metodo termina l' esecuzione di una generazione e avvia la successiva
	public static void finePopolazione(Popolazione popolazione) {
		if (popolazione.getListaDonne().size() == 0 || popolazione.getListaUomini().size() == 0) {
			if (counter < main.main.GENERAZIONI_MASSIME) {
				counter++;
				System.out.println("\n Generazione finita, inizia la prossima \n");
				Evoluzione evoluzione = popolazione.getEvoluzione();
				Popolazione successiva = EvolutionUtils.ottieniGenerazioneSuccessiva(evoluzione, popolazione);
				evoluzione.getListaPopolazioni().remove(popolazione); //Rimuove dalla lista delle popolazioni la popolazione per evitare consumi di memoria
				popolazione.stopTimer(); //Interrompe il timer della popolazione in corso 
				successiva.startTimer(); //Avvia il timer della popolazione successiva
				uccidiPopolazione(popolazione);
			}else {
				Evoluzione evoluzione = popolazione.getEvoluzione();
				EvolutionUtils.fineEvoluzione(evoluzione);
				System.out.println("Evoluzione fallita");
			}
		}else {
			System.out.println("\n Generazione ancora da completare \n");
		}
	}
	
	//Questo metodo rimuove dalla memoria una Popolazione
	public static void uccidiPopolazione(Popolazione popolazione) {
		popolazione = null;
	}
	

}
