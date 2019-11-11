
public class Client {
     public static void main(String[] args) {
           Fan  fan = new Fan( );
           FanOnCmd fanOnCmd = new FanOnCmd(fan);
           Invoker invoker1 = new Invoker( fanOnCmd);
           invoker1.callCommand( );

           FanOffCmd fanOffCmd = new FanOffCmd(fan);
           Invoker invoker2 = new Invoker( fanOffCmd);
           invoker2.callCommand( );


           RoomWindow window = new RoomWindow( );
           WindowOpenCmd  woCmd = new WindowOpenCmd(window);
           Invoker invoker3 = new Invoker(woCmd);
           invoker3.callCommand( );

		    WindowCloseCmd  wcCmd = new WindowCloseCmd(window);
		    Invoker invoker4 = new Invoker(wcCmd);
            invoker4.callCommand( );
     }
}
