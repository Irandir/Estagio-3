package telas;

import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import algoritmo.genetico.Individuo;
import algoritmo.genetico.Professor2;
import model.Ano;

public class GradeDeHorarioBuscaFrame extends JFrame {

	private JPanel contentPane;
	private JTable table_1;

	public GradeDeHorarioBuscaFrame(List<Ano> ano,Individuo individuo,String nome,List<Professor2>professor2) {
		
		setTitle("Grade de Hor\u00E1rio");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 541, 422);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 525, 32);
		contentPane.add(panel);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel lblHorrio = new JLabel("Grade de Hor\u00E1rio");
		lblHorrio.setFont(new Font("Times New Roman", Font.BOLD, 18));
		panel.add(lblHorrio);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setToolTipText("1\u00B0\r\n2\u00B0");
		tabbedPane.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);

		tabbedPane.setBounds(10, 64, 505, 273);
		contentPane.add(tabbedPane);
		
		JScrollPane scrollPane_1[] = new JScrollPane[ano.size()];
		Object[][] object;
		int contInd = 0;
		int contInd2 = 0;
		for (int i = 0; i < scrollPane_1.length; i++) {
			scrollPane_1[i] = new JScrollPane();
			tabbedPane.addTab(ano.get(i).getNome(), null, scrollPane_1[i], null);
			table_1 = new JTable();
			//5 e 6--> hora e dia 
			object = new Object[5][6];
			contInd2 = contInd;
			for (int j = 0; j < object.length; j++) {
				object[j][0] = individuo.getGenes()[contInd2].getHora().getHora();
				contInd2++;
			}
			for (int j = 1; j < object[0].length; j++) {
				for (int j2 = 0; j2 < object.length; j2++) {
					if(individuo.getGenes()[contInd].getProfessor().getNome().equals(nome)){
						object[j2][j] = individuo.getGenes()[contInd].getDisciplina().getNome()+" \n"+individuo.getGenes()[contInd].getProfessor().getNome();
					}else{
						object[j2][j] ="";
					}
					contInd++;
				}
			}
			table_1.setModel(new DefaultTableModel(
				object,
				new String[] {
					"Hora", "Segunda", "Ter\u00E7a", "Quarta", "Quinta", "Sexta"
				}
			));
			TableColumn col;
			for (int j = 0; j < table_1.getColumnCount(); j++) {  
	            col = table_1.getColumnModel().getColumn(j);  
	            col.setCellRenderer(new TextAreaCellRenderer());  
	        }
			scrollPane_1[i].setViewportView(table_1);
		}
		
		
		JButton btnMenu = new JButton("Menu");
		btnMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MenuFrame menu = new MenuFrame();
				menu.setLocationRelativeTo(null);
				menu.setVisible(true);
				dispose();
			}
		});
		btnMenu.setFont(new Font("Times New Roman", Font.BOLD, 11));
		btnMenu.setBounds(10, 348, 89, 23);
		contentPane.add(btnMenu);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GradeDeHorarioFrame gdhf = new GradeDeHorarioFrame(professor2,ano, individuo);
				gdhf.setVisible(true);
				dispose();
			}
		});
		btnVoltar.setFont(new Font("Times New Roman", Font.BOLD, 11));
		btnVoltar.setBounds(109, 348, 89, 23);
		contentPane.add(btnVoltar);
		List<String> nomesAux = new ArrayList<>();
		for (int i = 0; i < individuo.getGenes().length; i++) {
			nomesAux.add(individuo.getGenes()[i].getProfessor().getNome());
		}
		List<String> nomes= new ArrayList<>();
		loop:for (int i = 0; i < nomesAux.size(); i++) {
			if (nomesAux.get(i).equals("")) {
				continue;
			}
			for (int j = 0; j < nomes.size(); j++) {
				if (nomesAux.get(i).equals(nomes.get(j))) {
					continue loop;
				}
			}
			nomes.add(nomesAux.get(i));
		}
	}
}
