package calculator;

import java.awt.event.*;
import java.awt.*;
import java.awt.image.*;

import javax.swing.*;


public class Calculator extends JFrame implements MouseListener
{
	private Container contentPane;
	private JLabel button[][] = new JLabel[4][5];
	private JTextField textField = new JTextField();
	private Icon iconArray[][] = 
	{ 
			{new ImageIcon("src/jpg/clear.jpg"), new ImageIcon("src/jpg/seven.jpg"), new ImageIcon("src/jpg/four.jpg"),new ImageIcon("src/jpg/one.jpg"),new ImageIcon("src/jpg/zero.jpg"),},
			{new ImageIcon("src/jpg/squareRoot.jpg"),new ImageIcon("src/jpg/eight.jpg"),new ImageIcon("src/jpg/five.jpg"),new ImageIcon("src/jpg/two.jpg"),new ImageIcon("src/jpg/decimal.jpg")},
			{new ImageIcon("src/jpg/negate.jpg"), new ImageIcon("src/jpg/nine.jpg"), new ImageIcon("src/jpg/six.jpg"),new ImageIcon("src/jpg/three.jpg"),new ImageIcon("src/jpg/equals.jpg")},
			{new ImageIcon("src/jpg/percent.jpg"), new ImageIcon("src/jpg/div.jpg"),new ImageIcon("src/jpg/multi.jpg"),new ImageIcon("src/jpg/subtraction.jpg"),new ImageIcon("src/jpg/addition.jpg")},
	};
	public Calculator()
	{
		contentPane = getContentPane();
		setLayout(null);
		setSize(300,500);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("Calculator");
		setResizable(false);
		
		textField.setBounds(40, 40, 220, 50);
		contentPane.add(textField);
		
		
		for(int i = 0; i != 4;i++)
		{
			for(int j = 0; j != 5; j++)
			{
				button[i][j] = new JLabel();
				button[i][j].setBounds(55*i + 40, 55 * j + 100,50,50);
				button[i][j].addMouseListener(this);
				button[i][j].setBorder(BorderFactory.createLineBorder(Color.BLACK));
				button[i][j].setIcon(iconArray[i][j]);
				contentPane.add(button[i][j]);
			}
		}
		repaint();
	}
	public static void main(String[] args)
	{
		Calculator frame = new Calculator();
		frame.setVisible(true);
	}
	public void mouseClicked(MouseEvent e) 
	{

	}
	public void mouseEntered(MouseEvent e) 
	{
		
		
	}
	public void mouseExited(MouseEvent e) 
	{
		// TODO Auto-generated method stub
		
	}
	public void mousePressed(MouseEvent e) 
	{
		// TODO Auto-generated method stub
		
	}
	public void mouseReleased(MouseEvent e) 
	{
		// TODO Auto-generated method stub
		
	}

}
