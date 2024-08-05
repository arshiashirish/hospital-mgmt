package hospital.management.system;
import net.proteanit.sql.DbUtils;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Employee_info  extends JFrame{
    Employee_info(){

        JPanel panel = new JPanel();
        panel.setBounds(0,0,1000,600);
        panel.setBackground(new Color(25,25,50));
        panel.setLayout(null);
        add(panel);

        ImageIcon imageIcon = new ImageIcon(ClassLoader.getSystemResource("icon/empp.png"));
        Image image = imageIcon.getImage().getScaledInstance(300,300,Image.SCALE_DEFAULT);
        ImageIcon imageIcon1 = new ImageIcon(image);
        JLabel label = new JLabel(imageIcon1);
        label.setBounds(700,300,300,300);
        panel.add(label);

        JTable table = new JTable();
        table.setBounds(10,34,950,200);
        table.setBackground(new Color(25,25,50));

        table.setBorder(new LineBorder(Color.WHITE, 2));
        table.setRowHeight(50);
        table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        table.setForeground(Color.WHITE);
        table.setFont(new Font("Arial", Font.ITALIC, 14));

        panel.add(table);
        try{
            conn c= new conn();
            String q = "select * from EMP_INFO";
            ResultSet resultSet= c.statement.executeQuery(q);
            table.setModel(DbUtils.resultSetToTableModel(resultSet));


        }catch(Exception e ){
            e.printStackTrace();
        }

        JLabel label1 = new JLabel("NAME");
        label1.setBounds(41,5,105,20);
        label1.setFont(new Font("Times New ROman", Font.BOLD,16));
        label1.setForeground(Color.WHITE);
        panel.add(label1);


        JLabel label2 = new JLabel("AGE");
        label2.setBounds(185,5,200,20);
        label2.setForeground(Color.WHITE);
        label2.setFont(new Font("Times New ROman", Font.BOLD,16));
        panel.add(label2);

        JLabel label3 = new JLabel("PHONE NO.");
        label3.setBounds(345,5,105,20);
        label3.setFont(new Font("Times New ROman", Font.BOLD,16));
        label3.setForeground(Color.WHITE);
        panel.add(label3);


        JLabel label4 = new JLabel("SALARY");
        label4.setBounds(535,5,200,20);
        label4.setForeground(Color.WHITE);
        label4.setFont(new Font("Times New ROman", Font.BOLD,16));
        panel.add(label4);

        JLabel label5 = new JLabel("GMAIL ID");
        label5.setBounds(666,5,105,20);
        label5.setFont(new Font("Times New ROman", Font.BOLD,16));
        label5.setForeground(Color.WHITE);
        panel.add(label5);


        JLabel label6 = new JLabel("AADHAAR NO.");
        label6.setBounds(802,5,200,20);
        label6.setForeground(Color.WHITE);
        label6.setFont(new Font("Times New ROman", Font.BOLD,16));
        panel.add(label6);

        JButton b1 = new JButton("BACK");
        b1.setBounds(806,270,100,20);
        b1.setForeground(new Color(255,88,15));
        b1.setFont(new Font("Georgia", Font.BOLD, 16));
        panel.add(b1);
        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });


        setSize(1000,600);
        setUndecorated(true);
        setLocation(350,260);
        setLayout(null);
        setVisible(true);
    }



    public static void main(String[] args){
        new Employee_info();
    }
}
