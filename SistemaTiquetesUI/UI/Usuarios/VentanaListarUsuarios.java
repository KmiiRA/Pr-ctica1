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


        JTextArea areaUsuarios=new JTextArea();
        areaUsuarios.setEditable(false);
        areaUsuarios.setFont(new Font("Monospaced", Font.PLAIN, 14));


        GestionarUsuarios.listarUsuarios();
        areaUsuarios.setText(GestionarUsuarios.listarUsuariosComoTexto());


        JScrollPane scroll=new JScrollPane(areaUsuarios);

        //Volver
        JButton btnVolver=new JButton("Volver");
        btnVolver.addActionListener(e->{
            new VentanaUsuarios().setVisible(true);
            dispose();
        });


        panel.add(scroll, BorderLayout.CENTER);
        panel.add(btnVolver, BorderLayout.SOUTH);

        add(panel);
    }
}

