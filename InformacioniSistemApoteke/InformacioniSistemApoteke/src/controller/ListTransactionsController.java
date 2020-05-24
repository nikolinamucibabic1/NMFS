package controller;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import model.Transakcija;
import view.MainFrame;

public class ListTransactionsController extends AbstractAction{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public ArrayList<Transakcija> transakcije;
	public JTable table;

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub

		JButton btn = (JButton) arg0.getSource();
		MainFrame frame = (MainFrame) btn.getTopLevelAncestor();

		Object[] possibilities = {"Ukupna prodaja svih lekova", "Ukupna prodaja po proizvodjacu", "Ukupna prodaja po apotekaru"};
		String s = (String)JOptionPane.showInputDialog(
				frame,
				"Izaberite vrstu izvjestaja:",
				"Prodaja lekova",
				JOptionPane.PLAIN_MESSAGE,
				null,
				possibilities,
				"Ukupna prodaja svih lekova");
		if(s!=null) {
			String[] columnNames = { "Sifra leka", "Apotekar", "Kolicina", "Proizvodjac", "Cena"};
			table = new JTable();
			DefaultTableModel dtm = new DefaultTableModel(0,0);
			dtm.setColumnIdentifiers(columnNames);
			table.setModel(dtm);
			table.setEnabled(false);
			
			try {
				File fileName = new File("src/resources/transactions.txt");
				if (fileName.length() == 0) {
					transakcije = new ArrayList<>();
				}else {
					FileInputStream file = new FileInputStream(fileName); 
					ObjectInputStream in = new ObjectInputStream(file); 
					// Method for deserialization of object
					try {
						transakcije = (ArrayList<Transakcija>) in.readObject();
					} catch (IOException ex) {
					} catch (ClassNotFoundException ex) {
					}

					in.close();
					file.close();
				}		
			} catch (IOException o) {
				System.out.println("An error occurred.");
				o.printStackTrace();
			}
			if(s.equals("Ukupna prodaja svih lekova")){
				for(int i=0;i<transakcije.size();i++) {
					//System.out.println(transakcije.get(i).getSifraLeka() + " " + transakcije.get(i).getApotekar().getIme() + " " + transakcije.get(i).getKolicina() + " " +transakcije.get(i).getCena()+ "\n");
					dtm.addRow(new Object[] { transakcije.get(i).getSifraLeka(), transakcije.get(i).getApotekar().getIme(), transakcije.get(i).getKolicina(), transakcije.get(i).getProizvodjac(), transakcije.get(i).getCena() });
				}	
			}else if(s.equals("Ukupna prodaja po proizvodjacu")) {
				String opcija = (String)JOptionPane.showInputDialog(
						frame,
						"Unesite proizvodjaca:",
						"Prodaja lekova",
						JOptionPane.PLAIN_MESSAGE,
						null,
						null,
						"");
				for(int i=0;i<transakcije.size();i++) {
					//System.out.println(transakcije.get(i).getSifraLeka() + " " + transakcije.get(i).getApotekar().getIme() + " " + transakcije.get(i).getKolicina() + " " +transakcije.get(i).getCena()+ "\n");
					if(transakcije.get(i).getProizvodjac().toLowerCase().contains(opcija.toLowerCase())) {
						dtm.addRow(new Object[] { transakcije.get(i).getSifraLeka(), transakcije.get(i).getApotekar().getIme(), transakcije.get(i).getKolicina(), transakcije.get(i).getProizvodjac(), transakcije.get(i).getCena() });
					}
				}
			} else {
				String opcija = (String)JOptionPane.showInputDialog(
						frame,
						"Unesite apotekara:",
						"Prodaja lekova",
						JOptionPane.PLAIN_MESSAGE,
						null,
						null,
						"");
				for(int i=0;i<transakcije.size();i++) {
					//System.out.println(transakcije.get(i).getSifraLeka() + " " + transakcije.get(i).getApotekar().getIme() + " " + transakcije.get(i).getKolicina() + " " +transakcije.get(i).getCena()+ "\n");
					if(transakcije.get(i).getApotekar().getIme().toLowerCase().contains(opcija.toLowerCase())) {
						dtm.addRow(new Object[] { transakcije.get(i).getSifraLeka(), transakcije.get(i).getApotekar().getIme(), transakcije.get(i).getKolicina(), transakcije.get(i).getProizvodjac(), transakcije.get(i).getCena() });
					}
				}
			}
			
			JScrollPane sp = new JScrollPane(table);
			frame.getCentralni().removeAll();
			frame.getCentralni().add(sp, BorderLayout.CENTER);
			frame.validate();
			frame.repaint();
		}
	}

}
