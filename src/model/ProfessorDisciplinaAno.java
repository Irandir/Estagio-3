package model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
@Entity
public class ProfessorDisciplinaAno {
	@Id
	@GeneratedValue
	private Integer id;
	private Integer prof_id;
	private Integer disc_id;
	private Integer ano_id;
	public ProfessorDisciplinaAno() {
		super();
	}

	public ProfessorDisciplinaAno( Integer id_prof, Integer id_disc,Integer ano_id) {
		super();
		this.prof_id = id_prof;
		this.disc_id = id_disc;
		this.ano_id = ano_id;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getProf_id() {
		return prof_id;
	}

	public void setProf_id(Integer prof_id) {
		this.prof_id = prof_id;
	}

	public Integer getDisc_id() {
		return disc_id;
	}

	public void setDisc_id(Integer disc_id) {
		this.disc_id = disc_id;
	}

	public Integer getAno_id() {
		return ano_id;
	}

	public void setAno_id(Integer ano_id) {
		this.ano_id = ano_id;
	}

	
	
	
}
