package sk.stuba.fei.uim.oop.frame.elements;

import lombok.Getter;
import lombok.Setter;
import sk.stuba.fei.uim.oop.frame.picture.PaintThree;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;

@Getter
@Setter
public class PaintPanel extends Canvas implements MouseListener, MouseMotionListener {
    private Color color;
    private PaintThree three;
    private ArrayList<PaintThree> threes = new ArrayList<PaintThree>();
    private int x, y;
    private NextColor colorButton;
    private Three threeButton;
    private Move move;
    private boolean moving;
    private int posx, posy;
    public PaintPanel(NextColor colorB, Three paintB, Move moveB) {
        this.setBackground(Color.WHITE);
        addMouseListener(this);
        addMouseMotionListener(this);
        this.colorButton = colorB;
        this.threeButton = paintB;
        this.move = moveB;
        x=0;
        y=0;
    }

    private boolean threeMove(){
        boolean canMove = false;
        System.out.println("vosiel som do funkcie");
        for (int i = 0; i<threes.size(); i++){
            if (threes.get(i)==null){
                System.out.println("kokot");
            }
            System.out.println(threes.get(i).getPosy() + " " + posy);
            if(threes.get(i).getPosy()<posy && (threes.get(i).getPosy()+threes.get(i).getHeight())>posy && threes.get(i).getPosx()<posx && (threes.get(i).getPosx()+threes.get(i).getWidth()>posx)){
                System.out.println("klikol si na strom");
                canMove = true;
                three = threes.get(i);
            }
        }
        return canMove;
    }

    @Override
    public void mouseClicked(MouseEvent mouseEvent) {

    }

    @Override
    public void mousePressed(MouseEvent mouseEvent) {
        if (threeButton.isAllowed()) {
            this.x = mouseEvent.getX();
            this.y = mouseEvent.getY();
            //System.out.println("PRESSED  x: " + mouseEvent.getX() + " + y: " + mouseEvent.getY());
            three = new PaintThree(colorButton.getColor());
            //three.setColor(color);
            three.setGraphics(getGraphics());
            three.paint(x, y, 1, 1);
            //three.paintComponents(getGraphics());
        }else if (move.isAllowed()){
            posx=mouseEvent.getX();
            posy=mouseEvent.getY();
            moving = threeMove();
        }
    }

    @Override
    public void mouseReleased(MouseEvent mouseEvent) {

            threes.add(three);
            three = null;
            repaint();


    }

    @Override
    public void mouseEntered(MouseEvent mouseEvent) {

    }

    @Override
    public void mouseExited(MouseEvent mouseEvent) {

    }

    @Override
    public void mouseDragged(MouseEvent mouseEvent) {
        if (threeButton.isAllowed()) {
            //System.out.println("DRAGGED  x: " + mouseEvent.getX() + " + y: " + mouseEvent.getY());
            int dx = mouseEvent.getX();
            int dy = mouseEvent.getY();
            if (three != null) {

                if (dx > x && dy > y) {
                    three.paint(x, y, dx - x, dy - y);
                }

                if (dx < x && dy > y) {
                    three.paint(dx, y, x - dx, dy - y);
                }

                if (dx > x && dy < y) {
                    three.paint(x, dy, dx - x, y - dy);
                }

                if (dx < x && dy < y) {
                    three.paint(dx, dy, x - dx, y - dy);
                }
            }
            repaint();
        }else if(moving){

            if (three != null) {
                int dx = mouseEvent.getX();
                int dy = mouseEvent.getY();
                if (dx > posx && dy > posy) {
                    three.paint(three.getRPosx(), three.getPosy(), three.getWidth(), three.getHeight());

                    //three.paint(three.getRPosx()+(dx-posx), three.getPosy()+(dy-posy), three.getWidth(), three.getHeight());
                    //three.setpositions(three.getPosx() + dx - posx, three.getPosy() + dy - posy, three.getRPosx() + dx - posx, three.getRPosy() + dy - posy);
                }
/*
                if (dx < x && dy > y) {
                    three.paint(dx, y, x - dx, dy - y);
                }

                if (dx > x && dy < y) {
                    three.paint(x, dy, dx - x, y - dy);
                }

                if (dx < x && dy < y) {
                    three.paint(dx, dy, x - dx, y - dy);
                }*/
                repaint();
            }
        }
    }


    @Override
    public void mouseMoved(MouseEvent mouseEvent) {

    }

    public void paint(Graphics g){

        for (PaintThree paintThree : threes) {
            if(paintThree != null) {
                paintThree.paintDone();
            }
        }
        if (three != null){
            three.paintDone();
        }
    }
}
