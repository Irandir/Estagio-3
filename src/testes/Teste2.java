package testes;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.io.File;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;
import javax.swing.JList;
import javax.swing.AbstractListModel;
import javax.swing.JFileChooser;

public class Teste2 extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Teste2 frame = new Teste2();
					//frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Teste2() {
		
		JFileChooser fc = new JFileChooser();
		JTextArea log = new JTextArea();
		fc.showSaveDialog(Teste2.this);
		int i = JFileChooser.APPROVE_OPTION;
		File file = fc.getSelectedFile();
		System.out.println(file.getAbsolutePath());
		
		/*int returnVal = fc.showSaveDialog(Teste2.this);
		if (returnVal == JFileChooser.APPROVE_OPTION) {
			File file = fc.getSelectedFile();
			// This is where a real application would save the file.
			log.append("Saving: " + file.getName() + ".");
		} else {
			log.append("Save command cancelled by user." );
		}
		log.setCaretPosition(log.getDocument().getLength());*/
	}

}
