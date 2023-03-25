import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.*;


public class ChangePassword extends JFrame  implements ActionListener{

    private JPanel panel = new JPanel();
    private JTextField nameField = new JTextField(10);
    private JTextField passwordField = new JTextField(10);
    private JLabel labelName = new JLabel("UserName :");
    private JLabel labelPass = new JLabel("Enter New Password :");
    private JButton btnChange = new JButton("Enter");
    private JButton btnLogout = new JButton("Logout");



    public ChangePassword() {
        super("Password Change");
        setSize(800,600);
        setLocationRelativeTo(null);
        panel.setLayout(null);

        labelName.setBounds(40, 100, 300, 50);
        labelPass.setBounds(40, 200, 300, 50);
        nameField.setBounds(200, 100, 300, 50);
        passwordField.setBounds(200, 200, 300, 50);
        btnChange.setBounds(300, 300, 100, 40);
        btnLogout.setBounds(10, 500, 100, 40);

        btnChange.addActionListener(this);
        btnLogout.addActionListener(this);

        panel.add(nameField);
        panel.add(passwordField);
        panel.add(labelName);
        panel.add(labelPass);
        panel.add(btnChange);
        panel.add(btnLogout);
        add(panel);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnChange){
                String text = passwordField.getText();
                String name = nameField.getText();
                try {
                    Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital",
                            "root", "Kibreab.37");

                    PreparedStatement statement = connection
                            .prepareStatement("Update user_type set Password=? where UserName=?");

                    statement.setString(1, text);
                    statement.setString(2, name);
                    statement.executeUpdate();
                    JOptionPane.showMessageDialog(this, "Password has been successfully changed");
                    connection.close();

                } catch (SQLException exception) {
                    JOptionPane.showMessageDialog(this,exception.getMessage());
                }}
        if (e.getSource() == btnLogout){
            new Login();
            dispose();
        }

    }
public static void main(String[] args) {
        new ChangePassword();
        }
}