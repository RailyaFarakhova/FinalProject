/*
Notes for Aesthetic lines

Set background to a preset color:
button.setBackground(Color.BLUE);

Set background using custom RGB values:
button.setBackground(new Color(255, 0, 0));

Set text color:
button.setForeground(Color.YELLOW);

*/

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
    JLabel spacer;
    JLabel spacer2;
    JLabel spacer3;

    String librarianCode;

    public MainGUI() {
        frame = new JFrame ("Library");
        librarianButton = new JButton("I'm a Librarian");
        int correctCode = 135246;
        librarianButton.addActionListener(e-> {
            librarianCode = JOptionPane.showInputDialog("Please enter your code:");
            if (librarianCode == null) {
                return;
            }
            try {
                int enteredCode = Integer.parseInt(librarianCode.trim());
                if (enteredCode == correctCode) {
                    new LibrarianGUI();
                } else {
                    JOptionPane.showMessageDialog(null, "Incorrect Code. Access Denied", "Error", JOptionPane.ERROR_MESSAGE);
                }

            } catch (NumberFormatException error) {
                JOptionPane.showMessageDialog(null, "Invalid input. Please enter numbers only.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        userButton = new JButton("I'm a Guest");
        userButton.addActionListener(e-> {
            new GuestGUI();
        });
        spacer = new JLabel();
        spacer2 = new JLabel();
        spacer3 = new JLabel();

        panel = new JPanel();
        selector = new JLabel("Login", SwingConstants.CENTER);
        selector.setFont(new Font("Times New Roman", Font.BOLD, 50));

        panel.setBorder(BorderFactory.createEmptyBorder(50, 100, 50, 100));
        panel.setLayout(new GridLayout(2,3));

        panel.setPreferredSize(new Dimension(800, 500));

        panel.add(spacer);
        panel.add(selector);
        panel.add(spacer2);
        panel.add(userButton);
        panel.add(spacer3);
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
