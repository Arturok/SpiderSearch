package EstructurasDeDatos;

/**
 * @author arturo
 * @version 02/04/2015 
 */

public class ListaCircularDoble {
	//Campos de la clase
	Nodo cabeza;
	Nodo cola;
	int size;
	/**
	 * Constructor de la clase ListaCircularDoble
	 */
	public ListaCircularDoble(){
		cabeza = null;
		cola = null;
		size = 0;
	}//Cierre del constructor
	/**
	 * Funcion que devuelve si la lista esta vacia
	 * @return Booleano indicando si la lista esta vacia o no
	 */
	public boolean estaVacia(){
		return(cabeza == null)?true:false;
	}//cierre de la funcion
	/**
	 * Metodo que agrega un elemento al inicio de la lista
	 * @param obj - Objeto destinado a agregar en la lista
	 */
	public void addInicio(Object obj){
		if(estaVacia()){ 
			//Caso lista vacia
			cabeza = new Nodo(obj);
			cola = cabeza; //unico nodo es cabeza y cola
			cola.enlazarSiguiente(cabeza);
			cabeza.enlazarAnterior(cola);			
		}
		else{ 
			//caso lista con elementos dentro
			Nodo temp = cabeza; //temporal apunta al primer nodo
			Nodo nuevo = new Nodo(obj); 
			nuevo.enlazarSiguiente(temp);
			temp.enlazarAnterior(nuevo); 
			cabeza = nuevo; 
			cabeza.enlazarAnterior(cola);
			cola.enlazarSiguiente(cabeza);
		}
		size++; //suma 1 al contador de tamanio cuando se agrega un nodo
	}//cierre de la funcion
	/**
	 * Metodo que agrega un elemento al final de la lista
	 * @param obj - Objeto destinado a agregar en la lista
	 */	
	public void addFinal(Object obj){ 
		if(estaVacia()){ 
			//Caso lista vacia
			cabeza = new Nodo(obj);
			cola = cabeza;
			cola.enlazarSiguiente(cabeza);
			cabeza.enlazarAnterior(cola);
		}
		else{
			//caso lista con elementos dentro
			Nodo temp = cola;
			Nodo nuevo = new Nodo(obj);
			temp.enlazarSiguiente(nuevo);
			nuevo.enlazarAnterior(temp);
			cola = nuevo;
			cola.enlazarSiguiente(cabeza);
			cabeza.enlazarAnterior(cola);
		}
		size++; //suma 1 al contador de tamanio cuando se agrega un nodo
	}//Cierre del Constructor	
	/**
	 * Metodo usado para agregar un Nodo al final de la lista actual
	 * @param nuevo - Nodo a ser agregado a la lista
	 */
	public void appendNodo(Nodo nuevo){
		if(estaVacia()){
			cabeza = nuevo;
			cola = nuevo;
			size = 1;
		}
		else{
			try{
				Nodo temp = cola;
				temp.enlazarSiguiente(nuevo);
				nuevo.enlazarAnterior(temp);
				cola = nuevo;
				cola.enlazarSiguiente(cabeza);
				cabeza.enlazarAnterior(cola);
				size++;
			}catch(Exception CE){}
			
		}
	}
	
	/**
	 * Metodo usado para agregar una cola existente a la actual
	 * @param nueva
	 */
	public void appendLista(ListaCircularDoble nueva){
		if(estaVacia()){
			cabeza = nueva.cabeza;
			cola = nueva.cola;
			size = nueva.size;
		}
		else{
			try{
				Nodo temp = cola;
				temp.enlazarSiguiente(nueva.cabeza);
				nueva.cabeza.enlazarAnterior(temp);
				cola = nueva.cola;
				cola.enlazarSiguiente(cabeza);
				cabeza.enlazarAnterior(cola);
				size=size+nueva.size;
			}catch(Exception CE){}
			
		}
	}
	/**
	 * Metodo que elimina el primer Nodo de la Lista
	 */
	public void eliminaInicio(){
		if(estaVacia())
			//Caso lista vacia
			System.out.println("La lista esta vacia");
		else{
			//caso lista con elementos dentro
			cabeza = cabeza.obtenerSiguiente();
			cabeza.enlazarAnterior(cola);
			cola.enlazarSiguiente(cabeza);
		}
		size--;
	}//Cierre de Metodo
	/**
	 * Metodo que elimina el ultimo Nodo de la Lista
	 */
	public void eliminaFinal(){
		if(cabeza == null)
			//Caso lista vacia
			System.out.println("La lista esta vacia"); //
		else{
			//caso lista con elementos dentro
			cola = cola.obtenerAnterior();
			cola.enlazarSiguiente(cabeza);
			cabeza.enlazarAnterior(cola);			
		}
		size--;	//Resta 1 al contador del tamaño al quitar un elemento de la lista	
	}//Cierre del constructor
	/**
	 * Metodo que elimina un elemento en una posicion especifica de la lista
	 * @param indice - Recibe la posicion de la lista que se desea eliminar
	 */
	public void eliminarenPos(int indice){
		if(indice == 0)
			//Eliminar primera posicion
			eliminaInicio();
		else if(indice == getSize()-1)
			//Eliminar ultima posicion
			eliminaFinal();
		else{
			//Elimina en una posicion diferente a los demas
			int contador = 0;
			Nodo temp = cabeza;
			Nodo temp2 = null;
			while(contador < indice-1){
				//Bucle que recorre la lista
				temp = temp.obtenerSiguiente();
				contador++;			
			}
			temp.enlazarSiguiente(temp.obtenerSiguiente().obtenerSiguiente());
			temp2 = temp.obtenerSiguiente();
			temp2.enlazarAnterior(temp);
		}
		size--; //Resta 1 al contador del tamaño de la lista
	}//Cierre del Metodo
	/**
	 * Funcion que retorna el Nodo en una posicion especifica de la lista
	 * @param indice - Recibe la posicion de la lista que se desea eliminar
	 * @return Objeto contenido en el nodo de la posicion especificada
	 */	
	public Nodo obtenerenPos(int indice){
		int contador = 0;
		Nodo temporal = cabeza;
		while(contador < indice){
			temporal = temporal.obtenerSiguiente();
			contador++;
		}
		return temporal;			
	}//Cierre de la Funcion
	/**
	 * Funcion que retorna eltamaño de la cola
	 * @return Entero que indica el tamaño de la cola
	 */		
	public void imprimir(){
		int contador = 0;
		Nodo temp = cabeza;
		while(contador < size){
			//Ciclo que recorre la lista 
			System.out.println(temp.obtenerValor().toString());
			System.out.println(temp.obtenerProfundidad().obtenerValor().toString());
			temp=temp.obtenerSiguiente();
			contador++;		
		}	
	}//Cierre del metodo
	/**
	 * Funcion que retorna el tamaño de la lista
	 * @return Entero con el tamaño de la lista
	 */
	public int getSize(){ //metodo para obtener el tamanio de la lista
		return size;
	}//Cierre de la Funcion
}//Cierre de la clase
