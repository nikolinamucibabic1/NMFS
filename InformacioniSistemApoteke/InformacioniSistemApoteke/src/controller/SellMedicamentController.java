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
import java.util.ArrayList;
import java.util.Map;

import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JOptionPane;

import model.Korisnik;
import model.Lek;
import model.Recept;
import model.Transakcija;
import view.MainFrame;
import view.SellMedicament;
import view.SellMedicamentRecipe;

public class SellMedicamentController extends AbstractAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public ArrayList<Lek> lekovi = null;
	public ArrayList<Recept> recepti = null;
	public ArrayList<Transakcija> transakcije = null;

	@SuppressWarnings("unchecked")
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		JButton btn = (JButton) arg0.getSource();
		MainFrame frame = (MainFrame) btn.getTopLevelAncestor();

		Object[] possibilities = {"Sifra leka", "Recept"};
		String s = (String)JOptionPane.showInputDialog(
				frame,
				"Odaberite nacin prodaje lekova:",
				"Prodaja lekova",
				JOptionPane.PLAIN_MESSAGE,
				null,
				possibilities,
				"Sifra leka");
		
		try {
			File fileName = new File("src/resources/transactions.txt");
			if (fileName.length() == 0) {
				transakcije = new ArrayList<>();
			} else {
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
		
		if(s!=null) {
			if(s.equals("Sifra leka")) {
			try {
				FileInputStream file = new FileInputStream("src/resources/medicaments.txt"); 
				ObjectInputStream in = new ObjectInputStream(file); 
				lekovi = new ArrayList<Lek>();
				// Method for deserialization of object
				try {
					lekovi = (ArrayList<Lek>) in.readObject();
				} catch (IOException ex) {
				} catch (ClassNotFoundException ex) {
				}

				in.close();
				file.close();

			} catch (IOException o) {
				System.out.println("An error occurred.");
				o.printStackTrace();
			}
			SellMedicament sellMedicament = new SellMedicament(lekovi);
			sellMedicament.getKreiraj().addActionListener(new ActionListener(){  
				public void actionPerformed(ActionEvent e){
					Korisnik k = MainFrame.getInstance().getUser();
					Transakcija t = new Transakcija();
					t.setKolicina(Integer.parseInt(sellMedicament.getTkolicina().getText()));
					t.setApotekar(k);
					t.setSifraLeka(sellMedicament.getComboBox().getSelectedItem().toString());
					for(int j=0;j<lekovi.size();j++) {
						if(t.getSifraLeka().equals(lekovi.get(j).getSifra())) {
							t.setCena(lekovi.get(j).getCena() * t.getKolicina());
							t.setProizvodjac(lekovi.get(j).getProzivodjac());
						}
					}
					try {
						FileInputStream file = new FileInputStream("src/resources/medicaments.txt"); 
						ObjectInputStream in = new ObjectInputStream(file); 
						ArrayList<Lek> lekovi = new ArrayList<Lek>();
						// Method for deserialization of object
						try {
							lekovi = (ArrayList<Lek>) in.readObject();
						} catch (IOException ex) {
						} catch (ClassNotFoundException ex) {
						}

						in.close();
						file.close();

						for(int i=0;i<lekovi.size();i++) {
							if(t.getSifraLeka().equals(lekovi.get(i).getSifra())) {
								if(lekovi.get(i).isRecept()) {
									JOptionPane.showMessageDialog(sellMedicament, "Lek se prodaje samo uz recept!");
									return;
								}
							}
						}
					} catch (IOException o) {
						System.out.println("An error occurred.");
						o.printStackTrace();
					}
					//transakcije = new ArrayList<>();
					boolean flag = true;
					if(transakcije.size()==0) {
						transakcije.add(t);
					} else{
						for(int r=0;r<transakcije.size();r++) {
							if(transakcije.get(r).getSifraLeka().equals(t.getSifraLeka())) {
								int kol = transakcije.get(r).getKolicina();
								float cena = transakcije.get(r).getCena();
								transakcije.get(r).setKolicina(kol + t.getKolicina());
								transakcije.get(r).setCena(cena + t.getCena());
								flag = false;
							} 
						}
						
						if(flag) {
							transakcije.add(t);
						}
					}
					
					
					try {
						FileOutputStream fout = new FileOutputStream("src/resources/transactions.txt");
						ObjectOutputStream oos;
						try {
							oos = new ObjectOutputStream(fout);
							oos.writeObject(transakcije);
						} catch (IOException e2) {
							// TODO Auto-generated catch block
							e2.printStackTrace();
						}
					} catch (FileNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					sellMedicament.getTkolicina().setText("");
				}
			});
			} else {
				try {
					FileInputStream file = new FileInputStream("src/resources/recipes.txt"); 
					ObjectInputStream in = new ObjectInputStream(file); 
					recepti = new ArrayList<Recept>();
					// Method for deserialization of object
					try {
						recepti = (ArrayList<Recept>) in.readObject();
					} catch (IOException ex) {
					} catch (ClassNotFoundException ex) {
					}

					in.close();
					file.close();

				} catch (IOException o) {
					System.out.println("An error occurred.");
					o.printStackTrace();
				}
				try {
					FileInputStream file = new FileInputStream("src/resources/medicaments.txt"); 
					ObjectInputStream in = new ObjectInputStream(file); 
					lekovi = new ArrayList<Lek>();
					// Method for deserialization of object
					try {
						lekovi = (ArrayList<Lek>) in.readObject();
					} catch (IOException ex) {
					} catch (ClassNotFoundException ex) {
					}

					in.close();
					file.close();

				} catch (IOException o) {
					System.out.println("An error occurred.");
					o.printStackTrace();
				}
				//transakcije = new ArrayList<>();
				SellMedicamentRecipe sellMedicamentRecipe = new SellMedicamentRecipe(recepti);
				sellMedicamentRecipe.getKreiraj().addActionListener(new ActionListener(){  
					public void actionPerformed(ActionEvent e){
						ObjectInputStream in;
						try {
							FileInputStream file = new FileInputStream("src/resources/recipes.txt"); 
							in = new ObjectInputStream(file); 
							ArrayList<Recept> recepti = new ArrayList<Recept>();
							// Method for deserialization of object
							Korisnik korisnik;
							try {
								recepti = (ArrayList<Recept>) in.readObject();
							} catch (IOException ex) {
							} catch (ClassNotFoundException ex) {
							}

							in.close();
							file.close();

							for(int i=0;i<recepti.size();i++) {
								if(Integer.parseInt(sellMedicamentRecipe.getComboBox().getSelectedItem().toString()) == recepti.get(i).getSifra()) {
									Korisnik k = MainFrame.getInstance().getUser();
									for (Map.Entry lek : recepti.get(i).getLekovi().entrySet()) {
								          Transakcija t = new Transakcija();
								         
								          Lek lekNovi = (Lek) lek.getKey();
								          Integer kolicina = (Integer) lek.getValue();
										  t.setKolicina(kolicina);
										  t.setApotekar(k);
										  t.setSifraLeka(lekNovi.getSifra());
										  for(int j=0;j<lekovi.size();j++) {
												if(t.getSifraLeka().equals(lekovi.get(j).getSifra())) {
													t.setCena(lekovi.get(j).getCena() * t.getKolicina());
													t.setProizvodjac(lekovi.get(j).getProzivodjac());
												}
										  }
										  boolean flag = true;
											if(transakcije.size()==0) {
												transakcije.add(t);
											} else {
												for(int r=0;r<transakcije.size();r++) {
													if(transakcije.get(r).getSifraLeka().equals(t.getSifraLeka())) {
														int kol = transakcije.get(r).getKolicina();
														float cena = transakcije.get(r).getCena();
														transakcije.get(r).setKolicina(kol + t.getKolicina());
														transakcije.get(r).setCena(cena + t.getCena());
														flag = false;
													} 
												}
												
												if(flag) {
													transakcije.add(t);
												}
											}
								    }
									
								}
							}
						} catch (IOException o ) {
							System.out.println("An error occurred.");
							o.printStackTrace();
						}
						try {
							FileOutputStream fout = new FileOutputStream("src/resources/transactions.txt");
							ObjectOutputStream oos;
							try {
								oos = new ObjectOutputStream(fout);
								oos.writeObject(transakcije);
							} catch (IOException e2) {
								// TODO Auto-generated catch block
								e2.printStackTrace();
							}
						} catch (FileNotFoundException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
				});
			}
		}
	}

}
