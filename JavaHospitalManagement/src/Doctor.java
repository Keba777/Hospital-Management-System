import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Doctor extends JFrame implements ActionListener {
    private JPanel panel = new JPanel();
    private JLabel labelTitle = new JLabel("Doctor");;
    private JButton btnAppointment = new JButton("Appointment");
    private JButton btnPrescription = new JButton("Prescription");
    private JButton btnLogout = new JButton("Logout");
    private JButton btnChangePassword = new JButton("Change Password");;
    public Doctor(){
        super("Doctors");

        panel.setLayout(null);
        labelTitle.setFont(new Font("Times New Roman",Font.BOLD,50));

        labelTitle.setBounds(100,50,400,60);
        btnAppointment.setBounds(20,200,200,40);
        btnPrescription.setBounds(20,260,200,40);
        btnLogout.setBounds(10,500,100,30);
        btnChangePassword.setBounds(400,300,200,40);
        panel.add(labelTitle);
        panel.add(btnAppointment);
        panel.add(btnPrescription);
        panel.add(btnLogout);
        panel.add(btnChangePassword);

        btnAppointment.addActionListener(this);
        btnPrescription.addActionListener(this);
        btnLogout.addActionListener(this);
        btnChangePassword.addActionListener(this);

        add(panel);
        setSize(800,600);
        setLocationRelativeTo(null);

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnAppointment) {
            new DoctorSchedule();
            this.dispose();

        }

        if (e.getSource() == btnPrescription) {
            new Prescription();
            this.dispose();

        }
        if (e.getSource() == btnLogout) {
            new Login();
            this.dispose();

        }
        if (e.getSource() == btnChangePassword) {
            new ChangePassword();
            this.dispose();

        }
    }

    public static void main(String[] args) {
        Doctor doctor = new Doctor();
    }
}
