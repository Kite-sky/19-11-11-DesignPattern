

class FanOnCmd implements Command{
        private Fan fan;
        public FanOnCmd ( Fan fan) {
                this.fan  =  fan;
        }
        public void execute( ) {
                fan.startRotate( );
        }
}
