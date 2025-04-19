package UI.Tiquetes;

import javax.swing.*;
import java.awt.*;
import BL.GestionarTiquetes;

public class VentanaListarTiquetes extends JFrame{

    public VentanaListarTiquetes(){
        setTitle("Lista de Tiquetes");
        setSize(500, 500);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        //Panel principal
        JPanel panel=new JPanel();
        panel.setLayout(new BorderLayout());

        //Título
        JLabel lblTitulo=new JLabel("Sistema de Tiquetes - Lista de Tiquetes",SwingConstants.CENTER);
        lblTitulo.setFont(new Font("Arial",Font.BOLD,18));

        //Área de texto
        JTextArea txtArea=new JTextArea();
        txtArea.setEditable(false);
        txtArea.setFont(new Font("Monospaced",Font.PLAIN,14));
        txtArea.setText(GestionarTiquetes.listarTiquetesComoTexto());

        //Scroll
        JScrollPane scroll=new JScrollPane(txtArea);

        //Botón cerrar
        JButton btnCerrar=new JButton("Cerrar");
        btnCerrar.addActionListener(e->dispose());

        //Organizar
        panel.add(lblTitulo,BorderLayout.NORTH);
        panel.add(scroll,BorderLayout.CENTER);
        panel.add(btnCerrar,BorderLayout.SOUTH);

        add(panel);
    }
}
