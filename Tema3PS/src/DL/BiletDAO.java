package DL;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Models.Bilet;

public class BiletDAO {

	public final ArrayList<Bilet> getBilete() {
        final ArrayList<Bilet> bilete = new ArrayList<Bilet>();
        try {
            final Connection c = (Connection) DBConnection.getDBConnection();
            final Statement s = c.createStatement();
            final ResultSet rs = s.executeQuery("select * from bilet");
            while (rs.next()) {
                Bilet bilet = new Bilet();
                
                // Luam informatiile utilizatorului din baza de date
                bilet.setNumeSpectacol(rs.getString("titlul"));
                bilet.setRand(rs.getInt("rand"));
                bilet.setNumar(rs.getInt("numar"));
                
                bilete.add(bilet);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return bilete;
    }
	
	public int addBilet(Bilet bilet){
		List<Bilet> listaBilete= getBilete();
		int existaDeja=0;
		int nr=0;
		for(Bilet b:listaBilete){
			if(b.getNumeSpectacol().equals(bilet.getNumeSpectacol()) && b.getNumar()==bilet.getNumar() 
					&& b.getRand()==bilet.getRand()){
				existaDeja=1;
			}
		}
		if(existaDeja==0){
		try{
			final Connection c = (Connection) DBConnection.getDBConnection();
			final Statement s = c.createStatement();
			ResultSet rezi= s.executeQuery("SELECT MAX(id) FROM bilet");
			System.out.println(rezi);
            if(rezi.next()){
            	nr=rezi.getInt("MAX(id)");
            }
			String q="INSERT INTO bilet(id,titlul,rand,numar) VALUES ('"
					+(nr+1)+"','"+bilet.getNumeSpectacol()+"','"+bilet.getRand()+"','"+bilet.getNumar()+"');";
			Statement stmt = c.createStatement();
		     stmt.executeUpdate(q);
		} catch (ClassNotFoundException e) {
            e.printStackTrace();
		} catch(SQLException e) {
            e.printStackTrace();
        }
		}
		return existaDeja;
	}
}
