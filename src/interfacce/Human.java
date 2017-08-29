package interfacce;

import classi.Popolazione;

public interface Human {
	//Tipi per le persone
	public enum Sesso {Uomo,Donna}
	public enum Tipo {Morigerato, Avventuriero, Prudente, Spregiudicata}
	
	//Restituisce il tipo dell' essere umano
	public Tipo getTipo();
	
	//Restituisce il Sesso dell' essere Umano
	public Sesso getSesso();
	
	//Restituisce la popolazione dell' essere umano
	public Popolazione getPopolazione();
	
	//Restituisce la percentuale del gene dominante
	public int getPercDominante();
	
	//Restituisce la percentuale del gene recessivo
	public int getPercRecessivo();
	
	//Se l' umano ha figli incrementa la percentuale del gene dominante
	public void premioFigli(Human persona);
	
	//Questo metodo restituisce il numero di figli che l' umano vuole avere
	public int getNumeroFigli();

	//Questo metodo fa si che un uomo corteggi una donna a caso
	public boolean corteggia();
	
	//Questo metodo per solo le donne restituisce true se l' uomo la conquista
	public boolean corteggiata(Human uomo);
	
	//Questo metodo restituisce la compagna dell' uomo
	public Human getConsorte();
	
	//Questo Metodo restituisce il numero massimo di Avventure per un uomo
	public int getAvventure();
	
}
