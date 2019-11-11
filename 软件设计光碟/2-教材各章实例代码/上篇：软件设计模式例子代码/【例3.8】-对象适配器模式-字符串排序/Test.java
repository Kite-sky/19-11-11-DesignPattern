


public class Test
{
   public static void main(String[] args)
   {
      StrArraySortAdapter adapt = new StrArraySortAdapter();
      String[] input = adapt.inputFromFile("china.txt");
	  String[] sorted = adapt.sortStringArray(input);

	  for ( int k = 0; k < sorted.length; k++ )
	     System.out.println(sorted[k]);
   }
}