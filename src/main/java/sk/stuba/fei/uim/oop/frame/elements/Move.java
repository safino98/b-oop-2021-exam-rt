package sk.stuba.fei.uim.oop.frame.elements;

import lombok.Setter;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
@Setter
public class Move  extends JButton implements ActionListener {

    private JLabel label;
    private boolean allowed;

    public Move(JLabel la) {
        super("Pohyb");
        this.label = la;
        addActionListener(this);
        allowed = false;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        allowed = true;
        label.setText("Pohyb");
    }

    public boolean isAllowed() {
        return allowed;
    }
}
