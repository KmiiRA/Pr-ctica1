package UI.Usuarios;

import UI.Principal.VentanaPrincipal;
import javax.swing.*;
import java.awt.*;

public class VentanaUsuarios extends JFrame{

    public VentanaUsuarios(){
        setTitle("Menú de Usuarios");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null); // Centra la ventana en la pantalla

        //Panel principal
        JPanel panel=new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 40, 20, 40));

        //Título del sistema
        JLabel lblTitulo=new JLabel("Sistema de Tiquetes", SwingConstants.CENTER);
        lblTitulo.setFont(new Font("Arial", Font.BOLD, 22));
        lblTitulo.setAlignmentX(Component.CENTER_ALIGNMENT);

        //Subtítulo
        JLabel lblMenu=new JLabel("Menú de Usuarios", SwingConstants.CENTER);
        lblMenu.setFont(new Font("Arial", Font.PLAIN, 18));
        lblMenu.setAlignmentX(Component.CENTER_ALIGNMENT);

        //Botones
        JButton btnRegistrar=new JButton("Registrar Usuario");
        JButton btnModificar=new JButton("Modificar Usuario");
        JButton btnEliminar=new JButton("Eliminar Usuario");
        JButton btnListar=new JButton("Listar Usuarios");
        JButton btnVolver=new JButton("Volver");

        //Alinear botones
        btnRegistrar.setAlignmentX(Component.CENTER_ALIGNMENT);
        btnModificar.setAlignmentX(Component.CENTER_ALIGNMENT);
        btnEliminar.setAlignmentX(Component.CENTER_ALIGNMENT);
        btnListar.setAlignmentX(Component.CENTER_ALIGNMENT);
        btnVolver.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Acciones para abrir ventanas específicas
        btnRegistrar.addActionListener(e->{
            new VentanaRegistrarUsuario().setVisible(true);
            dispose();
        });

        btnModificar.addActionListener(e->{
            new VentanaModificarUsuario().setVisible(true);
            dispose();
        });

        btnEliminar.addActionListener(e->{
            new VentanaEliminarUsuario().setVisible(true);
            dispose();
        });

        btnListar.addActionListener(e->{
            new VentanaListarUsuarios().setVisible(true);
            dispose();
        });

        btnVolver.addActionListener(e->{
            new VentanaPrincipal().setVisible(true);
            dispose();
        });

        //Separadores y orden
        panel.add(lblTitulo);
        panel.add(Box.createVerticalStrut(10));
        panel.add(lblMenu);
        panel.add(Box.createVerticalStrut(20));
        panel.add(btnRegistrar);
        panel.add(Box.createVerticalStrut(10));
        panel.add(btnModificar);
        panel.add(Box.createVerticalStrut(10));
        panel.add(btnEliminar);
        panel.add(Box.createVerticalStrut(10));
        panel.add(btnListar);
        panel.add(Box.createVerticalStrut(20));
        panel.add(btnVolver);

        add(panel);
    }
}
