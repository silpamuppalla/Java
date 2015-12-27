import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ControlPanel extends JPanel
{
    //Variable Declarations
	JButton b1, b2, b4, b5,b6;
	Client container;
   	ChatPanel cp;
	DrawPanel dp;
	
	public ControlPanel(Client fd, ChatPanel cp1, DrawPanel dp1)
		{
		container = fd;
		cp=cp1;
        
		dp = dp1;
		b1 = new JButton("Connect");
		b2 = new JButton("Disconnect");
		b4 = new JButton("Clear Chat");
		b5 = new JButton("Share White Board");
                b6 = new JButton("Save-Chat");

		b1.addActionListener(new ActionListener()
				   {
				    public void actionPerformed(ActionEvent ae)
					{
                                     final StringMessage sm = new StringMessage();
						             String urname;
                                     urname= JOptionPane.showInputDialog("Enter Username:");
                                             if(urname!=null)
                                             {
											 container.connect();
                                             sm.setMessage(urname);
                                             container.sendMessage(sm);
                                            
                                             }
					}  
					  
				   });
		b2.addActionListener(new ActionListener()
				   {
						public void actionPerformed(ActionEvent ae)
					{
						container.close();
					}
				   });
		
				
		b4.addActionListener(new ActionListener()
				   {
						public void actionPerformed(ActionEvent ae)
					{
						container.clear();
					}
				   });
		b5.addActionListener(new ActionListener()
				   {
			     public void actionPerformed(ActionEvent ae)
					{
						LineMessage lm = new LineMessage();
						lm.setLineMessage(container.dp.linelist);
						container.sendMessage(lm);
                                             
					}
				   });
		b6.addActionListener(new ActionListener()
				   {
				  public void actionPerformed(ActionEvent ae)
					{
						container.savechat();
					}
				   });

					setLayout(new FlowLayout());
         
		 setComponentOrientation(
                ComponentOrientation.LEFT_TO_RIGHT);
		 add(b1);
		 add(b6);
         add(b4);
		 add(b2);
		 add(b5);		
		}
}

