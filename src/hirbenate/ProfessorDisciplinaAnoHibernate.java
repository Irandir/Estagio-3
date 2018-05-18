package hirbenate;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;

import dao.ProfessorDisciplinaAnoDAO;
import model.AnoDisciplina;
import model.DiaHora;
import model.Professor;
import model.ProfessorDisciplinaAno;

public class ProfessorDisciplinaAnoHibernate implements ProfessorDisciplinaAnoDAO {

	@Override
	public void insert(ProfessorDisciplinaAno o) {
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
	public void update(ProfessorDisciplinaAno o) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(ProfessorDisciplinaAno o) {
		// TODO Auto-generated method stub
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
	public ProfessorDisciplinaAno read(Integer id) {
		Session session = HibernateUtil.getSession();
		try {
			return (ProfessorDisciplinaAno) session.get(ProfessorDisciplinaAno.class.getName(), id);
		} catch (Exception e) {
			session.getTransaction().rollback();
			System.err.println("Falha ao recuperar Bairro. Erro: " + e.toString());
		} finally {
			session.close();
		}
	
		return null;
	}

	@Override
	public List<ProfessorDisciplinaAno>recuperarPorNome(String nome) {
		Session session = HibernateUtil.getSession();
		try {
			int id = Integer.parseInt(nome);
			session.beginTransaction();
			List<ProfessorDisciplinaAno> listaAux = session.createQuery("from " + ProfessorDisciplinaAno.class.getName()).list();
			List<ProfessorDisciplinaAno> lista = new ArrayList<>();
			for (ProfessorDisciplinaAno s : listaAux) {
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
	public List<ProfessorDisciplinaAno> recuperarTodos() {
		Session session = HibernateUtil.getSession();
		try {
			session.beginTransaction();
			List<ProfessorDisciplinaAno> lista = session.createQuery("from " + ProfessorDisciplinaAno.class.getName()).list();
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
