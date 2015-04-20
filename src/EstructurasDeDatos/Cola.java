package EstructurasDeDatos;

/**
 * Esta clase define una estructura de datos llamada Cola donde se pueden insertar tareas para
 * su posterior ejecucion
 * @author arturo
 * @version 02/04/2015 
 */

public class Cola {
	//Campos de la clase
	public Nodo cabeza;
	Nodo cola;
	int size;	
	/**
	 * Constructor de la clase Cola
	 */	
	public Cola(){ 		
		cabeza = null;
		cola = null;
		size = 0;
	}//Cierre del constructor
	/**
	 * Funcion que revisa si la cola esta vacia
	 * @return Booleano indicando si la cola esta vacia o no
	 */
	public boolean estaVacia(){ //Metodo que verifica si la lista esta vacia
		return(cabeza == null)?true:false;
	}//cierre de la funcion
	/**
	 * Metodo que agrega un elemento al final de la cola
	 * @param obj - Objeto destinado a agregar en la cola
	 */
	public void addFinal(Object obj){ //Metodo que agrega nodos al inicio de la lista
		if(estaVacia()){ 
			//Caso cola vacia
			cabeza = new Nodo(obj);
			cola = cabeza;
			Nodo p = new Nodo(0);
			cabeza.enlazarProfundidad(p);
		}
		else{
			//Caso en que la cola ya tenga algun elemento
			Nodo temp = cola;
			Nodo nuevo = new Nodo(obj);
			temp.enlazarSiguiente(nuevo);
			cola = nuevo;
			Nodo p = new Nodo(0);
			nuevo.enlazarProfundidad(p);
		}
		size++; //suma 1 al contador de tamaño cuando se agrega un elemento a la lista
	}//Ciere del metodo
	
	public void addURL(String url, int profundidad){
		if(estaVacia()){ 
			//Caso cola vacia
			cabeza = new Nodo(url);
			cola = cabeza;
			Nodo p = new Nodo(profundidad);
			cabeza.enlazarProfundidad(p);
		}
		else{
			//Caso en que la cola ya tenga algun elemento
			Nodo temp = cola;
			Nodo nuevo = new Nodo(url);
			temp.enlazarSiguiente(nuevo);
			cola = nuevo;
			Nodo p = new Nodo(profundidad);
			nuevo.enlazarProfundidad(p);
		}
		size++;
		
	}
	
	/**
	 * Metodo usado para agregar una cola existente a la actual
	 * @param nueva
	 */
	public void appendCola(Cola nueva){
		if (nueva.estaVacia()){
			try {
				finalize();
			} catch (Throwable e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(estaVacia()){
			cabeza = nueva.cabeza;
			cola = nueva.cola;
			size = nueva.size;
		}
		else{
			try{
				Nodo temp = cola;
				temp.enlazarSiguiente(nueva.cabeza);
				cola = nueva.cola;
				size=size+nueva.size;
			}catch(Exception CE){}
			
		}
	}
	
	/**
	 * Metodo que elimina el primer elemento de la cola
	 */	
	public void eliminaInicio(){ //Metodo para eliminar al inicio
		if(estaVacia())
			//En caso de que la lista este vacia			
			System.out.println("La lista esta vacia");
		else{
			//Caso en que la cola ya tenga algun elemento
			Nodo temp = cabeza.obtenerSiguiente();
			cabeza = temp;			
		}
		size--;//resta 1 al contador de tamaño cuando se elimina un elemento de la lista 
	}//cierre del metodo
	/**
	 * Funcion que obtiene el primer elemento de la cola
	 * @return primer Nodo con el objeto que contiene
	 */
	public Nodo obtenerInicio(){
		return cabeza;			
	} //cierre de la funcion
	/**
	 * Metodo que imprime los valores contenidos en los nodos de la cola
	 */
	public void imprimir(){
		int contador = 0;
		Nodo temp = cabeza;
		while(contador < size){
			//Bucle que recorre la cola en busca de los nodos
			System.out.println(temp.obtenerValor().toString());
			System.out.println(temp.obtenerProfundidad().obtenerValor().toString());
			temp=temp.obtenerSiguiente();
			contador++;
		}	
	}//cierre del metodo
	/**
	 * Funcion que retorna eltamaño de la cola
	 * @return Entero que indica el tamaño de la cola
	 */	
	public int getSize(){ //metodo para obtener el tamanio de la lista
		return size;
	}//Cierre de la funcion
}//Cierre de la Clase

	
	


