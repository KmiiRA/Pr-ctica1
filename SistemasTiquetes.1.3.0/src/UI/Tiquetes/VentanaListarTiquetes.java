package UI.Tiquetes;

import javax.swing.*;
import java.awt.*;
import BL.GestionarTiquetes;

public class VentanaListarTiquetes extends JFrame {

    public VentanaListarTiquetes() {
        setTitle("Lista de Tiquetes");
        setSize(500, 500);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JTextArea areaTiquetes = new JTextArea();
        areaTiquetes.setEditable(false);
        areaTiquetes.setFont(new Font("Monospaced", Font.PLAIN, 14));
        areaTiquetes.setText(GestionarTiquetes.listarTiquetesComoTexto());

        JScrollPane scroll = new JScrollPane(areaTiquetes);

        JButton btnVolver = new JButton("Volver");
        btnVolver.addActionListener(e -> {
            new VentanaTiquetes().setVisible(true);
            dispose();
        });

        panel.add(scroll, BorderLayout.CENTER);
        panel.add(btnVolver, BorderLayout.SOUTH);

        add(panel);
    }
}

