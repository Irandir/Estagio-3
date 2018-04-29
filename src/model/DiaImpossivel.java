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
public class DiaImpossivel {
	@Id 
	@GeneratedValue
	private Integer id;
	@Enumerated(EnumType.STRING)
	private Dia dia;
	
	public DiaImpossivel() {
		// TODO Auto-generated constructor stub
	}
	public DiaImpossivel(Dia dia) {
		this.dia = dia;
	}
	
	public Dia getDia() {
		return dia;
	}
	public void setDia(Dia dia) {
		this.dia = dia;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}

	
}
