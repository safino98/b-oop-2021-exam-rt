package sk.stuba.fei.uim.oop.frame.picture;

import lombok.Getter;
import lombok.Setter;

import javax.swing.*;
import java.awt.*;

@Getter
@Setter
public class PaintThree extends JPanel {
    private int posx;
    private int posy;
    private int width;
    private int height;
    private int rPosx;
    private int rPosy;
    private int rWidth;
    private int rHeight;
    private Color color;
    private Graphics graphics;

    public PaintThree(Color color) {
        this.color = color;
    }

    public void paint(int x, int y, int width, int height){
        this.setOpaque(false);
        this.posx = x;
        this.posy = y;
        this.width = width;
        this.height = height;
        this.rPosx = x+(width/2)-(width/6);
        this.rPosy = y+height-(height/30);
        this.rWidth = width/3;
        this.rHeight = height/2;
        //this.color = c;
        paintComponent(graphics);

    }

    public void setpositions(int x, int y, int rx, int ry){
        this.posx = x;
        this.posy = y;
        this.rPosx = rx;
        this.rPosy =ry;
    }

    public void paintDone(){
        paintComponent(graphics);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(this.color);
        g.fillOval(posx, posy, width, height);
        g.fillRect(rPosx, rPosy, rWidth, rHeight);


    }
}
