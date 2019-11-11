


class WindowCloseCmd implements Command {
        private RoomWindow window;
        public WindowCloseCmd ( RoomWindow window) {
                this.window  =  window;
        }
        public void execute( ) {
                window.close( );
        }
}


