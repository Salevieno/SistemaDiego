package main;

import java.util.List;
import java.util.Objects;

public class Alimento
{
	private List<String> dados ;
	
	public Alimento(List<String> list)
	{
		this.dados = list ;
	}

	public List<String> getDados()
	{
		return dados;
	}

	@Override
	public int hashCode()
	{
		return Objects.hash(dados);
	}

	@Override
	public boolean equals(Object obj)
	{
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Alimento other = (Alimento) obj;
		return Objects.equals(dados, other.dados);
	}

	@Override
	public String toString()
	{
		return "Alimento [dados=" + dados + "]";
	}
	
	
}
