import java.io.*;
import java.util.*;

/*=======================================================*/
/* This class incapsulates an ArrayList named lineStorage. The collection
/* here will input all the data from a text file to an ArrayList . Thus, an
/* object of this class will contain all data from the input text file
/*=======================================================*/
public class TotalSalesInfo implements SalesAggregate {
   private ArrayList<SalesDataModel> lineStorage = new ArrayList<SalesDataModel>();
   private String aFile;

   public TotalSalesInfo(String file){
      aFile = file;
      try {
         BufferedReader reader = new BufferedReader(new FileReader(aFile));
         String line = reader.readLine();
         while(line != null) {
			if (line.length() != 0) {
		       String[] arr = line.split("\\,");
	           SalesDataModel sdm = new SalesDataModel(arr[0], arr[1],arr[2],arr[3],arr[4]);
	           if(sdm != null)
			      lineStorage.add(sdm);
			}
			line = reader.readLine();
          }
       }
       catch(FileNotFoundException exc){
          exc.printStackTrace();
          System.exit(1);
       }
       catch(IOException exc){
          exc.printStackTrace();
          System.exit(1);
       }
   }
   public ArrayList getAllSalesData() {
	  return lineStorage;
   }
   public TypeIterator createTypeIterator(String type) {
      return new TypeIterator(this, type);
   }
   public DateIterator createDateIterator(String strStartDate, String strEndDate) {
      return new DateIterator(this, strStartDate, strEndDate);
   }
}






