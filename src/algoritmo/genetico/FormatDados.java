package algoritmo.genetico;

import java.util.ArrayList;
import java.util.List;

import model.Ano;
import model.AnoDisciplina;
import model.DiaEnum;
import model.Dia;
import model.DiaHora;
import model.Disciplina;
import model.Hora;
import model.Professor;
import model.ProfessorDisciplinaAno;
//esta class nao pode ser alterada
public class FormatDados {

	private List<Hora> horas;
	private List<Dia> dias;
	private List<Disciplina> disci;
	private List<Ano> ano;
	private List<Professor> professor;
	// auxs
	private List<AnoDisciplina> ad;
	private List<DiaHora> dh;
	private List<ProfessorDisciplinaAno> pda;
	
	// respota 2
	private List<Ano2> ano2 = new ArrayList<>();
	private List<Professor2> professor2 = new ArrayList<>();
	
	public FormatDados(List<Hora> horas, List<Dia> dias, List<Disciplina> disci, List<Ano> ano,
			List<Professor> professor, List<AnoDisciplina> ad, List<DiaHora> dh, List<ProfessorDisciplinaAno> pda) {
		super();
		this.horas = horas;
		this.dias = dias;
		this.disci = disci;
		this.ano = ano;
		this.professor = professor;
		this.ad = ad;
		// this.dI = dI;
		this.dh = dh;
		this.pda = pda;
		
		format();
	}

	public void format() {
		List<Disciplina> aux;
		// resposta 1
		
		int a;//satanas entrou no codigo por isso tem essa porras a e b
		int b;
		for (int i = 0; i < ano.size(); i++) {
			aux = new ArrayList<>();
			for (int j = 0; j < ad.size(); j++) {
				if (ano.get(i).getId() == ad.get(j).getAno_id()) {
					for (int j2 = 0; j2 < disci.size(); j2++) {
						a = disci.get(j2).getId();
						b = ad.get(j).getDisciplina_id();
						if (a == b) {
							aux.add(disci.get(j2));
						}
					}
				}
			}
			ano2.add(new Ano2(ano.get(i).getNome(), ano.get(i).getTurno(), aux));
		}

		for (int i = 0; i < professor.size(); i++) {
			professor2.add(new Professor2(professor.get(i).getNome()));
		}
		List<Dia> auxDia;
		List<Hora> auxHora;
		List<Disciplina>auxDisc;
		for (int i = 0; i < professor.size(); i++) {
			auxDia = new ArrayList<>();
			auxHora = new ArrayList<>();
			auxDisc = new ArrayList<>();
			for (int j = 0; j < dh.size(); j++) {
				if ((int)professor.get(i).getId() == (int)dh.get(j).getProf_id()) {
					for (int j2 = 0; j2 < dias.size(); j2++) {
						if ((int)dias.get(j2).getId() == (int)dh.get(j).getDia_id()) {
							auxDia.add(dias.get(j2));
						}
					}
					for (int j2 = 0; j2 < horas.size(); j2++) {
						if ((int)horas.get(j2).getId() == (int)dh.get(j).getHora_id()) {
							auxHora.add(horas.get(j2));
						}
					}
				}
			}
			for (int j = 0; j < pda.size(); j++) {
				if (professor.get(i).getId() == pda.get(j).getProf_id()) {
					for (int j2 = 0; j2 < disci.size(); j2++) {
						if ((int)disci.get(j2).getId() == (int)pda.get(j).getDisc_id()) {
							auxDisc.add(disci.get(j2));
						}
					}
					
				}
			}
			professor2.get(i).setPrefDisciplinas(auxDisc);
			professor2.get(i).setDia(auxDia);
			professor2.get(i).setHora(auxHora);
		}

		/*System.out.println("____________________________________");
		for (int i = 0; i < ano2.size(); i++) {
			System.out.println("ano -->" + ano2.get(i).getNome() + "*********************");
			for (int j = 0; j < ano2.get(i).getDisc().size(); j++) {
				System.out.println(ano2.get(i).getDisc().get(j).getNome());
			}
			System.out.println("**************************");
		}

		System.out.println("____________________________________");
		for (int i = 0; i < professor2.size(); i++) {
			System.out.println("professor -->" + professor2.get(i).getNome() + "*********************");
			for (int j = 0; j < professor2.get(i).getDia().size(); j++) {
				System.out.println(professor2.get(i).getDia().get(j).getDia().toString() + " "
						+ professor2.get(i).getHora().get(j).getHora());
			}
			System.out.println("**************************");
		}
		System.out.println("____________________________________");
		for (int i = 0; i < professor2.size(); i++) {
			System.out.println("professor -->" + professor2.get(i).getNome() + "*********************");
			for (int j = 0; j < professor2.get(i).getPrefDisciplinas().size(); j++) {
				System.out.println(professor2.get(i).getPrefDisciplinas().get(j).getNome());
			}
			System.out.println("**************************");
		}
		System.out.println("1212");*/
	}

	public List<Ano2> getAno2() {
		return ano2;
	}

	public void setAno2(List<Ano2> ano2) {
		this.ano2 = ano2;
	}

	public List<Professor2> getProfessor2() {
		return professor2;
	}

	public void setProfessor2(List<Professor2> professor2) {
		this.professor2 = professor2;
	}
	
}
