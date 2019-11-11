
 /*======================================================*/
 /* This is the State class in the State pattern. This   */
 /* class has 9 subclasses TaxState1,...,TaxState9.      */
 /* Pay attention that this class hierarcgy is used by   */
 /* class TaxContext class. and this class also call     */
 /* TaxContext class.                                    */
 /* Adding or modifying a subclass of the TaxState class */
 /* hierarchy will not affact the TaxContext class       */
 /*======================================================*/

 public abstract class TaxState {

    protected double taxable =0;
    protected String state;
    protected TaxState stateObj;

    protected static final String STATE1="State1";
    protected static final String STATE2="State2";
    protected static final String STATE3="State3";
    protected static final String STATE4="State4";
    protected static final String STATE5="State5";
    protected static final String STATE6="State6";
    protected static final String STATE7="State7";
    protected static final String STATE8="State8";
    protected static final String STATE9="State9";

    protected static final double s0 = 0;
    protected static final double s1 = 500;
    protected static final double s2 = 2000;
    protected static final double s3 = 5000;
    protected static final double s4 = 20000;
	protected static final double s5 = 40000;
	protected static final double s6 = 60000;
    protected static final double s7 = 80000;
    protected static final double s8 = 100000;

    protected TaxContext context;

    public TaxState(TaxContext context){
	   this.context = context;
	}

    public void changeState(double taxable){
	   if(taxable > s0 && taxable <= s1)
	      state = STATE1;
	   else if(taxable > s1 && taxable <= s2)
	      state = STATE2;
	   else if(taxable > s2 && taxable <= s3)
	      state = STATE3;
	   else if(taxable > s3 && taxable <= s4)
	      state = STATE4;
	   else if(taxable > s4 && taxable <= s5)
	      state = STATE5;
	   else if(taxable > s5 && taxable <= s6)
	      state = STATE6;
	   else if(taxable > s6 && taxable <= s7)
	      state = STATE7;
	   else if(taxable > s7 && taxable <= s8)
	      state = STATE8;
	   else if(taxable > s8)
	      state = STATE9;
     }

    public TaxState getStateObj(){
	   if(state.equals(STATE1))
	      stateObj = new TaxState1(context);
	   else if (state.equals(STATE2))
	      stateObj = new TaxState2(context);
	   else if (state.equals(STATE3))
	      stateObj = new TaxState3(context);
	   else if (state.equals(STATE4))
	      stateObj = new TaxState4(context);
	   else if (state.equals(STATE5))
	      stateObj = new TaxState5(context);
	   else if (state.equals(STATE6))
	      stateObj = new TaxState6(context);
	   else if (state.equals(STATE7))
	      stateObj = new TaxState7(context);
	   else if (state.equals(STATE8))
	   	  stateObj = new TaxState8(context);
	   else if (state.equals(STATE9))
	   	  stateObj = new TaxState9(context);

	   return stateObj;
	}
	public String getState()  {
	    return state;
    }

    public abstract double calculateTax(String kind, double amount);
}
