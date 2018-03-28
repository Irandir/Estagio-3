package curso;

public class Ano {
	private Disciplina[] disciplinas;
	private String nome;
	private Horario horas[];
	public Ano(String nome,Disciplina[] disciplinas) {
		super();
		this.nome = nome;
		this.disciplinas = disciplinas;
	}

	public Disciplina[] getDisciplinas() {
		return disciplinas;
	}

	public void setDisciplinas(Disciplina[] disciplinas) {
		this.disciplinas = disciplinas;
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int numeroDeAulasDeUmPeriodo(){
		int r = 0;
		for (int i = 0; i < disciplinas.length; i++) {
			r+= disciplinas[i].getNumeroDeAulasSemanais();
		}
		return r;
	}
	
}
