import javax.swing.JFrame;

public class CalculatorDriver {

	   public static void main(String[] args)
	   {  
	      JFrame frame = new CalculatorFrame();
	      frame.setTitle("Calculator");
	      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	      frame.setVisible(true);
	   }
}