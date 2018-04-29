package hirbenate;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;

import dao.DiaImpossivelHoraDAO;
import model.DiaImpossivelHora;

public class DiaImpossivelHoraHibernate implements DiaImpossivelHoraDAO {

	@Override
	public void insert(DiaImpossivelHora o) {
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
	public void update(DiaImpossivelHora o) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(DiaImpossivelHora o) {

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
	public DiaImpossivelHora read(Integer id) {
		Session session = HibernateUtil.getSession();
		try {
			return (DiaImpossivelHora) session.get(DiaImpossivelHora.class.getName(), id);
		} catch (Exception e) {
			session.getTransaction().rollback();
			System.err.println("Falha ao recuperar Bairro. Erro: " + e.toString());
		} finally {
			session.close();
		}

		return null;
	}

	@Override
	public List<DiaImpossivelHora> recuperarPorNome(String nome) {
		Session session = HibernateUtil.getSession();
		try {
			int id = Integer.parseInt(nome);
			session.beginTransaction();
			List<DiaImpossivelHora> listaAux = session.createQuery("from " + DiaImpossivelHora.class.getName()).list();
			List<DiaImpossivelHora> lista = new ArrayList<>();
			for (DiaImpossivelHora s : listaAux) {
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
	public List<DiaImpossivelHora> recuperarTodos() {
		Session session = HibernateUtil.getSession();
		try {
			session.beginTransaction();
			List<DiaImpossivelHora> lista = session.createQuery("from " + DiaImpossivelHora.class.getName()).list();
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
