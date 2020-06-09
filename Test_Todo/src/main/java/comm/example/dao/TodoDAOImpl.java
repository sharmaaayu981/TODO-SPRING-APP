package comm.example.dao;

import comm.example.model.Todos;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

@Repository("todoDAO")
public class TodoDAOImpl implements TodoDAO {
    private final EntityManager entityManager;

    @Autowired
    public TodoDAOImpl(EntityManager entityManager) {

        this.entityManager = entityManager;

    }

    @Override
    @Transactional
    public List<Todos> getTodos() {
        Query query = entityManager.createQuery(" from Todos");
        return query.getResultList();
    }

    @Override
    @Transactional
    public void createTodo(Todos todos) {
        Session session = entityManager.unwrap(org.hibernate.Session.class);
      //  session.getTransaction().begin();
        session.saveOrUpdate(todos);
        //session.getTransaction().commit();


    }

    @Override
    @Transactional
    public Todos getTodo(int todoId) {
        return entityManager.find(Todos.class,todoId);
    }

    @Override
    @Transactional
    public void deleteTodo(int todoId) {
        entityManager.remove(getTodo(todoId));

    }


}
