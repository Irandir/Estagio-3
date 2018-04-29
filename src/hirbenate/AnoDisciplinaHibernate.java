package hirbenate;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;

import dao.AnoDisciplinaDAO;
import model.AnoDisciplina;
import model.Disciplina;

public class AnoDisciplinaHibernate implements AnoDisciplinaDAO{

	@Override
	public void insert(AnoDisciplina o) {
		// TODO Auto-generated method stub
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
	public void update(AnoDisciplina o) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(AnoDisciplina o) {
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
	public AnoDisciplina read(Integer id) {
		Session session = HibernateUtil.getSession();
		try {
			return (AnoDisciplina) session.get(AnoDisciplina.class.getName(), id);
		} catch (Exception e) {
			session.getTransaction().rollback();
			System.err.println("Falha ao recuperar Bairro. Erro: " + e.toString());
		} finally {
			session.close();
		}
	
		return null;
	}

	@Override
	public List<AnoDisciplina> recuperarPorNome(String nome) {
		
		  Session session = HibernateUtil.getSession();
	        try {
	        	int ano_id = Integer.parseInt(nome); 
	            session.beginTransaction();
	            List<AnoDisciplina> listaAux = session.createQuery("from " + AnoDisciplina.class.getName()).list();
	            List<AnoDisciplina> lista = new ArrayList<>();
	            for (AnoDisciplina s : listaAux) {
	                if (s.getAno_id() == ano_id) {
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
	public List<AnoDisciplina> recuperarTodos() {
		Session session = HibernateUtil.getSession();
		try {
			session.beginTransaction();
			List<AnoDisciplina> lista = session.createQuery("from " + AnoDisciplina.class.getName()).list();
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
