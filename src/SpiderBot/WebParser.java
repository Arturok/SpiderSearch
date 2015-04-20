package SpiderBot;

import java.io.IOException;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import EstructurasDeDatos.Cola;
import EstructurasDeDatos.ListaCircularDoble;
import EstructurasDeDatos.Nodo;

/**
 * Clase usada para extraer las palabras y los links de un sitio web y agregarlas a sus respectivas listas
 * @author arturo
 */

public class WebParser{
	//Campos de la clase
		String url = null;
		int profundidad;
		int i;
		
	/**
	 *  Constructor de la clae WebParser
	 *  @param url - recibe la url a ser parseada
	 */	
	public WebParser(String url, int profundidad){
		this.url = url;
		this.profundidad = profundidad;
	} //Cierre del constructor
	
	/**
	 * Metodo que extrae los links de un sitio web y los mete en la cola de URLs
	 * 
	 */
	public Cola getLinks(){
		Cola colalinks = new Cola();
		try {
			Document doc = Jsoup.connect(url).get();
			org.jsoup.select.Elements links = doc.select("a");
			for(Element e: links){
				colalinks.addURL(e.attr("abs:href"),profundidad+1);		
			}
			
		}//catch(IOException ex){Logger.getLogger(WebParser.class.getName()).log(Level.SEVERE,null, ex);
		catch(Exception e){
			colalinks = null;
			return colalinks;
		}
		return colalinks;	
	}
	/**
	 * Metodo que obtiene todo el texto del sitio web
	 */
	public void getText(){
		try {
			Document doc = Jsoup.connect(url).timeout(5000).get();
			String text = doc.body().text();
			separates(text);
		} catch (IOException e) {e.printStackTrace();
		}			
	}//Cierre del Metodo
	/**
	 * Metodo que se encarga de e
	 * @param text
	 */
	public void separates(String text){
		String[] separadores = {".",",",":",";","“","'","(",")","[","]","{","}","¿","?","¡","!","…","-","<",">","+","-","*","/","=","\"","«","»","“","”","‘","’"};	
		int i = 0;
		String txt;
		while(i<separadores.length){
			txt = getWords(text, separadores[i]);
			text = txt;
			i++;
		}
		StringTokenizer token = new StringTokenizer(text," ");
		ListaCircularDoble listaPalabras = new ListaCircularDoble();
		while (token.hasMoreTokens()){
			if(listaPalabras.estaVacia())
				listaPalabras.addFinal(token.nextToken());
			else{
				if(repetida(token.nextToken(), listaPalabras) == false)
					listaPalabras.addInicio(token.nextToken());
				else{
					repetida(token.nextToken(), listaPalabras);
				}
			}
		}
	}
	
	private String getWords(String text, String separador){
		StringTokenizer noSigns = new StringTokenizer(text, separador);
		String textToken = "";
		while(noSigns.hasMoreTokens()){
			textToken = textToken + " " + noSigns.nextToken().toString();	
		}	
		return textToken;
	}
	
	private boolean repetida(String palabra, ListaCircularDoble lista){
		Nodo temp = lista.obtenerenPos(0);
		boolean condicion = false;
		int contador = 0;
		while(contador <= lista.getSize()){
			if(palabra == temp.obtenerValor().toString()){
				condicion = true;
				break;
			}
			else
				contador++;
					
		}
		return condicion;
		
	}


}

