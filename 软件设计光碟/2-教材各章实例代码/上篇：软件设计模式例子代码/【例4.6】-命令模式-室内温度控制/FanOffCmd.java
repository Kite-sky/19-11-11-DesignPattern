



class FanOffCmd implements Command {
        private Fan fan;
        public FanOffCmd ( Fan fan) {
               this.fan  =  fan;
        }
        public void execute( ) {
               fan.stopRotate( );
        }
}


