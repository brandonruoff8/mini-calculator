import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.BorderLayout;
import java.awt.Font;

/**
 * Name: Brandon Ruoff
 * A frame that contains some properties of a calculator.
*/
public class CalculatorFrame extends JFrame
{
   private static final int FRAME_WIDTH = 500;
   private static final int FRAME_HEIGHT = 400;
   private static final int FIELD_WIDTH = 15;
   
   private GridLayout gridLayout = new GridLayout(4,4);
   
   Font font = new Font("SansSerif", Font.BOLD, 30);
     
   private JTextField textField;
   
   private JButton clearButton;
   private JButton equalsButton;
   
   private JButton addButton;
   private JButton subButton;
   private JButton multiButton;
   private JButton divButton;
   
   private JButton oneButton;   
   private JButton twoButton;
   private JButton threeButton;
   private JButton fourButton;
   private JButton fiveButton;
   private JButton sixButton;
   private JButton sevenButton;
   private JButton eightButton;
   private JButton nineButton;
   private JButton zeroButton;
 
   public CalculatorFrame()
   {              
      createTextField();
      createButtons();
      createButtonPanel();
      createTextPanel();

      setSize(FRAME_WIDTH, FRAME_HEIGHT);
   }

   private void createTextField()
   {
      textField = new JTextField(FIELD_WIDTH);
      textField.setText("0");
      textField.setFont(new Font("SansSerif", Font.BOLD, 30));
   }
   
   class ClearListener implements ActionListener
   {
     public void actionPerformed(ActionEvent event)
     {
    	 textField.setText("0");
     }
   } 
   
   class EqualsListener implements ActionListener
   {
      public void actionPerformed(ActionEvent event)
      {
    	  try {
	    	  String inputString = textField.getText();
	    	  String firstNumber = "";
	    	  String secondNumber = "";
	    	  char function;
	    	  char currentChar;
	    	  int length = textField.getText().length();
	    	  int index = 0;
			  currentChar = inputString.charAt(index);
			  
			  // Get the first integer
			  while((currentChar >= '0') && (currentChar <= '9')) {
				  firstNumber = firstNumber + currentChar;
				  index++;
				  currentChar = inputString.charAt(index);	  
			  }
			  
			  // Find how the user wants to use the numbers
			  function = currentChar;			  
			  
			  // Get the second integer
			  for(index = index + 1; index < length; index++) {
				  secondNumber = secondNumber + inputString.charAt(index);
			  }
			  
			  double output;
			  switch(function) {

				  case '+' : output = (Double.parseDouble(firstNumber) + Double.parseDouble(secondNumber));
				  			 textField.setText(Integer.toString((int)output));
				  			 break;
				  			 
				  case '-' : output = (Double.parseDouble(firstNumber) - Double.parseDouble(secondNumber));
				  			 textField.setText(Integer.toString((int)output));
				  			 break;
				  			 
				  case '×' : output = (Double.parseDouble(firstNumber) * Double.parseDouble(secondNumber));
				  			 textField.setText(Integer.toString((int)output));
				  			 break;
				  			 
				  case '÷' : output = (Double.parseDouble(firstNumber) / Double.parseDouble(secondNumber));
				  			 if(output == (int)output) {
				  				 textField.setText(Integer.toString((int)output));
				  				 break;
				  			 }
				  			 textField.setText(Double.toString(output));
				  			 break;
			  }			  
    	  }
    	  catch (Exception e) {
    		  textField.setText("Invalid Input");
    	  }
      }
   }
   
   class WriteListener implements ActionListener
   {
      public void actionPerformed(ActionEvent event)
      {
    	  if((textField.getText().equals("0")) || textField.getText().equals("Invalid Input")) {
        	  textField.setText("");
    	  }
    	  textField.setText(textField.getText() + ((JButton)event.getSource()).getText());
      }            
   }
   
   private void createButtons()
   {
	  clearButton = new JButton("AC");
      equalsButton = new JButton("="); 
      addButton = new JButton("+");
      subButton = new JButton("-");
      multiButton = new JButton("×");
      divButton = new JButton("÷");
      oneButton = new JButton("1");
      twoButton = new JButton("2");
      threeButton = new JButton("3");
      fourButton = new JButton("4");
      fiveButton = new JButton("5");
      sixButton = new JButton("6");
      sevenButton = new JButton("7");
      eightButton = new JButton("8");
      nineButton = new JButton("9");
      zeroButton = new JButton("0");

      ActionListener writeListener = new WriteListener();
      ActionListener clearListener = new ClearListener();
      ActionListener equalsListener = new EqualsListener();      
      
      clearButton.addActionListener(clearListener);
      equalsButton.addActionListener(equalsListener);
      addButton.addActionListener(writeListener);
      subButton.addActionListener(writeListener);
      multiButton.addActionListener(writeListener);
      divButton.addActionListener(writeListener);
      oneButton.addActionListener(writeListener);
      twoButton.addActionListener(writeListener);
      threeButton.addActionListener(writeListener);
      fourButton.addActionListener(writeListener);
      fiveButton.addActionListener(writeListener);
      sixButton.addActionListener(writeListener);
      sevenButton.addActionListener(writeListener);
      eightButton.addActionListener(writeListener);
      nineButton.addActionListener(writeListener);
      zeroButton.addActionListener(writeListener);
   }

   private void createButtonPanel()
   {
      JPanel buttonPanel = new JPanel();
      buttonPanel.setLayout(gridLayout);
      
      buttonPanel.add(sevenButton);
      sevenButton.setBackground(Color.WHITE);
      sevenButton.setFont(font);
      
      buttonPanel.add(eightButton);
      eightButton.setBackground(Color.WHITE);
      eightButton.setFont(font);
      
      buttonPanel.add(nineButton);
      nineButton.setBackground(Color.WHITE);
      nineButton.setFont(font);
         
      buttonPanel.add(addButton);
      addButton.setBackground(Color.LIGHT_GRAY);
      addButton.setFont(font);
      
      buttonPanel.add(fourButton);
      fourButton.setBackground(Color.WHITE);
      fourButton.setFont(font);
      
      buttonPanel.add(fiveButton);
      fiveButton.setBackground(Color.WHITE);
      fiveButton.setFont(font);
      
      buttonPanel.add(sixButton);
      sixButton.setBackground(Color.WHITE);
      sixButton.setFont(font);
      
      buttonPanel.add(subButton);
      subButton.setBackground(Color.LIGHT_GRAY);
      subButton.setFont(font);
      
      buttonPanel.add(oneButton);
      oneButton.setBackground(Color.WHITE);
      oneButton.setFont(font);
      
      buttonPanel.add(twoButton);
      twoButton.setBackground(Color.WHITE);
      twoButton.setFont(font);
      
      buttonPanel.add(threeButton);
      threeButton.setBackground(Color.WHITE);
      threeButton.setFont(font);
      
      buttonPanel.add(multiButton);
      multiButton.setBackground(Color.LIGHT_GRAY);
      multiButton.setFont(font);
      
      buttonPanel.add(equalsButton);
      equalsButton.setBackground(Color.CYAN);
      equalsButton.setFont(font);
      
      buttonPanel.add(zeroButton);
      zeroButton.setBackground(Color.WHITE);
      zeroButton.setFont(font);
      
      buttonPanel.add(clearButton);
      clearButton.setBackground(Color.WHITE);
      clearButton.setFont(font);
      
      buttonPanel.add(divButton);
      divButton.setBackground(Color.LIGHT_GRAY);  
      divButton.setFont(font);
      
      add(buttonPanel);
   }
   
   public void createTextPanel() {
	   JPanel textPanel = new JPanel();
	   
	   textField.setEditable(false);
	   
	   textPanel.add(textField);
	  
	   add(textPanel, BorderLayout.NORTH);
   }
}