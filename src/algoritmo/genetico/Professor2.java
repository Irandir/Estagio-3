package algoritmo.genetico;

import java.util.List;

import model.Dia;
import model.Disciplina;
import model.Hora;

public class Professor2 {
	private String nome;
	private List<Hora> hora;
	private List<Dia> dia;
	private List<Disciplina>prefDisciplinas;
	
	
	public Professor2(String nome) {
		super();
		this.nome = nome;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public List<Hora> getHora() {
		return hora;
	}
	public void setHora(List<Hora> hora) {
		this.hora = hora;
	}
	public List<Dia> getDia() {
		return dia;
	}
	public void setDia(List<Dia> dia) {
		this.dia = dia;
	}
	public List<Disciplina> getPrefDisciplinas() {
		return prefDisciplinas;
	}
	public void setPrefDisciplinas(List<Disciplina> prefDisciplinas) {
		this.prefDisciplinas = prefDisciplinas;
	}
	@Override
	public String toString() {
		return "Professor2 [nome=" + nome + ", hora=" + hora + ", dia=" + dia + ", prefDisciplinas=" + prefDisciplinas
				+ "]";
	}
	
	
}
