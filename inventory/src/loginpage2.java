import javax.swing.*;
import javax.swing.border.Border;

import java.awt.*;
import java.awt.event.ActionEvent;
//this page for owner login
import java.awt.event.ActionListener;

public class loginpage2 implements ActionListener
{   
    private String user="employee" ;
    private String password="employee123" ;


    JFrame jf;
    JLabel jl,jl1;
    JTextField jt,jt1;
    JButton jb;
   
    JPanel jp;

   public loginpage2()
   {
    jf=new JFrame();
    jf.setSize(600, 600);
    jl=new JLabel("Uerrname");
    jl1=new JLabel("Password");
    jb=new JButton("ok");
    jb.addActionListener( this);
  

    jt=new JTextField(15);
    jt1=new JTextField(15);

    jp=new JPanel();

    jp.setBounds(400, 400, 500, 500);
     
   
    jp.add(jl); 
    jp.add(jt);
    jp.add(jl1);
    jp.add(jt1);
   
    jp.add(jb);
    jf.add(jp);

    jf.setVisible(true);
    Border b=BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.BLACK),"Owner Login Page");

    jp.setBorder(b);


   







    jf.setLayout(new FlowLayout());

   }
   public void actionPerformed(ActionEvent e)
   {
    if(jt.getText().equals(user)&&jt1.getText().equals(password))
    {
        mainpageE a=new mainpageE();
    }
   }


    
}


