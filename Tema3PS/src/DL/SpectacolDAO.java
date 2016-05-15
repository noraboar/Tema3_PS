package DL;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Models.Spectacol;

public class SpectacolDAO {

	public final ArrayList<Spectacol> getSpectacole() {
        final ArrayList<Spectacol> spectacole = new ArrayList<Spectacol>();
        try {
            final Connection c = (Connection) DBConnection.getDBConnection();
            final Statement s = c.createStatement();
            final ResultSet rs = s.executeQuery("select * from spectacol");
            while (rs.next()) {
                Spectacol spectacol = new Spectacol();
                
                // Luam informatiile utilizatorului din baza de date
                spectacol.setRegia(rs.getString("regia"));
                spectacol.setDataPremierei(rs.getDate("datapremierei"));
                spectacol.setNumarBilete(rs.getInt("numarBilete"));
                spectacol.setTitlul(rs.getString("titlul"));
                spectacol.setDistributia(rs.getString("distributia"));
                spectacole.add(spectacol);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return spectacole;
    }
	
	public void addSpectacol(Spectacol spectacol){
		try{
			final Connection c = (Connection) DBConnection.getDBConnection();
			String s="INSERT INTO spectacol(regia,datapremierei,numarBilete,titlul,distributia) VALUES ('"
					+spectacol.getRegia()+"','"+spectacol.getDataPremierei()+"','"+spectacol.getNumarBilete()
					+"','"+spectacol.getTitlul()+"','"+spectacol.getDistributia()+"');";
			Statement stmt = c.createStatement();
		     stmt.executeUpdate(s);
		} catch (ClassNotFoundException e) {
            e.printStackTrace();
		} catch(SQLException e) {
            e.printStackTrace();
        }

	}
	
	public void deleteSpectacol(Spectacol spectacol){
		try{
			final Connection c = (Connection) DBConnection.getDBConnection();
			String sb="DELETE FROM bilet WHERE titlul='"+spectacol.getTitlul()+"';";
			String s="DELETE FROM spectacol WHERE titlul='"+spectacol.getTitlul()+"';";
			Statement stmt = c.createStatement();
			stmt.executeUpdate(sb);
		     stmt.executeUpdate(s);
		} catch (ClassNotFoundException e) {
            e.printStackTrace();
		} catch(SQLException e) {
            e.printStackTrace();
        }
	}
	
	public void updateSpectacol(Spectacol spectacolVechi,Spectacol spectacolNou){
		try{
			final Connection c = (Connection) DBConnection.getDBConnection();
			String s="UPDATE spectacol SET distributia='"+spectacolNou.getDistributia()
					+"', regia='"+spectacolNou.getRegia()+"', datapremierei='"
					+spectacolNou.getDataPremierei()+"', numarBilete='"+spectacolNou.getNumarBilete()
					+"' WHERE titlul='"+spectacolVechi.getTitlul()+"';";
			Statement stmt = c.createStatement();
		     stmt.executeUpdate(s);
		} catch (ClassNotFoundException e) {
            e.printStackTrace();
		} catch(SQLException e) {
            e.printStackTrace();
        }
	}
	
}
