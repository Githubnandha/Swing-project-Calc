import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class CalcSwing implements ActionListener {
	JFrame frame;
	JTextField textfield;
	JButton[] numbersButtons = new JButton[10];
	JButton[] functionButtons = new JButton[10];
	JButton addButton, subButton, mulButton, divButton;
	JButton decButton, equButton, delButton, clrButton;
	JPanel panel;
	
	double num1 = 0,num2 = 0 ,result=0;
	char operator;
	
	CalcSwing() {
        frame = new JFrame("Calculator");
        frame.setSize(420,550);
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        textfield = new JTextField();
        textfield.setBounds(50,40,300,50);
        textfield.setEditable(false);

        addButton= new JButton("+");
        subButton = new JButton("-");
        mulButton = new JButton("x");
        divButton = new JButton("/");
        decButton = new JButton(".");
        equButton = new JButton("=");
        delButton = new JButton("<-");
        clrButton= new JButton("clr");

        functionButtons[0] = addButton;
        functionButtons[1] = subButton;
        functionButtons[2] = mulButton;
        functionButtons[3] = divButton;
        functionButtons[4] = decButton;
        functionButtons[5] = equButton;
        functionButtons[6] = delButton;
        functionButtons[7] = clrButton;

        for (int i=0;i<8;i++) {
        	functionButtons[i].addActionListener(this);
        }

        for(int i=0;i<10;i++) {
        	numbersButtons[i] = new JButton(String.valueOf(i));
        	numbersButtons[i].addActionListener(this);
        }

        delButton.setBounds(50,430,145,50);
        clrButton.setBounds(205,430,145,50);

        panel = new JPanel();
        panel.setBounds(50,100,300,300);
        panel.setLayout(new GridLayout(4,4,10,10));
        panel.setBackground(Color.white);

        panel.add(numbersButtons[1]);
        panel.add(numbersButtons[2]);
        panel.add(numbersButtons[3]);
        panel.add(addButton);
        panel.add(numbersButtons[4]);
        panel.add(numbersButtons[5]);
        panel.add(numbersButtons[6]);
        panel.add(subButton);
        panel.add(numbersButtons[7]);
        panel.add(numbersButtons[8]);
        panel.add(numbersButtons[9]);
        panel.add(mulButton);
        panel.add(decButton);
        panel.add(numbersButtons[0]);
        panel.add(equButton);
        panel.add(divButton);


        frame.add(panel);
        frame.add(textfield);
        frame.add(delButton);
        frame.add(clrButton);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
       for(int i=0;i<10;i++){
       	 if(e.getSource() == numbersButtons[i]) {
       	 	textfield.setText(textfield.getText().concat(String.valueOf(i)));
       	 }
       }
       if(e.getSource() == decButton) {
       	 textfield.setText(textfield.getText().concat(String.valueOf(".")));
       }
       if(e.getSource() == addButton) {
       	 num1 = Double.parseDouble(textfield.getText());
       	 operator = '+';
       	 textfield.setText("");
       }
       if(e.getSource() == subButton) {
       	 num1 = Double.parseDouble(textfield.getText());
       	 operator = '-';
       	 textfield.setText("");
       }
       if(e.getSource() == mulButton) {
       	 num1 = Double.parseDouble(textfield.getText());
       	 operator = '*';
       	 textfield.setText("");
       }
       if(e.getSource() == divButton) {
       	 num1 = Double.parseDouble(textfield.getText());
       	 operator = '/';
       	 textfield.setText("");
       }
       if(e.getSource() == equButton) {
       	 num2 = Double.parseDouble(textfield.getText());
       	 switch(operator) {
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
       	 }
       	 textfield.setText(String.valueOf(result));
       	 num1 = result;
       }
       if(e.getSource() == clrButton) {
       	 textfield.setText("");
       }
       if(e.getSource() == delButton) {
       	String str = textfield.getText();
       	textfield.setText("");
       	for(int i=0;i<str.length()-i;i++){
       		textfield.setText(textfield.getText()+str.charAt(i));
       	}
       }
	}

	public static void main(String[] args) {
       CalcSwing obj = new CalcSwing();
	}
}