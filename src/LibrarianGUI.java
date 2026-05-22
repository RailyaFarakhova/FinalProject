import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class LibrarianGUI implements ActionListener {

    JFrame librarianFrame;
    JPanel librarianPanel;
    JButton test;

    public LibrarianGUI () {
        librarianFrame = new JFrame("Librarian Account");
        librarianPanel = new JPanel();

        librarianPanel.setBorder(BorderFactory.createEmptyBorder(50, 100, 50, 100));
        librarianPanel.setLayout(new GridLayout(2,3));

        librarianPanel.setPreferredSize(new Dimension(500, 200));

        test = new JButton();
        librarianPanel.add(test);

        librarianFrame.add(librarianPanel, BorderLayout.CENTER);
        librarianFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        librarianFrame.pack();
        librarianFrame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
