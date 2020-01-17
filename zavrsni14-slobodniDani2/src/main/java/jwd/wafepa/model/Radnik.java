package jwd.wafepa.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Radnik {
	@Id
	@GeneratedValue
	@Column
	private Long id;
	@Column(nullable = false, unique = true)
	private String idBroj;
	@Column(nullable = false)
	private String imeIPrezime;
	@Column
	private String email;
	@Column
	private int godineStaza;
	@Column
	private int slobodniDani;
	@ManyToOne(fetch=FetchType.EAGER)
	private Sektor sektor;
	@OneToMany(mappedBy="radnik", cascade=CascadeType.ALL, fetch=FetchType.LAZY)
	private List<Godisnji> godisnji = new ArrayList<>();
	public Radnik() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getIdBroj() {
		return idBroj;
	}
	public void setIdBroj(String idBroj) {
		this.idBroj = idBroj;
	}
	public String getImeIPrezime() {
		return imeIPrezime;
	}
	public void setImeIPrezime(String imeIPrezime) {
		this.imeIPrezime = imeIPrezime;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getGodineStaza() {
		return godineStaza;
	}
	public void setGodineStaza(int godineStaza) {
		this.godineStaza = godineStaza;
	}
	public int getSlobodniDani() {
		return slobodniDani;
	}
	public void setSlobodniDani(int slobodniDani) {
		this.slobodniDani = slobodniDani;
	}
	public Sektor getSektor() {
		return sektor;
	}
	public void setSektor(Sektor sektor) {
		this.sektor = sektor;
		if(!sektor.getRadnici().contains(this)){
			sektor.getRadnici().add(this);
		}
	}
	public List<Godisnji> getGodisnji() {
		return godisnji;
	}
	public void setGodisnji(List<Godisnji> godisnji) {
		this.godisnji = godisnji;
	}
	public void addGodisnji(Godisnji odmor) {
		if(odmor.getRadnik() != this) {
			odmor.setRadnik(this);
		}
		godisnji.add(odmor);
	}
	
	
	

}
