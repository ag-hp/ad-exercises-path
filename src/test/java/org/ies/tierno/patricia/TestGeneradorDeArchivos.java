package org.ies.tierno.patricia;

public class TestGeneradorDeArchivos
{
	public static void main(String[] args)
	{ 
		GeneradorDeArchivos generador = new GeneradorDeArchivos(null);
		try
		{	
				generador.crearArchivosNIO();
				generador.crearArchivosIO();
		}
		catch(Exception e)
		{
			System.out.println("Algo ha ido mal "+e.getClass().getSimpleName()+"Mensaje: "+ e.getMessage());
		}
	}
}