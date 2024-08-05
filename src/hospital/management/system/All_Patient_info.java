package hospital.management.system;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class All_Patient_info extends JFrame{
    All_Patient_info(){

        JPanel panel = new JPanel();
        panel.setBounds(0,0,1000,600);
        panel.setBackground(new Color(25,25,50));
        panel.setLayout(null);
        add(panel);

        JTable table = new JTable();
        table.setBounds(10,40,900,450);
        table.setBackground(new Color(25,25,50));
        table.setBorder(new LineBorder(Color.WHITE, 2));
        table.setRowHeight(35);
        table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        table.setForeground(Color.WHITE);
        table.setFont(new Font("Arial", Font.ITALIC, 14));
        panel.add(table);

        try{
            conn c= new conn();
            String q= "select * from patient_info";
            ResultSet resultSet = c.statement.executeQuery(q);
            table.setModel(DbUtils.resultSetToTableModel(resultSet));
        }catch(Exception e){
            e.printStackTrace();
        }

        JLabel label1 = new JLabel("ID TYPE");
        label1.setBounds(35,14,105,18);
        label1.setFont(new Font("Times New ROman", Font.BOLD,16));
        label1.setForeground(Color.WHITE);
        panel.add(label1);

        JLabel label2 = new JLabel("ID");
        label2.setBounds(165,14,200,18);
        label2.setForeground(Color.WHITE);
        label2.setFont(new Font("Times New ROman", Font.BOLD,16));
        panel.add(label2);

        JLabel label3 = new JLabel("NAME");
        label3.setBounds(267,14,105,18);
        label3.setFont(new Font("Times New ROman", Font.BOLD,16));
        label3.setForeground(Color.WHITE);
        panel.add(label3);


        JLabel label4 = new JLabel("SEX");
        label4.setBounds(357,14,200,18);
        label4.setForeground(Color.WHITE);
        label4.setFont(new Font("Times New ROman", Font.BOLD,16));
        panel.add(label4);

        JLabel label5 = new JLabel("AILMENT");
        label5.setBounds(475,14,105,18);
        label5.setFont(new Font("Times New ROman", Font.BOLD,16));
        label5.setForeground(Color.WHITE);
        panel.add(label5);


        JLabel label6 = new JLabel("TIME");
        label6.setBounds(600,14,200,18);
        label6.setForeground(Color.WHITE);
        label6.setFont(new Font("Times New ROman", Font.BOLD,16));
        panel.add(label6);

        JLabel label7 = new JLabel("ROOM NO.");
        label7.setBounds(700,14,105,18);
        label7.setFont(new Font("Times New ROman", Font.BOLD,16));
        label7.setForeground(Color.WHITE);
        panel.add(label7);


        JLabel label8 = new JLabel("EXPENSE");
        label8.setBounds(805,14,200,18);
        label8.setForeground(Color.WHITE);
        label8.setFont(new Font("Times New ROman", Font.BOLD,16));
        panel.add(label8);

        JButton b1 = new JButton("BACK");
        b1.setBounds(805,500,100,30);
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

    public static void main(String[] args){
        new All_Patient_info();
    }
}
