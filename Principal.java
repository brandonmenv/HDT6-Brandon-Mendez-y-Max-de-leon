import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

import javax.swing.JOptionPane;


/**
   * @Principal.java  1.0 29/08/2014
   *
   * Universidad del Valle de Guatemala.
   * Seccion: 30 Estructura de Datos
   * @author Brandon Mendez Carnet: 13087
   * @author Max de leon: 13261
   * Programa principal de la HDT6
   * 
   *
   */


public class Principal<E> {

	public static void main(String[] args) {
		
		String respuest="";		
		if(respuest!=""){
			respuest=JOptionPane.showInputDialog("Ingrese la implementacion que desea utilizar"); 
			FactorySet<String> factory=new FactorySet<String>();
			factory.getSetImplementacion(respuest);
			
			
		}
		
		
		
		String programador = JOptionPane.showInputDialog("Ingrese "); 

		
		
		
		
		
	}
	
