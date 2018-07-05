package model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import hirbenate.AnoDisciplinaHibernate;
import hirbenate.DisciplinaHibernate;

@Entity
public class AnoDisciplina {
	@Id
	@GeneratedValue
	private Integer id;
	private Integer ano_id;
	private Integer disciplina_id;
	public AnoDisciplina() {
		// TODO Auto-generated constructor stub
	}
	public AnoDisciplina(Integer ano_id, Integer disciplina_id) {
		this.ano_id = ano_id;
		this.disciplina_id = disciplina_id;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getAno_id() {
		return ano_id;
	}
	public void setAno_id(Integer ano_id) {
		this.ano_id = ano_id;
	}
	public Integer getDisciplina_id() {
		return disciplina_id;
	}
	public void setDisciplina_id(Integer disciplina_id) {
		this.disciplina_id = disciplina_id;
	}

	public List<Disciplina>disciplinasDoAno(Ano ano){
		try{
			DisciplinaHibernate disciplinaHibernate = new DisciplinaHibernate();
			List<AnoDisciplina> anoDisciplina = new AnoDisciplinaHibernate().recuperarPorNome(ano.getId()+"");
			
			List<Disciplina> disciplinas = new ArrayList<>();
			for (int i = 0; i < anoDisciplina.size(); i++) {
				disciplinas.add(disciplinaHibernate.read(anoDisciplina.get(0).getDisciplina_id()));
			}
					
			return disciplinas;
		}catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
	@Override
	public String toString() {
		return "AnoDisciplina [id=" + id + ", ano_id=" + ano_id + ", disciplina_id=" + disciplina_id + "]";
	}
	
	
}
