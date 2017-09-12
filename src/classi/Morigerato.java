package classi;


import interfacce.Donna;
import interfacce.Human;
import interfacce.Uomo;
import main.main.Sesso;
import main.main.Tipo;
import utils.HumanUtils;

public class Morigerato implements Uomo{
	
	private Evoluzione evoluzione;
	private Popolazione popolazione;
	private Sesso sesso;
	private Tipo tipo;
	private int geneDominante;
	private int geneRecessivo;
	private int numerofigli;
	private Donna moglie;

	
	public Morigerato(Evoluzione evoluzione, Popolazione popolazione, int geneDominante, int geneRecessivo) {
		
		this.evoluzione = evoluzione;
		this.popolazione = popolazione;
		this.sesso = Sesso.Uomo;
		this.tipo = Tipo.Morigerato;
		
		this.geneDominante = geneDominante;
		this.geneRecessivo = geneRecessivo;
		
		this.numerofigli = HumanUtils.randomFigli();
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
	
	public int getNumeroFigli() {
		return this.numerofigli;
	}
	
	@Override
	public void premioFigli(Human donna) {
		
		if (donna.getTipo() == Tipo.Prudente) {
			int premioprudente = ((main.main.A - main.main.B)/(2-main.main.C));
			if (!((this.geneDominante + premioprudente) > 100)) {
				this.geneDominante += premioprudente;
				this.geneRecessivo -= premioprudente;
			}
		}
		if (donna.getTipo() == Tipo.Spregiudicata) {
			int premiospregiudicata = ((main.main.A - main.main.B)/2);
			if (!((this.geneDominante + premiospregiudicata) > 100)) {
				this.geneDominante += premiospregiudicata;
				this.geneRecessivo -= premiospregiudicata;
			}
		}
	}

	@Override
	public boolean corteggia() {
		Donna donna = HumanUtils.getDonnaCasuale(this.popolazione);
		if (donna.corteggiata(this)) {
			this.moglie = donna;
			return true;
		}
		return false;
	}

	@Override
	public Donna getMoglie() {
		return this.moglie;
	}	
}
