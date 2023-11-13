package model;

public class Pokemon {
	private String name;
	private String url;
	private String foto;
	private String number;
	
	public String getName() {
		return name;
	}
	
	public String getUrl() {
		return url;
	}
	
	public String getFoto() {
		return foto;
	}
	
	public void setFoto(String foto) {
		this.foto = foto;
	}

	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	@Override
	public String toString() {
		return "Pokemon [name=" + name + ", url=" + url + ", foto=" + foto + ", number=" + number + "]";
	}

}
