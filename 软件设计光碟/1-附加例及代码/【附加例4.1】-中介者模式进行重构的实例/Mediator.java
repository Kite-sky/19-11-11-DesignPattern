

public class Mediator
{
    private SearchButton btnSearch;
    private TraceButton btnTrace;
    private ReportButton btnReport;
    private SupportButton btnSupport;
    private FireButton btnFire;

    LblDisplay show;
    //....

    void registerSearch(SearchButton s) {
        btnSearch = s;
    }
    void registerTrace(TraceButton v) {
        btnTrace = v;
    }
    void registerReport(ReportButton b) {
        btnReport = b;
    }
    void registerSupport(SupportButton v) {
	    btnSupport = v;
    }
    void registerFire(FireButton v) {
		btnFire = v;
    }
    void registerDisplay(LblDisplay d) {
        show = d;
    }

    void search() {
       btnSearch.setEnabled(false);
       btnTrace.setEnabled(true);
       btnReport.setEnabled(true);
       btnSupport.setEnabled(true);
       btnFire.setEnabled(true);
       show.setText("System is searching for target...");
    }

    void trace() {
	   btnSearch.setEnabled(true);
	   btnTrace.setEnabled(false);
	   btnReport.setEnabled(true);
	   btnSupport.setEnabled(true);
       btnFire.setEnabled(true);
       show.setText("System is tracing the targets...");
    }
    void report() {
       btnSearch.setEnabled(true);
	   btnTrace.setEnabled(true);
	   btnReport.setEnabled(false);
	   btnSupport.setEnabled(true);
       btnFire.setEnabled(true);
       show.setText("reporting to headquarter...");
    }

    void askSupport() {
	   btnSearch.setEnabled(true);
	   btnTrace.setEnabled(true);
	   btnReport.setEnabled(true);
	   btnSupport.setEnabled(false);
       btnFire.setEnabled(true);
	   show.setText("asking for support...");
	    }
	void fire() {
	   btnSearch.setEnabled(true);
	   btnTrace.setEnabled(true);
	   btnReport.setEnabled(true);
	   btnSupport.setEnabled(true);
       btnFire.setEnabled(false);
	   show.setText("Weapons are firing...");
	    }

}