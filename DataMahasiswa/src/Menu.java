import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Menu extends JFrame {
    public static void main(String[] args) {
        Menu window = new Menu();
        window.setSize(600, 450);
        window.setLocationRelativeTo(null);
        window.setContentPane(window.mainPanel);
        window.getContentPane().setBackground(Color.white);
        window.setVisible(true);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private int selectedIndex = -1;
    private Database database;

    // Komponen GUI
    private JPanel mainPanel;
    private JTextField nimField;
    private JTextField namaField;
    private JTable mahasiswaTable;
    private JButton addUpdateButton;
    private JButton cancelButton;
    private JComboBox<String> jenisKelaminComboBox;
    private JButton deleteButton;
    private JLabel titleLabel;
    private JSlider semesterSlider;
    private JLabel semesterValueLabel;

    private JLabel nimLabel;
    private JLabel namaLabel;
    private JLabel jenisKelaminLabel;
    private JLabel semesterLabel;

    public Menu() {
        database = new Database();

        // Inisialisasi tabel
        mahasiswaTable.setModel(setTable());

        // Styling
        titleLabel.setFont(new Font("Arial", Font.BOLD, 20));

        // Combo box
        String[] genderOptions = {"", "Laki-laki", "Perempuan"};
        jenisKelaminComboBox.setModel(new DefaultComboBoxModel<>(genderOptions));

        // Slider semester
        semesterSlider.setMinimum(1);
        semesterSlider.setMaximum(8);
        semesterSlider.setPaintTicks(true);
        semesterSlider.setPaintLabels(true);
        semesterSlider.setMajorTickSpacing(1);
        semesterValueLabel.setText("1");

        semesterSlider.addChangeListener(e -> {
            semesterValueLabel.setText(String.valueOf(semesterSlider.getValue()));
        });

        // Event Handlers
        addUpdateButton.addActionListener(e -> handleAddUpdate());
        deleteButton.addActionListener(e -> handleDelete());
        cancelButton.addActionListener(e -> clearForm());

        mahasiswaTable.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                selectedIndex = mahasiswaTable.getSelectedRow();
                loadSelectedData();
            }
        });
    }

    private void handleAddUpdate() {
        if (isFormInvalid()) {
            JOptionPane.showMessageDialog(this, "Inputan tidak boleh ada yang kosong!", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (selectedIndex == -1) {
            insertData();
        } else {
            updateData();
        }
    }

    private boolean isFormInvalid() {
        return nimField.getText().isEmpty() ||
                namaField.getText().isEmpty() ||
                jenisKelaminComboBox.getSelectedIndex() == 0;
    }

    private void handleDelete() {
        if (selectedIndex >= 0) {
            int confirm = JOptionPane.showConfirmDialog(
                    this,
                    "Apakah Anda yakin ingin menghapus data?",
                    "Konfirmasi",
                    JOptionPane.YES_NO_OPTION
            );

            if (confirm == JOptionPane.YES_OPTION) {
                deleteData();
            }
        }
    }

    private DefaultTableModel setTable() {
        DefaultTableModel model = new DefaultTableModel(
                new Object[]{"No", "NIM", "Nama", "Jenis Kelamin", "Semester"},
                0
        );

        try {
            ResultSet rs = database.selectQuery("SELECT * FROM mahasiswa");
            int counter = 1;
            while (rs.next()) {
                model.addRow(new Object[]{
                        counter++,
                        rs.getString("nim"),
                        rs.getString("nama"),
                        rs.getString("jenis_kelamin"),
                        rs.getInt("semester")
                });
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error loading data: " + e.getMessage());
        }

        return model;
    }

    private void insertData() {
        String nim = nimField.getText();
        String nama = namaField.getText();
        String gender = jenisKelaminComboBox.getSelectedItem().toString();
        int semester = semesterSlider.getValue();

        try {
            ResultSet check = database.selectQuery("SELECT * FROM mahasiswa WHERE nim = '" + nim + "'");
            if (check.next()) {
                JOptionPane.showMessageDialog(this, "NIM sudah terdaftar!", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            String sql = String.format(
                    "INSERT INTO mahasiswa VALUES (null, '%s', '%s', '%s', %d)",
                    nim, nama, gender, semester
            );

            database.insertUpdateDeleteQuery(sql);
            refreshTable();
            clearForm();
            JOptionPane.showMessageDialog(this, "Data berhasil ditambahkan!");

        } catch (SQLException e) {
            handleDatabaseError(e);
        }
    }

    private void updateData() {
        String originalNim = mahasiswaTable.getValueAt(selectedIndex, 1).toString();
        String newNim = nimField.getText();

        try {
            if (!newNim.equals(originalNim)) {
                ResultSet check = database.selectQuery("SELECT * FROM mahasiswa WHERE nim = '" + newNim + "'");
                if (check.next()) {
                    JOptionPane.showMessageDialog(this, "NIM sudah terdaftar!", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
            }

            String sql = String.format(
                    "UPDATE mahasiswa SET " +
                            "nim = '%s', nama = '%s', jenis_kelamin = '%s', semester = %d " +
                            "WHERE nim = '%s'",
                    newNim,
                    namaField.getText(),
                    jenisKelaminComboBox.getSelectedItem(),
                    semesterSlider.getValue(),
                    originalNim
            );

            database.insertUpdateDeleteQuery(sql);
            refreshTable();
            clearForm();
            JOptionPane.showMessageDialog(this, "Data berhasil diupdate!");

        } catch (SQLException e) {
            handleDatabaseError(e);
        }
    }

    private void deleteData() {
        String nim = mahasiswaTable.getValueAt(selectedIndex, 1).toString();

        try {
            String sql = "DELETE FROM mahasiswa WHERE nim = '" + nim + "'";
            database.insertUpdateDeleteQuery(sql);
            refreshTable();
            clearForm();
            JOptionPane.showMessageDialog(this, "Data berhasil dihapus!");

        } catch (Exception e) {
            handleDatabaseError(e);
        }
    }

    private void loadSelectedData() {
        nimField.setText(mahasiswaTable.getValueAt(selectedIndex, 1).toString());
        namaField.setText(mahasiswaTable.getValueAt(selectedIndex, 2).toString());
        jenisKelaminComboBox.setSelectedItem(mahasiswaTable.getValueAt(selectedIndex, 3).toString());
        semesterSlider.setValue((Integer) mahasiswaTable.getValueAt(selectedIndex, 4));

        addUpdateButton.setText("Update");
        deleteButton.setVisible(true);
    }

    private void refreshTable() {
        mahasiswaTable.setModel(setTable());
    }

    private void clearForm() {
        nimField.setText("");
        namaField.setText("");
        jenisKelaminComboBox.setSelectedIndex(0);
        semesterSlider.setValue(1);

        addUpdateButton.setText("Add");
        deleteButton.setVisible(false);
        selectedIndex = -1;
    }

    private void handleDatabaseError(Exception e) {
        JOptionPane.showMessageDialog(
                this,
                "Database error: " + e.getMessage(),
                "Error",
                JOptionPane.ERROR_MESSAGE
        );
        e.printStackTrace();
    }
}