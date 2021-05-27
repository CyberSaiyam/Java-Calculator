package com.CyberSaiyam;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Calculator implements ActionListener {

    JFrame frame;
    JTextField textField,textField1;
    JButton[] numberButtons = new JButton[10];
    JButton[] functionButtons = new JButton[8];

    JButton addButton, subButton, mulButton,divButton;
    JButton deciButton, equalButton, delButton, clrButton;

    JPanel panel;

    Font myFont = new Font("monospace", Font.BOLD,30);
    Font myFont2 = new Font("Calibre",Font.BOLD,24);
    double num1 = 0, num2 = 0, result = 0;
    char operator;





    Calculator(){
        frame = new JFrame("Ultimate Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(360,600);
        frame.setBackground(Color.BLACK);
        frame.setLayout(null);

//        TextField

        textField1 = new JTextField();
        textField1.setBounds(30,10,280,40);
        textField1.setFont(myFont);
        textField1.setEditable(false);



        textField = new JTextField();
        textField.setBounds(30,60,280,60);
        textField.setFont(myFont);
        textField.setEditable(false);


//        Buttons
        addButton = new JButton("+");
        subButton = new JButton("-");
        mulButton = new JButton("*");
        divButton = new JButton("/");
        deciButton = new JButton(".");
        equalButton = new JButton("=");
        delButton = new JButton("Del");
        clrButton = new JButton("Clr");

        functionButtons[0] = addButton;
        functionButtons[1] = subButton;
        functionButtons[2] = mulButton;
        functionButtons[3] = divButton;
        functionButtons[4] = deciButton;
        functionButtons[5] = equalButton;
        functionButtons[6] = delButton;
        functionButtons[7] = clrButton;

        for(int i = 0; i < 8;i++)
        {
            functionButtons[i].addActionListener(this);
            functionButtons[i].setFont(myFont);
            functionButtons[i].setFocusable(false);

        }

        for(int i = 0; i < 10;i++)
        {
            numberButtons[i] = new JButton(String.valueOf(i));
            numberButtons[i].addActionListener(this);
            numberButtons[i].setFont(myFont2);
            numberButtons[i].setFocusable(false);
        }

        delButton.setBounds(30,480,125,60);
        clrButton.setBounds(185,480,125,60);

        panel = new JPanel();
        panel.setBounds(30,140,280,300);
        panel.setLayout(new GridLayout(4,4,6,8));
        panel.setBackground(Color.cyan);


        panel.add(numberButtons[7]);
        panel.add(numberButtons[8]);
        panel.add(numberButtons[9]);
        panel.add(addButton);
        panel.add(numberButtons[4]);
        panel.add(numberButtons[5]);
        panel.add(numberButtons[6]);
        panel.add(subButton);
        panel.add(numberButtons[1]);
        panel.add(numberButtons[2]);
        panel.add(numberButtons[3]);
        panel.add(mulButton);
        panel.add(deciButton);
        panel.add(numberButtons[0]);
        panel.add(equalButton);
        panel.add(divButton);


        frame.add(panel);
        frame.add(delButton);
        frame.add(clrButton);
        frame.add(textField1);
        frame.add(textField);
        frame.setVisible(true);
    }
    public static void main(String[] args) {
	// write your code here
    Calculator calc = new Calculator();

    }
    public void actionPerformed(ActionEvent e)
    {
        for (int i = 0; i <10; i++) {
            if (e.getSource() == numberButtons[i]) {
                textField.setText(textField.getText().concat(String.valueOf(i)));
                textField1.setText(textField1.getText().concat(String.valueOf(i)));

            }
        }
        if(e.getSource()== deciButton){
            textField1.setText(textField1.getText().concat("."));
            textField.setText(textField.getText().concat("."));
        }
        if(e.getSource()==addButton){
            num1 = Double.parseDouble(textField.getText());
            operator = '+';
            textField.setText("");
            textField1.setText(textField1.getText().concat("+"));
        }
        if(e.getSource()==subButton){
            num1 = Double.parseDouble(textField.getText());
            operator = '-';
            textField.setText("");
            textField1.setText(textField1.getText().concat("-"));
        }
        if(e.getSource()==mulButton){
            num1 = Double.parseDouble(textField.getText());
            operator = '*';
            textField.setText("");
            textField1.setText(textField1.getText().concat("*"));
        }
        if(e.getSource()==divButton){
            num1 = Double.parseDouble(textField.getText());
            operator = '/';
            textField.setText("");
            textField1.setText(textField1.getText().concat("/"));
        }
        if(e.getSource()==equalButton)
        {
            num2 = Double.parseDouble(textField.getText());

            switch (operator)
            {
                case '+':
                    result = num1 + num2;
                    break;
                case '-':
                    result = num1 - num2;
                    break;
                case '*':
                    result = num1 * num2;
                    break;
                case '/':
                    result = num1 / num2;
                    break;

                default:
                    result = 0;
                    break;
            }

            textField.setText(String.valueOf(result));
            textField1.setText(String.valueOf(result));
            num1=result;
        }
        if(e.getSource()==clrButton){
            textField.setText("");
            textField1.setText("");
        }
        if(e.getSource()==delButton) {
            String string = textField.getText();
            String string2 = textField1.getText();
            textField1.setText("");
            textField.setText("");
            for (int i = 0; i < string.length() - 1; i++) {
                textField.setText(textField.getText() + string.charAt(i));
            }
            for (int i = 0;i<string2.length()-1;i++){
                textField1.setText(textField1.getText()+string.charAt(i));
            }
        }
    }
}
