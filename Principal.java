import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

import javax.swing.JFrame;
import javax.swing.JOptionPane;


/**
   * @Principal.java  1.0 29/08/2014
   *
   * Universidad del Valle de Guatemala.
   * Seccion: 30 Estructura de Datos
   * @author Brandon Mendez Carnet: 13087
   * @author Max de leon: 13012
   * Programa principal de la HDT6
   * 
   *
   */


public class Principal<E> {

	private static JFrame frame;
	public static void main(String[] args) {
		
		InterfazGrafica in=new InterfazGrafica(frame);
		in.creandoInterfaz();		
		
	}
	
	

	

}
