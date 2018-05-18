package hirbenate;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;

import dao.DiaImpossivelHoraDAO;
import model.DiaHora;

public class DiaHoraHibernate implements DiaImpossivelHoraDAO {

	@Override
	public void insert(DiaHora o) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		Session session = HibernateUtil.getSession();
		try {
			session.beginTransaction();
			session.save(o);
			session.getTransaction().commit();
		} catch (Exception e) {
			session.getTransaction().rollback();
			System.err.println("Falha ao salvar. Erro: " + e.toString());
		} finally {
			session.close();
			HibernateUtil.getSession().close();
		}
	}

	@Override
	public void update(DiaHora o) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(DiaHora o) {

		Session session = HibernateUtil.getSession();
		try {
			session.beginTransaction();
			session.delete(o);
			session.getTransaction().commit();
		} catch (Exception e) {
			session.getTransaction().rollback();
			System.err.println("Falha ao remover. Erro: " + e.toString());
		} finally {
			session.close();
		}
	}

	@Override
	public DiaHora read(Integer id) {
		Session session = HibernateUtil.getSession();
		try {
			return (DiaHora) session.get(DiaHora.class.getName(), id);
		} catch (Exception e) {
			session.getTransaction().rollback();
			System.err.println("Falha ao recuperar Bairro. Erro: " + e.toString());
		} finally {
			session.close();
		}

		return null;
	}

	@Override
	public List<DiaHora> recuperarPorNome(String nome) {
		Session session = HibernateUtil.getSession();
		try {
			int id = Integer.parseInt(nome);
			session.beginTransaction();
			List<DiaHora> listaAux = session.createQuery("from " + DiaHora.class.getName()).list();
			List<DiaHora> lista = new ArrayList<>();
			for (DiaHora s : listaAux) {
				if (s.getProf_id() == id) {
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
	public List<DiaHora> recuperarTodos() {
		Session session = HibernateUtil.getSession();
		try {
			session.beginTransaction();
			List<DiaHora> lista = session.createQuery("from " + DiaHora.class.getName()).list();
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

}
