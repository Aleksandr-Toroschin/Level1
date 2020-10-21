package ru.toroschin;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class MainWindow extends JFrame {
    MainWindow () {
        setTitle("Крестики-нолики");
        setBounds(700, 300, 500, 600);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        add(panel);

        panel.setLayout(new GridLayout(3,3));
        XButton[][] Xbtn = new XButton[3][3];
        for (int i=0; i<3; i++) {
            for (int j=0; j<3; j++) {
                Xbtn[i][j] = new XButton(i, j);
                panel.add(Xbtn[i][j]);
            }
        }

        JButton btnExit = new JButton("Выход");
        btnExit.addActionListener(e -> {
            System.out.println("Нажата кнопка Выход");
            System.exit(0);
        });
        add(btnExit, BorderLayout.SOUTH);

        //setVisible(true);
    }

}
