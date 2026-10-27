package com.mycompany.cor;

/**
 *
 * @author Gail Jacinto
 */
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class CertificateOfRegistration extends JFrame {

    public CertificateOfRegistration() {
        setTitle("Certificate of Registration");
        setSize(1150, 750);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(10, 10));

        JPanel topPanel = new JPanel(new GridLayout(1, 2, 10, 0));
        topPanel.setBorder(new EmptyBorder(10, 15, 10, 15));

        JPanel leftInfo = new JPanel(new GridLayout(4, 1, 2, 2));
        leftInfo.add(new JLabel("Enrollment Status: ENROLLED"));
        leftInfo.add(new JLabel("Student #: 202510084"));
        leftInfo.add(new JLabel("Name: JACINTO, CHRISTIA GAIL RODRIGUEZ"));
        leftInfo.add(new JLabel("Phone: 9237435599     Zip Code: 1016"));

        JPanel rightInfo = new JPanel(new GridLayout(3, 1, 2, 2));
        rightInfo.add(new JLabel("College: COMPUTER STUDIES    Program: BSCSAI"));
        rightInfo.add(new JLabel("Year Level: 2    1st Term, SY 26-27"));
        rightInfo.add(new JLabel("Address: 41 F. Pasco Ave. Santolan, Pasig City"));

        topPanel.add(leftInfo);
        topPanel.add(rightInfo);
        add(topPanel, BorderLayout.NORTH);

        JPanel centerContainer = new JPanel(new BorderLayout(5, 5));
        centerContainer.setBorder(new EmptyBorder(0, 15, 10, 15));

        String[] columnNames = {"Course Code", "Title", "Section", "Units", "Days", "Time", "Room"};
        Object[][] data = {
            {"CCS0021", "INFORMATION MANAGEMENT (LEC)", "TA21", "2", "T", "13:00-15:40", "ONLINE"},
            {"CCS0021L", "INFORMATION MANAGEMENT (LAB)", "TA21", "1", "F", "13:00-15:50", "ONLINE"},
            {"CS0001", "DISCRETE STRUCTURES 1", "TA21", "3", "M / TH", "15:00-18:50 / 15:00-16:50", "F710 / F710"},
            {"CS0003", "COMPUTER SYSTEMS & ARCHITECTURE", "TN26", "2", "T", "07:00-09:40", "ONLINE"},
            {"CS0003L", "COMPUTER SYSTEMS & ARCHITECTURE (LAB)", "TN26", "M", "TH", "07:00-09:50", "E609"},
            {"CS0070", "OBJECT ORIENTED PROGRAMMING", "TA21", "2", "T", "10:00-12:40", "ONLINE"},
            {"CS0070L", "OBJECT ORIENTED PROGRAMMING-LAB", "TA21", "1", "M", "10:00-12:50", "E609"},
            {"GED0021", "SPECIALIZED ENGLISH PROGRAM 2", "TN25", "3", "W / S", "13:00-14:50 / 13:00-14:50", "F608 / F608"},
            {"GED0055", "MATHEMATICAL ANALYSIS", "M552", "3", "W / S", "07:00-08:50 / 07:00-08:50", "F712 / F712"},
            {"GED0081", "COLLEGE PHYSICS 1 LECTURE", "TA21", "2", "F", "10:00-12:40", "ONLINE"},
            {"GED0081L", "COLLEGE PHYSICS 1 LABORATORY", "TA21", "1", "S", "10:00-12:50", "F1003"}
        };

        DefaultTableModel model = new DefaultTableModel(data, columnNames);
        JTable table = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(table);
        centerContainer.add(scrollPane, BorderLayout.CENTER);

        JPanel feesPanel = new JPanel();
        feesPanel.setLayout(new BoxLayout(feesPanel, BoxLayout.Y_AXIS));
        feesPanel.setBorder(new EmptyBorder(10, 5, 5, 5));

        feesPanel.add(new JLabel("TOTAL UNITS: 21"));
        feesPanel.add(Box.createVerticalStrut(8));
        feesPanel.add(new JLabel("Assessment Fees (PHP):"));
        feesPanel.add(new JLabel("  • Tuition Fee (21): 44,258.00"));
        feesPanel.add(new JLabel("  • Miscellaneous Fee: 12,305.00"));
        feesPanel.add(new JLabel("  • ID Validation Fee: 80.00"));
        feesPanel.add(new JLabel("  • ITE Computer Laboratory Fee (CCS0021): 4,008.00"));
        feesPanel.add(new JLabel("  • ITE Computer Laboratory Fee (CS0003): 4,008.00"));
        feesPanel.add(new JLabel("  • ITE Computer Laboratory Fee (CS0070): 4,008.00"));
        feesPanel.add(new JLabel("  • Science Lab Fee (GED0081): 4,104.00"));
        feesPanel.add(Box.createVerticalStrut(5));

        JLabel totalLabel = new JLabel("TOTAL ASSESSMENT: 72,781.00");
        totalLabel.setFont(new Font("Arial", Font.BOLD, 13));
        feesPanel.add(totalLabel);

        centerContainer.add(feesPanel, BorderLayout.SOUTH);
        add(centerContainer, BorderLayout.CENTER);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new CertificateOfRegistration().setVisible(true);
        });
    }
}