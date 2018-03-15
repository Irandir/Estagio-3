package curso;

public class DiaImpossivel {

	private Dia dia;
	private Horario hora[];
	public DiaImpossivel(Dia dia, Horario[] hora) {
		super();
		this.dia = dia;
		this.hora = hora;
	}
	public Dia getDia() {
		return dia;
	}
	public void setDia(Dia dia) {
		this.dia = dia;
	}
	public Horario[] getHora() {
		return hora;
	}
	public void setHora(Horario[] hora) {
		this.hora = hora;
	}
	

}
