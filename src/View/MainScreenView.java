package View;

import Cars.Car;
import Cars.Sedan;
import com.formdev.flatlaf.FlatIntelliJLaf;

import javax.swing.*;
import java.awt.*;

public class MainScreenView {

    private final JFrame frame;

    private final JPanel insideFilterPanel;
    private final JPanel insideSortPanel;

    private JButton btnApplyFilter;
    private final JButton btnApplySort;
    private final JToggleButton btnFilter;
    private final JToggleButton btnSort;


    public MainScreenView() {

//        FlatIntelliJLaf.setup();

        frame = new JFrame();
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1000,800);
        frame.setLocationRelativeTo(null);
        frame.setLayout(null);
        frame.getContentPane().setBackground(Color.white);

        JPanel carsCards = new JPanel();
        carsCards.setLayout(null);
        carsCards.setBackground(new Color(231, 214, 255,50));
//        carsCards.setBackground(Color.white);


        //our items
        Car mercedes1 = new Sedan("Mercedes","C 180 AMG",2018,1200,
                "src/Assets/mercedes-benz.png",
                "src/Assets/mercedes_c180amg_2018.jpg");

        MainScreenListItem item = new MainScreenListItem(mercedes1);

        //this part needed for create scrollable panel, I found it after ~100 trying and
        //update -> I put this part after creating cars because of counter increment.
        carsCards.setPreferredSize(new Dimension(650,
                MainScreenListItem.getCounter() * 110 + 30));
        /* I will make the second part(590) dynamic, i found 590 like this;
                every item(panel) has 100 px height and 10 px padding = 110,
                then I have 7 items so 7 x 110 = 770,
                then I add the initial yCoordinate 770 + 20 = 790,
                then I add missing '10x' at the end 790 + 10 = 800.

        '10px' : initial padding is 20, but at the end there is just panel's 10px padding,
                so I need +10 px at the end.

                you can make dynamic using this way...
         */

        //add them in a panel
        carsCards.add(item.getPanel());

        //classic scroll pane
        JScrollPane scrollPanel = new JScrollPane(carsCards);
        scrollPanel.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPanel.setBounds(150, 180, 700, 500);

        JButton btnAdminPage = new JButton("Admin Page");
        btnAdminPage.setBounds(700,700,150,40);
        btnAdminPage.setBackground(new Color(0, 56, 255,255));
        btnAdminPage.setForeground(new Color(255, 255, 255,255));
        btnAdminPage.setFont(new Font("Arial", Font.PLAIN, 18));

        btnAdminPage.addActionListener(e->{
            AdminPageView view = new AdminPageView();
            view.show();
        });


        // Search Panel
        ImageIcon searchIcon = IResizeImage.resizeImage("src/Assets/search.png",
                20,20);

        JPanel searchPanel = new JPanel();
        searchPanel.setLayout(null);
        searchPanel.setBounds(320,20,360,60);
        searchPanel.setBorder(new RoundedBorder(15));
        searchPanel.setBackground(new Color(171, 252, 255,50));

        JTextField search = new JTextField();
        search.setBounds(10,10, 290,40);
        search.setFont(new Font("Arial", Font.PLAIN, 20));

        JButton btnSearch = new JButton();
        btnSearch.setIcon(searchIcon);
        btnSearch.setBounds(310,10,40,40);

        searchPanel.add(search);
        searchPanel.add(btnSearch);

        // Filter Panel
        ImageIcon angleDown = IResizeImage.resizeImage("src/Assets/angle-down.png",
                20,20);

        JPanel filterPanel = new JPanel();
        filterPanel.setLayout(null);
        filterPanel.setBounds(320,110,150,40);
        filterPanel.setBorder(new RoundedBorder(15));
        filterPanel.setBackground(new Color(255, 213, 171, 50));

        JLabel filterLabel = new JLabel("Filter");
        filterLabel.setFont(new Font("Arial", Font.PLAIN, 18));
        filterLabel.setBounds(40,5,100,30);

        btnFilter = new JToggleButton();
        btnFilter.setIcon(angleDown);
        btnFilter.setBounds(110,5,30,30);

        filterPanel.add(filterLabel);
        filterPanel.add(btnFilter);

        //Sort Panel
        JPanel sortPanel = new JPanel();
        sortPanel.setLayout(null);
        sortPanel.setBounds(530,110,150,40);
        sortPanel.setBorder(new RoundedBorder(15));
        sortPanel.setBackground(new Color(255, 213, 171, 50));

        JLabel sortLabel = new JLabel("Sort");
        sortLabel.setFont(new Font("Arial", Font.PLAIN, 18));
        sortLabel.setBounds(40,5,100,30);

        btnSort = new JToggleButton();
        btnSort.setIcon(angleDown);
        btnSort.setBounds(110,5,30,30);

        sortPanel.add(sortLabel);
        sortPanel.add(btnSort);

        //Inside of Filter
        insideFilterPanel = new JPanel();
        insideFilterPanel.setLayout(null);
        insideFilterPanel.setBorder(new RoundedBorder(15));
        insideFilterPanel.setBounds(320,150,150,130);
        insideFilterPanel.setVisible(false);

        JCheckBox sedanCheckBox = new JCheckBox("Sedan");
        sedanCheckBox.setFont(new Font("Arial", Font.PLAIN, 18));
        sedanCheckBox.setBounds(10,10,130,30);
        insideFilterPanel.add(sedanCheckBox);

        JCheckBox suvCheckBox = new JCheckBox("SUV");
        suvCheckBox.setFont(new Font("Arial", Font.PLAIN, 18));
        suvCheckBox.setBounds(10,50,130,30);
        insideFilterPanel.add(suvCheckBox);

        btnApplyFilter = new JButton("Apply");
        btnApplyFilter.setBounds(10,90,130,30);
        btnApplyFilter.setFont(new Font("Arial", Font.PLAIN, 17));
        btnApplyFilter.setBackground(new Color(75, 99, 255,255));
        btnApplyFilter.setForeground(Color.white);
        insideFilterPanel.add(btnApplyFilter);

        //Inside of sort
        insideSortPanel = new JPanel();
        insideSortPanel.setLayout(null);
        insideSortPanel.setBorder(new RoundedBorder(15));
        insideSortPanel.setBounds(530,150,150,130);
        insideSortPanel.setVisible(false);

        JRadioButton lowToHigh = new JRadioButton("Low To High");
        lowToHigh.setFont(new Font("Arial", Font.PLAIN, 18));
        lowToHigh.setBounds(10,10,130,30);
        insideSortPanel.add(lowToHigh);

        JRadioButton highToLow = new JRadioButton("High To Low");
        highToLow.setFont(new Font("Arial", Font.PLAIN, 18));
        highToLow.setBounds(10,50,130,30);
        insideSortPanel.add(highToLow);

        ButtonGroup group = new ButtonGroup();
        group.add(highToLow);
        group.add(lowToHigh);

        btnApplySort = new JButton("Apply");
        btnApplySort.setBounds(10,90,130,30);
        btnApplySort.setFont(new Font("Arial", Font.PLAIN, 17));
        btnApplySort.setBackground(new Color(75, 99, 255,255));
        btnApplySort.setForeground(Color.white);
        insideSortPanel.add(btnApplySort);

        btnFilter.addActionListener(e ->{

            if (btnFilter.isSelected()){
                insideFilterPanel.setVisible(true);
            }
            else{
                insideFilterPanel.setVisible(false);
            }
        });

        btnSort.addActionListener(e ->{

            if (btnSort.isSelected()){
                insideSortPanel.setVisible(true);
            }
            else{
                insideSortPanel.setVisible(false);
            }
        });

        //Profile btn and label
        ImageIcon profileButtonImage = IResizeImage.resizeImage("src/Assets/user.png",
                60,60);
        JButton btnProfilePage = new JButton();
        btnProfilePage.setIcon(profileButtonImage);
        btnProfilePage.setBackground(new Color(0, 51, 255,20));
        btnProfilePage.setBounds(750,30,75,75);

        JLabel profileLabel = new JLabel("My Profile");
        profileLabel.setFont(new Font("Arial", Font.PLAIN, 17));
        profileLabel.setBounds(750,110,130,30);

        ImageIcon myRentsButtonImage = IResizeImage.resizeImage("src/Assets/car-alt.png",
                50,50);
        JButton btnMyRents = new JButton();
        btnMyRents.setIcon(myRentsButtonImage);
        btnMyRents.setBounds(180,30,75,75);
        btnMyRents.setBackground(new Color(0, 51, 255,20));

        JLabel myRentsLabel = new JLabel("My Rents");
        myRentsLabel.setFont(new Font("Arial", Font.PLAIN, 17));
        myRentsLabel.setBounds(182,110,130,30);

        btnProfilePage.addActionListener(e -> {
            ProfileScreenView view = new ProfileScreenView();
            view.show();
        });

        btnMyRents.addActionListener(e->{
            HistoryPageView view = new HistoryPageView();
            view.show();
        });


        //classic addings cart curt.
        frame.add(btnAdminPage);
        frame.add(btnProfilePage);
        frame.add(profileLabel);
        frame.add(btnMyRents);
        frame.add(myRentsLabel);
        frame.add(insideSortPanel);
        frame.add(insideFilterPanel);
        frame.add(filterPanel);
        frame.add(sortPanel);
        frame.add(searchPanel);
        frame.add(scrollPanel);
    }

    public void show(){
        frame.setVisible(true);
    }

    public void hide(){
        frame.setVisible(false);
    }

    //------------

    public JButton getBtnApplySort() {
        return btnApplySort;
    }

    public JButton getBtnApplyFilter() {
        return btnApplyFilter;
    }

    public JPanel getInsideFilterPanel() {
        return insideFilterPanel;
    }

    public JPanel getInsideSortPanel() {
        return insideSortPanel;
    }

    public JToggleButton getBtnSort() {
        return btnSort;
    }

    public JToggleButton getBtnFilter() {
        return btnFilter;
    }

    public JFrame getFrame() {
        return frame;
    }
}
