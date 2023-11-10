package test7;

/**
 * Program Description: Welcome page as introduction to the whole project.
 *
 * Author: NUR IZZAH THAQIFFAH 
 * Date: 
 */


import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


//Driver class
public class WelcomePage extends JFrame implements ActionListener 
{
    private JButton btnStaff;
    private Container cont;
    private FlowLayout layout;
    private ImageIcon spider;
    private ImageIcon spiderweb;
    private ImageIcon spiderweb2;
    private ImageIcon bat;
    private ImageIcon bat2;
    private ImageIcon pumpkin;
    private ImageIcon cemetery;
    private ImageIcon tree;

    //Colours
    private final Color SUNWAY_BLUE = new Color(180, 213, 234);
    private final Color SUNWAY_ORANGE = new Color(241, 115, 31);
    
    //Method for WelcomePage()
    public WelcomePage() 
    {
        super("WELCOME TO SUNWAY LAGOON!");

        cont = getContentPane();
        cont.setLayout(null);
        cont.setBackground(SUNWAY_ORANGE); //Set background color

        //Sunway Logo
        ImageIcon logo = new ImageIcon("sunlag.png");
        Image image = logo.getImage().getScaledInstance(600, 350, Image.SCALE_SMOOTH); // Decrease the size
        ImageIcon scaledLogo = new ImageIcon(image);
        JLabel imageLabel = new JLabel(new ImageIcon(WelcomePage.class.getResource("/pic/sunlag (3).png")));
        
        //Load image icons
        ImageIcon spiderIcon = new ImageIcon("spooder.png");
        spiderIcon.setImage(spiderIcon.getImage().getScaledInstance(140, 140, Image.SCALE_SMOOTH));

        ImageIcon spiderwebIcon = new ImageIcon("spiderweb.png");
        spiderwebIcon.setImage(spiderwebIcon.getImage().getScaledInstance(200, 200, Image.SCALE_SMOOTH));

        ImageIcon spiderweb2Icon = new ImageIcon("spiderweb2.png");
        spiderweb2Icon.setImage(spiderweb2Icon.getImage().getScaledInstance(200, 200, Image.SCALE_SMOOTH));

        ImageIcon batIcon = new ImageIcon("bat.png");
        batIcon.setImage(batIcon.getImage().getScaledInstance(150, 150, Image.SCALE_SMOOTH));

        ImageIcon bat2Icon = new ImageIcon("bat2.png");
        bat2Icon.setImage(bat2Icon.getImage().getScaledInstance(120, 120, Image.SCALE_SMOOTH));

        ImageIcon pumpkinIcon = new ImageIcon("pumpkin.png");
        pumpkinIcon.setImage(pumpkinIcon.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH));
        
        ImageIcon cemeteryIcon = new ImageIcon("cemetery.png");
        cemeteryIcon.setImage(cemeteryIcon.getImage().getScaledInstance(200, 200, Image.SCALE_SMOOTH));
        
        ImageIcon treeIcon = new ImageIcon("tree.png");
        treeIcon.setImage(treeIcon.getImage().getScaledInstance(220, 220, Image.SCALE_SMOOTH));

        //Create JLabel components with the loaded icons
        JLabel decoPic1 = new JLabel(new ImageIcon(WelcomePage.class.getResource("/pic/spooder (1).png")));
        JLabel decoPic2 = new JLabel(new ImageIcon(WelcomePage.class.getResource("/pic/spiderweb (1).png")));
        JLabel decoPic3 = new JLabel(new ImageIcon(WelcomePage.class.getResource("/pic/spiderweb2 (1) (1).png")));
        JLabel decoPic4 = new JLabel(new ImageIcon(WelcomePage.class.getResource("/pic/bat (1).png")));
        JLabel decoPic5 = new JLabel(new ImageIcon(WelcomePage.class.getResource("/pic/bat2 (1).png")));
        JLabel decoPic6 = new JLabel(new ImageIcon(WelcomePage.class.getResource("/pic/pumpkin (1).png")));
        JLabel decoPic7 = new JLabel(new ImageIcon(WelcomePage.class.getResource("/pic/cemetery (1).png")));
        JLabel decoPic8 = new JLabel(new ImageIcon(WelcomePage.class.getResource("/pic/tree (1).png")));

        btnStaff = new JButton("CLICK HERE TO START");
        btnStaff.setFont(new Font("Arial", Font.BOLD, 16)); 
        btnStaff.setBackground(SUNWAY_BLUE);

        //Set the bounds for each component
        imageLabel.setBounds(57, 60, 758, 466);
        decoPic1.setBounds(550, 1, 140, 140);
        decoPic2.setBounds(0, 0, 200, 200); 
        decoPic3.setBounds(700, -14, 200, 200); 
        decoPic4.setBounds(700, 392, 150, 150); 
        decoPic5.setBounds(0, 366, 120, 120); 
        decoPic6.setBounds(283, 134, 100, 100);
        decoPic7.setBounds(57, 479, 200, 200);
        decoPic8.setBounds(537, 459, 220, 220);
        btnStaff.setBounds(325, 536, 250,30);

        //add items into container
        cont.add(imageLabel);
        cont.add(btnStaff);
        cont.add(decoPic1);
        cont.add(decoPic2);
        cont.add(decoPic3);
        cont.add(decoPic4);
        cont.add(decoPic5);
        cont.add(decoPic6);
        cont.add(decoPic7);
        cont.add(decoPic8);

        btnStaff.setActionCommand("loginPage");
        btnStaff.addActionListener(this);

        setSize(900,700);
        setLocationRelativeTo(null); // Center the frame on the screen
        setVisible(true);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }//end of method

    //method for handling button clicks
    public void actionPerformed(ActionEvent e) 
    {
        if ("loginPage".equals(e.getActionCommand()))
        {
            navigateLoginPage();
        }
    }//end of method

    //method of navigating to the staff page
    private void navigateLoginPage()
    {
        LoginPage loginPage = new LoginPage();
        dispose();
    }//end of method

    //Driver method
    public static void main(String[] args)
    {
        SwingUtilities.invokeLater(() -> new WelcomePage());
    }//end of driver method
}//End of class