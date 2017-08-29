package classi;


import interfacce.Human;
import utils.HumanUtils;

public class Morigerato implements Human{
	
	
	private Popolazione popolazione;
	private Sesso sesso;
	private Tipo tipo;
	private int geneDominante;
	private int geneRecessivo;
	private int numerofigli;
	private Human consorte;
	
	
	public Morigerato(Popolazione popolazione, int geneDominante, int geneRecessivo) {
		this.popolazione = popolazione;
		this.sesso = Sesso.Uomo;
		this.tipo = Tipo.Morigerato;
		
		this.geneDominante = geneDominante;
		this.geneRecessivo = geneRecessivo;
		
		this.numerofigli = HumanUtils.randomFigli();
		this.consorte = null;
	}

	@Override
	public Tipo getTipo() {
		return this.tipo;
	}
	
	@Override
	public Sesso getSesso() {
		return this.sesso;
	}

	@Override
	public Popolazione getPopolazione() {
		return this.popolazione;
	}
	
	@Override
	public int getPercDominante() {
		return this.geneDominante;
	}

	@Override
	public int getPercRecessivo() {
		return this.geneRecessivo;
	}
	
	public int getNumeroFigli() {
		return this.numerofigli;
	}
	
	@Override
	public void premioFigli(Human donna) {
		if (donna.getTipo() == Tipo.Prudente) {
			this.geneDominante += 2;
			this.geneRecessivo -= 2;
		}
		if (donna.getTipo() == Tipo.Spregiudicata) {
			this.geneDominante += 5;
			this.geneRecessivo -= 5;
		}
	}

	@Override
	public boolean corteggia() {
		Human donna = HumanUtils.getDonnaCasuale(this.popolazione);
		if (donna.corteggiata(this)) {
			this.consorte = donna;
			return true;
		}
		return false;
	}
	
	//Metodo per sole donne
	@Override
	public boolean corteggiata(Human uomo) {
		return false;
	}

	@Override
	public int getAvventure() {
		return 0;
	}

	@Override
	public Human getConsorte() {
		return this.consorte;
	}	
}
