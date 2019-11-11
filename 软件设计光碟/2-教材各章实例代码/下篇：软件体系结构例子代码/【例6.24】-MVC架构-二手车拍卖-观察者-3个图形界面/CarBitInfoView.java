import java.awt.*;
import javax.swing.*;


public class CarBitInfoView extends JFrame implements Observer{
    private JLabel bitLabel;
    private JTextArea bitText;
    private CarModel model;
    private JScrollPane textPane;

	public CarBitInfoView(CarModel cmodel) {
       super("Car Bit Info View- Observer 2");
       model = cmodel;

       bitLabel = new JLabel("Bits offered:");
       bitText = new JTextArea(4, 20);
       bitText.setFont(new Font("Serif", Font.PLAIN, 14));
       bitText.setLineWrap(true);
       bitText.setWrapStyleWord(true);

       JScrollPane textPane = new JScrollPane(bitText);

       Container contentPane = getContentPane();
       contentPane.add(bitLabel, BorderLayout.NORTH);
       contentPane.add(textPane, BorderLayout.CENTER);

       setSize(400, 150);
       setVisible(true);
     }

     public void update(Observable subject){
       if ( (subject == model) && (model.isBitBtnClicked())){
          String sCar= model.getSelectedCar();

          String pr = model.getBitPrice();
          bitText.append("\n Bit price for "+ sCar + "="+ pr);
       }
     }
}// end of class
