import java.awt.*;
import java.awt.event.*;


class myframe implements ActionListener
{
    Frame f;
    Button submit;
    TextField user,pass;
    Label l1,l2;


    public String username="dhairyashil";
    public String Password="drpatil";

    String u,p;

    myframe(String s)
    {
        f=new Frame();
        
        user=new TextField();
        user.setBounds(500, 200, 100, 25);
        pass=new TextField();
        pass.setBounds(500, 250, 100, 25);
        submit=new Button("ok");
        submit.setBounds(500,300,100,25);
        submit.addActionListener(this);



        l1=new Label("username");
        l2=new Label("password");

        l1.setBounds(420, 200, 70, 20);
        l2.setBounds(420, 250, 70, 20);


        f.add(l1);
        f.add(l2);
        f.add(user);
        f.add(pass);
        f.add(submit);
       

        Toolkit t =f.getToolkit();
        Dimension d=t.getScreenSize();
        int width =d.width*8/10;
        int height=d.height*8/10;

        f.setBounds(width/8, height/8, width, height);

        f.setLayout(null);
        f.setVisible(true);

    }

    public void actionPerformed(ActionEvent e)
    {  
        String a=user.getText();
        String b=pass.getText();

        if(username.equals(a)&&Password.equals(b))
        {
            mainpage mp=new mainpage();
        } 
       
    }
}


public class loginpage{
    public static void main(String[] args) {

        myframe a=new myframe("loginpage");
        
    }
}