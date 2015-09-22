package calculator;

import java.awt.event.*;
import java.awt.*;
import java.awt.image.*;
import java.math.*;
import javax.swing.*;
/**
 * @author Andrew
 * @version 1.0 final
 */
public class Calculator extends JFrame implements MouseListener
{
	private int activeOperation = 0;
	private Container contentPane;
	private JLabel button[][] = new JLabel[4][5];
	private JTextField textField = new JTextField();
	private Double text = new Double(0);
	private int decimate = 0;
	private Double orginalNumber;
	private final int SIZEARRAY[] = {55,55,40,100};
	private final Icon ICONARRAY[][] = 
	{ 
			{new ImageIcon("src/jpg/clear.jpg"), new ImageIcon("src/jpg/seven.jpg"), new ImageIcon("src/jpg/four.jpg"),new ImageIcon("src/jpg/one.jpg"),new ImageIcon("src/jpg/zero.jpg"),},
			{new ImageIcon("src/jpg/squareRoot.jpg"),new ImageIcon("src/jpg/eight.jpg"),new ImageIcon("src/jpg/five.jpg"),new ImageIcon("src/jpg/two.jpg"),new ImageIcon("src/jpg/decimal.jpg")},
			{new ImageIcon("src/jpg/negate.jpg"), new ImageIcon("src/jpg/nine.jpg"), new ImageIcon("src/jpg/six.jpg"),new ImageIcon("src/jpg/three.jpg"),new ImageIcon("src/jpg/equals.jpg")},
			{new ImageIcon("src/jpg/percent.jpg"), new ImageIcon("src/jpg/div.jpg"),new ImageIcon("src/jpg/multi.jpg"),new ImageIcon("src/jpg/subtraction.jpg"),new ImageIcon("src/jpg/addition.jpg")},
	};
	/**
	 * Constructor for calculator
	 */
	public Calculator()
	{
		contentPane = getContentPane();
		setLayout(null);
		setSize(300,500);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("Calculator");
		setResizable(false);
		
		textField.setBounds(40, 40, 220, 50);
		textField.setText(Double.toString(text));
		contentPane.add(textField);
		for(int i = 0; i != 4;i++)
		{
			for(int j = 0; j != 5; j++)
			{
				button[i][j] = new JLabel();
				button[i][j].setBounds(SIZEARRAY[0]*i + SIZEARRAY[2], SIZEARRAY[1] * j + SIZEARRAY[3],50,50);
				button[i][j].addMouseListener(this);
				button[i][j].setBorder(BorderFactory.createLineBorder(Color.BLACK));
				button[i][j].setIcon(ICONARRAY[i][j]);
				contentPane.add(button[i][j]);
			}
		}
		repaint();
	}
	/**
	 * @param args array of Strings for main method
	 */
	public static void main(String[] args)
	{
		Calculator frame = new Calculator();
		frame.setVisible(true);
	}
	/**
	 * @param e MouseEvent fired when mouse clicked
	 */
	public void mouseClicked(MouseEvent e) 
	{
		if(e.getSource() instanceof JLabel)
		{
			JLabel clicked = (JLabel) e.getSource();
			clickedSwitch(clicked.getX(),clicked.getY());
		}
	}
	/**
	 * @param x the x position of the JLabel
	 * @param y the y position of the JLabel
	 */
	private void clickedSwitch(int x, int y) 
	{
		int intSwitch = x * y;
		switch(intSwitch)
		{
		case 4000: clear();
			break;
		case 9500: sqrt();
			break;
		case 15000: negate();
			break;
		case 20500: percent();
			break;
		case 31775: divide();
			break;
		case 43050: multiply();
			break;
		case 54325: subtract();
			break;
		case 65600: add();
			break;
		case 48000: equals();
			break;
		case 30400: decimal();
			break;
		case 12800: number(x,y);
			break;
		case 10600:	number(x,y);
			break;
		case 25175: number(x,y);
			break;
		case 39750: number(x,y);
			break;
		case 8400: number(x,y);
			break;
		case 19950: number(x,y);
			break;
		case 31500: number(x,y);
			break;
		case 6200: number(x,y);
			break;
		case 14725: number(x,y);
			break;
		case 23250: number(x,y);
			break;
		default:
			break;
		}
	}
	/**
	 * @param x the x position of the JLabel
	 * @param y the y position of the JLabel
	 */
	private void number(int x, int y) 
	{
		Integer number;
		if(3 *((y-SIZEARRAY[3])/SIZEARRAY[1]) == 12)
		{
			number = 0;
		}
		else
		{
			number = 10 - 3* ((y-SIZEARRAY[3])/SIZEARRAY[1]) + ((x-SIZEARRAY[2])/SIZEARRAY[0]);
		}
		if(Double.parseDouble(textField.getText()) == 0)
		{
			textField.setText(number.toString());
		}
		else if(decimate == 0)
		{
			textField.setText(Double.toString(Double.parseDouble(textField.getText()) * 10 + number));
		}
		else
		{
			textField.setText(Double.toString(Double.parseDouble(textField.getText()) + (number * Math.pow(10,0-decimate))));
			decimate++;
		}
	}
	/**was the decimal JLabel clicked */
	private void decimal() 
	{
		if(decimate == 0)
		{
			decimate = 1;
		}
	}
	/**Does active operation when equal JLabel is click or method is called*/
	private void equals() 
	{
		Double nextNumber = Double.parseDouble(textField.getText());
		switch(activeOperation)
		{
		case 1: textField.setText(Double.toString(orginalNumber + nextNumber));
			break;
		case 2: textField.setText(Double.toString(orginalNumber - nextNumber));
			break;
		case 3: textField.setText(Double.toString(orginalNumber * nextNumber));
			break;
		case 4: textField.setText(Double.toString(orginalNumber / nextNumber));
			break;
		default:
			break;			
		}
		activeOperation = 0;
	}
	/**Set activeOperation to add after previous operation */
	private void add()
	{
		equals();
		orginalNumber = Double.parseDouble(textField.getText());
		clear();
		activeOperation = 1;
	}
	/**Set activeOperation to subtract after previous operation */
	private void subtract()
	{
		equals();
		orginalNumber = Double.parseDouble(textField.getText());
		clear();
		activeOperation = 2;
	}
	/**Set activeOperation to multiply after previous operation */
	private void multiply()
	{
		equals();
		orginalNumber = Double.parseDouble(textField.getText());
		clear();
		activeOperation = 3;
	}
	/**Set activeOperation to divide after previous operation */
	private void divide()
	{
		equals();
		orginalNumber = Double.parseDouble(textField.getText());
		clear();
		activeOperation = 4;
	}
	/**finds the percentage of the text field */
	private void percent()
	{
		textField.setText(Double.toString(Double.parseDouble(textField.getText()) * 100));
	}
	/**Multiply value of text field by -1 */ 
	private void negate() 
	{
		textField.setText(Double.toString(Double.parseDouble(textField.getText()) * -1));
	}
	/**takes sqrt of text in textField */ 
	private void sqrt() 
	{
		textField.setText(Double.toString(Math.sqrt(Double.parseDouble(textField.getText()))));
	}
	/**resets calculator to zero */ 
	private void clear() 
	{
		activeOperation = 0;
		decimate = 0;
		text = 0.0;
		textField.setText(Double.toString(text));
	}
	/**Unused MouseListener method
	 * @param e a MouseEvent
	 */
	public void mouseEntered(MouseEvent e) 
	{
		
	}
	/**Unused MouseListener method
	 * @param e a MouseEvent
	 */
	public void mouseExited(MouseEvent e) 
	{
		
	}
	/**Unused MouseListener method
	 * @param e a MouseEvent
	 */
	public void mousePressed(MouseEvent e) 
	{
		
	}
	/**Unused MouseListener method
	 * @param e a MouseEvent
	 */
	public void mouseReleased(MouseEvent e) 
	{
			
	}
}
