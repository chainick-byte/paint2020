/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codigo.figuras;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;



/**
 *
 * @author xp
 */
public class Circulo extends Ellipse2D.Double {
    //color del circulo
    public Color color=Color.black;
    public boolean relleno=false;
    //constructor de la clase Circulo
    public Circulo(int _posX,int _posY,int _diametro, Color _color, boolean _relleno){
        //llamo al constructor de la clase Ellipse2d y a todo eso le aplicamos nuestras variables
        super();
        //asigno a la x de ellipse2d nuestra posicion x(_posX)
        x = _posX;
        y = _posY;
        width=_diametro;
        height=_diametro;
        color=_color;
        relleno=_relleno;
  
    }
    //aqui ponemos la capacidad del circulo se dibuja!!!!
    //este valor lo llamara la clase constructor de ellipse
    //graphics2d es el buffer donde dibujamos realmente
    public void dibujaTe(Graphics2D g2, int _posX){
        //casteamos el valor ya que si no , restamos del double el int,
        //double en este caso es es la x
        int diametro= Math.abs((int)x-_posX);
        width=diametro;
        height=diametro;
        
        g2.setColor(color);
        //pasamo como parametro el propio circulo (thus)
        if(relleno){
            g2.fill(this);
        }else{
            g2.draw(this);
        }
    }
    
}
