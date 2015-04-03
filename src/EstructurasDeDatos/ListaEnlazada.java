package EstructurasDeDatos;

/**
 * @author arturo
 * @version 02/04/2015 
 */

public class ListaEnlazada {
	//Campos de la clase
	Nodo cabeza;
	Nodo cola;
	int size;
	/**
	 * Constructor de la clase ListaEnlazada
	 */
	public ListaEnlazada(){
		cabeza = null;
		cola = null;
		size = 0;
	}//Cierre del constructor
	/**
	 * Funcion que revisa si la cola esta vacia 
	 * @return Booleano indicando si la cola esta vacia o no
	 */	
	public boolean estaVacia(){
		return(cabeza == null)?true:false;
	}//Cierre de la Funcion
	/**
	 * Metodo que agrega un elemento al inicio de la lista
	 * @param obj - Objeto destinado a agregar en la lista
	 */	
	public void addInicio(Object obj){
		if(estaVacia()){ 
			//Caso lista vacia
			cabeza = new Nodo(obj);
			cola = cabeza; //unico nodo es cabeza y cola
		}
		else{ 
			//Caso en que la lista ya tenga algun elemento
			Nodo temp = cabeza; //temporal apunta al primer nodo
			Nodo nuevo = new Nodo(obj); //crea el nodo nuevo fuera de la lista
			nuevo.enlazarSiguiente(temp); //el nuevo nodo apunta al inicio de la lista
			cabeza = nuevo; //el nodo nuevo ahora es la cabeza
		}
		size++; //suma 1 al contador de tamanio cuando se agrega un nodo
	}//Cierre del Metodo
	/**
	 * Metodo que agrega un elemento al final de la cola
	 * @param obj - Objeto destinado a agregar en la cola
	 */
	public void addFinal(Object obj){
		if(estaVacia()){
			//Caso lista vacia
			cabeza = new Nodo(obj);
			cola = cabeza;
		}
		else{
			//Caso en que la lista ya tenga algun elemento
			Nodo temp = cola;
			Nodo nuevo = new Nodo(obj);
			temp.enlazarSiguiente(nuevo);
			cola = nuevo;
		}
		size++; //suma 1 al contador de tamanio cuando se agrega un nodo
	}//Cierre del metodo
	/**
	 * Metodo que elimina el primer elemento de la cola
	 */
	public void eliminaInicio(){
		if(estaVacia())
			//Caso lista vacia
			System.out.println("La lista esta vacia");
		else{
			//Caso en que la cola ya tenga algun elemento
			Nodo temp = cabeza.obtenerSiguiente();
			cabeza = temp;			
		}
		size--;//resta 1 al contador de tamaño cuando se elimina un elemento a la lista
	}//Cierre del Metodo
	/**
	 * Metodo que elimina el ultimo elemento de la lista
	 */
	public void eliminaFinal(){ //Metodo para eliminar al final
		if(cabeza == null)
			//Caso cola vacia
			System.out.println("La lista esta vacia"); //
		else{
			//Caso en que la cola ya tenga algun elemento
			Nodo temp = cabeza;
			int contador = 0;
			while(contador < size){
				//Bucle que recorre la lista
				temp = temp.obtenerSiguiente();
				contador++;				
			}		
			cola = temp;
		}
		size--;//resta 1 al contador de tamaño cuando se elimina un elemento a la lista
	}//Cierre del Metodo
	/**
	 * Metodo que elimina una posicion indicada de la lista
	 * @param indice - Posicion que se desea eliminar de la lista
	 */	
	public void eliminarenPos(int indice){
		if(estaVacia())
			//Caso eliminar primera posicion
			eliminaInicio();
		else if(indice == getSize()-1)
			//Caso eliminar ultima posicion
			eliminaFinal();
		else{
			//Caso posiciones diferentes a las dos anteriores
			int contador = 1;
			Nodo temp = cabeza;
			while(contador < indice){
				//Bucle que recorre la lista
				temp = temp.obtenerSiguiente();
				contador++;			
			}
			temp.enlazarSiguiente(temp.obtenerSiguiente().obtenerSiguiente());
		}
		size--; //resta 1 al contador de tamaño cuando se elimina un elemento a la lista
	}//Cierre del Metodo
	/**
	 * Funcion que obtiene el Objeto almacenado en una posicion especifica de la lista
	 * @param indice - Posicion de la lista que se desea obtener
	 * @return Objeto almacenado en la posicion de la lista dada
	 */
	public Object obtenerenPos(int indice){
		int contador = 0;
		Nodo temporal = cabeza;
		while(contador < indice){
			//Bucle que recorre la lista en busqueda de la posicion a obtener
			temporal = temporal.obtenerSiguiente();
			contador++;
		}
		return temporal.obtenerValor();			
	}//Cierre de la Funcion
	/**
	 * Metodo que imprime todos los valores almacenados en la lista
	 */
	public void imprimir(){
		int contador = 0;
		Nodo temp = cabeza;
		while(contador < size){
			//Bucle que recorre la lista
			System.out.println(temp.obtenerValor().toString());
			temp=temp.obtenerSiguiente();
			contador++;		
		}	
	}//Cierre del Metodo
	/**
	 * Funcion que retorna el tamaño de la lista
	 * @return Entero con el tamaño de la lista
	 */
	public int getSize(){ //metodo para obtener el tamanio de la lista
		return size;
	}//Cierre de la Funcion
}//Cierre de la clase
