package comm.example.controller;
import comm.example.model.Todos;
import comm.example.service.TodoService;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("/todo")
public class TodoController {
    private TodoService todoService;

    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }
    @RequestMapping("/listTodo")
    public String listTodo(Model model) {
        model.addAttribute("todo", todoService.getTodos());
        return "todo-list";

    }

    @InitBinder
    public void initBinder(WebDataBinder dataBinder) {

        StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);

        dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
    }
    @RequestMapping("/showFormForAdd")
    public String showFormForAdd(Model model)
    {
        model.addAttribute("todo",new Todos());
        return "todo-form";
    }

    @RequestMapping("/saveTodo")
    public String saveCustomer(@Valid @ModelAttribute("todo") Todos todos,
                               BindingResult theBindingResult)
    {

        if (theBindingResult.hasErrors()) {
            return "todo-form";
        } else {
            todoService.createTodo(todos);
            return "redirect:/todo/listTodo";
        }

    }

    @GetMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("todoId") int theId,
                                    Model theModel) {

        Todos theTodos = todoService.getTodo(theId);

        theModel.addAttribute("todo", theTodos);

        return "todo-form";
    }
    @RequestMapping("/updateTodo")
    public String updateCustomer(@ModelAttribute("todo") Todos todos)
    {
        todoService.createTodo(todos);
        return "redirect:/todo/listTodo";
    }
    @RequestMapping("/delete")
    public String delete(@RequestParam("todoId") int todoId)
    {
        todoService.deleteTodo(todoId);
        return "redirect:/todo/listTodo";
    }
}
