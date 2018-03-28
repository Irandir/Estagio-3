package telas;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PreferenciaFrame extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PreferenciaFrame frame = new PreferenciaFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public PreferenciaFrame() {
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
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null},
				{null, null, null},
			},
			new String[] {
				"ID", "Disciplina", "Ano"
			}
		));
		scrollPane.setViewportView(table);
		
		JLabel lblNewLabel = new JLabel("ID:");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 11));
		lblNewLabel.setBounds(12, 50, 30, 14);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setEnabled(false);
		textField.setBounds(41, 46, 86, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setFont(new Font("Times New Roman", Font.BOLD, 11));
		lblNome.setBounds(144, 47, 44, 14);
		contentPane.add(lblNome);
		
		textField_1 = new JTextField();
		textField_1.setEnabled(false);
		textField_1.setColumns(10);
		textField_1.setBounds(201, 45, 313, 20);
		contentPane.add(textField_1);
		
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
		btnDeletar.setFont(new Font("Times New Roman", Font.BOLD, 11));
		btnDeletar.setBounds(311, 349, 89, 23);
		contentPane.add(btnDeletar);
		
		JButton btnAlterar = new JButton("Adicionar");
		btnAlterar.setFont(new Font("Times New Roman", Font.BOLD, 11));
		btnAlterar.setBounds(425, 349, 89, 23);
		contentPane.add(btnAlterar);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(91, 244, 163, 20);
		contentPane.add(comboBox);
		
		JLabel lblNewLabel_1 = new JLabel("Disciplina:");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 11));
		lblNewLabel_1.setBounds(20, 247, 107, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblAno = new JLabel("Ano:");
		lblAno.setFont(new Font("Times New Roman", Font.BOLD, 11));
		lblAno.setBounds(287, 247, 53, 14);
		contentPane.add(lblAno);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(351, 244, 163, 20);
		contentPane.add(comboBox_1);
		
		
	}
}
