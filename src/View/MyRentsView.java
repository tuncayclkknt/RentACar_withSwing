package View;

import javax.swing.*;
import java.awt.*;

public class MyRentsView {
    JFrame frame;

    public MyRentsView() {
        frame = new JFrame("History");
        frame.setResizable(false);
        frame.setSize(400,800);
        frame.setLayout(null);
        frame.getContentPane().setBackground(Color.white);
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

        int frameHeight = frame.getHeight();

        int x = 0;
        int y = (screenSize.height - frameHeight - 50) / 2;
        frame.setLocation(x, y);

        JLabel activeRentLabel = new JLabel("Active Rents");
        activeRentLabel.setBounds(30,50,130,30);
        activeRentLabel.setFont(new Font("Arial", Font.PLAIN, 20));

        JPanel activeRentsPanel = new JPanel();
        activeRentsPanel.setLayout(null);
        activeRentsPanel.setBorder(new RoundedBorder(15));
        activeRentsPanel.setBounds(30,90,325,120);

        JLabel historyLabel = new JLabel("Last Rents");
        historyLabel.setBounds(30,230,130,30);
        historyLabel.setFont(new Font("Arial", Font.PLAIN, 20));

        JPanel historyPanel = new JPanel();
        historyPanel.setLayout(null);
        historyPanel.setBorder(new RoundedBorder(15));
        historyPanel.setBounds(30,270,325,120);

        JLabel thereIsNoting = new JLabel("There is noting to see.");
        thereIsNoting.setFont(new Font("Arial", Font.PLAIN, 18));
        thereIsNoting.setBounds(60,45,200,30);
        historyPanel.add(thereIsNoting);

        JLabel thereIsNoting2 = new JLabel("There is noting to see.");
        thereIsNoting2.setFont(new Font("Arial", Font.PLAIN, 18));
        thereIsNoting2.setBounds(60,45,200,30);
        activeRentsPanel.add(thereIsNoting2);


        frame.add(activeRentLabel);
        frame.add(historyLabel);
        frame.add(activeRentsPanel);
        frame.add(historyPanel);
    }

    public void show(){
        frame.setVisible(true);
    }

    public boolean isVisibleForScreen(){
        return frame.isVisible();
    }
}
