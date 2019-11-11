/*------------------------------------------------*/
/* THis class implements interface MessageLogger  */
/* This class provides a method called            */
/*            logMsg(String msg)                  */
/* to write a message into a file called log.txt  */
/*------------------------------------------------*/



import java.util.*;

public class FileWriter implements MessageWriter {

  public void logMsg(String lastNm, String firstNm, String code) {
    FileUtil futil = new FileUtil();
    futil.writeToFile("log.txt",lastNm + " " + firstNm + " " +code, true, true);
  }
}
