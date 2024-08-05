package hospital.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Date;


public class NEW_PATIENT extends JFrame implements ActionListener{

    JComboBox<String> comboBox;

    JTextField textFieldNumber, textFieldName, textFieldDisease, textFieldDeposit;

    JRadioButton r1,r2;

    Choice c1;

    JLabel date;

    JButton b1,b2;


    NEW_PATIENT(){

        JPanel panel= new JPanel();
        panel.setBounds(0,0,850,550);
        panel.setBackground(new Color(25,25,50));
        panel.setLayout(null);
        add(panel);

        ImageIcon ImageIcon= new ImageIcon(ClassLoader.getSystemResource("icon/patient.png"));
        Image image = ImageIcon.getImage().getScaledInstance(300,300,Image.SCALE_DEFAULT);
        ImageIcon imageIcon1 = new ImageIcon(image);
        JLabel label = new JLabel(imageIcon1);
        label.setBounds(550,290,270,270);
        panel.add(label);

        JLabel labelName = new JLabel("NEW PATIENT FORM");
        labelName.setBounds(118,11,260,53);
        labelName.setFont(new Font("Georgia", Font.BOLD, 21));
        labelName.setForeground(new Color(255,156,89));
        panel.add(labelName);

        //id
        JLabel labelID = new JLabel("ID: ");
        labelID.setBounds(35,76,200,18);
        labelID.setFont(new Font("Georgia", Font.BOLD, 16));
        labelID.setForeground(new Color(255,164,114));
        panel.add(labelID);

        comboBox = new JComboBox<>(new String[] {"Aadhaar Card", "Voter ID", "Driving License","Pan Card"});
        comboBox.setBounds(271,76,150,21);
        comboBox.setBackground(new Color(255,201,157));
        comboBox.setForeground(new Color(182,82,0));
        comboBox.setFont(new Font("Georgia", Font.ITALIC, 14));
        panel.add(comboBox);

        //number
        JLabel labelNumber = new JLabel("Number: ");
        labelNumber.setBounds(35,111,200,18);
        labelNumber.setFont(new Font("Georgia", Font.BOLD, 16));
        labelNumber.setForeground(new Color(255,164,114));
        panel.add(labelNumber);

        textFieldNumber = new JTextField();
        textFieldNumber.setBounds(271,111,150,20);
        panel.add(textFieldNumber);

        //name
        JLabel labelName1 = new JLabel("Name: ");
        labelName1.setBounds(35,151,200,18);
        labelName1.setFont(new Font("Georgia", Font.BOLD, 16));
        labelName1.setForeground(new Color(255,164,114));
        panel.add(labelName1);

        textFieldName = new JTextField();
        textFieldName.setBounds(271,151,150,20);
        panel.add(textFieldName);

        //gender
        JLabel labelGender = new JLabel("Sex: ");
        labelGender.setBounds(35,191,200,18);
        labelGender.setFont(new Font("Georgia", Font.BOLD, 16));
        labelGender.setForeground(new Color(255,164,114));
        panel.add(labelGender);

        r1 = new JRadioButton("Male");
        r1.setFont(new Font("Georgia", Font.ITALIC, 12));
        r1.setForeground(new Color(255,164,114));
        r1.setBounds(271,192,80,15);
        panel.add(r1);

        r2 = new JRadioButton("Female");
        r2.setFont(new Font("Georgia", Font.ITALIC, 12));
        r2.setForeground(new Color(255,164,114));
        r2.setBounds(350,192,100,15);
        panel.add(r2);

        //disease name
        JLabel labelDisease = new JLabel("Ailment: ");
        labelDisease.setBounds(35,231,200,18);
        labelDisease.setFont(new Font("Georgia", Font.BOLD, 16));
        labelDisease.setForeground(new Color(255,164,114));
        panel.add(labelDisease);

        textFieldDisease = new JTextField();
        textFieldDisease.setBounds(271,231,150,20);
        panel.add(textFieldDisease);

        JLabel labelTime = new JLabel("Time: ");
        labelTime.setBounds(35,274,200,18);
        labelTime.setFont(new Font("Georgia", Font.BOLD, 16));
        labelTime.setForeground(new Color(255,164,114));
        panel.add(labelTime);

        //add date exact of today
        Date date1= new Date();
        date= new JLabel(""+date1);
        date.setBounds(271,274,300,14);
        date.setForeground(new Color(255,164,114));
        date.setFont(new Font("Georgia", Font.BOLD, 14));
        panel.add(date);

        //room
        JLabel labelRoom = new JLabel("Room Number: ");
        labelRoom.setBounds(35,316,200,18);
        labelRoom.setFont(new Font("Georgia", Font.BOLD, 16));
        labelRoom.setForeground(new Color(255,164,114));
        panel.add(labelRoom);

        //room dropdown box from database:
        c1 = new Choice();
        try{
            conn c = new conn();
            ResultSet resultSet = c.statement.executeQuery("select * from Room");
            while(resultSet.next()){
                c1.add(resultSet.getString("room_no"));
            }

        }catch(Exception e1){
            e1.printStackTrace();
        }

        c1.setBounds(271,316,150,20);
        c1.setFont(new Font("Georgia", Font.BOLD, 16));
        c1.setBackground(new Color(255,201,157));
        c1.setForeground(new Color(182,82,0));
        panel.add(c1);



        //deposit
        JLabel labelDeposit = new JLabel("Deposit: ");
        labelDeposit.setBounds(35,359,200,18);
        labelDeposit.setFont(new Font("Georgia", Font.BOLD, 16));
        labelDeposit.setForeground(new Color(255,164,114));
        panel.add(labelDeposit);

        textFieldDeposit = new JTextField();
        textFieldDeposit.setBounds(271,359,150,20);
        panel.add(textFieldDeposit);

        b1 = new JButton("REGISTER");
        b1.setBounds(100,430,120,35);
        b1.setForeground(new Color(255,88,15));
        b1.setFont(new Font("Georgia", Font.BOLD, 16));
        b1.addActionListener(this);
        panel.add(b1);

        b2 = new JButton("BACK");
        b2.setBounds(260,430,120,35);
        b2.setForeground(new Color(255,88,15));
        b2.setFont(new Font("Georgia", Font.BOLD, 16));
        b2.addActionListener(this);
        panel.add(b2);

        setSize(850,550);
        setLayout(null);
        setUndecorated(true);
        setLocation(350,260);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==b1){
            conn C =new conn();
            String radioBTN=null;
            if(r1.isSelected()){
                radioBTN = "Male";
            }
            else if(r2.isSelected()){
                radioBTN ="Female";
            }
            String s1 = (String)comboBox.getSelectedItem();
            String s2 = textFieldNumber.getText();
            String s3 = textFieldName.getText();
            String s4 = radioBTN;
            String s5 = textFieldDisease.getText();
            String s6 = date.getText();
            String s7 = c1.getSelectedItem();
            String s8 = textFieldDeposit.getText();

            try{
                //String q= "INSERT INTO patient_info (ID, Number, Name, Gender, Patient_Disease, room_no, admitted_date, deposit) VALUES (?, ?, ?, ?, ?, ?, ?, ?)\";";
                String q ="Insert Into patient_info values('"+s1+"','"+s2+"','"+s3+"','"+s4+"','"+s5+"','"+s6+"','"+s7+"','"+s8+"')";
                String q1 ="Update room set Availability = 'Occupied' where room_no = " +s7;
                C.statement.executeUpdate(q);
                C.statement.executeUpdate(q1);
                JOptionPane.showMessageDialog(null, "Added Successfully");
                setVisible(false);

            }catch(Exception E){
            E.printStackTrace();
            }

        }
        else{
            setVisible(false);
        }
    }

    public static void main(String[] args)
    { new NEW_PATIENT(); }
}
