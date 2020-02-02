import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

class ViewPatients extends JFrame{
JTextArea taData ;
JButton btnBack;
Container c1;
ViewPatients(){
c1=getContentPane();

getContentPane().setBackground(Color.WHITE);

c1.setLayout(new FlowLayout(FlowLayout.LEFT));
setSize(800,400);
taData=new JTextArea(15,30);
setTitle("Patient's Details");
setLocation(300,180);
btnBack = new JButton("Back");
btnBack.setBackground(Color.RED);
taData.setBackground(Color.WHITE);
c1.add(taData);
c1.add(btnBack);
String PatientsDetails = new DbHandlerBDM().viewPatients();
taData.setText(PatientsDetails);

ActionListener an = (ae)->{
dispose();
};
btnBack.addActionListener(an);
setVisible(true);

}
}