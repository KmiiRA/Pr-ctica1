package UI.Tiquetes;

import javax.swing.*;
import java.awt.*;
import BL.GestionarTiquetes;

public class VentanaModificarTiquete extends JFrame{

    public VentanaModificarTiquete(){
        setTitle("Modificar Estado del Tiquete");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 40, 20, 40));

        JLabel lblTitulo = new JLabel("Sistema de Tiquetes", SwingConstants.CENTER);
        lblTitulo.setFont(new Font("Arial", Font.BOLD, 22));
        lblTitulo.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel lblSubtitulo = new JLabel("Modificar Tiquete", SwingConstants.CENTER);
        lblSubtitulo.setFont(new Font("Arial", Font.PLAIN, 18));
        lblSubtitulo.setAlignmentX(Component.CENTER_ALIGNMENT);

        JTextField txtCodigo = new JTextField();
        JTextField txtNuevoEstado = new JTextField();

        JButton btnModificar = new JButton("Modificar");
        JButton btnVolver = new JButton("Volver");

        panel.add(lblTitulo);
        panel.add(Box.createVerticalStrut(10));
        panel.add(lblSubtitulo);
        panel.add(Box.createVerticalStrut(20));
        panel.add(new JLabel("Código del Tiquete:"));
        panel.add(txtCodigo);
        panel.add(new JLabel("Nuevo Estado:"));
        panel.add(txtNuevoEstado);
        panel.add(Box.createVerticalStrut(15));
        panel.add(btnModificar);
        panel.add(Box.createVerticalStrut(10));
        panel.add(btnVolver);

        btnModificar.addActionListener(e -> {
            try {
                int codigo = Integer.parseInt(txtCodigo.getText());
                String nuevoEstado = txtNuevoEstado.getText();

                boolean modificado = GestionarTiquetes.modificarEstadoTiquete(codigo, nuevoEstado);
                if (modificado) {
                    JOptionPane.showMessageDialog(this, "Tiquete actualizado");
                    dispose();
                } else {
                    JOptionPane.showMessageDialog(this, "Tiquete no encontrado");
                }
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Datos inválidos");
            }
        });

        btnVolver.addActionListener(e -> {
            new VentanaTiquetes().setVisible(true);
            dispose();
        });

        add(panel);
    }
}

