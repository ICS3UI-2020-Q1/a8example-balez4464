import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Main implements Runnable, ActionListener{

  // Class Variables  
  JLabel firstLabel;
  JLabel secondLabel;
  JLabel thirdLabel;

  JTextField firstInput;
  JTextField secondInput;
  JTextField thirdInput;

  JButton validateButton;
  JButton resetButton;

  JTextArea outputTextArea;
  JTextArea instructionTextArea;

  JPanel mainPanel;


  // Method to assemble our GUI
  public void run(){
    // Creats a JFrame that is 800 pixels by 600 pixels, and closes when you click on the X
    JFrame frame = new JFrame("Title");
    // Makes the X button close the program
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    // makes the windows 800 pixel wide by 600 pixels tall
    frame.setSize(800,600);
    // shows the window
    frame.setVisible(true);

    //initialize mainnpanel
    mainPanel = new JPanel();
    //tell the main panel we will do a manual layout
    mainPanel.setLayout(null);
    //add the main panel to the frame
    frame.add(mainPanel);

    //nitlaize the labels and out put text
    firstLabel = new JLabel("Enter the first side:");
    secondLabel = new JLabel("Enter the second side:");
    thirdLabel = new JLabel("Enter the third side:");

    //setting size and location for labels
    firstLabel.setBounds(10, 10, 200, 20);
    secondLabel.setBounds(10, 40, 200, 20);
    thirdLabel.setBounds(10, 70, 200, 20);


    //add the labels to the main panel
    mainPanel.add(firstLabel);
    mainPanel.add(secondLabel);
    mainPanel.add(thirdLabel);


    //create the text boxes
    firstInput = new JTextField();
    firstInput.setBounds(220, 10, 150, 20);
    secondInput = new JTextField();
    secondInput.setBounds(220, 40, 150, 20);
    thirdInput = new JTextField();
    thirdInput.setBounds(220, 70, 150, 20);

    //add the input to the panel
    mainPanel.add(firstInput);
    mainPanel.add(secondInput);
    mainPanel.add(thirdInput);


    //create the buttons
    validateButton = new JButton("Validate");
    validateButton.setBounds(380, 10, 100, 35);
    resetButton = new JButton("Reset");
    resetButton.setBounds(380, 55, 100, 35);

    //setting action comand so we know which button was pressed
    validateButton.setActionCommand("validate");
    resetButton.setActionCommand("reset");

    //add action listener to the buttons
    validateButton.addActionListener(this);
    resetButton.addActionListener(this);

    //adds buttons to panetl
    mainPanel.add(validateButton);
    mainPanel.add(resetButton);


    //creates the text ares
    outputTextArea = new JTextArea();
    outputTextArea.setBounds(10, 100, 780, 240);
    instructionTextArea = new JTextArea();
    instructionTextArea.setBounds(10, 350, 780, 240);

    //make it so they cant type in the ares
    outputTextArea.setEnabled(false);
    instructionTextArea.setEnabled(false);

    //put some text in the instructionTextArea
    instructionTextArea.setText("This is a simple Triangle detector.\nEnter an integer in each of the textfields above.\nPress the button \"Validate\" to find out whether you have made a valid triangle or not.\nPress the \"Clear\" button to clear the previous text.");

    //ad text araes to panel
    mainPanel.add(outputTextArea);
    mainPanel.add(instructionTextArea);

  }


  //a mthod to determine if a triangle is valid given the three side lengths
  public boolean isValidTriangle(int a, int b, int c){
    if(a + b > c && a + c > b && b + c > a){
      return true;
    }else{
     return false;
    }
  }


  // method called when a button is pressed
  public void actionPerformed(ActionEvent e){
    // get the command from the action
    String command = e.getActionCommand();

    //deal with the buttons being pressed
    if(command.equals("reset")){
      //reset button pressed
      //clear all of the text fields and areas
      firstInput.setText("");
      secondInput.setText("");
      thirdInput.setText("");
      outputTextArea.setText("");
    }else if(command.equals("validate")){
      //validate button wss pressed
      //get the text that the user inputs
      String firstText = firstInput.getText();
      String secondText = secondInput.getText();
      String thirdText = thirdInput.getText();

      //convert the strings into integers
      int firstSide = Integer.parseInt(firstText);
      int secondSide = Integer.parseInt(secondText);
      int thirdSide = Integer.parseInt(thirdText);

      //asks the is valid method if the tirangle works
      boolean isValid = isValidTriangle(firstSide, secondSide,thirdSide);

      //check the result
      if(isValid){
        outputTextArea.setText("This is a valid triangle");
      }else{
        outputTextArea.setText("This is an invalid triangle");
      }
    }


  }

  // Main method to start our program
  public static void main(String[] args){
    // Creates an instance of our program
    Main gui = new Main();
    // Lets the computer know to start it in the event thread
    SwingUtilities.invokeLater(gui);
  }
}
