/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algoritmogenetico_baby;

import java.awt.*;
import javax.swing.*;
import java.util.*;
import java.awt.event.*;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author anton
 */
public class Frame extends JFrame{
	
    //Atributos
    private JFrame frame;
    private JPanel pnl;
    private JLabel etqTitle1, etqTitle2, etqSubtitle, etqPalabra, etqPoblacion, etqEvolucion;
    private JLabel etqSep1, etqSep2, etqSep3, etqDec;
    private JTextField txtPalabra, txtPoblacion, txtEvolucion;
    private JButton btnCalcular;
    private JTextArea txtArea, txtAreaTitle;
    private JScrollPane scroll;
    
    //Constructor
    public Frame(){
        frame = this;
        setTitle("Algoritmo Genetico Baby");
        setSize(1000,400);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);        
        initComponets();
        setVisible(true);
    }


    public void initComponets(){

        //CODIGO ATRIBUTOS
        Font fuenteTitle = new Font( "Calibri", 0, 30 );
        Font fuenteSubtitle = new Font( "Calibri", 1, 20 );
        Font fuenteOptionPane = new Font( "Calibri", 1, 16 );
        Font fuenteTexto = new Font( "Consolas", 0, 14 );
        Color colorGris = new Color(62,62,62);
        Color colorAmarillo = new Color(255,197,9);
        Color colorCafe = new Color(182,150,75);
        UIManager.put("OptionPane.messageFont", fuenteOptionPane);
        UIManager.put("OptionPane.messageForeground", Color.WHITE);
        UIManager.put("OptionPane.background", colorGris);
        UIManager.put("OptionPane.buttonFont", fuenteOptionPane);
        UIManager.put("Button.border", BorderFactory.createMatteBorder(5, 5, 5, 5, colorCafe));
        UIManager.put("Panel.background", colorGris);
        UIManager.put("Button.font", fuenteSubtitle);
        UIManager.put("Button.background", colorCafe);
        UIManager.put("Button.focus", colorCafe);
        UIManager.put("Button.foreground", colorGris);
        UIManager.put("Button.select", colorCafe);
        UIManager.put("TextField.foreground", Color.WHITE);
        UIManager.put("TextField.background", colorGris);
        UIManager.put("TextField.border", BorderFactory.createLineBorder(colorGris));
        UIManager.put("TextField.caretForeground", Color.WHITE);

        //CODIGO PANEL
        pnl = new JPanel();
        this.getContentPane().add(pnl);
        pnl.setBackground(colorGris);
        pnl.setLayout(null);

        //CODIGO TITULO
        etqTitle1 = new JLabel("Algoritmo");
        etqTitle1.setBounds(30,30,130,25);
        etqTitle1.setForeground(Color.WHITE);
        etqTitle1.setFont( fuenteTitle );
        pnl.add(etqTitle1);
        
        etqTitle2 = new JLabel("Genético");
        etqTitle2.setBounds(160,30,120,25);
        etqTitle2.setForeground(colorAmarillo);
        etqTitle2.setFont( fuenteTitle );
        pnl.add(etqTitle2);
        
        //CODIGO SUBTITULO
        etqSubtitle = new JLabel("Sistemas Expertos", SwingConstants.CENTER);
        etqSubtitle.setBounds(30,60,240,25);
        etqSubtitle.setForeground(colorGris);
        etqSubtitle.setOpaque(true);
        etqSubtitle.setBackground(colorAmarillo);
        etqSubtitle.setFont( fuenteSubtitle );
        pnl.add(etqSubtitle);
        
        //CODIGO PALABRA
        etqPalabra = new JLabel("Palabra:");
        etqPalabra.setBounds(30,130,80,25);
        etqPalabra.setForeground(colorAmarillo);
        etqPalabra.setFont( fuenteSubtitle );
        pnl.add(etqPalabra);
        
        txtPalabra = new JTextField("Hola mundo");
        txtPalabra.setHorizontalAlignment(SwingConstants.CENTER);
        txtPalabra.setBounds(110,130,160,20);
        txtPalabra.setFont( fuenteSubtitle );
        txtPalabra.addActionListener( new EventoTxtField());
        pnl.add(txtPalabra);
        
        etqSep1 = new JLabel();
        etqSep1.setBounds(110,150,160,3);
        etqSep1.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, colorAmarillo));
        pnl.add(etqSep1);
        
        //CODIGO POBLACION
        etqPoblacion = new JLabel("Población:");
        etqPoblacion.setBounds(30,170,90,25);
        etqPoblacion.setForeground(colorAmarillo);
        etqPoblacion.setFont( fuenteSubtitle );
        pnl.add(etqPoblacion);
        
        txtPoblacion = new JTextField("10");
        txtPoblacion.setHorizontalAlignment(SwingConstants.CENTER);
        txtPoblacion.setBounds(130,170,140,20);
        txtPoblacion.setFont( fuenteSubtitle );
        txtPoblacion.addActionListener( new EventoTxtField());
        pnl.add(txtPoblacion);
        
        etqSep2 = new JLabel();
        etqSep2.setBounds(130,190,140,3);
        etqSep2.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, colorAmarillo));
        pnl.add(etqSep2);
        
        //CODIGO GENERACION
        etqEvolucion = new JLabel("Generaciones:");
        etqEvolucion.setBounds(30,210,120,25);
        etqEvolucion.setForeground(colorAmarillo);
        etqEvolucion.setFont( fuenteSubtitle );
        pnl.add(etqEvolucion);
        
        txtEvolucion = new JTextField("500");
        txtEvolucion.setHorizontalAlignment(SwingConstants.CENTER);
        txtEvolucion.setBounds(160,210,110,20);
        txtEvolucion.setFont( fuenteSubtitle );
        txtEvolucion.addActionListener( new EventoTxtField());
        pnl.add(txtEvolucion);
        
        etqSep3 = new JLabel();
        etqSep3.setBounds(160,230,110,3);
        etqSep3.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, colorAmarillo));
        pnl.add(etqSep3);
        
        //CODIGO BOTON DATOS
        btnCalcular = new JButton("Calcular");
        btnCalcular.setVerticalAlignment(SwingConstants.CENTER);
        btnCalcular.setBounds(95,290,120,35);
        btnCalcular.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, colorCafe));
        btnCalcular.setFocusPainted(false);
        btnCalcular.setCursor(new Cursor(HAND_CURSOR));
        btnCalcular.addActionListener(new EventoBoton());
        pnl.add(btnCalcular);
        
        etqDec = new JLabel();
        etqDec.setBounds(90,290,5,35);
        etqDec.setOpaque(true);
        etqDec.setBackground(colorAmarillo);
        pnl.add(etqDec);
        
        //CODIGO CAJA DE TEXTO
        txtAreaTitle = new JTextArea();
        txtAreaTitle.setBounds(300,30,670,50);
        txtAreaTitle.setLineWrap(true);
        txtAreaTitle.setWrapStyleWord(true);
        txtAreaTitle.setBackground(Color.WHITE);
        txtAreaTitle.setFont(fuenteTexto);
        txtAreaTitle.setBorder(BorderFactory.createEmptyBorder());
        txtAreaTitle.setEditable(false);
        txtAreaTitle.append("\n  Gen.  Individuo         Aptitud\n");
        txtAreaTitle.append("  --------------------------------------------------------------------------------");
        pnl.add(txtAreaTitle);
        
        txtArea = new JTextArea();
        txtArea.setLineWrap(true);
        txtArea.setWrapStyleWord(true);
        txtArea.setBackground(Color.WHITE);
        txtArea.setFont(fuenteTexto);
        txtArea.setBorder(BorderFactory.createEmptyBorder());
        txtArea.setEditable(false);
        scroll = new JScrollPane(txtArea);
        scroll.setBounds(300,80,670,260);
        scroll.setBorder(BorderFactory.createEmptyBorder());
        pnl.add(scroll);
    }
    
    //CODIGO EVENTO ACTION
    public class EventoBoton implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent ev){
            
            txtAreaTitle.setText("");
            txtArea.setText("");
            
            if (txtPalabra.getText().length()==0 || txtPoblacion.getText().length()==0 || txtEvolucion.getText().length()==0)
                JOptionPane.showMessageDialog(null, "Falta rellenar un campo.","Valores incompletos",JOptionPane.WARNING_MESSAGE);
            else{
                int esp = 0, esp2 = 0;
                if(txtPalabra.getText().length()<=10)
                    esp = 9;    
                else{
                    esp = txtPalabra.getText().length() - 1;
                    
                    
                }
                txtAreaTitle.append("\n  Gen.  Individuo");
                for(int i=0 ; i<esp ; i++)
                    txtAreaTitle.append(" ");
                txtAreaTitle.append("Aptitud = " + txtPalabra.getText().length() + "\n");
                txtAreaTitle.append("  --------------------------------------------------------------------------------");

                AlgoritmoEvolutivo algEv = new AlgoritmoEvolutivo(Integer.parseInt(txtPoblacion.getText()), new StringBuilder(txtPalabra.getText()));
                algEv.init();
                StringBuilder genInicial = new StringBuilder("");
                
                for(int i=1 ; i<=Integer.parseInt(txtEvolucion.getText()) ; i++){
                    if(i==1){
                       genInicial = algEv.evolucion(true).append("\n");
                    }
                    txtArea.append("  " + i);
                    txtArea.append(algEv.evolucion(false).toString() + "\n");
                    
                    if(algEv.criterioParo){
                        txtArea.append("\n  Se ha llegado ya a la palabra en la generación " + (i+1) + "!\n");
                        break;
                    }
                }

                txtArea.append("\n  GENERACIÓN FINAL...\n");
                txtArea.append(algEv.evolucion(false).toString() + "\n");
                
                StringBuilder genFinal = algEv.evolucion(true).append("\n");
                
                txtArea.append("\n\n  -----------------------------------------------------------------------------");
                txtArea.append("\n  GENERACIÓN INICIAL VS FINAL...\n");
                txtArea.append("\n  INICIAL\n");
                txtArea.append(genInicial.toString());
                txtArea.append("\n  FINAL\n");
                txtArea.append(genFinal.toString());
                
                
            }
        }//evento
    }//clase interna
    
    //CODIGO EVENTO TEXT FIELD (PASAR A OTRO CAMPO CON INTRO)
    public class EventoTxtField implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent ev){
            if (txtPalabra.getText().length()==0 || txtPoblacion.getText().length()==0 || txtEvolucion.getText().length()==0)
                ((JComponent) ev.getSource()).transferFocus();
            else{        
                if (Integer.parseInt(txtPoblacion.getText())<=0 || Integer.parseInt(txtEvolucion.getText())<=0)
                    JOptionPane.showMessageDialog(null, "La Poblacion y las Generaciones deben ser mayores que 0.","Valores incorrectos",JOptionPane.WARNING_MESSAGE);
                else
                    btnCalcular.doClick();
            }
        }
    }
    
}
