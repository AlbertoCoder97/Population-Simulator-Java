package classi;


import java.util.Random;

import interfacce.Human;
import utils.HumanUtils;

public class Avventuriero implements Human{
	
	private Popolazione popolazione;
	private Sesso sesso;
	private Tipo tipo;
	private int geneDominante;
	private int geneRecessivo;
	private int numerofigli;
	private Human consorte;
	private int avventure;
	
	private Random random = new Random();

	public Avventuriero(Popolazione popolazione, int geneDominante, int geneRecessivo) {
		this.popolazione = popolazione;
		this.sesso = Sesso.Uomo;
		this.tipo = Tipo.Avventuriero;
		
		this.geneDominante = geneDominante;
		this.geneRecessivo = geneRecessivo;
		
		this.numerofigli = 1;
		this.avventure = random.nextInt(21);
		
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

	@Override
	public void premioFigli(Human donna) {
		if(donna.getTipo() == Tipo.Spregiudicata) {
			this.geneDominante += 15;
			this.geneRecessivo -= 15;
		}
	}

	@Override
	public int getNumeroFigli() {
		return this.numerofigli;
	}

	@Override
	public boolean corteggia() {
		this.avventure -=1;
		Human donna = HumanUtils.getDonnaCasuale(this.popolazione);
		if (donna.corteggiata(this)) {
			this.consorte = donna;
			return true;
		}
		return false;
	}
	@Override
	public boolean corteggiata(Human uomo) {
		return false;
	}

	@Override
	public int getAvventure() {
		return this.avventure;
	}

	@Override
	public Human getConsorte() {
		return this.consorte;
	}


}
