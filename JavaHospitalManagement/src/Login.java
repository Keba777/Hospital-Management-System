import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class Login extends JFrame implements ActionListener {
    private JPanel panel = new JPanel();
    private JLabel labelTitle = new JLabel("Exodus Hospital");
    private JLabel labelName = new JLabel("User Name");
    private JLabel labelPass = new JLabel("Password");
    private JTextField nameField = new JTextField(20);
    private JPasswordField paswd = new JPasswordField();
    private JButton btnAdmin = new JButton("Admin");
    private JButton btnDoctor = new JButton("Doctor");
    private JButton btnReceptionist = new JButton("Receptionist");
    private JButton btnPharmacist = new JButton("Pharmacist");
    public Login() {
        super("Login");
        setSize(800, 600);
        panel.setLayout(null);
        labelTitle.setFont(new Font("Times New Roman",Font.BOLD,50));
        labelName.setFont(new Font("Times New Roman",Font.PLAIN,30));
        labelPass.setFont(new Font("Times New Roman",Font.PLAIN,30));

        labelTitle.setBounds(200, 10, 400, 60);
        labelName.setBounds(150, 100, 150, 40);
        nameField.setBounds(300, 100, 350, 40);
        labelPass.setBounds(150, 180, 150, 40);
        paswd.setBounds(300, 180, 350, 40);
        btnAdmin.setBounds(240, 260, 80, 40);
        btnDoctor.setBounds(330, 260, 80, 40);
        btnReceptionist.setBounds(420, 260, 120, 40);
        btnPharmacist.setBounds(550, 260, 120, 40);

        panel.add(labelTitle);
        panel.add(labelName);
        panel.add(nameField);
        panel.add(labelPass);
        panel.add(paswd);
        panel.add(btnAdmin);
        panel.add(btnDoctor);
        panel.add(btnReceptionist);
        panel.add(btnPharmacist);

        btnAdmin.addActionListener(this);
        btnDoctor.addActionListener(this);
        btnReceptionist.addActionListener(this);
        btnPharmacist.addActionListener(this);

        add(panel);
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnAdmin) {
            String userName = nameField.getText();
            String password = String.valueOf(paswd.getPassword());
            try {
                Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital",
                        "root", "Kibreab.37");

                PreparedStatement statement = connection
                        .prepareStatement("Select UserName, Password from user_type where UserName=? and " +
                                "Password=? and UserType = 'admin'");

                statement.setString(1, userName);
                statement.setString(2, password);

                ResultSet rs = statement.executeQuery();
                if (rs.next()) {
                    dispose();
                    Admin admin = new Admin();
                    admin.setVisible(true);
                    JOptionPane.showMessageDialog(this, "You have successfully logged in");
                }
                else {
                    JOptionPane.showMessageDialog(this, "Wrong Username & Password");
                }
                connection.close();
            } catch (SQLException exception) {
                JOptionPane.showMessageDialog(this, exception.getMessage());
            }

        }
        if (e.getSource() == btnDoctor){
            String userName = nameField.getText();
            String password = String.valueOf(paswd.getPassword());
            try {
                Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital",
                        "root", "Kibreab.37");

                PreparedStatement statement = connection.prepareStatement("Select UserName, " +
                        "Password from user_type where UserName=? and " + "Password=? and UserType = 'doctor'");

                statement.setString(1, userName);
                statement.setString(2, password);
                ResultSet rs = statement.executeQuery();
                if (rs.next()) {
                    dispose();
                    Doctor doctor = new Doctor();
                    doctor.setVisible(true);
                    JOptionPane.showMessageDialog(this, "You have successfully logged in ");
                } else {
                    JOptionPane.showMessageDialog(this, "Wrong Username & Password");
                }
                connection.close();
            } catch (SQLException exception) {
                JOptionPane.showMessageDialog(this, exception.getMessage());
            }
        }

        if (e.getSource() == btnReceptionist){
            String userName = nameField.getText();
            String password = String.valueOf(paswd.getPassword());
            try {
                Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital",
                        "root", "Kibreab.37");

                PreparedStatement statement = connection
                        .prepareStatement("Select UserName, Password from user_type where" +
                                " UserName=? and Password=? and UserType = 'receptionist'");

                statement.setString(1, userName);
                statement.setString(2, password);
                ResultSet rs = statement.executeQuery();
                if (rs.next()) {
                    dispose();
                    Receptionist receptionist = new Receptionist();
                    receptionist.setVisible(true);
                    JOptionPane.showMessageDialog(this, "You have successfully logged in");
                } else {
                    JOptionPane.showMessageDialog(this, "Wrong Username & Password");
                }
                connection.close();
            } catch (SQLException exception) {
                JOptionPane.showMessageDialog(this, exception.getMessage());
            }
        }
        if (e.getSource() == btnPharmacist){
            String userName = nameField.getText();
            String password = String.valueOf(paswd.getPassword());
            try {
                Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital",
                        "root", "Kibreab.37");

                PreparedStatement statement = connection.prepareStatement("Select UserName, Password from user_type " +
                        "where UserName=? and " + "Password=? and UserType = 'pharmacist'");

                statement.setString(1, userName);
                statement.setString(2, password);
                ResultSet rs = statement.executeQuery();
                if (rs.next()) {
                    dispose();
                    Pharmacy pharmacy = new Pharmacy();
                    pharmacy.setVisible(true);
                    JOptionPane.showMessageDialog(this, "You have successfully logged in");
                } else {
                    JOptionPane.showMessageDialog(this, "Wrong Username & Password");
                }
                connection.close();
            } catch (SQLException exception) {
                JOptionPane.showMessageDialog(this, exception.getMessage());
            }
        }
    }

    public static void main(String[] args) {
        new Login();
    }
}