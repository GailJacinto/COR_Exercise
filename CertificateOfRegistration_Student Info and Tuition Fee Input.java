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

    public CertificateOfRegistration(String studentNum, String name, String phone, String zipCode, 
                                      String college, String program, String yearLevel, String address,
                                      int units, double ratePerUnit) {
        setTitle("Certificate of Registration");
        setSize(1150, 750);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(10, 10));

        JPanel topPanel = new JPanel(new GridLayout(1, 2, 10, 0));
        topPanel.setBorder(new EmptyBorder(10, 15, 10, 15));

        JPanel leftInfo = new JPanel(new GridLayout(4, 1, 2, 2));
        leftInfo.add(new JLabel("Enrollment Status: ENROLLED"));
        leftInfo.add(new JLabel("Student #: " + studentNum));
        leftInfo.add(new JLabel("Name: " + name));
        leftInfo.add(new JLabel("Phone: " + phone + "     Zip Code: " + zipCode));

        JPanel rightInfo = new JPanel(new GridLayout(3, 1, 2, 2));
        rightInfo.add(new JLabel("College: " + college + "     Program: " + program));
        rightInfo.add(new JLabel("Year Level: " + yearLevel + "     1st Term, SY 26-27"));
        rightInfo.add(new JLabel("Address: " + address));

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
            {"CS0003L", "COMPUTER SYSTEMS & ARCHITECTURE (LAB)", "TN26", "1", "M", "07:00-09:50", "E609"},
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

        // Computation logic for tuition and total assessment
        double tuitionFee = units * ratePerUnit;
        double miscFee = 12305.00;
        double idFee = 80.00;
        double lab1 = 4008.00;
        double lab2 = 4008.00;
        double lab3 = 4008.00;
        double sciLab = 4104.00;
        double totalAssessment = tuitionFee + miscFee + idFee + lab1 + lab2 + lab3 + sciLab;

        JPanel feesPanel = new JPanel();
        feesPanel.setLayout(new BoxLayout(feesPanel, BoxLayout.Y_AXIS));
        feesPanel.setBorder(new EmptyBorder(10, 5, 5, 5));

        feesPanel.add(new JLabel("TOTAL UNITS: " + units));
        feesPanel.add(Box.createVerticalStrut(8));
        feesPanel.add(new JLabel("Assessment Fees (PHP):"));
        feesPanel.add(new JLabel(String.format("  • Tuition Fee (%d): %,.2f", units, tuitionFee)));
        feesPanel.add(new JLabel(String.format("  • Miscellaneous Fee: %,.2f", miscFee)));
        feesPanel.add(new JLabel(String.format("  • ID Validation Fee: %,.2f", idFee)));
        feesPanel.add(new JLabel(String.format("  • ITE Computer Laboratory Fee (CCS0021): %,.2f", lab1)));
        feesPanel.add(new JLabel(String.format("  • ITE Computer Laboratory Fee (CS0003): %,.2f", lab2)));
        feesPanel.add(new JLabel(String.format("  • ITE Computer Laboratory Fee (CS0070): %,.2f", lab3)));
        feesPanel.add(new JLabel(String.format("  • Science Lab Fee (GED0081): %,.2f", sciLab)));
        feesPanel.add(Box.createVerticalStrut(5));

        JLabel totalLabel = new JLabel(String.format("TOTAL ASSESSMENT: %,.2f", totalAssessment));
        totalLabel.setFont(new Font("Arial", Font.BOLD, 13));
        feesPanel.add(totalLabel);

        centerContainer.add(feesPanel, BorderLayout.SOUTH);
        add(centerContainer, BorderLayout.CENTER);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JTextField tfStudentNum = new JTextField(20);
            JTextField tfName = new JTextField(20);
            JTextField tfPhone = new JTextField(20);
            JTextField tfZipCode = new JTextField(20);
            JTextField tfCollege = new JTextField(20);
            JTextField tfProgram = new JTextField(20);
            JTextField tfYearLevel = new JTextField(20);
            JTextField tfAddress = new JTextField(20);
            JTextField tfUnits = new JTextField("21", 20);
            JTextField tfRate = new JTextField("2107.52", 20);

            JPanel inputPanel = new JPanel(new GridLayout(0, 2, 5, 5));
            inputPanel.add(new JLabel("Student #:"));
            inputPanel.add(tfStudentNum);
            inputPanel.add(new JLabel("Name:"));
            inputPanel.add(tfName);
            inputPanel.add(new JLabel("Phone:"));
            inputPanel.add(tfPhone);
            inputPanel.add(new JLabel("Zip Code:"));
            inputPanel.add(tfZipCode);
            inputPanel.add(new JLabel("College:"));
            inputPanel.add(tfCollege);
            inputPanel.add(new JLabel("Program:"));
            inputPanel.add(tfProgram);
            inputPanel.add(new JLabel("Year Level:"));
            inputPanel.add(tfYearLevel);
            inputPanel.add(new JLabel("Address:"));
            inputPanel.add(tfAddress);
            inputPanel.add(new JLabel("Total Units:"));
            inputPanel.add(tfUnits);
            inputPanel.add(new JLabel("Rate Per Unit (PHP):"));
            inputPanel.add(tfRate);

            int result = JOptionPane.showConfirmDialog(
                null, 
                inputPanel, 
                "Enter Student Information & Fee Details", 
                JOptionPane.OK_CANCEL_OPTION, 
                JOptionPane.PLAIN_MESSAGE
            );

            if (result == JOptionPane.OK_OPTION) {
                try {
                    int units = Integer.parseInt(tfUnits.getText().trim());
                    double rate = Double.parseDouble(tfRate.getText().trim());

                    new CertificateOfRegistration(
                        tfStudentNum.getText(),
                        tfName.getText(),
                        tfPhone.getText(),
                        tfZipCode.getText(),
                        tfCollege.getText(),
                        tfProgram.getText(),
                        tfYearLevel.getText(),
                        tfAddress.getText(),
                        units,
                        rate
                    ).setVisible(true);
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "Please enter valid numeric values for Units and Rate.", "Input Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }
}