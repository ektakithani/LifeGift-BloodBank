import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

class ViewParticularDonorsTransactions extends JFrame

{
JLabel lbdid;
JTextField txtdid;
JButton btnview;

Container c8;
ViewParticularDonorsTransactions()

{
c8=getContentPane();
getContentPane().setBackground(Color.WHITE);

JOptionPane.showMessageDialog(c8,"Welcome to Blood Bank System.!");

setLocation(300,150);
setSize(300,200);
c8.setLayout(new FlowLayout(FlowLayout.LEFT));
setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
setTitle("Check Blood");



lbdid=new JLabel("Donor's Id    :");
txtdid=new JTextField(20);


btnview=new JButton("View Transactions");

c8.add(lbdid);
c8.add(txtdid);
c8.add(btnview);

ActionListener ac = (ae)->{
int id = Integer.parseInt(txtdid.getText());

String s = new DbHandlerBDM().viewParticularDonorsTransactions(id);
ViewPDT dt = new ViewPDT();
dt.view(s);

};
btnview.addActionListener(ac);




setVisible(true);



}

}
