package UI.Tiquetes;

import javax.swing.*;
import java.awt.*;

public class VentanaCrearTiquete extends JFrame{

    public VentanaCrearTiquete(){
        setTitle("Crear Tiquete");
        setSize(400,300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        //Panel principal
        JPanel panel=new JPanel();
        panel.setLayout(new BoxLayout(panel,BoxLayout.Y_AXIS));
        panel.setBorder(BorderFactory.createEmptyBorder(20,40,20,40));

        //Título
        JLabel lblTitulo=new JLabel("Sistema de Tiquetes",SwingConstants.CENTER);
        lblTitulo.setFont(new Font("Arial",Font.BOLD,22));
        lblTitulo.setAlignmentX(Component.CENTER_ALIGNMENT);

        //Subtítulo
        JLabel lblSubtitulo=new JLabel("Seleccione tipo de tiquete",SwingConstants.CENTER);
        lblSubtitulo.setFont(new Font("Arial",Font.PLAIN,18));
        lblSubtitulo.setAlignmentX(Component.CENTER_ALIGNMENT);

        //Botones
        JButton btnIncidente=new JButton("Tiquete de Incidente");
        JButton btnCambio=new JButton("Tiquete de Cambio");
        JButton btnServicio=new JButton("Tiquete de Servicio");
        JButton btnVolver=new JButton("Volver");

        //Alinear botones
        btnIncidente.setAlignmentX(Component.CENTER_ALIGNMENT);
        btnCambio.setAlignmentX(Component.CENTER_ALIGNMENT);
        btnServicio.setAlignmentX(Component.CENTER_ALIGNMENT);
        btnVolver.setAlignmentX(Component.CENTER_ALIGNMENT);

        //Acciones
        btnIncidente.addActionListener(e->{
            new VentanaCrearIncidente().setVisible(true);
            dispose();
        });

        btnCambio.addActionListener(e->{
            new VentanaCrearCambio().setVisible(true);
            dispose();
        });

        btnServicio.addActionListener(e->{
            new VentanaCrearServicio().setVisible(true);
            dispose();
        });

        btnVolver.addActionListener(e->{
            new VentanaTiquetes().setVisible(true);
            dispose();
        });

        //Organización
        panel.add(lblTitulo);
        panel.add(Box.createVerticalStrut(10));
        panel.add(lblSubtitulo);
        panel.add(Box.createVerticalStrut(20));
        panel.add(btnIncidente);
        panel.add(Box.createVerticalStrut(10));
        panel.add(btnCambio);
        panel.add(Box.createVerticalStrut(10));
        panel.add(btnServicio);
        panel.add(Box.createVerticalStrut(20));
        panel.add(btnVolver);

        add(panel);
    }
}
