package model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
@Entity
public class Professor {
	@Id
	@GeneratedValue
	private Integer id;
	private String nome;

	public Professor() {
		// TODO Auto-generated constructor stub
	}
	public Professor(String nome) {
		this.nome = nome;

	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Integer getId() {
		return id;
	}
	@Override
	public String toString() {
		return "Professor [id=" + id + ", nome=" + nome + "]";
	}	
	
}
