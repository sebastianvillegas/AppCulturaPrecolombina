/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Caro
 */
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Image;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import com.panamahitek.ArduinoException;
import com.panamahitek.PanamaHitek_Arduino;
import java.awt.Color;

import jssc.SerialPortEvent;
import jssc.SerialPortEventListener;
import jssc.SerialPortException;

public class VistaJava extends JFrame{
	
	private JLabel fondo;
	PanamaHitek_Arduino arduino = new PanamaHitek_Arduino();
	
        SerialPortEventListener comListener = new SerialPortEventListener() {
		@Override
		public void serialEvent(SerialPortEvent arg0) {
			// TODO Auto-generated method stub
			
			try {
				if(arduino.isMessageAvailable()) {
                                    
                                    fondo = new javax.swing.JLabel();
					String opcion = arduino.printMessage();
                                        System.out.println(opcion);
					int op = Integer.parseInt(opcion);
                                        System.out.println("Hola" + op);
                                                
					//fondo.setText(opcion);
									
					ImageIcon icono;
                                        Image ic;
					Image imgEscalada;
					Icon iconoEscalado;
					
					switch(op) {
					  case 1:
                                              icono = new ImageIcon(getClass().getResource("/personajes1.jpg"));
					  		  imgEscalada = icono.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
					          iconoEscalado = new ImageIcon(imgEscalada);
					          fondo.setIcon(iconoEscalado);					          
					          break;
					  case 2: icono = new ImageIcon(getClass().getResource("/imagenes/personajes2.jpg"));
					  		  imgEscalada = icono.getImage().getScaledInstance(fondo.getWidth(), fondo.getHeight(), Image.SCALE_SMOOTH);
					          iconoEscalado = new ImageIcon(imgEscalada);
					          fondo.setIcon(iconoEscalado);
						      break;
					  case 3: icono = new ImageIcon(getClass().getResource("/imagenes/personajes3.jpg"));
					  		  imgEscalada = icono.getImage().getScaledInstance(fondo.getWidth(), fondo.getHeight(), Image.SCALE_SMOOTH);
					          iconoEscalado = new ImageIcon(imgEscalada);
					          fondo.setIcon(iconoEscalado);
						      break;
					  case 4: icono = new ImageIcon(getClass().getResource("/imagenes/personajes4.jpg"));
			  		  		  imgEscalada = icono.getImage().getScaledInstance(fondo.getWidth(), fondo.getHeight(), Image.SCALE_SMOOTH);
					          iconoEscalado = new ImageIcon(imgEscalada);
					          fondo.setIcon(iconoEscalado);
					          break;
					  case 5: icono = new ImageIcon(getClass().getResource("/imagenes/personajes5.jpg"));
					  		  imgEscalada = icono.getImage().getScaledInstance(fondo.getWidth(), fondo.getHeight(), Image.SCALE_SMOOTH);
					          iconoEscalado = new ImageIcon(imgEscalada);
					          fondo.setIcon(iconoEscalado);
					  		  break;
					  case 6: icono = new ImageIcon(getClass().getResource("/imagenes/personajes6.jpg"));
			  		  		  imgEscalada = icono.getImage().getScaledInstance(fondo.getWidth(), fondo.getHeight(), Image.SCALE_SMOOTH);
					          iconoEscalado = new ImageIcon(imgEscalada);
					          fondo.setIcon(iconoEscalado);
			  		  		  break;
					  case 7: icono = new ImageIcon(getClass().getResource("/imagenes/personajes7.jpg"));
			  		  		  imgEscalada = icono.getImage().getScaledInstance(fondo.getWidth(), fondo.getHeight(), Image.SCALE_SMOOTH);
					          iconoEscalado = new ImageIcon(imgEscalada);
					          fondo.setIcon(iconoEscalado);
					  case 8: icono = new ImageIcon(getClass().getResource("/imagenes/personajes8.jpg"));
			  		  		  imgEscalada = icono.getImage().getScaledInstance(fondo.getWidth(), fondo.getHeight(), Image.SCALE_SMOOTH);
					          iconoEscalado = new ImageIcon(imgEscalada);
					          fondo.setIcon(iconoEscalado);
			  		  		  break;
					}//end switch */
					
				}
			} catch (SerialPortException | ArduinoException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	};
	
	public VistaJava(){
				
		Container contenedor = getContentPane();
		contenedor.setLayout(new FlowLayout());
		
		fondo = new JLabel();		
		fondo.setPreferredSize(new Dimension(400,600));
				
		contenedor.add(fondo);
		
		setSize(400,600);
		this.setLocationRelativeTo(null);
		setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		try {
			arduino.arduinoRX("COM3", 9600, comListener);
		} catch (ArduinoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SerialPortException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
	}

}

