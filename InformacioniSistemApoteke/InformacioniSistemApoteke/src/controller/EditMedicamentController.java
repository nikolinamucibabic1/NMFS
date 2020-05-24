package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JOptionPane;

import model.Korisnik;
import model.Lek;
import model.TipKorisnika;
import view.MainFrame;
import view.MedicamentFrame;

public class EditMedicamentController extends AbstractAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private MedicamentFrame medicamentFrame;
	private Lek lek;
	public ArrayList<Lek> lekovi;

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		lek = new Lek();
		JButton btn = (JButton) e.getSource();
		MainFrame frame = (MainFrame) btn.getTopLevelAncestor();
		String s = (String)JOptionPane.showInputDialog(
				frame,
				"Ukucajte sifru leka koji zelite da izmenite:",
				"Izmena leka",
				JOptionPane.PLAIN_MESSAGE,
				null,
				null,
				null);

		if(s!=null) {
			try {
				
				FileInputStream file = new FileInputStream("src/resources/medicaments.txt"); 
				ObjectInputStream in = new ObjectInputStream(file); 
				lekovi = new ArrayList<Lek>();
				// Method for deserialization of object
				Korisnik korisnik;
				try {
					lekovi = (ArrayList<Lek>) in.readObject();
				} catch (IOException ex) {
				} catch (ClassNotFoundException ex) {
				}

				in.close();
				file.close();

				for(int i=0;i<lekovi.size();i++) {
					if(s.equals(lekovi.get(i).getSifra())) {
						if(lekovi.get(i).isObrisan()) {
							if(frame.getUser().getTipKorisnika() == TipKorisnika.ADMINISTRATOR) {
								lek.setSifra(s);
								lek.setIme(lekovi.get(i).getIme());
								lek.setProzivodjac(lekovi.get(i).getProzivodjac());
								lek.setRecept(lekovi.get(i).isRecept());
								lek.setCena(lekovi.get(i).getCena());
								medicamentFrame = new MedicamentFrame("edit");
								medicamentFrame.getTsifra().setText(lek.getSifra());
								medicamentFrame.getTsifra().setEditable(false);
								medicamentFrame.getTime().setText(lek.getIme());
								medicamentFrame.getTproizvodjac().setText(lek.getProzivodjac());
								medicamentFrame.getTcena().setText(String.valueOf(lek.getCena()));
								medicamentFrame.getIzdavanje().setSelected(lek.isRecept());
							} else {
								return;
							}		
						} else {
							lek.setSifra(s);
							lek.setIme(lekovi.get(i).getIme());
							lek.setProzivodjac(lekovi.get(i).getProzivodjac());
							lek.setRecept(lekovi.get(i).isRecept());
							lek.setCena(lekovi.get(i).getCena());
							medicamentFrame = new MedicamentFrame("edit");
							medicamentFrame.getTsifra().setText(lek.getSifra());
							medicamentFrame.getTsifra().setEditable(false);
							medicamentFrame.getTime().setText(lek.getIme());
							medicamentFrame.getTproizvodjac().setText(lek.getProzivodjac());
							medicamentFrame.getTcena().setText(String.valueOf(lek.getCena()));
							medicamentFrame.getIzdavanje().setSelected(lek.isRecept());
						}
						
					}
				}
			} catch (IOException o) {
				System.out.println("An error occurred.");
				o.printStackTrace();
			}

			medicamentFrame.getKreiraj().addActionListener(new ActionListener(){  
				public void actionPerformed(ActionEvent e){
					lek.setSifra(medicamentFrame.getTsifra().getText());
					lek.setIme(medicamentFrame.getTime().getText());
					lek.setProzivodjac(medicamentFrame.getTproizvodjac().getText());
					lek.setCena(Float.parseFloat(medicamentFrame.getTcena().getText()));
					lek.setRecept(medicamentFrame.getIzdavanje().isSelected());
					
					for(int i=0;i<lekovi.size();i++) {
						if(lek.getSifra().equals(lekovi.get(i).getSifra())) {
							lekovi.get(i).setSifra(lek.getSifra());
							lekovi.get(i).setIme(lek.getIme());
							lekovi.get(i).setProzivodjac(lek.getProzivodjac());
							lekovi.get(i).setRecept(lek.isRecept());
							lekovi.get(i).setCena(lek.getCena());
						}
					}
					
					FileOutputStream fout = null;
					try {
						fout = new FileOutputStream("src/resources/medicaments.txt");
					} catch (FileNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					ObjectOutputStream oos;
					try {
						oos = new ObjectOutputStream(fout);
						oos.writeObject(lekovi);
					} catch (IOException e2) {
						// TODO Auto-generated catch block
						e2.printStackTrace();
					}
					
					medicamentFrame.dispose();

				}			
			});  

		}

	}

}
