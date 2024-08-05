package hospital.management.system;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Ambulance extends JFrame {

    Ambulance(){

        JPanel panel = new JPanel();
        panel.setBounds(0,0,1000,600);
        panel.setBackground(new Color(25,25,50));
        panel.setLayout(null);
        add(panel);

        JTable table = new JTable();
        table.setBounds(10,40,900,250);
        table.setBackground(new Color(25,25,50));
        table.setBorder(new LineBorder(Color.WHITE, 2));
        table.setRowHeight(35);
        table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        table.setForeground(Color.WHITE);
        table.setFont(new Font("Arial", Font.ITALIC, 14));
        panel.add(table);

        try{
            conn c= new conn();
            String q= "select * from Ambulance";
            ResultSet resultSet = c.statement.executeQuery(q);
            table.setModel(DbUtils.resultSetToTableModel(resultSet));
        }catch(Exception e){
            e.printStackTrace();
        }

        JLabel label1 = new JLabel("NAME");
        label1.setBounds(35,14,105,18);
        label1.setFont(new Font("Times New ROman", Font.BOLD,16));
        label1.setForeground(new Color(255,201,157));
        panel.add(label1);

        JLabel label2 = new JLabel("GENDER");
        label2.setBounds(235,14,200,18);
        label2.setForeground(new Color(255,201,157));
        label2.setFont(new Font("Times New ROman", Font.BOLD,16));
        panel.add(label2);

        JLabel label3 = new JLabel("CAR NAME");
        label3.setBounds(415,14,105,18);
        label3.setFont(new Font("Times New ROman", Font.BOLD,16));
        label3.setForeground(new Color(255,201,157));
        panel.add(label3);


        JLabel label4 = new JLabel("AVAILABILITY");
        label4.setBounds(585,14,200,18);
        label4.setForeground(new Color(255,201,157));
        label4.setFont(new Font("Times New ROman", Font.BOLD,16));
        panel.add(label4);

        JLabel label5 = new JLabel("LOCATION");
        label5.setBounds(790,14,105,18);
        label5.setFont(new Font("Times New ROman", Font.BOLD,16));
        label5.setForeground(new Color(255,201,157));
        panel.add(label5);




        JButton b1 = new JButton("BACK");
        b1.setBounds(805,300,100,30);
        b1.setForeground(new Color(255,88,15));
        b1.setFont(new Font("Georgia", Font.BOLD, 16));
        panel.add(b1);
        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });


        setSize(925,600);
        setUndecorated(true);
        setLocation(350,260);
        setLayout(null);
        setVisible(true);

    }
    public static void main(String[] args) {
        new Ambulance();
    }
}
