package model;


import java.util.List;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
@Entity
public class Dia {
	@Id 
	@GeneratedValue
	private Integer id;
	@Enumerated(EnumType.STRING)
	private DiaEnum dia;
	
	public Dia() {
		// TODO Auto-generated constructor stub
	}
	public Dia(DiaEnum dia) {
		this.dia = dia;
	}
	
	public DiaEnum getDia() {
		return dia;
	}
	public void setDia(DiaEnum dia) {
		this.dia = dia;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	@Override
	public String toString() {
		return dia.name();
	}

	
}
