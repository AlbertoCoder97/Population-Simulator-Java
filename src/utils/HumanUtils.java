package utils;

import java.util.ArrayList;
import java.util.Random;

import classi.Avventuriero;
import classi.Evoluzione;
import classi.Morigerato;
import classi.Popolazione;
import classi.Prudente;
import classi.Spregiudicata;
import interfacce.Donna;
import interfacce.Human;
import interfacce.Uomo;
import main.main.Sesso;
import main.main.Tipo;

public class HumanUtils {
	
	private static Random random = new Random();
	
	//Questo metodo restituisce un numero di figli casuale da 0 a 4
	public static int randomFigli() {
		return random.nextInt(5);
	}
	
	//Questo metodo restituisce un intero utilizzato per la decisione del tipo del neonato;
	public static int randomGene() {
		return random.nextInt(101);
	}
	
	//Questo metodo restituisce un sesso randomico
	public static Sesso randomSesso() {
		if (random.nextInt(2) == 0) {
			return Sesso.Donna;
		}else{
			return Sesso.Uomo;
		}
	}
	
	//Questo metodo restituisce il numero di figli che la coppia avrà
		public static int numeroFigli(Human uomo, Human donna) {
			int figliuomo = uomo.getNumeroFigli();
			int figlidonna = donna.getNumeroFigli();
			if (uomo.getTipo() == Tipo.Avventuriero) {
				return 1;
			}else {
				return Math.max(figliuomo, figlidonna);
			}
		}
	
	
	//Uccide un umano nella data popolazione
	public static void Morte(Human umano) {
		Popolazione popolazione = umano.getPopolazione();
		PopulationUtils.rimuoviPersona(popolazione, umano);
		umano = null;
	}
	
	//Questo metodo restituisce una donna casuale dalla lista della popolazione data
	public static Donna getDonnaCasuale(Popolazione popolazione) {
		ArrayList<Donna> lista = popolazione.getListaDonne();
		return lista.get(random.nextInt(lista.size()));
	}
	
	//Questo metodo restituisce un uomo casuale dalla lista della popolazione data
	public static Uomo getUomoCasuale(Popolazione popolazione) {
		ArrayList<Uomo> lista = popolazione.getListaUomini();
		return lista.get(random.nextInt(lista.size()));
	}
	
	
	//Questo metodo fa vivere l' uomo, che corteggia una donna casuale e poi muore sia lui che la consorte.
	public static void vivi(Uomo uomo) {
		Popolazione generazioneSuccessiva = EvolutionUtils.ottieniGenerazioneSuccessiva(uomo.getEvoluzione(), uomo.getPopolazione());
		if (uomo.getTipo() == Tipo.Avventuriero) {
			while (((Avventuriero) uomo).getAvventure() > 0) {
				if (uomo.corteggia()) {
					Donna donna = uomo.getMoglie();
					riproduzione(generazioneSuccessiva, uomo, donna);
					Morte(donna);
				}
			}
			Morte(uomo);
		}else {
			while (uomo.getMoglie() == null) { //Questo ciclo viene eseguito finchè l' uomo non riesce a corteggiare una donna
				if (uomo.corteggia()) {
					Donna donna = uomo.getMoglie();
					int numerofigli = numeroFigli(uomo,donna);
					for (int i = 0; i < numerofigli; i++) {
						riproduzione(generazioneSuccessiva, uomo, donna);
						uomo.premioFigli(donna); //Da ai genitori il premio per ogni figlio avuto
						donna.premioFigli(uomo);
					}
					
				}
			}
			Morte(uomo.getMoglie()); //Muore la moglie dopo aver avuto figli
			Morte(uomo); //Muore anche l' uomo dopo aver avuto figli
		}
	}
	
	//Questo metodo aggiunge un bambino alla lista degli uomini o delle donne
	public static void riproduzione(Popolazione popolazione, Human uomo, Human donna) {
		Evoluzione evoluzione = uomo.getEvoluzione();
		int gene = randomGene(); //Viene estratto un intero casuale che decide il tipo del neonato
		if (randomSesso() == Sesso.Donna) {
			/*Se il numero estratto è minore del valore che indica la percentuale del gene dominante
			allora il neonato sarà dello stesso tipo del padre/madre in base al sesso.
			Altrimenti il neonato sarà di tipo opposto rispetto a quello del genitore.*/
			if (gene <= donna.getPercDominante()) { 
				if (donna.getTipo() == Tipo.Prudente) {
					PopulationUtils.aggiungiPersona(popolazione, new Prudente(evoluzione, popolazione, donna.getPercDominante(), donna.getPercRecessivo()));
				}else {
					PopulationUtils.aggiungiPersona(popolazione, new Spregiudicata(evoluzione, popolazione, donna.getPercDominante(), donna.getPercRecessivo()));
				}
			}else {
				if (donna.getTipo() == Tipo.Prudente) {
					PopulationUtils.aggiungiPersona(popolazione, new Spregiudicata(evoluzione, popolazione, donna.getPercDominante(), donna.getPercRecessivo()));
				}else {
					PopulationUtils.aggiungiPersona(popolazione, new Prudente(evoluzione, popolazione, donna.getPercDominante(), donna.getPercRecessivo()));
				}
			}
		}else {
			if (gene <= uomo.getPercDominante()) {
				if (uomo.getTipo() == Tipo.Morigerato) {
					PopulationUtils.aggiungiPersona(popolazione, new Morigerato(evoluzione, popolazione, uomo.getPercDominante(), uomo.getPercRecessivo()));
				}else {
					PopulationUtils.aggiungiPersona(popolazione, new Avventuriero(evoluzione, popolazione, uomo.getPercDominante(), uomo.getPercRecessivo()));
				}
			}else {
				if (uomo.getTipo() == Tipo.Morigerato) {
					PopulationUtils.aggiungiPersona(popolazione, new Avventuriero(evoluzione, popolazione, uomo.getPercDominante(), uomo.getPercRecessivo()));
				}else {
					PopulationUtils.aggiungiPersona(popolazione, new Morigerato(evoluzione, popolazione, uomo.getPercDominante(), uomo.getPercRecessivo()));
				}
			}
		}
	}

}
