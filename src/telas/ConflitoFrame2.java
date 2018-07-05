package telas;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

import algoritmo.genetico.Gene;
import algoritmo.genetico.Individuo;
import algoritmo.genetico.Professor2;
import model.Dia;
import model.Hora;
import javax.swing.JScrollPane;

public class ConflitoFrame2 extends JFrame {

	private JPanel contentPane;

	public ConflitoFrame2(List<Professor2> professor2, Individuo ind) {
		setResizable(false);
		setTitle("Choque de Hor\u00E1rio de Aulas");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 342, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		Gene gene;
		Gene gene2;
		String string = "";
		// colisao do mesmo dia/hora o professor ter duas(ou mais) disciplinas
		for (int i = 0; i < ind.getGenes().length - 1; i++) {
			gene = ind.getGenes()[i];
			for (int j = i; j < ind.getGenes().length - 1; j++) {
				gene2 = ind.getGenes()[j + 1];
				if (gene.getDia().toString().equals(gene2.getDia().toString())
						&& gene.getHora().getHora().equals(gene2.getHora().getHora())
						&& gene.getProfessor().getNome().equals(gene2.getProfessor().getNome())
						&& !gene.getProfessor().getNome().equals("")) {
						string += "Dia-->"+gene.getDia().toString()+" Hora-->"+gene.getHora().getHora()+" prof-->"+gene.getProfessor().getNome()+" ano-->"+gene.getAno().getNome()+"\n";
						string += "Dia-->"+gene2.getDia().toString()+" Hora-->"+gene2.getHora().getHora()+" prof-->"+gene2.getProfessor().getNome()+" ano-->"+gene2.getAno().getNome()+"\n";
						string +="______________________________________________\n";
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
