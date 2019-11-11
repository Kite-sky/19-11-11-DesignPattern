



class FanOffCmd implements Command {
        private GFan fan;
        public FanOffCmd ( GFan fan) {
               this.fan  =  fan;
        }
        public void execute( ) {
               fan.stopRotate( );
        }
}


