package classi;

import java.util.Random;

import interfacce.Donna;
import interfacce.Human;
import interfacce.Uomo;
import main.main.Sesso;
import main.main.Tipo;
import utils.HumanUtils;

public class Spregiudicata implements Donna {
	
	private Random random = new Random();
	
	private Evoluzione evoluzione;
	private Popolazione popolazione;
	private Sesso sesso;
	private Tipo tipo;
	private int geneDominante;
	private int geneRecessivo;
	private int numerofigli;
	
	public Spregiudicata(Evoluzione evoluzione, Popolazione popolazione, int geneDominante, int geneRecessivo) {
		
		this.evoluzione = evoluzione;
		this.popolazione = popolazione;
		this.sesso = Sesso.Donna;
		this.tipo = Tipo.Spregiudicata;
		
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
	
	public int getNumeroFigli() {
		return this.numerofigli;
	}
	
	@Override
	public void premioFigli(Human uomo) {
		if (uomo.getTipo() == Tipo.Morigerato) {
			int premiomorigerato = ((main.main.A-main.main.B)/2);
			if (!((this.geneDominante + premiomorigerato) > 100)) {
				this.geneDominante += premiomorigerato;
				this.geneRecessivo -= premiomorigerato;
			}
		}
		if (uomo.getTipo() == Tipo.Avventuriero) {
			int premioavventuriero = (main.main.A - main.main.B);
			if (!((this.geneDominante + premioavventuriero) > 100)) {
			this.geneDominante += premioavventuriero;
			this.geneRecessivo -= premioavventuriero;
			}
		}
		
	}

	@Override
	public boolean corteggiata(Uomo uomo) {
		int successo = random.nextInt(2);
		if (successo == 0) {
			return false;
		}else {
			return true;
		}
	}
}
