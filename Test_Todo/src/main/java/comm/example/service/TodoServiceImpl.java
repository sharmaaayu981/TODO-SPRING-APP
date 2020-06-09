package comm.example.service;

import comm.example.dao.TodoDAO;
import comm.example.model.Todos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("todoService")
public class TodoServiceImpl implements TodoService {
    private TodoDAO todoDAO;

    public TodoServiceImpl() {
    }

    @Autowired
    public TodoServiceImpl(TodoDAO todoDAO) {
        this.todoDAO = todoDAO;
    }

    @Override
    public List<Todos> getTodos() {
        return todoDAO.getTodos();
    }

    @Override
    public void createTodo(Todos todos) {
        todoDAO.createTodo(todos);
    }

    @Override
    public Todos getTodo(int todoId) {
       return todoDAO.getTodo(todoId);
    }

    @Override
    public void deleteTodo(int todoId) {
        todoDAO.deleteTodo(todoId);

    }


}
