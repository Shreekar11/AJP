package exp3;
import java.awt.*;
import java.swing.*;
import java.awt.event.*;

public class StudentDetails {
    JFrame fr;
    JLabel main, full_name, year_1, branch_2, division_3, batch_4, marks_5, ajp_6, cn_7, pm_8, pdc_9;
    JTextField fullName, year, branch, division, batch, marks, ajp, cn, pm, pdc;
    JButton submit, reset;

    StudentDetails() {
        fr = new JFrame();
        fr.setSize(400, 400);
        fr.setLayout(null);
        fr.setVisible(true);
        fr.setTitle("Student Details Form");

        fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        init();
        add_components();
        register();
    }

    public void init() {
        main = new Label();
        main.setBounds(20, 40, 420, 20);
        main.setText("Enter Student Details Form");
        main.setHorizontalAlignment(SwingConstants.CENTER);

        full_name = new JLabel();
        full_name.setBounds(20, 80, 200, 20);
        full_name.setText("Full Name: ");

        year_1 = new JLabel();
        year_1.setBounds(20, 120, 200, 20);
        year_1.setText("Year (FE/SE/TE/BE): ");

        branch_2 = new JLabel();
        branch_2.setBounds(20, 160, 200, 20);
        branch_2.setText("Branch (CE/IT/EnTC):");

        division_3 = new JLabel();
        division_3.setBounds(20, 200, 200, 20);
        division_3.setText("Division (1-11):");

        batch_4 = new JLabel();
        batch_4.setBounds(20, 240, 200, 20);
        batch_4.setText("Batch:");

        marks_5 = new JLabel();
        marks_5.setBounds(20, 300, 420, 20);
        marks_5.setText("Enter your subject wise marks in the given fields:");
        marks_5.setHorizontalAlignment(SwingConstants.CENTER);

        ajp_6 = new JLabel();
        ajp_6.setBounds(20, 340, 200, 20);
        ajp_6.setText("AJP:");

        cn_7 = new JLabel();
        cn_7.setBounds(20, 380, 200, 20);
        cn_7.setText("CN:");

        pm_8 = new JLabel();
        pm_8.setBounds(20, 420, 200, 20);
        pm_8.setText("PM:");

        pdc_9 = new JLabel();
        pdc_9.setBounds(20, 460, 200, 20);
        pdc_9.setText("PDC:");

        // Text fields:
        fullName = new JTextField();
        fullName.setBounds(240, 80, 200, 20);

        year = new JTextField();
        year.setBounds(240, 120, 200, 20);

        branch = new JTextField();
        branch.setBounds(240, 160, 200, 20);

        division = new JTextField();
        division.setBounds(240, 200, 200, 20);

        batch = new JTextField();
        batch.setBounds(240, 240, 200, 20);

        ajp = new JTextField();
        ajp.setBounds(240, 340, 200, 20);

        cn = new JTextField();
        cn.setBounds(240, 380, 200, 20);

        pm = new JTextField();
        pm.setBounds(240, 420, 200, 20);

        pdc = new JTextField();
        pdc.setBounds(240, 460, 200, 20);

        // Buttons:
        submit = new JButton();
        submit.setBounds(100, 520, 80, 20);
        submit.setText("Submit");

        reset = new JButton();
        reset.setBounds(280, 520, 80, 20);
        reset.setText("Reset");
    }

    public void add_components() {
        // Labels: 
        fr.add(main);
        fr.add(full_name);
        fr.add(year_1);
        fr.add(branch_2);
        fr.add(division_3);
        fr.add(batch_4);
        fr.add(marks_5);
        fr.add(ajp_6);
        fr.add(cn_7);
        fr.add(pm_8);
        fr.add(pdc_9);

        // Text fields:
        fr.add(fullName);
        fr.add(year);
        fr.add(branch);
        fr.add(division);
        fr.add(batch);
        fr.add(ajp);
        fr.add(cn);
        fr.add(pm);
        fr.add(pdc);

        // Buttons: 
        fr.add(submit);
        fr.add(reset);
    }

    public void register() {
        submit.addActionListener(e -> handleSubmit());
        reset.addActionListener(e -> handleReset());
    }

    private void handleSubmit() {
        JPanel displayPanel = new JPanel();
        displayPanel.setLayout(null);
        displayPanel.setPreferredSize(new java.awt.Dimension(400, 500));

        int ajpMarks = Integer.parseInt(ajp.getText());
        int cnMarks = Integer.parseInt(cn.getText());
        int pmMarks = Integer.parseInt(pm.getText());
        int pdcMarks = Integer.parseInt(pdc.getText());

        int finalMarks = (ajpMarks + cnMarks + pmMarks + pdcMarks) / 4;

        JLabel mainLabel = new JLabel("Student Details:");
        mainLabel.setBounds(0, 10, 420, 20);
        mainLabel.setHorizontalAlignment(SwingConstants.CENTER);
        displayPanel.add(mainLabel);

        JLabel fullNameLabel = new JLabel("Full Name: " + fullName.getText());
        fullNameLabel.setBounds(0, 40, 420, 20);
        displayPanel.add(fullNameLabel);

        JLabel yearLabel = new JLabel("Year: " + year.getText());
        yearLabel.setBounds(0, 80, 420, 20);
        displayPanel.add(yearLabel);

        JLabel branchLabel = new JLabel("Branch: " + branch.getText());
        branchLabel.setBounds(0, 120, 420, 20);
        displayPanel.add(branchLabel);

        JLabel divisionLabel = new JLabel("Division: " + division.getText());
        divisionLabel.setBounds(0, 160, 420, 20);
        displayPanel.add(divisionLabel);

        JLabel batchLabel = new JLabel("Batch: " + batch.getText());
        batchLabel.setBounds(0, 200, 420, 20);
        displayPanel.add(batchLabel);

        JLabel marksLabel = new JLabel("Subject-wise Marks:");
        marksLabel.setBounds(0, 240, 420, 20);
        marksLabel.setHorizontalAlignment(SwingConstants.CENTER);
        displayPanel.add(marksLabel);

        JLabel ajpLabel = new JLabel("AJP: " + ajp.getText());
        ajpLabel.setBounds(0, 280, 420, 20);
        displayPanel.add(ajpLabel);

        JLabel cnLabel = new JLabel("CN: " + cn.getText());
        cnLabel.setBounds(0, 320, 420, 20);
        displayPanel.add(cnLabel);

        JLabel pmLabel = new JLabel("PM: " + pm.getText());
        pmLabel.setBounds(0, 360, 420, 20);
        displayPanel.add(pmLabel);

        JLabel pdcLabel = new JLabel("PDC: " + pdc.getText());
        pdcLabel.setBounds(0, 400, 420, 20);
        displayPanel.add(pdcLabel);

        JLabel finalLabel = new JLabel("Final Percentage: " + finalMarks + "%");
        finalLabel.setBounds(0, 440, 420, 20);
        displayPanel.add(finalLabel);

        JOptionPane.showMessageDialog(fr, displayPanel, "Submitted Information", JOptionPane.INFORMATION_MESSAGE);
    }

    private void handleReset() {
        fullName.setText("");
        year.setText("");
        branch.setText("");
        division.setText("");
        batch.setText("");
        ajp.setText("");
        cn.setText("");
        pm.setText("");
        pdc.setText("");
    }

    public static void main(String[] args) {
        new StudentDetails();
    }
}