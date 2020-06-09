package comm.example.dao;

import comm.example.model.Todos;

import java.util.List;

public interface TodoDAO {
    public List<Todos> getTodos();
    public void createTodo(Todos todos);
    public Todos getTodo(int todoId);
    public void deleteTodo(int todoId);

}
