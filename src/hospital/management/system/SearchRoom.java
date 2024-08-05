package hospital.management.system;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class SearchRoom extends JFrame {

    Choice choice;
    JTable table;
    SearchRoom(){

        JPanel panel = new JPanel();
        panel.setBounds(2,2,900,600);
        panel.setBackground(new Color(25,25,50));
        panel.setLayout(null);
        add(panel);

        JLabel label1 = new JLabel("SEARCH FOR ROOM");
        label1.setBounds(320,11,250,31);
        label1.setFont(new Font("Times New ROman", Font.BOLD,20));
        label1.setForeground(new Color(255,164,114));
        panel.add(label1);

        JLabel label2 = new JLabel("STATUS :");
        label2.setBounds(70,70,100,20);
        label2.setFont(new Font("Times New Roman", Font.BOLD, 14));
        label2.setForeground(new Color(255,164,114));
        panel.add(label2);

        choice = new Choice();
        choice.setBounds(170,70,120,20);
        choice.setBackground(new Color(255,164,114));
        choice.setForeground(new Color(182,82,0));
        choice.add("AVAILABLE");
        choice.add("OCCUPIED");
        panel.add(choice);

        table= new JTable();
        table.setBounds(100,160,700,300);
        table.setBackground(new Color(25,25,50));
        table.setBorder(new LineBorder(Color.WHITE, 3));
        table.setRowHeight(25);
        table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        table.setForeground(Color.WHITE);
        table.setFont(new Font("Arial", Font.ITALIC, 14));
        panel.add(table);

        try{
            conn c= new conn();
            String q= "select * from room ";
            ResultSet result = c.statement.executeQuery(q);
            table.setModel(DbUtils.resultSetToTableModel(result));

        }
        catch(Exception e){
            e.printStackTrace();
        }

        JLabel label5 = new JLabel("ROOM NUMBER");
        label5.setBounds(105,135,200,15);
        label5.setFont(new Font("Times New Roman", Font.BOLD, 14));
        label5.setForeground(new Color(255,201,157));
        panel.add(label5);

        JLabel label6 = new JLabel("STATUS");
        label6.setBounds(315,135,200,15);
        label6.setFont(new Font("Times New Roman", Font.BOLD, 14));
        label6.setForeground(new Color(255,201,157));
        panel.add(label6);

        JLabel label3 = new JLabel("PRICE");
        label3.setBounds(503,135,200,15);
        label3.setFont(new Font("Times New Roman", Font.BOLD, 14));
        label3.setForeground(new Color(255,201,157));
        panel.add(label3);

        JLabel label4 = new JLabel("BED TYPE");
        label4.setBounds(685,135,200,15);
        label4.setFont(new Font("Times New Roman", Font.BOLD, 14));
        label4.setForeground(new Color(255,201,157));
        panel.add(label4);

        JButton search = new JButton("SEARCH");
        search.setBounds(200,500,100,40);
        search.setForeground(new Color(182,82,0));
        search.setFont(new Font("Georgia", Font.BOLD, 16));
        panel.add(search);
        search.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String q = "select * from room where Availability = '"+choice.getSelectedItem()+"'";
                try{
                    conn c= new conn();
                    ResultSet resultSet= c.statement.executeQuery(q);
                    table.setModel(DbUtils.resultSetToTableModel(resultSet));




                }catch(Exception E){
                    E.printStackTrace();
                }
            }
        });

        JButton b1 = new JButton("BACK");
        b1.setBounds(350,500,100,40);
        b1.setForeground(new Color(182,82,0));
        b1.setFont(new Font("Georgia", Font.BOLD, 16));
        panel.add(b1);
        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });

















        setUndecorated(true);
        setSize(900,600);
        setLocation(350,260);
        setVisible(true);
    }


    public static void main(String[] args) {

        new SearchRoom();
    }
}
