package EstructurasDeDatos;

public class Nodo{
	
	Object valor;
	Nodo siguiente;
	
	public Nodo(Object valor){ //Constructor de la clase nodo
		
			this.valor = valor;	
			this.siguiente = null;
	}
	
	public Object obtenerValor(){ //Retorna el valor del nodo
		return valor;
	}
	
	public void enlazarSiguiente(Nodo n){ // Enlaza el siguiente nodo a agregar
		siguiente = n;
	}
	
	public Nodo obtenerSiguiente(){ //Retorna el nodo siguiente
		return siguiente;
	}
	
}
