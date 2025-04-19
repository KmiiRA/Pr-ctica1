package UI.Tiquetes;

import javax.swing.*;
import java.awt.*;
import BL.GestionarTiquetes;

public class VentanaModificarTiquete extends JFrame{

    public VentanaModificarTiquete(){
        setTitle("Modificar Estado del Tiquete");
        setSize(400, 250);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        //Panel principal
        JPanel panel=new JPanel();
        panel.setLayout(new BoxLayout(panel,BoxLayout.Y_AXIS));
        panel.setBorder(BorderFactory.createEmptyBorder(20,40,20,40));

        //Título
        JLabel lblTitulo=new JLabel("Sistema de Tiquetes",SwingConstants.CENTER);
        lblTitulo.setFont(new Font("Arial",Font.BOLD,22));
        lblTitulo.setAlignmentX(Component.CENTER_ALIGNMENT);

        //Subtítulo
        JLabel lblSubtitulo=new JLabel("Modificar Tiquete",SwingConstants.CENTER);
        lblSubtitulo.setFont(new Font("Arial",Font.PLAIN,18));
        lblSubtitulo.setAlignmentX(Component.CENTER_ALIGNMENT);

        //Campos
        JTextField txtCodigo=new JTextField();
        JTextField txtNuevoEstado=new JTextField();

        //Botón
        JButton btnModificar=new JButton("Modificar");

        //Agregar componentes
        panel.add(lblTitulo);
        panel.add(Box.createVerticalStrut(10));
        panel.add(lblSubtitulo);
        panel.add(Box.createVerticalStrut(20));
        panel.add(new JLabel("Código del Tiquete:"));
        panel.add(txtCodigo);
        panel.add(new JLabel("Nuevo Estado:"));
        panel.add(txtNuevoEstado);
        panel.add(Box.createVerticalStrut(15));
        panel.add(btnModificar);

        //Acción del botón
        btnModificar.addActionListener(e->{
            try{
                int codigo=Integer.parseInt(txtCodigo.getText());
                String nuevoEstado=txtNuevoEstado.getText();

                boolean modificado=GestionarTiquetes.modificarEstadoTiquete(codigo,nuevoEstado);
                if(modificado){
                    JOptionPane.showMessageDialog(this,"Tiquete actualizado");
                    dispose();
                }else{
                    JOptionPane.showMessageDialog(this,"Tiquete no encontrado");
                }
            }catch(Exception ex){
                JOptionPane.showMessageDialog(this,"Datos inválidos");
            }
        });

        add(panel);
    }
}
