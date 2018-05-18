package model;

import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class DiaHora {
	@Id
	@GeneratedValue
	private Integer id;
	private Integer prof_id;
	private Integer dia_id;
	private Integer hora_id;
	
	public DiaHora() {
		// TODO Auto-generated constructor stub
	}
	
	public DiaHora(Integer prof_id, Integer diaImpossivel_id , Integer hora_id) {
		this.dia_id = diaImpossivel_id ;
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
		return dia_id;
	}
	public void setDia_id(Integer dia_id) {
		this.dia_id = dia_id;
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
		return dia_id;
	}

	public void setDiaImpossivel_id(Integer diaImpossivel_id) {
		this.dia_id = diaImpossivel_id;
	}

	@Override
	public String toString() {
		return "DiaHora [id=" + id + ", prof_id=" + prof_id + ", dia_id=" + dia_id + ", hora_id=" + hora_id + "]";
	}
	
}
