package sk.stuba.fei.uim.oop.frame.elements;

import lombok.Getter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NextColor  extends JButton implements ActionListener {

    private Color color;
    private int klik;
    private JLabel label;
    private JPanel panel;

    public NextColor(JLabel la, JPanel pan) {
        super("Dalsia farba");
        addActionListener(this);
        this.color=Color.BLUE;
        this.label = la;
        this.panel = pan;
        klik = 0;
        label.setBackground(color);
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        klik++;
        if (klik == 1) {
            this.color = Color.green;
        }else if(klik == 2){
            this.color = Color.red;
        }else if (klik==3){
            this.color = Color.BLUE;
            klik = 0;
        }

        panel.setBackground(this.color);
        panel.repaint();
        label.setText("zmena farby");

    }

    public Color getColor() {
        return color;
    }
}
