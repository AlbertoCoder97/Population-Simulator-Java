package classi;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import interfacce.Donna;
import interfacce.Human;
import interfacce.Uomo;
import main.main.Tipo;
import utils.EvolutionUtils;
import utils.HumanUtils;
import utils.PopulationUtils;

public class Popolazione {
	
	//Oggetti all' interno dell' oggetto Popolazione
	private Evoluzione evoluzione;
	private ArrayList<Uomo> listauomini;
	private ArrayList<Donna> listadonne;
	private int totpopolazione;
	
	private Timer timer;
	
	public Popolazione(Evoluzione evoluzione) {
		this.evoluzione = evoluzione;
		this.listauomini = new ArrayList<Uomo>();
		this.listadonne = new ArrayList<Donna>();
		this.totpopolazione = this.listadonne.size() + this.listauomini.size();
		
		this.timer = new Timer();
	}
	
	//Questo metodo aggiorna la popolazione
	public void update() {
		System.out.println("Numero uomini " + this.listauomini.size());
		System.out.println("Numero donne " + this.listadonne.size());
		Uomo uomo = HumanUtils.getUomoCasuale(this);
		HumanUtils.vivi(uomo);
	}
	
	//Questo metodo restituisce la percentuale della popolazione di Tipo Morigerati
	public int percMorigerati() {
		int counter = 0;
		for (Uomo uomo : this.listauomini) {
			if (uomo.getTipo().equals(Tipo.Morigerato)) {
				counter +=1;
			}
		}
		return ((counter * 100)/this.listauomini.size());
	}
	
	//Questo metodo restituisce la percentuale delle donne di Tipo Prudenti
	public int percPrudenti() {
		int counter = 0;
		for (Human donna : this.listadonne) {
			if (donna.getTipo().equals(Tipo.Prudente)) {
				counter +=1;
			}
		}
		return ((counter * 100)/this.listadonne.size());
	}	
	
	public Evoluzione getEvoluzione() {
		return this.evoluzione;
	}
	
	//Questo metodo restituisce la lista degli uomini
	public ArrayList<Uomo> getListaUomini(){
		return this.listauomini;
	}
	
	//Questo metodo restituisce la lista delle donne
	public ArrayList<Donna> getListaDonne(){
		return this.listadonne;
	}
	
	//Questo metodo restituisce il numero preciso della popolazione
	public int getTotale() {
		return this.totpopolazione;
	}
	
	//Questo metodo restituisce il timer
	public Timer getTimer() {
		return this.timer;
	}
	
	//Questo metodo starta il timer della popolazione che aggiorna la popolazione e controlla se si è raggiunta la stabilità e se la popolazione debba essere terminata
	public void startTimer() {
		EvolutionUtils.aggiungiPercentuali(this.evoluzione, this);
		if (EvolutionUtils.stabilitaEvolutiva(this.evoluzione)) {
			EvolutionUtils.fineEvoluzione(this.evoluzione);
		}else {
			Popolazione popolazione = this; //Necessario dichiarare popolazione per la timertask
			this.evoluzione.creaGenerazioneSuccessiva();
			this.timer.schedule(new TimerTask() {
				@Override
				public void run() {
					popolazione.update();
					PopulationUtils.finePopolazione(popolazione);
				}
			}, 0,1);
		}
	}
	
	//Questo metodo interrompe il timer
	public void stopTimer() {
		this.timer.cancel();
	}
	
}
