package telas;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

import algoritmo.genetico.Individuo;
import algoritmo.genetico.Professor2;

public class ConflitoFrame3 extends JFrame {

	private JPanel contentPane;

	public ConflitoFrame3(List<Professor2> professor2, Individuo ind) {
		setResizable(false);
		setTitle("Professor Sem Hor\u00E1rio");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 342, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		List<String> nomes = new ArrayList<>();
		String string = "";
		// professor sem horario
		boolean exist = false;
		 for (int j = 0; j < professor2.size(); j++) {
			 exist = false;
			 loop:for (int i = 0; i < ind.getGenes().length; i++) {
				if (professor2.get(j).getNome().equals(ind.getGenes()[i].getProfessor().getNome())) {
					exist = true;
					break loop;
				}
			}
			if(exist == false){
				nomes.add(professor2.get(j).getNome());
			}
		}
		
		for (int i = 0; i < nomes.size(); i++) {
			string+=nomes.get(i)+"\n";
		}
		 
		contentPane.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(5, 5, 316, 245);
		contentPane.add(scrollPane);

		JTextArea txtrPronou = new JTextArea();
		scrollPane.setViewportView(txtrPronou);
		txtrPronou.setText(string);
	}

}
