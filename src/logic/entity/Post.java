package logic.entity;

public class Post {
	
	private int id;
	
	private String titolo;
	private String autore;
	private String descrizione;
	
	private String nomeSample;
	
	private String argomento;
	
	private String risolto;
	
	public Post(int int1, String string, String string2, String string3, String string4, String string5,
			String string6) {
	}

	public Post() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public String getTitolo() {
		return titolo;
	}
	
	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}

	public String getAutore() {
		return autore;
	}

	public void setAutore(String autore) {
		this.autore = autore;
	}

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	public String getNomeSample() {
		return nomeSample;
	}

	public void setNomeSample(String nomeSample) {
		this.nomeSample = nomeSample;
	}

	public String getArgomento() {
		return argomento;
	}

	public void setArgomento(String argomento) {
		this.argomento = argomento;
	}

	public String getRisolto() {
		return risolto;
	}

	public void setRisolto(String risolto) {
		this.risolto = risolto;
	}

}
