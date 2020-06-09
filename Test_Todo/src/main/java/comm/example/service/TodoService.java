package comm.example.service;

import comm.example.model.Todos;

import java.util.List;

public interface TodoService {
    public List<Todos> getTodos();
    public void createTodo(Todos todos);
    public Todos getTodo(int todoId);
    public void deleteTodo(int todoId);
}
