package algoritmo.genetico;



import java.util.List;

import model.Disciplina;
import model.Turno;

public class Ano2 {
	private String nome;
	private Turno turno;
	private List<Disciplina> disc;
	
	public Ano2(String nome, Turno turno, List<Disciplina> disc) {
		super();
		this.nome = nome;
		this.turno = turno;
		this.disc = disc;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Turno getTurno() {
		return turno;
	}
	public void setTurno(Turno turno) {
		this.turno = turno;
	}
	public List<Disciplina> getDisc() {
		return disc;
	}
	public void setDisc(List<Disciplina> disc) {
		this.disc = disc;
	}
	
	
}
