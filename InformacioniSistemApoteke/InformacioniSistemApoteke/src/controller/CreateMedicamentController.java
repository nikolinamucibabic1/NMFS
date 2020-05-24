package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.AbstractAction;
import javax.swing.JOptionPane;

import model.Korisnik;
import model.Lek;
import view.MedicamentFrame;

public class CreateMedicamentController extends AbstractAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private MedicamentFrame medicamentFrame;

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		medicamentFrame = new MedicamentFrame("create");
		medicamentFrame.getKreiraj().addActionListener(new ActionListener(){  
			public void actionPerformed(ActionEvent e){
				Lek lek = new Lek();
				lek.setSifra(medicamentFrame.getTsifra().getText());
				lek.setIme(medicamentFrame.getTime().getText());
				lek.setProzivodjac(medicamentFrame.getTproizvodjac().getText());
				lek.setCena(Float.parseFloat(medicamentFrame.getTcena().getText()));
				lek.setRecept(medicamentFrame.getIzdavanje().isSelected());


				try{
					
					ArrayList<Lek> lekovi = new ArrayList<Lek>();
					FileInputStream file = new FileInputStream("src/resources/medicaments.txt");
					 
					ObjectInputStream in;
		                try {
		                	in = new ObjectInputStream(file);
		                	lekovi = (ArrayList<Lek>) in.readObject();
		                    in.close();
							file.close();
		                } catch (IOException ex) {

		                } catch (ClassNotFoundException ex) {
		                }
		            for(int i=0;i<lekovi.size();i++) {
		            	if(lekovi.get(i).getSifra().equals(lek.getSifra())) {
		            		JOptionPane.showMessageDialog(medicamentFrame, "Lek sa odabranim 'Sifra' vec postoji!");
							return;
		            	}
		            }
					lekovi.add(lek);
		            
					FileOutputStream fout = new FileOutputStream("src/resources/medicaments.txt");
					ObjectOutputStream oos;
					try {
						oos = new ObjectOutputStream(fout);
						oos.writeObject(lekovi);
					} catch (IOException e2) {
						// TODO Auto-generated catch block
						e2.printStackTrace();
					}

					medicamentFrame.dispose();
				} catch (FileNotFoundException o) {
					System.out.println("An error occurred.");
					o.printStackTrace();
				}
			}			
		});  
	}

}
