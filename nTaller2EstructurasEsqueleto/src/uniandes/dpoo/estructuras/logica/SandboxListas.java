package uniandes.dpoo.estructuras.logica;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Iterator;
import java.util.Collections;
import java.util.HashMap;
/**
 * Esta clase tiene un conjunto de métodos para practicar operaciones sobre listas de enteros y de cadenas.
 *
 * Todos los métodos deben operar sobre los atributos listaEnteros y listaCadenas.
 * 
 * No pueden agregarse nuevos atributos.
 * 
 * Implemente los métodos usando operaciones sobre listas (ie., no haga cosas como construir arreglos para evitar la manipulación de listas).
 * 
 * Intente usar varias formas de recorrer las listas (while, for, for each, iteradores ... )
 */
public class SandboxListas
{
    /**
     * Una lista de enteros para realizar varias de las siguientes operaciones.
     */
    private List<Integer> listaEnteros;

    /**
     * Una lista de cadenas para realizar varias de las siguientes operaciones
     */
    private List<String> listaCadenas;

    /**
     * Crea una nueva instancia de la clase con las dos listas inicializadas pero vacías
     */
    public SandboxListas( )
    {
        listaEnteros = new ArrayList<Integer>( );
        listaCadenas = new LinkedList<String>( );
    }

    /**
     * Retorna una copia de la lista de enteros, es decir una nueva lista del mismo tamaño que contiene copias de los valores de la lista original
     * @return Una copia de la lista de enteros
     */
    public List<Integer> getCopiaEnteros( )
    {
    	ArrayList<Integer> copiaEnteros = new ArrayList<Integer> ();

    	Iterator<Integer> iteratorEnteros = this.listaEnteros.iterator();

    	while ( iteratorEnteros.hasNext() ) {

    		int next = iteratorEnteros.next();

    		copiaEnteros.add(next);

    	}

        return copiaEnteros;
    }

    /**
     * Retorna una copia de la lista de cadenas, es decir una nueva lista del mismo tamaño que contiene copias de los valores de la lista original
     * @return Una copia de la lista de cadenas
     */
    public List<String> getCopiaCadenas( )
    {
    	LinkedList<String> copiaCadenas = new LinkedList<String> ();

    	Iterator<String> iteratorCadenas = this.listaCadenas.iterator();

    	while ( iteratorCadenas.hasNext() ) {

    		String next = iteratorCadenas.next();

    		copiaCadenas.add(next);

    	}

        return copiaCadenas;
    }

    /**
     * Retorna un arreglo con los valores de la lista de enteros, es decir un arreglo del mismo tamaño que contiene copias de los valores de la lista
     * @return Una arreglo de enteros
     */
    public int[] getEnterosComoArreglo( )
    {
    	int sizeEnteros = this.listaEnteros.size();

    	int[] arregloEnteros = new int[sizeEnteros];

    	Iterator<Integer> iteratorEnteros = this.listaEnteros.iterator();

    	int i = 0; // contador de posicion
    	while ( iteratorEnteros.hasNext() ) {

    		int next = iteratorEnteros.next();

    		arregloEnteros[i] = next;

    		i++; // incrementar posicion

    	}

        return arregloEnteros;
    }

    /**
     * Retorna la cantidad de valores en la lista de enteros
     * @return
     */
    public int getCantidadEnteros( )
    {
        return this.listaEnteros.size();
    }

    /**
     * Retorna la cantidad de valores en la lista de cadenas
     * @return
     */
    public int getCantidadCadenas( )
    {
        return this.listaCadenas.size();
    }

    /**
     * Agrega un nuevo valor al final de la lista de enteros. Es decir que este método siempre debería aumentar en 1 el tamaño de la lista.
     * 
     * @param entero El valor que se va a agregar.
     */
    public void agregarEntero( int entero )
    {
    	this.listaEnteros.add(entero);
    }

    /**
     * Agrega un nuevo valor al final de la lista de cadenas. Es decir que este método siempre debería aumentar en 1 la capacidad de la lista.
     * 
     * @param cadena La cadena que se va a agregar.
     */
    public void agregarCadena( String cadena )
    {
    	this.listaCadenas.add(cadena);
    }

    /**
     * Elimina todas las apariciones de un determinado valor dentro de la lista de enteros
     * @param valor El valor que se va eliminar
     */
    public void eliminarEntero( int valor )
    {
    	Iterator<Integer> iteratorEnteros = this.listaEnteros.iterator();

    	int i = 0; // contador de posicion
    	while ( iteratorEnteros.hasNext() ) {

    		int next = iteratorEnteros.next();

    		if ( next == valor ) {

    			iteratorEnteros.remove();

    		}

    		i++; // incrementar posicion
    	}
    }

    /**
     * Elimina todas las apariciones de un determinado valor dentro de la lista de cadenas
     * @param cadena La cadena que se va eliminar
     */
    public void eliminarCadena( String cadena )
    {
    	Iterator<String> iteratorCadenas = this.listaCadenas.iterator();

    	int i = 0; // contador de posicion
    	while ( iteratorCadenas.hasNext() ) {

    		String next = iteratorCadenas.next();

    		if ( next.equals(cadena) ) {

    			iteratorCadenas.remove();

    		}

    		i++; 
    	}
    }

    /**
     * Inserta un nuevo entero en la lista de enteros
     * 
     * @param entero El nuevo valor que debe agregarse
     * @param posicion La posición donde debe quedar el nuevo valor en la lista aumentada. Si la posición es menor a 0, se inserta el valor en la primera posición. Si la
     *        posición es mayor que el tamaño de la lista, se inserta el valor en la última posición.
     */
    public void insertarEntero( int entero, int posicion )
    {
    	if ( posicion < 0 )
    		posicion = 0;

    	if ( posicion > this.listaEnteros.size() &&  this.listaEnteros.size() > 0 )
    		posicion = this.listaEnteros.size();

    	this.listaEnteros.add(posicion, entero);
    }

    /**
     * Elimina un valor de la lista de enteros dada su posición.
     * @param posicion La posición donde está el elemento que debe ser eliminado. Si el parámetro posicion no corresponde a ninguna posición de la lista de enteros, el método
     *        no debe hacer nada.
     */
    public void eliminarEnteroPorPosicion( int posicion )
    {
    	if ( !( posicion < 0 | posicion > this.listaEnteros.size() - 1 ) )
    		this.listaEnteros.remove(posicion);
    }

    /**
     * Reinicia la lista de enteros con los valores contenidos en el parámetro 'valores', pero truncados.
     * 
     * Es decir que si el valor fuera 3.67, en la nueva lista debería quedar el entero 3.
     * @param valores Un arreglo de valores decimales.
     */
    public void reiniciarArregloEnteros( double[] valores )
    {
    	ArrayList<Integer> newList = new ArrayList<Integer>( valores.length );

    	for (int i = 0; i < valores.length; i++) {

    		newList.add( (int) valores[i] ); // truncar el double y agregar a la lista

    	}

    	this.listaEnteros = newList;
    }

    /**
     * Reinicia la lista de cadenas con las representaciones como Strings de los objetos contenidos en la lista del parámetro 'objetos'.
     * 
     * Use el método toString para convertir los objetos a cadenas.
     * @param valores Una lista de objetos
     */
    public void reiniciarArregloCadenas( List<Object> objetos )
    {
    	ArrayList<String> newList = new ArrayList<String>( objetos.size() );

    	Iterator<Object> iteratorObjetos = objetos.iterator();

    	while ( iteratorObjetos.hasNext() ) {

    		String next = iteratorObjetos.next().toString();

    		newList.add( next );

    	}

    	this.listaCadenas = newList;
    }

    /**
     * Modifica la lista de enteros para que todos los valores sean positivos.
     * 
     * Es decir que si en una posición había un valor negativo, después de ejecutar el método debe quedar el mismo valor muliplicado por -1.
     */
    public void volverPositivos( )
    {
    	int sizeEnteros = this.listaCadenas.size();

    	ArrayList<Integer> newList = new ArrayList<Integer>( sizeEnteros );

    	Iterator<Integer> iteratorEnteros = this.listaEnteros.iterator();

    	int i = 0;
    	while ( iteratorEnteros.hasNext() ) {

    		int next = iteratorEnteros.next();

    		if ( next < 0 )
    			next *= -1;

    		newList.add(i, next);

    		i++;

    	}

    	this.listaEnteros = newList;
    }

    /**
     * Modifica la lista de enteros para que todos los valores queden organizados de MAYOR a MENOR.
     */
    public void organizarEnteros( )
    {
    	Collections.sort(this.listaEnteros); // ordenar de menor a mayor

    	Collections.reverse(this.listaEnteros); // invertir
    }

    /**
     * Modifica la lista de cadenas para que todos los valores queden organizados lexicográficamente.
     */
    public void organizarCadenas( )
    {
    	Collections.sort(this.listaCadenas); // ordenar lexicograficamente
    }

    /**
     * Cuenta cuántas veces aparece el valor recibido por parámetro en la lista de enteros
     * @param valor El valor buscado
     * @return La cantidad de veces que aparece el valor
     */
    public int contarApariciones( int valor )
    {
    	int reps = 0;

    	Iterator<Integer> iteratorEnteros = this.listaEnteros.iterator();

    	while ( iteratorEnteros.hasNext() ) {

    		int next = iteratorEnteros.next();

    		if ( next == valor )
    			reps += 1;

    	}

    	return reps;
    }

    /**
     * Cuenta cuántas veces aparece la cadena recibida por parámetro en la lista de cadenas.
     * 
     * La búsqueda no debe diferenciar entre mayúsculas y minúsculas.
     * @param cadena La cadena buscada
     * @return La cantidad de veces que aparece la cadena
     */
    public int contarApariciones( String cadena )
    {
    	cadena = cadena.toLowerCase();
    	int reps = 0;

    	Iterator<String> iteratorEnteros = this.listaCadenas.iterator();

    	while ( iteratorEnteros.hasNext() ) {

    		String next = iteratorEnteros.next();
    		next = next.toLowerCase();

    		if ( next.equals(cadena) )
    			reps += 1;

    	}

    	return reps;
    }

    /**
     * Cuenta cuántos valores dentro de la lista de enteros están repetidos.
     * @return La cantidad de enteos diferentes que aparecen más de una vez
     */
    public int contarEnterosRepetidos( )
    {
        int reps = 0;
        HashMap<Integer, Integer> repetidos = new HashMap<Integer, Integer>();

        Iterator<Integer> iteratorEnteros = this.listaEnteros.iterator();

    	while ( iteratorEnteros.hasNext() ) {

    		int next = iteratorEnteros.next();

    		if ( repetidos.containsKey(next)) {

    			int value = repetidos.get(next);

    			if ( value == 1)
    				reps += 1;

    			repetidos.put(next, value + 1);

    		} else
    			repetidos.put(next, 1);

    	}
        return reps;
    }

    /**
     * Compara la lista de enteros con un arreglo de enteros y verifica si contienen los mismos elementos exactamente en el mismo orden.
     * @param otroArreglo El arreglo de enteros con el que se debe comparar
     * @return True si los elementos son los mismos y en el mismo orden y false de lo contrario
     */
    public boolean compararArregloEnteros( int[] otroArreglo )
    {
    	int otroSize = otroArreglo.length;

    	int listaSize = this.listaEnteros.size();

    	if ( otroSize != listaSize )
    		return false;

    	for (int i = 0; i < otroSize; i++) {

    		int elem = this.listaEnteros.get(i);

    		if ( elem != otroArreglo[i] )
    			return false;

    	}

        return true;
    }

    /**
     * Cambia los elementos de la lista de enteros por una nueva serie de valores generada de forma aleatoria.
     * 
     * Para generar los valores se debe partir de una distribución uniforme usando Math.random().
     * 
     * Los números en la lista deben quedar entre el valor mínimo y el máximo.
     * @param cantidad La cantidad de elementos que debe haber en la lista
     * @param minimo El valor mínimo para los números generados
     * @param maximo El valor máximo para los números generados
     */
    public void generarEnteros( int cantidad, int minimo, int maximo )
    {
    	this.listaEnteros = new ArrayList<Integer>( cantidad ); // reemplazar lista por uno de tamaño cantidad

    	int rango = maximo - minimo + 1; // generar el rango

    	for (int i = 0; i < cantidad; i++) {

    		this.listaEnteros.add(i, (int)(Math.random() * rango) + minimo);

    	}
    }

}
