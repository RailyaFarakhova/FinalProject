import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GuestGUI implements ActionListener {

    JFrame userFrame;
    JPanel userPanel;
    JButton filter;
    JButton info;
    JLabel accountTitle;

    public GuestGUI () {
        userFrame = new JFrame("Guest Account");
        userPanel = new JPanel();

        userPanel.setBorder(BorderFactory.createEmptyBorder(50, 100, 50, 100));
        userPanel.setLayout(new GridLayout(2,3));

        userPanel.setPreferredSize(new Dimension(500, 200));

        filter = new JButton();
        userPanel.add(filter);

        userFrame.add(userPanel, BorderLayout.CENTER);
        userFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        userFrame.pack();
        userFrame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
