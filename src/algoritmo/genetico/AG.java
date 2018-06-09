package algoritmo.genetico;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.swing.JOptionPane;

import model.Ano;
import model.Dia;
import model.Disciplina;
import model.Hora;
import model.HoraEnum;
import model.Professor;
import model.Turno;

public class AG {
	Random rand = new Random();
	// respota 2
	private List<Ano2> ano2;
	private List<Professor2> professor2;
	private List<Hora> horas;
	private List<Dia> dias;
	private List<Disciplina> disciplinas;
	private int h1 = 5;

	public AG(List<Ano2> ano2, List<Professor2> professor2, List<Hora> horas, List<Dia> dias, List<Disciplina> disci) {
		super();
		this.ano2 = ano2;
		this.professor2 = professor2;
		this.horas = horas;
		this.dias = dias;
		this.disciplinas = disci;
	}

	public void mostraGene(Individuo ind) {
		for (int i = 0; i < ind.getGenes().length; i++) {
			System.out.println("i="+i+"| "+ind.getGenes()[i]);
		}

	}

	public Individuo[] gerandoPopulacao(int t) {
		Individuo[] r = new Individuo[t];
		Individuo ind;
		for (int i = 0; i < t; i++) {

			ind = gerandoIndividuo();
			if (ind == null) {
				return null;
			}
			r[i] = ind;

		}

		return r;
	}

	public List<Hora> horasDoPerido(Ano2 ano2) {
		List<Hora> a = new ArrayList<>();
		if (ano2.getTurno().equals(Turno.Matinal)) {
			a.add(new Hora(HoraEnum.h1));
			a.add(new Hora(HoraEnum.h2));
			a.add(new Hora(HoraEnum.h3));
			a.add(new Hora(HoraEnum.h4));
			a.add(new Hora(HoraEnum.h5));
		} else if (ano2.getTurno().equals(Turno.Vespertino)) {
			a.add(new Hora(HoraEnum.h6));
			a.add(new Hora(HoraEnum.h7));
			a.add(new Hora(HoraEnum.h8));
			a.add(new Hora(HoraEnum.h9));
			a.add(new Hora(HoraEnum.h10));
		}
		if (ano2.getTurno().equals(Turno.Noturno)) {
			a.add(new Hora(HoraEnum.h11));
			a.add(new Hora(HoraEnum.h12));
			a.add(new Hora(HoraEnum.h13));
			a.add(new Hora(HoraEnum.h14));
			a.add(new Hora(HoraEnum.h15));
		}
		return a;
	}

	public double fitness(Individuo ind) {
		Gene gene;
		Gene gene2;
		int penalidades = 0;
		int bonus = 0;

		// colisao do mesmo dia/hora o professor ter duas(ou mais) disciplinas
		for (int i = 0; i < ind.getGenes().length - 1; i++) {
			gene = ind.getGenes()[i];
			for (int j = i; j < ind.getGenes().length - 1; j++) {
				gene2 = ind.getGenes()[j + 1];
				if (gene.getDia().toString().equals(gene2.getDia().toString())
						&& gene.getHora().getHora().equals(gene2.getHora().getHora())
						&& gene.getProfessor().getNome().equals(gene2.getProfessor().getNome())
						&& !gene.getAno().getNome().equals(gene2.getAno().getNome())
						&& !gene.getProfessor().getNome().equals("")) {
					penalidades += 50;
				//	System.out.println("i" + i + " j" + j);
				}
			}

		}
		// professor sem horario
		int contProf = 0;
		for (int j = 0; j < professor2.size(); j++) {
			loop: for (int i = 0; i < ind.getGenes().length; i++) {
				if (professor2.get(j).getNome().equals(ind.getGenes()[i].getProfessor().getNome())) {
					contProf++;
					break loop;
				}
			}
		}
		/*int contTodasDis = 0;
		for (int i = 0; i < ano2.size(); i++) {
			contTodasDis += ano2.get(i).getDisc().size();
		}
		if (contProf > contTodasDis) {
			JOptionPane.showMessageDialog(null, "Professores são muitos não existe disciplinas suficientes");
			JOptionPane.showMessageDialog(null, "Adicione mais disciplinas ou delete professores");
			return 0;
		}*/

		if (contProf < professor2.size()) {
			penalidades += 20;
			//System.out.println("falta professor");
		}
		List<Dia> dias;
		List<Hora> hora;
		int cont = 0;
		// indisponibilidade do prof
		for (int i = 0; i < ind.getGenes().length; i++) {
			for (int c = 0; c < professor2.size(); c++) {
				if (ind.getGenes()[i].getProfessor().getNome().equals(professor2.get(c).getNome())) {
					dias = professor2.get(c).getDia();
					hora = professor2.get(c).getHora();
					for (int j = 0; j < dias.size(); j++) {
						if (ind.getGenes()[i].getHora().getHora().equals(hora.get(j).getHora())
								&& ind.getGenes()[i].getDia().getDia().name().equals(dias.get(j).getDia().name())) {
							penalidades += 3;
							//System.out.println(cont + "prof indisponivel -->" + i);
							cont++;
						}
					}

				}
			}
		}
		// preferencia de displina
		for (int i = 0; i < ind.getGenes().length; i++) {
			for (int c = 0; c < professor2.size(); c++) {
				if (ind.getGenes()[i].getProfessor().getNome().equals(professor2.get(c).getNome())) {
					for (int j = 0; j < professor2.get(c).getPrefDisciplinas().size(); j++) {
						if (ind.getGenes()[i].getDisciplina().getNome()
								.equals(professor2.get(c).getPrefDisciplinas().get(j).getNome())) {
							bonus += 1;
							//.out.println("bonus");
						}
					}

				}
			}
		}

		return (1000 / (1 + penalidades)) * (bonus + 1);
	}

	public Individuo gerandoIndividuo() {
		Individuo individuo = new Individuo(null);
		Gene gene;
		Gene[] genes = new Gene[h1 * dias.size() * ano2.size()];
		int cont = 0;
		List<Hora> horasAno;
		for (int k = 0; k < ano2.size(); k++) {
			for (int h = 0; h < dias.size(); h++) {
				horasAno = horasDoPerido(ano2.get(k));
				for (int i = 0; i < horasAno.size(); i++) {
					gene = new Gene(horasAno.get(i), ano2.get(k), new Professor2(""), new Disciplina("", 0),
							dias.get(h));
					genes[cont++] = gene;
				}

			}
		}
		List<Disciplina> disc = null;
		Professor2 prof2;
		int indice = 0;
		int contErro = 0;
		for (int i = 0; i < ano2.size(); i++) {
			disc = ano2.get(i).getDisc();
			for (int j = 0; j < disc.size(); j++) {
				prof2 = professor2.get(rand.nextInt(professor2.size()));
				for (int j2 = 0; j2 < disc.get(j).getNumeroDeAulasSemanais();) {
					indice = rand.nextInt(h1 * dias.size()) + (h1 * dias.size() * i);
					if (genes[indice].getDisciplina().getNome().equals("")) {
						genes[indice].setDisciplina(disc.get(j));
						genes[indice].setProfessor(prof2);
						j2++;
						contErro = 0;
					}
					if (contErro == 1000) {
						JOptionPane.showMessageDialog(null, "Numero muito grande de disciplina na grade ");
						JOptionPane.showMessageDialog(null, "Delete algunha(s) disciplina(s) do ano "+ano2.get(i).getNome());
						return null;
					}
					contErro++;
				}
			}
		}
		individuo.setGenes(genes);
		return individuo;
	}

	public int[] selecaoRoleta(double[] fitness) {
		double demoninador = 0;
		double aux = 0;
		double roleta[] = new double[fitness.length];
		int indice[] = new int[fitness.length];
		for (int i = 0; i < fitness.length; i++) {
			demoninador += fitness[i];
		}
		for (int i = 0; i < fitness.length; i++) {
			roleta[i] = aux + (fitness[i] / demoninador);
			aux += (fitness[i] / demoninador);
			
		}

		double aleatorio = 0;
		for (int i = 0; i < indice.length; i++) {
			aleatorio = rand.nextDouble();
			loop: for (int j = 0; j < roleta.length; j++) {
				if (aleatorio < roleta[j]) {
					indice[i] = j;
					break loop;
				}
			}
		}
		return indice;
	}
	
	public Individuo melhorIndividuo(Individuo[] populacao,double[] fitness){
		double maior = fitness[0];
		int indice = 0;
		for (int i = 0; i < fitness.length; i++) {
			if (fitness[i]>maior) {
				maior = fitness[i];
				indice = i;
			}
		}
		if(maior< 1000){
			JOptionPane.showMessageDialog(null, "Existe muita especificações diminua a professores ou a indisponibilidade");
			
		}
		
		return populacao[indice];
	}
	
	public Individuo[] crossoverUniforme(Individuo[] populacao, int[] indice, double prob) {
		Individuo[] novaPopulacao = new Individuo[populacao.length];
		double aleatorio = 0;
		int mascara[] = new int[ano2.size()];
		Gene[] indAux = new Gene[populacao[0].getGenes().length];
		Gene[] indAux2 = new Gene[populacao[0].getGenes().length];
		int cont = 0;
		for (int i = 0; i < novaPopulacao.length / 2; i++) {
			aleatorio = rand.nextDouble();
			if (aleatorio <= prob) {
				indAux = new Gene[populacao[0].getGenes().length];
				indAux2 = new Gene[populacao[0].getGenes().length];
				for (int j = 0; j < mascara.length; j++) {
					mascara[j] = rand.nextInt(2);
				}
				cont = 0;
				for (int j = 0; j < mascara.length; j++) {
					if (mascara[j] == 0) {
						for (int j2 = 0; j2 < h1*dias.size(); j2++) {
							indAux[cont] = populacao[indice[i * 2]].getGenes()[cont];
							indAux2[cont] = populacao[indice[i * 2 + 1]].getGenes()[cont];
							cont++;
						}
						
					} else if (mascara[j] == 1) {
						for (int j2 = 0; j2 < h1*dias.size(); j2++) {
							indAux[cont] = populacao[indice[i * 2 + 1]].getGenes()[cont];
							indAux2[cont] = populacao[indice[i * 2]].getGenes()[cont];
							cont++;
						}
					}
				}
				novaPopulacao[i * 2] = new Individuo(indAux);
				novaPopulacao[i * 2 + 1] = new Individuo(indAux2);
			
			} else {
				novaPopulacao[i * 2] = populacao[indice[i * 2]];
				novaPopulacao[i * 2 + 1] = populacao[indice[i * 2 + 1]];
			}
		}
		return novaPopulacao;
	}

	public Individuo[] multacao(Individuo[] populacao, double prob) {
		Individuo[] novaPopulacao = new Individuo[populacao.length];
		double aleatorioMult = 0;
		Disciplina disc;
		Disciplina disc2;
		int aleatorioAno = 0;
		int aleatorioAno2 = 0;
		List<Integer> indice;
		List<Integer> indice2;
		int atributo = 0;
		int indiceGene1 = 0;
		int indiceGene2 = 0;
		Professor2 professor;
		Gene[] individuo;//<_-errodo
		Dia dia=null;
		Hora hora=null;
		Professor2 prof;
		Disciplina disc1;
		Ano2 ano;
		for (int i = 0; i < novaPopulacao.length; i++) {
			aleatorioMult = rand.nextDouble();
			if (aleatorioMult <= prob) {
				individuo = new Gene[populacao[0].getGenes().length];
				for (int j = 0; j < individuo.length; j++) {
					
					dia = new Dia(populacao[i].getGenes()[j].getDia().getDia());
					hora=new Hora(populacao[i].getGenes()[j].getHora().getHora());
					prof= new Professor2(populacao[i].getGenes()[j].getProfessor().getNome());
					disc1 = new Disciplina(populacao[i].getGenes()[j].getDisciplina().getNome(),populacao[i].getGenes()[j].getDisciplina().getNumeroDeAulasSemanais());
					ano= new Ano2(populacao[i].getGenes()[j].getAno().getNome(),populacao[i].getGenes()[j].getAno().getTurno(),null);
					individuo[j] = new Gene(hora, ano, prof, disc1, dia);
				}
				//mostraGene(populacao[i]);
				atributo = rand.nextInt(2);
				aleatorioAno = rand.nextInt(ano2.size());
				if(atributo == 0){
					//multacao por troca de professor
					indice = new ArrayList<>();
					indice2 = new ArrayList<>();
					disc = ano2.get(aleatorioAno).getDisc().get(rand.nextInt(ano2.get(aleatorioAno).getDisc().size()));
					for (int j = 0; j < individuo.length; j++) {
						if (disc.getNome().equals(individuo[j].getDisciplina().getNome())
								&& ano2.get(aleatorioAno).getNome().equals(individuo[j].getAno().getNome())) {
							indice.add(j);
						}
					}
					aleatorioAno2 = rand.nextInt(ano2.size());
					disc2 = ano2.get(aleatorioAno2).getDisc().get(rand.nextInt(ano2.get(aleatorioAno2).getDisc().size()));
					for (int j = 0; j < individuo.length; j++) {
						if (disc2.getNome().equals(individuo[j].getDisciplina().getNome())
								&& ano2.get(aleatorioAno2).getNome().equals(individuo[j].getAno().getNome())) {
							indice2.add(j);
						}
					}
					professor = professor2.get(rand.nextInt(professor2.size()));
					for (int j = 0; j < indice.size(); j++) {
						individuo[indice.get(j)].setProfessor(individuo[indice2.get(0)].getProfessor());
					}
					for (int j = 0; j < indice2.size(); j++) {
						individuo[indice2.get(j)].setProfessor(professor);
					}
				}
				// troca as disciplinas
				else if(atributo == 1){
					for (int j = 0; j < 10000; j++) {
						indiceGene1 = rand.nextInt(individuo.length);
						indiceGene2 = rand.nextInt(individuo.length);
						if (individuo[indiceGene1].getAno().getNome().equals( ano2.get(aleatorioAno).getNome()) 
								&& individuo[indiceGene2].getAno().getNome().equals( ano2.get(aleatorioAno).getNome())) {
							break;
						}
					}
					//System.out.println("i = "+indiceGene1);
					//System.out.println("i = "+indiceGene2);
					professor = individuo[indiceGene1].getProfessor();
					disc = individuo[indiceGene1].getDisciplina();
					
					individuo[indiceGene1].setDisciplina(individuo[indiceGene2].getDisciplina());
					individuo[indiceGene1].setProfessor(individuo[indiceGene2].getProfessor());
					
					individuo[indiceGene2].setDisciplina(disc);
					individuo[indiceGene2].setProfessor(professor);

				}
				novaPopulacao[i] = new Individuo(individuo);
				/*System.out.println("_____");
				mostraGene(novaPopulacao[i]);
				System.out.println("teste");*/
			} else {
				novaPopulacao[i] = populacao[i];
			}
		
		}
		
		return novaPopulacao;
	}
}
