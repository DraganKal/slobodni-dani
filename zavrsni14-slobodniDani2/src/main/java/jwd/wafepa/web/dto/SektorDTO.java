package jwd.wafepa.web.dto;


public class SektorDTO {
	
	private Long id;
	
	private String naziv;
	
	private int bonusDana;

	public SektorDTO() {
		super();
		// TODO Auto-generated constructor stub
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
	
	
}
