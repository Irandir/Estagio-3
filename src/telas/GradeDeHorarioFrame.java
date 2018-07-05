package telas;

import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
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
import export.ExportExcel2;
import model.Ano;

public class GradeDeHorarioFrame extends JFrame {

	private JPanel contentPane;
	private JTable table_1;
	private JComboBox comboBox;

	public GradeDeHorarioFrame(List<Professor2>professor2,List<Ano> ano,Individuo individuo) {
		setResizable(false);
		
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
		String[][][] grade = new String[ano.size()][6][6]; 
		String dia[] = new String[] {"Hora", "Segunda", "Ter\u00E7a", "Quarta", "Quinta", "Sexta"};
		
		for (int i = 0; i < scrollPane_1.length; i++) {
			scrollPane_1[i] = new JScrollPane();
			tabbedPane.addTab(ano.get(i).getNome(), null, scrollPane_1[i], null);
			table_1 = new JTable();
			//5 e 6--> hora e dia 
			object = new Object[5][6];
			contInd2 = contInd;
			for (int u = 0; u < dia.length; u++) {
				grade[i][0][u] = dia[u];
			}
			for (int j = 0; j < object.length; j++) {
				object[j][0] = individuo.getGenes()[contInd2].getHora().getHora();
				grade[i][j+1][0] = object[j][0].toString();
				contInd2++;
			}
			for (int j = 1; j < object[0].length; j++) {
				for (int j2 = 0; j2 < object.length; j2++) {
					object[j2][j] = individuo.getGenes()[contInd].getDisciplina().getNome()+" \n"+individuo.getGenes()[contInd].getProfessor().getNome();
					grade[i][j2+1][j] = object[j2][j].toString();
					contInd++;
				}
			}
	
			table_1.setModel(new DefaultTableModel(
				object,
				dia
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
		
		JButton btnExportaExecel = new JButton("Exporta Excel");
		btnExportaExecel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser fc = new JFileChooser();
				int i = fc.showSaveDialog(GradeDeHorarioFrame.this);
				if (i == JFileChooser.APPROVE_OPTION) {
					File file = fc.getSelectedFile();
					ExportExcel2 ee = new ExportExcel2();
					ee.expExcel(file.getAbsolutePath()+".xls", grade,ano);
				}
				
			}
		});
		btnExportaExecel.setFont(new Font("Times New Roman", Font.BOLD, 11));
		btnExportaExecel.setBounds(396, 348, 119, 23);
		contentPane.add(btnExportaExecel);
		
		JButton btnConflitos = new JButton("Conflitos");
		btnConflitos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ConflitoFrame conflitoFrame = new ConflitoFrame(professor2,individuo);
				ConflitoFrame2 conflitoFrame2 = new ConflitoFrame2(professor2,individuo);
				ConflitoFrame3 conflitoFrame3 = new ConflitoFrame3(professor2,individuo);
				conflitoFrame.setVisible(true);
				conflitoFrame2.setVisible(true);
				conflitoFrame3.setVisible(true);
			}
		});
		btnConflitos.setFont(new Font("Times New Roman", Font.BOLD, 11));
		btnConflitos.setBounds(10, 35, 89, 23);
		contentPane.add(btnConflitos);
		
		JButton btnNewButton = new JButton("Busca");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GradeDeHorarioBuscaFrame ghbf = new GradeDeHorarioBuscaFrame(ano, individuo,comboBox.getSelectedItem().toString(),professor2);
				ghbf.setVisible(true);
				dispose();
			}
		});
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 11));
		btnNewButton.setBounds(426, 35, 89, 23);
		contentPane.add(btnNewButton);
		
		JLabel lblBusca = new JLabel("Busca Professores:");
		lblBusca.setFont(new Font("Times New Roman", Font.BOLD, 11));
		lblBusca.setBounds(169, 39, 129, 14);
		contentPane.add(lblBusca);
		List<String> nomesAux = new ArrayList<>();
		for (int i = 0; i < individuo.getGenes().length; i++) {
			nomesAux.add(individuo.getGenes()[i].getProfessor().getNome());
		}
		List<String> nomes= new ArrayList<>();
		String aux = "";
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
		comboBox = new JComboBox(nomes.toArray());
		comboBox.setBounds(270, 36, 146, 20);
		contentPane.add(comboBox);
	}
}
