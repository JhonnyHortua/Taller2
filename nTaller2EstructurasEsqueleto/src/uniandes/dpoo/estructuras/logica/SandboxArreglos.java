package uniandes.dpoo.estructuras.logica;

import java.util.HashMap;

/**
 * Esta clase tiene un conjunto de métodos para practicar operaciones sobre arreglos de enteros y de cadenas.
 *
 * Todos los métodos deben operar sobre los atributos arregloEnteros y arregloCadenas.
 * 
 * No pueden agregarse nuevos atributos.
 * 
 * Implemente los métodos usando operaciones sobre arreglos (ie., no haga cosas como construir listas para evitar la manipulación de arreglos).
 */
public class SandboxArreglos
{
    /**
     * Un arreglo de enteros para realizar varias de las siguientes operaciones.
     * 
     * Ninguna posición del arreglo puede estar vacía en ningún momento.
     */
    private int[] arregloEnteros;

    /**
     * Un arreglo de cadenas para realizar varias de las siguientes operaciones
     * 
     * Ninguna posición del arreglo puede estar vacía en ningún momento.
     */
    private String[] arregloCadenas;

    /**
     * Crea una nueva instancia de la clase con los dos arreglos inicializados pero vacíos (tamaño 0)
     */
    public SandboxArreglos( )
    {
        arregloEnteros = new int[]{};
        arregloCadenas = new String[]{};
    }

    /**
     * Retorna una copia del arreglo de enteros, es decir un nuevo arreglo del mismo tamaño que contiene copias de los valores del arreglo original
     * @return Una copia del arreglo de enteros
     */
    public int[] getCopiaEnteros( )
    {
    	int sizeEnteros = this.arregloEnteros.length;
    	int[] copiaEnteros = new int[sizeEnteros];

    	System.arraycopy(this.arregloEnteros, 0, copiaEnteros, 0, sizeEnteros);

        return copiaEnteros;
    }

    /**
     * Retorna una copia del arreglo de cadenas, es decir un nuevo arreglo del mismo tamaño que contiene copias de los valores del arreglo original
     * @return Una copia del arreglo de cadenas
     */
    public String[] getCopiaCadenas( )
    {
    	int sizeCadenas = this.arregloCadenas.length;
    	String[] copiaCadenas = new String[sizeCadenas];

    	System.arraycopy(this.arregloCadenas, 0, copiaCadenas, 0, sizeCadenas);

        return copiaCadenas;
    }

    /**
     * Retorna la cantidad de valores en el arreglo de enteros
     * @return
     */
    public int getCantidadEnteros( )
    {
    	int sizeEnteros = this.arregloEnteros.length;

        return sizeEnteros;
    }

    /**
     * Retorna la cantidad de valores en el arreglo de cadenas
     * @return
     */
    public int getCantidadCadenas( )
    {
    	int sizeCadenas = this.arregloCadenas.length;

        return sizeCadenas;
    }

    /**
     * Agrega un nuevo valor al final del arreglo. Es decir que este método siempre debería aumentar en 1 la capacidad del arreglo.
     * 
     * @param entero El valor que se va a agregar.
     */
    public void agregarEntero( int entero )
    {
    	int sizeEnteros = this.arregloEnteros.length;
    	int[] newEnteros = new int[sizeEnteros + 1];

    	System.arraycopy(this.arregloEnteros, 0, newEnteros, 0, sizeEnteros);

    	newEnteros[sizeEnteros] = entero;

    	this.arregloEnteros = newEnteros;
    }

    /**
     * Agrega un nuevo valor al final del arreglo. Es decir que este método siempre debería aumentar en 1 la capacidad del arreglo.
     * 
     * @param cadena La cadena que se va a agregar.
     */
    public void agregarCadena( String cadena )
    {

    	int sizeCadenas = this.arregloCadenas.length;
    	String[] newCadenas = new String[sizeCadenas + 1];

    	System.arraycopy(this.arregloCadenas, 0, newCadenas, 0, sizeCadenas);

    	newCadenas[sizeCadenas] = cadena;

    	this.arregloCadenas = newCadenas;
    }

    /**
     * Elimina todas las apariciones de un determinado valor dentro del arreglo de enteros
     * @param valor El valor que se va eliminar
     */
    public void eliminarEntero( int valor )
    {
    	int sizeEnteros = this.arregloEnteros.length;

    	int[] nuevosEnteros = {};

    	for (int i = 0; i < sizeEnteros; i++) {

    		if (this.arregloEnteros[i] != valor) {

    			int sizeNuevos = nuevosEnteros.length;

    			int[] tempArreglo = new int[sizeNuevos + 1];

    			for (int j = 0; j < sizeNuevos; j++) {

    				tempArreglo[j] = nuevosEnteros[j];

    			}

    			tempArreglo[sizeNuevos] = this.arregloEnteros[i];

    			nuevosEnteros = tempArreglo;

    		}

    	}

    	this.arregloEnteros = nuevosEnteros;

    }

    /**
     * Elimina todas las apariciones de un determinado valor dentro del arreglo de cadenas
     * @param cadena La cadena que se va eliminar
     */
    public void eliminarCadena( String cadena )
    {
    	int sizeEnteros = this.arregloCadenas.length;

    	String[] nuevasCadenas = {};

    	for (int i = 0; i < sizeEnteros; i++) {

    		if (this.arregloCadenas[i] != cadena) {

    			int sizeNuevos = nuevasCadenas.length;

    			String[] tempArreglo = new String[sizeNuevos + 1];

    			for (int j = 0; j < sizeNuevos; j++) {

    				tempArreglo[j] = nuevasCadenas[j];

    			}

    			tempArreglo[sizeNuevos] = this.arregloCadenas[i];

    			nuevasCadenas = tempArreglo;

    		}

    	}

    	this.arregloCadenas = nuevasCadenas;


    }

    /**
     * Inserta un nuevo entero en el arreglo de enteros.
     * 
     * @param entero El nuevo valor que debe agregarse
     * @param posicion La posición donde debe quedar el nuevo valor en el arreglo aumentado. Si la posición es menor a 0, se inserta el valor en la primera posición. Si la
     *        posición es mayor que el tamaño del arreglo, se inserta el valor en la última posición.
     */
    public void insertarEntero( int entero, int posicion )
    {
    	int sizeEnteros = this.arregloEnteros.length;

    	int[] nuevosEnteros = new int[sizeEnteros + 1]; // nuevo arreglo vacio 

    	if (posicion < 0) { // si la posicion es menor a 0, convertirla en 0

    		posicion = 0;

		} else if ( posicion > sizeEnteros) { // si la posicion es mayor o igual al tamaño del nuevo arreglo

			posicion = sizeEnteros; // convertirla al tamaño del nuevo arreglo

		}

    	boolean found = false; // inicar una variable de estado 


    	for (int i = 0; i < sizeEnteros + 1; i++) { // recorrer el nuevo arreglo en su totalidad + 1

    		if (i == posicion) { // si el ciclo llega a la posicion

    			nuevosEnteros[i] = entero; // insertar el entero

    			found = true; // cambiar variable de estado 

    		} else if ( !found ) { // si no se ha encontrado la posicion,

    			nuevosEnteros[i] = this.arregloEnteros[i]; // agregar el entero en su posicion correspondiente

    		} else { // si ya se encontro la posicion

    			nuevosEnteros[i] = this.arregloEnteros[i - 1]; // agregar el entero anterior en su posicion correspondiente

    		}

    	}

    	this.arregloEnteros = nuevosEnteros;
    }

    /**
     * Elimina un valor del arreglo de enteros dada su posición.
     * @param posicion La posición donde está el elemento que debe ser eliminado. Si el parámetro posicion no corresponde a ninguna posición del arreglo de enteros, el método
     *        no debe hacer nada.
     */
    public void eliminarEnteroPorPosicion( int posicion )
    {

    	int sizeEnteros = this.arregloEnteros.length;

    	if ( !(posicion < 0) && !(posicion > sizeEnteros - 1) ) { // si la posicion no en negativa y no es mayor al tamaño del arreglo

        	int[] nuevosEnteros = new int[sizeEnteros - 1]; // crear un nuevo arreglo con size-1 posiciones

        	boolean found = false; // iniciar una variable de estado

        	for (int i = 0; i < sizeEnteros; i++) { // recorrer el arreglo +1 para garantizar que se recorra

        		if ( i == posicion ) { // si se encuentra la posicion:

        			found = true; // cambiar variable de estado

        		} else if ( !found ) { // si no se ha encontrado la posicion:

        			nuevosEnteros[i] = this.arregloEnteros[i]; // agregar el entero en su posicion

        		} else { // si ya se encontro el entero

        			nuevosEnteros[i - 1] = this.arregloEnteros[i]; // insertar el entero en su posicion correspondiente

        		}

        	}

        	this.arregloEnteros = nuevosEnteros;

    	}

    }

    /**
     * Reinicia el arreglo de enteros con los valores contenidos en el arreglo del parámetro 'valores' truncados.
     * 
     * Es decir que si el valor fuera 3.67, en el nuevo arreglo de enteros debería quedar el entero 3.
     * @param valores Un arreglo de valores decimales.
     */
    public void reiniciarArregloEnteros( double[] valores )
    {

    	int sizeValores = valores.length; // obtener tamaño de valores
    	this.arregloEnteros = new int[sizeValores];

    	for (int i = 0; i < sizeValores; i++) {

    		this.arregloEnteros[i] = (int)valores[i];

    	}
    }

    /**
     * Reinicia el arreglo de cadenas con las representaciones como Strings de los objetos contenidos en el arreglo del parámetro 'objetos'.
     * 
     * Use el método toString para convertir los objetos a cadenas.
     * @param valores Un arreglo de objetos
     */
    public void reiniciarArregloCadenas( Object[] objetos )
    {
    	int sizeObjetos = objetos.length; // obtener tamaño de objetos

    	this.arregloCadenas = new String[sizeObjetos]; // reinicia el arreglo

    	for (int i = 0; i < sizeObjetos; i++) {

    		this.arregloCadenas[i] = objetos[i].toString();

    	}


    }

    /**
     * Modifica el arreglo de enteros para que todos los valores sean positivos.
     * 
     * Es decir que si en una posición había un valor negativo, después de ejecutar el método debe quedar el mismo valor muliplicado por -1.
     */
    public void volverPositivos( )
    {
    	int sizeEnteros = this.arregloEnteros.length;

    	for ( int i = 0; i < sizeEnteros; i++) {

    		int temp = this.arregloEnteros[i];

    		if (temp < 0) {
    			this.arregloEnteros[i] = -1*temp;
    		}

    	}
    }

    /**
     * Modifica el arreglo de enteros para que todos los valores queden organizados de menor a mayor.
     */
    public void organizarEnteros( )
    {
    	int sizeEnteros = this.arregloEnteros.length;

	    boolean swapped = true; // crear variable de estado

	    int j = 0; // crear variable para recortar el recorrido

	    while (swapped) { // verificar si aun hay cambios por hacer

	        swapped = false; // estado -> ordenado (asumir que no hay cambios por hacer)

	        j++; // tamaño del recorrido -1

	        for (int i = 0; i < sizeEnteros - j; i++) { // recorrer la "cola" no ordenada del arreglo de enteros

	            if (this.arregloEnteros[i] > this.arregloEnteros[i + 1]) { // si el entero es mayor al proximo entero

	            	int temp = this.arregloEnteros[i]; // crear variable temporal con el entero

	                this.arregloEnteros[i] = this.arregloEnteros[i + 1]; // intercambiar entero y el proximo entero para ordenar de menor a mayor

	                this.arregloEnteros[i + 1] = temp; // guardar elemento mayor en el próximo

	                swapped = true; // estado -> no ordenado (posibles cambios por hacer)
	            }
	        }
	    }
    }

    /**
     * Modifica el arreglo de cadenas para que todos los valores queden organizados lexicográficamente.
     */
    public void organizarCadenas( )
    {

    	int sizeCadenas = this.arregloCadenas.length;

	    boolean swapped = true; // crear variable de estado

	    int j = 0; // crear variable para recortar el recorrido

	    while (swapped) { // verificar si aun hay cambios por hacer

	        swapped = false; // estado -> ordenado (asumir que no hay cambios por hacer)

	        j++; // tamaño del recorrido -1

	        for (int i = 0; i < sizeCadenas - j; i++) { // recorrer la "cola" no ordenada del arreglo de cadenas

	            if ( this.arregloCadenas[i].compareTo(this.arregloCadenas[i + 1]) > 0 ) { // si la cadena supera la proxima cadena

	            	String temp = this.arregloCadenas[i]; // crear variable temporal con la cadena

	            	this.arregloCadenas[i] = this.arregloCadenas[i + 1]; // intercambiar cadena y la proxima cadena para ordenar de menor a mayor

	            	this.arregloCadenas[i + 1] = temp; // guardar cadena mayor en el proximo

	                swapped = true; // estado -> no ordenado (posibles cambios por hacer)
	            }
	        }
	    }
    }

    /**
     * Cuenta cuántas veces aparece el valor recibido por parámetro en el arreglo de enteros
     * @param valor El valor buscado
     * @return La cantidad de veces que aparece el valor
     */
    public int contarApariciones( int valor )
    {
        int sizeEnteros = this.arregloEnteros.length;

        int instancias = 0;

        for (int i = 0; i < sizeEnteros; i++) {

        	if (this.arregloEnteros[i] == valor) {

        		instancias += 1;

        	}

        }

        return instancias;
    }

    /**
     * Cuenta cuántas veces aparece la cadena recibida por parámetro en el arreglo de cadenas.
     * 
     * La búsqueda no debe diferenciar entre mayúsculas y minúsculas.
     * @param cadena La cadena buscada
     * @return La cantidad de veces que aparece la cadena
     */
    public int contarApariciones( String cadena )
    {
        int sizeCadenas = this.arregloCadenas.length;

        int instancias = 0;

        for (int i = 0; i < sizeCadenas; i++) {

        	if (this.arregloCadenas[i].toLowerCase().equals(cadena.toLowerCase()) ) {

        		instancias += 1;

        	}

        }

        return instancias;

    }

    /**
     * Busca en qué posiciones del arreglo de enteros se encuentra el valor que se recibe en el parámetro
     * @param valor El valor que se debe buscar
     * @return Un arreglo con los números de las posiciones del arreglo de enteros en las que se encuentra el valor buscado. Si el valor no se encuentra, el arreglo retornado
     *         es de tamaño 0.
     */
    public int[] buscarEntero( int valor )
    {
        int sizeEnteros = this.arregloEnteros.length;

        int[] instancias = {};

        for (int i = 0; i < sizeEnteros; i++) {

        	if (this.arregloEnteros[i] == valor) {

        		int sizeInstancias = instancias.length;

        		int[] temp = new int[sizeInstancias + 1];

        		for (int j = 0; j < sizeInstancias; j++) {

        			temp[j] = instancias[j];

        		}

        		temp[sizeInstancias] = i;

        		instancias = temp;

        	}

        }

        return instancias;

    }

    /**
     * Calcula cuál es el rango de los enteros (el valor mínimo y el máximo).
     * @return Un arreglo con dos posiciones: en la primera posición, debe estar el valor mínimo en el arreglo de enteros; en la segunda posición, debe estar el valor máximo
     *         en el arreglo de enteros. Si el arreglo está vacío, debe retornar un arreglo vacío.
     */
    public int[] calcularRangoEnteros( )
    {


    	int sizeEnteros = this.arregloEnteros.length;

    	if (sizeEnteros > 0) {
        	int menor = 0;
        	int mayor = 0;
    		for (int i = 0; i < sizeEnteros; i++) {

    			int temp = this.arregloEnteros[i];

    			if (i == 0) {
    				menor = temp;
    				mayor = temp;


    			}

					if ( temp < menor ) {
	
						menor = temp;
	
					}
	
					if (temp > mayor ) {
	
						mayor = temp;
					}

    			
        	}
    		
    		int[] rango = new int[2];

    		rango[0] = menor;

			rango[1] = mayor;

    		return rango;


    	} else {

    		int[] rango = {};

            return rango;
    	}
    }

    /**
     * Calcula un histograma de los valores del arreglo de enteros y lo devuelve como un mapa donde las llaves son los valores del arreglo y los valores son la cantidad de
     * veces que aparece cada uno en el arreglo de enteros.
     * @return Un mapa con el histograma de valores.
     */
    public HashMap<Integer, Integer> calcularHistograma( )
    {
    	int sizeEnteros = this.arregloEnteros.length;

    	HashMap<Integer, Integer> reps = new HashMap<Integer, Integer> ();

    	for (int i = 0; i < sizeEnteros; ++i) {

    	      int temp = this.arregloEnteros[i];

    	      if (reps.containsKey(temp)) {

    	    	  int currentValue = reps.get(temp);

    	    	  reps.put(temp, currentValue + 1);

    	      } else {

    	    	  reps.put(temp, 1);

    	      }

    	}

        return reps;
    }

    /**
     * Cuenta cuántos valores dentro del arreglo de enteros están repetidos.
     * @return La cantidad de enteos diferentes que aparecen más de una vez
     */
    public int contarEnterosRepetidos( )
    {
    	int sizeEnteros = this.arregloEnteros.length;

    	int countRepetidos = 0;
    	HashMap<Integer, Integer> reps = new HashMap<Integer, Integer> ();

    	for (int i = 0; i < sizeEnteros; ++i) {
    	      int temp = this.arregloEnteros[i];

    	      if (reps.containsKey(temp)) {
    	    	  int currentValue = reps.get(temp);

    	    	  if ( currentValue == 1) {

    	    		  reps.put(temp, currentValue + 1);

    	    		  countRepetidos += 1;
    	    	  }

    	      } else {
    	    	  reps.put(temp, 1);
    	      }

    	}

        return countRepetidos;
    }

    /**
     * Compara el arreglo de enteros con otro arreglo de enteros y verifica si son iguales, es decir que contienen los mismos elementos exactamente en el mismo orden.
     * @param otroArreglo El arreglo de enteros con el que se debe comparar
     * @return True si los arreglos son idénticos y false de lo contrario
     */
    public boolean compararArregloEnteros( int[] otroArreglo )
    {

    	int sizeEnteros = this.arregloEnteros.length;

    	int sizeOtro = otroArreglo.length;

    	if (sizeEnteros != sizeOtro) {

    		return false;

    	}

    	for ( int i = 0; i < sizeEnteros; i++ ) {

    		if ( this.arregloEnteros[i] != otroArreglo[i] ) {

    			return false;

    		}

    	}

    	return true;

    }

    /**
     * Compara el arreglo de enteros con otro arreglo de enteros y verifica que tengan los mismos elementos, aunque podría ser en otro orden.
     * @param otroArreglo El arreglo de enteros con el que se debe comparar
     * @return True si los elementos en los dos arreglos son los mismos
     */
    public boolean mismosEnteros( int[] otroArreglo )
    {
    	HashMap<Integer, Integer> elemsEnteros = new HashMap<Integer, Integer> (); // crear un mapa de elementos del arreglo de enteros

    	HashMap<Integer, Integer> elemsOtro = new HashMap<Integer, Integer> (); // crear un mapa de elementos del otro arreglo 

    	int sizeEnteros = this.arregloEnteros.length;

    	int sizeOtro = otroArreglo.length;

    	for (int i = 0; i < sizeEnteros; i++) {

    		int entero = this.arregloEnteros[i];

    		if ( !(elemsEnteros.containsKey(entero) ) ) {

    			elemsEnteros.put(entero, entero);

    		}

    	}

    	for (int i = 0; i < sizeOtro; i++) {

    		int entero = otroArreglo[i];

    		if ( !(elemsOtro.containsKey(entero) ) ) {

    			elemsOtro.put(entero, entero);
    		}

    	}

    	if ( elemsEnteros.size() != elemsOtro.size() ) { // verificar que la cantidad de enteros sea equivalente

    		return false;

    	}

    	for ( HashMap.Entry<Integer, Integer> entry : elemsEnteros.entrySet() ) { // por cada entry del mapa de elementos de enteros

    		int enterosKey = entry.getKey();

    		if ( !( elemsOtro.containsKey(enterosKey) ) ) { // si el mapa de otros no contiene la llave

    			return false;
    		}

    	}

        return true;
    }

    /**
     * Cambia los elementos del arreglo de enteros por una nueva serie de valores generada de forma aleatoria.
     * 
     * Para generar los valores se debe partir de una distribución uniforme usando Math.random().
     * 
     * Los números en el arreglo deben quedar entre el valor mínimo y el máximo.
     * @param cantidad La cantidad de elementos que debe haber en el arreglo
     * @param minimo El valor mínimo para los números generados
     * @param maximo El valor máximo para los números generados
     */
    public void generarEnteros( int cantidad, int minimo, int maximo )
    {
    	this.arregloEnteros = new int[cantidad]; // reemplazar arreglo por uno de tamaño cantidad

    	int rango = maximo - minimo + 1; // generar el rango

    	for (int i = 0; i < cantidad; i++) {

    		this.arregloEnteros[i] = (int)(Math.random() * rango) + minimo;

    	}
    }

}
