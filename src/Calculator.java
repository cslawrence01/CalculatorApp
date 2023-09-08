import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Objects;

public class Calculator implements ActionListener {

    JFrame frame;
    JTextField textfield;
    JButton[] numberButtons = new JButton[10];
    JButton[] functionButtons = new JButton[9];
    JButton addButton, subButton, mulButton, divButton;
    JButton decButton, equButton, delButton, clrButton, negButton;
    JPanel panel;



    Font myFont = new Font("Ink Free", Font.BOLD, 30);
    double num1=0,num2=0,result=0;
    char operator;

    Calculator(){
        frame = new JFrame("Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 550); //this is a comment width was 420
        frame.setLayout(null);
        frame.getContentPane().setBackground(Color.BLACK);

        textfield = new JTextField();
        textfield.setBounds(50, 25, 400, 50); // width was 300
        textfield.setFont(myFont);
        textfield.setEditable(false);

        addButton = new JButton("+");
        subButton = new JButton("-");
        mulButton = new JButton("*");
        divButton = new JButton("/");
        decButton = new JButton(".");
        equButton = new JButton("=");
        delButton = new JButton("delete");
        clrButton = new JButton("Clear");
        negButton = new JButton("(-)");

        // will add the above button to the array of function buttons
        functionButtons[0] = addButton;
        functionButtons[1] = subButton;
        functionButtons[2] = mulButton;
        functionButtons[3] = divButton;
        functionButtons[4] = decButton;
        functionButtons[5] = equButton;
        functionButtons[6] = delButton;
        functionButtons[7] = clrButton;
        functionButtons[8] = negButton;

        // use a for loop to iterate through the array buttons
        for(int i = 0; i < 9; i++){
            functionButtons[i].addActionListener(this); // this refers to the current object in a method or constructor
            functionButtons[i].setFont(myFont);
            functionButtons[i].setFocusable(false); // this is so you cannot see the outline around the box
            functionButtons[i].setBackground(new java.awt.Color(247, 245, 245));
        }

        for(int i = 0; i < 10; i++){
            numberButtons[i] = new JButton(String.valueOf(i));
            numberButtons[i].addActionListener(this); // this refers to the current object in a method or constructor
            numberButtons[i].setFont(myFont);
            numberButtons[i].setFocusable(false); // this is so you cannot see the outline around the box
            numberButtons[i].setBackground(new java.awt.Color(247, 245, 245));
        }

        negButton.setBounds(50, 430, 125, 50);
        delButton.setBounds(190, 430, 125, 50);
        clrButton.setBounds(325, 430, 125, 50); // x was 250, width was 100

        // setting up the panel that will hold the function and number Buttons
        panel = new JPanel();
        panel.setBounds(50, 100, 400, 300); // width was 300
        panel.setLayout(new GridLayout(4, 4, 10, 10)); // this is a 4 by 4 grid, 10 is the space between the buttons
        panel.setBackground(Color.BLACK); // can delete this line if necessary

        panel.add(numberButtons[1]);
        panel.add(numberButtons[2]);
        panel.add(numberButtons[3]);
        panel.add(addButton);
        panel.add(numberButtons[4]);
        panel.add(numberButtons[5]);
        panel.add(numberButtons[6]);
        panel.add(subButton);
        panel.add(numberButtons[7]);
        panel.add(numberButtons[8]);
        panel.add(numberButtons[9]);
        panel.add(mulButton);
        panel.add(decButton);
        panel.add(numberButtons[0]);
        panel.add(equButton);
        panel.add(divButton);

        frame.add(panel);
        frame.add(negButton); // create separation, add add button in specified location
        frame.add(delButton);
        frame.add(clrButton);
        frame.add(textfield);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        Calculator calc = new Calculator();

    }

    @Override
    public void actionPerformed(ActionEvent e){
        for (int i=0; i<10; i++){
            if (e.getSource() == numberButtons[i]) {
                textfield.setText(textfield.getText().concat(String.valueOf(i)));
            }
        }
        if (e.getSource() == decButton) {
            textfield.setText(textfield.getText().concat("."));
        }
        if (e.getSource() == addButton) {
            // if what is in the textfield is empty, print something out
            if (textfield.getText().isEmpty()) {
                //System.out.println("Invalid format used");
                JOptionPane.showMessageDialog(frame, "Invalid format used");
            } else {
                num1 = Double.parseDouble(textfield.getText());
                operator = '+';
                textfield.setText("");
            }
        }
        if (e.getSource() == subButton) {
            if (textfield.getText().isEmpty()){
                //System.out.println("Invalid format used");
                JOptionPane.showMessageDialog(frame, "Invalid format used");
            } else {
                num1 = Double.parseDouble(textfield.getText());
                operator = '-';
                textfield.setText("");
            }
        }
        if (e.getSource() == mulButton) {
            if (textfield.getText().isEmpty()){
                //System.out.println("Invalid format used");
                JOptionPane.showMessageDialog(frame, "Invalid format used");
            } else {
                num1 = Double.parseDouble(textfield.getText());
                operator = '*';
                textfield.setText("");
            }
        }
        if (e.getSource() == divButton) {
            if (textfield.getText().isEmpty()){
                //System.out.println("Invalid format used");
                JOptionPane.showMessageDialog(frame, "Invalid format used");
            } else {
                num1 = Double.parseDouble(textfield.getText());
                operator = '/';
                textfield.setText("");
            }
        }
        if (e.getSource() == equButton) {
            if (textfield.getText().isEmpty()){
                //System.out.println("Invalid format used");
                JOptionPane.showMessageDialog(frame, "Invalid format used");
            } else {
                num2 = Double.parseDouble(textfield.getText());

                switch(operator) {
                    case'+':
                        result=num1+num2;
                        break;
                    case'-':
                        result=num1-num2;
                        break;
                    case'*':
                        result=num1*num2;
                        break;
                    case'/':
                        result=num1/num2;
                        break;
            }
            }
            textfield.setText(String.valueOf(result));
            num1 = result;
        }
        if (e.getSource() == clrButton) {
            textfield.setText("");
        }
        if (e.getSource() == delButton) {
            String string = textfield.getText();
            textfield.setText("");
            for(int i=0; i < string.length() - 1; i++) {
                textfield.setText(textfield.getText() + string.charAt(i));
            }
        }
        if (e.getSource() == negButton) {
            if (textfield.getText().isEmpty()){
                //System.out.println("Invalid format used");
                JOptionPane.showMessageDialog(frame, "Invalid format used");
            } else {
                double temp = Double.parseDouble(textfield.getText());
                temp *= -1;
                textfield.setText(String.valueOf(temp));
            }
            }
        }

    }

