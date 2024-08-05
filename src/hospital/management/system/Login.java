package hospital.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;


public class Login extends JFrame implements ActionListener {

    JTextField textField;
    JPasswordField jPasswordField;
    JButton b1,b2;

    Login(){

        JLabel namelabel = new JLabel("USERNAME");
        namelabel.setBounds(40,20,100,30);
        namelabel.setFont(new Font("Times New Roman", Font.BOLD, 16));
        namelabel.setForeground(Color.BLACK);
        add(namelabel);

        JLabel password = new JLabel("PASSWORD");
        password.setBounds(40,70,100,30);
        password.setFont(new Font("Times New Roman", Font.BOLD, 16));
        password.setForeground(Color.BLACK);
        add(password);

        textField = new JTextField();
        textField.setBounds(150,20,150,30);
        textField.setFont(new Font("Times New Roman", Font.PLAIN,15 ));
        textField.setBackground(new Color(255,179,0));
        add(textField);

        jPasswordField = new JPasswordField();
        jPasswordField.setBounds(150,70,150,30);
        jPasswordField.setFont(new Font("Times New Roman", Font.PLAIN,15 ));
        jPasswordField.setBackground(new Color(255,179,0));
        add(jPasswordField);

        ImageIcon imageIcon= new ImageIcon(ClassLoader.getSystemResource("icon/login.png"));
        Image i1 = imageIcon.getImage().getScaledInstance(275,275,Image.SCALE_DEFAULT);
        ImageIcon imageIcon1 = new ImageIcon(i1);
        JLabel label = new JLabel(imageIcon1);
        label.setBounds(300,-20,400,300);
        add(label);

        b1 = new JButton("LOGIN");
        b1.setBounds(40,140,120,30);
        b1.setFont(new Font("serif", Font.BOLD, 15));
        b1.setForeground(Color.red);
        b1.addActionListener(this);
        add(b1);

        b2 = new JButton("CANCEL");
        b2.setBounds(180,140,120,30);
        b2.setFont(new Font("serif", Font.BOLD, 15));
        b2.setForeground(Color.red);
        b2.addActionListener(this);
        add(b2);


       //setting the layout and frame
        getContentPane().setBackground(new Color(255,185,233));
        setSize(750,300);
        setLocation(400,270);
        setUndecorated(true);
        setLayout(null);
        setVisible(true);

    }

    public static void main(String[] args){
        new Login();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource() == b1){
        try{
            conn c = new conn();
            String user = textField.getText();
            String Pass= jPasswordField.getText();

            String q= "select * from login where ID='"+user+"' and PW = '"+Pass+"'";
            ResultSet resultSet = c.statement.executeQuery(q);

            if(resultSet.next()){
                new Reception();
                setVisible(false);
            }
            else{
                JOptionPane.showMessageDialog(null, "INVALID");
            }

        }catch(Exception E){
            E.printStackTrace();
        }
        }


        else{
            System.exit(40);
        }

    }
}
