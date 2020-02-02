import java.sql.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
class DbHandlerBDM extends JFrame{
public void addDonor(String fname, String lname , String gender , int age , long contact , String address , String bgroup){//1
System.out.println("Admin ");
Connection conn=null;
try{
System.out.println("Loading..");
Class.forName("com.mysql.jdbc.Driver");  
System.out.println("Loaded");

System.out.println("Connecting..");
conn=DriverManager.getConnection("jdbc:mysql://localhost:3310/bloodbankmanagementdb","root","abc123");
System.out.println("Conected");
String s1 = "Insert into donors(Firstname,Lastname,Gender,Age,Contact,Address,BloodGroup)" + "values(?,?,?,?,?,?,?)";
PreparedStatement p1 = conn.prepareStatement(s1);
p1.setString(1,fname);
p1.setString(2,lname);
p1.setString(3,gender);
p1.setInt(4,age);
p1.setLong(5,contact);
p1.setString(6,address);
p1.setString(7,bgroup);
System.out.println("1");
int r1 = p1.executeUpdate();
System.out.println("q");
System.out.println(r1);
if(r1>0){
JOptionPane.showMessageDialog(new JDialog(),"Registered Successfully");
}}//end of try
catch(Exception e){
System.out.println("Issues :"+ e);
}
finally{
try{
if(conn !=null){
conn.close();
}
}
catch(Exception e){
System.out.println("Closing Issues :"+ e);
}}
}//end of adddonor ie insert





public void addPatient(String fname, String lname , String gender , int age , long contact , String address , String bgroup){//1
System.out.println("Admin ");
Connection conn=null;
try{
System.out.println("Loading..");
Class.forName("com.mysql.jdbc.Driver");  
System.out.println("Loaded");

System.out.println("Connecting..");
conn=DriverManager.getConnection("jdbc:mysql://localhost:3310/bloodbankmanagementdb","root","abc123");
System.out.println("Conected");
String s1 = "Insert into patients(Firstname,Lastname,Gender,Age,Contact,Address,BloodGroup)" + "values(?,?,?,?,?,?,?)";
PreparedStatement p1 = conn.prepareStatement(s1);
p1.setString(1,fname);
p1.setString(2,lname);
p1.setString(3,gender);
p1.setInt(4,age);
p1.setLong(5,contact);
p1.setString(6,address);
p1.setString(7,bgroup);
System.out.println("1");
int r1 = p1.executeUpdate();
System.out.println("q");
System.out.println(r1);
if(r1>0){
JOptionPane.showMessageDialog(new JDialog(),"Registered Successfully");
}}//end of try
catch(Exception e){
System.out.println("Issues :"+ e);
}
finally{
try{
if(conn !=null){
conn.close();
}
}
catch(Exception e){
System.out.println("Closing Issues :"+ e);
}}
}//end of adddonor ie insert





public String viewDonors(){//3
Connection conn = null;
StringBuffer sb = new StringBuffer();
try{
System.out.println("Loading..");
Class.forName("com.mysql.jdbc.Driver");  
System.out.println("Loaded");

System.out.println("Connecting..");
conn=DriverManager.getConnection("jdbc:mysql://localhost:3310/bloodbankmanagementdb","root","abc123");
System.out.println("Conected");

//setString m no of parameter,value
//getString m column no


Statement stmt = conn.createStatement();
String sql ="Select * from donors";
ResultSet rs = stmt.executeQuery(sql);
while(rs.next()){
int id = rs.getInt (1);
String firstname = rs.getString (2);
String lastname = rs.getString (3);
String gender= rs.getString (4);
int age = rs.getInt (5);
Long contact = rs.getLong (6);
String address = rs.getString (7);
String bgroup = rs.getString (8);

sb.append("Id :  "+id + "  Firstname :  "+ firstname + "  Lastname :  "+ lastname +   " Gender : " + gender + " Age : " + age + " Contact : " + contact + "  Address : "+ address + " BloodGroup : " +  bgroup + " \n  \n " );
}
rs.close();
stmt.close();
}
catch(Exception e){
System.out.println("Issues : " + e);
}
finally{
try{
System.out.println("Closing..");
conn.close();
System.out.println("Closed");
}
catch(Exception e){
System.out.println("Issues "+ e);
}
}
return sb.toString();

}//end of view donor






public String viewPatients(){//2
Connection conn = null;
StringBuffer sb = new StringBuffer();
try{
System.out.println("Loading..");
Class.forName("com.mysql.jdbc.Driver");  
System.out.println("Loaded");

System.out.println("Connecting..");
conn=DriverManager.getConnection("jdbc:mysql://localhost:3310/bloodbankmanagementdb","root","abc123");
System.out.println("Conected");

//setString m no of parameter,value
//getString m column no


Statement stmt = conn.createStatement();
String sql ="Select * from patients";
ResultSet rs = stmt.executeQuery(sql);
while(rs.next()){
int id = rs.getInt (1);
String firstname = rs.getString (2);
String lastname = rs.getString (3);
String gender= rs.getString (4);
int age = rs.getInt (5);
Long contact = rs.getLong (6);
String address = rs.getString (7);
String bgroup = rs.getString (8);

sb.append("Id :  "+id + " Firstname :  "+ firstname + "  Lastname :  "+ lastname +   " Gender : " + gender + " Age : " + age + " Contact : " + contact + "  Address : "+ address + " BloodGroup : " +  bgroup + " \n  \n " );
}
rs.close();
stmt.close();
}
catch(Exception e){
System.out.println("Issues : " + e);
}
finally{
try{
System.out.println("Closing..");
conn.close();
System.out.println("Closed");
}
catch(Exception e){
System.out.println("Issues "+ e);
}
}
return sb.toString();

}//end of viewPatient






public boolean donate(int id , int amt){
System.out.println("Admin ");
boolean donated = false;
Connection conn=null;
try{
System.out.println("Loading..");
Class.forName("com.mysql.jdbc.Driver");  
System.out.println("Loaded");

System.out.println("Connecting..");
conn=DriverManager.getConnection("jdbc:mysql://localhost:3310/bloodbankmanagementdb","root","abc123");
System.out.println("Conected");

System.out.println(id);
System.out.println(amt);
String sql="Update available_blood set Amount_Available = Amount_Available + "+ amt + " Where BloodGroup = ( Select BloodGroup from donors where id = " + id + ")";

System.out.println("up");
PreparedStatement pst = conn.prepareStatement(sql);
//pst.setInt(2,amt);

System.out.println("up");
System.out.println(pst);
int row=pst.executeUpdate();
System.out.println(row);
if(row>0){
JOptionPane.showMessageDialog(new JDialog(),"Thankyou for Donating Blood ! ");
donated =true;
}
else{
JOptionPane.showMessageDialog(new JDialog(),"Id not registered ");
donated =false;
}
if(donated){

String sql1="{call donor_transaction(?,?)}";
CallableStatement stmt1 = conn.prepareCall(sql1);

stmt1.setInt(1,id);
stmt1.setInt(2,amt);

int row2 = stmt1.executeUpdate();

if(row2>0){
JOptionPane.showMessageDialog(new JDialog(),"Recorded Inserted in donated ! ");
}}
/*

String s1 = "Insert into donated(Id,Amount_Donated)" + "values(?,?)";
PreparedStatement p1 = conn.prepareStatement(s1);
p1.setInt(1,id);
p1.setInt(2,amt);
System.out.println("1");
int r1 = p1.executeUpdate();
System.out.println("q");
System.out.println(r1);
if(r1>0){
JOptionPane.showMessageDialog(new JDialog(),"Donatation Recorded !");
}
}*/
}
catch(Exception e){
System.out.println("Issues :"+ e);
}
finally{
try{
if(conn !=null){
conn.close();
}
}
catch(Exception e){
System.out.println("Closing Issues :"+ e);
}}
return donated;
}//end of donate







public boolean check(int id , int amt){
System.out.println("Admin ");
boolean require = false;
boolean given=false;
int temp=0;
Connection conn=null;
try{
System.out.println("Loading..");
Class.forName("com.mysql.jdbc.Driver");  
System.out.println("Loaded");

System.out.println("Connecting..");
conn=DriverManager.getConnection("jdbc:mysql://localhost:3310/bloodbankmanagementdb","root","abc123");
System.out.println("Conected");

System.out.println(id);
System.out.println(amt);
String sql="{call get_available_amount(?)}";
System.out.println("up1");

CallableStatement stmt = conn.prepareCall(sql);
stmt.setInt(1,id);
System.out.println("up2");
System.out.println(stmt);

ResultSet rs = stmt.executeQuery();

System.out.println("up3");
while(rs.next()){
int amm = rs.getInt("Amount_Available");
System.out.println(amm);
temp=amm;
}

//System.out.println(rs);
if(temp>=amt){
int re = JOptionPane.showConfirmDialog(new JDialog(),"Blood Available ! Are you sure you want ?");
if(re==JOptionPane.YES_OPTION){
require = true;
String sql1="{call minus_available_amount(?,?)}";
CallableStatement stmt1 = conn.prepareCall(sql1);

stmt1.setInt(1,amt);
stmt1.setInt(2,id);

int row = stmt1.executeUpdate();
if(row>0){
JOptionPane.showMessageDialog(new JDialog(),"Take the blood from desk ");
given = true;

}
}
else{
System.out.println("dont want");
}
}
else{
JOptionPane.showMessageDialog(new JDialog(),"Not available ");
}

if(given){

String sql2="{call patient_transaction(?,?)}";
CallableStatement stmt2 = conn.prepareCall(sql2);

stmt2.setInt(1,id);
stmt2.setInt(2,amt);

int row2 = stmt2.executeUpdate();

if(row2>0){
JOptionPane.showMessageDialog(new JDialog(),"Recorded Inserted in patient_taken_blood ! ");
}
}



/*String s1 = "Insert into donated(Id,Amount_Donated)" + "values(?,?)";
PreparedStatement p1 = conn.prepareStatement(s1);
p1.setInt(1,id);
p1.setInt(2,amt);
System.out.println("1");
int r1 = p1.executeUpdate();
System.out.println("q");
System.out.println(r1);
if(r1>0){
JOptionPane.showMessageDialog(new JDialog(),"Donatation Recorded !");
}
*/
}
catch(Exception e){
System.out.println("Issues :"+ e);
}
finally{
try{
if(conn !=null){
conn.close();
}
}
catch(Exception e){
System.out.println("Closing Issues :"+ e);
}}
return require;
}//end of check







public String viewDonorsTransactions(){//3
Connection conn = null;
StringBuffer sb = new StringBuffer();
try{
System.out.println("Loading..");
Class.forName("com.mysql.jdbc.Driver");  
System.out.println("Loaded");

System.out.println("Connecting..");
conn=DriverManager.getConnection("jdbc:mysql://localhost:3310/bloodbankmanagementdb","root","abc123");
System.out.println("Conected");

//setString m no of parameter,value
//getString m column no


Statement stmt = conn.createStatement();
String sql ="Select * from donated";
ResultSet rs = stmt.executeQuery(sql);
while(rs.next()){
int id = rs.getInt (1);
int amount_donated = rs.getInt(2);
Timestamp created_at = rs.getTimestamp(3);
sb.append("Id :  "+id + "  Amount_Donated :  "+ amount_donated + "  Donated_at :  "+ created_at +  " \n  \n " );
}
rs.close();
stmt.close();
}
catch(Exception e){
System.out.println("Issues : " + e);
}
finally{
try{
System.out.println("Closing..");
conn.close();
System.out.println("Closed");
}
catch(Exception e){
System.out.println("Issues "+ e);
}
}
return sb.toString();

}//end of view donor transactions





public String viewPatientsTransactions(){//3
Connection conn = null;
StringBuffer sb = new StringBuffer();
try{
System.out.println("Loading..");
Class.forName("com.mysql.jdbc.Driver");  
System.out.println("Loaded");

System.out.println("Connecting..");
conn=DriverManager.getConnection("jdbc:mysql://localhost:3310/bloodbankmanagementdb","root","abc123");
System.out.println("Conected");

//setString m no of parameter,value
//getString m column no


Statement stmt = conn.createStatement();
String sql ="Select * from patients_taken_bloood";
ResultSet rs = stmt.executeQuery(sql);
while(rs.next()){
int id = rs.getInt (1);
int amount_taken = rs.getInt(2);
Timestamp created_at = rs.getTimestamp(3);
sb.append("Id :  "+id + "  Amount_Given :  "+ amount_taken + "  Given_at :  "+ created_at +  " \n  \n " );
}
rs.close();
stmt.close();
}
catch(Exception e){
System.out.println("Issues : " + e);
}
finally{
try{
System.out.println("Closing..");
conn.close();
System.out.println("Closed");
}
catch(Exception e){
System.out.println("Issues "+ e);
}
}
return sb.toString();

}//end of view patients transactions



public String viewParticularPatientsTransactions(int id){
Connection conn = null;
StringBuffer sb = new StringBuffer();
try{
System.out.println("Loading..");
Class.forName("com.mysql.jdbc.Driver");  
System.out.println("Loaded");

System.out.println("Connecting..");
conn=DriverManager.getConnection("jdbc:mysql://localhost:3310/bloodbankmanagementdb","root","abc123");
System.out.println("Conected");

Statement stmt = conn.createStatement();
String sql ="Select * from patients_taken_bloood where id = " + id;
ResultSet rs = stmt.executeQuery(sql);
while(rs.next()){
int iid = rs.getInt (1);
int amount_given = rs.getInt(2);
Timestamp created_at = rs.getTimestamp(3);
sb.append("Id :  "+iid + "  Amount_Given :  "+ amount_given + "  Given_at :  "+ created_at +  " \n  \n " );
}

rs.close();
stmt.close();
}
catch(Exception e){
System.out.println("Issues : " + e);
}
finally{
try{
System.out.println("Closing..");
conn.close();
System.out.println("Closed");
}
catch(Exception e){
System.out.println("Issues "+ e);
}
}
return sb.toString();
}

public String viewParticularDonorsTransactions(int id){
Connection conn = null;
StringBuffer sb = new StringBuffer();
try{
System.out.println("Loading..");
Class.forName("com.mysql.jdbc.Driver");  
System.out.println("Loaded");

System.out.println("Connecting..");
conn=DriverManager.getConnection("jdbc:mysql://localhost:3310/bloodbankmanagementdb","root","abc123");
System.out.println("Conected");

Statement stmt = conn.createStatement();
String sql ="Select * from donated where id = " + id;
ResultSet rs = stmt.executeQuery(sql);
while(rs.next()){
int iid = rs.getInt (1);
int amount_donated = rs.getInt(2);
Timestamp created_at = rs.getTimestamp(3);
sb.append("Id :  "+iid + "  Amount_Donated :  "+ amount_donated + "  Donated_at :  "+ created_at +  " \n  \n " );
}

rs.close();
stmt.close();
}
catch(Exception e){
System.out.println("Issues : " + e);
}
finally{
try{
System.out.println("Closing..");
conn.close();
System.out.println("Closed");
}
catch(Exception e){
System.out.println("Issues "+ e);
}
}
return sb.toString();
}






public String viewAvailable(){//3
Connection conn = null;
StringBuffer sb = new StringBuffer();
try{
System.out.println("Loading..");
Class.forName("com.mysql.jdbc.Driver");  
System.out.println("Loaded");

System.out.println("Connecting..");
conn=DriverManager.getConnection("jdbc:mysql://localhost:3310/bloodbankmanagementdb","root","abc123");
System.out.println("Conected");

//setString m no of parameter,value
//getString m column no


Statement stmt = conn.createStatement();
String sql ="Select * from available_blood";
ResultSet rs = stmt.executeQuery(sql);
while(rs.next()){
String bgroup = rs.getString (1);
int amount = rs.getInt(2);

sb.append("BloodGroup :  "+bgroup + "  Amount_Available(in Litres) :  "+ amount + " \n  \n " );
}
rs.close();
stmt.close();
}
catch(Exception e){
System.out.println("Issues : " + e);
}
finally{
try{
System.out.println("Closing..");
conn.close();
System.out.println("Closed");
}
catch(Exception e){
System.out.println("Issues "+ e);
}
}
return sb.toString();

}//end of available


}//e nd of class