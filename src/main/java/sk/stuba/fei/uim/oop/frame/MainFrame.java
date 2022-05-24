package sk.stuba.fei.uim.oop.frame;

import sk.stuba.fei.uim.oop.frame.elements.Move;
import sk.stuba.fei.uim.oop.frame.elements.NextColor;
import sk.stuba.fei.uim.oop.frame.elements.PaintPanel;
import sk.stuba.fei.uim.oop.frame.elements.Three;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;

public class MainFrame extends JFrame implements ActionListener {
    private Three three;
    private Move move;

    public MainFrame() throws HeadlessException {
        super("Skuska");
        generateFrame();
        this.repaint();
        this.setVisible(true);
    }

    private void generateFrame(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(500, 500);
        this.setLayout(new BorderLayout());

        JPanel menu = new JPanel();
        menu.setLayout(new GridLayout(1,4));
        menu.setBackground(new Color(200,200,200));

        JLabel text = new JLabel(" Aktualne vybrate tlacidlo");
        JPanel labelBackround = new JPanel();

        this.three = new Three(text);
        this.move = new Move(text);
        NextColor nextColor = new NextColor(text, labelBackround);
        three.addActionListener(this);
        move.addActionListener(this);
        nextColor.addActionListener(this);

        PaintPanel panel = new PaintPanel(nextColor, three, move);

        labelBackround.add(text);
        menu.add(three);
        menu.add(move);
        menu.add(nextColor);
        menu.add(labelBackround);
        this.add(menu, BorderLayout.PAGE_START);
        this.add(panel);

    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        if (actionEvent.getActionCommand().equals("Pohyb")){
            three.setAllowed(false);
        }else if (actionEvent.getActionCommand().equals("Kreslenie")){
            move.setAllowed(false);
        }else if (actionEvent.getActionCommand().equals("Dalsia farba")){
            three.setAllowed(false);
            move.setAllowed(false);
        }
    }
}
