package main;

import java.util.List;

import hirbenate.DiaHibernate;
import hirbenate.HoraHibernate;
import model.DiaEnum;
import model.Dia;
import model.Hora;
import model.HoraEnum;
import telas.MenuFrame;

public class Estagio3 {

	public static void main(String[] args) {
		HoraHibernate horaHibernate = new HoraHibernate();
		DiaHibernate diaImpossivelHibernate = new DiaHibernate();
		List a = horaHibernate.recuperarTodos();
		List b = diaImpossivelHibernate.recuperarTodos();
		if(a.size() == 0){
			HoraEnum[] hE = HoraEnum.values();
			Hora h[] = new Hora[hE.length];
			for (int i = 0; i < h.length; i++) {
				h[i] = new Hora(hE[i]);
			}
			for (int i = 0; i < h.length; i++) {
				horaHibernate.insert(h[i]);
			}
			System.out.println("Entrou");
		}
		if(b.size() == 0){
			DiaEnum[] dE = DiaEnum.values();
			Dia d[] = new Dia[dE.length];
			for (int i = 0; i < d.length; i++) {
				d[i] = new Dia(dE[i]);
			}
			for (int i = 0; i < d.length; i++) {
				diaImpossivelHibernate.insert(d[i]);
			}
			System.out.println("Entrou 2");
		}
		MenuFrame frame = new MenuFrame();
		frame.setVisible(true);	
	}
}
