package controller;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import model.Korisnik;
import model.Lek;
import model.Recept;
import model.TipKorisnika;
import view.MainFrame;
import view.SearchFrame;

public class SearchRecipesController extends AbstractAction{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTable table;
	private SearchFrame searchFrame;

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		JButton btn = (JButton) e.getSource();
		MainFrame frame = (MainFrame) btn.getTopLevelAncestor();

		Object[] possibilities = {"Sifra", "IdLekara", "JMBG", "Sifra leka"};
		String s = (String)JOptionPane.showInputDialog(
				frame,
				"Izaberite po cemu zelite da pretrazite podatke:",
				"Pretraga recepata",
				JOptionPane.PLAIN_MESSAGE,
				null,
				possibilities,
				"Sifra");
		if(s!=null) {

			searchFrame = new SearchFrame(s,"recept");			
			searchFrame.setVisible(true);

			searchFrame.getOk().addActionListener(new ActionListener(){  
				public void actionPerformed(ActionEvent e){
					String vrednost = searchFrame.getVrednost().getText();
					String[] columnNames = { "Sifra", "IdLekara", "JMBG Pacijenta", "Datum i vreme", "Lek(Kolicina)", "Ukupna cena" };
					String[][] data = {}; 
					table = new JTable();
					DefaultTableModel dtm = new DefaultTableModel(0,0);
					dtm.setColumnIdentifiers(columnNames);
					table.setModel(dtm);
					table.setEnabled(false);

					try {

						FileInputStream file = new FileInputStream("src/resources/recipes.txt"); 
						ObjectInputStream in = new ObjectInputStream(file); 
						ArrayList<Recept> recepti = new ArrayList<Recept>();
						// Method for deserialization of object
						try {
							recepti = (ArrayList<Recept>) in.readObject();
						} catch (IOException ex) {
						} catch (ClassNotFoundException ex) {
						}

						in.close();
						file.close();

						for(int i=0;i<recepti.size();i++) {
							if(s.equals("Sifra")) {
								if(recepti.get(i).getSifra() == Integer.parseInt(vrednost)) {
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
							}else if(s.equals("IdLekara")) {
								if(recepti.get(i).getIdLekara().toLowerCase().contains(vrednost.toLowerCase())) {
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
							} else if(s.equals("JMBG")) {
								if(recepti.get(i).getJmbgPacijenta().toLowerCase().contains(vrednost.toLowerCase())) {
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
							} else {
								
									String lekoviRecept = "";
									for (Lek lek: recepti.get(i).getLekovi().keySet()) {
									    lekoviRecept = lekoviRecept + lek.getSifra() + "(" + recepti.get(i).getLekovi().get(lek) + ") ";
									}
									if(lekoviRecept.toLowerCase().contains(vrednost.toLowerCase())) {
										if(recepti.get(i).isObrisan()) {
											if(frame.getUser().getTipKorisnika() == TipKorisnika.ADMINISTRATOR) {
												dtm.addRow(new Object[] { recepti.get(i).getSifra(), recepti.get(i).getIdLekara(), recepti.get(i).getJmbgPacijenta(), recepti.get(i).getDatum(), lekoviRecept ,recepti.get(i).getUkupnaCena(), recepti.get(i).isObrisan() });
											}
										} else {
											dtm.addRow(new Object[] { recepti.get(i).getSifra(), recepti.get(i).getIdLekara(), recepti.get(i).getJmbgPacijenta(), recepti.get(i).getDatum(), lekoviRecept ,recepti.get(i).getUkupnaCena(), recepti.get(i).isObrisan() });
										}
									}
							}
						}

					} catch (IOException o) {
						System.out.println("An error occurred.");
						o.printStackTrace();
					}

					JScrollPane sp = new JScrollPane(table);
					frame.getCentralni().removeAll();
					frame.getCentralni().add(sp, BorderLayout.CENTER);
					frame.validate();
					frame.repaint();
				}  
			});  

		}

	}
}
