package interfacce;

import classi.Popolazione;
import main.main.Sesso;
import main.main.Tipo;

public interface Human {
	
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
	
	//Se l' umano ha figli incrementa la percentuale del gene dominante e decresce quello del gene recessivo in base al/alla consorte
	public void premioFigli(Human consorte);
	
	//Questo metodo restituisce il numero di figli che l' umano vuole avere
	public int getNumeroFigli();
	
}
