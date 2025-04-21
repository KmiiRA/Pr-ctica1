package UI.Tiquetes;

import javax.swing.*;
import java.awt.*;
import BL.GestionarTiquetes;

public class VentanaCrearIncidente extends JFrame {

    public VentanaCrearIncidente() {
        setTitle("Crear Tiquete de Incidente");
        setSize(400, 500);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 40, 20, 40));

        JLabel lblTitulo = new JLabel("Sistema de Tiquetes", SwingConstants.CENTER);
        lblTitulo.setFont(new Font("Arial", Font.BOLD, 22));
        lblTitulo.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel lblSubtitulo = new JLabel("Crear Tiquete de Incidente", SwingConstants.CENTER);
        lblSubtitulo.setFont(new Font("Arial", Font.PLAIN, 18));
        lblSubtitulo.setAlignmentX(Component.CENTER_ALIGNMENT);

        JTextField txtCodigo = new JTextField();
        JTextField txtDescripcion = new JTextField();
        JTextField txtEstado = new JTextField();
        JTextField txtUsuarioCreador = new JTextField();
        JTextField txtTecnicoAsignado = new JTextField();
        JTextField txtImpacto = new JTextField();
        JTextField txtNotas = new JTextField();

        JButton btnCrear = new JButton("Crear");
        JButton btnVolver = new JButton("Volver");

        panel.add(lblTitulo);
        panel.add(Box.createVerticalStrut(10));
        panel.add(lblSubtitulo);
        panel.add(Box.createVerticalStrut(20));
        panel.add(new JLabel("Código:"));
        panel.add(txtCodigo);
        panel.add(new JLabel("Descripción:"));
        panel.add(txtDescripcion);
        panel.add(new JLabel("Estado:"));
        panel.add(txtEstado);
        panel.add(new JLabel("Usuario Creador (ID):"));
        panel.add(txtUsuarioCreador);
        panel.add(new JLabel("Técnico Asignado (ID):"));
        panel.add(txtTecnicoAsignado);
        panel.add(new JLabel("Impacto:"));
        panel.add(txtImpacto);
        panel.add(new JLabel("Notas:"));
        panel.add(txtNotas);
        panel.add(Box.createVerticalStrut(15));
        panel.add(btnCrear);
        panel.add(Box.createVerticalStrut(10));
        panel.add(btnVolver);

        btnCrear.addActionListener(e -> {
            try {
                int codigo = Integer.parseInt(txtCodigo.getText());
                int usuario = Integer.parseInt(txtUsuarioCreador.getText());
                int tecnico = Integer.parseInt(txtTecnicoAsignado.getText());
                String descripcion = txtDescripcion.getText();
                String estado = txtEstado.getText();
                String impacto = txtImpacto.getText();
                String notas = txtNotas.getText();

                GestionarTiquetes.crearTiqueteIncidente(codigo, descripcion, estado, usuario, tecnico, impacto, notas);
                JOptionPane.showMessageDialog(this, "Tiquete creado con éxito");
                dispose();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Error en los datos ingresados");
            }
        });

        btnVolver.addActionListener(e -> {
            new VentanaTiquetes().setVisible(true);
            dispose();
        });

        add(panel);
    }
}

