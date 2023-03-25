import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Admin extends JFrame implements ActionListener{
    private JPanel panel = new JPanel();;
    private JLabel labelTitle = new JLabel("Admin");
    private JButton btnUser = new JButton("Add  user");
    private JButton btnEmployee = new JButton("Manage Employee");
    private JButton btnLogout = new JButton("Logout");
    private JButton btnChangePassword = new JButton("Change Password");

    public Admin(){
        super("Admin");
        setSize(800,600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        panel.setLayout(null);
        labelTitle.setFont(new Font("Times New Roman",Font.BOLD,50));

        labelTitle.setBounds(250,30,200,60);
        btnUser.setBounds(20,150,200,40);        btnEmployee.setBounds(20,200,200,40);
        btnChangePassword.setBounds(400,300,200,40);
        btnLogout.setBounds(10,400,100,40);

        panel.add(labelTitle);
        panel.add(btnUser);
        panel.add(btnEmployee);
        panel.add(btnChangePassword);
        panel.add(btnLogout);

        btnChangePassword.addActionListener(this);
        btnLogout.addActionListener(this);
        btnEmployee.addActionListener(this);
        btnUser.addActionListener(this);

        add(panel);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == btnChangePassword) {
            new ChangePassword();
            this.dispose();

        }
        if (e.getSource() == btnUser) {
            new NewUser();
            this.dispose();

        }
        if (e.getSource() == btnEmployee) {
            new NewEmployee();
            this.dispose();

        }
        if (e.getSource() == btnLogout) {
            new Login();
            this.dispose();

        }
    }

    public static void main(String[] args) {
        new Admin();
    }
}
