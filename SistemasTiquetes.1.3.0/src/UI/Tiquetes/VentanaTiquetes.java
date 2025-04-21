package UI.Tiquetes;

import UI.Principal.VentanaPrincipal;
import javax.swing.*;
import java.awt.*;

public class VentanaTiquetes extends JFrame{

    public VentanaTiquetes(){
        setTitle("Menú de Tiquetes");
        setSize(400,400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel=new JPanel();
        panel.setLayout(new BoxLayout(panel,BoxLayout.Y_AXIS));
        panel.setBorder(BorderFactory.createEmptyBorder(20,40,20,40));

        JLabel lblTitulo=new JLabel("Sistema de Tiquetes",SwingConstants.CENTER);
        lblTitulo.setFont(new Font("Arial",Font.BOLD,22));
        lblTitulo.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel lblMenu=new JLabel("Menú de Tiquetes",SwingConstants.CENTER);
        lblMenu.setFont(new Font("Arial",Font.PLAIN,18));
        lblMenu.setAlignmentX(Component.CENTER_ALIGNMENT);

        JButton btnCrear=new JButton("Crear Tiquete");
        JButton btnModificar=new JButton("Modificar Tiquete");
        JButton btnEliminar=new JButton("Eliminar Tiquete");
        JButton btnListar=new JButton("Listar Tiquetes");
        JButton btnEstadisticas=new JButton("Ver Estadísticas");
        JButton btnVolver=new JButton("Volver");

        btnCrear.setAlignmentX(Component.CENTER_ALIGNMENT);
        btnModificar.setAlignmentX(Component.CENTER_ALIGNMENT);
        btnEliminar.setAlignmentX(Component.CENTER_ALIGNMENT);
        btnListar.setAlignmentX(Component.CENTER_ALIGNMENT);
        btnEstadisticas.setAlignmentX(Component.CENTER_ALIGNMENT);
        btnVolver.setAlignmentX(Component.CENTER_ALIGNMENT);

        btnCrear.addActionListener(e->{
            new VentanaCrearTiquete().setVisible(true);
            dispose();
        });

        btnModificar.addActionListener(e->{
            new VentanaModificarTiquete().setVisible(true);
            dispose();
        });

        btnEliminar.addActionListener(e->{
            new VentanaEliminarTiquete().setVisible(true);
            dispose();
        });

        btnListar.addActionListener(e->{
            new VentanaListarTiquetes().setVisible(true);
            dispose();
        });

        btnEstadisticas.addActionListener(e->{
            new VentanaEstadisticas().setVisible(true);
            dispose();
        });

        btnVolver.addActionListener(e->{
            new VentanaPrincipal().setVisible(true);
            dispose();
        });

        panel.add(lblTitulo);
        panel.add(Box.createVerticalStrut(10));
        panel.add(lblMenu);
        panel.add(Box.createVerticalStrut(20));
        panel.add(btnCrear);
        panel.add(Box.createVerticalStrut(10));
        panel.add(btnModificar);
        panel.add(Box.createVerticalStrut(10));
        panel.add(btnEliminar);
        panel.add(Box.createVerticalStrut(10));
        panel.add(btnListar);
        panel.add(Box.createVerticalStrut(10));
        panel.add(btnEstadisticas);
        panel.add(Box.createVerticalStrut(20));
        panel.add(btnVolver);

        add(panel);
    }
}

