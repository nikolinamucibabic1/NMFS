package view;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class MedicamentFrame extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Container c; 
    private JLabel title; 
    private JLabel sifra; 
    private JTextField tsifra; 
    private JLabel ime; 
    private JTextField time;
    private JLabel prozivodjac; 
    private JTextField tproizvodjac; 
    private JLabel cena; 
    private JTextField tcena; 
    private JLabel recept; 
    private JCheckBox izdavanje; 
    private JButton kreiraj;
	
	public MedicamentFrame(String value) {
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		setSize((int) (screenSize.width / 3), 500);
		setLocationRelativeTo(null);
		setTitle("Lek");
		
		setResizable(false); 
		  
        c = getContentPane(); 
        c.setLayout(null); 
        if(value.equals("create")) {
        	title = new JLabel("Kreiranje leka");
        }else {
        	title = new JLabel("Izmena leka");
        }
        title.setFont(new Font("Arial", Font.PLAIN, 30)); 
        title.setSize(200, 30); 
        title.setLocation(200, 30); 
        c.add(title); 
  
        sifra = new JLabel("Sifra"); 
        sifra.setFont(new Font("Arial", Font.PLAIN, 20)); 
        sifra.setSize(200, 20); 
        sifra.setLocation(50, 100); 
        c.add(sifra); 
  
        tsifra = new JTextField(); 
        tsifra.setFont(new Font("Arial", Font.PLAIN, 16)); 
        tsifra.setSize(200, 20); 
        tsifra.setLocation(200, 100); 
        c.add(tsifra); 
  
        ime = new JLabel("Ime"); 
        ime.setFont(new Font("Arial", Font.PLAIN, 20)); 
        ime.setSize(200, 20); 
        ime.setLocation(50, 150); 
        c.add(ime); 
  
        time = new JTextField(); 
        time.setFont(new Font("Arial", Font.PLAIN, 16)); 
        time.setSize(200, 20); 
        time.setLocation(200, 150); 
        c.add(time); 
        
        prozivodjac = new JLabel("Prozivodjac"); 
        prozivodjac.setFont(new Font("Arial", Font.PLAIN, 20)); 
        prozivodjac.setSize(200, 20); 
        prozivodjac.setLocation(50, 200); 
        c.add(prozivodjac); 
  
        tproizvodjac = new JTextField(); 
        tproizvodjac.setFont(new Font("Arial", Font.PLAIN, 16)); 
        tproizvodjac.setSize(200, 20); 
        tproizvodjac.setLocation(200, 200); 
        c.add(tproizvodjac); 
  
        cena = new JLabel("Cena"); 
        cena.setFont(new Font("Arial", Font.PLAIN, 20)); 
        cena.setSize(200, 20); 
        cena.setLocation(50, 250); 
        c.add(cena); 
  
        tcena = new JTextField(); 
        tcena.setFont(new Font("Arial", Font.PLAIN, 16)); 
        tcena.setSize(200, 20); 
        tcena.setLocation(200, 250); 
        c.add(tcena); 
  
        recept = new JLabel("Izdavanje na recept"); 
        recept.setFont(new Font("Arial", Font.PLAIN, 20)); 
        recept.setSize(200, 20); 
        recept.setLocation(50, 300); 
        c.add(recept); 
  
        izdavanje = new JCheckBox(); 
        izdavanje.setFont(new Font("Arial", Font.PLAIN, 13)); 
        izdavanje.setSelected(false); 
        izdavanje.setSize(100, 20); 
        izdavanje.setLocation(250, 300); 
        c.add(izdavanje); 
        
        if(value.equals("create")) {
        	kreiraj = new JButton("Kreiraj");
        }else {
        	kreiraj = new JButton("Izmeni");
        }
        		
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

	public JLabel getSifra() {
		return sifra;
	}

	public void setSifra(JLabel sifra) {
		this.sifra = sifra;
	}

	public JTextField getTsifra() {
		return tsifra;
	}

	public void setTsifra(JTextField tsifra) {
		this.tsifra = tsifra;
	}

	public JLabel getIme() {
		return ime;
	}

	public void setIme(JLabel ime) {
		this.ime = ime;
	}

	public JTextField getTime() {
		return time;
	}

	public void setTime(JTextField time) {
		this.time = time;
	}

	public JLabel getProzivodjac() {
		return prozivodjac;
	}

	public void setProzivodjac(JLabel prozivodjac) {
		this.prozivodjac = prozivodjac;
	}

	public JTextField getTproizvodjac() {
		return tproizvodjac;
	}

	public void setTproizvodjac(JTextField tproizvodjac) {
		this.tproizvodjac = tproizvodjac;
	}

	public JLabel getCena() {
		return cena;
	}

	public void setCena(JLabel cena) {
		this.cena = cena;
	}

	public JTextField getTcena() {
		return tcena;
	}

	public void setTcena(JTextField tcena) {
		this.tcena = tcena;
	}

	public JLabel getRecept() {
		return recept;
	}

	public void setRecept(JLabel recept) {
		this.recept = recept;
	}

	public JCheckBox getIzdavanje() {
		return izdavanje;
	}

	public void setIzdavanje(JCheckBox izdavanje) {
		this.izdavanje = izdavanje;
	}

	public JButton getKreiraj() {
		return kreiraj;
	}

	public void setKreiraj(JButton kreiraj) {
		this.kreiraj = kreiraj;
	}
	
}
