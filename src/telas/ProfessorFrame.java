package telas;

import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import hirbenate.DiaHoraHibernate;
import hirbenate.ProfessorHibernate;
import model.DiaHora;
import model.Professor;

public class ProfessorFrame extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextField textField;
	ProfessorHibernate professorHibernate = new ProfessorHibernate();
	
	public ProfessorFrame() {
		setTitle("Grade De Hor\u00E1rios");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 541, 422);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 535, 32);
		contentPane.add(panel);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel lblHorrio = new JLabel("Professor");
		lblHorrio.setFont(new Font("Times New Roman", Font.BOLD, 18));
		panel.add(lblHorrio);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 34, 515, 215);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				DefaultTableModel d = (DefaultTableModel) table.getModel();
				int id = Integer.parseInt(d.getValueAt(table.getSelectedRow(), 0) + "");
				Professor o = professorHibernate.read(id);
				textField.setText(o.getNome());

			}
		});
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
			}
		});
		table.setFont(new Font("Tahoma", Font.PLAIN, 11));
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null},
			},
			new String[] {
				"ID", "Nome"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		table.getColumnModel().getColumn(0).setResizable(false);
		table.getColumnModel().getColumn(0).setPreferredWidth(15);
		table.getColumnModel().getColumn(1).setResizable(false);
		scrollPane.setViewportView(table);
		
		select();
		
		JButton btnMenu = new JButton("Menu");
		btnMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new MenuFrame().setVisible(true);
				dispose();
			}
		});
		btnMenu.setFont(new Font("Times New Roman", Font.BOLD, 11));
		btnMenu.setBounds(10, 359, 89, 23);
		contentPane.add(btnMenu);
		
		JButton btnNewButton = new JButton("Adicionar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!textField.getText().equals("")) {
					Professor prof = new Professor(textField.getText());
					professorHibernate.insert(prof);
					select();
					textField.setText("");
				}
			}
		});
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 11));
		btnNewButton.setBounds(424, 359, 89, 23);
		contentPane.add(btnNewButton);
		
		JButton btnAtualizar = new JButton("Atualizar");
		btnAtualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultTableModel d = (DefaultTableModel) table.getModel();
				int id = -1;
				try {
					id = Integer.parseInt(d.getValueAt(table.getSelectedRow(), 0) + "");
				} catch (ArrayIndexOutOfBoundsException e2) {
					
				}

				if (id != -1) {

					Professor o = professorHibernate.read(id);
					o.setNome(textField.getText());
					professorHibernate.update(o);
					select();
					textField.setText("");
				}
			}
		});
		btnAtualizar.setFont(new Font("Times New Roman", Font.BOLD, 11));
		btnAtualizar.setBounds(283, 359, 89, 23);
		contentPane.add(btnAtualizar);
		
		JButton btnDeletar = new JButton("Deletar");
		btnDeletar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {
					DefaultTableModel d = (DefaultTableModel) table.getModel();
					int id = Integer.parseInt(d.getValueAt(table.getSelectedRow(), 0) + "");
					
					Professor o = professorHibernate.read(id);
					d.removeRow(table.getSelectedRow());
					professorHibernate.delete(o);
					textField.setText("");
					DiaHoraHibernate dihh = new DiaHoraHibernate();
					List<DiaHora> dih = dihh.recuperarPorNome(o.getId()+"");
					for (int i = 0; i < dih.size(); i++) {
						dihh.delete(dih.get(i));
					}
					
					select();
				} catch (ArrayIndexOutOfBoundsException e2) {
					// TODO: handle exception
				}
			}
		});
		btnDeletar.setFont(new Font("Times New Roman", Font.BOLD, 11));
		btnDeletar.setBounds(150, 359, 89, 23);
		contentPane.add(btnDeletar);
		
		JLabel lblNewLabel_1 = new JLabel("Nome Completo:");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 11));
		lblNewLabel_1.setBounds(26, 260, 94, 14);
		contentPane.add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBounds(132, 257, 381, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton_1 = new JButton("Prefer\u00EAncia de Disciplina");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultTableModel d = (DefaultTableModel) table.getModel();
				try {
					int id = Integer.parseInt(d.getValueAt(table.getSelectedRow(), 0) + "");
					Professor professor = new ProfessorHibernate().read(id);
					new PreferenciaFrame(professor).setVisible(true);
					dispose();
				} catch (ArrayIndexOutOfBoundsException e2) {
					// TODO: handle exception
					JOptionPane.showMessageDialog(null, "Selecione um professor");
				}
			}
		});
		btnNewButton_1.setFont(new Font("Times New Roman", Font.BOLD, 11));
		btnNewButton_1.setBounds(26, 285, 206, 23);
		contentPane.add(btnNewButton_1);
		
		JButton btnIndisponibilidadeDoProfessor = new JButton("Indisponibilidade do Professor");
		btnIndisponibilidadeDoProfessor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultTableModel d = (DefaultTableModel) table.getModel();
				try {
					int id = Integer.parseInt(d.getValueAt(table.getSelectedRow(), 0) + "");
					Professor professor = professorHibernate.read(id);
					new IndisponivelFrame(professor).setVisible(true);
					dispose();
				} catch (ArrayIndexOutOfBoundsException e2) {
					// TODO: handle exception
					JOptionPane.showMessageDialog(null, "Selecione um professor");
				}
				
			}
		});
		btnIndisponibilidadeDoProfessor.setFont(new Font("Times New Roman", Font.BOLD, 11));
		btnIndisponibilidadeDoProfessor.setBounds(307, 285, 206, 23);
		contentPane.add(btnIndisponibilidadeDoProfessor);
	}
	public void select() {
		DefaultTableModel d = (DefaultTableModel) table.getModel();
		List<Professor> professores = professorHibernate.recuperarTodos();
		d.setRowCount(0);
		for (int i = 0; i < professores.size(); i++) {
			String[] linha = { professores.get(i).getId() + "", professores.get(i).getNome()};
			d.addRow(linha);
		}
	}
}
