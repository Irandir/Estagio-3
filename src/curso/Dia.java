package curso;

public class Dia {
	public static final Dia DOMINGO = new Dia("DOMINGO");
	public static final Dia SEGUNDA = new Dia("SEGUNDA");
	public static final Dia TERCA = new Dia("TERÇA");
	public static final Dia QUARTA = new Dia("QUARTA");
	public static final Dia QUINTA = new Dia("QUINTA");
	public static final Dia SEXTA = new Dia("SEXTA");
	public static final Dia SABADO =new Dia( "SABADO");
	private String nome;
	public Dia(String nome){
		this.nome = nome;
	}
	
	public static Dia[] getDiasDaSemana(){
		Dia [] r = {DOMINGO,SEGUNDA,TERCA,QUARTA,QUINTA,SEXTA,SABADO};
		return r;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
}
