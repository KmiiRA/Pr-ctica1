package UI.Tiquetes;

import javax.swing.*;
import java.awt.*;
import BL.GestionarTiquetes;

public class VentanaEliminarTiquete extends JFrame {

    public VentanaEliminarTiquete() {
        setTitle("Eliminar Tiquete");
        setSize(400, 250);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 40, 20, 40));

        JLabel lblTitulo = new JLabel("Sistema de Tiquetes", SwingConstants.CENTER);
        lblTitulo.setFont(new Font("Arial", Font.BOLD, 22));
        lblTitulo.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel lblSubtitulo = new JLabel("Eliminar Tiquete", SwingConstants.CENTER);
        lblSubtitulo.setFont(new Font("Arial", Font.PLAIN, 18));
        lblSubtitulo.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel lblCodigo = new JLabel("Código del Tiquete:");
        JTextField txtCodigo = new JTextField();
        txtCodigo.setMaximumSize(new Dimension(Integer.MAX_VALUE, 30));

        JButton btnEliminar = new JButton("Eliminar");
        btnEliminar.setAlignmentX(Component.CENTER_ALIGNMENT);

        JButton btnVolver = new JButton("Volver");
        btnVolver.setAlignmentX(Component.CENTER_ALIGNMENT);

        btnEliminar.addActionListener(e -> {
            try {
                int codigo = Integer.parseInt(txtCodigo.getText());
                boolean resultado = GestionarTiquetes.eliminarTiquetePorCodigo(codigo);
                if (resultado) {
                    JOptionPane.showMessageDialog(this, "Tiquete eliminado exitosamente");
                    dispose();
                } else {
                    JOptionPane.showMessageDialog(this, "No se encontró un tiquete con ese código");
                }
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Código no válido");
            }
        });

        btnVolver.addActionListener(e -> {
            new VentanaTiquetes().setVisible(true);
            dispose();
        });

        panel.add(lblTitulo);
        panel.add(Box.createVerticalStrut(10));
        panel.add(lblSubtitulo);
        panel.add(Box.createVerticalStrut(20));
        panel.add(lblCodigo);
        panel.add(txtCodigo);
        panel.add(Box.createVerticalStrut(20));
        panel.add(btnEliminar);
        panel.add(Box.createVerticalStrut(10));
        panel.add(btnVolver);

        add(panel);
    }
}

