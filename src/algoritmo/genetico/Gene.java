package algoritmo.genetico;

import curso.Dia;
import curso.Horario;
import model.Ano;
import model.Disciplina;
import model.Professor;

public class Gene {
	private Horario hora;
	private Ano periodo;
	private Professor professor;
	private Disciplina disciplina;
	private Dia dia;

	public Gene(Horario hora, Ano periodo, Professor professor, Disciplina disciplina, Dia dia) {
		super();
		this.hora = hora;
		this.periodo = periodo;
		this.professor = professor;
		this.disciplina = disciplina;
		this.dia = dia;
	}
	public Horario getHora() {
		return hora;
	}
	public void setHora(Horario hora) {
		this.hora = hora;
	}
	public Ano getPeriodo() {
		return periodo;
	}
	public void setPeriodo(Ano periodo) {
		this.periodo = periodo;
	}
	public Professor getProfessor() {
		return professor;
	}
	public void setProfessor(Professor professor) {
		this.professor = professor;
	}
	public Disciplina getDisciplina() {
		return disciplina;
	}
	public void setDisciplina(Disciplina disciplina) {
		this.disciplina = disciplina;
	}
	
	public Dia getDia() {
		return dia;
	}
	public void setDia(Dia dia) {
		this.dia = dia;
	}
	@Override
	public String toString() {
		return "Gene [hora=" + hora.getHora() + ", periodo=" + periodo.getNome() + ", professor=" + professor.getNome() + ", disciplina=" + disciplina.getNome()
				+ ", dia=" + dia.getNome() + "]";
	}
	
	
	
	
}
