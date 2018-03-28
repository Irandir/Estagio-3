package telas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JSpinner;
import javax.swing.JList;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ProfessorFrame extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextField textField;

	
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
				
			}
		});
		table.setFont(new Font("Times New Roman", Font.PLAIN, 11));
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
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 11));
		btnNewButton.setBounds(424, 359, 89, 23);
		contentPane.add(btnNewButton);
		
		JButton btnAtualizar = new JButton("Atualizar");
		btnAtualizar.setFont(new Font("Times New Roman", Font.BOLD, 11));
		btnAtualizar.setBounds(283, 359, 89, 23);
		contentPane.add(btnAtualizar);
		
		JButton btnDeletar = new JButton("Deletar");
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
				new PreferenciaFrame().setVisible(true);
				dispose();
			}
		});
		btnNewButton_1.setFont(new Font("Times New Roman", Font.BOLD, 11));
		btnNewButton_1.setBounds(26, 285, 206, 23);
		contentPane.add(btnNewButton_1);
		
		JButton btnIndisponibilidadeDoProfessor = new JButton("Indisponibilidade do Professor");
		btnIndisponibilidadeDoProfessor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new IndisponivelFrame().setVisible(true);
				dispose();
			}
		});
		btnIndisponibilidadeDoProfessor.setFont(new Font("Times New Roman", Font.BOLD, 11));
		btnIndisponibilidadeDoProfessor.setBounds(307, 285, 206, 23);
		contentPane.add(btnIndisponibilidadeDoProfessor);
	}
}
