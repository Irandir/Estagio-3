package model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Hora {
	@Id
	@GeneratedValue
	private Integer id;
	private String hora;
	
	public Hora() {
		// TODO Auto-generated constructor stub
	}
	
	public Hora(HoraEnum hora) {
		this.hora = hora.toString();
	}
	public Hora(String hora) {
		this.hora = hora;
	}
	public String getHora() {
		return hora;
	}
	public void setHora(String hora) {
		this.hora = hora;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	/*@Override
	public String toString() {
		return "Hora [id=" + id + ", hora=" + hora + "]";
	}*/
	
}
