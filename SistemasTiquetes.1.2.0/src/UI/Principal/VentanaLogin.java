package UI;

import BL.GestionarUsuarios;
import BL.Usuarios;
import UI.Principal.VentanaPrincipal;
import UI.Tiquetes.VentanaTiquetes;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class VentanaLogin extends JFrame{

    public VentanaLogin(){
        setTitle("Login");
        setSize(400,300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel=new JPanel();
        panel.setLayout(new BoxLayout(panel,BoxLayout.Y_AXIS));
        panel.setBorder(BorderFactory.createEmptyBorder(20,40,20,40));

        JTextField txtUsuario=new JTextField();
        JPasswordField txtPassword=new JPasswordField();

        txtUsuario.setMaximumSize(new Dimension(Integer.MAX_VALUE,30));
        txtPassword.setMaximumSize(new Dimension(Integer.MAX_VALUE,30));

        JButton btnLogin=new JButton();
        btnLogin.setText("Iniciar Sesión");
        btnLogin.setAlignmentX(Component.CENTER_ALIGNMENT);

        //Acción al presionar "Iniciar Sesión"
        btnLogin.addActionListener(e->{
            String correoIngresado=txtUsuario.getText();
            String passwordIngresada=new String(txtPassword.getPassword());

            List<Usuarios> listaUsuarios=GestionarUsuarios.getUsuarios();
            for(Usuarios u:listaUsuarios){
                if(u.getCorreoElectronico().equals(correoIngresado)&&u.getPassword().equals(passwordIngresada)){
                    JOptionPane.showMessageDialog(this,"Bienvenido "+u.getNombre());
                    switch(u.getTipo()){
                        case "Administrador":
                            new VentanaPrincipal().setVisible(true);
                            break;
                        case "Creador":
                            new VentanaTiquetes().setVisible(true);
                            break;
                        case "Técnico":
                            new VentanaTiquetes().setVisible(true);
                            break;
                    }
                    dispose();
                    return;
                }
            }

            JOptionPane.showMessageDialog(this,"Credenciales inválidas");
        });

        panel.add(new JLabel("Correo electrónico:"));
        panel.add(txtUsuario);
        panel.add(Box.createVerticalStrut(10));
        panel.add(new JLabel("Contraseña:"));
        panel.add(txtPassword);
        panel.add(Box.createVerticalStrut(20));
        panel.add(btnLogin);

        add(panel);
    }
}
