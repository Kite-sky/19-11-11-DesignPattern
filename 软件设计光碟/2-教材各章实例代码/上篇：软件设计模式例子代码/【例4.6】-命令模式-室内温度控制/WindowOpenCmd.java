

class WindowOpenCmd implements Command {
        private RoomWindow window;
        public WindowOpenCmd ( RoomWindow window) {
                this.window =  window;
        }
        public void execute( ) {
                window.open( );
        }
}
