package UI.Tiquetes;

import javax.swing.*;
import java.awt.*;
import BL.GestionarTiquetes;

public class VentanaEliminarTiquete extends JFrame{

    public VentanaEliminarTiquete(){
        setTitle("Eliminar Tiquete");
        setSize(350, 200);
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
        JLabel lblSubtitulo=new JLabel("Eliminar Tiquete",SwingConstants.CENTER);
        lblSubtitulo.setFont(new Font("Arial",Font.PLAIN,18));
        lblSubtitulo.setAlignmentX(Component.CENTER_ALIGNMENT);

        //Campo
        JTextField txtCodigo=new JTextField();

        //Botón
        JButton btnEliminar=new JButton("Eliminar");

        //Agregar componentes
        panel.add(lblTitulo);
        panel.add(Box.createVerticalStrut(10));
        panel.add(lblSubtitulo);
        panel.add(Box.createVerticalStrut(20));
        panel.add(new JLabel("Código del Tiquete:"));
        panel.add(txtCodigo);
        panel.add(Box.createVerticalStrut(15));
        panel.add(btnEliminar);

        //Acción del botón
        btnEliminar.addActionListener(e->{
            try{
                int codigo=Integer.parseInt(txtCodigo.getText());
                boolean resultado=GestionarTiquetes.eliminarTiquetePorCodigo(codigo);
                if(resultado){
                    JOptionPane.showMessageDialog(this,"Tiquete eliminado exitosamente");
                    dispose();
                }else{
                    JOptionPane.showMessageDialog(this,"No se encontró un tiquete con ese código");
                }
            }catch(Exception ex){
                JOptionPane.showMessageDialog(this,"Código inválido");
            }
        });

        add(panel);
    }
}
