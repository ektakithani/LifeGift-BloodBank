import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

class AddPatient extends JFrame

{
JLabel lbfirstname,lblastname,lbcontact,lbaddress,lbgender,lbage,lbbloodgroup;
JTextField txtfirstname,txtlastname,txtcontact,txtaddress,txtage;
JRadioButton btnMale,btnFemale;
ButtonGroup bg;
JButton btnsubmit;


//dropdown
String[] BloodGroup= { "A+(A Positive Blood Group)","A-(A Negative Blood Group)","B+(B Positive Blood Group)","B-(B Negative Blood Group)","AB+(AB Positive Blood Group)","AB-(AB Negative Blood Group)","O+(O Positive Blood Group)","O-(O Negative Blood Group)" };
final JComboBox<String> q = new JComboBox<String>(BloodGroup);


Container c8;
AddPatient()

{
c8=getContentPane();
getContentPane().setBackground(Color.WHITE);

JOptionPane.showMessageDialog(c8,"Welcome to Blood Bank System.!");

setLocation(300,150);
setSize(400,500);
c8.setLayout(new FlowLayout(FlowLayout.LEFT));
setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
setTitle("Patient Registration");




lbfirstname=new JLabel("Firstname     :");
lblastname=new JLabel("Lastname :");
lbgender=new JLabel("Gender                                                            :");
lbage=new JLabel("Age :     ");
lbcontact=new JLabel("Contact No :");
lbaddress=new JLabel("Address :");
lbbloodgroup=new JLabel("Blood Group :                 ");
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
c8.add(lbbloodgroup);
c8.add(q);
c8.add(btnsubmit);
btnsubmit.addActionListener(new AfterAddPatient());

setVisible(true);

}
class AfterAddPatient implements ActionListener{//class action
String gender;
public void actionPerformed(ActionEvent ae){
System.out.println(txtfirstname.getText());
System.out.println(txtlastname.getText());
System.out.println(txtage.getText());
System.out.println(txtcontact.getText());
boolean r=true;
boolean ag = true;
boolean amt=true;
boolean all_fine=false;
if(txtfirstname.getText().equals("") || txtlastname.getText().equals("") || txtage.getText().equals("") || txtcontact.getText().equals("")){//null value if
JOptionPane.showMessageDialog(c8,"Fill all the mandatory details");
}
else{//else of null value 
	try{
	int contact = Integer.parseInt(txtcontact.getText());

	}
	catch(Exception e){
	r=false;
	}
	if(r){//contact ka if integer check
		if( (txtcontact.getText()).length() !=10){//length of contact check
			JOptionPane.showMessageDialog(c8,"Incorrect Contact Number");
			txtcontact.requestFocus();
			r=false;
			}//end of contact length if
		else{//else start of contact length
			System.out.println("true");
			r=true;
			System.out.println(r);
			}//else end of contact length 
		}//if end of contact integer
	else{
		JOptionPane.showMessageDialog(c8,"1 Incorrect Contact Number");
	}//else end of contact integer
	if(r){//agar contact sahi hai 
		try{
		int age=Integer.parseInt(txtage.getText());
		}
		catch(Exception e){
		ag=false;
		}
		if(ag){//age ka integer check
all_fine=true;
System.out.println("age int hai toh if");
System.out.println(ag);


			
		}//age ka integer ka if end
		else{
			JOptionPane.showMessageDialog(new JDialog(),"Invalid age,age should be between 18 and 65");
System.out.println("age ka not int ka else");

			}//else end of agar age integer nahi hai toh

		}
	else{JOptionPane.showMessageDialog(c8,"2 Incorrect Contact Number");
	}
}//after null check wala else end
System.out.println("saab ");
System.out.println(all_fine);

if(all_fine){
System.out.println("inside all fine true");

String fname=txtfirstname.getText();
String lname=txtlastname.getText();
int age=Integer.parseInt(txtage.getText());
long contact=Long.parseLong(txtcontact.getText());
String address=txtaddress.getText();
String bgroup=(String)q.getSelectedItem();
if(btnMale.isSelected()) 
        gender="Male";
else if(btnFemale.isSelected()) 
        gender="Female";
new DbHandlerBDM().addPatient(fname,lname,gender,age,contact,address,bgroup);


txtfirstname.setText("");
txtlastname.setText("");
txtage.setText("");
txtcontact.setText("");
txtaddress.setText("");
bg.clearSelection();

}
}
}}
