package UI.Tiquetes;

import javax.swing.*;
import java.awt.*;
import BL.GestionarTiquetes;

public class VentanaCrearServicio extends JFrame{

    public VentanaCrearServicio(){
        setTitle("Crear Tiquete de Servicio");
        setSize(400, 450);
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
        JLabel lblSubtitulo=new JLabel("Crear Tiquete de Servicio",SwingConstants.CENTER);
        lblSubtitulo.setFont(new Font("Arial",Font.PLAIN,18));
        lblSubtitulo.setAlignmentX(Component.CENTER_ALIGNMENT);

        //Campos
        JTextField txtCodigo=new JTextField();
        JTextField txtDescripcion=new JTextField();
        JTextField txtEstado=new JTextField();
        JTextField txtUsuarioCreador=new JTextField();
        JTextField txtTecnicoAsignado=new JTextField();
        JTextField txtJustificacion=new JTextField();
        JTextField txtPrioridad=new JTextField();

        //Botón
        JButton btnCrear=new JButton("Crear");

        //Agregar componentes
        panel.add(lblTitulo);
        panel.add(Box.createVerticalStrut(10));
        panel.add(lblSubtitulo);
        panel.add(Box.createVerticalStrut(20));
        panel.add(new JLabel("Código:"));
        panel.add(txtCodigo);
        panel.add(new JLabel("Descripción:"));
        panel.add(txtDescripcion);
        panel.add(new JLabel("Estado:"));
        panel.add(txtEstado);
        panel.add(new JLabel("Usuario Creador (ID):"));
        panel.add(txtUsuarioCreador);
        panel.add(new JLabel("Técnico Asignado (ID):"));
        panel.add(txtTecnicoAsignado);
        panel.add(new JLabel("Justificación del servicio:"));
        panel.add(txtJustificacion);
        panel.add(new JLabel("Prioridad:"));
        panel.add(txtPrioridad);
        panel.add(Box.createVerticalStrut(15));
        panel.add(btnCrear);

        //Acción del botón
        btnCrear.addActionListener(e->{
            try{
                int codigo=Integer.parseInt(txtCodigo.getText());
                int usuario=Integer.parseInt(txtUsuarioCreador.getText());
                int tecnico=Integer.parseInt(txtTecnicoAsignado.getText());
                int prioridad=Integer.parseInt(txtPrioridad.getText());
                String descripcion=txtDescripcion.getText();
                String estado=txtEstado.getText();
                String justificacion=txtJustificacion.getText();

                GestionarTiquetes.crearTiqueteServicio(codigo,descripcion,estado,usuario,tecnico,justificacion,prioridad);
                JOptionPane.showMessageDialog(this,"Tiquete creado con éxito");
                dispose();
            }catch(Exception ex){
                JOptionPane.showMessageDialog(this,"Error en los datos ingresados");
            }
        });


        add(panel);
    }
}
