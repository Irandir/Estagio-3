package model;

public enum HoraEnum {
	h1("8:00"),h2("8:50"),	h3("10:15"), h4("11:05"), h5("12:00"), 	
	h6("13:00"),h7("13:50"),h8("15:15"),h9("16:05"), h10("17:00"), 
	h11("19:00"),h12("19:40"),h13("20:20"),h14("21:00"),h15("22:00");
	
	private String v;
	
	private HoraEnum(String f) {
		v = f;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return v;
	}
}
