package hirbenate;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;

import dao.HoraDAO;
import model.DiaImpossivel;
import model.DiaImpossivelHora;
import model.Hora;

public class HoraHibernate implements HoraDAO{

	@Override
	public void insert(Hora o) {
		Session session = HibernateUtil.getSession();
        try {
            session.beginTransaction();
            session.save(o);
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
            System.err.println("Falha ao salvar Usuario. Erro: " + e.toString());
        } finally {
            session.close();
            HibernateUtil.getSession().close();
        }
		
	}

	@Override
	public void update(Hora o) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Hora o) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Hora read(Integer id) {
		Session session = HibernateUtil.getSession();
		try {
			return (Hora) session.get(Hora.class.getName(), id);
		} catch (Exception e) {
			session.getTransaction().rollback();
			System.err.println("Falha ao recuperar Bairro. Erro: " + e.toString());
		} finally {
			session.close();
		}
	
		return null;
	}

	@Override
	public List<Hora> recuperarPorNome(String nome) {
		Session session = HibernateUtil.getSession();
		try {
			session.beginTransaction();
			List<Hora> listaAux = session.createQuery("from " + Hora.class.getName()).list();
			List<Hora> lista = new ArrayList<>();
			for (Hora s : listaAux) {
				if (s.getHora().equals(nome)) {
					lista.add(s);
				}
			}
			session.getTransaction().commit();
			return lista;
		} catch (Exception e) {
			session.getTransaction().rollback();
			System.err.println("Falha ao recuperar todos os Usuarios. Erro: " + e.toString());
		} finally {
			session.close();
		}
		return null;
	}

	@Override
	public List<Hora> recuperarTodos() {
		Session session = HibernateUtil.getSession();
        try {
            session.beginTransaction();
            List<Hora>lista = session.createQuery("from " + Hora.class.getName()).list();
            session.getTransaction().commit();
            return lista;
        } catch (Exception e) {
            session.getTransaction().rollback();
            System.err.println("Falha ao recuperar todos os NIVEIS. Erro: " + e.toString());
        } finally {
            session.close();
        }
        return null;
	}



}
