package ru.toroschin;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ActionX0 implements ActionListener {
    private XButton btn;

    ActionX0(XButton btn) {
        this.btn = btn;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // обработка нажатия
        System.out.println("Нажата кнопка "+btn.getX()+";"+btn.getY());
        btn.setText("X");
    }
}
