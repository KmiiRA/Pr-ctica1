package UI.Principal;

import UI.Tiquetes.VentanaTiquetes;
import UI.Usuarios.VentanaUsuarios;

import javax.swing.*;
import java.awt.*;

public class VentanaPrincipal extends JFrame {

    public static String tipoUsuario;

    public VentanaPrincipal(){
        setTitle("Sistema de Tiquetes");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        //Panel principal
        JPanel panel=new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 40, 20, 40));

        //Título
        JLabel lblTitulo=new JLabel("Sistema de Tiquetes", SwingConstants.CENTER);
        lblTitulo.setFont(new Font("Arial", Font.BOLD, 22));
        lblTitulo.setAlignmentX(Component.CENTER_ALIGNMENT);

        //Subtítulo
        JLabel lblSubtitulo=new JLabel("Menú Principal", SwingConstants.CENTER);
        lblSubtitulo.setFont(new Font("Arial", Font.PLAIN, 18));
        lblSubtitulo.setAlignmentX(Component.CENTER_ALIGNMENT);

        //Botones
        JButton btnUsuarios=new JButton("Usuarios");
        JButton btnTiquetes=new JButton("Tiquetes");

        //Alineación
        btnUsuarios.setAlignmentX(Component.CENTER_ALIGNMENT);
        btnTiquetes.setAlignmentX(Component.CENTER_ALIGNMENT);

        //Acciones
        btnUsuarios.addActionListener(e->{
            new VentanaUsuarios().setVisible(true);
            dispose();
        });

        btnTiquetes.addActionListener(e->{
            new VentanaTiquetes().setVisible(true);
            dispose();
        });

        //Organización
        panel.add(lblTitulo);
        panel.add(Box.createVerticalStrut(10));
        panel.add(lblSubtitulo);
        panel.add(Box.createVerticalStrut(20));
        panel.add(btnUsuarios);
        panel.add(Box.createVerticalStrut(10));
        panel.add(btnTiquetes);


        add(panel);
    }

}
