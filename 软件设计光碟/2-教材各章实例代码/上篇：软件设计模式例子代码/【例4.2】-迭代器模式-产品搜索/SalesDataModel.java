//=====================================================
// One object of this class represents a commodity that has name,
// productType, production location, price and sale date as attributes
//=====================================================

public class SalesDataModel {
   private String productName;
   private String productType;
   private String prodCountry;
   private String prodPrice;
   private String saleDate;

   public SalesDataModel(String prodNm, String prodType, String prodCtry,
                                        String price, String sDate) {
      productName = prodNm;
      productType = prodType;
      prodCountry = prodCtry;
      prodPrice = price;
      saleDate=sDate;
   }
   public String getProductType() {
      return productType;
   }
   public String getName() {
      return productName;
   }
   public String getLocation() {
      return prodCountry;
   }
   public String getPrice() {
      return prodPrice;
   }
   public String getSaleDate() {
      return saleDate;
   }
}
