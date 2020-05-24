package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;


public class LoginFrame extends JFrame{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	JTextField username;
	JPasswordField password;

	public LoginFrame() {
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		setSize((int) (screenSize.width/4), 170);
		setLocationRelativeTo(null);
		setTitle("Login");
		setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/resources/login.png")));
		
		JPanel panel1 = new JPanel();
		JPanel panel2 = new JPanel();
		
		JLabel usernameLab = new JLabel("Username: ");
		JLabel passwordLab = new JLabel("Password: ");
		
		username = new JTextField();
		//username.setText("admin");
		username.setPreferredSize(new Dimension(150,25));
		password = new JPasswordField();
		//password.setText("admin");
		password.setPreferredSize(new Dimension(150,25));
		
		panel1.add(usernameLab);
		panel1.add(username, "wrap");
		
		panel2.add(passwordLab);
		panel2.add(password, "wrap");
		
		JButton loginBtn = new JButton(MainFrame.getInstance().getActionManager().getLoginController());
		loginBtn.setText("Login");
		loginBtn.setAlignmentX(CENTER_ALIGNMENT);
		loginBtn.setPreferredSize(new Dimension(80,25));
		
		JPanel buttonPanel = new JPanel();
		buttonPanel.add(loginBtn);
		
		
		this.add(panel1, BorderLayout.NORTH);
		this.add(panel2, BorderLayout.CENTER);
		this.add(buttonPanel, BorderLayout.SOUTH);
	}
	
	public JTextField getUsername() {
		return username;
	}

	public void setUsername(JTextField username) {
		this.username = username;
	}

	public JPasswordField getPassword() {
		return password;
	}

	public void setPassword(JPasswordField password) {
		this.password = password;
	}
	
}
