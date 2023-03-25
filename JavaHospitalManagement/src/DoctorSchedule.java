
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class DoctorSchedule extends JFrame implements ActionListener {
    DefaultTableModel model = new DefaultTableModel();
    JTable table = new JTable(model);
    JPanel panel = new JPanel();
    JButton btnBack = new JButton("Back");

    public DoctorSchedule() {
        setTitle("Doctor Schedule");
        setSize(800, 600);
        setLocationRelativeTo(null);

        model.addColumn("PatientId");
        model.addColumn("PatientName");
        model.addColumn("FatherName");
        model.addColumn("ContactNo");
        model.addColumn("Age");
        model.addColumn("Gender");
        model.addColumn("Address");
        model.addColumn("DoctorName");
        model.addColumn("RoomNo");

        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/hospital", "root",
                    "Kibreab.37");
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM patient");
            ResultSet result = statement.executeQuery();
            while (result.next()) {
                model.addRow(new Object[]{result.getInt(1), result.getString(2), result.getString(3),
                        result.getInt(4), result.getInt(5), result.getString(6),
                        result.getString(7), result.getString(8), result.getInt(9),});
            }
        } catch (SQLException exception) {
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
            new Doctor();
            this.dispose();
        }
    }

    public static void main(String[] args) {
        new DoctorSchedule();

    }
}