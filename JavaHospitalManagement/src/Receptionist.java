import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Receptionist extends JFrame implements ActionListener {
    private JPanel panel = new JPanel();
    private JLabel labelTitle = new JLabel("Receptionist");
    private JButton btnPatient = new JButton("Register");
    private JButton btnBill = new JButton("Bill");

    private JButton btnBack = new JButton("Logout");
    private JButton btnChangePassword = new JButton("Change Password");
    public Receptionist(){
        super("Receptionist");
        panel.setLayout(null);

        labelTitle.setFont(new Font("Times New Roman",Font.PLAIN,40));
        labelTitle.setBounds(200,50,400,50);
        btnPatient.setBounds(20,200,200,40);
        btnBill.setBounds(20,250,200,40);

        btnBack.setBounds(10,500,100,30);
        btnChangePassword.setBounds(300,300,200,40);
        panel.add(labelTitle);
        panel.add(btnPatient);
        panel.add(btnBill);
        panel.add(btnBack);
        panel.add(btnChangePassword);
        add(panel);


        btnPatient.addActionListener(this);
        btnBack.addActionListener(this);
        btnBill.addActionListener(this);
        btnChangePassword.addActionListener(this);

        setSize(800,600);
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnPatient) {
            new PatientRegister();
            this.dispose();
        }
        if (e.getSource() == btnBill) {
            new Billing();
            this.dispose();
        }
        if (e.getSource() == btnBack) {
            new Login();
            this.dispose();
        }
        if (e.getSource() == btnChangePassword) {
            new ChangePassword();
            this.dispose();
        }
    }

    public static void main(String[] args) {
        new Receptionist();
    }

}
