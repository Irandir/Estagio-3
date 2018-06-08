package telas;

import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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

import algoritmo.genetico.AG;
import algoritmo.genetico.Individuo;
import model.Ano;
import model.Hora;
import javax.swing.JComboBox;

public class GradeDeHorarioFrame extends JFrame {

	private JPanel contentPane;
	//private JTable table;
	private JTable table_1;


	public GradeDeHorarioFrame(List<Ano> ano,Individuo individuo) {
		
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
					object[j2][j] = individuo.getGenes()[contInd].getDisciplina().getNome()+" \n"+individuo.getGenes()[contInd].getProfessor().getNome();
					contInd++;
				}
			}
			/*new Object[][] {
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
			}*/
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
		
		
		/*JScrollPane scrollPane = new JScrollPane();
		tabbedPane.addTab("2\u00B0 ano", null, scrollPane, null);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
			},
			new String[] {
				"Segunda", "Ter\u00E7a", "Quarta", "Quinta", "Sexta"
			}
		));
		scrollPane.setViewportView(table);*/
		
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
		
		JButton btnExportaExecel = new JButton("Exporta Execel");
		btnExportaExecel.setFont(new Font("Times New Roman", Font.BOLD, 11));
		btnExportaExecel.setBounds(396, 348, 119, 23);
		contentPane.add(btnExportaExecel);
		
		JButton btnConflitos = new JButton("Conflitos");
		btnConflitos.setFont(new Font("Times New Roman", Font.BOLD, 11));
		btnConflitos.setBounds(10, 35, 89, 23);
		contentPane.add(btnConflitos);
		
		JButton btnNewButton = new JButton("Busca");
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 11));
		btnNewButton.setBounds(426, 35, 89, 23);
		contentPane.add(btnNewButton);
		
		JLabel lblBusca = new JLabel("Busca Professores:");
		lblBusca.setFont(new Font("Times New Roman", Font.BOLD, 11));
		lblBusca.setBounds(169, 39, 129, 14);
		contentPane.add(lblBusca);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(270, 36, 146, 20);
		contentPane.add(comboBox);
	}
}
