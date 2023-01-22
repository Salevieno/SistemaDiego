package main;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.geom.AffineTransform;

public class DrawingOnPanel
{
	private static Graphics2D graph;

	
	public DrawingOnPanel(Graphics g)
	{
		graph = (Graphics2D) g;
	}
	
	public static void setGraphs(Graphics g)
	{
		graph = (Graphics2D) g;
	}
	
	public static void DrawText(Point pos, String text, Font font, Color color)
	{
		// by default starts at the left bottom
		AffineTransform backup = graph.getTransform() ;		
		graph.setColor(color) ;
		graph.setFont(font) ;
		graph.drawString(text, pos.x, pos.y) ;
        graph.setTransform(backup) ;
    }
}
