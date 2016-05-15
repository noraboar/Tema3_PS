package BL;

import java.util.List;

import DL.BiletDAO;
import Models.Bilet;

public class BiletManager {
	
	private BiletDAO biletDAO=new BiletDAO();
	
	public int addBilet(Bilet bilet){
		return biletDAO.addBilet(bilet);
	}
	
	public List<Bilet> getBilete(){
		return biletDAO.getBilete();
	}
}
