import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Billing extends JFrame implements ActionListener{
    private JPanel panel = new JPanel();
    private JLabel labelTitle = new JLabel("Billing");
    private JLabel labelCardCost = new JLabel("card cost");
    private JLabel labelTreatCost = new JLabel("Treatment cost");
    private JLabel labelTotal = new JLabel(" ");
    private JLabel labelID = new JLabel(" Patient Id");
    private JTextField preBillField = new JTextField(10);
    private JTextField postBillField =new JTextField(10);
    private JTextField idField = new JTextField(10);

    private JButton btnSave = new JButton("Save");
    private JButton btnBack = new JButton("Back");
    private JButton btnTotal = new JButton("Total");
    public Billing(){
        setTitle("Billing");
        setSize(800,600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        panel.setLayout(null);

        labelTitle.setFont(new Font("Times New Roman",Font.PLAIN,50));

        labelTitle.setBounds(200,50,400,60);
        labelCardCost.setBounds(10,200,200,40);
        labelTreatCost.setBounds(10,250,200,40);
        labelTotal.setBounds(150,300,200,40);
        labelID.setBounds(10,150,200,40);

        btnSave.setBounds(10,500,100,40);
        btnBack.setBounds(130,500,100,40);
        btnTotal.setBounds(10,300,100,40);

        btnSave.addActionListener(this);
        btnBack.addActionListener(this);
        btnTotal.addActionListener(this);

        preBillField.setBounds(100,200,200,40);
        postBillField.setBounds(100,250,200,40);
        idField.setBounds(100,150,200,40);

        panel.add(labelTitle);
        panel.add(labelCardCost);
        panel.add(labelTreatCost);
        panel.add(labelTotal);
        panel.add(labelID);

        panel.add(btnSave);
        panel.add(btnBack);
        panel.add(btnTotal);
        panel.add(preBillField);
        panel.add(postBillField);
        panel.add(idField);

        add(panel);
        setVisible(true);
    }

        public void actionPerformed(ActionEvent e){
            double n1 = 0;
            double n2 = 0;

            if (e.getSource() == btnTotal){
                n1 = Double.parseDouble(preBillField.getText());
                n2 = Double.parseDouble(postBillField.getText());
            double total=n1+n2;
            labelTotal.setText(" "+total+" Birr");
        }
            if (e.getSource() == btnSave){
                n1 = Double.parseDouble(preBillField.getText());
                n2 = Double.parseDouble(postBillField.getText());
                String id = idField.getText();
                String totalBill = String.valueOf(n1 + n2);

        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital",
                    "root", "Kibreab.37");

            String query = "INSERT INTO billing VALUES ('" + id + "','" + totalBill + "')";

            Statement statement = connection.createStatement();
            int x = statement.executeUpdate(query);
            if (x == 0) {
                JOptionPane.showMessageDialog(this, "This already exist");
            } else {
                JOptionPane.showMessageDialog(this,
                        "Successfully Submitted");
            }
            connection.close();
        } catch (Exception exception) {
            JOptionPane.showMessageDialog(this,exception.getMessage());
        }
    }
        if (e.getSource() == btnBack){
        new Receptionist();
        this.dispose();
    }
}

    public static void main(String[] args) {
        new Billing();
    }
}

