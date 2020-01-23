/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codigo.figuras;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Polygon;

/**
 *
 * @author xp
 */
public class ClaseBaseDeTodasFormas extends Polygon  {
    
    public Color color = null;
    public boolean relleno = false;
    
    //importante en el circulo no hemos necesitado la x y la y , poligono tienen
    //diferencia del circulo la posicion x sera el centro del circulo 
    
    //coordenadas del centro de la forma
    
    public int x = 0;
    public int y = 0;
    
    public ClaseBaseDeTodasFormas(int _posX,int _posY, int _lados,Color _color,
                boolean _relleno){
        //al super hay que pasar dos arrays una con coordenadas x y otra con coordenadas 
        //y, que seran las coordenadas de los lados
        super(new int[_lados],new int [_lados],_lados);
        this.x=_posX;
        this.y=_posY;
        
        color=_color;
        relleno = _relleno;
    }
        public void dibujaTe(Graphics2D g2, int _posX,int _posY){
            
            calculaVertice(y-_posY,x-_posX);
            
        g2.setColor(color);
        if(relleno){
            g2.fill(this);
        }else{
            g2.draw(this);
        }
        }
        //este metodo recalcula la posicion de los vertices en el poligono rectangulas
        public void calculaVertice(int _radio, double _giro){
            //npoints equivale a _lados
            for(int i = 0; i<npoints;i++){
                //asi se llama internamente a la primera array de las posiciones x
                xpoints[i] = (int)(x + _radio*Math.cos(2*Math.PI * i +_giro/40/npoints));
                ypoints[i] = (int)(y + _radio*Math.sin(2*Math.PI * i +_giro/40/npoints));
            }
            
        }
    
    
    
    
    
    
    
    
    
    
    
    
}
