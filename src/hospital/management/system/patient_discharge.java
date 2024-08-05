package hospital.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import java.util.Date;

public class patient_discharge extends JFrame{

    patient_discharge(){

        JPanel panel = new JPanel();
        panel.setBounds(0,0,800,600);
        panel.setBackground(new Color(25,25,50));
        panel.setLayout(null);
        add(panel);

        ImageIcon imageIcon= new ImageIcon(ClassLoader.getSystemResource("icon/heart2.png"));
        Image pic = imageIcon.getImage().getScaledInstance(350,400,Image.SCALE_DEFAULT);
        ImageIcon IMAGE = new ImageIcon(pic);
        JLabel label9= new JLabel(IMAGE);
        label9.setBounds(5,300,350,400);
        panel.add(label9);

        JLabel labelName = new JLabel("CHECK-OUT");
        labelName.setBounds(230,11,260,53);
        labelName.setFont(new Font("Georgia", Font.BOLD, 24));
        labelName.setForeground(new Color(255,156,89));
        panel.add(labelName);

        JLabel label2 = new JLabel("Customer ID: ");
        label2.setBounds(35,100,200,18);
        label2.setFont(new Font("Georgia", Font.BOLD, 16));
        label2.setForeground(new Color(255,164,114));
        panel.add(label2);

        Choice choices = new Choice();
        choices.setBounds(255,100,150,20);
        choices.setFont(new Font("Georgia", Font.BOLD, 16));
        choices.setBackground(new Color(255,201,157));
        choices.setForeground(new Color(182,82,0));
        panel.add(choices);

        try{
            conn c= new conn();
            ResultSet resultSet= c.statement.executeQuery("select * from patient_info");
            while(resultSet.next()){
                choices.add(resultSet.getString("number"));

            }

        }catch(Exception e){
            e.printStackTrace();
        }

        JLabel label3 = new JLabel("Room Number: ");
        label3.setBounds(35,150,200,18);
        label3.setFont(new Font("Georgia", Font.BOLD, 16));
        label3.setForeground(new Color(255,164,114));
        panel.add(label3);

        JLabel RNo = new JLabel();
        RNo.setBounds(255,150,200,18);
        RNo.setFont(new Font("Georgia", Font.BOLD, 16));
        RNo.setForeground(new Color(255,164,114));
        panel.add(RNo);

        JLabel label4 = new JLabel("Check-in Time: ");
        label4.setBounds(35,200,200,18);
        label4.setFont(new Font("Georgia", Font.BOLD, 16));
        label4.setForeground(new Color(255,164,114));
        panel.add(label4);

        JLabel in = new JLabel();
        in.setBounds(255,200,300,18);
        in.setFont(new Font("Georgia", Font.BOLD, 16));
        in.setForeground(new Color(255,164,114));
        panel.add(in);

        JLabel label5 = new JLabel("Check-out Time: ");
        label5.setBounds(35,250,200,18);
        label5.setFont(new Font("Georgia", Font.BOLD, 16));
        label5.setForeground(new Color(255,164,114));
        panel.add(label5);


        Date date1= new Date();

        JLabel out = new JLabel(""+date1);
        out.setBounds(255,250,300,18);
        out.setForeground(new Color(255,164,114));
        out.setFont(new Font("Georgia", Font.BOLD, 16));
        panel.add(out);

        JButton discharge = new JButton("DISCHARGE");
        discharge.setBounds(30,350,150,40);
        discharge.setForeground(new Color(255,156,89));
        discharge.setFont(new Font("Georgia", Font.BOLD, 15));
        panel.add(discharge);
        discharge.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                conn c= new conn();
                try {
                    c.statement.executeUpdate("delete from patient_info where Number='"+choices.getSelectedItem()+"'");
                    c.statement.executeUpdate("update room set Availability = 'Available' where room_no= '"+RNo.getText()+"' ");
                    JOptionPane.showMessageDialog(null, "DISCHARGE COMPLETED");

                } catch (Exception E) {
                    E.printStackTrace();
                }
            }
        });

        JButton check = new JButton("CHECK");
        check.setBounds(200,350,150,40);
        check.setForeground(new Color(255,156,89));
        check.setFont(new Font("Georgia", Font.BOLD, 15));
        panel.add(check);

        check.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                conn c= new conn();
                try{
                    ResultSet result = c.statement.executeQuery("select * from patient_info where number = '"+choices.getSelectedItem()+"'");
                    while(result.next()){
                        RNo.setText(result.getString("room_no"));
                        in.setText(result.getString("Time"));
                    }

                }catch(Exception E){
                    E.printStackTrace();
                }
            }
        });

        JButton back = new JButton("BACK");
        back.setBounds(380,350,150,40);
        back.setForeground(new Color(255,156,89));
        back.setFont(new Font("Georgia", Font.BOLD, 15));
        panel.add(back);
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });


        setSize(800,600);
        setUndecorated(true);
        setLocation(350,260);
        setLayout(null);
        setVisible(true);

    }

    public static void main(String[] args) {
        new patient_discharge();
    }
}
