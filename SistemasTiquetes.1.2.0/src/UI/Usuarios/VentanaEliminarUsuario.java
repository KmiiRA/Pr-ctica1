package UI.Usuarios;

import BL.GestionarUsuarios;
import javax.swing.*;
import java.awt.*;

public class VentanaEliminarUsuario extends JFrame{

    public VentanaEliminarUsuario(){
        setTitle("Eliminar Usuario");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        //Panel principal
        JPanel panel=new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 40, 20, 40));

        //Etiqueta y campo para ID
        JLabel lblId=new JLabel("Ingrese el ID del usuario a eliminar:");
        JTextField txtId=new JTextField();
        lblId.setAlignmentX(Component.CENTER_ALIGNMENT);
        txtId.setMaximumSize(new Dimension(Integer.MAX_VALUE, 30));

        //Botón eliminar
        JButton btnEliminar=new JButton("Eliminar");
        btnEliminar.setAlignmentX(Component.CENTER_ALIGNMENT);

        //Botón volver
        JButton btnVolver=new JButton("Volver");
        btnVolver.setAlignmentX(Component.CENTER_ALIGNMENT);

        //Eliminar usuario
        btnEliminar.addActionListener(e->{
            try{
                int id=Integer.parseInt(txtId.getText());
                GestionarUsuarios.eliminarUsuarioPorId(id);
                JOptionPane.showMessageDialog(this, "Usuario eliminado con éxito.");
                txtId.setText("");
            }catch(NumberFormatException ex){
                JOptionPane.showMessageDialog(this, "Ingrese un ID válido.");
            }
        });

        //Volver al menú de usuarios
        btnVolver.addActionListener(e->{
            new VentanaUsuarios().setVisible(true);
            dispose();
        });

        //Agregar componentes al panel
        panel.add(lblId);
        panel.add(Box.createVerticalStrut(10));
        panel.add(txtId);
        panel.add(Box.createVerticalStrut(20));
        panel.add(btnEliminar);
        panel.add(Box.createVerticalStrut(10));
        panel.add(btnVolver);

        add(panel);
    }
}
