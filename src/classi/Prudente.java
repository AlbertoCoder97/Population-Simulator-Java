package classi;

import java.util.Random;

import interfacce.Donna;
import interfacce.Human;
import interfacce.Uomo;
import main.main.Sesso;
import main.main.Tipo;
import utils.HumanUtils;

public class Prudente implements Donna {
	
	private Evoluzione evoluzione;
	private Popolazione popolazione;
	private Sesso sesso;
	private Tipo tipo;
	private int geneDominante;
	private int geneRecessivo;
	private int numerofigli;
	private Random random = new Random();
	
	public Prudente(Evoluzione evoluzione, Popolazione popolazione, int geneDominante, int geneRecessivo) {
		
		this.evoluzione = evoluzione;
		this.popolazione = popolazione;
		
		this.sesso = Sesso.Donna;
		this.tipo = Tipo.Prudente;
		
		this.geneDominante = geneDominante;
		this.geneRecessivo = geneRecessivo;
		
		this.numerofigli = HumanUtils.randomFigli();
		
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
	public int getNumeroFigli() {
		return this.numerofigli;
	}

	@Override
	public boolean corteggiata(Uomo uomo) {
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
			int premio = ((main.main.A - main.main.B)/(2 - main.main.C));
			if (!((this.geneDominante + premio) > 100)) {
				this.geneDominante += premio;
				this.geneRecessivo -= premio;
			}
		}
	}

}
