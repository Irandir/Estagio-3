package telas;

import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import hirbenate.AnoDisciplinaHibernate;
import hirbenate.AnoHibernate;
import hirbenate.DisciplinaHibernate;
import hirbenate.ProfessorDisciplinaAnoHibernate;
import model.Ano;
import model.AnoDisciplina;
import model.Disciplina;
import model.Professor;
import model.ProfessorDisciplinaAno;

public class PreferenciaFrame extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextField textField_Id;
	private JTextField textField_Nome;
	private JComboBox comboBox_1;
	private JComboBox comboBox;
	private List<Ano> anos = new AnoHibernate().recuperarTodos();
	private ProfessorDisciplinaAnoHibernate professorDisciplinaAnoHibernate = new ProfessorDisciplinaAnoHibernate();
	public PreferenciaFrame(Professor professor) {
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

		JLabel lblPrefernciaDeDisciplina = new JLabel("Prefer\u00EAncia de Disciplina");
		panel.add(lblPrefernciaDeDisciplina);
		lblPrefernciaDeDisciplina.setFont(new Font("Times New Roman", Font.BOLD, 18));

		table = new JTable();
		table.setModel(new DefaultTableModel(new Object[][] { { null, null, null }, { null, null, null }, },
				new String[] { "ID", "Disciplina", "Ano" }));
		scrollPane.setViewportView(table);

		select(professor);

		JLabel lblNewLabel = new JLabel("ID:");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 11));
		lblNewLabel.setBounds(12, 50, 30, 14);
		contentPane.add(lblNewLabel);

		textField_Id = new JTextField();
		textField_Id.setEnabled(false);
		textField_Id.setBounds(41, 46, 86, 20);
		contentPane.add(textField_Id);
		textField_Id.setColumns(10);

		JLabel lblNome = new JLabel("Nome:");
		lblNome.setFont(new Font("Times New Roman", Font.BOLD, 11));
		lblNome.setBounds(144, 47, 44, 14);
		contentPane.add(lblNome);

		textField_Nome = new JTextField();
		textField_Nome.setEnabled(false);
		textField_Nome.setColumns(10);
		textField_Nome.setBounds(201, 45, 313, 20);
		contentPane.add(textField_Nome);

		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new ProfessorFrame().setVisible(true);
				dispose();
			}
		});
		btnVoltar.setFont(new Font("Times New Roman", Font.BOLD, 11));
		btnVoltar.setBounds(10, 349, 89, 23);
		contentPane.add(btnVoltar);

		JButton btnDeletar = new JButton("Deletar");
		btnDeletar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultTableModel d = (DefaultTableModel) table.getModel();
				int id = Integer.parseInt(d.getValueAt(table.getSelectedRow(), 0) + "");
				
				ProfessorDisciplinaAno o = professorDisciplinaAnoHibernate.read(id);
				d.removeRow(table.getSelectedRow());
				professorDisciplinaAnoHibernate.delete(o);
				select(professor);
			}
		});
		btnDeletar.setFont(new Font("Times New Roman", Font.BOLD, 11));
		btnDeletar.setBounds(311, 349, 89, 23);
		contentPane.add(btnDeletar);

		JButton btnAlterar = new JButton("Adicionar");
		btnAlterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nomeDoAno = (String) comboBox.getSelectedItem();
				Ano ano = null;
				try {
					for (int i = 0; i < anos.size(); i++) {
						if (nomeDoAno.equals(anos.get(i).getNome())) {
							ano = anos.get(i);
							break;
						}
					}
					String nomeDaDisc = (String) comboBox_1.getSelectedItem();
					List<Disciplina> disciplinas = selecionarDis(ano);
					Disciplina disc = null;
					for (int i = 0; i < disciplinas.size(); i++) {
						if (disciplinas.get(i).getNome().equals(nomeDaDisc)) {
							disc = disciplinas.get(i);
							break;
						}
					}
					ProfessorDisciplinaAno professorDisciplinaAno = new ProfessorDisciplinaAno(professor.getId(),
							disc.getId(), ano.getId());

					new ProfessorDisciplinaAnoHibernate().insert(professorDisciplinaAno);
					select(professor);
				
				} catch (NullPointerException e2) {
					// TODO: handle exception
				}	
			}
		});
		btnAlterar.setFont(new Font("Times New Roman", Font.BOLD, 11));
		btnAlterar.setBounds(425, 349, 89, 23);
		contentPane.add(btnAlterar);

		comboBox = new JComboBox();
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nomeDoAno = (String) comboBox.getSelectedItem();
				Ano ano = null;
				for (int i = 0; i < anos.size(); i++) {
					if (nomeDoAno.equals(anos.get(i).getNome())) {
						ano = anos.get(i);
						break;
					}
				}

				List<Disciplina> disc = selecionarDis(ano);
				String disc_nome[] = new String[disc.size()];
				for (int i = 0; i < disc_nome.length; i++) {
					disc_nome[i] = disc.get(i).getNome();
				}

				if (!nomeDoAno.equals("")) {
					comboBox_1.setEnabled(true);
					comboBox_1.setModel(new DefaultComboBoxModel(disc_nome));

				} else {
					comboBox_1.setEnabled(false);
					comboBox_1.setModel(new DefaultComboBoxModel(disc_nome));
				}
			}
		});

		// int[] aux = selecionarAnos();
		String[] anos_nome = new String[anos.size() + 1];
		anos_nome[0] = "";
		for (int i = 0; i < anos.size(); i++) {
			anos_nome[i + 1] = anos.get(i).getNome();
		}
		comboBox.setModel(new DefaultComboBoxModel(anos_nome));
		comboBox.setBounds(60, 244, 163, 20);
		contentPane.add(comboBox);

		JLabel lblNewLabel_1 = new JLabel("Disciplina:");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 11));
		lblNewLabel_1.setBounds(260, 247, 107, 14);
		contentPane.add(lblNewLabel_1);

		JLabel lblAno = new JLabel("Ano:");
		lblAno.setFont(new Font("Times New Roman", Font.BOLD, 11));
		lblAno.setBounds(10, 247, 53, 14);
		contentPane.add(lblAno);

		comboBox_1 = new JComboBox();
		comboBox_1.setEnabled(false);

		comboBox_1.setBounds(351, 244, 163, 20);
		contentPane.add(comboBox_1);

		textField_Id.setText(professor.getId() + "");
		textField_Nome.setText(professor.getNome());
	}

	public List<Disciplina> selecionarDis(Ano ano) {
		List<Disciplina> r = new ArrayList<>();
		if (ano != null) {
			List<AnoDisciplina> anoDis = new AnoDisciplinaHibernate().recuperarPorNome(ano.getId() + "");
			List<Disciplina> discA = new DisciplinaHibernate().recuperarTodos();

			for (int i = 0; i < discA.size(); i++) {
				for (int j = 0; j < anoDis.size(); j++) {
					if (discA.get(i).getId() == anoDis.get(j).getDisciplina_id()) {
						r.add(discA.get(i));
					}
				}
			}
		}
		return r;
	}

	public void select(Professor professor) {
		DefaultTableModel d = (DefaultTableModel) table.getModel();
		List<ProfessorDisciplinaAno> ids = new ProfessorDisciplinaAnoHibernate()
				.recuperarPorNome(professor.getId() + "");
		d.setRowCount(0);
		AnoHibernate anoHibernate = new AnoHibernate();
		DisciplinaHibernate disciplinaHibernate = new DisciplinaHibernate();
		List<Ano> anos = new ArrayList<>();
		List<Disciplina> disciplinas = new ArrayList<>();
		for (int i = 0; i < ids.size(); i++) {
			anos.add(anoHibernate.read(ids.get(i).getAno_id()));
			disciplinas.add(disciplinaHibernate.read(ids.get(i).getDisc_id()));
		}
		for (int i = 0; i < ids.size(); i++) {
			String[] linha = { ids.get(i).getId() + "", disciplinas.get(i).getNome(), anos.get(i).getNome() };
			d.addRow(linha);
		}
	}
}
