import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;



/**
   * @FactorySet.java  1.0 29/08/2014
   *
   * Universidad del Valle de Guatemala.
   * Seccion: 30 Estructura de Datos
   * @author Brandon Mendez Carnet: 13087
   * @author Max de leon: 
   * Programa factory que selecciona la implementacion a utilizar
   * 
   *
   */


public class FactorySet{
	/*Se utiliza el factory para seleccionar la implementacion
	 * @Param entry: la eleccion de la implementacion
	 */
	public Set<String> getSetImplementacion(String entry){
		if (entry.equals("hashset")){		      
			return new HashSet<String>(); //regresa hash
		}
		if (entry.equals("treeset")){
			return new TreeSet<String>(); //regresa treeset
		}
		if (entry.equals("linkedhashset")){
			return new LinkedHashSet<String>(); //regresa linked	
		}

		return null;
	}
	
	
	
	
}

