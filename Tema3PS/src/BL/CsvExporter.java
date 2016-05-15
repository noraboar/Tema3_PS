package BL;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import Models.Bilet;

public class CsvExporter implements Exporter{

	@Override
	public void exportBilete(List<Bilet> listaBilete) {
		try{
			FileWriter writer = new FileWriter("Bilete.csv");
			for(Bilet bilet : listaBilete){
			     writer.append(bilet.getNumeSpectacol());
			     writer.append(" Randul: ");
			     writer.append(String.valueOf(bilet.getRand()));
			     writer.append(" Locul: ");
			     writer.append(String.valueOf(bilet.getNumar()));
			     writer.append("\n");
			}
		    writer.flush();
		    writer.close();
		}catch(IOException e)
		{
		     e.printStackTrace();
		}
	
	}

}
