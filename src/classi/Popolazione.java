package classi;

import java.util.ArrayList;

import interfacce.Human;
import interfacce.Human.Sesso;
import interfacce.Human.Tipo;
import utils.HumanUtils;
import utils.PopulationUtils;

public class Popolazione {
	
	//Oggetti all' interno dell' oggetto Popolazione
	private ArrayList<Human> listauomini;
	private ArrayList<Human> listadonne;
	private int totpopolazione;
	
	public Popolazione() {
		this.listauomini = new ArrayList<Human>();
		this.listadonne = new ArrayList<Human>();
		this.totpopolazione = this.listadonne.size() + this.listauomini.size();
	}
	
	//Questo metodo aggiorna la popolazione
	public void update() {
		if (this.totpopolazione > 10000) {
			System.out.println("EPIDEMIA IN CORSO!");
			this.epidemia();
		}else {
			Human uomo = HumanUtils.getUomoCasuale(this);
			HumanUtils.vivi(uomo);
		}
	}
	
	//Questo metodo causa un' epidemia nella popolazione e la riduce a metà degli elementi
	public void epidemia() {
		main.main.timerupdate.cancel();
		for (int i = 0; i < this.listauomini.size()/2; i++) {
			HumanUtils.Morte(this.listauomini.get(0));
		}
		for (int i = 0; i < this.listadonne.size()/2; i++) {
			HumanUtils.Morte(this.listadonne.get(0));
		}
		PopulationUtils.startTimer(this);
	}
	
	//Questo metodo restituisce la percentuale della popolazione di Tipo Morigerati
	public int percMorigerati() {
		int counter = 0;
		for (Human uomo : this.listauomini) {
			if (uomo.getTipo().equals(Tipo.Morigerato)) {
				counter +=1;
			}
		}
		return ((counter * 8)/this.listauomini.size());
	}
	
	//Questo metodo restituisce la percentuale della popolazione di Tipo Morigerati
		public int percAvventurieri() {
			int counter = 0;
			for (Human uomo : this.listauomini) {
				if (uomo.getTipo().equals(Tipo.Avventuriero)) {
					counter +=1;
				}
			}
			return ((counter * 8)/this.listauomini.size());
		}
	
	//Questo metodo restituisce la percentuale delle donne di Tipo Prudenti
	public int percPrudenti() {
		int counter = 0;
		for (Human donna : this.listadonne) {
			if (donna.getTipo().equals(Tipo.Prudente)) {
				counter +=1;
			}
		}
		return ((counter * 6)/this.listadonne.size());
	}
	
	//Questo metodo ritorna la percentuale delle donne di tipo Spregiudicate
	public int percSpregiudicate() {
		int counter = 0;
		for (Human donna : this.listadonne) {
			if (donna.getTipo().equals(Tipo.Spregiudicata)) {
				counter += 1;
			}
		}
		return ((counter * 6)/this.listadonne.size());
	}
	
	
	
	//Questo metodo aggiunge un uomo o una donna dalla rispettiva lista
	public void aggiungiPersona(Human umano) {
		if (umano != null) {
			if (umano.getSesso() == Sesso.Uomo) {
				this.listauomini.add(umano);
			}else {
				this.listadonne.add(umano);
			}
		}
	}
	
	
	//Questo metodo rimuove un uomo o una donna dalla rispettiva lista
	public void rimuoviPersona(Human umano) {
		if (umano != null) {
			if (umano.getSesso() == Sesso.Uomo) {
				this.listauomini.remove(umano);
			}else {
				this.listadonne.remove(umano);
			}
		}
	}
	
	//Questo metodo restituisce la lista degli uomini
	public ArrayList<Human> getListaUomini(){
		return this.listauomini;
	}
	
	//Questo metodo restituisce la lista delle donne
	public ArrayList<Human> getListaDonne(){
		return this.listadonne;
	}
	
	//Questo metodo restituisce il numero preciso della popolazione
	public int getTotale() {
		return this.totpopolazione;
	}
}
