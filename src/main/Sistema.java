package main;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class Sistema extends JPanel implements MouseListener, MouseWheelListener
{
	private static final long serialVersionUID = 1L;

	private Dieta dieta ;
	private BaseDados baseDados ;
	
	public Sistema(Dimension panelSize)
	{
		// configuring the panel
		this.setPreferredSize(panelSize);
		addMouseWheelListener(this);
		
		dieta = new Dieta(new ImageIcon("./windowDieta.png").getImage(), new Point(100, 20)) ;
		baseDados = new BaseDados() ;
	}
	
	@Override
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g) ;
		DrawingOnPanel.setGraphs(g) ;
		dieta.display((Graphics2D) g, baseDados.getSelectedAlimento());
	}

	@Override
	public void mouseClicked(MouseEvent e)
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e)
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e)
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e)
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e)
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseWheelMoved(MouseWheelEvent e)
	{
		if (0 < e.getWheelRotation())
		{
			baseDados.incSelectedAlimento() ;
			
			repaint() ;
		}
		else
		{
			baseDados.decSelectedAlimento() ;
			
			repaint() ;
		}
		
	}
}
