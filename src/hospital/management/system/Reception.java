package hospital.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Reception extends JFrame{

    Reception(){

        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBounds(5,210,1940,1080);
        panel.setBackground(new Color(25,25,50));
        add(panel);

        JPanel panel1 = new JPanel();
        panel1.setLayout(null);
        panel1.setBounds(5,5,1525,200);
        panel1.setBackground(new Color(255,185,233));
        add(panel1);

        //add image icons in panel1
        ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("icon/dr.png"));
        Image image = i1.getImage().getScaledInstance(250,300,Image.SCALE_SMOOTH);
        ImageIcon i2 = new ImageIcon(image);
        JLabel label= new JLabel(i2);
        label.setBounds(1200,0,250,250);
        panel1.add(label);


        ImageIcon i11= new ImageIcon(ClassLoader.getSystemResource("icon/well.png"));
        Image image1 = i11.getImage().getScaledInstance(260,230,Image.SCALE_DEFAULT);
        ImageIcon i22 = new ImageIcon(image1);
        JLabel label1= new JLabel(i22);
        label1.setBounds(30,11,300,200);
        panel1.add(label1);


        //add buttons:
        JButton btn1 = new JButton("Add New Patient");
        btn1.setBounds(350,30,200,30);
        btn1.setBackground(new Color(246, 215,118));
        panel1.add(btn1);
        btn1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new NEW_PATIENT();

            }
        });

        JButton btn2 = new JButton("Room");
        btn2.setBounds(350,65,200,30);
        btn2.setBackground(Color.YELLOW);
        panel1.add(btn2);
        btn2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Room();

            }
        });

        JButton btn3 = new JButton("Department");
        btn3.setBounds(350,100,200,30);
        btn3.setBackground(Color.YELLOW);
        panel1.add(btn3);
        btn3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Department();
            }
        });

        JButton btn4 = new JButton("Employee Information");
        btn4.setBounds(580,30,200,30);
        btn4.setBackground(Color.YELLOW);
        panel1.add(btn4);
        btn4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
              new Employee_info();

            }
        });

        JButton btn5 = new JButton("Patient Information");
        btn5.setBounds(580,65,200,30);
        btn5.setBackground(Color.YELLOW);
        panel1.add(btn5);
        btn5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               new All_Patient_info();

            }
        });

        JButton btn6 = new JButton("Patient Discharge");
        btn6.setBounds(580,100,200,30);
        btn6.setBackground(Color.YELLOW);
        panel1.add(btn6);
        btn6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new patient_discharge();
            }
        });

        JButton btn7 = new JButton("Update Patient Details");
        btn7.setBounds(810,30,200,30);
        btn7.setBackground(Color.YELLOW);
        panel1.add(btn7);
        btn7.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new update_patient_details();

            }
        });

        JButton btn8 = new JButton("Hospital Ambulance");
        btn8.setBounds(810,65,200,30);
        btn8.setBackground(Color.YELLOW);
        panel1.add(btn8);
        btn8.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Ambulance();

            }
        });

        JButton btn9 = new JButton("Search Room");
        btn9.setBounds(810,100,200,30);
        btn9.setBackground(new Color(246,215,118));
        panel1.add(btn9);
        btn9.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new SearchRoom();

            }
        });

        JButton btn10 = new JButton("LOGOUT");
        btn10.setBounds(1040,65,150,60);
        btn10.setBackground(new Color(246,215,118));
        btn10.setForeground(Color.red);
        btn10.setFont(new Font("Times New Roman", Font.BOLD, 18));
        panel1.add(btn10);
        btn10.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                new Login();
            }
        });

        //overall layout at end of the object created
        setSize(1950,1090);
        setUndecorated(true);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        setVisible(true);

    }


    public static void main(String[] args){
        new Reception();
    }
}
