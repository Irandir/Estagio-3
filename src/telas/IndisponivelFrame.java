package telas;

import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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

import hirbenate.AnoHibernate;
import hirbenate.DiaHibernate;
import hirbenate.DiaHoraHibernate;
import hirbenate.HoraHibernate;
import model.Ano;
import model.Dia;
import model.DiaHora;
import model.Hora;
import model.Professor;

public class IndisponivelFrame extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextField textField_id;
	private JTextField textField_nome;
	private JComboBox comboBox_Hora;
	private JComboBox comboBox_Dia;
	HoraHibernate horaHibernate = new HoraHibernate();

	public IndisponivelFrame(Professor professor) {
		setTitle("Grade De Hor\u00E1rios");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 541, 422);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 73, 504, 234);
		contentPane.add(scrollPane);

		JPanel panel = new JPanel();
		panel.setBounds(1, 1, 520, 30);
		contentPane.add(panel);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		JLabel lblPrefernciaDeDisciplina = new JLabel("Hora/Dia Indispon\u00EDvel");
		panel.add(lblPrefernciaDeDisciplina);
		lblPrefernciaDeDisciplina.setFont(new Font("Times New Roman", Font.BOLD, 18));

		table = new JTable();
		table.setRowSelectionAllowed(false);
		table.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "Hor\u00E1rio", "Segunda", "Ter\u00E7a", "Quarta", "Quinta", "Sexta" }) {
			boolean[] columnEditables = new boolean[] { false, false, false, false, false, false };

			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		table.getColumnModel().getColumn(0).setResizable(false);
		table.getColumnModel().getColumn(0).setMaxWidth(2147483646);
		table.getColumnModel().getColumn(1).setResizable(false);
		table.getColumnModel().getColumn(2).setResizable(false);
		table.getColumnModel().getColumn(3).setResizable(false);
		table.getColumnModel().getColumn(4).setResizable(false);
		table.getColumnModel().getColumn(5).setResizable(false);
		scrollPane.setViewportView(table);

		JLabel lblNewLabel = new JLabel("ID:");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 11));
		lblNewLabel.setBounds(12, 50, 30, 14);
		contentPane.add(lblNewLabel);

		textField_id = new JTextField();
		textField_id.setEnabled(false);
		textField_id.setBounds(41, 46, 86, 20);
		contentPane.add(textField_id);
		textField_id.setColumns(10);

		JLabel lblNome = new JLabel("Nome:");
		lblNome.setFont(new Font("Times New Roman", Font.BOLD, 11));
		lblNome.setBounds(144, 47, 44, 14);
		contentPane.add(lblNome);

		textField_nome = new JTextField();
		textField_nome.setEnabled(false);
		textField_nome.setColumns(10);
		textField_nome.setBounds(201, 45, 313, 20);
		contentPane.add(textField_nome);

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
				int i = comboBox_Dia.getSelectedIndex();
				int j = comboBox_Hora.getSelectedIndex();
				String hora = (String) comboBox_Hora.getSelectedItem();
				String dia = (String) comboBox_Dia.getSelectedItem();
				DefaultTableModel d = (DefaultTableModel) table.getModel();
				String s = (String) d.getValueAt(j, i + 1);
				if (s != "" || s != null) {
					d.setValueAt("", j, i + 1);
					HoraHibernate horaHibernate = new HoraHibernate();
					DiaHibernate diaImpossivelHibernate = new DiaHibernate();
					DiaHoraHibernate dihh = new DiaHoraHibernate();
					List<Hora> hora2 = horaHibernate.recuperarPorNome(hora);
					List<Dia> dia2 = diaImpossivelHibernate.recuperarPorNome(dia);
					List<DiaHora> dih = dihh.recuperarPorNome(professor.getId() + "");
					DiaHora diaImpossivelHora = new DiaHora();
					for (int k = 0; k < dih.size(); k++) {
						if (dih.get(k).getDia_id() == dia2.get(0).getId()
								&& dih.get(k).getHora_id() == hora2.get(0).getId()) {
							System.out.println("ENTROU_____________________________!!!");
							dihh.delete(dihh.read(dih.get(k).getId()));
						}

					}

				}
			}
		});
		btnDeletar.setFont(new Font("Times New Roman", Font.BOLD, 11));
		btnDeletar.setBounds(311, 349, 89, 23);
		contentPane.add(btnDeletar);

		JButton btnAlterar = new JButton("Adicionar");
		btnAlterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int i = comboBox_Dia.getSelectedIndex();
				int j = comboBox_Hora.getSelectedIndex();
				String h = (String) comboBox_Hora.getSelectedItem();
				String d2 = (String) comboBox_Dia.getSelectedItem();
				DefaultTableModel d = (DefaultTableModel) table.getModel();
				String s = (String) d.getValueAt(j, i + 1);
				if (s == "" || s == null) {
					d.setValueAt("indisponível", j, i + 1);
					HoraHibernate horaHibernate = new HoraHibernate();
					DiaHibernate diaImpossivelHibernate = new DiaHibernate();

					List<Hora> hora = horaHibernate.recuperarPorNome(h);
					List<Dia> diaImpossivel = diaImpossivelHibernate.recuperarPorNome(d2);
					DiaHoraHibernate dihh = new DiaHoraHibernate();
					DiaHora dih = new DiaHora(professor.getId(), diaImpossivel.get(0).getId(),
							hora.get(0).getId());
					dihh.insert(dih);
				}

			}
		});
		btnAlterar.setFont(new Font("Times New Roman", Font.BOLD, 11));
		btnAlterar.setBounds(425, 349, 89, 23);
		contentPane.add(btnAlterar);

		comboBox_Hora = new JComboBox();
		List<Hora> horas = horaHibernate.recuperarTodos();
		String horasString[] = new String[horas.size()];
		for (int i = 0; i < horasString.length; i++) {
			horasString[i] = horas.get(i).getHora();
		}
		comboBox_Hora.setModel(new DefaultComboBoxModel(horasString));
		comboBox_Hora.setBounds(93, 318, 163, 20);
		contentPane.add(comboBox_Hora);

		DefaultTableModel d = (DefaultTableModel) table.getModel();

		for (int i = 0; i < horasString.length; i++) {
			String[] linha = { horasString[i] + "" };
			d.addRow(linha);
		}

		select(professor);

		JLabel lblNewLabel_1 = new JLabel("Hora:");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 11));
		lblNewLabel_1.setBounds(12, 324, 107, 14);
		contentPane.add(lblNewLabel_1);

		JLabel lblAno = new JLabel("Dia:");
		lblAno.setFont(new Font("Times New Roman", Font.BOLD, 11));
		lblAno.setBounds(289, 321, 53, 14);
		contentPane.add(lblAno);

		comboBox_Dia = new JComboBox();
		comboBox_Dia.setModel(
				new DefaultComboBoxModel(new String[] { "Segunda", "Ter\u00E7a", "Quarta", "Quinta", "Sexta" }));
		comboBox_Dia.setBounds(351, 318, 163, 20);
		contentPane.add(comboBox_Dia);

		textField_nome.setText(professor.getNome());
		textField_id.setText(professor.getId() + "");
	}

	public void select(Professor professor) {

		DefaultTableModel d = (DefaultTableModel) table.getModel();
		// d.setRowCount(0);
		List<DiaHora> dIH = new DiaHoraHibernate().recuperarPorNome(professor.getId() + "");
		HoraHibernate horaHibernate = new HoraHibernate();
		DiaHibernate diaImpossivelHibernate = new DiaHibernate();
		Hora hora;
		Dia diaImpossivel;
		for (int i = 0; i < dIH.size(); i++) {
			hora = horaHibernate.read(dIH.get(i).getHora_id());
			diaImpossivel = diaImpossivelHibernate.read(dIH.get(i).getDiaImpossivel_id());
			for (int k = 1; k < d.getColumnCount(); k++) {
				int aux = d.getRowCount();
				for (int j = 0; j < d.getRowCount(); j++) {
					if (hora.getHora().equals(d.getValueAt(j, 0))
							&& diaImpossivel.getDia().toString().equals(d.getColumnName(k))) {
						// JOptionPane.showMessageDialog(null, "EITA");
						d.setValueAt("Indisponivel", j, k);
					}
				}
			}
		}

	}
}
