package jwd.wafepa.web.dto;


public class GodisnjiDTO {

	private Long id;
	
	private String datumPocetka;
	
	private String datumKraja;
	
	private int radnihDana;
	
	private Long radnikId;
	private String radnikNaziv;
	public GodisnjiDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getDatumPocetka() {
		return datumPocetka;
	}
	public void setDatumPocetka(String datumPocetka) {
		this.datumPocetka = datumPocetka;
	}
	public String getDatumKraja() {
		return datumKraja;
	}
	public void setDatumKraja(String datumKraja) {
		this.datumKraja = datumKraja;
	}
	public int getRadnihDana() {
		return radnihDana;
	}
	public void setRadnihDana(int radnihDana) {
		this.radnihDana = radnihDana;
	}
	public Long getRadnikId() {
		return radnikId;
	}
	public void setRadnikId(Long radnikId) {
		this.radnikId = radnikId;
	}
	public String getRadnikNaziv() {
		return radnikNaziv;
	}
	public void setRadnikNaziv(String radnikNaziv) {
		this.radnikNaziv = radnikNaziv;
	}
	
	
}
