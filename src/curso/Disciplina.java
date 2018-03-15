package curso;

public class Disciplina {
	private String nome;
	private int numeroDeAulasSemanais;// outra idea podia ser a carga horaria

	public Disciplina(String nome, int numeroDeAulasSemanais) {
		super();
		this.nome = nome;
		this.numeroDeAulasSemanais = numeroDeAulasSemanais;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getNumeroDeAulasSemanais() {
		return numeroDeAulasSemanais;
	}

	public void setNumeroDeAulasSemanais(int numeroDeAulasSemanais) {
		this.numeroDeAulasSemanais = numeroDeAulasSemanais;
	}

	
	
}
