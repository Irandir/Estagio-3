package telas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.FlowLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.BoxLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.GridLayout;
import java.awt.CardLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import net.miginfocom.swing.MigLayout;
import testes.GerarHorarioFrame2;

public class MenuFrame extends JFrame {

	private JPanel contentPane;


	public MenuFrame() {
		setResizable(false);
		setTitle("Grade De Hor\u00E1rios");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 344, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 328, 30);
		contentPane.add(panel);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel lblMenu = new JLabel("Menu");
		panel.add(lblMenu);
		lblMenu.setFont(new Font("Times New Roman", Font.BOLD, 18));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(10, 41, 318, 219);
		contentPane.add(panel_1);
		
		JButton btnNewButton = new JButton("Professor");
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 11));
		btnNewButton.setBounds(98, 115, 121, 40);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new ProfessorFrame().setVisible(true);
				dispose();
			}
		});
		
		JButton btnAno = new JButton("Ano");
		btnAno.setFont(new Font("Times New Roman", Font.BOLD, 11));
		btnAno.setBounds(98, 62, 121, 40);
		btnAno.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new AnoFrame().setVisible(true);
				dispose();
			}
		});
		panel_1.setLayout(null);
		panel_1.add(btnNewButton);
		panel_1.add(btnAno);
		
		JButton btnGerarGrade = new JButton("Gerar Grade");
		btnGerarGrade.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new GerarHorarioFrame().setVisible(true);
				dispose();
			}
		});
		btnGerarGrade.setFont(new Font("Times New Roman", Font.BOLD, 11));
		btnGerarGrade.setBounds(98, 166, 121, 40);
		panel_1.add(btnGerarGrade);
		
		JButton btnDisciplina = new JButton("Disciplina");
		btnDisciplina.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new DisciplinasFrame().setVisible(true);
				dispose();
			}
		});
		btnDisciplina.setFont(new Font("Times New Roman", Font.BOLD, 11));
		btnDisciplina.setBounds(98, 11, 121, 40);
		panel_1.add(btnDisciplina);
	}
}
