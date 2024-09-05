//librerías
import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;

// declaro la clase con sus herencias e implementaciones
public class Comentarios extends JFrame implements ChangeListener, ActionListener{

  //componentes
  private JLabel label1, label2;
  private JCheckBox check1;
  private JButton boton1, boton2;
  private JScrollPane scroll;
  private JTextArea campo;
  String nombre =""; //variable para alojar el nombre

  //constructor
  public Comentarios(){
    setLayout(null);
    setDefaultCloseOperation(EXIT_ON_CLOSE); //quiero que no quede activo en segundo plano
    
    setTitle("Comentarios de la autora");
    getContentPane().setBackground(new Color(33,97,140));
    setIconImage(new ImageIcon(getClass().getResource("images/phi.png")).getImage());
    Inicio inicio = new Inicio(); // creo el objeto que me permita recuperar la variable texto de la otra ventana
    nombre = inicio.texto;
    
    label1 = new JLabel("Información y aclaraciones");
    label1.setBounds(100,10,250,40);
    label1.setFont(new Font("Arial", 1, 18));
    label1.setForeground(new Color (210,213,214));
    add(label1);

    campo = new JTextArea();
    campo.setEditable(false);
    campo.setBackground(new Color(224,224,224));
    campo.setFont(new Font("Arial", 0, 13));
    campo.setForeground(new Color(33,97,140));
    campo.setText("\n\n          	Lo que debes saber: "+
"\n\n     ** El precio base en Agosto de 2024 es el número 15000, fuera"+ 
"\n     de esas fechas, debes actualizarlo consultando en mi perfil"+
"\n\n     ** La aplicación no registrará tus datos, no serán copiados "+
"\n     ni guardados."+
"\n\n     ** Puedes chequear el nivel de tu materia al cotizar"+ 
"\n     escribiendo a Marti Torres al 11 6979 9117."+
"\n\n     ** Este programa fue escrito en JAVA, utilizando notepad para "+ 
"\n        escribir el código y jdk para compilar."+
"\n\n     ** Utilicé las librerías swing y awt."+
"\n\n     ** Si quieres más información sobre mí puedes visitarme en "+
"\n https://www.instagram.com/numerodeorophi?igsh=MXJicmh2NWxtM2cwMA== "+
"\n\n");
    scroll = new JScrollPane(campo);
    scroll.setBounds(10,50,430,200);
    add(scroll);

    check1 = new JCheckBox("Yo, "+nombre+", leí los comentarios");
    check1.setBounds(10,260,270,30);
    check1.setBackground(new Color(224,224,224));
    check1.setFont(new Font("Arial",1,13));
    check1.setForeground(new Color(33,97,140));
    check1.addChangeListener(this);
    add(check1);
    
    boton1 = new JButton("Presupuesto");
    boton1.setBounds(10,300,130,30);
    boton1.setBackground(new Color(224,224,224));
    boton1.setFont(new Font("Arial",1,14));
    boton1.setForeground(new Color(33,97,140));
    boton1.addActionListener(this);
    boton1.setEnabled(false);
    add(boton1);
    
    boton2 = new JButton("ir a Inicio");
    boton2.setBounds(150,300,130,30);
    boton2.setBackground(new Color(224,224,224));
    boton2.setFont(new Font("Arial",1,14));
    boton2.setForeground(new Color(33,97,140));
    boton2.addActionListener(this);
    boton2.setEnabled(true);
    add(boton2);

    label2 = new JLabel("2024-Tutorías Marti Torres");
    label2.setBounds(85,380,300,30);
    label2.setFont(new Font("Arial",4,12));
    label2.setForeground(new Color(210,213,214));
    add(label2);
 }
 
  //Programacion de eventos
  public void stateChanged(ChangeEvent e){
    if(check1.isSelected() == true){
       boton1.setEnabled(true);
       boton2.setEnabled(false);
    }else{
       boton1.setEnabled(false);
       boton2.setEnabled(true);
    }
 }
  public void actionPerformed(ActionEvent e){
     if(e.getSource() == boton1){
        // copio el main de la ventana Presupuesto
        Presupuesto presupuesto = new Presupuesto();
        presupuesto.setBounds(0,0,450,450);
        presupuesto.setVisible(true);
        presupuesto.setResizable(false);
        presupuesto.setLocationRelativeTo(null);
        //cierro la ventana actual
        this.setVisible(false);

     }else if(e.getSource() == boton2){
        // copio el main de la ventana Inicio
        Inicio inicio = new Inicio();
         inicio.setBounds(0,0,450,450);
         inicio.setVisible(true);
         inicio.setResizable(false);
         inicio.setLocationRelativeTo(null);
        //cierro la ventana actual
        this.setVisible(false);
     }
 }
  
  //método main
  public static void main(String[] args){
   Comentarios comentarios = new Comentarios();
   comentarios.setBounds(0,0,450,450);
   comentarios.setVisible(true);
   comentarios.setResizable(false);
   comentarios.setLocationRelativeTo(null);
 }
}