package jwd.wafepa.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Sektor {
	@Id
	@GeneratedValue
	@Column
	private Long id;
	@Column(nullable = false, unique = true)
	private String naziv;
	@Column(nullable = false)
	private int bonusDana;
	@OneToMany(mappedBy="sektor", cascade=CascadeType.ALL, fetch=FetchType.LAZY)
	private List<Radnik> radnici = new ArrayList<>();
	
	
	public Sektor() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Sektor(String naziv, int bonusDana) {
		super();
		this.naziv = naziv;
		this.bonusDana = bonusDana;
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNaziv() {
		return naziv;
	}
	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}
	public int getBonusDana() {
		return bonusDana;
	}
	public void setBonusDana(int bonusDana) {
		this.bonusDana = bonusDana;
	}
	public List<Radnik> getRadnici() {
		return radnici;
	}
	public void setRadnici(List<Radnik> radnici) {
		this.radnici = radnici;
	}
	public void addRadnik(Radnik radnik) {
		if(radnik.getSektor() != this) {
			radnik.setSektor(this);
		}
		radnici.add(radnik);
	}
	

}
