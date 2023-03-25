
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DrugStore extends JFrame implements ActionListener {
    DefaultTableModel model = new DefaultTableModel();
    JTable table = new JTable(model);
    JPanel panel = new JPanel();
    JButton btnBack = new JButton("Back");

    public DrugStore() {
        setTitle("Drug Store");
        setSize(800, 600);
        setLocationRelativeTo(null);

        model.addColumn("DrugNo");
        model.addColumn("MedicineName");
        model.addColumn("Description");

        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/hospital", "root",
                    "Kibreab.37");
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM drug_store");
            ResultSet result = statement.executeQuery();
            while (result.next()) {
                model.addRow(new Object[]{result.getInt(1), result.getString(2), result.getString(3),});
            }
        } catch (Exception exception) {
            JOptionPane.showMessageDialog(this, exception.getMessage());
        }

        btnBack.setSize(80,40);
        JScrollPane scroll = new JScrollPane(table);
        add(scroll);
        panel.add(btnBack);
        add(panel,BorderLayout.SOUTH);

        btnBack.addActionListener(this);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnBack) {
            new Pharmacy();
            this.dispose();
        }
    }

    public static void main(String[] args) {
        new DrugStore();

    }
}