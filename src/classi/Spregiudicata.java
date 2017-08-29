package classi;

import java.util.Random;

import interfacce.Human;
import utils.HumanUtils;

public class Spregiudicata implements Human {
	
	private Random random = new Random();
	
	private Popolazione popolazione;
	private Sesso sesso;
	private Tipo tipo;
	private int geneDominante;
	private int geneRecessivo;
	private int numerofigli;
	private Human consorte;
	
	public Spregiudicata(Popolazione popolazione, int geneDominante, int geneRecessivo) {
		this.popolazione = popolazione;
		this.sesso = Sesso.Donna;
		this.tipo = Tipo.Spregiudicata;
		
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
	public boolean corteggia() {
		return false;
	}
	
	@Override
	public void premioFigli(Human uomo) {
		if (uomo.getTipo() == Tipo.Morigerato) {
			this.geneDominante += 5;
			this.geneRecessivo -= 5;
		}
		if (uomo.getTipo() == Tipo.Avventuriero) {
			this.geneDominante -= 5;
			this.geneRecessivo += 5;
		}
		
	}

	@Override
	public boolean corteggiata(Human uomo) {
		int successo = random.nextInt(2);
		if (successo == 0) {
			return false;
		}else {
			return true;
		}
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
