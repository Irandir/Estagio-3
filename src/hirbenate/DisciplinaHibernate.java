package hirbenate;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;

import dao.DisciplinaDAO;
import model.DiaImpossivelHora;
import model.Disciplina;
import model.Hora;

public class DisciplinaHibernate implements DisciplinaDAO {

	@Override
	public void insert(Disciplina o) {
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
	public void update(Disciplina o) {
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
	public void delete(Disciplina o) {
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
	public Disciplina read(Integer id) {
		Session session = HibernateUtil.getSession();
		try {
			return (Disciplina) session.get(Disciplina.class.getName(), id);
		} catch (Exception e) {
			session.getTransaction().rollback();
			System.err.println("Falha ao recuperar Bairro. Erro: " + e.toString());
		} finally {
			session.close();
		}
		return null;
	}

	@Override
	public List<Disciplina> recuperarPorNome(String nome) {
		
		return null;
	}

	@Override
	public List<Disciplina> recuperarTodos() {
		Session session = HibernateUtil.getSession();
		try {
			session.beginTransaction();
			List<Disciplina> lista = session.createQuery("from " + Disciplina.class.getName()).list();
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
