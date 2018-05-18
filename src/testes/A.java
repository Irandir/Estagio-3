package testes;

import java.util.ArrayList;

import hirbenate.AnoHibernate;
import hirbenate.DiaHibernate;
import hirbenate.DisciplinaHibernate;
import hirbenate.HoraHibernate;
import hirbenate.ProfessorHibernate;
import model.Ano;
import model.DiaEnum;
import model.Dia;
import model.Disciplina;
import model.Hora;
import model.HoraEnum;
import model.Professor;
import model.Turno;

public class A {
	public static void main(String[] args) {
		ArrayList a = new ArrayList<>();
		a.add(1);
		for (int i = 0; i < a.size(); i++) {
			System.out.println(a.get(i));
		}
		a.add(2);
		for (int i = 0; i < a.size(); i++) {
			System.out.println(a.get(i));
		}
		a.add(3);
		for (int i = 0; i < a.size(); i++) {
			System.out.println(a.get(i));
		}
		/*
		HoraEnum[] hE = HoraEnum.values();
		Hora h[] = new Hora[hE.length];
		for (int i = 0; i < h.length; i++) {
			h[i] = new Hora(hE[i]);
		}
		HoraHibernate hh = new HoraHibernate();
		for (int i = 0; i < h.length; i++) {
			hh.insert(h[i]);
		}
		
		DiaImpossivelHibernate d5 = new DiaImpossivelHibernate();
		ArrayList<Hora> hora = new ArrayList<>();
		hora.add(h[0]);
		hora.add(h[10]);
	
		DiaImpossivel di = new DiaImpossivel(Dia.SEGUNDA, hora);
		d5.insert(di);
		
		ProfessorHibernate ph = new ProfessorHibernate();
		Professor s = new Professor("dmoen", null, null);
		ph.insert(s);
		//System.out.println(new Hora(HoraEnum.h1).getHora());*/
	}
}
