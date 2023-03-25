import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Prescription extends JFrame implements ActionListener {
    private JPanel panel = new JPanel();
    JLabel label =  new JLabel("Prescription");
    private JLabel labelId=new JLabel("Patient ID");
    private JLabel labelMedicine1=new JLabel("Prescription");
    private JLabel labelMedicine2=new JLabel("Prescription2");
    private JLabel labelMedicine3=new JLabel("Prescription3");
    private JTextField patientId = new JTextField(10);
    private JTextField medicineField1 = new JTextField(10);
    private JTextField medicineField2 = new JTextField(10);
    private JTextField medicineField3 = new JTextField(10);
    private JButton btnSave = new JButton("save");
    private JButton btnBack = new JButton("Back");

    public Prescription(){
        super("Prescription");
        panel = new JPanel();
        panel.setLayout(null);
        label.setFont(new Font("Times New Roman",Font.PLAIN,50));

        label.setBounds(200,50,400,60);
        labelId.setBounds(10,150,200,40);
        labelMedicine1.setBounds(10,200,200,40);
        labelMedicine2.setBounds(10,250,200,40);
        labelMedicine3.setBounds(10,300,200,40);
        patientId.setBounds(100,150,200,40);
        medicineField1.setBounds(100,200,200,40);
        medicineField2.setBounds(100,250,200,40);
        medicineField3.setBounds(100,300,200,40);
        btnSave.setBounds(400,200,200,40);
        btnBack.setBounds(400,260,200,40);

        panel.add(label);
        panel.add(labelId);
        panel.add(labelMedicine1);
        panel.add(labelMedicine2);
        panel.add(labelMedicine3);
        panel.add(patientId);
        panel.add(medicineField1);
        panel.add(medicineField2);
        panel.add(medicineField3);
        panel.add(btnSave);
        panel.add(btnBack);
        add(panel);
        btnSave.addActionListener(this);
        btnBack.addActionListener(this);

        setSize(800,600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);

    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnSave){
            String id = patientId.getText();
            String first_med = medicineField1.getText();
            String second_med = medicineField2.getText();
            String third_med = medicineField3.getText();



            try {
                Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital",
                        "root", "Kibreab.37");

                String query = "INSERT INTO prescription values('" + id + "','" + first_med + "','"
                        + second_med + "','" + third_med + "')";

                Statement statement = connection.createStatement();
                int x = statement.executeUpdate(query);
                if (x == 0) {
                    JOptionPane.showMessageDialog(this, "This already exist");
                } else {
                    JOptionPane.showMessageDialog(this,
                            "Successfully Registered");
                }
                connection.close();
            } catch (SQLException exception) {
                JOptionPane.showMessageDialog(this, exception.getMessage());
            }
        }

        if (e.getSource() == btnBack) {
            new Doctor();
            this.dispose();
        }
    }

    public static void main(String[] args) {
        new Prescription();
    }
}
