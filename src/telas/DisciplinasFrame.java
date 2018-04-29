package telas;

import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import hirbenate.AnoDisciplinaHibernate;
import hirbenate.DisciplinaHibernate;
import hirbenate.ProfessorDisciplinaAnoHibernate;
import model.AnoDisciplina;
import model.Disciplina;
import model.ProfessorDisciplinaAno;

import javax.swing.ListSelectionModel;

public class DisciplinasFrame extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextField nomeTextField;
	private JButton btnNewButton_1;
	private JButton btnDeletar;
	private JButton btnAlterar;
	private JButton btnAdicionar;
	private JPanel panel;
	private JLabel lblAno;
	private JTextField n_aulasTextField;
	private DisciplinaHibernate disciplinaHibernate = new DisciplinaHibernate(); 
	private DefaultTableModel d;
	private AnoDisciplinaHibernate anoDisciplinaHibernate = new AnoDisciplinaHibernate();
	private ProfessorDisciplinaAnoHibernate professorDisciplinaAnoHibernate = new ProfessorDisciplinaAnoHibernate();
	
	public DisciplinasFrame() {
		setTitle("Grade De Hor\u00E1rios");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 541, 422);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 86, 505, 225);
		contentPane.add(scrollPane);

		panel = new JPanel();
		panel.setBounds(0, 0, 525, 32);
		contentPane.add(panel);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		lblAno = new JLabel("Disciplina");
		lblAno.setFont(new Font("Times New Roman", Font.BOLD, 18));
		panel.add(lblAno);

		table = new JTable();
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				d = (DefaultTableModel) table.getModel();
				n_aulasTextField.setText(d.getValueAt(table.getSelectedRow(),2)+"");
				nomeTextField.setText(d.getValueAt(table.getSelectedRow(),1)+"");
			}
		});
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID", "Nome", "N\u00B0 de Aulas"
			}
		){  

			public boolean isCellEditable(int row, int col) {
				return false;
			}

		});
		table.getColumnModel().getColumn(0).setPreferredWidth(38);
		table.getColumnModel().getColumn(0).setMinWidth(5);
		table.getColumnModel().getColumn(0).setMaxWidth(2147483641);
		scrollPane.setViewportView(table);

		select();
		
		JLabel lblNomeDoAno = new JLabel("Nome da Disciplina:");
		lblNomeDoAno.setFont(new Font("Times New Roman", Font.BOLD, 11));
		lblNomeDoAno.setBounds(10, 58, 121, 14);
		contentPane.add(lblNomeDoAno);

		nomeTextField = new JTextField();
		nomeTextField.setBounds(141, 55, 192, 20);
		contentPane.add(nomeTextField);
		nomeTextField.setColumns(10);

		btnNewButton_1 = new JButton("Menu");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new MenuFrame().setVisible(true);
				dispose();
			}
		});
		btnNewButton_1.setFont(new Font("Times New Roman", Font.BOLD, 11));
		btnNewButton_1.setBounds(12, 349, 89, 23);
		contentPane.add(btnNewButton_1);

		btnDeletar = new JButton("Deletar");
		btnDeletar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				d = (DefaultTableModel) table.getModel();
				String id = d.getValueAt(table.getSelectedRow(), 0) + "";
				String n_aulas = n_aulasTextField.getText();
				String nome = nomeTextField.getText();
				Disciplina o = new Disciplina(nome,Integer.parseInt(n_aulas));
				o.setId(Integer.parseInt(id));
				d.removeRow(table.getSelectedRow());
				List<ProfessorDisciplinaAno> pdaAux = professorDisciplinaAnoHibernate.recuperarTodos();
				List<ProfessorDisciplinaAno> pda = new ArrayList<>();
				List<AnoDisciplina> adAux = anoDisciplinaHibernate.recuperarTodos();
				List<AnoDisciplina> ad  = new ArrayList<>();
				for (int i = 0; i < pdaAux.size(); i++) {
					if (pdaAux.get(i).getDisc_id() == o.getId()) {
						pda.add(pdaAux.get(i));
					}
				}
				for (int i = 0; i < adAux.size(); i++) {
					if (adAux.get(i).getDisciplina_id() == o.getId()) {
						ad.add(adAux.get(i));
					}
				}
				for (int j = 0; j < pda.size(); j++) {
					professorDisciplinaAnoHibernate.delete(pda.get(j));
				}
				for (int j = 0; j < ad.size(); j++) {
					anoDisciplinaHibernate.delete(ad.get(j));
				}
				disciplinaHibernate.delete(o);
			}
		});
		btnDeletar.setFont(new Font("Times New Roman", Font.BOLD, 11));
		btnDeletar.setBounds(143, 349, 89, 23);
		contentPane.add(btnDeletar);

		btnAlterar = new JButton("Alterar");
		btnAlterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				d = (DefaultTableModel) table.getModel();
				String id = d.getValueAt(table.getSelectedRow(), 0) + "";
				String n_aulas = n_aulasTextField.getText();
				String nome = nomeTextField.getText();
				//JOptionPane.showMessageDialog(null, id);
				if (id != null && n_aulas != null && nome != null) {
					Disciplina disciplina = disciplinaHibernate.read(Integer.parseInt(id));
					disciplina.setNome(nome);
					disciplina.setNumeroDeAulasSemanais(Integer.parseInt(n_aulas));
					disciplinaHibernate.update(disciplina);
					select();
				}
				
			}
		});
		btnAlterar.setFont(new Font("Times New Roman", Font.BOLD, 11));
		btnAlterar.setBounds(295, 349, 89, 23);
		contentPane.add(btnAlterar);

		btnAdicionar = new JButton("Adicionar");
		btnAdicionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nome = nomeTextField.getText().trim();
				String aula = n_aulasTextField.getText().trim();
				if (nome.equals("")) {
					JOptionPane.showMessageDialog(null, "Digite o nome da nova disciplina");
				}else if(aula.equals("")){
					JOptionPane.showMessageDialog(null, "Digite o numero de aulas");
				}else {
					
					Disciplina disciplina = new Disciplina(nome, Integer.parseInt(aula));
					disciplinaHibernate.insert(disciplina);
					select();
					nomeTextField.setText("");
					n_aulasTextField.setText("");
					nomeTextField.requestFocus();
				}
			}
		});
		btnAdicionar.setFont(new Font("Times New Roman", Font.BOLD, 11));
		btnAdicionar.setBounds(426, 349, 89, 23);
		contentPane.add(btnAdicionar);

		n_aulasTextField = new JTextField();
		n_aulasTextField.setBounds(426, 55, 86, 20);
		contentPane.add(n_aulasTextField);
		n_aulasTextField.setColumns(10);

		JLabel lblNPorAulas = new JLabel("N\u00BA por Aulas:");
		lblNPorAulas.setFont(new Font("Times New Roman", Font.BOLD, 11));
		lblNPorAulas.setBounds(343, 58, 73, 14);
		contentPane.add(lblNPorAulas);
	}
	
	public void select(){
		d = (DefaultTableModel) table.getModel();
		List<Disciplina> disciplinas = disciplinaHibernate.recuperarTodos();
		d.setRowCount(0);
		for (int i = 0; i < disciplinas.size(); i++) {
			String[]linha = {disciplinas.get(i).getId()+"", disciplinas.get(i).getNome(),""+disciplinas.get(i).getNumeroDeAulasSemanais()};
			d.addRow(linha);
		}
	}
}
