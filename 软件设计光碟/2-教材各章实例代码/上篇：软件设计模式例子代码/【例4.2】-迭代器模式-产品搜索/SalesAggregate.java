
// An aggregation interface for the class TotalSalesInfo
// to implement

public interface SalesAggregate {
   public abstract TypeIterator createTypeIterator(String type);
   public abstract DateIterator createDateIterator(String strStartDate, String strEndDate );

}