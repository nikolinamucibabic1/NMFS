package controller;

import java.awt.event.ActionEvent;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JOptionPane;

import model.Recept;
import view.MainFrame;

public class DeleteRecipeController extends AbstractAction{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		JButton btn = (JButton) e.getSource();
		MainFrame frame = (MainFrame) btn.getTopLevelAncestor();

		String s = (String)JOptionPane.showInputDialog(
				frame,
				"Ukucajte sifru recepta koji zelite da izbrisete:",
				"Brisanje recepta",
				JOptionPane.PLAIN_MESSAGE,
				null,
				null,
				null);
		
		if(s!=null) {
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
					if(Integer.parseInt(s) == recepti.get(i).getSifra()) {
						recepti.get(i).setObrisan(true);
					}
				}
				
				FileOutputStream fout = null;
				try {
					fout = new FileOutputStream("src/resources/recipes.txt");
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				ObjectOutputStream oos;
				try {
					oos = new ObjectOutputStream(fout);
					oos.writeObject(recepti);
				} catch (IOException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
				
			} catch (IOException o) {
				System.out.println("An error occurred.");
				o.printStackTrace();
			}
		}
	}

}
