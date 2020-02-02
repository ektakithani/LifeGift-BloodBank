import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

class ViewPDT extends JFrame{

JTextArea taData ;
JButton btnBack;
Container c1;
ViewPDT(){
c1=getContentPane();

getContentPane().setBackground(Color.WHITE);

c1.setLayout(new FlowLayout(FlowLayout.LEFT));
setSize(800,400);
taData=new JTextArea(15,30);
setTitle("Donor's Details");
setLocation(300,180);
btnBack = new JButton("Back");
btnBack.setBackground(Color.RED);
taData.setBackground(Color.WHITE);
c1.add(taData);
c1.add(btnBack);


//String DonorsDetails = new DbHandlerBDM().viewDonors();
//taData.setText(DonorsDetails);

ActionListener an = (ae)->{
dispose();
};
btnBack.addActionListener(an);
setVisible(true);

}

public void view(String sa){
taData.setText(sa);
}

}