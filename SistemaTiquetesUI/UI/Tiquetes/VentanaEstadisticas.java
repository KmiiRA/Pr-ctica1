package UI.Tiquetes;

import BL.GestionarTiquetes;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class VentanaEstadisticas extends JFrame {

    public VentanaEstadisticas() {
        setTitle("Estadísticas de Tiquetes");
        setSize(600, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel panel = new JPanel(new BorderLayout());
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        String[] columnas = {"Categoría", "Cantidad"};
        DefaultTableModel modelo = new DefaultTableModel(columnas, 0);

        int total = GestionarTiquetes.getCantidadTotal();
        int incidentes = GestionarTiquetes.getCantidadPorTipo("Tiquete Incidente");
        int cambios = GestionarTiquetes.getCantidadPorTipo("Tiquete Cambio");
        int servicios = GestionarTiquetes.getCantidadPorTipo("Tiquete Servicio");
        String[][] estados = GestionarTiquetes.getCantidadPorEstado();

        modelo.addRow(new String[]{"Total de Tiquetes", String.valueOf(total)});
        modelo.addRow(new String[]{"Incidentes", String.valueOf(incidentes)});
        modelo.addRow(new String[]{"Cambios", String.valueOf(cambios)});
        modelo.addRow(new String[]{"Servicios", String.valueOf(servicios)});
        modelo.addRow(new String[]{"", ""});
        modelo.addRow(new String[]{"Por Estado", ""});

        for (String[] fila : estados) {
            modelo.addRow(fila);
        }

        modelo.addRow(new String[]{"", ""});
        modelo.addRow(new String[]{"Por Técnico", ""});
        String[][] porTecnico = GestionarTiquetes.getCantidadPorTecnico();
        for (String[] fila : porTecnico) {
            modelo.addRow(fila);
        }

        modelo.addRow(new String[]{"", ""});
        modelo.addRow(new String[]{"Por Creador", ""});
        String[][] porCreador = GestionarTiquetes.getCantidadPorCreador();
        for (String[] fila : porCreador) {
            modelo.addRow(fila);
        }

        JTable tabla = new JTable(modelo);
        JScrollPane scrollPane = new JScrollPane(tabla);

        JButton btnVolver = new JButton("Volver");
        btnVolver.addActionListener(e -> {
            new VentanaTiquetes().setVisible(true);
            dispose();
        });

        JPanel abajo = new JPanel();
        abajo.add(btnVolver);

        panel.add(scrollPane, BorderLayout.CENTER);
        panel.add(abajo, BorderLayout.SOUTH);

        add(panel);
    }
}



