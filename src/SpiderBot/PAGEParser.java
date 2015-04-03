package SpiderBot;



import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import java.net.URL;
import java.io.BufferedReader;

/**
 * @author arturo
 * @version 02/04/2015 
 */

public class PAGEParser {
	//campos de la clase
	URL url;
	/**
	 * Constructor de la clase PAGEParser
	 */
	public PAGEParser(){
	}//Cierra el constructor
	/**
	 * Metodo que parsea las url
	 * @param url - url seleccionada a parsear
	 * @throws IOException - Excepcion al declarar de mala forma la url
	 */
	public void parsear(URL url) throws IOException{
		this.url = url;
	    InputStream is = url.openConnection().getInputStream();
	    BufferedReader reader = new BufferedReader( new InputStreamReader(is));
	    String line = null;
	    while( ( line = reader.readLine() ) != null )  {
	    	//Bucle que imprime todo el codigo de la pagina
	       System.out.println(line);
	    }
	    reader.close();	
	}//Cierre del Metodo
}//Cierre de la clase
