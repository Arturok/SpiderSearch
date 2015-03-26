package EstructurasDeDatos;
//Clase designada para las pruebas de las estructuras de Datos

public class Main {

	public static void main(String[] args) {
	
	ListaEnlazada lista = new ListaEnlazada();
	System.out.println("Esta vacia???"+lista.estaVacia());
	
	lista.addFinal("www.nacion.com"); //addFinal
	lista.addFinal("www.google.com"); //addInicio
	lista.addFinal("www.wikipedia.org");
	lista.addFinal("www.shippuden.tv");

	
	
	

	System.out.println("");
	lista.imprimir();
	
	lista.eliminarenPos(2);
	System.out.println("");

	lista.imprimir();







	}

}
