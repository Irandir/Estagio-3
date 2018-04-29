package model;

public enum Dia {
	SEGUNDA("Segunda"),
	TERCA("Terça"),
	QUARTA("Quarta"),
	QUINTA("Quinta"),
	SEXTA("Sexta");
	
	private String v;
	
	private Dia(String f) {
		v = f;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return v;
	}
}
