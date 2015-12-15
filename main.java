
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class  main extends JFrame implements ActionListener, Runnable
{
	static JFrame frame;
	private String username, password;
	private static JFrame loginFrame;
	private static JPanel panel1;
	private JButton loginBtn, exitBtn;
	int dialogtype = JOptionPane.PLAIN_MESSAGE;
	String dialogmessage, dialogs;
	private JLabel nameLbl, userLbl, passwordLbl;
	private static JTextField userTxt;
	private static JPasswordField passwordTxt;
	public String loginname, loginpass;
	JProgressBar barDo;
	Thread t;

	main()
	{
		frame = new JFrame("Hospital Managment");
                               frame.setLayout(new BorderLayout());
	JLabel background=new JLabel(new ImageIcon("images/Capture.jpg"));
	frame.add(background);
	background.setLayout(null);
		//panel1 = new JPanel();
		//panel1.setLayout(null);

		nameLbl = new JLabel("Hospital Managment ");
		nameLbl.setBounds(5, 5, 289, 24);
		nameLbl.setFont(new Font("Arial", Font.BOLD, 20));
		nameLbl.setHorizontalAlignment(SwingConstants.CENTER);

		userLbl = new JLabel("Username :");
		userLbl.setFont(new Font("Arial", Font.PLAIN, 15));
		userLbl.setBounds(5, 47, 82, 24);
		
		userTxt = new JTextField(20);
		userTxt.setBounds(97, 50, 197, 20);
		

		passwordLbl = new JLabel("Password :");
		passwordLbl.setFont(new Font("Arial", Font.PLAIN, 15));
		passwordLbl.setBounds(5, 82, 82, 14);

		passwordTxt = new JPasswordField(20);
		passwordTxt.setBounds(97, 80, 197, 20);

		barDo = new JProgressBar(0, 100); //Min value: 0 Max value: 100
		barDo.setBounds(10, 158, 284, 14);

		loginBtn = new JButton("Login", new ImageIcon("images/key.gif"));
		loginBtn.setBounds(40, 107, 100, 43);
		loginBtn.addActionListener(this);

		exitBtn = new JButton("Exit", new ImageIcon("images/Keys.gif"));
		exitBtn.setBounds(170, 107, 100, 43);
		exitBtn.addActionListener(this);

		//frame.getContentPane().add(panel1);

		background.add(nameLbl);
		background.add(userTxt);
		background.add(userLbl);
		background.add(passwordLbl);
		background.add(passwordTxt);
		background.add(barDo);
		background.add(loginBtn);
		background.add(exitBtn);

		frame.setSize(399,399);
		frame.setLocationRelativeTo(null);	
		frame.setVisible(true);

		frame.addWindowListener(new WindowAdapter()
		{
			public void windowClosing(WindowEvent e)
			{
				System.exit(0);
			}
		});

	}

	public void actionPerformed(ActionEvent event)
	{
		Object source = event.getSource();

		if(source.equals(loginBtn))
		{
			String loginname,loginpass;
			loginname = userTxt.getText().trim();
			loginpass = passwordTxt.getText().trim();

			if(loginname.equals("admin") && loginpass.equals("admin"))
			{	
				dialogmessage = "Welcome - " + loginname;
				t = new Thread(this);	
				t.start();
			}
			else
			{
				JOptionPane.showMessageDialog(null,"Invaild User name and password" , "WARNING!!!",JOptionPane.INFORMATION_MESSAGE);
				userTxt.setText("");
				passwordTxt.setText("");
			}				

		} 

		else if(source.equals(exitBtn))
		{
			System.exit(0);
		}
	}

	public void run()
	{
		for (int i=0; i<=100; i++)
		{ 
			barDo.setValue(i); //set value 
			barDo.repaint(); //refresh graphics
			try
			{
				Thread.sleep(20);
			}	 
			catch (Exception e)
			{
			}

		}
		JOptionPane.showMessageDialog((Component)null, dialogmessage, dialogs, JOptionPane.INFORMATION_MESSAGE);
		userTxt.setText("");
		setVisible(false);
		frame.dispose();
		new start();
	}

	public static void main(String[] args)
	{
		try
		{
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		}
		catch(Exception e)
		{
		}

		new main();
	}
}
