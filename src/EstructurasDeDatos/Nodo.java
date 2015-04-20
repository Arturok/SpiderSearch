package EstructurasDeDatos;

/**
 * @author arturo
 * @version 02/04/2015 
 */

public class Nodo{
	//campos de la clase
	Object valor;
	Nodo siguiente;
	Nodo anterior;
	Nodo profundidad;
	Nodo cantidad;
	/**
	 * Constructor de la clase Nodo
	 * @param valor - Objeto a almecenar dentro del nodo
	 */
	public Nodo(Object valor){ //Constructor de la clase nodo
			this.valor = valor;	
			this.siguiente = null;
	}//Cierre del constructor
	/**
	 * Funcion que retorna el valor almacenado en el nodo
	 * @return Objeto almacenado en el Nodo
	 */
	public Object obtenerValor(){ //Retorna el valor del nodo
		return valor;
	}//Cierre de la Funcion
	/**
	 * Metodo que enlaza un siguiente nodo
	 * @param s Nodo siquiente a enlazar
	 */
	public void enlazarSiguiente(Nodo s){ // Enlaza el siguiente nodo a agregar
		siguiente = s;
	}//Cierre de la Funcion
	/**
	 * Metodo que enlaza un anterior nodo
	 * @param a - Nodo anterior a enlazar
	 */
	public void enlazarAnterior(Nodo a){
		anterior = a;
	}//Cierre de la Funcion
	/**
	 * Metodo que enlaza la profundidad de la URL
	 * @param p - Entero que indica la profundidad de la URL
	 */
	public void enlazarProfundidad(Nodo p){
		profundidad = p;
	}//Cierre de la Metodo
	/**
	 * Metodo que enlaza un atributo de cantidad al Nodo
	 * @param c - Entero que indica la cantidad de veces que aparace una letra
	 */
	public void enlazarCantidad(Nodo c){
		cantidad = c;		
	}//Cierre del Metodo
	/**
	 * Funcion que retorna el nodo siguiente enlazado
	 * @return - Nodo siguiente 	
	 */
	public Nodo obtenerSiguiente(){ //Retorna el nodo siguiente
		return siguiente;
	}//Cierre de la Funcion
	/**
	 * Funcion que retorna el nodo anterior enlazado
	 * @return - Nodo anterior 	
	 */
	public Nodo obtenerAnterior(){
		return anterior;
	}//Cierre de la Funcion
	/**
	 * Funcion que retorna la profundidad
	 * @return - Nodo donde se almacena la profundidad	
	 */
	public Nodo obtenerProfundidad(){
		return profundidad;
	}//Cierre de la Funcion
}//Cierre de la clase
