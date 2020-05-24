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
import model.TipKorisnika;
import view.RegisterUserFrame;

public class RegisterUserController extends AbstractAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private RegisterUserFrame registerUserFrame;

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		registerUserFrame = new RegisterUserFrame();
		registerUserFrame.getKreiraj().addActionListener(new ActionListener(){  
			public void actionPerformed(ActionEvent e){
				TipKorisnika tip = null;
				if(registerUserFrame.getLekar().isSelected()) {
					tip = TipKorisnika.LEKAR;
				} else if(registerUserFrame.getApotekar().isSelected()) {
					tip = TipKorisnika.APOTEKAR;
				}else {
					tip = TipKorisnika.ADMINISTRATOR;
				}
				Korisnik korisnik = new Korisnik();
				korisnik.setKorisnickoIme(registerUserFrame.getTusername().getText());
				korisnik.setLozinka(registerUserFrame.getTlozinka().getText());
				korisnik.setIme(registerUserFrame.getTname().getText());
				korisnik.setPrezime(registerUserFrame.getTsurname().getText());
				korisnik.setTipKorisnika(tip);

				try{
					
					ArrayList<Korisnik> korisnici = new ArrayList<Korisnik>();
					FileInputStream file = new FileInputStream("src/resources/users.txt"); 
					ObjectInputStream in;
		                try {
		                	in = new ObjectInputStream(file);
		                    korisnici = (ArrayList<Korisnik>) in.readObject();
		                    in.close();
							file.close();
		                } catch (IOException ex) {

		                } catch (ClassNotFoundException ex) {
		                }
		            for(int i=0;i<korisnici.size();i++) {
		            	if(korisnici.get(i).getKorisnickoIme().equals(korisnik.getKorisnickoIme())) {
		            		JOptionPane.showMessageDialog(registerUserFrame, "Korisnik sa odabranim 'Korisnicko ime' vec postoji!");
							return;
		            	}
		            }
					
					korisnici.add(korisnik);
					FileOutputStream fout = new FileOutputStream("src/resources/users.txt");
					ObjectOutputStream oos;
					try {
						oos = new ObjectOutputStream(fout);
						oos.writeObject(korisnici);
					} catch (IOException e2) {
						// TODO Auto-generated catch block
						e2.printStackTrace();
					}

					registerUserFrame.dispose();
				} catch (IOException o) {
					System.out.println("An error occurred.");
					o.printStackTrace();
				}



			}			
		});  
	}

}
