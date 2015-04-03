package SpiderBot;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import EstructurasDeDatos.Cola;
import EstructurasDeDatos.ListaEnlazada;

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
		public synchronized void run(){	
			while(true){
				//Bucle encargado de darle vida al hilo
				if(colaURL.estaVacia() == false){
					//Caso de que la cola este vacia
					try {
						String U = colaURL.obtenerInicio().obtenerValor().toString();
						URL url = new URL(U);
						System.out.println("soy el hilo: "+hilo+" y tengo la url: "+url);
						colaURL.eliminaInicio();
						Thread.sleep(10000);
						PAGEParser page = new PAGEParser();
						page.parsear(url);
						
						contador++;
						Thread.sleep(10000);
					} catch (InterruptedException | IOException e) {e.printStackTrace();}
				}
				else{
					//Caso en que la cola tenga elementos dentro
					//System.out.println("soy el hilo: "+hilo+" y estoy esperando un url");
					try {wait();} catch (InterruptedException e) {e.printStackTrace();}
					contador++;
				}			
			}		
		}//Cierre del metodo run
	}
	
	int trabajadores;
	int contador = 0;
	XMLParser urlParser = new XMLParser("targets.xml","URL");
	Cola colaURL = urlParser.obtenerCola();
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
