import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
class AdminPage extends JFrame

{


JMenu Home,Logout,View,Transactions;
JMenuBar bar;
JMenuItem home,logout,view_patients,view_donors,patients,donors,particular_patient_transactions,particular_donor_transactions;
JButton addDonor,addPatient,exchange,check,donate,available;
Container c2;
AdminPage()
{
c2=getContentPane();
getContentPane().setBackground(Color.WHITE);
setLocation(400,180);
setSize(500,400);
setTitle("Admin Page");
c2.setLayout(new FlowLayout(FlowLayout.LEFT));

setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
home=new JMenuItem("Home");
patients=new JMenuItem("Patients");
donors=new JMenuItem("Donors");

particular_patient_transactions =new JMenuItem("Check Patient's Transactions");
particular_donor_transactions=new JMenuItem("Check Donor's Transactions");

view_donors =new JMenuItem("View Donors");
view_patients =new JMenuItem("View Patients");

logout=new JMenuItem("Logout");

bar =new JMenuBar();
Home=new JMenu("Home");
View =new JMenu("View Registered Records");
Transactions =new JMenu("Transactions");
Logout =new JMenu("Logout");

Home.add(home);
View.add(view_patients);
View.add(view_donors);

Transactions.add(patients);
Transactions.add(donors);
Transactions.add(particular_patient_transactions);
Transactions.add(particular_donor_transactions);

Logout.add(logout);
bar.add(Home);
bar.add(View);
bar.add(Transactions);
bar.add(Logout);
c2.add(bar);
addDonor = new JButton("Add    Donor     Information");
addPatient = new JButton("Add  Patient  Information ");
exchange=new JButton("Exchange Blood");
check=new JButton("Check");
donate=new JButton("Donate");

available = new JButton("Blood Availablility");
//view_patients=new JButton("View Patients");
//view_donors=new JButton("View Donors");

ActionListener ak = (ae)->{
Welcome w = new Welcome();
};
home.addActionListener(ak);

ActionListener al = (ae)->{
int re = JOptionPane.showConfirmDialog(new JDialog(),"Are you sure you want to logout?");
if(re==JOptionPane.YES_OPTION){
Admin_Login l = new Admin_Login();
dispose();
}
};
logout.addActionListener(al);

ActionListener ab = (ae)->{
AddDonor ad=new AddDonor();
};
addDonor.addActionListener(ab);

ActionListener ac = (ae)->{
AddPatient ap=new AddPatient();
};
addPatient.addActionListener(ac);

ActionListener ad = (ae)->{
Exchange aex=new Exchange();
};
exchange.addActionListener(ad);


ActionListener af = (ae)->{
Check ach=new Check();
};
check.addActionListener(af);

ActionListener ah = (ae)->{
Donate ado=new Donate();
};
donate.addActionListener(ah);

ActionListener ai = (ae)->{
ViewDonors vd=new ViewDonors();
};
view_donors.addActionListener(ai);

ActionListener aj = (ae)->{
ViewPatients vp=new ViewPatients();
};
view_patients.addActionListener(aj);

ActionListener an = (ae)->{
ViewPatientsTransactions vpt = new ViewPatientsTransactions();
};
patients.addActionListener(an);


ActionListener am = (ae)->{
ViewDonorsTransactions vdt = new ViewDonorsTransactions();
};
donors.addActionListener(am);


ActionListener ao = (ae)->{
ViewParticularDonorsTransactions vpdt = new ViewParticularDonorsTransactions();
};
particular_donor_transactions.addActionListener(ao);


ActionListener ap = (ae)->{
ViewParticularPatientsTransactions vppt = new ViewParticularPatientsTransactions();
};
particular_patient_transactions.addActionListener(ap);


ActionListener aq = (ae)->{
String s = new DbHandlerBDM().viewAvailable();
ViewAvailable va = new ViewAvailable();
va.view(s);
};
available.addActionListener(aq);



setVisible(true);
}
class Welcome{
JLabel lb;
Welcome(){
lb=new JLabel("Welcome  Admin  ");
lb.setFont(new Font("Serif", Font.BOLD, 35));
c2.add(lb);
c2.add(addDonor);
c2.add(addPatient); 
//c2.add(exchange);
c2.add(check);
c2.add(donate);
c2.add(available);


//c2.add(view_donors);
//c2.add(view_patients);


setVisible(true);
}
}

}