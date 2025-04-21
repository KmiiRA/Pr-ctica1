package UI.Usuarios;

import BL.GestionarUsuarios;
import javax.swing.*;
import java.awt.*;

public class VentanaModificarUsuario extends JFrame {

    public VentanaModificarUsuario() {
        setTitle("Modificar Usuario");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        //Panel principal
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 40, 20, 40));

        //Campos
        JLabel lblId = new JLabel("ID del usuario a modificar:");
        JTextField txtId = new JTextField();
        JLabel lblNuevoNombre = new JLabel("Nuevo nombre:");
        JTextField txtNuevoNombre = new JTextField();

        lblId.setAlignmentX(Component.CENTER_ALIGNMENT);
        lblNuevoNombre.setAlignmentX(Component.CENTER_ALIGNMENT);

        txtId.setMaximumSize(new Dimension(Integer.MAX_VALUE, 30));
        txtNuevoNombre.setMaximumSize(new Dimension(Integer.MAX_VALUE, 30));

        //Botón modificar
        JButton btnModificar = new JButton("Modificar");
        btnModificar.setAlignmentX(Component.CENTER_ALIGNMENT);

        //Botón volver
        JButton btnVolver = new JButton("Volver");
        btnVolver.setAlignmentX(Component.CENTER_ALIGNMENT);

        //Acción de modificar
        btnModificar.addActionListener(e -> {
            try {
                int id = Integer.parseInt(txtId.getText());
                String nuevoNombre = txtNuevoNombre.getText().trim();
                if (nuevoNombre.isEmpty()) {
                    JOptionPane.showMessageDialog(this, "Debe ingresar un nuevo nombre.");
                    return;
                }
                boolean modificado = GestionarUsuarios.modificarUsuarioPorId(id, nuevoNombre);
                if (modificado) {
                    JOptionPane.showMessageDialog(this, "Usuario modificado correctamente.");
                    dispose();
                } else {
                    JOptionPane.showMessageDialog(this, "No se encontró un usuario con ese ID.");
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "ID no válido.");
            }
        });

        //Volver
        btnVolver.addActionListener(e -> {
            new VentanaUsuarios().setVisible(true);
            dispose();
        });

        //Agregar componentes
        panel.add(lblId);
        panel.add(txtId);
        panel.add(Box.createVerticalStrut(10));
        panel.add(lblNuevoNombre);
        panel.add(txtNuevoNombre);
        panel.add(Box.createVerticalStrut(20));
        panel.add(btnModificar);
        panel.add(Box.createVerticalStrut(10));
        panel.add(btnVolver);

        add(panel);
    }
}