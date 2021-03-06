package algoritmo.genetico;

import java.util.Arrays;

public class Individuo {
	private Gene[] genes;
	private double aptidao;
	public Individuo(Gene[] genes) {
		super();
		this.genes = genes;
	}

	public Gene[] getGenes() {
		return genes;
	}

	public void setGenes(Gene[] genes) {
		this.genes = genes;
	}

	public double getAptidao() {
		return aptidao;
	}

	public void setAptidao(double aptidao) {
		this.aptidao = aptidao;
	}

	@Override
	public String toString() {
		return "Individuo [genes=" + Arrays.toString(genes) + ", aptidao=" + aptidao + "]";
	}
	
}
