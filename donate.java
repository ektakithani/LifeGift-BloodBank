import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

class Donate extends JFrame

{
JLabel lbdid,lbamount;
JTextField txtdid,txtamount;
JButton btndonate;

Container c8;
Donate()

{
c8=getContentPane();
getContentPane().setBackground(Color.WHITE);

JOptionPane.showMessageDialog(c8,"Welcome to Blood Bank System.!");

setLocation(300,150);
setSize(300,300);
c8.setLayout(new FlowLayout(FlowLayout.LEFT));
setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
setTitle("Donate Blood");



lbdid=new JLabel("Donor's Id    :");
lbamount=new JLabel("Amount of Blood Donating (in Litres)");
txtdid=new JTextField(20);
txtamount=new JTextField(20);


btndonate=new JButton("Donate");

c8.add(lbdid);
c8.add(txtdid);
c8.add(lbamount);
c8.add(txtamount);
c8.add(btndonate);

ActionListener ado = (ae)->{
int id = Integer.parseInt(txtdid.getText());
int amount = Integer.parseInt(txtamount.getText());

boolean ans_donate = new DbHandlerBDM().donate(id,amount);
if(ans_donate){
System.out.println("Available");
}
txtdid.setText("");
txtamount.setText("");
};
btndonate.addActionListener(ado);


setVisible(true);



}

}
