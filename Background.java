import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
public class Background extends JFrame{
public Background(){
setSize(1000,1000);
setTitle("Blood Bank Managemnet System");
setLocationRelativeTo(null);
JLabel background = new JLabel(new ImageIcon("C:\\DEMO\\MYSQL\\BloodDonationSystem\\trial.jpg"));
add(background);
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
setVisible(true);

}}
