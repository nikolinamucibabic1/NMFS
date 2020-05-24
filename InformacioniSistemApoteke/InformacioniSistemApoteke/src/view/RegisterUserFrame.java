package view;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class RegisterUserFrame extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Container c; 
    private JLabel title; 
    private JLabel username; 
    private JTextField tusername; 
    private JLabel lozinka; 
    private JTextField tlozinka;
    private JLabel name; 
    private JTextField tname; 
    private JLabel surname; 
    private JTextField tsurname; 
    private JLabel tip; 
    private JRadioButton lekar; 
    private JRadioButton apotekar;
    private JRadioButton administrator; 
    private ButtonGroup gengp; 
    private JButton kreiraj;
	
	public RegisterUserFrame() {
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		setSize((int) (screenSize.width / 2), 500);
		setLocationRelativeTo(null);
		setTitle("Registruj korisnika");
		
		setResizable(false); 
		  
        c = getContentPane(); 
        c.setLayout(null); 
  
        title = new JLabel("Registracija"); 
        title.setFont(new Font("Arial", Font.PLAIN, 30)); 
        title.setSize(200, 30); 
        title.setLocation(200, 30); 
        c.add(title); 
  
        username = new JLabel("Korisnicko ime"); 
        username.setFont(new Font("Arial", Font.PLAIN, 20)); 
        username.setSize(200, 20); 
        username.setLocation(50, 100); 
        c.add(username); 
  
        tusername = new JTextField(); 
        tusername.setFont(new Font("Arial", Font.PLAIN, 16)); 
        tusername.setSize(200, 20); 
        tusername.setLocation(200, 100); 
        c.add(tusername); 
  
        lozinka = new JLabel("Lozinka"); 
        lozinka.setFont(new Font("Arial", Font.PLAIN, 20)); 
        lozinka.setSize(200, 20); 
        lozinka.setLocation(50, 150); 
        c.add(lozinka); 
  
        tlozinka = new JTextField(); 
        tlozinka.setFont(new Font("Arial", Font.PLAIN, 16)); 
        tlozinka.setSize(200, 20); 
        tlozinka.setLocation(200, 150); 
        c.add(tlozinka); 
        
        name = new JLabel("Ime"); 
        name.setFont(new Font("Arial", Font.PLAIN, 20)); 
        name.setSize(200, 20); 
        name.setLocation(50, 200); 
        c.add(name); 
  
        tname = new JTextField(); 
        tname.setFont(new Font("Arial", Font.PLAIN, 16)); 
        tname.setSize(200, 20); 
        tname.setLocation(200, 200); 
        c.add(tname); 
  
        surname = new JLabel("Prezime"); 
        surname.setFont(new Font("Arial", Font.PLAIN, 20)); 
        surname.setSize(200, 20); 
        surname.setLocation(50, 250); 
        c.add(surname); 
  
        tsurname = new JTextField(); 
        tsurname.setFont(new Font("Arial", Font.PLAIN, 16)); 
        tsurname.setSize(200, 20); 
        tsurname.setLocation(200, 250); 
        c.add(tsurname); 
  
        tip = new JLabel("Tip korisnika"); 
        tip.setFont(new Font("Arial", Font.PLAIN, 20)); 
        tip.setSize(200, 20); 
        tip.setLocation(50, 300); 
        c.add(tip); 
  
        lekar = new JRadioButton("LEKAR"); 
        lekar.setFont(new Font("Arial", Font.PLAIN, 13)); 
        lekar.setSelected(true); 
        lekar.setSize(100, 20); 
        lekar.setLocation(250, 300); 
        c.add(lekar); 
  
        apotekar = new JRadioButton("APOTEKAR"); 
        apotekar.setFont(new Font("Arial", Font.PLAIN, 13)); 
        apotekar.setSelected(false); 
        apotekar.setSize(150, 20); 
        apotekar.setLocation(350, 300); 
        c.add(apotekar);
        
        administrator = new JRadioButton("ADMINISTRATOR"); 
        administrator.setFont(new Font("Arial", Font.PLAIN, 13)); 
        administrator.setSelected(false); 
        administrator.setSize(200, 20); 
        administrator.setLocation(500, 300); 
        c.add(administrator); 
  
        gengp = new ButtonGroup(); 
        gengp.add(lekar); 
        gengp.add(apotekar);
        gengp.add(administrator);
        
        kreiraj = new JButton("Kreiraj");
        kreiraj.setSize(150, 40); 
        kreiraj.setLocation(220, 350); 
        c.add(kreiraj);
  
        setVisible(true); 
	}

	public Container getC() {
		return c;
	}

	public void setC(Container c) {
		this.c = c;
	}

	public void setTitle(JLabel title) {
		this.title = title;
	}

	public JLabel getUsername() {
		return username;
	}

	public void setUsername(JLabel username) {
		this.username = username;
	}

	public JTextField getTusername() {
		return tusername;
	}

	public void setTusername(JTextField tusername) {
		this.tusername = tusername;
	}

	public JLabel getLozinka() {
		return lozinka;
	}

	public void setLozinka(JLabel lozinka) {
		this.lozinka = lozinka;
	}

	public JTextField getTlozinka() {
		return tlozinka;
	}

	public void setTlozinka(JTextField tlozinka) {
		this.tlozinka = tlozinka;
	}

	public void setName(JLabel name) {
		this.name = name;
	}

	public JTextField getTname() {
		return tname;
	}

	public void setTname(JTextField tname) {
		this.tname = tname;
	}

	public JLabel getSurname() {
		return surname;
	}

	public void setSurname(JLabel surname) {
		this.surname = surname;
	}

	public JTextField getTsurname() {
		return tsurname;
	}

	public void setTsurname(JTextField tsurname) {
		this.tsurname = tsurname;
	}

	public JLabel getTip() {
		return tip;
	}

	public void setTip(JLabel tip) {
		this.tip = tip;
	}

	public JRadioButton getLekar() {
		return lekar;
	}

	public void setLekar(JRadioButton lekar) {
		this.lekar = lekar;
	}

	public JRadioButton getApotekar() {
		return apotekar;
	}

	public void setApotekar(JRadioButton apotekar) {
		this.apotekar = apotekar;
	}

	public ButtonGroup getGengp() {
		return gengp;
	}

	public void setGengp(ButtonGroup gengp) {
		this.gengp = gengp;
	}

	public JButton getKreiraj() {
		return kreiraj;
	}

	public void setKreiraj(JButton kreiraj) {
		this.kreiraj = kreiraj;
	}

	public JRadioButton getAdministrator() {
		return administrator;
	}

	public void setAdministrator(JRadioButton administrator) {
		this.administrator = administrator;
	}

}
