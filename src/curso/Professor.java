package curso;

public class Professor {
	private String nome;
	private Disciplina[] disciplina;
	private DiaImpossivel[] diaImpossivels;
	public Professor(String nome, Disciplina[] disciplina) {
		super();
		this.nome = nome;
		this.disciplina = disciplina;
		diaImpossivels = new DiaImpossivel[0];
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Disciplina[] getDisciplina() {
		return disciplina;
	}
	public void setDisciplina(Disciplina[] disciplina) {
		this.disciplina = disciplina;
	}
	public DiaImpossivel[] getDiaImpossivels() {
		return diaImpossivels;
	}
	public void setDiaImpossivels(DiaImpossivel[] diaImpossivels) {
		this.diaImpossivels = diaImpossivels;
	}
	
	
}
