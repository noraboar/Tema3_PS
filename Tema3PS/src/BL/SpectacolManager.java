package BL;

import java.util.List;

import DL.SpectacolDAO;
import Models.Spectacol;

public class SpectacolManager {

	private SpectacolDAO spectacolDAO=new SpectacolDAO();
	
	public void addSpectacol(Spectacol spectacol){
		spectacolDAO.addSpectacol(spectacol);
	}
	
	public void deleteSpectacol(Spectacol spectacol){
		spectacolDAO.deleteSpectacol(spectacol);
	}
	
	public List<Spectacol> getSpectacole(){
		return spectacolDAO.getSpectacole();
	}
	
	public void updateSpectacol(Spectacol spectacolVechi,Spectacol spectacolNou){
		spectacolDAO.updateSpectacol(spectacolVechi,spectacolNou);
	}
	
}
