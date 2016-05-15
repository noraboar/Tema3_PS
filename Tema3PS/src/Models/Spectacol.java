package Models;

import java.sql.Date;

public class Spectacol {
	private String titlul;
	private String regia;
	private String distributia;
	private Date dataPremierei;
	private int numarBilete;

	public String getTitlul() {
		return titlul;
	}

	public void setTitlul(String titlul) {
		this.titlul = titlul;
	}

	public String getRegia() {
		return regia;
	}

	public void setRegia(String regia) {
		this.regia = regia;
	}

	public String getDistributia() {
		return distributia;
	}

	public void setDistributia(String distributia) {
		this.distributia = distributia;
	}

	public Date getDataPremierei() {
		return dataPremierei;
	}

	public void setDataPremierei(Date dataPremierei) {
		this.dataPremierei = dataPremierei;
	}

	public int getNumarBilete() {
		return numarBilete;
	}

	public void setNumarBilete(int numarBilete) {
		this.numarBilete = numarBilete;
	}
	
	public String toString(){
		return titlul+", \n"+dataPremierei+",\n"+regia+", "+distributia+", \n"+numarBilete;
	}

}
