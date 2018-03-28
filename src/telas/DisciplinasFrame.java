package telas;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class DisciplinasFrame extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextField textField;
	private JButton btnNewButton_1;
	private JButton btnDeletar;
	private JButton btnAlterar;
	private JButton btnAdicionar;
	private JPanel panel;
	private JLabel lblAno;
	private JTextField textField_1;

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
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				DefaultTableModel d = (DefaultTableModel)table.getModel();
				
				JOptionPane.showMessageDialog(null, d.getValueAt(table.getSelectedRow(), 1));
			}
		});
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID", "Nome"
			}
		));
		table.getColumnModel().getColumn(0).setPreferredWidth(15);
		table.getColumnModel().getColumn(0).setMinWidth(5);
		table.getColumnModel().getColumn(0).setMaxWidth(2147483641);
		scrollPane.setViewportView(table);
		
		JLabel lblNomeDoAno = new JLabel("Nome da Disciplina:");
		lblNomeDoAno.setFont(new Font("Times New Roman", Font.BOLD, 11));
		lblNomeDoAno.setBounds(10, 58, 121, 14);
		contentPane.add(lblNomeDoAno);
		
		textField = new JTextField();
		textField.setBounds(141, 55, 192, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
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
				DefaultTableModel d = (DefaultTableModel)table.getModel();
				d.removeRow(table.getSelectedRow());
			}
		});
		btnDeletar.setFont(new Font("Times New Roman", Font.BOLD, 11));
		btnDeletar.setBounds(143, 349, 89, 23);
		contentPane.add(btnDeletar);
		
		btnAlterar = new JButton("Alterar");
		btnAlterar.setFont(new Font("Times New Roman", Font.BOLD, 11));
		btnAlterar.setBounds(295, 349, 89, 23);
		contentPane.add(btnAlterar);
		
		btnAdicionar = new JButton("Adicionar");
		btnAdicionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nome = textField.getText().trim();
				if(nome.equals("")){
					JOptionPane.showMessageDialog(null, "Digite o nome da nova disciplina");
				}else{
				DefaultTableModel d = (DefaultTableModel)table.getModel();
				
				String[] linha = {"",nome};
				d.addRow(linha);
				textField.setText("");
				textField.requestFocus();
				}
			}
		});
		btnAdicionar.setFont(new Font("Times New Roman", Font.BOLD, 11));
		btnAdicionar.setBounds(426, 349, 89, 23);
		contentPane.add(btnAdicionar);
		
		textField_1 = new JTextField();
		textField_1.setBounds(426, 55, 86, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNPorAulas = new JLabel("N\u00BA por Aulas:");
		lblNPorAulas.setFont(new Font("Times New Roman", Font.BOLD, 11));
		lblNPorAulas.setBounds(343, 58, 73, 14);
		contentPane.add(lblNPorAulas);
	}
}
