package hirbenate;

import java.util.List;

import org.hibernate.Session;

import dao.AnoDAO;
import model.Ano;
import model.Disciplina;

public class AnoHibernate implements AnoDAO {

	@Override
	public void insert(Ano o) {
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
	public void update(Ano o) {
		// TODO Auto-generated method stub
		Session session = HibernateUtil.getSession();
        try {
            session.beginTransaction();
            session.update(o);
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
            System.err.println("Falha ao alterar Usuario. Erro: " + e.toString());
        } finally {
            session.close();
        }
	}

	@Override
	public void delete(Ano o) {
		// TODO Auto-generated method stub
		Session session = HibernateUtil.getSession();
		try {
			session.beginTransaction();
			session.delete(o);
			session.getTransaction().commit();
		} catch (Exception e) {
			session.getTransaction().rollback();
			System.err.println("Falha ao remover Usuario. Erro: " + e.toString());
		} finally {
			session.close();
		}

	}

	@Override
	public Ano read(Integer id) {
		Session session = HibernateUtil.getSession();
		try {
			return (Ano) session.get(Ano.class.getName(), id);
		} catch (Exception e) {
			session.getTransaction().rollback();
			System.err.println("Falha ao recuperar Bairro. Erro: " + e.toString());
		} finally {
			session.close();
		}
		return null;
	}

	@Override
	public List<Ano> recuperarPorNome(String nome) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Ano> recuperarTodos() {
		Session session = HibernateUtil.getSession();
		try {
			session.beginTransaction();
			List<Ano> lista = session.createQuery("from " + Ano.class.getName()).list();
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
