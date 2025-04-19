package UI.Usuarios;

import BL.GestionarUsuarios;
import javax.swing.*;
import java.awt.*;

public class VentanaListarUsuarios extends JFrame{

    public VentanaListarUsuarios(){
        setTitle("Lista de Usuarios");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        //Panel principal
        JPanel panel=new JPanel();
        panel.setLayout(new BorderLayout());
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        //Área de texto para mostrar los usuarios
        JTextArea areaUsuarios=new JTextArea();
        areaUsuarios.setEditable(false);
        areaUsuarios.setFont(new Font("Monospaced", Font.PLAIN, 14));
        areaUsuarios.setText(GestionarUsuarios.listarUsuariosComoTexto());

        //Scroll por si hay muchos usuarios
        JScrollPane scroll=new JScrollPane(areaUsuarios);

        //Botón volver
        JButton btnVolver=new JButton("Volver");
        btnVolver.addActionListener(e->{
            new VentanaUsuarios().setVisible(true);
            dispose();
        });

        //Agregar componentes
        panel.add(scroll, BorderLayout.CENTER);
        panel.add(btnVolver, BorderLayout.SOUTH);

        add(panel);
    }
}
