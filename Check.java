import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

class Check extends JFrame

{
JLabel lbpid,lbamount;
JTextField txtpid,txtamount;
JButton btncheck;

Container c8;
Check()

{
c8=getContentPane();
getContentPane().setBackground(Color.WHITE);

JOptionPane.showMessageDialog(c8,"Welcome to Blood Bank System.!");

setLocation(300,150);
setSize(300,300);
c8.setLayout(new FlowLayout(FlowLayout.LEFT));
setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
setTitle("Check Blood");



lbpid=new JLabel("Patient's Id    :");
lbamount=new JLabel("Amount of Blood Required (in Litres)");
txtpid=new JTextField(20);
txtamount=new JTextField(20);


btncheck=new JButton("Check");

c8.add(lbpid);
c8.add(txtpid);
c8.add(lbamount);
c8.add(txtamount);

c8.add(btncheck);

ActionListener ac = (ae)->{
int id = Integer.parseInt(txtpid.getText());
int amount = Integer.parseInt(txtamount.getText());

boolean ans_check = new DbHandlerBDM().check(id,amount);
if(ans_check){
System.out.println("Available");


}
txtpid.setText("");
txtamount.setText("");
};
btncheck.addActionListener(ac);




setVisible(true);



}

}
