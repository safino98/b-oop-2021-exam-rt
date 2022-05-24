package sk.stuba.fei.uim.oop.frame.elements;

import lombok.Getter;
import lombok.Setter;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


@Setter
public class Three extends JButton implements ActionListener {
private JLabel label;
private boolean allowed;
    public Three(JLabel la) {
        super("Kreslenie");
        this.label = la;
        addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        this.allowed = true;
        label.setText("Kreslenie");
    }

    public boolean isAllowed() {
        return allowed;
    }
}
