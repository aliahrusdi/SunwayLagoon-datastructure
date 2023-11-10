package test7;

/**
 /**
 * Program Description: Log in page gui for users to enter their details.
 *
 * Name: NUR IZZAH THAQIFFAH
 * Date: 22/10/2023
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginPage extends JFrame 
{
    private JLabel lblName;
    private JLabel lblID;
    private JLabel instructionLabel;
    private JPanel colorPanel;
    private JTextField txtName;
    private JPasswordField passwordText; 
    private JButton btnCont;
    private Container cont;
    private Staff staff1;
    private Staff staff2;
    private Staff staff3;
    private ImageIcon zombie;
    private ImageIcon cat;
    private ImageIcon bat3;
    private ImageIcon web;
    private ImageIcon pumpkin;

    private final Color SUNWAY_WHITE = new Color(255, 255, 255);
    private final Color SUNWAY_ORANGE = new Color(241, 115, 31);
    private final Color SUNWAY_BLACK = new Color(6, 6, 6);
    private final Color SUNWAY_LORANGE = new Color(255, 210, 143);
    private final Color SUNWAY_BLUE = new Color(180, 213, 234);

    public LoginPage()
    {
        super("Log In");

        cont = getContentPane();
        cont.setLayout(null);
        cont.setBackground(SUNWAY_ORANGE);

        //top panel
        colorPanel = new JPanel(null);
        colorPanel.setBackground(new Color(255, 210, 143));
        colorPanel.setBounds(0, 0, 900, 160);
        getContentPane().add(colorPanel);

        //Sunway Logo
        ImageIcon logo = new ImageIcon("sunlag.png");
        Image image = logo.getImage().getScaledInstance(250, 100, Image.SCALE_SMOOTH);
        ImageIcon scaledLogo = new ImageIcon(image);
        JLabel imageLabel = new JLabel(new ImageIcon(LoginPage.class.getResource("/pic/sunlag (2) (1) (1) (1).png")));

        //Load image icons
        ImageIcon zombieIcon = new ImageIcon("hand.png");
        zombieIcon.setImage(zombieIcon.getImage().getScaledInstance(300, 300, Image.SCALE_SMOOTH));

        ImageIcon catIcon = new ImageIcon("cat.png");
        catIcon.setImage(catIcon.getImage().getScaledInstance(300, 300, Image.SCALE_SMOOTH));

        ImageIcon bat3Icon = new ImageIcon("bat3.png");
        bat3Icon.setImage(bat3Icon.getImage().getScaledInstance(150, 150, Image.SCALE_SMOOTH));

        ImageIcon webIcon = new ImageIcon("web.png");
        webIcon.setImage(webIcon.getImage().getScaledInstance(200, 200, Image.SCALE_SMOOTH));

        ImageIcon pumpkinIcon = new ImageIcon("pumpkin.png");
        pumpkinIcon.setImage(pumpkinIcon.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH));

        //set up a instructionlabel
        instructionLabel = new JLabel (" LOG IN PAGE ");
        instructionLabel.setFont(new Font("Arial", Font.BOLD, 40)); 
        instructionLabel.setBackground(SUNWAY_BLACK);

        lblName = new JLabel("USERNAME: ");
        lblID = new JLabel("PASSWORD: ");

        txtName = new JTextField(20);
        passwordText = new JPasswordField(20);// to create * font

        btnCont = new JButton("LOG IN");
        Font font1 = new Font("Arial", Font.BOLD, 18);
        btnCont.setFont(font1);
        btnCont.setBackground(SUNWAY_BLUE);

        //Create and Assign staffs
        staff1 = new Staff("Izzah", "D01");
        staff2 = new Staff("Anis", "D02");
        staff3 = new Staff("Aliah", "D03");

        //Add an action listener to the "Continue" button
        btnCont.addActionListener(new ActionListener() 
        {
                public void actionPerformed(ActionEvent e)
                {
                    String enteredName = txtName.getText();
                    String enteredID = new String(passwordText.getPassword());
                    boolean loggedIn = false;

                    //Checking if the details are correct with the given name and ID
                    if (enteredName.equals(staff1.getName()) && enteredID.equals(staff1.getID()))
                    {
                        loggedIn = true;
                    } else if (enteredName.equals(staff2.getName()) && enteredID.equals(staff2.getID()))
                    {
                        loggedIn = true;
                    } else if (enteredName.equals(staff3.getName()) && enteredID.equals(staff3.getID()))
                    {
                        loggedIn = true;
                    }

                    if (loggedIn)
                    {
                        // Show a successful login message
                        JOptionPane.showMessageDialog(null, "Login Successful!");

                        // Create an instance of CounterGUI
                        CounterGui counterGUI = new CounterGui();

                        // Close the LoginPage window
                        dispose();

                        // Make the CounterGUI window visible
                        counterGUI.setVisible(true);
                    } 
                    else 
                    {
                        JOptionPane.showMessageDialog(null, "Invalid Name or ID. Please try again.");
                    }
                }
            });

        Font font2 = new Font("Arial", Font.BOLD, 23);
        lblName.setFont(font2);
        lblID.setFont(font2);
        lblName.setForeground(SUNWAY_BLACK);
        lblID.setForeground(SUNWAY_BLACK);

        JLabel decoPic1 = new JLabel(new ImageIcon(LoginPage.class.getResource("/pic/hand (1).png")));
        JLabel decoPic2 = new JLabel(new ImageIcon(LoginPage.class.getResource("/pic/cat (1).png")));
        JLabel decoPic3 = new JLabel(new ImageIcon(LoginPage.class.getResource("/pic/bat3 (1).png")));
        JLabel decoPic4 = new JLabel(new ImageIcon(LoginPage.class.getResource("/pic/spiderweb (1).png")));
        JLabel decoPic5 = new JLabel(new ImageIcon(LoginPage.class.getResource("/pic/pumpkin (1).png")));

        imageLabel.setBounds(10, -4, 250, 150);
        instructionLabel.setBounds(300, 210, 584, 35);
        lblName.setBounds(230, 300, 500, 40);
        lblID.setBounds(227, 350,500, 40);
        txtName.setBounds(390, 303, 220, 35);
        passwordText.setBounds(390, 356, 220, 35);
        btnCont.setBounds(390, 460, 100, 50);
        decoPic1.setBounds(26, 399, 300, 300);
        decoPic2.setBounds(580, 400, 300, 300);
        decoPic3.setBounds(670, 280, 150, 150);
        decoPic4.setBounds(1,158,200,200);
        decoPic5.setBounds(745, 62, 100, 100);

        colorPanel.add(imageLabel);
        colorPanel.add(decoPic5);
        cont.add(instructionLabel);
        cont.add(lblName);
        cont.add(lblID);
        cont.add(txtName);
        cont.add(passwordText);
        cont.add(btnCont);
        cont.add(decoPic1);
        cont.add(decoPic2);
        cont.add(decoPic3);
        cont.add(decoPic4);

        setSize(900,700);
        setLocationRelativeTo(null);
        setVisible(true);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public static void main(String[] args) 
    {
        SwingUtilities.invokeLater(() -> 
                {
                    new LoginPage();
            });
    }
}