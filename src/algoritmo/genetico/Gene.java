package algoritmo.genetico;


import model.Dia;
import model.Disciplina;
import model.Hora;

public class Gene {
	private Hora hora;
	private Ano2 ano;
	private Professor2 professor;
	private Disciplina disciplina;
	private Dia dia;

	public Gene(Hora hora, Ano2 ano, Professor2 professor, Disciplina disciplina, Dia dia) {
		super();
		this.hora = hora;
		this.ano = ano;
		this.professor = professor;
		this.disciplina = disciplina;
		this.dia = dia;
	}
	
	public Hora getHora() {
		return hora;
	}

	public void setHora(Hora hora) {
		this.hora = hora;
	}

	
	public Ano2 getAno() {
		return ano;
	}

	public void setAno(Ano2 ano) {
		this.ano = ano;
	}

	public Professor2 getProfessor() {
		return professor;
	}

	public void setProfessor(Professor2 professor) {
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
		return "Gene [hora=" + hora.getHora() + ", periodo=" + ano.getNome() + ", professor=" + professor.getNome() + ", disciplina=" + disciplina.getNome()
				+ ", dia = " + dia + "]";
	}
	
	
	
	
}
