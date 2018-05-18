package model;

public enum DiaEnum {
	SEGUNDA("Segunda"),
	TERCA("Terça"),
	QUARTA("Quarta"),
	QUINTA("Quinta"),
	SEXTA("Sexta");
	
	private String v;
	
	private DiaEnum(String f) {
		v = f;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return v;
	}
}
