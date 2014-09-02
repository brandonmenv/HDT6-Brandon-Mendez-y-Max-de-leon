
/**
   * @IntefazGrafica.java  1.0 29/08/2014
   *
   * Universidad del Valle de Guatemala.
   * Seccion: 30 Estructura de Datos
   * @author Brandon Mendez Carnet: 13087
   * @author Max de leon: 
   * Gui de la hoja de trabajo no.6 
   * 
   *
   */



//Importando librerias utiles
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

import java.awt.*;
import java.awt.event.*;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

import java.util.*;

public class InterfazGrafica extends JPanel implements ActionListener{
	
	/**ATRIBUTOS**/
	private static JFrame frame;										//frame principal de la GUI y frame de control de errores
	private JTextArea areatexto; 
    private JComboBox<String> comboBox;
	private JButton btonHash,btonTree, btonLinked,btonResultados;
	private static String comHash="comhash",comTree="comtree",comLinked="comlinked",comEnviar="comenviar",comResultados="comresultados";
	Set<String> programadoresWeb;
	Set<String> programadoresJava;
	Set<String> programadoresCel;
	private JTextField jNombre;
	private String tipoProgramador="",implementacion="";
	private JButton btonEnviar;
	private String resultado="";
	/**
	* Constructor con un parametro que es un frame de control de errores
	* @param v El parámetro v es un frame que sirve para mostrarle errores de ingreso al usuario
	*/
	public InterfazGrafica(JFrame v){

		//Construyendo paneles de la interfaz				
		JComponent panelImplementacion=panelImplementacion();
		JComponent panelResultado=panelResultado();
		JComponent panelEnviar=panelEnviar(); 
		JComponent panelNombre=panelNombre(); 

		
		add(panelImplementacion);
		add(panelNombre);
		add(panelEnviar);
		add(panelResultado);
		
		jNombre.setEnabled(false);
		btonEnviar.setEnabled(false);


	}	
	
	
	/**
	* Método que devuelve el panel el label y field para que ingrese el nombre del programador
	* @return JPanel con text field
	*/	  									  							  
		protected JComponent panelNombre(){
			jNombre = new JTextField(15);
			JLabel lblNombre = new JLabel("Ingrese el nombre del programador: ");
            lblNombre.setLabelFor(jNombre);							
    
            JPanel panelTexto = new JPanel(new GridLayout(0,1));			//Creando panel de texto 
            
            Border bordejpanel = new TitledBorder(new EtchedBorder(), "Datos Personales");
            panelTexto.setBorder(bordejpanel); 
            //Agregando al panel de texto
            panelTexto.add(lblNombre);
            panelTexto.add(jNombre);
        

            return panelTexto;
		

	}
		

		
		
		
	/**
	* Método que devuelve el panel un boton para enviar los datos del programador
	* @return JPanel con boton
	*/	  									  							  
		protected JComponent panelEnviar(){
			JPanel panel = new JPanel(new GridLayout(0,1));									//Creando panel con un Gridlayout con 0 filas 1 columna
			panel.setBorder(BorderFactory.createTitledBorder(" Ingresar programador. ")); 		
			panel.setPreferredSize(new Dimension(175,50));     							//Cambiandolo de tamanio
			
			btonEnviar=new JButton("Enviar");
			btonEnviar.setActionCommand(comEnviar);											//Comando de boton
			btonEnviar.addActionListener(this);												//Asignando listener
											//Asignando listener
			
			panel.add(btonEnviar);
			
			return panel;
	}
	
	/**
	* Método que devuelve el panel con los botones para seleccionar la implementacion de set que desean utilizar
	* @return JPanel textfield y label
	*/	  									  							  
		protected JComponent panelImplementacion(){
		JPanel panel = new JPanel(new GridLayout(0,1));									//Creando panel con un Gridlayout con 0 filas 1 columna
		panel.setBorder(BorderFactory.createTitledBorder(" Seleccione el tipo de implementacion que desea utilizar. ")); 		
		panel.setPreferredSize(new Dimension(250, 100));     							//Cambiandolo de tamanio
		
		btonHash=new JButton("HashSet");
		btonHash.setActionCommand(comHash);											//Comando de boton
		btonHash.addActionListener(this);												//Asignando listener
		
		btonTree=new JButton("TreeSet");
		btonTree.setActionCommand(comTree);											//Comando de boton
		btonTree.addActionListener(this);												//Asignando listener
		
		btonLinked=new JButton("LinkedHashSet");
		btonLinked.setActionCommand(comLinked);											//Comando de boton
		btonLinked.addActionListener(this);												//Asignando listener
		
		panel.add(btonHash);
		panel.add(btonTree);
		panel.add(btonLinked);

		
		return panel;
	}
			
	/**
	* Método que devuelve el panel con una caja de texto y scroll para mostrar los resultados
	* @return JPanel con una caja de texto y scroll
	*/	  									  							  
		protected JComponent panelResultado(){
		JPanel panel = new JPanel(new GridLayout(0,1));									//Creando panel con un Gridlayout con 0 filas 1 columna
		panel.setBorder(BorderFactory.createTitledBorder(" Resultados. ")); 		
		panel.setPreferredSize(new Dimension(400, 300));     							//Cambiandolo de tamanio
		
	    areatexto = new JTextArea ( 16, 58 );
	    areatexto.setEditable ( false ); // set textArea non-editable
	    JScrollPane scroll = new JScrollPane ( areatexto );
	    scroll.setVerticalScrollBarPolicy ( ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS );

	    panel.add ( scroll );
		
	    btonResultados=new JButton("Mostrar Resultados");
	    btonResultados.setActionCommand(comResultados);											//Comando de boton
	    btonResultados.addActionListener(this);	
		
		
		panel.add(btonResultados);
	
		return panel;
	}	
	
	
			


	


	/**
	*	GESTIONADOR DE EVENTOS: Permite gestionar todos los eventos de la clase.
	* @see ActionEvent
	* @see ActionListener
	*/						  
	public void actionPerformed(ActionEvent e){									//Empieza el control de eventos
		String comando = e.getActionCommand();										//String del comando de accion			
		
		if(comando.equals(comHash)){
			implementacion="hashset";
			FactorySet factory=new FactorySet();
			
			programadoresWeb= factory.getSetImplementacion("hashset");
			programadoresJava= factory.getSetImplementacion("hashset");
			programadoresCel= factory.getSetImplementacion("hashset");
			
			jNombre.setEnabled(true);
			btonEnviar.setEnabled(true);

			btonHash.setEnabled(false);
			btonTree.setEnabled(false);
			btonLinked.setEnabled(false);
		}
	
		if(comando.equals(comTree)){
			implementacion="treeset";
			FactorySet factory=new FactorySet();
	
			programadoresWeb= factory.getSetImplementacion("treeset");
			programadoresJava= factory.getSetImplementacion("treeset");
			programadoresCel= factory.getSetImplementacion("treeset");
	
			
			jNombre.setEnabled(true);
			btonEnviar.setEnabled(true);

			btonHash.setEnabled(false);
			btonTree.setEnabled(false);
			btonLinked.setEnabled(false);
		}
		
		if(comando.equals(comLinked)){
			implementacion="linkedhashset";
			FactorySet factory=new FactorySet();
		

			programadoresWeb= factory.getSetImplementacion("linkedhashset");
			programadoresJava= factory.getSetImplementacion("linkedhashset");
			programadoresCel= factory.getSetImplementacion("linkedhashset");
	
			
			jNombre.setEnabled(true);
			btonEnviar.setEnabled(true);

			btonHash.setEnabled(false);
			btonTree.setEnabled(false);
			btonLinked.setEnabled(false);
			
		}
		
		if(comando.equals(comEnviar)){
			if(!jNombre.getText().equals("")){	

				int reply=0,reply2 = 0,reply3 = 0;
				
				reply = JOptionPane.showConfirmDialog(null, "Tiene experiencia en programacion Java", "Programacion Java", JOptionPane.YES_NO_OPTION);
		        if (reply == JOptionPane.YES_OPTION) {
					programadoresJava.add(jNombre.getText());
					JOptionPane.showMessageDialog(frame, "Se ha ingresado un nuevo programador");
		        }else {
			    }
				
		        
		        reply2 = JOptionPane.showConfirmDialog(null, "Tiene experiencia en programacion Web", "Programacion Web", JOptionPane.YES_NO_OPTION);
		        if (reply2 == JOptionPane.YES_OPTION) {
					programadoresWeb.add(jNombre.getText());
					JOptionPane.showMessageDialog(frame, "Se ha ingresado un nuevo programador");
		        }else {
		        }
		        
		        reply3 = JOptionPane.showConfirmDialog(null, "Tiene experiencia en programacion de Celulares", "Programacion de Celulares", JOptionPane.YES_NO_OPTION);
		        if (reply3 == JOptionPane.YES_OPTION) {
					programadoresCel.add(jNombre.getText());
					JOptionPane.showMessageDialog(frame, "Se ha ingresado un nuevo programador");
		        }else {
		        }
		        
		        
		        if(reply!=JOptionPane.YES_OPTION && reply2!=JOptionPane.YES_OPTION && reply3!=JOptionPane.YES_OPTION){

		        	JOptionPane.showMessageDialog(frame, "No se ha ingresado ningun nuevo programador a ningun conjunto porque no eligio un conjunto valido.");
		        }
						
				
				
				
				
			}else{
				JOptionPane.showMessageDialog(frame, "Los datos ingresados no son correctos!");

			}
		}
		
		
		if(comando.equals(comResultados)){
			
			if(!implementacion.equals("")){
				for(int i=0; i<=0; i++){
					areatexto.setText(muestraResultados());
				}
			}
			
			
			
		}

	}//Final de gestionador de eventos	

	/**
	* creandoInterfaz:Metodo que crea el Frame principal, el contenedor principal y muestra la interfaz grafica
	* @see windowActivated */
	public void creandoInterfaz() {
		frame = new JFrame(" Hoja de trabajo No 6. ");			        						//Creando la ventana principal
		frame.setPreferredSize(new Dimension(480, 450)); 						//colocar caracteristicas al frame (tamaÃ±o)
		
		this.setOpaque(true); 													//Se vuelve opaco el panel de contenido para que no sea diferenciado
		frame.setContentPane(this);												//Estableciendo el panel principal.
		frame.setResizable(false);												//Bloqueando la maximizaciÃ³n de la ventana
		
		frame.setDefaultCloseOperation (WindowConstants.DO_NOTHING_ON_CLOSE);	//Asegurandose de que el evento foco se valla al Panel principal
		frame.addWindowListener(new WindowAdapter() {							//El evento foco se centra en este panel no importa que
		//Cerrando con confirmacion
		public void windowClosing(WindowEvent we){
			int eleccion = JOptionPane.showConfirmDialog(null, "¿Desea salir?");
				if ( eleccion == 0) {
					System.exit(0);
				}  
			}
		});
		
		//Mostrando el frame
		frame.pack();
		frame.setLocationRelativeTo(null);;										//Frame en el centro
		frame.setVisible(true);	
	}

	

	
	
	public String muestraResultados(){
		/*
		 * Inicializando resultado para que en otra corrida
		 * no llene los valores que ya tenia
		 */
		resultado="";
		
		/*Se crea un factoru para poder crear Sets temporales para manejar los conjuntos de programadores definidos*/
		FactorySet factory=new FactorySet();

		Set <String> requerimiento1 = factory.getSetImplementacion(implementacion);
        Set <String> requerimiento2= factory.getSetImplementacion(implementacion);
        Set <String> requerimiento3 = factory.getSetImplementacion(implementacion);
        Set <String> requerimiento4 = factory.getSetImplementacion(implementacion);
        Set <String> requerimiento6 = factory.getSetImplementacion(implementacion);
       
        /*
         * Resolviendo Requerimiento no.1
         * Desarrolladores con experiencia en Web o Celulares (unión de Web y Celuares), pero que no tengan experiencia en java. 
         */
        requerimiento1.addAll(programadoresWeb);
        requerimiento1.retainAll(programadoresJava);
        requerimiento1.retainAll(programadoresCel);
        
		resultado+="La interseccion de los 3 conjuntos es: "+requerimiento1;

		 /*
         * Resolviendo Requerimiento no.4
         * Desarrolladores con experiencia en Web o Celulares (unión de Web y Celuares), pero que no tengan experiencia en java. 
         */
		 requerimiento2.addAll(programadoresJava);
		 requerimiento2.removeAll(programadoresWeb);
         resultado+="\nTrabajadores con experiencia en Java pero no en web:"+requerimiento2;
         
         /*
          * Resolviendo Requerimiento no.3
          * Desarrolladores con experiencia en Web o Celulares (unión de Web y Celuares), pero que no tengan experiencia en java. 
          */
         requerimiento3.addAll(programadoresCel);
         requerimiento3.retainAll(programadoresWeb);
         requerimiento3.removeAll(programadoresJava);
         resultado+="\nExpereincia en Web y celulares pero no en java:"+ requerimiento3;
         
         /*
          * Resolviendo Requerimiento no.4
          * Desarrolladores con experiencia en Web o Celulares (unión de Web y Celuares), pero que no tengan experiencia en java. 
          */
         requerimiento4.addAll(programadoresWeb);
         requerimiento4.addAll(programadoresCel);
         requerimiento4.removeAll(programadoresJava);
         resultado+="\nExperiencia en Web o celulares pero no en java:"+requerimiento4;
         
         
         /*
          * Resolviendo el requerimiento no.5
          * Indicar SI o NO el conjunto de desarrolladores Java es un subconjunto de Desarrolladores Web. 
          */
         boolean bandera=programadoresJava.containsAll(programadoresWeb);
     
         if(bandera==false){
             resultado+="\nEl conjunto de java no es subconjunto del conjunto web";
         }
         if(bandera==true){
             resultado+="\nEl conjunto de java es subconjunto del conjunto web";
         }
         
         /*
          * Resolviendo requerimiento no.6
          * El conjunto (Java, Web o Celulares) que tenga la cantidad más grande de desarrolladores, y los nombres de esos desarrolladores.
          */
 
         if(programadoresWeb.size()>programadoresJava.size() && programadoresWeb.size()>programadoresCel.size()){
        	 resultado+="\nEl conjunto con mas desarrolladores es el web. ";
        	 resultado+="Sus nombres son:" + programadoresWeb;
             requerimiento6=programadoresWeb;
         }
       
         if (programadoresJava.size()>programadoresWeb.size()&& programadoresJava.size()>programadoresCel.size()){
             resultado+="\nEl conjunto con mas desarrolladores es el de Java. ";
             resultado+="Sus nombres son:" + programadoresJava;
             requerimiento6=programadoresJava;
         }
         
         if (programadoresCel.size()>programadoresWeb.size()&& programadoresCel.size()>programadoresJava.size())
         {
        	 resultado+="\nEl conjunto con mas desarrolladores es el de Java. ";
        	 resultado+="Sus nombres son:" + programadoresCel;
             requerimiento6=programadoresCel;
         }
         
         /*
          * Resolviendo requerimiento no.7
          * Del conjunto que tenga la mayor cantidad de desarrolladores, desplegar la lista de los nombres de sus integrantes en orden ascendente. 
          */
         Set ordenAscendente = new TreeSet(requerimiento6);
         resultado+="\nImpresion del conjunto con mas numero de elementos:\n"+ordenAscendente;

		
		return resultado;
        
        
		
	}
	

}



