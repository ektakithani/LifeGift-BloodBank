import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

class Exchange extends JFrame

{
JLabel lbfirstname,lblastname,lbcontact,lbaddress,lbgender,lbage,lbbloodgroupr,lbbloodgroupd,lbamount;
JTextField txtfirstname,txtlastname,txtcontact,txtaddress,txtage,txtamount;
JRadioButton btnMale,btnFemale;
ButtonGroup bg;
JButton btnsubmit;


//dropdown
String[] BloodGroupD= { "A+ (A Positive Blood Group)","A- (A  Negative Blood Group)","B+ (B Positive Blood Group)","B- (B Negative Blood Group)","AB+ (AB Positive Blood Group)","AB- (AB Negative Blood Group)","O+ (O Positive Blood Group)","O- (O Negative Blood Group)" };
final JComboBox<String> q = new JComboBox<String>(BloodGroupD);


String[] BloodGroupR= { "A+ (A Positive Blood Group)","A- (A  Negative Blood Group)","B+ (B Positive Blood Group)","B- (B Negative Blood Group)","AB+ (AB Positive Blood Group)","AB- (AB Negative Blood Group)","O+ (O Positive Blood Group)","O- (O Negative Blood Group)" };
final JComboBox<String> r = new JComboBox<String>(BloodGroupR);

Container c8;
Exchange()

{
c8=getContentPane();
getContentPane().setBackground(Color.WHITE);

JOptionPane.showMessageDialog(c8,"Welcome to Blood Bank System.!");

setLocation(300,150);
setSize(400,500);
c8.setLayout(new FlowLayout(FlowLayout.LEFT));
setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
setTitle("Exchange Blood");




lbfirstname=new JLabel("Firstname     :");
lblastname=new JLabel("Lastname :");
lbgender=new JLabel("Gender                                                            :");
lbage=new JLabel("Age :     ");
lbcontact=new JLabel("Contact No :");
lbaddress=new JLabel("Address :");
lbbloodgroupd=new JLabel("Blood Group Donating :  ");
lbbloodgroupr=new JLabel("Blood Group Required :   ");
lbamount=new JLabel("Amount Required(in Litres) :");
//JOptionPane.showMessageDialog(c8,"Welcome to Blood Bank System.!");



txtfirstname=new JTextField(30);
txtlastname=new JTextField(30);
btnMale = new JRadioButton("Male");
btnFemale = new JRadioButton("Female");
btnsubmit = new JButton("Submit");
bg = new ButtonGroup();
bg.add(btnMale);
bg.add(btnFemale);
txtage=new JTextField(30);
txtcontact=new JTextField(30);
txtaddress=new JTextField(30);
txtamount=new JTextField(30);
JOptionPane.showMessageDialog(c8,"Welcome to Blood Bank System.!");


c8.add(lbfirstname);
c8.add(txtfirstname);
c8.add(lblastname);
c8.add(txtlastname);
c8.add(lbgender);
c8.add(btnMale);
c8.add(btnFemale);
c8.add(lbage);

c8.add(txtage);
c8.add(lbcontact);
c8.add(txtcontact);
c8.add(lbaddress);
c8.add(txtaddress);
c8.add(lbbloodgroupd);
c8.add(q);
c8.add(lbbloodgroupr);
c8.add(r);
c8.add(lbamount);
c8.add(txtamount);
c8.add(btnsubmit);

setVisible(true);

}

class AfterAddDonor implements ActionListener{

public void actionPerformed(ActionEvent ae){
System.out.println(txtfirstname.getText());
boolean r=true;
boolean ag = true;
boolean amt=true;
if(txtfirstname.getText().equals("") || txtlastname.getText().equals("") || txtage.getText().equals("") || txtcontact.getText().equals("") || txtamount.getText().equals("")){
JOptionPane.showMessageDialog(c8,"Fill all the mandatory details");
}
else{
try{
int contact = Integer.parseInt(txtcontact.getText());
}
catch(Exception e){
r=false;
}
if(r){
if( (txtcontact.getText()).length() !=10){
JOptionPane.showMessageDialog(c8,"Incorrect Contact Number");
txtcontact.requestFocus();
r=false;
}
else{
System.out.println("true");
r=true;
System.out.println(r);
}}
else{ 
JOptionPane.showMessageDialog(c8,"Incorrect Contact Number");
}
if(r){
try{
int age=Integer.parseInt(txtage.getText());
}
catch(Exception e){
ag=false;
}
if(ag){
if(Integer.parseInt(txtage.getText())>18 && Integer.parseInt(txtage.getText())<65){
System.out.println("True");
}
else{
JOptionPane.showMessageDialog(new JDialog(),"Invalid age,age should be between 18 and 65");
txtage.requestFocus();
ag=false;
}
}
else{
JOptionPane.showMessageDialog(new JDialog(),"Invalid age,age should be between 18 and 65");}
}
if(ag){
try{
int amount=Integer.parseInt(txtamount.getText());
}
catch(Exception e){
amt=false;
}
if(! amt){
JOptionPane.showMessageDialog(new JDialog(),"Enter the amount in litres ");
}
}
}
}
}
}
