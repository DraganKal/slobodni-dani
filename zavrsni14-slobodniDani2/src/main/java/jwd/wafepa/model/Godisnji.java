package jwd.wafepa.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Godisnji {
	@Id
	@GeneratedValue
	@Column
	private Long id;
	@Column(nullable = false)
	private String datumPocetka;
	@Column
	private String datumKraja;
	@Column
	private int radnihDana;
	@ManyToOne(fetch=FetchType.EAGER)
	private Radnik radnik;
	public Godisnji() {
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
	public Radnik getRadnik() {
		return radnik;
	}
	public void setRadnik(Radnik radnik) {
		this.radnik = radnik;
		if(!radnik.getGodisnji().contains(this)){
			radnik.getGodisnji().add(this);
		}
	}
	
	

}
