


class WindowCloseCmd implements Command {
        private GWindow window;
        public WindowCloseCmd ( GWindow window) {
                this.window  =  window;
        }
        public void execute( ) {
                window.close( );
        }
}


