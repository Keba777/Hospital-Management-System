import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Medicine extends JFrame implements ActionListener {
    DefaultTableModel model = new DefaultTableModel();
    JTable table = new JTable(model);
    JPanel panel = new JPanel();
    JButton button = new JButton("Back");

    public Medicine(){
        setTitle("Medicine");
        setSize(800, 600);
        setLocationRelativeTo(null);

        model.addColumn("Patient Id");
        model.addColumn("Prescription-1");
        model.addColumn("Prescription-2");
        model.addColumn("Prescription-3");


        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/hospital", "root",
                    "Kibreab.37");
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM prescription");
            ResultSet result = statement.executeQuery();
            while (result.next()) {
                model.addRow(new Object[]{result.getInt(1), result.getString(2),
                        result.getString(3), result.getString(4),});
            }
            connection.close();
        } catch (Exception exception) {
            JOptionPane.showMessageDialog(this, exception.getMessage());
        }

        button.setSize(80,40);
        JScrollPane scroll = new JScrollPane(table);
        add(scroll);
        panel.add(button);
        add(panel, BorderLayout.SOUTH);

        button.addActionListener(this);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == button) {
            new Pharmacy();
            this.dispose();
        }
    }

    public static void main(String[] args) {
        new Medicine();
    }

}
