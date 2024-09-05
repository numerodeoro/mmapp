/* importar librerias */
 
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

 /* declarar la clase con las herencias necesarias:
 implemento el ChangeListener, para los eventos 
 asociados a los JRadioButton */

  public class Inicio extends JFrame implements ActionListener{
    /* declaro las componentes*/

    private JTextField campito;
    private JButton boton;
    private JLabel label1, label3, label4;
    public static String texto ="";
    
    /* creo el constructor (debe llevar el nombre de la clase): 
    - coloco el metodo SetLayout para poder trabajar con coordenadas 
    dentro de mi grafica
    - comienzo con el diseño creando las componentes
    - con setBounds establezco el diseño, 
    - recordar el add(elemento) 
    - recordar el boton.addEventListener*/

     public Inicio(){
       setLayout(null);
       setDefaultCloseOperation(EXIT_ON_CLOSE); //quiero que no quede activo en segundo plano
       setTitle("Inicio");
       getContentPane().setBackground(new Color(33,97,140));
       setIconImage(new ImageIcon(getClass().getResource("images/phi.png")).getImage());

       ImageIcon imagen = new ImageIcon("images/logo3.png");
       label1 = new JLabel(imagen);
       label1.setBounds(125,15,200,200);
       add(label1);

       label3 = new JLabel("Nombre");
       label3.setBounds(75,250,200,30);
       label3.setFont(new Font("Arial",1,12));
       label3.setForeground(new Color(210,213,214));
       add(label3);

       label4 = new JLabel("2024-Tutorías Marti Torres");
       label4.setBounds(85,380,300,30);
       label4.setFont(new Font("Arial",4,12));
       label4.setForeground(new Color(210,213,214));
       add(label4);

       campito = new JTextField();
       campito.setBounds(75,278,300,25);
       campito.setBackground(new Color(224,224,224));
       campito.setFont(new Font("Arial",1,14));
       campito.setForeground(new Color(33,97,140));
       add(campito); 

       boton = new JButton("Ingresar");
       boton.setBounds(150,328,150,30);
       boton.setBackground(new Color(224,224,224));
       boton.setFont(new Font("Arial",1,14));
       boton.setForeground(new Color(33,97,140));
       boton.addActionListener(this);
       add(boton); 
  }

  /* fuera del constructor, programo los eventos. 
   Uso el método getSource para el boton */

    public void actionPerformed(ActionEvent e){
      if(e.getSource() == boton){
        texto = campito.getText().trim(); 
        //el metodo trim borra los espacios antes o despues del nombre
        if(texto.equals("")){
           JOptionPane.showMessageDialog(null, "Debes ingresar tu nombre.");
        }else{
           Comentarios comentarios = new Comentarios();
           comentarios.setBounds(0,0,450,450);
           comentarios.setVisible(true);
           comentarios.setResizable(false);
           comentarios.setLocationRelativeTo(null);
           this.setVisible(false);
      // la ultima linea cierra la interfaz actual 
     }
    } 
  }

 /* cierro la programacion de eventos y, dentro de la clase
declaro el main y le doy diseño a la interfaz grafica */

  public static void main(String[] args){
    Inicio inicio = new Inicio();
    inicio.setBounds(0,0,450,450);
    inicio.setVisible(true);
    inicio.setResizable(false);
    inicio.setLocationRelativeTo(null);
  }
  
}



