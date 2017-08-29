package utils;

import java.util.ArrayList;
import java.util.Random;

import classi.Avventuriero;
import classi.Morigerato;
import classi.Popolazione;
import classi.Prudente;
import classi.Spregiudicata;
import interfacce.Human;
import interfacce.Human.Sesso;
import interfacce.Human.Tipo;

public class HumanUtils {
	
	private static Random random = new Random();
	
	
	public static int randomFigli() {
		int figli = random.nextInt(5);
		if (figli > 1) {
			return figli;
		}else {
			return 1;
		}
	}
	
	public static int randomGene() {
		return random.nextInt(101);
	}
	
	public static Sesso randomSesso() {
		int decisionesesso = random.nextInt(2);
		if (decisionesesso == 0) {
			return Sesso.Donna;
		}else{
			return Sesso.Uomo;
		}
	}
	
	//Questo metodo restituisce un numero randomico in base al numero di figli che un uomo vuole avere con una donna
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
		popolazione.rimuoviPersona(umano);
		umano = null;
	}
	
	//Questo metodo restituisce una donna casuale dalla lista della popolazione data
	public static Human getDonnaCasuale(Popolazione popolazione) {
		ArrayList<Human> lista = popolazione.getListaDonne();
		return lista.get(random.nextInt(lista.size()));
	}
	
	public static Human getUomoCasuale(Popolazione popolazione) {
		ArrayList<Human> lista = popolazione.getListaUomini();
		return lista.get(random.nextInt(lista.size()));
	}
	
	
	//Questo metodo fa vivere l' uomo, che corteggia una donna casuale e poi muore sia lui che la consorte.
	public static void vivi(Human uomo) {
		if (uomo.getTipo() == Tipo.Avventuriero) {
			while (uomo.getAvventure() > 0) {
				if (uomo.corteggia()) {
					riproduzione(uomo.getPopolazione(), uomo, uomo.getConsorte());
					Morte(uomo.getConsorte());
				}
			}
			Morte(uomo);
		}else {
			while (uomo.getConsorte() == null) {
				if (uomo.corteggia()) {
					int numerofigli = numeroFigli(uomo,uomo.getConsorte());
					for (int i = 0; i < numerofigli; i++) {
						riproduzione(uomo.getPopolazione(), uomo, uomo.getConsorte());
						uomo.premioFigli(uomo.getConsorte());
						uomo.getConsorte().premioFigli(uomo);
					}
					
				}
			}
			Morte(uomo.getConsorte()); //Muore la moglie dopo aver avuto figli
			Morte(uomo); //Muore anche l' uomo dopo aver avuto figli
		}
	}
	
	//Questo metodo aggiunge un bambino alla lista degli uomini o delle donne
	public static void riproduzione(Popolazione popolazione, Human uomo, Human donna) {
		int gene = randomGene();
		if (randomSesso() == Sesso.Donna) {
			if (gene <= donna.getPercDominante()) {
				if (donna.getTipo() == Tipo.Prudente) {
					popolazione.aggiungiPersona(new Prudente(popolazione, donna.getPercDominante(), donna.getPercRecessivo()));
				}else {
					popolazione.aggiungiPersona(new Spregiudicata(popolazione, donna.getPercDominante(), donna.getPercRecessivo()));
				}
			}else {
				if (donna.getTipo() == Tipo.Prudente) {
					popolazione.aggiungiPersona(new Spregiudicata(popolazione, donna.getPercRecessivo(), donna.getPercDominante()));
				}else {
					popolazione.aggiungiPersona(new Prudente(popolazione, donna.getPercRecessivo(), donna.getPercDominante()));
				}
			}
		}else {
			if (gene <= uomo.getPercDominante()) {
				if (uomo.getTipo() == Tipo.Morigerato) {
					popolazione.aggiungiPersona(new Morigerato(popolazione, uomo.getPercDominante(), uomo.getPercRecessivo()));
				}else {
					popolazione.aggiungiPersona(new Avventuriero(popolazione, uomo.getPercDominante(), uomo.getPercRecessivo()));
				}
			}else {
				if (uomo.getTipo() == Tipo.Morigerato) {
					popolazione.aggiungiPersona(new Avventuriero(popolazione, uomo.getPercRecessivo(), uomo.getPercDominante()));
				}else {
					popolazione.aggiungiPersona(new Morigerato(popolazione, uomo.getPercRecessivo(), uomo.getPercDominante()));
				}
			}
		}
	}

}
