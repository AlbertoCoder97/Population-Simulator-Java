package classi;

import java.util.ArrayList;

public class Evoluzione {
	
	private ArrayList<Popolazione> listapopolazioni;
	private ArrayList<Integer> listaPercentualiMorigerati;
	private ArrayList<Integer> listaPercentualiPrudenti;
	
	public Evoluzione() {
		this.listapopolazioni = new ArrayList<Popolazione>();
		this.listaPercentualiMorigerati = new ArrayList<Integer>();
		this.listaPercentualiPrudenti = new ArrayList<Integer>();
	}
	
	
	
	//Questo metodo restituisce tutte le popolazioni nell' evoluzione
	public ArrayList<Popolazione> getListaPopolazioni(){
		return this.listapopolazioni;
	}
	
	//Questo metodo restituisce la lista con le percentuali dei morigerati di ogni generazione
	public ArrayList<Integer> getListaPercMorigerati(){
		return this.listaPercentualiMorigerati;
	}
	
	//Questo metodo restituisce la lista con le percentuali delle prudenti di ogni generazione
	
	public ArrayList<Integer> getListaPercPrudenti(){
		return this.listaPercentualiPrudenti;
	}
	
	//Questo metodo crea la generazione successiva dell' evoluzione
	public void creaGenerazioneSuccessiva() {
		this.listapopolazioni.add(new Popolazione(this));
	}
	
	//Questo metodo rimuove una popolazione dalla lista dell' evoluzione
	public void rimuoviPopolazione(Popolazione popolazione) {
		this.listapopolazioni.remove(popolazione);
	}
	
	
	
}
