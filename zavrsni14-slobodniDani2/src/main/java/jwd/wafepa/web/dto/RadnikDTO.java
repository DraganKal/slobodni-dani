package jwd.wafepa.web.dto;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

public class RadnikDTO {

	private Long id;
	@Size(min = 5, max = 5)
	private String idBroj;
	@NotEmpty
	private String imeIPrezime;
	@Email
	private String email;
	
	private int godineStaza;
	
	private int slobodniDani;
	
	private Long sektorId;
	private String sektorNaziv;
	public RadnikDTO() {
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
	public Long getSektorId() {
		return sektorId;
	}
	public void setSektorId(Long sektorId) {
		this.sektorId = sektorId;
	}
	public String getSektorNaziv() {
		return sektorNaziv;
	}
	public void setSektorNaziv(String sektorNaziv) {
		this.sektorNaziv = sektorNaziv;
	}
	
	
	
	
}
