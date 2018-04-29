package telas;

import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;
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

import org.hibernate.sql.Select;

import hirbenate.AnoDisciplinaHibernate;
import hirbenate.AnoHibernate;
import hirbenate.ProfessorDisciplinaAnoHibernate;
import model.Ano;
import model.AnoDisciplina;
import model.Disciplina;
import model.ProfessorDisciplinaAno;
import model.Turno;
import javax.swing.ListSelectionModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class AnoFrame extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextField textFieldNomeAno;
	private JLabel lblTurno;
	private JComboBox comboBoxTurno;
	private JButton btnNewButton;
	private JButton btnNewButton_1;
	private JButton btnDeletar;
	private JButton btnAlterar;
	private JButton btnAdicionar;
	private JPanel panel;
	private JLabel lblAno;
	private AnoHibernate anoHibernate = new AnoHibernate();
	private AnoDisciplinaHibernate anoDisciplinaHibernate = new AnoDisciplinaHibernate();
	private ProfessorDisciplinaAnoHibernate professorDisciplinaAnoHibernate = new ProfessorDisciplinaAnoHibernate();
	public AnoFrame() {
		setTitle("Grade De Hor\u00E1rios");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 541, 422);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		panel = new JPanel();
		panel.setBounds(0, 0, 525, 32);
		contentPane.add(panel);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		lblAno = new JLabel("Ano");
		lblAno.setFont(new Font("Times New Roman", Font.BOLD, 18));
		panel.add(lblAno);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 101, 505, 210);
		contentPane.add(scrollPane);

		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				DefaultTableModel d = (DefaultTableModel) table.getModel();
				int id = Integer.parseInt(d.getValueAt(table.getSelectedRow(), 0) + "");
				Ano o = anoHibernate.read(id);
				textFieldNomeAno.setText(o.getNome());
				comboBoxTurno.setSelectedItem(o.getTurno().toString());

			}
		});
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setModel(new DefaultTableModel(new Object[][] { { null, null, null }, { null, null, null }, },
				new String[] { "ID", "Ano", "Turno" }));
		scrollPane.setViewportView(table);

		select();

		JLabel lblNomeDoAno = new JLabel("Nome do Ano:");
		lblNomeDoAno.setFont(new Font("Times New Roman", Font.BOLD, 11));
		lblNomeDoAno.setBounds(10, 39, 91, 14);
		contentPane.add(lblNomeDoAno);

		textFieldNomeAno = new JTextField();
		textFieldNomeAno.setBounds(128, 36, 387, 20);
		contentPane.add(textFieldNomeAno);
		textFieldNomeAno.setColumns(10);

		lblTurno = new JLabel("Turno:");
		lblTurno.setFont(new Font("Times New Roman", Font.BOLD, 11));
		lblTurno.setBounds(12, 76, 46, 14);
		contentPane.add(lblTurno);

		comboBoxTurno = new JComboBox();
		comboBoxTurno.setModel(new DefaultComboBoxModel(new String[] { "Matinal", "Vespertino", "Noturno" }));
		comboBoxTurno.setBounds(128, 70, 125, 20);
		contentPane.add(comboBoxTurno);

		btnNewButton = new JButton("Adicionar Disciplinas");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultTableModel d = (DefaultTableModel) table.getModel();
				try {
					int id = Integer.parseInt(d.getValueAt(table.getSelectedRow(), 0) + "");
					Ano ano = new AnoHibernate().read(id);
					new AnoAddDisciplinaFrame(ano).setVisible(true);
					dispose();
				} catch (ArrayIndexOutOfBoundsException e2) {
					// TODO: handle exception
					JOptionPane.showMessageDialog(null, "Selecione um ano");
				}
			}
		});
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 11));
		btnNewButton.setBounds(345, 67, 170, 23);
		contentPane.add(btnNewButton);

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
				DefaultTableModel d3 = (DefaultTableModel) table.getModel();
				try {
					int id = Integer.parseInt(d3.getValueAt(table.getSelectedRow(), 0) + "");
					Ano o = anoHibernate.read(id);
					List<ProfessorDisciplinaAno> pdaAux = professorDisciplinaAnoHibernate.recuperarTodos();
					List<ProfessorDisciplinaAno> pda = new ArrayList<>();
					List<AnoDisciplina> ad = anoDisciplinaHibernate.recuperarPorNome(o.getId()+"");
					for (int i = 0; i < pdaAux.size(); i++) {
						if (pdaAux.get(i).getAno_id() == o.getId()) {
							pda.add(pdaAux.get(i));
						}
					}
					
					d3.removeRow(table.getSelectedRow());
					//remove
					anoHibernate.delete(o);
					for (int j = 0; j < pda.size(); j++) {
						professorDisciplinaAnoHibernate.delete(pda.get(j));
					}
					for (int j = 0; j < ad.size(); j++) {
						anoDisciplinaHibernate.delete(ad.get(j));
					}
					textFieldNomeAno.setText("");
				} catch (ArrayIndexOutOfBoundsException e2) {
					// TODO: handle exception
				}
			}
		});
		btnDeletar.setFont(new Font("Times New Roman", Font.BOLD, 11));
		btnDeletar.setBounds(143, 349, 89, 23);
		contentPane.add(btnDeletar);

		btnAlterar = new JButton("Alterar");
		btnAlterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultTableModel d = (DefaultTableModel) table.getModel();
				int id = -1;
				try {
					id = Integer.parseInt(d.getValueAt(table.getSelectedRow(), 0) + "");
				} catch (ArrayIndexOutOfBoundsException e2) {
					
				}

				if (id != -1) {

					Ano o = anoHibernate.read(id);
					o.setNome(textFieldNomeAno.getText());
					Turno turnos[] = Turno.values();
					int indice = -1;
					for (int i = 0; i < turnos.length; i++) {
						if (turnos[i].toString().equals(comboBoxTurno.getSelectedItem().toString())) {
							indice = i;
						}
					}
					o.setTurno(turnos[indice]);
					anoHibernate.update(o);
					select();
					textFieldNomeAno.setText("");
				}
			}
		});
		btnAlterar.setFont(new Font("Times New Roman", Font.BOLD, 11));
		btnAlterar.setBounds(279, 349, 89, 23);
		contentPane.add(btnAlterar);

		btnAdicionar = new JButton("Adicionar");
		btnAdicionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!textFieldNomeAno.getText().equals("")) {
					String turnoA = (String) comboBoxTurno.getSelectedItem();
					Turno turno = null;
					Turno[] lista = Turno.values();
					for (int i = 0; i < lista.length; i++) {
						if (lista[i].toString().equals(turnoA)) {
							turno = lista[i];
						}
					}
					Ano ano = new Ano(textFieldNomeAno.getText(), turno);
					anoHibernate.insert(ano);
					select();
					textFieldNomeAno.setText("");
				}

			}
		});
		btnAdicionar.setFont(new Font("Times New Roman", Font.BOLD, 11));
		btnAdicionar.setBounds(426, 349, 89, 23);
		contentPane.add(btnAdicionar);
	}

	public void select() {
		DefaultTableModel d = (DefaultTableModel) table.getModel();
		List<Ano> anos = new AnoHibernate().recuperarTodos();
		d.setRowCount(0);
		for (int i = 0; i < anos.size(); i++) {
			String[] linha = { anos.get(i).getId() + "", anos.get(i).getNome(), anos.get(i).getTurno() + "" };
			d.addRow(linha);
		}
	}
}
