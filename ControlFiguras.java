package unidad2.proyecto;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.Line2D;
import java.awt.geom.RoundRectangle2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.*;

public class ControlFiguras {

    private Ellipse2D circulo;
    private Rectangle2D cuadrado;


    public void refrescarfigura(Graphics2D g) {
        Graphics2D g2d = (Graphics2D) g;

        //200x300
        g2d.setColor(Color.WHITE);
        g2d.fillRect(0, 0, 300, 200);
        g2d.drawRect(0, 0, 300, 200);
    }

    public void dibujarFigura(Graphics2D g, String figura, int opcionDeColor, Color color, float grosorLinea, int tamano, boolean lineaPunteada, int centroX, int centroY) throws IOException{
        Graphics2D g2d = (Graphics2D) g;
        
        BufferedImage bi=ImageIO.read(this.getClass().getResource("perro.jpg"));
        TexturePaint texturaPerro=new TexturePaint(bi,new Rectangle(20,20));
        
        // Configurar el grosor de la línea
        if (lineaPunteada) {
            float guiones[] = {10}; // especifica el patrón de guiones
            g2d.setPaint(Color.YELLOW);
            g2d.setStroke(new BasicStroke(4, BasicStroke.CAP_ROUND,
                    BasicStroke.JOIN_ROUND, 10, guiones, 0));
        } else {
            g2d.setStroke(new BasicStroke(grosorLinea));
        }
        switch (figura) {
            case "Cuadrado" -> {
                switch (opcionDeColor) {
                    case 1:
                        g2d.setColor(color);
                        g2d.fillRect(150 - (tamano / 2), 100 - (tamano / 2), tamano, tamano);
                        break;
                        
                    case 2:
                        g2d.setPaint(new GradientPaint(150 - (tamano / 2), 100 - (tamano / 2), Color.RED, tamano, tamano,
                                color, true));
                        g2d.fill(new Rectangle.Double(150 - (tamano / 2), 100 - (tamano / 2), tamano, tamano));
                        break;
                        
                    default:
                        g2d.setPaint(texturaPerro);
                        g2d.fill(new Rectangle.Double(150 - (tamano / 2), 100 - (tamano / 2), tamano, tamano));
                        break;
                }

                if (lineaPunteada) {
                    float guiones[] = {10};
                    g2d.setPaint(color);
                    g2d.setStroke(new BasicStroke(4, BasicStroke.CAP_ROUND,
                            BasicStroke.JOIN_ROUND, 10, guiones, 0));
                }
                g2d.setColor(Color.BLACK);
                g2d.drawRect(150 - (tamano / 2), 100 - (tamano / 2), tamano, tamano);
            }

            case "Círculo" -> {
                switch (opcionDeColor) {
                    case 1:
                        g2d.setColor(color);
                        g2d.fillOval(150 - (tamano / 2), 100 - (tamano / 2), tamano, tamano);
                        break;
                        
                    case 2:
                        g2d.setPaint(new GradientPaint(150 - (tamano / 2), 100 - (tamano / 2), Color.RED, tamano, tamano,
                                color, true));
                        g2d.fill(new Ellipse2D.Double(150 - (tamano / 2), 100 - (tamano / 2), tamano, tamano));
                        break;

                    default:
                        g2d.setPaint(texturaPerro);
                        g2d.fill(new Ellipse2D.Double(150 - (tamano / 2), 100 - (tamano / 2), tamano, tamano));
                        break;
                }
                g2d.setColor(Color.BLACK);
                g2d.drawOval(150 - (tamano / 2), 100 - (tamano / 2), tamano, tamano);
            }
            case "Cilindro" -> {
                switch (opcionDeColor) {
                    case 1:
                        g2d.setColor(color);
                        g2d.fillRect(centroX - (tamano / 4), centroY - (tamano / 2), tamano / 2, tamano);
                        g2d.setColor(Color.BLACK);
                        g2d.drawRect(centroX - (tamano / 4), centroY - (tamano / 2), tamano / 2, tamano);

                        g2d.setColor(color);
                        g2d.fillOval(centroX - (tamano / 4), (int) (centroY - (tamano / 1.5)), tamano / 2, tamano / 4);
                        g2d.fillOval(centroX - (tamano / 4), (int) (centroY + (tamano / 2.25)), tamano / 2, tamano / 4);
                        g2d.setColor(Color.BLACK);
                        g2d.drawOval(centroX - (tamano / 4), (int) (centroY - (tamano / 1.5)), tamano / 2, tamano / 4);
                        g2d.drawOval(centroX - (tamano / 4), (int) (centroY + (tamano / 2.25)), tamano / 2, tamano / 4);
                        break;
                        
                    case 2:
                        g2d.setPaint(new GradientPaint(centroX - (tamano / 4), centroY - (tamano / 2), Color.RED, tamano, tamano,
                                color, true));
                        g2d.fillRect(centroX - (tamano / 4), centroY - (tamano / 2), tamano / 2, tamano);
                        g2d.setColor(Color.BLACK);
                        g2d.drawRect(centroX - (tamano / 4), centroY - (tamano / 2), tamano / 2, tamano);

                        g2d.setPaint(new GradientPaint(centroX - (tamano / 4), centroY - (tamano / 2), Color.RED, tamano, tamano,
                                color, true));
                        g2d.fillOval(centroX - (tamano / 4), (int) (centroY - (tamano / 1.5)), tamano / 2, tamano / 4);
                        g2d.fillOval(centroX - (tamano / 4), (int) (centroY + (tamano / 2.25)), tamano / 2, tamano / 4);
                        g2d.setColor(Color.BLACK);
                        g2d.drawOval(centroX - (tamano / 4), (int) (centroY - (tamano / 1.5)), tamano / 2, tamano / 4);
                        g2d.drawOval(centroX - (tamano / 4), (int) (centroY + (tamano / 2.25)), tamano / 2, tamano / 4);
                        break;

                    default:
                        g2d.setPaint(texturaPerro);
                        g2d.fillRect(centroX - (tamano / 4), centroY - (tamano / 2), tamano / 2, tamano);
                        g2d.setColor(Color.BLACK);
                        g2d.drawRect(centroX - (tamano / 4), centroY - (tamano / 2), tamano / 2, tamano);

                        g2d.setPaint(texturaPerro);
                        g2d.fillOval(centroX - (tamano / 4), (int) (centroY - (tamano / 1.5)), tamano / 2, tamano / 4);
                        g2d.fillOval(centroX - (tamano / 4), (int) (centroY + (tamano / 2.25)), tamano / 2, tamano / 4);
                        g2d.setColor(Color.BLACK);
                        g2d.drawOval(centroX - (tamano / 4), (int) (centroY - (tamano / 1.5)), tamano / 2, tamano / 4);
                        g2d.drawOval(centroX - (tamano / 4), (int) (centroY + (tamano / 2.25)), tamano / 2, tamano / 4);
                        break;
                }
            }
        }
    }
}