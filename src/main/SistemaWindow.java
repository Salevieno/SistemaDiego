package main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Point;

public class SistemaWindow
{
	private Image image ;
	private Point bottomLeftPos ;	
	
	
	public SistemaWindow(Image image, Point bottomLeftPos)
	{
		this.image = image;
		this.bottomLeftPos = bottomLeftPos;
	}
	

	public void display(Graphics2D graph, Alimento alimento)
	{
		Font font = new Font(Main.font.getName(), Font.BOLD, 13) ;
		if (image != null)
		{
			Dimension size = new Dimension(image.getWidth(null), image.getHeight(null)) ;
			graph.drawImage(image, bottomLeftPos.x, bottomLeftPos.y, size.width, size.height, null) ;
		}
		DrawingOnPanel.DrawText(new Point(60, 60), alimento.getDados().get(0), font, Color.blue);
		
		int posY = 60 ;
		for (String dado : alimento.getDados())
		{
			if (!dado.equals(alimento.getDados().get(0)))
			{
				DrawingOnPanel.DrawText(new Point(200, posY), dado, font, Color.black);
				posY += 20 ;
			}
		}
	}
}
