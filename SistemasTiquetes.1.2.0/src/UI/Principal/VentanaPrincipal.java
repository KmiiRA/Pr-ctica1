package UI.Principal;

import UI.Usuarios.VentanaUsuarios;
import UI.Tiquetes.VentanaTiquetes;

import javax.swing.*;
import java.awt.*;

public class VentanaPrincipal extends JFrame{

    public VentanaPrincipal(){
        setTitle("Sistema de Tiquetes");
        setSize(400, 250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Centrar la ventana

        //Panel principal
        JPanel panel=new JPanel();
        panel.setLayout(new BoxLayout(panel,BoxLayout.Y_AXIS));
        panel.setBorder(BorderFactory.createEmptyBorder(20,40,20,40));

        //Título principal
        JLabel lblTitulo=new JLabel("Sistema de Tiquetes",SwingConstants.CENTER);
        lblTitulo.setFont(new Font("Arial",Font.BOLD,22));
        lblTitulo.setAlignmentX(Component.CENTER_ALIGNMENT);

        //Subtítulo
        JLabel lblMenu=new JLabel("Menú Principal",SwingConstants.CENTER);
        lblMenu.setFont(new Font("Arial",Font.PLAIN,18));
        lblMenu.setAlignmentX(Component.CENTER_ALIGNMENT);

        //Botones de navegación
        JButton btnUsuarios=new JButton("Usuarios");
        JButton btnTiquetes=new JButton("Tiquetes");

        btnUsuarios.setAlignmentX(Component.CENTER_ALIGNMENT);
        btnTiquetes.setAlignmentX(Component.CENTER_ALIGNMENT);

        //Acciones de los botones
        btnUsuarios.addActionListener(e->new VentanaUsuarios().setVisible(true));
        btnTiquetes.addActionListener(e->new VentanaTiquetes().setVisible(true));

        //Organización visual
        panel.add(lblTitulo);
        panel.add(Box.createVerticalStrut(10));
        panel.add(lblMenu);
        panel.add(Box.createVerticalStrut(20));
        panel.add(btnUsuarios);
        panel.add(Box.createVerticalStrut(10));
        panel.add(btnTiquetes);

        add(panel);
    }

    //Main
    public static void main(String[] args){
        SwingUtilities.invokeLater(()->{
            new VentanaPrincipal().setVisible(true);
        });
    }
}
