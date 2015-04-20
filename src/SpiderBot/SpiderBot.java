package SpiderBot;

import java.net.MalformedURLException;

/**
 * @author arturo
 * @version 02/04/2015 
 */

public class SpiderBot {
	/**
	 * Constructor de la clase SpiderBot
	 */	
	public SpiderBot(){
	}//Cierre del Constructor
	/**
	 * Funcion main de la funcion
	 * @param args argumento de la funcion main
	 * @return 
	 * @throws MalformedURLException - excepcion dada al malformar una url
	 */
	public void inicia(){
		XMLParser parseThreads = new XMLParser("spider.xml","maxthreads");
		String maxthread = parseThreads.obtenerCola().obtenerInicio().obtenerValor().toString();
		int maxthreads = Integer.parseInt(maxthread);
		
		listaHilos hilos = new listaHilos();
		try {
			hilos.crearHilos(maxthreads);
		} catch (MalformedURLException e) {e.printStackTrace();}		
		
		
		
		
	}//Cierre de la Funcion
}//Cierre de la clase
