package controller;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.OptionalDataException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.RowSorter;
import javax.swing.SortOrder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import model.Korisnik;
import view.MainFrame;

public class ShowAllUsersController extends AbstractAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTable table;

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		JButton btn = (JButton) arg0.getSource();
		MainFrame frame = (MainFrame) btn.getTopLevelAncestor();

		Object[] possibilities = {"Ime", "Prezime", "Tip korisnika"};
		String s = (String)JOptionPane.showInputDialog(
				frame,
				"Izaberite po cemu zelite da sortirate podatke:",
				"Prikaz korisnika",
				JOptionPane.PLAIN_MESSAGE,
				null,
				possibilities,
				"Ime");
		if(s!=null) {

			String[] columnNames = { "Korisnicko ime", "Lozinka", "Ime", "Prezime", "Tip korisnika" };
			table = new JTable();
			DefaultTableModel dtm = new DefaultTableModel(0,0);
			dtm.setColumnIdentifiers(columnNames);
			table.setModel(dtm);
			table.setEnabled(false);

			frame.getInstance().getPretragaLekoviBtn().setVisible(false);
			frame.getInstance().getPretragaReceptiBtn().setVisible(false);

			try {
				
				FileInputStream file = new FileInputStream("src/resources/users.txt"); 
				ObjectInputStream in = new ObjectInputStream(file); 
				ArrayList<Korisnik> korisnici = new ArrayList<Korisnik>();
				// Method for deserialization of object
				Korisnik korisnik;
				try {
					korisnici = (ArrayList<Korisnik>) in.readObject();
				} catch (IOException ex) {
				} catch (ClassNotFoundException ex) {
				}

				in.close();
				file.close();

				for(int i=0;i<korisnici.size();i++) {
					dtm.addRow(new Object[] { korisnici.get(i).korisnickoIme, korisnici.get(i).lozinka, korisnici.get(i).ime, korisnici.get(i).prezime, korisnici.get(i).tipKorisnika });
				}

			} catch (IOException o) {
				System.out.println("An error occurred.");
				o.printStackTrace();
			}


			TableRowSorter<TableModel> sorter = new TableRowSorter<>(table.getModel());
			table.setRowSorter(sorter);
			List<RowSorter.SortKey> sortKeys = new ArrayList<>();
			int columnIndexToSort;
			if(s.equals("Ime")) {
				columnIndexToSort = 2;
			} else if(s.equals("Prezime")) {
				columnIndexToSort = 3;
			} else {
				columnIndexToSort = 4;
			}

			sortKeys.add(new RowSorter.SortKey(columnIndexToSort, SortOrder.ASCENDING));

			sorter.setSortKeys(sortKeys);
			sorter.sort();

			// adding it to JScrollPane 
			JScrollPane sp = new JScrollPane(table);
			frame.getCentralni().removeAll();
			frame.getCentralni().add(sp, BorderLayout.CENTER);
			frame.validate();
			frame.repaint();

		}
	}

}
