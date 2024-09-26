import javax.swing.*;
import javax.swing.border.Border;

import java.awt.*;
import java.awt.event.ActionEvent;
//this page for owner login
import java.awt.event.ActionListener;


public class loginpage1 implements ActionListener
{   
    private String user="owner" ;
    private String password="owner123" ;


    JFrame jf;
    JLabel jl,jl1,jl3;
    JTextField jt,jt1;
    JButton jb,back;
   
    JPanel jp;

   public loginpage1()
   {
    jf=new JFrame();
    jf.setBounds(500,350,600,160);
    jl=new JLabel("Username");
    jl1=new JLabel("Password");
    jb=new JButton("ok");
    jb.addActionListener( this);
    back=new JButton("back");

    back.addActionListener(this);

    jl3=new JLabel("enter username and password");
  

    jt=new JTextField(15);
    jt1=new JTextField(15);

    jp=new JPanel();

    jp.setBounds(400, 400, 500, 500);
     
   
    jp.add(jl); 
    jp.add(jt);
    jp.add(jl1);
    jp.add(jt1);
   
    jp.add(jb);
   

    jf.add(jp,BorderLayout.CENTER);
    jf.add(jl3);
    jp.add(back);
  

    jf.setVisible(true);
    Border b=BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.BLACK),"Owner Login Page");

    jp.setBorder(b);
    jf.setLayout(new FlowLayout());
    jf.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
   }

   public void actionPerformed(ActionEvent e)
   {
    if(e.getSource()==jb)
    {
      
      if(jt.getText().equals(user)&&jt1.getText().equals(password))
      {
         mainpageO a=new mainpageO();
      }
      else if(jt.getText().equals(user)==false&&jt1.getText().equals(password)==false)
          {
            jl3.setText("invalid username and password");
            jt.setText(null);
            jt1.setText(null);
          }
            else if(jt.getText().equals(user)==false)
          {
             jl3.setText("invalid username");
             jt.setText(null);
          }
            else
        {
            jl3.setText("invalid password");
            jt1.setText(null);
        }
    }
    if(e.getSource()==back)
    {
      myframe p=new myframe("loginPage");
      p.setVisible(true);
      jf.setVisible(false);
      
    }

  }    
}


