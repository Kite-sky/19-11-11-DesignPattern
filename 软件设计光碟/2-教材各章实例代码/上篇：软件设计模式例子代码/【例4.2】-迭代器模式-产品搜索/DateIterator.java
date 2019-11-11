import java.util.*;
import java.lang.Float;

/*==============================================================*/
/* This class represents an iterator that is designed for iterating through a
/* collection of type SalesDataModel. The purpose is to search for lines with
/* sale date between users inputs strStartDate, and strEndDate.When an object of
/* DateIterator is created,an instance of TotalSalesInfo,  strStartDate and strEndDate
/* are passed to this SalesIterator object. Method hasNext() is responsible for finding
/* the data items that match the date period.
/*==============================================================*/

public class DateIterator implements TextFileIterator {
   private TotalSalesInfo allSalesInfo;
   private SalesDataModel nextProduct;
   private String strStartDate;
   private String strEndDate;
   private ArrayList saleList;
   private float salesTotal;
   private int lowBound=0;

   public DateIterator(TotalSalesInfo allSalesInfo, String strStartDate, String strEndDate){
      this.allSalesInfo = allSalesInfo;
      this.strStartDate = strStartDate;
      this.strEndDate = strEndDate;

      saleList = allSalesInfo.getAllSalesData();
   }
   public boolean hasNext() {
      boolean matchFound = false;

      //Find a line whose sale date is betwen strStartDate and strEndDate
      for( int n = lowBound; n < saleList.size(); n++ ){
	     SalesDataModel aProduct = (SalesDataModel) saleList.get(n);
	     String strSoldDate = aProduct.getSaleDate();
	     int intSoldDate = Integer.parseInt(strSoldDate);
	     int intStartDate = Integer.parseInt(strStartDate);
	     int intEndDate = Integer.parseInt(strEndDate);

	     if ( (intSoldDate>=intStartDate) && (intSoldDate<=intEndDate) ) {
			salesTotal = salesTotal + Float.valueOf(aProduct.getPrice());
		    matchFound = true;
		    nextProduct = aProduct;
		    lowBound = n+1;
		    break;
         }
      }
      if (matchFound == true)
	     return matchFound;
	  else
	     nextProduct = null;
      return matchFound;
  }
  public SalesDataModel next(){
     if (nextProduct == null)
        throw new NoSuchElementException();
     else
        return nextProduct;
  }
  public void remove() {
     saleList.remove(nextProduct);
  }
  public  float getPriceTotal(){
     return salesTotal;
  }
}
