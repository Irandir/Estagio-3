package model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import hirbenate.AnoDisciplinaHibernate;
import hirbenate.DisciplinaHibernate;

@Entity
public class Ano {
	@Id
	@GeneratedValue
	private Integer id;

	private String nome;
	@Enumerated(EnumType.STRING)
	private Turno turno;

	public Ano() {
		// TODO Auto-generated constructor stub
	}
	
	public Ano(String nome, Turno turno) {
		this.nome = nome;
		//this.disciplinas = disciplinas;
		this.turno = turno;
	}

	
	public Turno getTurno() {
		return turno;
	}

	public void setTurno(Turno turno) {
		this.turno = turno;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	/*public int numeroDeAulasDeUmPeriodo() {
		int r = 0;
		for (int i = 0; i < disciplinas.size(); i++) {
			r += disciplinas.get(i).getNumeroDeAulasSemanais();
		}
		return r;
	}*/

	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Ano [id=" + id + ", nome=" + nome + ", turno=" + turno + "]";
	}
	
}
