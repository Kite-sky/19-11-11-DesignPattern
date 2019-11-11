import java.awt.*;
import javax.swing.*;

public class CarBitView extends JFrame implements View{
    private JPanel showPanel;
    private JLabel bitOfferedLabel;
    private JTextArea bitText;
    private CarModel model;

    //public CarBitView(CarModel cmodel) throws Exception{
	public CarBitView(CarModel cmodel) {
       super("Car Bit Info View- Observer 2");
       model = cmodel;

       bitOfferedLabel = new JLabel("Latest bit offered:");
       bitText = new JTextArea(4, 20);
       bitText.setFont(new Font("Serif", Font.PLAIN, 14));
       bitText.setLineWrap(true);
       bitText.setWrapStyleWord(true);

       Container contentPane = getContentPane();
       contentPane.add(bitOfferedLabel, BorderLayout.NORTH);
       contentPane.add(bitText, BorderLayout.CENTER);

       setSize(400, 150);
       setVisible(true);
     }

	 public void update(){
       System.out.println("Car bit has been called.");
       String sCar= model.getSelectedCar();
       String pr = model.getBitPrice();
       bitText.append("\n Bit price for "+ sCar + "="+ pr);
     }
}// end of class












