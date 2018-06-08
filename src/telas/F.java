package telas;

import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import algoritmo.genetico.AG;
import algoritmo.genetico.FormatDados;
import algoritmo.genetico.Individuo;
import hirbenate.AnoDisciplinaHibernate;
import hirbenate.AnoHibernate;
import hirbenate.DiaHibernate;
import hirbenate.DiaHoraHibernate;
import hirbenate.DisciplinaHibernate;
import hirbenate.HoraHibernate;
import hirbenate.ProfessorDisciplinaAnoHibernate;
import hirbenate.ProfessorHibernate;
import model.Ano;
import model.AnoDisciplina;
import model.Dia;
import model.DiaHora;
import model.Disciplina;
import model.Hora;
import model.Professor;
import model.ProfessorDisciplinaAno;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.ImageIcon;

public class F extends JFrame {

	private JPanel contentPane;

	public F() {
		setBackground(Color.BLUE);
		setResizable(false);
		setTitle("Grade De Hor\u00E1rios");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 494, 30);
		contentPane.add(panel);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel lblMenu = new JLabel("Menu");
		panel.add(lblMenu);
		lblMenu.setFont(new Font("Times New Roman", Font.BOLD, 18));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 255, 255));
		panel_1.setBounds(0, 31, 494, 329);
		contentPane.add(panel_1);
		
		JButton btnNewButton = new JButton("Professor");
		btnNewButton.setIcon(new ImageIcon("C:\\Users\\Irandir\\Desktop\\icons\\user_accounts_15362.png"));
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 11));
		btnNewButton.setBounds(179, 164, 121, 40);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new ProfessorFrame().setVisible(true);
				dispose();
			}
		});
		
		JButton btnAno = new JButton("Ano");
		btnAno.setFont(new Font("Times New Roman", Font.BOLD, 11));
		btnAno.setBounds(179, 91, 121, 40);
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
				List<Hora>horas = new HoraHibernate().recuperarTodos();
				List<Dia>dias = new DiaHibernate().recuperarTodos();
				List<AnoDisciplina> ad = new AnoDisciplinaHibernate().recuperarTodos();
				List<Disciplina> disci = new DisciplinaHibernate().recuperarTodos();
				List<Ano> ano = new AnoHibernate().recuperarTodos();
				List<DiaHora> dih = new DiaHoraHibernate().recuperarTodos();
				List<ProfessorDisciplinaAno> pda = new ProfessorDisciplinaAnoHibernate().recuperarTodos();
				List<Professor> professor = new ProfessorHibernate().recuperarTodos();
				//new GerarHorarioFrame().setVisible(true);
				//dispose();
				FormatDados fd = new FormatDados(horas, dias, disci, ano, professor, ad, dih, pda);
				AG ag = new AG(fd.getAno2(),fd.getProfessor2(), horas, dias, disci);

				try{
					Individuo[] populacao = ag.gerandoPopulacao(100);
					int indice[] = new int[populacao.length];
					double fitness[] = new double[populacao.length];
					System.out.println("________fitness________");
					Individuo[] populacao = ag.gerandoPopulacao(100);
					int indice[] = new int[populacao.length];
					double fitness[] = new double[populacao.length];
					System.out.println("________fitness________");
					for (int i = 0; i < populacao.length; i++) {
						//ag.mostraGene(populacao[i]);
						System.out.println(ag.fitness(populacao[i]));
					}
					for (int geracao = 0; geracao < 300; geracao++) {

						for (int i = 0; i < populacao.length; i++) {
						//ag.mostraGene(populacao[i]);
						System.out.println(ag.fitness(populacao[i]));
					}
					for (int geracao = 0; geracao < 2000; geracao++) {
						for (int i = 0; i < populacao.length; i++) {
							fitness[i] = ag.fitness(populacao[i]);
						}
						
						indice = ag.selecaoRoleta(fitness);
						populacao = ag.crossoverUniforme(populacao, indice, 0.7);
						populacao = ag.multacao(populacao, 0.1);
						
					}

					System.out.println("________fitness________");
					for (int i = 0; i < populacao.length; i++) {
						//ag.mostraGene(populacao[i]);
						System.out.println(ag.fitness(populacao[i]));
					}
					Individuo individuo = ag.melhorIndividuo(populacao, fitness);
					ag.mostraGene(individuo);
					GradeDeHorarioFrame gdhf = new GradeDeHorarioFrame(ano, individuo);
					gdhf.setVisible(true);
					dispose();
				}catch (NullPointerException e3) {
					// TODO: handle exception
					indice = ag.selecaoRoleta(fitness);
					populacao = ag.crossoverUniforme(populacao, indice, 0.7);
					populacao = ag.multacao(populacao, 0.1);

				}
				System.out.println("________fitness________");
				for (int i = 0; i < populacao.length; i++) {
					//ag.mostraGene(populacao[i]);
					System.out.println(ag.fitness(populacao[i]));
				}
				Individuo individuo = ag.melhorIndividuo(populacao, fitness);
				ag.mostraGene(individuo);
				GradeDeHorarioFrame gdhf = new GradeDeHorarioFrame(ano, individuo);
				gdhf.setVisible(true);
				dispose();
			}
		});
		btnGerarGrade.setFont(new Font("Times New Roman", Font.BOLD, 11));
		btnGerarGrade.setBounds(179, 239, 121, 40);
		panel_1.add(btnGerarGrade);
		
		JButton btnDisciplina = new JButton("Disciplina");
		btnDisciplina.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new DisciplinasFrame().setVisible(true);
				dispose();
			}
		});
		btnDisciplina.setFont(new Font("Times New Roman", Font.BOLD, 11));
		btnDisciplina.setBounds(179, 11, 121, 40);
		panel_1.add(btnDisciplina);
	}
	}
}
