
import java.util.Arrays;


/*--------------------------------------------------*/
/* This class shows the one use of the adapter      */
/* pattern. This class use object adapter pattern   */
/* to draw 2 objects in to this class, one object   */
/* of class Arrays to do sorting of a String array, */
/* and another object of class InputFile to input   */
/* a text file. The two methods                     */
/*        inputFromFile(String str), and            */
/*        sortStringArray(String[] array)           */
/* are formed by wrapping the corresponding         */
/* methods inside                                   */
/*--------------------------------------------------*/

interface StrArraySortInterface
{
   abstract String[] inputFromFile(String str);
   abstract String[] sortStringArray(String[] array);
}