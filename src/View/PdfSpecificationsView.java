package View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.text.NumberFormat;

public class PdfSpecificationsView extends JFrame {
    private JButton btnExport;

    private JCheckBox sedanCheckBox;
    private JCheckBox suvCheckBox;

    private JFormattedTextField minPriceField;
    private JFormattedTextField maxPriceField;

    public PdfSpecificationsView(){
        setResizable(false);
        setSize(500,300);
        setLocationRelativeTo(null);
        setLayout(null);
        getContentPane().setBackground(Color.white);

        JLabel title = new JLabel("Export Cars");
        title.setFont(new Font("Arial", Font.BOLD, 20));
        title.setBounds(190,5,120,30);
        add(title);

        sedanCheckBox = new JCheckBox("Sedan");
        sedanCheckBox.setFont(new Font("Arial", Font.PLAIN, 18));
        sedanCheckBox.setBounds(100,80,150,30);
        add(sedanCheckBox);

        suvCheckBox = new JCheckBox("SUV");
        suvCheckBox.setFont(new Font("Arial", Font.PLAIN, 18));
        suvCheckBox.setBounds(100,120,150,30);
        add(suvCheckBox);

        JLabel minPriceLabel = new JLabel("Min Price :");
        minPriceLabel.setFont(new Font("Arial", Font.PLAIN, 18));
        minPriceLabel.setBounds(220,80,150,30);
        add(minPriceLabel);

        JLabel maxPriceLabel = new JLabel("Max Price:");
        maxPriceLabel.setFont(new Font("Arial", Font.PLAIN, 18));
        maxPriceLabel.setBounds(220,120,150,30);
        add(maxPriceLabel);

        NumberFormat numberFormat = NumberFormat.getNumberInstance();
        numberFormat.setGroupingUsed(false);

        minPriceField = new JFormattedTextField(numberFormat);
        minPriceField.setBounds(320,80,100,30);
        add(minPriceField);

        maxPriceField = new JFormattedTextField(numberFormat);
        maxPriceField.setBounds(320,120,100,30);
        add(maxPriceField);

        btnExport = new JButton("Export");
        btnExport.setFont(new Font("Arial", Font.PLAIN, 18));
        btnExport.setBounds(200,200,100,30);
        btnExport.setBackground(new Color(0, 34, 255,255));
        btnExport.setForeground(Color.white);
        add(btnExport);

    }

    public void addBtnExportActionListener(ActionListener listener){
        btnExport.addActionListener(listener);
    }

    public JCheckBox getSedanCheckBox() {
        return sedanCheckBox;
    }

    public JCheckBox getSuvCheckBox() {
        return suvCheckBox;
    }

    public JFormattedTextField getMinPriceField() {
        return minPriceField;
    }

    public JFormattedTextField getMaxPriceField() {
        return maxPriceField;
    }
}
