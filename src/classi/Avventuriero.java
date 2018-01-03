package classi;


import java.util.Random;

import interfacce.Donna;
import interfacce.Human;
import interfacce.Uomo;
import main.main.Sesso;
import main.main.Tipo;
import utils.HumanUtils;

public class Avventuriero implements Uomo{
	
	private Evoluzione evoluzione;
	private Popolazione popolazione;
	private Sesso sesso;
	private Tipo tipo;
	private int geneDominante;
	private int geneRecessivo;
	private int numerofigli;
	private Donna moglie;
	private int avventure;
	
	private Random random = new Random();

	public Avventuriero(Evoluzione evoluzione, Popolazione popolazione, int geneDominante, int geneRecessivo) {
		
		this.evoluzione = evoluzione;
		this.popolazione = popolazione;
		this.sesso = Sesso.Uomo;
		this.tipo = Tipo.Avventuriero;
		
		this.geneDominante = geneDominante;
		this.geneRecessivo = geneRecessivo;
		
		this.numerofigli = 1;
		this.avventure = random.nextInt(20);
		
		this.moglie = null;
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
	public Evoluzione getEvoluzione() {
		return this.evoluzione;
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

	@Override
	public void premioFigli(Human donna) {
		if(donna.getTipo() == Tipo.Spregiudicata) {
			if (!((this.geneDominante + main.main.A) > 100)) {
				this.geneDominante += main.main.A;
				this.geneRecessivo -= main.main.A;
			}
			
		}
	}

	@Override
	public int getNumeroFigli() {
		return this.numerofigli;
	}

	@Override
	public boolean corteggia() {	
		this.avventure -=1;
		Donna donna = HumanUtils.getDonnaCasuale(this.popolazione);
		if (donna.corteggiata(this)) {
			this.moglie = donna;
			return true;
		}
		return false;
	}

	public int getAvventure() {
		return this.avventure;
	}

	@Override
	public Donna getMoglie() {
		return this.moglie;
	}


}
