package BL;

public class ExporterFactory {
	
	public Exporter getExporter(String exporterType){
	      if(exporterType == null){
	         return null;
	      }		
	      if(exporterType.equalsIgnoreCase("CSV")){
	         return new CsvExporter();
	         
	      } else if(exporterType.equalsIgnoreCase("JSON")){
	         return new JsonExporter();
	
	      }
	      return null;
	   }
}
