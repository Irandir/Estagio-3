package algoritmo.genetico;

import java.util.ArrayList;
import java.util.Random;

import javax.swing.JOptionPane;

import curso.Dia;
import curso.Horario;
import model.Ano;
import model.DiaImpossivel;
import model.Disciplina;
import model.Professor;

public class Principal {
	private static Random rand = new Random();
	int quantDeCromossomos;
	Horario[] hora;
	Professor[] professor;
	Ano[] periodo;
	Dia[] dia;
	Horario[] horaPreferencial = new Horario[0];

	public Principal(int quantDeCromossomos, Horario[] hora, Professor[] professor, Ano[] periodo, Dia[] dia,
			Horario[] horaPreferencial) {
		this.quantDeCromossomos = quantDeCromossomos;
		this.hora = hora;
		this.professor = professor;
		this.periodo = periodo;
		this.dia = dia;
		this.horaPreferencial = horaPreferencial;
	}

	public ArrayList<Individuo> gerandoPopulacao() {
		ArrayList<Individuo> r = new ArrayList<Individuo>();
		for (int i = 0; i < quantDeCromossomos; i++) {
			r.add(gerandoIndividuo());
		}
		return r;
	}
	
	public Individuo gerandoIndividuo() {

		ArrayList<Individuo> individuos = new ArrayList<>();
		Professor p = new Professor("", null);
		Disciplina d = new Disciplina("", 0);
		Gene genesArray[] = new Gene[periodo.length * dia.length * hora.length];
		int cont = 0;
		for (int i = 0; i < periodo.length; i++) {
			for (int j = 0; j < dia.length; j++) {
				for (int j2 = 0; j2 < hora.length; j2++) {
					genesArray[cont] = new Gene(hora[j2], periodo[i], p, d, dia[j]);
					cont++;
				}

			}
		}
		int[] indiceSorteados = new int[genesArray.length];
		int cont0 = 0;
		int indiceG = 0;
		int indiceP = 0;
		boolean aux = false;
		cont = 0;
	
		for (int i = 0; i < periodo.length; i++) {
			for (int j = 0; j < periodo[i].getDisciplinas().length; j++) {
				indiceP = rand.nextInt(professor.length);
				for (int j2 = 0; j2 < periodo[i].getDisciplinas()[j].getNumeroDeAulasSemanais(); j2++) {
					
					indiceG = rand.nextInt(hora.length*dia.length)+hora.length*dia.length*i;
					loop: while (true) {
						indiceG = rand.nextInt(hora.length*dia.length)+hora.length*dia.length*i;
						if(indiceG ==0 && cont0==0){
							cont0++;
							break loop;
						}
						aux = false;
						loop2:for (int k = 0; k < indiceSorteados.length; k++) {
							if (indiceG == indiceSorteados[k]) {
								aux = true;
								break loop2;
							}
						}
						if (aux == false) {
							break loop;
						}
					}
					genesArray[indiceG].setProfessor(professor[indiceP]);
					genesArray[indiceG].setDisciplina(periodo[i].getDisciplinas()[j]);
					indiceSorteados[cont] = indiceG;
					cont++;
				}
			}
		}

		return new Individuo(genesArray);

	}

	public void funcaoDeAvalicao(Individuo ind) {
		
		Gene gene;
		Gene gene2;
		int penalidades = 0;
		int bonus = 0;
		
		// indisponibilidade do prof
		for (int i = 0; i < ind.getGenes().length; i++) {
			for (int contProf = 0; contProf < professor.length; contProf++) {
				for (int contDiaIm = 0; contDiaIm < professor[contProf].getDiaImpossivels().length; contDiaIm++) {
					for (int contHora = 0; contHora < professor[contProf].getDiaImpossivels()[contDiaIm]
							.getHora().length; contHora++) {
						if (ind.getGenes()[i].getHora()
								.equals(professor[contProf].getDiaImpossivels()[contDiaIm].getHora()[contHora])
								&& ind.getGenes()[i].getDia()
										.equals(professor[contProf].getDiaImpossivels()[contDiaIm].getDia())
								&& ind.getGenes()[i].getProfessor().getNome().equals(professor[contProf].getNome())) {
							System.out.println("Condicao_3  i-->" + i);
							penalidades += 500;
						}
					}

				}
			}

		}
		// colisao do mesmo dia/hora o professor ter duas(ou mais) disciplinas
		for (int i = 0; i < ind.getGenes().length - 1; i++) {
			gene = ind.getGenes()[i];
			for (int j = i; j < ind.getGenes().length - 1; j++) {
				gene2 = ind.getGenes()[j + 1];
				if (gene.getHora().equals(gene2.getHora()) && gene.getDia().equals(gene2.getDia())
						&& !gene.getPeriodo().getNome().equals(gene2.getPeriodo().getNome())
						&& gene.getProfessor().getNome().equals(gene2.getProfessor().getNome()) 
						&& !gene.getProfessor().getNome().equals("")) {
					penalidades += 500;
					System.out.println("Condicao_4  i-->" + i + " j-->" + (j + 1));
				}
			}

		}
		
		// professor sem horario
		int contProf = 0;
		for (int j = 0; j < professor.length; j++) {
			loop: for (int i = 0; i < ind.getGenes().length; i++) {
				if (professor[j].getNome().equals(ind.getGenes()[i].getProfessor().getNome())) {
					contProf++;
					break loop;
				}
			}
		}
		if (contProf < professor.length) {
			penalidades += 1000;
			System.out.println("Condicao 5");
		}
		// falta de disciplina
		// aumento de aulas de uma disiciplina
		// falta de aulas de uma disiciplina
		// horario vaga/branco 
		
		
		// horario preferencial do curso (manha,tarde,...)
		for (int i = 0; i < ind.getGenes().length; i++) {
			for (int j = 0; j < horaPreferencial.length; j++) {
				if (ind.getGenes()[i].getHora().equals(horaPreferencial[j]) && !ind.getGenes()[i].getProfessor().getNome().equals("")) {
					bonus += 100;
				}
			}
		}
		// horario com disciplinas seguidas


		ind.setAptidao(bonus - penalidades);

	}

	public static void main(String[] args) {

		Disciplina d = new Disciplina("Prática 1", 2);
		Disciplina d2 = new Disciplina("Prática 2", 4);
		Disciplina d3 = new Disciplina("Prática 3", 2);

		Horario h1 = new Horario("7:30");
		Horario h2 = new Horario("8:00");
		Horario h3 = new Horario("9:10");
		Horario h4 = new Horario("10:00");
		Horario h5 = new Horario("10:50");
		Horario h6 = new Horario("11:50");
		Horario h7 = new Horario("12:30");
		Horario[] hora = { h1, h2};

		Disciplina disciplimas[][] = { { d }, { d2, d3 } };
		Ano[] periodo = { new Ano("1", disciplimas[0]), new Ano("2", disciplimas[1]) };

		Professor[] professor = { new Professor("João", disciplimas[0]), new Professor("ZZZZ", disciplimas[1]) };

		Dia dia1 = Dia.DOMINGO;
		Dia dia2 = Dia.SEGUNDA;
		Dia dia3 = Dia.TERCA;
		Dia dia4 = Dia.QUARTA;
		Dia dia5 = Dia.SABADO;

		Horario[] hora2 = { h5, h6, h7 };

		DiaImpossivel dia1I = new DiaImpossivel(dia1, hora);
		DiaImpossivel dia2I = new DiaImpossivel(dia2, hora);
		DiaImpossivel dia3I = new DiaImpossivel(dia3, hora);
		DiaImpossivel dia4I = new DiaImpossivel(dia4, hora2);
		DiaImpossivel dia5I = new DiaImpossivel(dia5, hora);
		DiaImpossivel[] diaImpossivels = { dia1I, dia2I, dia3I, dia4I, dia5I };

		professor[0].setDiaImpossivels(diaImpossivels);

		Horario[] horaPreferencial = { h1, h2, h3 };

		Principal p = new Principal(4, hora, professor, periodo, Dia.getDiasDaSemana(), horaPreferencial);
		ArrayList<Individuo> ind = p.gerandoPopulacao();
		for (Individuo individuo : ind) {
			p.funcaoDeAvalicao(individuo);
			for (int i = 0; i < individuo.getGenes().length; i++) {
				System.out.println("i-->"+i+" "+individuo.getGenes()[i].toString());
			}
			System.out.println("apitidao--> " + individuo.getAptidao() +"\n");
		}
	}

}
