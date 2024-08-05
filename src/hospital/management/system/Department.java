package hospital.management.system;

import net.proteanit.sql.DbUtils;
import javax.swing.*;
import java.awt.*;
import javax.swing.border.LineBorder;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Department extends JFrame {


    Department(){


        JPanel panel = new JPanel();
        panel.setBounds(2,2,1000,600);
        panel.setBackground(new Color(25,25,50));
        panel.setLayout(null);
        add(panel);

        ImageIcon ImageIcon= new ImageIcon(ClassLoader.getSystemResource("icon/dept.png"));
        Image image = ImageIcon.getImage().getScaledInstance(340,600,Image.SCALE_DEFAULT);
        ImageIcon imageIcon1 = new ImageIcon(image);
        JLabel label = new JLabel(imageIcon1);
        label.setBounds(650,0,400,605);
        panel.add(label);

        JTable table = new JTable();
        table.setBounds(20,34,650,200);
        table.setBackground(new Color(25,25,50));
        table.setBorder(new LineBorder(Color.WHITE, 3));
        table.setRowHeight(50);
        table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        table.setForeground(Color.WHITE);
        table.setFont(new Font("Arial", Font.ITALIC, 14));
        panel.add(table);


        try{
            conn c = new conn();
            String q = "select * from department";
            ResultSet resultSet = c.statement.executeQuery(q);
            table.setModel(DbUtils.resultSetToTableModel(resultSet));

        }
        catch(Exception e){
            e.printStackTrace();
        }

        JLabel label1 = new JLabel("Department");
        label1.setBounds(80,5,105,20);
        label1.setFont(new Font("Times New ROman", Font.BOLD,19));
        label1.setForeground(Color.WHITE);
        panel.add(label1);


        JLabel label2 = new JLabel("Phone Number");
        label2.setBounds(400,5,200,20);
        label2.setForeground(Color.WHITE);
        label2.setFont(new Font("Times New ROman", Font.BOLD,19));
        panel.add(label2);




        JButton b1 = new JButton("BACK");
        b1.setBounds(50,300,100,20);
        b1.setForeground(new Color(255,88,15));
        b1.setFont(new Font("Georgia", Font.BOLD, 16));
        panel.add(b1);
        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });

        setUndecorated(true);
        setSize(1000,600);
        setLocation(350,260);
        setVisible(true);

    }

    public static void main(String[] args){
        new Department();
    }
}

