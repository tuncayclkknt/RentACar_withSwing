package View;

import javax.swing.*;
import java.awt.*;
import java.security.PublicKey;

public class CarDetailsView {

    private final JFrame frame;

    public CarDetailsView() {
        frame = new JFrame("Details");
        frame.setResizable(false);
        frame.setSize(400,800);
        frame.setLayout(null);
        frame.getContentPane().setBackground(Color.white);

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int frameWidth = frame.getWidth();
        int frameHeight = frame.getHeight();

        int x = screenSize.width - frameWidth;
        int y = (screenSize.height - frameHeight - 50) / 2;
        frame.setLocation(x, y);

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

        frame.add(button);
        frame.add(spinner);
        frame.add(last);
        frame.add(dailyPrice);
        frame.add(year);
        frame.add(carName);
        frame.add(modelName);
        frame.add(photo);
    }

    public void show(){
        frame.setVisible(true);
    }
}
