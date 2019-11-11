import java.util.*;
import java.lang.Float;

/*==========================================================*/
/* This class represents an iterator that is designed for iterating through
/* a collection of type SalesDataModel. The purpose is to search for lines
/*  with userQueryProductType.  When an object of SalesIterator is created,
/* an instance of TotalSalesInfo and userQueryProductType are passed
/* to this SalesIterator object. Method hasNext() is responsible for finding the
/* data items that match the userQueryProductType
/*==========================================================*/
public class TypeIterator implements TextFileIterator {
   private int lowBound=0;
   private TotalSalesInfo allSalesInfo;
   private String userQueryProductType;
   private SalesDataModel nextProduct;
   private ArrayList saleList;
   private float salesTotal;

   public TypeIterator(TotalSalesInfo allSalesInfo, String userQueryProductType){
      this.allSalesInfo = allSalesInfo;
      this.userQueryProductType = userQueryProductType;
      saleList = allSalesInfo.getAllSalesData();
   }
   public boolean hasNext() {
      boolean matchFound = false;

      //If the product type of nextProduct is exactly
      //the one that matchs the user-queried type, then
      //break the "for" loop below, and return matchFound
      for( int n = lowBound; n < saleList.size(); n++ ){
	     SalesDataModel aProduct = (SalesDataModel) saleList.get(n);
	     String candidateProdType = aProduct.getProductType();

	     if ( candidateProdType.compareTo( userQueryProductType) == 0 ) {
            salesTotal = salesTotal + Float.valueOf(aProduct.getPrice());
		    matchFound = true;
		    nextProduct = aProduct;
		    lowBound = n+1;
		    break;
         }
      }
      if (matchFound == true){
	     return matchFound;
	  }
	  else {
	     nextProduct = null;
	  }
      return matchFound;
  }
  public SalesDataModel next(){
     if (nextProduct == null) {
        throw new NoSuchElementException();
     }
     else {
        return nextProduct;
     }
  }
  public void remove() {
     saleList.remove(nextProduct);
  }
  public  float getPriceTotal(){
         return salesTotal;
  }
}
