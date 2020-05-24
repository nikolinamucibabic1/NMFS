package controller;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;

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
import model.Lek;
import model.Recept;
import model.TipKorisnika;
import view.MainFrame;

public class ShowAllRecipesController extends AbstractAction{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTable table;

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
				JButton btn = (JButton) e.getSource();
				MainFrame frame = (MainFrame) btn.getTopLevelAncestor();
				
				Object[] possibilities = {"Sifra", "IdLekara", "Datum"};
				String s = (String)JOptionPane.showInputDialog(
				                    frame,
				                    "Izaberite po cemu zelite da sortirate podatke:",
				                    "Prikaz recepata",
				                    JOptionPane.PLAIN_MESSAGE,
				                    null,
				                    possibilities,
				                    "Ime");
				
				if(s!=null) {
				
				String[] columnNames = { "Sifra", "IdLekara", "JMBG Pacijenta", "Datum i vreme", "Lek(Kolicina)", "Ukupna cena", "Obrisan" };
				String[][] data = {}; 
				table = new JTable();
				DefaultTableModel dtm = new DefaultTableModel(0,0);
				dtm.setColumnIdentifiers(columnNames);
				table.setModel(dtm);
				table.setEnabled(false);
				
				frame.getInstance().getPretragaLekoviBtn().setVisible(false);
				frame.getInstance().getPretragaReceptiBtn().setVisible(true);
				ObjectInputStream in;
				try {
					File fileName = new File("src/resources/recipes.txt");
					ArrayList<Recept> recepti;
					if (fileName.length() == 0) {
						recepti = new ArrayList<>();
					}else {
						FileInputStream file = new FileInputStream(fileName); 
						in = new ObjectInputStream(file); 
						recepti = new ArrayList<Recept>();
						// Method for deserialization of object
						Korisnik korisnik;
						try {
							recepti = (ArrayList<Recept>) in.readObject();
						} catch (IOException ex) {
						} catch (ClassNotFoundException ex) {
						}

						in.close();
						file.close();
					}
					for(int i=0;i<recepti.size();i++) {
						String lekoviRecept = "";
						for (Lek lek: recepti.get(i).getLekovi().keySet()) {
							lekoviRecept = lekoviRecept + lek.getSifra() + "(" + recepti.get(i).getLekovi().get(lek) + ") ";
						}
						if(recepti.get(i).isObrisan()) {
							if(frame.getUser().getTipKorisnika() == TipKorisnika.ADMINISTRATOR) {
								dtm.addRow(new Object[] { recepti.get(i).getSifra(), recepti.get(i).getIdLekara(), recepti.get(i).getJmbgPacijenta(), recepti.get(i).getDatum(), lekoviRecept ,recepti.get(i).getUkupnaCena(), recepti.get(i).isObrisan() });
							}
						} else {
							dtm.addRow(new Object[] { recepti.get(i).getSifra(), recepti.get(i).getIdLekara(), recepti.get(i).getJmbgPacijenta(), recepti.get(i).getDatum(), lekoviRecept ,recepti.get(i).getUkupnaCena(), recepti.get(i).isObrisan() });
						}
					}
				} catch (IOException o ) {
					System.out.println("An error occurred.");
					o.printStackTrace();
				}
				
				TableRowSorter<TableModel> sorter = new TableRowSorter<>(table.getModel());
				table.setRowSorter(sorter);
				List<RowSorter.SortKey> sortKeys = new ArrayList<>();
				int columnIndexToSort;
				if(s.equals("Sifra")) {
					columnIndexToSort = 0;
		        } else if(s.equals("IdLekara")) {
		        	columnIndexToSort = 1;
		        } else {
		        	columnIndexToSort = 3;
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
