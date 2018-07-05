package model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;
@Entity
public class Disciplina {
	@Id
	@GeneratedValue
	private Integer id;
	private String nome;
	private Integer numeroDeAulasSemanais;// outra idea podia ser a carga horaria

	public Disciplina() {
		// TODO Auto-generated constructor stub
	}
	
	public Disciplina(String nome, int numeroDeAulasSemanais) {
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

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}	
	
}
