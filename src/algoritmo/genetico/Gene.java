package algoritmo.genetico;

import curso.Dia;
import curso.Disciplina;
import curso.Horario;
import curso.Periodo;
import curso.Professor;

public class Gene {
	private Horario hora;
	private Periodo periodo;
	private Professor professor;
	private Disciplina disciplina;
	private Dia dia;

	public Gene(Horario hora, Periodo periodo, Professor professor, Disciplina disciplina, Dia dia) {
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
	public Periodo getPeriodo() {
		return periodo;
	}
	public void setPeriodo(Periodo periodo) {
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
		return "Gene [hora=" + hora.getHora() + ", periodo=" + periodo.getNumeroDoPerido() + ", professor=" + professor.getNome() + ", disciplina=" + disciplina.getNome()
				+ ", dia=" + dia.getNome() + "]";
	}
	
	
	
	
}
