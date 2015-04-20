package SpiderBot;


import java.net.MalformedURLException;
import java.net.URL;

import EstructurasDeDatos.Cola;
import EstructurasDeDatos.ListaCircularDoble;
import EstructurasDeDatos.ListaEnlazada;
import EstructurasDeDatos.Nodo;

/**
 * Clase encargada de crear una lista de hilos trabajadores
 * @author arturo
 * @version 02/04/2015 
 */

public class listaHilos {
	/**	
	 * Clase encargada de realizar las tareas de los hilos
	 * @author arturo
	 * @version 02/04/2015 
	 */
	protected class Hilo extends Thread{
		//Campos de la clase
		URL url;
		int hilo;
		/**
		 * Constructor de la clase Hilo
		 * @param hilo asigna un identidicador al hilo
		 */
		public Hilo(int hilo){	
			this.hilo = hilo;
		}//Cierra el constructor
		/**
		 * Metodo encargado de ejecutar las tareas asignadas al hilo
		 */
		public void run(){	
			try {
				while(true){
					
					//Bucle encargado de darle vida al hilo
					if(colaURL.estaVacia() == false){
						Nodo Ini = colaURL.obtenerInicio();
						colaURL.eliminaInicio();
						String URL = Ini.obtenerValor().toString();
						int P = Integer.parseInt(Ini.obtenerProfundidad().obtenerValor().toString());
						listaURLParseadas.appendNodo(Ini);
						WebParser webparser = new WebParser(URL,P);
						Cola colanueva = webparser.getLinks();
						webparser.getText();
						colanueva.imprimir();	
						
						if (P+1 <= recursivity){
							if (colanueva != null){
								colaURL.appendCola(colanueva);
							}
						}
						
					}
					else
						wait();
					
					//colanueva.imprimir();	
				}
				
			} catch (Exception e) {System.out.println("no entra al while");}
		
		}//Cierre del metodo run
		
	}
	
	int trabajadores;
	int contador = 0;
	XMLParser urlParser = new XMLParser("targets.xml","URL");
	Cola colaURL = urlParser.obtenerCola();
	XMLParser recursivityParser = new XMLParser("spider.xml","recursivity");
	int recursivity = Integer.parseInt(recursivityParser.obtenerCola().obtenerInicio().obtenerValor().toString());
	ListaCircularDoble listaURLParseadas = new ListaCircularDoble();
	ListaCircularDoble listaPalabras = new ListaCircularDoble();
	/**
	 * Constructor de la clase listaHilos
	 */
	public listaHilos(){}//Cierra el constructor
	/**
	 * Metodo que crea hilos	
	 * @param trabajadores Cantidad de Hilos que se van a crear
	 * @throws MalformedURLException se da al malformar una url
	 */
	public void crearHilos(int trabajadores) throws MalformedURLException{		
		this.trabajadores = trabajadores;	
		ListaEnlazada listaHilos = new ListaEnlazada();		
		for(int i = 0; i < trabajadores; i++){		
			//Bucle que crea la cantidad de hilos indicada
			Hilo nuevo = new Hilo(i);
			nuevo.start();
			listaHilos.addFinal(nuevo);	
		}	
	}//Cierra el Metodo
}//Cierra la clase
