package View;

import javax.swing.*;
import java.awt.*;

public class CarDetailsView extends JFrame{

    public CarDetailsView() {
        setResizable(false);
        setSize(400,800);
        setLayout(null);
        getContentPane().setBackground(Color.white);

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int frameWidth = getWidth();
        int frameHeight = getHeight();

        int x = screenSize.width - frameWidth;
        int y = (screenSize.height - frameHeight - 50) / 2;
        setLocation(x, y);

        ImageIcon icon = IResizeImage.resizeImage("src/Assets/mercedes_c180amg_2018.jpg",360,200);
        JLabel photo = new JLabel(icon);
        photo.setBounds(15,20,360,200);

        JLabel carName = new JLabel("Mercedes-Benz");
        carName.setFont(new Font("Arial", Font.PLAIN, 20));
        carName.setBounds(15,240,200,30);

        JLabel modelName = new JLabel("C 180 AMG");
        modelName.setFont(new Font("Arial", Font.PLAIN, 20));
        modelName.setBounds(15,280,200,30);

        JLabel year = new JLabel("Year: 2018");
        year.setFont(new Font("Arial", Font.PLAIN, 20));
        year.setBounds(15,330,200,30);

        JLabel dailyPrice = new JLabel("Daily Price: 1200.0 TL");
        dailyPrice.setFont(new Font("Arial", Font.PLAIN, 20));
        dailyPrice.setBounds(15,360,200,30);

        JLabel last = new JLabel("I want to rent             days.");
        last.setFont(new Font("Arial", Font.PLAIN, 20));
        last.setBounds(140,600,240,30);

        SpinnerNumberModel model = new SpinnerNumberModel(1,1,5,1);
        JSpinner spinner = new JSpinner(model);
        spinner.setFont(new Font("Arial", Font.PLAIN, 20));
        spinner.setBounds(260,600,60,30);

        JButton button = new JButton("Rent");
        button.setFont(new Font("Arial", Font.PLAIN, 20));
        button.setBounds(260,640,80,40);
        button.setBackground(new Color(0, 56, 255,255));
        button.setForeground(new Color(255, 255, 255,255));

        button.addActionListener(e->{

            String message = "You will pay " + (int)spinner.getValue()*1200 + "₺";
            String title = "Summary";

            Object[] options = {"Accept","Deny"};

            int result = JOptionPane.showOptionDialog(
                    this,
                    message,
                    title,
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.QUESTION_MESSAGE,
                    null,
                    options,
                    options[0]
            );

            if (result == JOptionPane.YES_OPTION)
                JOptionPane.showMessageDialog(this,"You get the car.","Result",JOptionPane.INFORMATION_MESSAGE);
            else if (result == JOptionPane.NO_OPTION)
                JOptionPane.showMessageDialog(this,"Payment is canceled.","Result",JOptionPane.WARNING_MESSAGE);

        });

        add(button);
        add(spinner);
        add(last);
        add(dailyPrice);
        add(year);
        add(carName);
        add(modelName);
        add(photo);
    }

    public boolean isVisibleForScreen(){
        return isVisible();
    }
}
