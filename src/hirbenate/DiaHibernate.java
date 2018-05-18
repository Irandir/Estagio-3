package hirbenate;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import dao.DiaImpossivelDAO;
import model.AnoDisciplina;
import model.Dia;
import model.Hora;

public class DiaHibernate implements DiaImpossivelDAO{

	@Override
	public void insert(Dia o) {
		// TODO Auto-generated method stub
		Session session = HibernateUtil.getSession();
        try {
            Transaction t = session.beginTransaction();
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
	public void update(Dia o) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Dia o) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Dia read(Integer id) {
		Session session = HibernateUtil.getSession();
		try {
			return (Dia) session.get(Dia.class.getName(), id);
		} catch (Exception e) {
			session.getTransaction().rollback();
			System.err.println("Falha ao recuperar Bairro. Erro: " + e.toString());
		} finally {
			session.close();
		}
	
		return null;
	}

	@Override
	public List<Dia> recuperarPorNome(String nome) {
		Session session = HibernateUtil.getSession();
		try {
			session.beginTransaction();
			List<Dia> listaAux = session.createQuery("from " + Dia.class.getName()).list();
			List<Dia> lista = new ArrayList<>();
			for (Dia s : listaAux) {
				if (s.getDia().toString().equals(nome)) {
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
	public List<Dia> recuperarTodos() {
		Session session = HibernateUtil.getSession();
        try {
            session.beginTransaction();
            List<Dia>lista = session.createQuery("from " + Dia.class.getName()).list();
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
