




class WindowOpenCmd implements Command {
        private GWindow window;
        public WindowOpenCmd ( GWindow window) {
                this.window =  window;
        }
        public void execute( ) {
                window.open( );
        }
}
