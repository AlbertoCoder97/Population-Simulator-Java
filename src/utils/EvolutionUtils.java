package utils;

import java.util.ArrayList;

import classi.Evoluzione;
import classi.Popolazione;

public class EvolutionUtils {
	
	//Questo metodo avvia la simulazione dell' evoluzione
	public static void setup(Evoluzione evoluzione) {
		evoluzione.creaGenerazioneSuccessiva();
		Popolazione popolazione = evoluzione.getListaPopolazioni().get(0);
		PopulationUtils.avviaPopolazione(popolazione);
	}
	
	//Questo metodo termina indiscriminatamente tutte le popolazioni
	public static void fineEvoluzione(Evoluzione evoluzione) {
		for (Popolazione popolazione : evoluzione.getListaPopolazioni()) {
			popolazione.stopTimer();
		}
	}
	
	//Questo metoo restituisce la popolazione successiva nell' evoluzione
	public static Popolazione ottieniGenerazioneSuccessiva(Evoluzione evoluzione, Popolazione popolazione) {
		ArrayList<Popolazione> listapopolazione = evoluzione.getListaPopolazioni();
		if (listapopolazione.contains(popolazione)) {
			return listapopolazione.get(listapopolazione.indexOf(popolazione) + 1);
		}else {
			return null;
		}
	}
	
	//Questo metodo aggiunge le percentuali dei Morigerati e delle prudenti all' interno della lista dell' evoluzione
	public static void aggiungiPercentuali(Evoluzione evoluzione, Popolazione popolazione) {
		evoluzione.getListaPercMorigerati().add(popolazione.percMorigerati());
		evoluzione.getListaPercPrudenti().add(popolazione.percPrudenti());
	}
	
	//Questo metodo restituisce true se si è raggiunta la stabilità evolutiva
	public static boolean stabilitaEvolutiva(Evoluzione evoluzione) {
		ArrayList<Integer> listaPercMorigerati = evoluzione.getListaPercMorigerati();
		ArrayList<Integer> listaPercPrudenti = evoluzione.getListaPercPrudenti();
		if (listaPercMorigerati.size() > main.main.GENERAZIONI_CHECK+1 && listaPercPrudenti.size() > main.main.GENERAZIONI_CHECK + 1) {
			int counterMorigerati = 0;
			int counterPrudenti = 0;
			
			int ultimoMorigerati = listaPercMorigerati.get(listaPercMorigerati.size() - 1);
			int ultimoPrudenti = listaPercPrudenti.get(listaPercPrudenti.size() - 1);
			
			for (int indice = 1; indice <= main.main.GENERAZIONI_CHECK; indice++) {
				if (Math.abs(ultimoMorigerati - listaPercMorigerati.get(listaPercMorigerati.size() - 1 - indice)) < main.main.TOLLERANZA_PERC) {
					counterMorigerati += 1;
				}
			}
			
			for (int indice = 1; indice <= main.main.GENERAZIONI_CHECK; indice++) {
				if (Math.abs(ultimoPrudenti - listaPercPrudenti.get(listaPercPrudenti.size() - 1 - indice)) < main.main.TOLLERANZA_PERC) {
					counterPrudenti += 1;
				}
			}
			
			if (counterMorigerati >= 9 && counterPrudenti >= 9) {
				System.out.println("\n L' evoluzione è avvenuta con successo!");
				return true;
			}else {
				return false;
			}
		}else {
			return false;
		}
	}
}
