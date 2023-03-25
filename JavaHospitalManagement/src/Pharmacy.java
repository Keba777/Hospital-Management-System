import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Pharmacy extends JFrame implements ActionListener {
    private JPanel panel;
    private JLabel label;
    private JButton buttonMed;
    private JButton buttonStore;
    private JButton buttonLogout;
    private JButton btnChangePassword;
    public Pharmacy(){
        super("Pharmacy");
        panel = new JPanel();
        panel.setLayout(null);
        label=new JLabel("Pharmacy");
        label.setFont(new Font("Times New Roman",Font.PLAIN,50));
        buttonMed=new JButton("Medicine");
        buttonStore=new JButton("Store");
        buttonLogout=new JButton("Logout");
        btnChangePassword =new JButton("Change Password");

        label.setBounds(100,50,400,60);
        buttonMed.setBounds(20,200,200,40);
        buttonStore.setBounds(20,260,200,40);
        buttonLogout.setBounds(10,500,100,30);
        btnChangePassword.setBounds(400,300,200,40);
        panel.add(label);
        panel.add(buttonMed);
        panel.add(buttonStore);
        panel.add(buttonLogout);
        panel.add(btnChangePassword);

        buttonMed.addActionListener(this);
        buttonStore.addActionListener(this);
        buttonLogout.addActionListener(this);
        btnChangePassword.addActionListener(this);

        add(panel);
        setSize(800,600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == buttonMed) {
            new Medicine();
            this.dispose();
        }
        if (e.getSource() == buttonStore) {
            new DrugStore();
            this.dispose();
        }
        if (e.getSource() == buttonLogout) {
            new Login();
            this.dispose();
        }
        if (e.getSource() == btnChangePassword) {
            new ChangePassword();
            this.dispose();
        }
    }

    public static void main(String[] args) {
        Pharmacy pharmacy = new Pharmacy();
    }
}
