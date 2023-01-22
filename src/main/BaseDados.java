package main;

import java.awt.Color;
import java.awt.Font;
import java.awt.Point;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BaseDados
{
	private List<Alimento> alimentos ;
	private Alimento selectedAlimento ;
	private String[] titles ;
	
	public BaseDados()
	{
		alimentos = new ArrayList<>() ;
		ArrayList<String[]> dados = ReadcsvFile("./BaseDados.csv") ;
		titles = dados.get(0) ;
		dados.remove(titles) ;
		for (String[] dado : dados)
		{
			alimentos.add(new Alimento(Arrays.asList(dado))) ;
		}
		selectedAlimento = alimentos.get(0) ;
	}
	
	
	
	public Alimento getSelectedAlimento()
	{
		return selectedAlimento;
	}



	public void incSelectedAlimento()
	{
		int selectedAlimentoID = alimentos.indexOf(selectedAlimento) ;
		if (selectedAlimentoID <= alimentos.size() - 1)
		{
			selectedAlimento = alimentos.get(selectedAlimentoID + 1) ;
		}
	}
	
	public void decSelectedAlimento()
	{
		int selectedAlimentoID = alimentos.indexOf(selectedAlimento) ;
		if (1 <= selectedAlimentoID)
		{
			selectedAlimento = alimentos.get(selectedAlimentoID - 1) ;
		}
	}

	
	public static ArrayList<String[]> ReadcsvFile(String FileName)
	{
		BufferedReader br = null ;
        String line = "" ;
        String separator = "," ;
        ArrayList<String[]> Input = new ArrayList<String[]>() ;
        try 
        {
            br = new BufferedReader(new FileReader(FileName, Charset.forName("UTF-8"))) ;
            while ((line = br.readLine()) != null) 
            {
                Input.add(line.split(separator)) ;
            }
        } 
        catch (FileNotFoundException e) 
        {
            e.printStackTrace() ;
        }
        catch (IOException e)
        {
            e.printStackTrace() ;
        }
        finally
        {
            if (br != null)
            {
                try
                {
                    br.close() ;
                }
                catch (IOException e)
                {
                    e.printStackTrace() ;
                }
            }
        }
        return Input ;
	}
	
	public void display()
	{
		Font font = new Font(Main.font.getName(), Font.BOLD, 13) ;
		
		int posX = 20 ;
		int posY = 20 ;
		
		for (String title : titles)
		{
			DrawingOnPanel.DrawText(new Point(posX, posY), title, font, Color.black);
			posX += 100 ;
		}
		posY += 30 ;

		font = new Font(Main.font.getName(), Font.PLAIN, 13) ;
		for (Alimento alimento : alimentos)
		{
			posX = 20 ;
			if (alimento.equals(selectedAlimento))
			{
				DrawingOnPanel.DrawText(new Point(posX, posY), alimento.getDados().get(0), font, Color.blue);
				/*for (String dado : alimento.getDados())
				{
					DrawingOnPanel.DrawText(new Point(posX, posY), dado, font, Color.blue);
					posX += 100 ;
				}*/
			}
			else
			{
				DrawingOnPanel.DrawText(new Point(posX, posY), alimento.getDados().get(0), font, Color.black);
				/*for (String dado : alimento.getDados())
				{
					DrawingOnPanel.DrawText(new Point(posX, posY), dado, font, Color.black);
					posX += 100 ;
				}*/
			}
			posY += 20 ;
		}
	}
}
