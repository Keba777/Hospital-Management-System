import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class NewUser extends JFrame implements ActionListener {
    private JPanel panel = new JPanel();
    private JLabel labelTitle = new JLabel("New User");
    private JLabel labelUser = new JLabel("user name");;
    private JLabel labelPass = new JLabel("password");
    private JLabel labelUserType = new JLabel("user type");
    private JTextField userField =new JTextField(10);
    private JTextField userTypeField =new JTextField(10);
    private JPasswordField passwordField = new JPasswordField(10);
    private JButton btnSave =new JButton("Save");
    private JButton btnBack =new JButton("Back");
    public NewUser(){
        super("Add New User");
        setSize(800,600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        panel.setLayout(null);
        labelTitle.setFont(new Font("Times New Roman",Font.BOLD,50));

        labelTitle.setBounds(200,50,400,40);
        labelUser.setBounds(10,150,200,40);
        labelPass.setBounds(10,200,200,40);
        labelUserType.setBounds(10,250,200,40);
        userField.setBounds(100,150,200,40);
        passwordField.setBounds(100,200,200,40);
        userTypeField.setBounds(100,250,200,40);
        btnSave.setBounds(100,320,150,40);
        btnBack.setBounds(10,500,150,40);

        btnSave.addActionListener(this);
        btnBack.addActionListener(this);

        panel.add(labelTitle);
        panel.add(labelUser);
        panel.add(labelPass);
        panel.add(labelUserType);
        panel.add(btnSave);
        panel.add(btnBack);
        panel.add(userField);
        panel.add(passwordField);
        panel.add(userTypeField);

        add(panel);
        setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnSave) {
            String user_name = userField.getText();
            String user_pass = String.valueOf(passwordField.getPassword());
            String user_type = userTypeField.getText();

            try {
                Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital",
                        "root", "Kibreab.37");

                String query = "INSERT INTO user_type values('" + user_name + "','" + user_pass + "','"
                        + user_type + "')";

                Statement statement = connection.createStatement();
                int count = statement.executeUpdate(query);
                if (count == 0) {
                    JOptionPane.showMessageDialog(this, "This already exist");
                } else {
                    JOptionPane.showMessageDialog(this,
                            "Successfully Registered");
                }
                connection.close();
            } catch (Exception exception) {
                JOptionPane.showMessageDialog(this, exception.getMessage());
            }
        }

        if (e.getSource() == btnBack) {
            new Admin();
            this.dispose();

        }
    }
    public static void main(String[] args) {
        new NewUser();
    }
}

