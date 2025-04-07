package UI.Tiquetes;

import BL.GestionarTiquetes;
import UI.Tiquetes.VentanaTiquetes;

import javax.swing.*;
import java.awt.*;

public class VentanaTipoTiquete extends JFrame{

    public VentanaTipoTiquete(){
        setTitle("Tipo de Tiquete");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        //Principal
        JPanel panel=new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 40, 20, 40));

        //Título del sistema
        JLabel lblTitulo=new JLabel("Sistema de Tiquetes", SwingConstants.CENTER);
        lblTitulo.setFont(new Font("Arial", Font.BOLD, 22));
        lblTitulo.setAlignmentX(Component.CENTER_ALIGNMENT);

        //Subtítulo
        JLabel lblMenu=new JLabel("Tipo de Tiquete", SwingConstants.CENTER);
        lblMenu.setFont(new Font("Arial", Font.PLAIN, 18));
        lblMenu.setAlignmentX(Component.CENTER_ALIGNMENT);

        //Botones
        JButton btnIncidente=new JButton("Incidente");
        JButton btnCambio=new JButton("Cambio");
        JButton btnServicio=new JButton("Servicio");
        JButton btnVolver=new JButton("Volver");

        //Alinear botones
        btnIncidente.setAlignmentX(Component.CENTER_ALIGNMENT);
        btnCambio.setAlignmentX(Component.CENTER_ALIGNMENT);
        btnServicio.setAlignmentX(Component.CENTER_ALIGNMENT);
        btnVolver.setAlignmentX(Component.CENTER_ALIGNMENT);

        //Conexión al BL
        btnIncidente.addActionListener(e->GestionarTiquetes.crearTiquete());
        btnCambio.addActionListener(e->GestionarTiquetes.crearTiquete());
        btnServicio.addActionListener(e->GestionarTiquetes.crearTiquete());

        //Volver al menú de tiquetes
        btnVolver.addActionListener(e->{
            new VentanaTiquetes().setVisible(true);
            dispose();
        });

        //Separadores
        panel.add(lblTitulo);
        panel.add(Box.createVerticalStrut(10));
        panel.add(lblMenu);
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
