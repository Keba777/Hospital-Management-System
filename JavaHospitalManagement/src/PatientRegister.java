import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class PatientRegister extends JFrame implements ActionListener {
    private JPanel panel;
    private JLabel labelTitle = new JLabel("Patient Details");;
    private JLabel labelId=new JLabel("Patient ID");
    private JLabel labelName=new JLabel("Patient Name");
    private JLabel labelFather=new JLabel("Father Name");
    private JLabel labelContact=new JLabel("Contact No.");
    private JLabel labelAge=new JLabel("Age");
    private JLabel labelGender=new JLabel("Gender");
    private JLabel labelAddress=new JLabel("Address");
    private JLabel labelDoctor=new JLabel("Doctor Name");
    private JLabel labelRoom=new JLabel("Room No.");
    private JTextField patientId = new JTextField(10);
    private JTextField patientName = new JTextField(10);
    private JTextField fatherName = new JTextField(10);
    private JTextField contactNo = new JTextField(10);
    private JTextField patientAge = new JTextField(10);
    private JTextField patientGender = new JTextField(10);
    private JTextField patientAddress = new JTextField(10);
    private JTextField doctorName = new JTextField(10);
    private JTextField roomNo = new JTextField(10);
    private JButton btnSave = new JButton("save");
    private JButton btnBack = new JButton("Back");

    public PatientRegister(){
        setTitle("Exodus Hospital");
        setSize(800,600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        panel=new JPanel();
        panel.setLayout(null);

        labelTitle.setFont(new Font("Times New Roman",Font.PLAIN,40));

        labelTitle.setBounds(200,50,300,40);
        labelId.setBounds(10,100,200,40);
        labelName.setBounds(10,150,200,40);
        labelFather.setBounds(10,200,200,40);
        labelContact.setBounds(10,250,200,40);
        labelAge.setBounds(10,300,200,40);
        labelGender.setBounds(10,350,200,40);
        labelAddress.setBounds(10,400,200,40);
        labelDoctor.setBounds(10,450,200,40);
        labelRoom.setBounds(10,500,200,40);
        btnSave.setBounds(400,200,200,40);
        btnBack.setBounds(400,300,200,40);
        patientId.setBounds(100,100,200,40);
        patientName.setBounds(100,150,200,40);
        fatherName.setBounds(100,200,200,40);
        contactNo.setBounds(100,250,200,40);
        patientAge.setBounds(100,300,200,40);
        patientGender.setBounds(100,350,200,40);
        patientAddress.setBounds(100,400,200,40);
        doctorName.setBounds(100,450,200,40);
        roomNo.setBounds(100,500,200,40);
        panel.add(labelTitle);
        panel.add(labelId);
        panel.add(labelName);
        panel.add(labelFather);
        panel.add(labelContact);
        panel.add(labelAge);
        panel.add(labelGender);
        panel.add(labelAddress);
        panel.add(labelDoctor);
        panel.add(labelRoom);

        panel.add(btnSave);
        panel.add(btnBack);
        panel.add(patientId);
        panel.add(patientName);
        panel.add(fatherName);
        panel.add(contactNo);
        panel.add(patientAge);
        panel.add(patientGender);
        panel.add(patientAddress);
        panel.add(doctorName);
        panel.add(roomNo);
        add(panel);

        btnSave.addActionListener(this);
        btnBack.addActionListener(this);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnSave){
        String id = patientId.getText();
        String first_name = patientName.getText();
        String last_name = fatherName.getText();
        String mobile_number = contactNo.getText();
        String age = patientAge.getText();
        String gender = patientGender.getText();
        String address = patientAddress.getText();
        String doctor = doctorName.getText();
        String room = roomNo.getText();


        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital",
                    "root", "Kibreab.37");

            String query = "INSERT INTO patient values('" + id + "','" + first_name + "','"
                    + last_name + "','" + mobile_number + "','" + age + "','" + gender +
                    "','" + address + "','" + doctor + "','" + room + "')";

            Statement statement = connection.createStatement();
            int x = statement.executeUpdate(query);
            if (x == 0) {
                JOptionPane.showMessageDialog(this, "This already exist");
            }
            else {
                JOptionPane.showMessageDialog(this,
                        "Successfully Registered");
            }
            connection.close();
        } catch (SQLException exception) {
            JOptionPane.showMessageDialog(this,exception.getMessage());
        }
        }
        if (e.getSource() == btnBack){
            new Receptionist();
            this.dispose();
        }
}

    public static void main(String[] args) {
        new PatientRegister();
    }
}
