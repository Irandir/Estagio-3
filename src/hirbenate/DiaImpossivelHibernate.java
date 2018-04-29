package hirbenate;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import dao.DiaImpossivelDAO;
import model.AnoDisciplina;
import model.DiaImpossivel;
import model.Hora;

public class DiaImpossivelHibernate implements DiaImpossivelDAO{

	@Override
	public void insert(DiaImpossivel o) {
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
	public void update(DiaImpossivel o) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(DiaImpossivel o) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public DiaImpossivel read(Integer id) {
		Session session = HibernateUtil.getSession();
		try {
			return (DiaImpossivel) session.get(DiaImpossivel.class.getName(), id);
		} catch (Exception e) {
			session.getTransaction().rollback();
			System.err.println("Falha ao recuperar Bairro. Erro: " + e.toString());
		} finally {
			session.close();
		}
	
		return null;
	}

	@Override
	public List<DiaImpossivel> recuperarPorNome(String nome) {
		Session session = HibernateUtil.getSession();
		try {
			session.beginTransaction();
			List<DiaImpossivel> listaAux = session.createQuery("from " + DiaImpossivel.class.getName()).list();
			List<DiaImpossivel> lista = new ArrayList<>();
			for (DiaImpossivel s : listaAux) {
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
	public List<DiaImpossivel> recuperarTodos() {
		Session session = HibernateUtil.getSession();
        try {
            session.beginTransaction();
            List<DiaImpossivel>lista = session.createQuery("from " + DiaImpossivel.class.getName()).list();
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
