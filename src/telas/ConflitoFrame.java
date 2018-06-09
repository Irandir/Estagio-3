package telas;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

import algoritmo.genetico.Individuo;
import algoritmo.genetico.Professor2;
import model.Dia;
import model.Hora;
import javax.swing.JScrollPane;

public class ConflitoFrame extends JFrame {

	private JPanel contentPane;

	public ConflitoFrame(List<Professor2> professor2,Individuo ind) {
		setResizable(false);
		setTitle("Hor\u00E1rio Indisponivel");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 342, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		List<Dia> dias;
		List<Hora> hora;
		String string = "";
		// indisponibilidade do prof
		for (int i = 0; i < ind.getGenes().length; i++) {
			for (int c = 0; c < professor2.size(); c++) {
				if (ind.getGenes()[i].getProfessor().getNome().equals(professor2.get(c).getNome())) {
					dias = professor2.get(c).getDia();
					hora = professor2.get(c).getHora();
					for (int j = 0; j < dias.size(); j++) {
						if (ind.getGenes()[i].getHora().getHora().equals(hora.get(j).getHora())
								&& ind.getGenes()[i].getDia().getDia().name().equals(dias.get(j).getDia().name())) {
							string += "Dia-->"+dias.get(j).getDia().name()+" Hora-->"+hora.get(j).getHora()+" prof-->"+professor2.get(c).getNome()+"\n";
						}
					}

				}
			}
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
