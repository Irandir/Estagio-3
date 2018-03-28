package telas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AnoFrame extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextField textField;
	private JLabel lblTurno;
	private JComboBox comboBox;
	private JButton btnNewButton;
	private JButton btnNewButton_1;
	private JButton btnDeletar;
	private JButton btnAlterar;
	private JButton btnAdicionar;
	private JPanel panel;
	private JLabel lblAno;

	
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
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null},
				{null, null, null},
			},
			new String[] {
				"ID", "Ano", "Turno"
			}
		));
		scrollPane.setViewportView(table);
		
		JLabel lblNomeDoAno = new JLabel("Nome do Ano:");
		lblNomeDoAno.setFont(new Font("Times New Roman", Font.BOLD, 11));
		lblNomeDoAno.setBounds(10, 39, 91, 14);
		contentPane.add(lblNomeDoAno);
		
		textField = new JTextField();
		textField.setBounds(128, 36, 387, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		lblTurno = new JLabel("Turno:");
		lblTurno.setFont(new Font("Times New Roman", Font.BOLD, 11));
		lblTurno.setBounds(12, 76, 46, 14);
		contentPane.add(lblTurno);
		
		comboBox = new JComboBox();
		comboBox.setEnabled(false);
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Matinal", "Vespertino", "Noturno"}));
		comboBox.setBounds(128, 70, 125, 20);
		contentPane.add(comboBox);
		
		btnNewButton = new JButton("Adicionar Disciplinas");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new AnoAddDisciplinaFrame().setVisible(true);
				dispose();
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
		btnDeletar.setFont(new Font("Times New Roman", Font.BOLD, 11));
		btnDeletar.setBounds(143, 349, 89, 23);
		contentPane.add(btnDeletar);
		
		btnAlterar = new JButton("Alterar");
		btnAlterar.setFont(new Font("Times New Roman", Font.BOLD, 11));
		btnAlterar.setBounds(279, 349, 89, 23);
		contentPane.add(btnAlterar);
		
		btnAdicionar = new JButton("Adicionar");
		btnAdicionar.setFont(new Font("Times New Roman", Font.BOLD, 11));
		btnAdicionar.setBounds(426, 349, 89, 23);
		contentPane.add(btnAdicionar);
	}
}
