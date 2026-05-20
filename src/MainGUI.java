import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MainGUI implements ActionListener {
    JFrame frame;
    JPanel panel;
    JButton librarianButton;
    JButton userButton;
    JLabel selector;

    String librarianCode;

    public MainGUI() {
        frame = new JFrame ("Library");
        librarianButton = new JButton("I'm a Librarian");
        librarianButton.addActionListener(e-> {
            librarianCode = JOptionPane.showInputDialog("Please enter your code:");

            //Logic
        });

        userButton = new JButton("I'm a Guest");
        userButton.addActionListener(e-> {

            //Logic
        });
        panel = new JPanel();
        selector = new JLabel("Login");

        panel.setBorder(BorderFactory.createEmptyBorder(50, 100, 50, 100));
        panel.setLayout(new GridLayout(2,3));

        panel.setPreferredSize(new Dimension(500, 200));

        panel.add(selector);
        panel.add(userButton);
        panel.add(librarianButton);

        frame.add(panel, BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
