import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class Admin_Login extends JFrame{
Container c;
JButton blogin;
JLabel lbUserName,lbPassword;
JTextField txtUserName;
JPasswordField txtPassword;


Admin_Login(){
c=getContentPane();
//Color white = Color(255,255,255,0);
//int rgb = white.getRGB();


getContentPane().setBackground(Color.WHITE);
c.setLayout(new FlowLayout(FlowLayout.LEFT));
setTitle("Blood Bank System");
setSize(300,200);
setLocation(700,210);
setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);


lbUserName=new JLabel("   Username      :");
lbUserName.setBounds(100,100,30,20);
lbPassword=new JLabel("  Password     :");
//lbPassword.setBounds(100,200,30,20);
txtUserName=new JTextField(20);
txtPassword = new JPasswordField(20);
blogin=new JButton("Login");
blogin.setBackground(Color.RED);
c.add(lbUserName);
c.add(txtUserName);
c.add(lbPassword);
c.add(txtPassword);
c.add(blogin);
blogin.addActionListener(new Login());
setVisible(true);
}

class Login implements ActionListener{  // c

public void actionPerformed(ActionEvent ae){
String Username = txtUserName.getText();
String Password = txtPassword.getText();

if(Username.equals("Admin") && Password.equals("admin123") ){
JOptionPane.showMessageDialog(c,"Successful Login");
dispose();
JOptionPane.showMessageDialog(c,"Welcome to Blood Bank System.!");
AdminPage ap = new AdminPage();
}
else if((Username.equals("")) || (Password.equals(""))){
JOptionPane.showMessageDialog(c,"Please fill all the details");
}
else{
JOptionPane.showMessageDialog(c,"Incorrect Credentials");
}

txtUserName.setText("");
txtPassword.setText("");
txtUserName.requestFocus();

}
}



public static void main(String args[]){
Background b = new Background();
Admin_Login l = new Admin_Login();
}
}