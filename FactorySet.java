import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

import javax.swing.JOptionPane;


/**
   * @FactorySet.java  1.0 29/08/2014
   *
   * Universidad del Valle de Guatemala.
   * Seccion: 30 Estructura de Datos
   * @author Brandon Mendez Carnet: 13087
   * @author Max de leon: 13261
   * Programa factory que selecciona la implementacion a utilizar
   * 
   *
   */


class FactorySet<E> {
	/*Se utiliza el factory para seleccionar la implementacion
	 * @Param entry: la eleccion de la implementacion
	 */
	public Set<E> getSetImplementacion(String entry){
		if (entry.equals("hashset")){		      
			return new HashSet<E>(); //regresa list
		}
		if (entry.equals("treeset")){

			return new TreeSet<E>(); //regresa list
		}
		
		if (entry.equals("linkedhashset")){
			return new LinkedHashSet<E>(); //regresa Vector
			
		}

		return null;
		
		
	}
}
