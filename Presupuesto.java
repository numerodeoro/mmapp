import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;

public class Presupuesto extends JFrame implements ActionListener, ChangeListener, ItemListener{

// COMPONENTES
  private JMenuBar mb;
  private JMenu menuOpciones, menuAcercaDe;
  private JMenuItem miAutora, miInicio, miComentarios, miSalir, miNuevo;
  private JLabel lhoras, lcupon, lpresupuesto, lprecio, lfooter;
  private JTextField horas, precio;
  private JComboBox comboAlumnos, comboNivel;
  private JScrollPane scroll;
  private JTextArea campo;
  private JRadioButton sinCupon, c10, c20;
  private ButtonGroup grupo;
  private JButton boton;

  
  int pr = 0;
  float hrs = 0f;
  float multiplicador;
  float pack = 1f;
  float resultado = 0f;
  float agrup = 0f;
  float level = 0f;

  String cantAlumnos = "Cant. de alumnos";
  String cantHoras = "";
  String nivelMat = "Nivel de Materia";
  String precioBase = "";

// CONSTRUCTOR
  public Presupuesto(){
    setLayout(null);
    setDefaultCloseOperation(EXIT_ON_CLOSE); //quiero que no quede activo cuando se cierre
    setTitle("Presupuesto");
    getContentPane().setBackground(new Color(33,97,140)); //color de fondo
    setIconImage(new ImageIcon(getClass().getResource("images/phi.png")).getImage());

    //COMPONENTE JMENUBAR
    mb = new JMenuBar();
    mb.setBackground(new Color(33,97,140));
    setJMenuBar(mb);

    menuOpciones = new JMenu("Opciones");
    menuOpciones.setBackground(new Color (33,97,140));
    menuOpciones.setFont(new Font("Arial", 1, 14));
    menuOpciones.setForeground(new Color(210, 213, 214));
    mb.add(menuOpciones);

    menuAcercaDe = new JMenu("Acerca De");
    menuAcercaDe.setBackground(new Color (33,97,140));
    menuAcercaDe.setFont(new Font("Arial", 1, 14));
    menuAcercaDe.setForeground(new Color(210, 213, 214));
    mb.add(menuAcercaDe);

    // AGREGO LOS ITEMS
    miInicio = new JMenuItem("ir a Inicio");
    miInicio.setFont(new Font("Arial", 1, 14));
    miInicio.setForeground(new Color(33,97,140));
    miInicio.addActionListener(this);
    menuOpciones.add(miInicio);

    miComentarios = new JMenuItem("ver Comentarios");
    miComentarios.setFont(new Font("Arial", 1, 14));
    miComentarios.setForeground(new Color(33,97,140));
    miComentarios.addActionListener(this);
    menuOpciones.add(miComentarios);

    miSalir = new JMenuItem("Salir");
    miSalir.setFont(new Font("Arial", 1, 14));
    miSalir.setForeground(new Color(33,97,140));
    miSalir.addActionListener(this);
    menuOpciones.add(miSalir);
 
    miNuevo = new JMenuItem("Nuevo Cálculo");
    miNuevo.setFont(new Font("Arial", 1, 14));
    miNuevo.setForeground(new Color(33,97,140));
    miNuevo.addActionListener(this);
    menuOpciones.add(miNuevo);

    miAutora = new JMenuItem("La autora");
    miAutora.setFont(new Font("Arial", 1, 14));
    miAutora.setForeground(new Color(33,97,140));
    miAutora.addActionListener(this);
    menuAcercaDe.add(miAutora);
  
    // configuro las labels
    lpresupuesto = new JLabel("Presupuesto");
    lpresupuesto.setBounds(165,10,130,40);
    lpresupuesto.setFont(new Font("Arial",1, 18));
    lpresupuesto.setForeground(new Color(210,213,214));
    add(lpresupuesto);

    lhoras = new JLabel("Cantidad de Horas");
    lhoras.setBounds(10,130,180,20);
    lhoras.setFont(new Font("Arial", 1,12));
    lhoras.setForeground(new Color(210,213,214));
    add(lhoras);
    
    horas = new JTextField();
    horas.setBounds(10,150,180,30);
    horas.setBackground(new java.awt.Color(224,224,224));
    horas.setFont(new java.awt.Font("Arial", 1, 14));
    horas.setForeground(new java.awt.Color(33,97,140));
    add(horas);

    lprecio = new JLabel("Precio base");
    lprecio.setBounds(260,130,180,20);
    lprecio.setFont(new Font("Arial", 1,12));
    lprecio.setForeground(new Color(210,213,214));
    add(lprecio);
    
    precio = new JTextField();
    precio.setBounds(260,150,180,30);
    precio.setBackground(new java.awt.Color(224,224,224));
    precio.setFont(new java.awt.Font("Arial", 1,14));
    precio.setForeground(new java.awt.Color(33,97,140));
    add(precio);

    lcupon = new JLabel("Cupón");
    lcupon.setBounds(340,240,100,20);
    lcupon.setFont(new Font("Arial", 1,12));
    lcupon.setForeground(new Color(210,213,214));
    add(lcupon);

    grupo = new ButtonGroup();

    sinCupon = new JRadioButton("Sin Cupón");
    sinCupon.setBounds(340,260,100,30);
    sinCupon.setBackground(new Color(224,224,224));
    sinCupon.setFont(new Font("Arial",1,14));
    sinCupon.setForeground(new Color(33,97,140));
    //sinCupon.setSelected(true);
    sinCupon.addChangeListener(this);
    grupo.add(sinCupon);
    add(sinCupon);

    c10 = new JRadioButton("C10");
    c10.setBounds(340,285,100,30);
    c10.setBackground(new Color(224,224,224));
    c10.setFont(new Font("Arial",1,14));
    c10.setForeground(new Color(33,97,140));
    c10.addChangeListener(this);
    grupo.add(c10);
    add(c10);

    c20 = new JRadioButton("C20");
    c20.setBounds(340,310,100,30);
    c20.setBackground(new Color(224,224,224));
    c20.setFont(new Font("Arial",1,14));
    c20.setForeground(new Color(33,97,140));
    c20.addChangeListener(this);
    grupo.add(c20);
    add(c20); 

    lfooter = new JLabel("2024-Tutorías Marti Torres");
    lfooter.setBounds(85,360,300,30);
    lfooter.setFont(new Font("Arial",4,12));
    lfooter.setForeground(new Color(210,213,214));
    add(lfooter);

    comboAlumnos = new JComboBox();
    comboAlumnos.setBounds(10,70,180,30);
    comboAlumnos.setBackground(new java.awt.Color(224,224,224));
    comboAlumnos.setFont(new java.awt.Font("Arial", 1,14));
    comboAlumnos.setForeground(new java.awt.Color(33,97,140));
    add(comboAlumnos);
    comboAlumnos.addItem("Cant. de alumnos");
    comboAlumnos.addItem("1");
    comboAlumnos.addItem("2");
    comboAlumnos.addItem("3");
    comboAlumnos.addItem("4");
    comboAlumnos.addItem("5");
    comboAlumnos.addItemListener(this);

    comboNivel = new JComboBox();
    comboNivel.setBounds(260,70,180,30);
    comboNivel.setBackground(new java.awt.Color(224,224,224));
    comboNivel.setFont(new java.awt.Font("Arial", 1,14));
    comboNivel.setForeground(new java.awt.Color(33,97,140));
    add(comboNivel);
    comboNivel.addItem("Nivel de Materia");
    comboNivel.addItem("Básico");
    comboNivel.addItem("Avanzado");
    comboNivel.addItemListener(this);

    campo = new JTextArea();
    campo.setEditable(false);
    campo.setBackground(new Color(224,224,224));
    campo.setFont(new Font("Arial", 1,11));
    campo.setForeground(new Color(33,97,140));
    campo.setText("\n\n\n\n                    Aquí aparece el presupuesto.");
    scroll = new JScrollPane(campo);
    scroll.setBounds(10,210,320,130);
    add(scroll);

    boton = new JButton("Calcular");
    boton.setBounds(340,210,100,30);
    boton.setBackground(new Color(224,224,224));
    boton.setFont(new Font("Arial",1,14));
    boton.setForeground(new Color(33,97,140));
    add(boton);
    boton.addActionListener(this);
    
  }

    public void stateChanged(ChangeEvent c){

      if(sinCupon.isSelected()){
        multiplicador = 1f;
    } else if(c10.isSelected()){
        multiplicador = 0.9f;
    } else if(c20.isSelected()){
        multiplicador = 0.8f;
    }
  }

    public void itemStateChanged(ItemEvent e) {
 
      if (e.getSource() == comboAlumnos) {
        cantAlumnos = comboAlumnos.getSelectedItem().toString();

        try {
          agrup = cantAlumnos.equals("1")? 1f :(1 + 0.25f * Integer.parseInt(cantAlumnos)) / (float) Integer.parseInt(cantAlumnos);

        } catch (NumberFormatException ex) {
            // Manejo de error si la conversión falla
            agrup = 0f; 
        }
    } else if (e.getSource() == comboNivel) {
        nivelMat = comboNivel.getSelectedItem().toString();

        if(!nivelMat.equals("Nivel de Materia") && nivelMat!=null) {
          level = nivelMat.equals("Básico") ? 0.75f : 1f;

        } else {
            level = 0f; 
       }
        
    }
}


    public void actionPerformed(ActionEvent e){
      
      if(e.getSource() == boton){
            cantHoras = horas.getText().trim();
            precioBase = precio.getText().trim();
            float hrs = (horas.getText().matches("\\d*\\.?\\d+")) ? Float.parseFloat(horas.getText()) : 0.0f;
            int pr = (precio.getText().trim().matches("\\d+")) ? Integer.parseInt(precio.getText()) : 0;

            if( cantAlumnos == "Cant. de alumnos" || cantHoras == "" || nivelMat == "Nivel de Materia" ||precioBase == ""){
              campo.setText("\n\n   Hay un error: recuerde completar todos los campos.  "+
                          "\n   e indicar si tiene un cupón.  "+
                          "\n   La cantidad de horas debe ser un entero entre 1 y 20.  "+
                          "\n\n   El precio base es un entero que debes consultar en el  "+
                          "\n   sitio de la autora. (ver comentarios)  ");

          } else {

             if(Float.parseFloat(cantHoras)>0 && Float.parseFloat(cantHoras)<6){
               pack = 1f;
           } else if(Float.parseFloat(cantHoras)>=6 && Float.parseFloat(cantHoras)<12) {
               pack = 0.8f;
           } else if(Float.parseFloat(cantHoras)>=12 && Float.parseFloat(cantHoras)<=20){
               pack = 0.75f;
           } else {
               pack = 0f;
           }
        
             resultado = (float)multiplicador*level*agrup*pack*hrs*pr;
          
               if(resultado!=0){
                  campo.setText("\n\n   Cada alumno deberá abonar "+ Math.round(resultado) +" pesos.  ");
               } else {
                  campo.setText("\n\n   Hay un error: recuerde completar todos los campos  "+
                          "\n   e indicar si tiene un cupón.  "+
                          "\n   La cantidad de horas debe ser número entre 1 y 20.  "+
                          "\n\n   El precio base es un entero que debes consultar en el  "+
                          "\n   sitio de la autora. (ver comentarios)  ");
          }
        }
          
      } else if(e.getSource() == miSalir) {
          System.exit(0);

      } else if(e.getSource() == miInicio) {
          // agregamos el método main de la clase Inicio
          Inicio inicio = new Inicio();
          inicio.setBounds(0,0,450,450);
          inicio.setVisible(true);
          inicio.setResizable(false);
          inicio.setLocationRelativeTo(null);
          // cerramos la ventana actual
          this.setVisible(false);

      } else if (e.getSource() == miComentarios){
          // agregamos el método main de la clase Comentarios
          Comentarios comentarios = new Comentarios();
          comentarios.setBounds(0,0,450,450);
          comentarios.setVisible(true);
          comentarios.setResizable(false);
          comentarios.setLocationRelativeTo(null);
          // cerramos la ventana actual
          this.setVisible(false);

      } else if (e.getSource() == miNuevo) {
          // llevamos los estados a los JTextField, los JComboBox y el radio group a su valor inicial
          horas.setText("");
          precio.setText("");
          comboAlumnos.setSelectedIndex(0);
          comboNivel.setSelectedIndex(0);
          sinCupon.setSelected(true);

          campo.setText("\n Aquí aparece el presupuesto.");

      } else if (e.getSource() == miAutora){
          JOptionPane.showMessageDialog(null, "Desarrollado por Marti Torres,\n"+
                                              "        'número de oro'         ");
      }
 
    } 


    public static void main(String args[]){
      Presupuesto presupuesto = new Presupuesto();
      presupuesto.setBounds(0,0,450,450);
      presupuesto.setVisible(true);
      presupuesto.setResizable(false);
      presupuesto.setLocationRelativeTo(null);
  }

}


