package main;


import classi.Evoluzione;
import utils.EvolutionUtils;

public class main {
	
	//Tipi di persone
	public enum Sesso {Uomo,Donna}
	public enum Tipo {Morigerato, Avventuriero, Prudente, Spregiudicata}
	
	//Valori MAPS
	public static final int A = 15; //A indica il premio per aver avuto figli
	public static final int B = 20; //B indica il costo del crescere i figli
	public static final int C = 3; //C indica il costo del corteggiamento
	
	public static final int GRANDEZZA_POPOLAZIONE_INIZIALE = 200; //Questo numero indica per quante volte aggiungerà alla popolazione iniziale ogni tipo di essere umano
	
	public static final int TOLLERANZA_PERC = 10; //Tolleranza nella differenza della percentuale dei Morigerati e Prudenti
	public static final int GENERAZIONI_CHECK = 10; //Numero di generazioni da controllare
	
	public static final int GENERAZIONI_MASSIME = 200;
	
	public static int counter = 0;
	
	public static void main(String[] args) {
		
		EvolutionUtils.setup(new Evoluzione());
		
	}
}
