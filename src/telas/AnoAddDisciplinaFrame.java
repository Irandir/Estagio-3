package telas;

import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
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
import hirbenate.AnoHibernate;
import hirbenate.DisciplinaHibernate;
import model.Ano;
import model.AnoDisciplina;
import model.Disciplina;
import javax.swing.ListSelectionModel;

public class AnoAddDisciplinaFrame extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextField textField_IdAno;
	private JTextField textField_AnoNome;
	private DisciplinaHibernate disciplinaHibernate = new DisciplinaHibernate();
	private DefaultTableModel d;
	private JTextField textField_ID_Disciplina;
	private JTextField textField_NAulas;
	private List<Disciplina> todasDisciplinas;
	private JComboBox comboBox;

	public AnoAddDisciplinaFrame(Ano ano) {
		setTitle("Grade De Hor\u00E1rios");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 541, 422);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 73, 504, 159);
		contentPane.add(scrollPane);

		JPanel panel = new JPanel();
		panel.setBounds(1, 1, 520, 30);
		contentPane.add(panel);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		JLabel lblPrefernciaDeDisciplina = new JLabel("Disciplina do Ano/S\u00E9rie");
		panel.add(lblPrefernciaDeDisciplina);
		lblPrefernciaDeDisciplina.setFont(new Font("Times New Roman", Font.BOLD, 18));

		table = new JTable();
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setModel(
				new DefaultTableModel(new Object[][] {}, new String[] { "ID", "Disciplina", "N\u00BA de Aulas" }));
		scrollPane.setViewportView(table);

		select(ano);

		JLabel lblNewLabel = new JLabel("ID:");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 11));
		lblNewLabel.setBounds(12, 50, 30, 14);
		contentPane.add(lblNewLabel);

		textField_IdAno = new JTextField();
		textField_IdAno.setEnabled(false);
		textField_IdAno.setBounds(41, 46, 86, 20);
		contentPane.add(textField_IdAno);
		textField_IdAno.setColumns(10);

		JLabel lblNome = new JLabel("Ano:");
		lblNome.setFont(new Font("Times New Roman", Font.BOLD, 11));
		lblNome.setBounds(144, 47, 44, 14);
		contentPane.add(lblNome);

		textField_AnoNome = new JTextField();
		textField_AnoNome.setEnabled(false);
		textField_AnoNome.setColumns(10);
		textField_AnoNome.setBounds(201, 45, 313, 20);
		contentPane.add(textField_AnoNome);

		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new AnoFrame().setVisible(true);
				dispose();
			}
		});
		btnVoltar.setFont(new Font("Times New Roman", Font.BOLD, 11));
		btnVoltar.setBounds(10, 349, 89, 23);
		contentPane.add(btnVoltar);

		JButton btnDeletar = new JButton("Deletar");
		btnDeletar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					d = (DefaultTableModel) table.getModel();
					String a = d.getValueAt(table.getSelectedRow(), 0) + "";
					int id = Integer.parseInt(a);
					AnoDisciplinaHibernate anoDisciplinaHibernate = new AnoDisciplinaHibernate();
					AnoDisciplina o = new AnoDisciplinaHibernate().read(id);
					d.removeRow(table.getSelectedRow());
					anoDisciplinaHibernate.delete(o);
				} catch (ArrayIndexOutOfBoundsException e2) {

				}
			}
		});
		btnDeletar.setFont(new Font("Times New Roman", Font.BOLD, 11));
		btnDeletar.setBounds(311, 349, 89, 23);
		contentPane.add(btnDeletar);

		JButton btnAlterar = new JButton("Adicionar");
		btnAlterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				d = (DefaultTableModel) table.getModel();
				try {
					int disciplina_id = Integer.parseInt(textField_ID_Disciplina.getText());
					AnoDisciplina ad = new AnoDisciplina(ano.getId(), disciplina_id);
					AnoDisciplinaHibernate adh = new AnoDisciplinaHibernate();
					adh.insert(ad);
					select(ano);
				} catch (java.lang.NumberFormatException e2) {

				}
			}
		});
		btnAlterar.setFont(new Font("Times New Roman", Font.BOLD, 11));
		btnAlterar.setBounds(425, 349, 89, 23);
		contentPane.add(btnAlterar);

		comboBox = new JComboBox();

		comboBox.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				String a = comboBox.getSelectedItem().toString();
				int id = Integer.parseInt(a.split(" ")[0]);
				int n_aula = 0;
				for (int i = 0; i < todasDisciplinas.size(); i++) {
					if (id == todasDisciplinas.get(i).getId()) {
						n_aula = todasDisciplinas.get(i).getNumeroDeAulasSemanais();
					}
				}

				textField_ID_Disciplina.setText("" + id);
				textField_NAulas.setText(n_aula + "");
			}
		});
		comboBox.setBounds(91, 244, 163, 20);
		contentPane.add(comboBox);

		JLabel lblNewLabel_1 = new JLabel("Disciplina:");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 11));
		lblNewLabel_1.setBounds(20, 247, 107, 14);
		contentPane.add(lblNewLabel_1);

		JLabel label = new JLabel("ID:");
		label.setFont(new Font("Times New Roman", Font.BOLD, 11));
		label.setBounds(20, 284, 30, 14);
		contentPane.add(label);

		textField_ID_Disciplina = new JTextField();
		textField_ID_Disciplina.setEnabled(false);
		textField_ID_Disciplina.setColumns(10);
		textField_ID_Disciplina.setBounds(91, 281, 86, 20);
		contentPane.add(textField_ID_Disciplina);

		JLabel lblNAulas = new JLabel("N\u00BA aulas:");
		lblNAulas.setFont(new Font("Times New Roman", Font.BOLD, 11));
		lblNAulas.setBounds(298, 247, 55, 14);
		contentPane.add(lblNAulas);

		textField_NAulas = new JTextField();
		textField_NAulas.setEnabled(false);
		textField_NAulas.setColumns(10);
		textField_NAulas.setBounds(395, 244, 116, 20);
		contentPane.add(textField_NAulas);

		todasDisciplinas = disciplinaHibernate.recuperarTodos();
		String[] nomesDaDisciplina = new String[todasDisciplinas.size()];
		for (int i = 0; i < nomesDaDisciplina.length; i++) {
			nomesDaDisciplina[i] = todasDisciplinas.get(i).getId() + " " + todasDisciplinas.get(i).getNome();
		}
		comboBox.setModel(new DefaultComboBoxModel(nomesDaDisciplina));
		textField_AnoNome.setText(ano.getNome());
		textField_IdAno.setText(ano.getId() + "");
		try {
			int id = todasDisciplinas.get(0).getId();
			int n_aula = todasDisciplinas.get(0).getNumeroDeAulasSemanais();

			textField_ID_Disciplina.setText(id + "");
			textField_NAulas.setText(n_aula + "");

		} catch (ArrayIndexOutOfBoundsException e) {
			// TODO: handle exception
		} catch (java.lang.IndexOutOfBoundsException e2) {
			// JOptionPane.showMessageDialog(null, "");
		}
	}

	public void select(Ano ano) {
		DefaultTableModel d = (DefaultTableModel) table.getModel();
		DisciplinaHibernate disciplinaHibernate = new DisciplinaHibernate();
		List<AnoDisciplina> ano_disciplinas = new AnoDisciplinaHibernate().recuperarPorNome(ano.getId() + "");
		Disciplina disciplina;
		d.setRowCount(0);
		int v = 0;
		int v2 = 0;
		for (int i = 0; i < ano_disciplinas.size(); i++) {
			v = ano.getId();
			v2 = ano_disciplinas.get(i).getAno_id();
			if (v == v2) {
				disciplina = disciplinaHibernate.read(ano_disciplinas.get(i).getDisciplina_id());
				String[] linha = { ano_disciplinas.get(i).getId() + "", disciplina.getNome(),
						disciplina.getNumeroDeAulasSemanais() + "" };
				d.addRow(linha);
			}
		}

	}
}
