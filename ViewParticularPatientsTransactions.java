import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

class ViewParticularPatientsTransactions extends JFrame

{
JLabel lbpid;
JTextField txtpid;
JButton btnview;

Container c8;
ViewParticularPatientsTransactions()

{
c8=getContentPane();
getContentPane().setBackground(Color.WHITE);

JOptionPane.showMessageDialog(c8,"Welcome to Blood Bank System.!");

setLocation(300,150);
setSize(300,200);
c8.setLayout(new FlowLayout(FlowLayout.LEFT));
setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
setTitle("Check Blood");



lbpid=new JLabel("Patient's Id    :");
txtpid=new JTextField(20);


btnview=new JButton("View Transactions");

c8.add(lbpid);
c8.add(txtpid);
c8.add(btnview);

ActionListener ac = (ae)->{
int id = Integer.parseInt(txtpid.getText());

String s = new DbHandlerBDM().viewParticularPatientsTransactions(id);

ViewPPT pt = new ViewPPT();
pt.view(s);

};
btnview.addActionListener(ac);




setVisible(true);




}}
