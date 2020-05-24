package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class SearchFrame extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField vrednost;
	private JTextField vrednostDo;
	private JPanel panel;
	private JButton ok;

	public SearchFrame() {

	}

	public SearchFrame(String filter,String value) {

		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		setSize((int) (screenSize.width / 5), 200);
		setLocationRelativeTo(null);
		if(value.equals("lek")) {
			setTitle("Pretraga lekova");
			panel = new JPanel(new BorderLayout());
			JPanel centralni = new JPanel();

			if(filter.equals("Sifra")) {
				panel.add(new JLabel("Unesite sifru leka:"),BorderLayout.NORTH);
				vrednost = new JTextField(15);
				centralni.add(vrednost);
				panel.add(centralni,BorderLayout.CENTER);
				ok = new JButton();
				ok.setPreferredSize(new Dimension(150, 25));
				ok.setName("Pretrazi");
				ok.setText("Pretrazi");
				panel.add(ok,BorderLayout.SOUTH);
				add(panel);
			} else if(filter.equals("Ime")) {
				panel.add(new JLabel("Unesite ime leka:"),BorderLayout.NORTH);
				vrednost = new JTextField(15);
				centralni.add(vrednost);
				panel.add(centralni,BorderLayout.CENTER);
				ok = new JButton();
				ok.setPreferredSize(new Dimension(150, 25));
				ok.setName("Pretrazi");
				ok.setText("Pretrazi");
				panel.add(ok,BorderLayout.SOUTH);
				add(panel);
			} else if(filter.equals("Proizvodjac")) {
				panel.add(new JLabel("Unesite naziv proizvodjaca leka:"),BorderLayout.NORTH);
				vrednost = new JTextField(15);
				centralni.add(vrednost);
				panel.add(centralni,BorderLayout.CENTER);
				ok = new JButton();
				ok.setPreferredSize(new Dimension(150, 25));
				ok.setName("Pretrazi");
				ok.setText("Pretrazi");
				panel.add(ok,BorderLayout.SOUTH);
				add(panel);
			} else {
				panel.add(new JLabel("Unesite raspod cene leka:"),BorderLayout.NORTH);
				vrednostDo = new JTextField(10);
				vrednost = new JTextField(10);
				centralni.add(new JLabel("od"));
				centralni.add(vrednost);
				centralni.add(new JLabel("do"));
				centralni.add(vrednostDo);
				panel.add(centralni,BorderLayout.CENTER);
				ok = new JButton();
				ok.setPreferredSize(new Dimension(150, 25));
				ok.setName("Pretrazi");
				ok.setText("Pretrazi");
				panel.add(ok,BorderLayout.SOUTH);
				add(panel);
			} 
		} else {
			setTitle("Pretraga recepata");
			panel = new JPanel(new BorderLayout());
			JPanel centralni = new JPanel();

			if(filter.equals("Sifra")) {
				panel.add(new JLabel("Unesite sifru recepta:"),BorderLayout.NORTH);
				vrednost = new JTextField(15);
				centralni.add(vrednost);
				panel.add(centralni,BorderLayout.CENTER);
				ok = new JButton();
				ok.setPreferredSize(new Dimension(150, 25));
				ok.setName("Pretrazi");
				ok.setText("Pretrazi");
				panel.add(ok,BorderLayout.SOUTH);
				add(panel);
			} else if(filter.equals("IdLekara")) {
				panel.add(new JLabel("Unesite idLekara:"),BorderLayout.NORTH);
				vrednost = new JTextField(15);
				centralni.add(vrednost);
				panel.add(centralni,BorderLayout.CENTER);
				ok = new JButton();
				ok.setPreferredSize(new Dimension(150, 25));
				ok.setName("Pretrazi");
				ok.setText("Pretrazi");
				panel.add(ok,BorderLayout.SOUTH);
				add(panel);
			} else if(filter.equals("JMBG")) {
				panel.add(new JLabel("Unesite JMBG pacijenta:"),BorderLayout.NORTH);
				vrednost = new JTextField(15);
				centralni.add(vrednost);
				panel.add(centralni,BorderLayout.CENTER);
				ok = new JButton();
				ok.setPreferredSize(new Dimension(150, 25));
				ok.setName("Pretrazi");
				ok.setText("Pretrazi");
				panel.add(ok,BorderLayout.SOUTH);
				add(panel);
			} else {
				vrednost = new JTextField(15);
				centralni.add(vrednost);
				panel.add(centralni,BorderLayout.CENTER);
				ok = new JButton();
				ok.setPreferredSize(new Dimension(150, 25));
				ok.setName("Pretrazi");
				ok.setText("Pretrazi");
				panel.add(ok,BorderLayout.SOUTH);
				add(panel);
			} 
		}
	}

	public JTextField getVrednost() {
		return vrednost;
	}

	public void setVrednost(JTextField vrednost) {
		this.vrednost = vrednost;
	}

	public JTextField getVrednostDo() {
		return vrednostDo;
	}

	public void setVrednostDo(JTextField vrednostDo) {
		this.vrednostDo = vrednostDo;
	}

	public JButton getOk() {
		return ok;
	}

	public void setOk(JButton ok) {
		this.ok = ok;
	}

}
