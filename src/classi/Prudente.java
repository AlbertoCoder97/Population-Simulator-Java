package classi;

import java.util.Random;

import interfacce.Human;
import utils.HumanUtils;

public class Prudente implements Human {
	
	private Popolazione popolazione;
	private Sesso sesso;
	private Tipo tipo;
	private int geneDominante;
	private int geneRecessivo;
	private int numerofigli;
	private Human consorte;
	private Random random = new Random();
	
	public Prudente(Popolazione popolazione, int geneDominante, int geneRecessivo) {
		
		this.popolazione = popolazione;
		
		this.sesso = Sesso.Donna;
		this.tipo = Tipo.Prudente;
		
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


	@Override
	public int getNumeroFigli() {
		return this.numerofigli;
	}

	@Override
	public boolean corteggia() {
		return false;
	}

	@Override
	public boolean corteggiata(Human uomo) {
		if (uomo.getTipo() == Tipo.Avventuriero) {
			return false;
		}else {
			int successo = random.nextInt(2);
			if (successo == 1) {
				return true;
			}else {
				return false;
			}
		}
	}

	@Override
	public void premioFigli(Human uomo) {
		if (uomo.getTipo() == Tipo.Morigerato) {
			this.geneDominante += 2;
			this.geneRecessivo -= 2;
		}
	}

	@Override
	public Human getConsorte() {
		return this.consorte;
	}

	@Override
	public int getAvventure() {
		return 0;
	}
}
