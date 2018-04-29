package model;

import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class DiaImpossivelHora {
	@Id
	@GeneratedValue
	private Integer id;
	private Integer prof_id;
	private Integer diaImpossivel_id;
	private Integer hora_id;
	
	public DiaImpossivelHora() {
		// TODO Auto-generated constructor stub
	}
	
	public DiaImpossivelHora(Integer prof_id, Integer diaImpossivel_id , Integer hora_id) {
		this.diaImpossivel_id = diaImpossivel_id ;
		this.hora_id = hora_id;
		this.prof_id = prof_id;
	}

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getDia_id() {
		return diaImpossivel_id;
	}
	public void setDia_id(Integer dia_id) {
		this.diaImpossivel_id = dia_id;
	}
	public Integer getHora_id() {
		return hora_id;
	}
	public void setHora_id(Integer hora_id) {
		this.hora_id = hora_id;
	}

	public Integer getProf_id() {
		return prof_id;
	}

	public void setProf_id(Integer prof_id) {
		this.prof_id = prof_id;
	}

	public Integer getDiaImpossivel_id() {
		return diaImpossivel_id;
	}

	public void setDiaImpossivel_id(Integer diaImpossivel_id) {
		this.diaImpossivel_id = diaImpossivel_id;
	}
	
}
