package main;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Point;

import javax.swing.JFrame;

public class Main extends JFrame
{
	private static final long serialVersionUID = 1L;
	private Point windowLocation ;
	private Dimension windowSize ;
	
	protected static Font font ;

	public Main()
	{
		windowLocation = new Point(200, 100) ;
		windowSize = new Dimension(800, 600) ;
		font = new Font("Sans serif", Font.BOLD, 20) ;
		this.add(new Sistema(windowSize)) ;
		initJFrame(windowLocation, windowSize) ;
	}
	
	private void initJFrame(Point windowLocation, Dimension windowSize)
	{
		this.setTitle("Sistema nutri") ;
		this.setLocation(windowLocation) ;
		this.setPreferredSize(windowSize) ;
		this.pack() ;
		this.setVisible(true) ;
		this.setDefaultCloseOperation(EXIT_ON_CLOSE) ;
	}
	
	public static void main(String[] args)
	{
		new Main() ;
	}
}