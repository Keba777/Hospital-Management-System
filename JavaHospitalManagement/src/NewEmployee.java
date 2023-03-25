import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class NewEmployee extends JFrame implements ActionListener {
    private JPanel panel;
    private JLabel labelTitle = new JLabel("New employee");
    private JLabel labelName = new JLabel("name");
    private JLabel labelFName = new JLabel("father name");
    private JLabel labelAge = new JLabel("age");
    private JLabel labelPhoneNo = new JLabel("phone no");
    private JLabel labelEmail = new JLabel("email");
    private JLabel labelGender = new JLabel("Gender");
    private JLabel labelAddress = new JLabel("Address");
    private JLabel labelPosition = new JLabel("Position");
    private JLabel labelSalary = new JLabel("salary");
    private JTextField nameField = new JTextField(10);
    private JTextField fNameField = new JTextField(10);
    private JTextField ageField = new JTextField(10);
    private JTextField phoneNoField = new JTextField(10);
    private JTextField emailField = new JTextField(10);
    private JTextField genderField = new JTextField(10);
    private JTextField addressField = new JTextField(10);
    private JTextField positionField = new JTextField(10);
    private JTextField salaryField = new JTextField(10);
    private JButton btnSave = new JButton("Save");
    private JButton btnBack =new JButton("Back");
    public NewEmployee(){
        setTitle("Exodus Hospital");
        setSize(800,600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        panel=new JPanel();
        panel.setLayout(null);

        labelTitle.setFont(new Font("Times New Roman",Font.BOLD,50));

        labelTitle.setBounds(200,40,400,60);
        labelName.setBounds(10,100,200,40);
        labelFName.setBounds(10,150,200,40);
        labelAge.setBounds(10,200,200,40);
        labelPhoneNo.setBounds(10,250,200,40);
        labelEmail.setBounds(10,300,200,40);
        labelGender.setBounds(10,350,200,40);
        labelAddress.setBounds(10,400,200,40);
        labelPosition.setBounds(10,450,200,40);
        labelSalary.setBounds(10,500,200,40);
        btnSave.setBounds(400,200,100,40);
        btnBack.setBounds(400,300,100,40);
        nameField.setBounds(100,100,200,40);
        fNameField.setBounds(100,150,200,40);
        ageField.setBounds(100,200,200,40);
        phoneNoField.setBounds(100,250,200,40);
        emailField.setBounds(100,300,200,40);
        genderField.setBounds(100,350,200,40);
        addressField.setBounds(100,400,200,40);
        positionField.setBounds(100,450,200,40);
        salaryField.setBounds(100,500,200,40);

        panel.add(labelTitle);
        panel.add(labelName);
        panel.add(labelFName);
        panel.add(labelAge);
        panel.add(labelPhoneNo);
        panel.add(labelPhoneNo);
        panel.add(labelEmail);
        panel.add(labelGender);
        panel.add(labelAddress);
        panel.add(labelPosition);
        panel.add(labelSalary);
        panel.add(btnSave);
        panel.add(btnBack);
        panel.add(nameField);
        panel.add(fNameField);
        panel.add(ageField);
        panel.add(phoneNoField);
        panel.add(emailField);
        panel.add(genderField);
        panel.add(addressField);
        panel.add(positionField);
        panel.add(salaryField);

        btnSave.addActionListener(this);
        btnBack.addActionListener(this);

        add(panel);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnSave){
            String first_name = nameField.getText();
            String last_name = fNameField.getText();
            String age = ageField.getText();
            String mobile_number = phoneNoField.getText();
            String email = emailField.getText();
            String gender = genderField.getText();
            String address = addressField.getText();
            String position = positionField.getText();
            String salary = salaryField.getText();

            try {
                Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital",
                        "root", "Kibreab.37");

                String query = "INSERT INTO employee values('" + first_name + "','"
                        + last_name + "','" + age + "','" + mobile_number + "','" + email + "','" + gender +
                        "','" + address + "','" + position + "','" + salary + "')";

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
        if (e.getSource() == btnBack){
            new Admin();
            this.dispose();
        }
    }
    public static void main(String[] args) {
        new NewEmployee();
    }
}

