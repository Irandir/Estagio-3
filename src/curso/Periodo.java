package curso;

public class Periodo {
	private Disciplina[] disciplinas;
	private int numeroDoPerido;
	public Periodo(int numeroDoPerido,Disciplina[] disciplinas) {
		super();
		this.numeroDoPerido = numeroDoPerido;
		this.disciplinas = disciplinas;
	}

	public Disciplina[] getDisciplinas() {
		return disciplinas;
	}

	public void setDisciplinas(Disciplina[] disciplinas) {
		this.disciplinas = disciplinas;
	}
	
	public int getNumeroDoPerido() {
		return numeroDoPerido;
	}

	public void setNumeroDoPerido(int numeroDoPerido) {
		this.numeroDoPerido = numeroDoPerido;
	}

	public int numeroDeAulasDeUmPeriodo(){
		int r = 0;
		for (int i = 0; i < disciplinas.length; i++) {
			r+= disciplinas[i].getNumeroDeAulasSemanais();
		}
		return r;
	}
	
}
