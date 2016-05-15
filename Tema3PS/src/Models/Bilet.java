package Models;

public class Bilet {
	private String numeSpectacol;
	private int numar;
	private int rand;
	
	public Bilet(){
		
	}
	
	public Bilet(String numeSpectacol, int numar, int rand){
		this.numeSpectacol=numeSpectacol;
		this.numar=numar;
		this.rand=rand;
	}

	public String getNumeSpectacol() {
		return numeSpectacol;
	}

	public void setNumeSpectacol(String numeSpectacol) {
		this.numeSpectacol = numeSpectacol;
	}

	public int getNumar() {
		return numar;
	}

	public void setNumar(int numar) {
		this.numar = numar;
	}

	public int getRand() {
		return rand;
	}

	public void setRand(int rand) {
		this.rand = rand;
	}
	
	public String toString(){
		return numeSpectacol+", Rand: "+rand+", Loc: "+numar;
	}

}
