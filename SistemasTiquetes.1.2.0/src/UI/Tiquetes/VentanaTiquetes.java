package UI.Tiquetes;

import BL.GestionarTiquetes;
import UI.Principal.VentanaPrincipal;

import javax.swing.*;
import java.awt.*;

public class VentanaTiquetes extends JFrame{

    public VentanaTiquetes(){
        setTitle("Menú de Tiquetes");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        //Panel principal
        JPanel panel=new JPanel();
        panel.setLayout(new BoxLayout(panel,BoxLayout.Y_AXIS));
        panel.setBorder(BorderFactory.createEmptyBorder(20,40,20,40));

        //Título del sistema
        JLabel lblTitulo=new JLabel("Sistema de Tiquetes",SwingConstants.CENTER);
        lblTitulo.setFont(new Font("Arial",Font.BOLD,22));
        lblTitulo.setAlignmentX(Component.CENTER_ALIGNMENT);

        //Subtítulo
        JLabel lblMenu=new JLabel("Menú de Tiquetes",SwingConstants.CENTER);
        lblMenu.setFont(new Font("Arial",Font.PLAIN,18));
        lblMenu.setAlignmentX(Component.CENTER_ALIGNMENT);

        //Botones
        JButton btnCrear=new JButton("Crear Tiquete");
        JButton btnModificar=new JButton("Modificar Tiquete");
        JButton btnEliminar=new JButton("Eliminar Tiquete");
        JButton btnListar=new JButton("Listar Tiquetes");
        JButton btnVolver=new JButton("Volver");

        //Alinear botones
        btnCrear.setAlignmentX(Component.CENTER_ALIGNMENT);
        btnModificar.setAlignmentX(Component.CENTER_ALIGNMENT);
        btnEliminar.setAlignmentX(Component.CENTER_ALIGNMENT);
        btnListar.setAlignmentX(Component.CENTER_ALIGNMENT);
        btnVolver.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Conexión directa a la lógica del BL
        btnCrear.addActionListener(e->GestionarTiquetes.crearTiquete());
        btnModificar.addActionListener(e->GestionarTiquetes.modificarTiquete());
        btnEliminar.addActionListener(e->GestionarTiquetes.eliminarTiquete());
        btnListar.addActionListener(e->GestionarTiquetes.listarTiquetes());

        //Volver al menú principal
        btnVolver.addActionListener(e->{
            new VentanaPrincipal().setVisible(true);
            dispose();
        });

        //Separadores y orden
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
        panel.add(Box.createVerticalStrut(20));
        panel.add(btnVolver);

        add(panel);
    }
}
