package View;

import com.formdev.flatlaf.FlatIntelliJLaf;

import javax.swing.*;
import java.awt.*;

public class MainScreenView {

    private final JFrame frame;

    public MainScreenView() {

        FlatIntelliJLaf.setup();

        frame = new JFrame();
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1000,800);
        frame.setLocationRelativeTo(null);
        frame.setLayout(null);
        frame.getContentPane().setBackground(Color.white);


    }

    public void show(){
        frame.setVisible(true);
    }

    public void hide(){
        frame.setVisible(false);
    }
}
