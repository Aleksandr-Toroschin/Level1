package ru.toroschin;

import javax.swing.*;
import java.awt.*;

public class XButton extends JButton {
    private int x;
    private int y;

    XButton(int x, int y) {
        this.x = x;
        this.y = y;
        this.setText("");
        this.setFont(new Font("Arial", Font.PLAIN, 30));
        this.addActionListener(new ActionX0(this));
    }

    @Override
    public int getX() {
        return x;
    }

    @Override
    public int getY() {
        return y;
    }
}