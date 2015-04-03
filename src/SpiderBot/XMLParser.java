

package SpiderBot;


import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;

import EstructurasDeDatos.Cola;

/**
 * @author arturo
 * @version 02/04/2015 
 */

public class XMLParser {
	String archivo;
	String tag;
	
	public XMLParser(String archivo, String tag){
		/*
		 * Constructor para la funcion que parsea los archivos XML
		 * Parameters:
		 * archivo - El parametro recibe el nombre del archivo XML de la forma "nombre.xml" al que se va a acceder
		 * tag - El parametro recibe el tag que se desea buscar en el archivo XML de la forma "tag"
		 */		
		this.archivo = archivo;
		this.tag = tag;
		
	}
	public Cola obtenerCola(){
		Cola colaParse = new Cola();

		try {
			DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder(); //Se crea un documento builder para parsear el xml
			File f = new File("/home/arturo/Escritorio/SpiderSearch/SpiderSearch/src/SpiderBot/"+archivo); //se carga el xml en un documento 
			Document documento = builder.parse(f); //se crea un documento tipo Document con el xml parseado
			Node nodo = documento;
						
			if(nodo != null){				
				Node padre = documento.getChildNodes().item(0); //Obtiene la primera jerarquia del documento
				NodeList hijos = padre.getChildNodes(); //Obtiene una lista con los nodos de la segunda jerarquia
				
				for(int i = 0; i < (hijos.getLength()-1)/2; i++){ 					
					String nuevo = documento.getElementsByTagName(tag).item(i).getTextContent(); //Obtiene el contenido del XML en la posicion i
					colaParse.addFinal(nuevo); //Introduce las URL's en una lista
				}
			}
		}catch(Exception e){
			//e.printStackTrace();
		}
		return colaParse;		
	}
}
