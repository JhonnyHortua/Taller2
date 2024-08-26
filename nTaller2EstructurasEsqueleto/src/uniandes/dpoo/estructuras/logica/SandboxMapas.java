package uniandes.dpoo.estructuras.logica;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Collections;
import java.util.ArrayList;
import java.util.Iterator;
/**
 * Esta clase tiene un conjunto de métodos para practicar operaciones sobre mapas.
 *
 * Todos los métodos deben operar sobre el atributo mapaCadenas que se declara como un Map.
 * 
 * En este mapa, las llaves serán cadenas y los valores serán también cadenas. La relación entre los dos será que cada llave será igual a la cadena del valor, pero invertida.
 * 
 * El objetivo de usar el tipo Map es que sólo puedan usarse métodos de esa interfaz y no métodos adicionales provistos por la implementación concreta (HashMap).
 * 
 * No pueden agregarse nuevos atributos.
 */
public class SandboxMapas
{
    /**
     * Un mapa de cadenas para realizar varias de las siguientes operaciones.
     * 
     * Las llaves del mapa son cadenas, así como los valores.
     * 
     * Las llaves corresponden a invertir la cadena que aparece asociada a cada llave.
     */
    private Map<String, String> mapaCadenas;

    /**
     * Crea una nueva instancia de la clase con las dos listas inicializadas pero vacías
     */
    public SandboxMapas( )
    {
        mapaCadenas = new HashMap<String, String>( );
    }

    /**
     * Retorna una lista con las cadenas del mapa (los valores) ordenadas lexicográficamente
     * @return Una lista ordenada con las cadenas que conforman los valores del mapa
     */
    public List<String> getValoresComoLista( )
    {
    	ArrayList<String> newList = new ArrayList<String>();

    	for ( Map.Entry<String, String> entry : this.mapaCadenas.entrySet() ) { // recorrer los entries del mapa

    		newList.add( entry.getValue() );

    	}

    	Collections.sort(newList); // ordenar la lista lexicograficamente

        return newList;
    }

    /**
     * Retorna una lista con las llaves del mapa ordenadas lexicográficamente de mayor a menor
     * @return Una lista ordenada con las cadenas que conforman las llaves del mapa
     */
    public List<String> getLlavesComoListaInvertida( )
    {
    	ArrayList<String> newList = new ArrayList<String>();

    	for ( Map.Entry<String, String> entry : this.mapaCadenas.entrySet() ) { // recorrer los entries del mapa

    		newList.add( entry.getKey() );

    	}

    	Collections.sort(newList); // ordenar la lista lexicograficamente

    	Collections.reverse(newList); // invertir la lista

        return newList;
    }

    /**
     * Retorna la cadena que sea lexicográficamente menor dentro de las llaves del mapa .
     * 
     * Si el mapa está vacío, debe retornar null.
     * @return
     */
    public String getPrimera( )
    {
        if ( this.mapaCadenas.isEmpty() )
        	return null;

        String menorLlave = "";
        int i = 0;
        for ( Map.Entry<String, String> entry : this.mapaCadenas.entrySet() ) { // recorrer los entries del mapa

        	if ( i == 0 ) {

        		menorLlave = entry.getKey();

        	} else if ( entry.getKey().compareTo(menorLlave) < 0 ) {

        		menorLlave = entry.getKey();

        	}

        	i++;
        }

        return menorLlave;

    }

    /**
     * Retorna la cadena que sea lexicográficamente mayor dentro de los valores del mapa
     * 
     * Si el conjunto está vacío, debe retornar null.
     * @return
     */
    public String getUltima( )
    {
        if ( this.mapaCadenas.isEmpty() )
        	return null;

        String mayorLlave = "";
        int i = 0;
        for ( Map.Entry<String, String> entry : this.mapaCadenas.entrySet() ) { // recorrer los entries del mapa

        	if ( i == 0 ) {

        		mayorLlave = entry.getKey();

        	} else if ( entry.getKey().compareTo(mayorLlave) > 0 ) {

        		mayorLlave = entry.getKey();

        	}

        	i++;
        }

        return mayorLlave;
    }

    /**
     * Retorna una colección con las llaves del mapa, convertidas a mayúsculas.
     * 
     * El orden de las llaves retornadas no importa.
     * @return Una lista de cadenas donde todas las cadenas están en mayúsculas
     */
    public Collection<String> getLlaves( )
    {
    	ArrayList<String> nuevaLista = new ArrayList<String> ( this.mapaCadenas.size() );

        for ( Map.Entry<String, String> entry : this.mapaCadenas.entrySet() ) { // recorrer los entries del mapa

        	nuevaLista.add( entry.getKey().toUpperCase() );

        }

        return nuevaLista;
    }

    /**
     * Retorna la cantidad de *valores* diferentes en el mapa
     * @return
     */
    public int getCantidadCadenasDiferentes( )
    {
    	int ammount = 0;

    	HashMap<String, Integer> vals = new HashMap<String,Integer>();

        for ( Map.Entry<String, String> entry : this.mapaCadenas.entrySet() ) { // recorrer los entries del mapa

        	String cadena = entry.getValue();

        	if ( vals.containsKey( cadena ) ) {

        		int cadenaAmmount = vals.get(cadena);

        		vals.put( cadena, cadenaAmmount + 1 );

        	} else {

        		vals.put(cadena, 1);
        		ammount += 1;
        	}

        }

        return ammount;
    }

    /**
     * Agrega un nuevo valor al mapa de cadenas: el valor será el recibido por parámetro, y la llave será la cadena invertida
     * 
     * Este método podría o no aumentar el tamaño del mapa, dependiendo de si ya existía la cadena en el mapa
     * 
     * @param cadena La cadena que se va a agregar al mapa
     */
    public void agregarCadena( String cadena )
    {
    	int sizeCadena = cadena.length();

    	String key = "";

    	for (int i = sizeCadena - 1; i >= 0; i--) {

    		key = key + cadena.charAt(i);

    	}

    	this.mapaCadenas.put(key, cadena);
    }

    /**
     * Elimina una cadena del mapa, dada la llave
     * @param cadena La llave para identificar el valor que se debe eliminar
     */
    public void eliminarCadenaConLLave( String llave )
    {
    	this.mapaCadenas.remove(llave);
    }

    /**
     * Elimina una cadena del mapa, dado el valor
     * @param cadena El valor que se debe eliminar
     */
    public void eliminarCadenaConValor( String valor )
    {
    	for ( Map.Entry<String, String> entry : this.mapaCadenas.entrySet() ) { // recorrer los entries del mapa

        	String value = entry.getValue();

        	if ( value.equals(valor) )
        		this.mapaCadenas.remove( entry.getKey() );

        }

     
    }

    /**
     * Reinicia el mapa de cadenas con las representaciones como Strings de los objetos contenidos en la lista del parámetro 'objetos'.
     * 
     * Use el método toString para convertir los objetos a cadenas.
     * @param valores Una lista de objetos
     */
    public void reiniciarMapaCadenas( List<Object> objetos )
    {
    	HashMap<String,String> newMap = new HashMap<String,String>();

    	Iterator<Object> iteradorObjetos = objetos.iterator();

    	while ( iteradorObjetos.hasNext() ) {

    		String cadena = iteradorObjetos.next().toString();

    		int sizeCadena = cadena.length();

        	String key = "";

        	for (int i = sizeCadena - 1; i >= 0; i--) {

        		key = key + cadena.charAt(i);

        	}

        	newMap.put(key, cadena);

    	}

    	this.mapaCadenas = newMap;
    }

    /**
     * Modifica el mapa de cadenas reemplazando las llaves para que ahora todas estén en mayúsculas pero sigan conservando las mismas cadenas asociadas.
     */
    public void volverMayusculas( )
    {
    	HashMap<String,String> newMap = new HashMap<String,String>();

    	for ( Map.Entry<String, String> entry : this.mapaCadenas.entrySet() ) { // recorrer los entries del mapa

        	String value = entry.getValue();

        	String key = entry.getKey().toUpperCase();

        	newMap.put(key, value);

        }

    	this.mapaCadenas = newMap;
     
    }

    /**
     * Verifica si todos los elementos en el arreglo de cadenas del parámetro hacen parte del mapa de cadenas (de los valores)
     * @param otroArreglo El arreglo de enteros con el que se debe comparar
     * @return True si todos los elementos del arreglo están dentro de los valores del mapa
     */
    public boolean compararValores( String[] otroArreglo )
    {
    	for (int i = 0; i < otroArreglo.length; i++) {

    		if ( !( this.mapaCadenas.containsValue( otroArreglo[i] ) ) )
    			return false;

    	}

        return true;
    }

}
