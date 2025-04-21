package UI.Usuarios;

import BL.GestionarUsuarios;
import BL.Usuarios;

import javax.swing.*;
import java.awt.*;

public class VentanaRegistrarUsuario extends JFrame{

    public VentanaRegistrarUsuario(){
        setTitle("Registrar Usuario");
        setSize(400, 450);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel=new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 40, 20, 40));

        JTextField txtCodigo=new JTextField();
        JTextField txtNombre=new JTextField();
        JTextField txtApellido1=new JTextField();
        JTextField txtApellido2=new JTextField();
        JTextField txtCorreo=new JTextField();
        JTextField txtTelefono=new JTextField();
        JPasswordField txtPassword=new JPasswordField();

        String[] tipos={"Administrador","Creador","Técnico"};
        JComboBox<String> cbTipo=new JComboBox<>(tipos);

        txtCodigo.setMaximumSize(new Dimension(Integer.MAX_VALUE,30));
        txtNombre.setMaximumSize(new Dimension(Integer.MAX_VALUE,30));
        txtApellido1.setMaximumSize(new Dimension(Integer.MAX_VALUE,30));
        txtApellido2.setMaximumSize(new Dimension(Integer.MAX_VALUE,30));
        txtCorreo.setMaximumSize(new Dimension(Integer.MAX_VALUE,30));
        txtTelefono.setMaximumSize(new Dimension(Integer.MAX_VALUE,30));
        txtPassword.setMaximumSize(new Dimension(Integer.MAX_VALUE,30));
        cbTipo.setMaximumSize(new Dimension(Integer.MAX_VALUE,30));

        JButton btnRegistrar=new JButton("Registrar");
        btnRegistrar.setAlignmentX(Component.CENTER_ALIGNMENT);

        JButton btnVolver=new JButton("Volver");
        btnVolver.setAlignmentX(Component.CENTER_ALIGNMENT);

        btnRegistrar.addActionListener(e->{
            try{
                int codigo=Integer.parseInt(txtCodigo.getText());
                String nombre=txtNombre.getText();
                String apellido1=txtApellido1.getText();
                String apellido2=txtApellido2.getText();
                String correo=txtCorreo.getText();
                String telefono=txtTelefono.getText();
                String password=new String(txtPassword.getPassword());
                String tipo=(String)cbTipo.getSelectedItem();

                Usuarios nuevoUsuario=new Usuarios(codigo,nombre,apellido1,apellido2,correo,telefono,password,tipo);
                GestionarUsuarios.getUsuarios().add(nuevoUsuario);

                JOptionPane.showMessageDialog(this,"Usuario registrado con éxito.");
                dispose();
            }catch(Exception ex){
                JOptionPane.showMessageDialog(this,"Datos inválidos.");
            }
        });

        btnVolver.addActionListener(e->{
            new VentanaUsuarios().setVisible(true);
            dispose();
        });

        panel.add(new JLabel("Código:"));panel.add(txtCodigo);
        panel.add(new JLabel("Nombre:"));panel.add(txtNombre);
        panel.add(new JLabel("Primer Apellido:"));panel.add(txtApellido1);
        panel.add(new JLabel("Segundo Apellido:"));panel.add(txtApellido2);
        panel.add(new JLabel("Correo Electrónico:"));panel.add(txtCorreo);
        panel.add(new JLabel("Teléfono:"));panel.add(txtTelefono);
        panel.add(new JLabel("Contraseña:"));panel.add(txtPassword);
        panel.add(new JLabel("Tipo de Usuario:"));panel.add(cbTipo);
        panel.add(Box.createVerticalStrut(20));
        panel.add(btnRegistrar);
        panel.add(Box.createVerticalStrut(10));
        panel.add(btnVolver);

        add(panel);
    }
}



