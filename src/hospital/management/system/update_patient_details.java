package hospital.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class update_patient_details extends JFrame{

    update_patient_details()
    {
        JPanel panel = new JPanel();
        panel.setBounds(0,0,900,600);
        panel.setBackground(new Color(25,25,50));
        panel.setLayout(null);
        add(panel);

        ImageIcon imageIcon= new ImageIcon(ClassLoader.getSystemResource("icon/updated.png"));
        Image pic = imageIcon.getImage().getScaledInstance(250,250,Image.SCALE_DEFAULT);
        ImageIcon IMAGE = new ImageIcon(pic);
        JLabel label9= new JLabel(IMAGE);
        label9.setBounds(510,95,350,400);
        panel.add(label9);

        JLabel labelName = new JLabel("UPDATE PATIENT DETAILS");
        labelName.setBounds(150,11,400,53);
        labelName.setFont(new Font("Georgia", Font.BOLD, 24));
        labelName.setForeground(new Color(255,156,89));
        panel.add(labelName);

        JLabel label2 = new JLabel("NAME: ");
        label2.setBounds(35,100,200,18);
        label2.setFont(new Font("Georgia", Font.PLAIN, 16));
        label2.setForeground(new Color(255,164,114));
        panel.add(label2);

        Choice choice = new Choice();
        choice.setBounds(255,100,150,20);
        choice.setFont(new Font("Georgia", Font.BOLD, 16));
        choice.setBackground(new Color(255,201,157));
        choice.setForeground(new Color(182,82,0));
        panel.add(choice);

        try{
            conn c= new conn();
            ResultSet resultSet= c.statement.executeQuery("select * from patient_info");
            while(resultSet.next()){
                choice.add(resultSet.getString("Name"));

            }

        }catch(Exception e){
            e.printStackTrace();
        }

        JLabel label3 = new JLabel("Room Number: ");
        label3.setBounds(35,150,200,18);
        label3.setFont(new Font("Georgia", Font.BOLD, 16));
        label3.setForeground(new Color(255,164,114));
        panel.add(label3);
        JTextField textr = new JTextField();
        textr.setBounds(255,150,150,18);
        textr.setFont(new Font("Georgia", Font.BOLD, 14));
        textr.setForeground(new Color(182,82,0));
        panel.add(textr);

        JLabel label4 = new JLabel("In-Time: ");
        label4.setBounds(35,200,200,18);
        label4.setFont(new Font("Georgia", Font.BOLD, 16));
        label4.setForeground(new Color(255,164,114));
        panel.add(label4);
        JTextField text1 = new JTextField();
        text1.setBounds(255,200,150,18);
        text1.setFont(new Font("Georgia", Font.BOLD, 14));
        text1.setForeground(new Color(182,82,0));
        panel.add(text1);

        JLabel label5 = new JLabel("Amount Paid (Rs): ");
        label5.setBounds(35,250,200,18);
        label5.setFont(new Font("Georgia", Font.BOLD, 16));
        label5.setForeground(new Color(255,164,114));
        panel.add(label5);
        JTextField text2 = new JTextField();
        text2.setBounds(255,250,150,18);
        text2.setFont(new Font("Georgia", Font.BOLD, 14));
        text2.setForeground(new Color(182,82,0));
        panel.add(text2);


        JLabel label6 = new JLabel("Pending Amount (Rs): ");
        label6.setBounds(35,300,200,18);
        label6.setFont(new Font("Georgia", Font.BOLD, 16));
        label6.setForeground(new Color(255,164,114));
        panel.add(label6);
        JTextField text3 = new JTextField();
        text3.setBounds(255,300,150,18);
        text3.setFont(new Font("Georgia", Font.BOLD, 14));
        text3.setForeground(new Color(182,82,0));
        panel.add(text3);

        JButton check = new JButton("CHECK");
        check.setBounds(30,380,150,40);
        check.setForeground(new Color(182,82,0));
        check.setFont(new Font("Georgia", Font.BOLD, 17));
        Component add = panel.add(check);
        check.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String id = choice.getSelectedItem();
                String q = "select * from patient_info where Name ='"+id+"'";
                try{
                    conn c = new conn();
                    ResultSet result = c.statement.executeQuery(q);
                    while(result.next()){
                        textr.setText(result.getString("room_no"));
                        text1.setText(result.getString("Time"));
                        text2.setText(result.getString("Deposit"));
                    }

                    ResultSet result1 = c.statement.executeQuery("select * from room where room_no ='"+textr.getText()+"'");
                    while(result1.next()){
                        String price = result1.getString("Price");
                        int paid = Integer.parseInt(price) - Integer.parseInt(text2.getText());
                        text3.setText(""+paid);

                    }

                }catch(Exception E){
                    E.printStackTrace();
                }
            }
        });

        JButton update = new JButton("UPDATE");
        update.setBounds(200,380,150,40);
        update.setForeground(new Color(182,82,0));
        update.setFont(new Font("Georgia", Font.BOLD, 17));
        panel.add(update);
        update.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    conn c= new conn();
                    String q = choice.getSelectedItem();
                    String room = textr.getText();
                    String time = text1.getText();
                    String amount = text2.getText();
                    c.statement.executeUpdate("update patient_info set room_no = '"+room+"', Time = '"+time+"', Deposit = '"+amount+"' where name = '"+q+"'");
                    JOptionPane.showMessageDialog(null, "UPDATED SUCCESSFULLY");
                    setVisible(false);


                }
                catch(Exception E){
                    E.printStackTrace();
                }
            }
        });

        JButton back = new JButton("BACK");
        back.setBounds(380,380,150,40);
        back.setForeground(new Color(182,82,0));
        back.setFont(new Font("Georgia", Font.BOLD, 17));
        panel.add(back);
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });



        setSize(900,600);
        setUndecorated(true);
        setLocation(350,260);
        setLayout(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        new update_patient_details();
    }
}
