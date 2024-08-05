package hospital.management.system;
import net.proteanit.sql.DbUtils;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import javax.swing.border.LineBorder;

public class Room extends JFrame {


    Room(){

        JPanel panel = new JPanel();
        panel.setBounds(0,0,1050,900);
        panel.setBackground(new Color(25,25,50));
        panel.setLayout(null);
        add(panel);

        JTable table = new JTable();
        table.setBounds(10,34,600,500);
        table.setBackground(new Color(25,25,50));
        table.setBorder(new LineBorder(Color.WHITE, 2));
        table.setRowHeight(35);
        table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        table.setForeground(Color.WHITE);
        table.setFont(new Font("Arial", Font.ITALIC, 14));
        panel.add(table);



        try{
            conn c = new conn();
            String q = "select * from room";
            ResultSet resultSet = c.statement.executeQuery(q);
            table.setModel(DbUtils.resultSetToTableModel(resultSet));
        }
        catch(Exception e){
            e.printStackTrace();
        }

        ImageIcon imageIcon = new ImageIcon(ClassLoader.getSystemResource("icon/roomm.png"));
        Image image = imageIcon.getImage().getScaledInstance(240,240,Image.SCALE_DEFAULT);
        ImageIcon imageIcon1 = new ImageIcon(image);
        JLabel label = new JLabel(imageIcon1);
        label.setBounds(650,20,200,200);
        panel.add(label);



        JLabel label1 = new JLabel("ROOM NUMBER");
        label1.setBounds(15,12,200,15);
        label1.setFont(new Font("Times New Roman", Font.BOLD, 14));
        label1.setForeground(new Color(255,201,157));
        panel.add(label1);

        JLabel label2 = new JLabel("STATUS");
        label2.setBounds(200,12,200,15);
        label2.setFont(new Font("Times New Roman", Font.BOLD, 14));
        label2.setForeground(new Color(255,201,157));
        panel.add(label2);

        JLabel label3 = new JLabel("PRICE");
        label3.setBounds(350,12,200,15);
        label3.setFont(new Font("Times New Roman", Font.BOLD, 14));
        label3.setForeground(new Color(255,201,157));
        panel.add(label3);

        JLabel label4 = new JLabel("BED TYPE");
        label4.setBounds(510,12,200,15);
        label4.setFont(new Font("Times New Roman", Font.BOLD, 14));
        label4.setForeground(new Color(255,201,157));
        panel.add(label4);




        JButton b1 = new JButton("BACK");
        b1.setBounds(700,260,100,20);
        b1.setForeground(new Color(255,88,15));
        b1.setFont(new Font("Georgia", Font.BOLD, 16));
        panel.add(b1);
        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });





        setSize(900,600);
        setUndecorated(true);
        setLayout(null);
        setLocation(350,260);
        setVisible(true);

    }


    public static void main(String[] args){
        new Room();
    }
}
