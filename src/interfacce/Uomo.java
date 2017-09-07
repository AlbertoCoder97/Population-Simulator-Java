package interfacce;

public interface Uomo extends Human{

	//Questo metodo fa si che un uomo corteggi una donna a caso
	public boolean corteggia();
	
	//Questo metodo restituisce la compagna dell' uomo
	public Donna getMoglie();
}
