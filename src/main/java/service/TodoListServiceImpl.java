package service;

import java.util.ArrayList;
import java.util.List;

import dao.TodoListDao;
import dao.TodoListDaoImpl;
import model.dto.TodoDTO;
import model.entity.Todo;

public class TodoListServiceImpl implements TodoListService{
	private TodoListDao dao=new TodoListDaoImpl();
	@Override
	public List<TodoDTO> findAllTodos() {
		return dao.findAllTodos().stream().map(this::transferToDTO).toList();
	}

	@Override
	public TodoDTO getTodo(Integer id) {
		// TODO 自動產生的方法 Stub
		return transferToDTO(dao.getTodo(id));
	}

	@Override
	public void addTodo(String text, Boolean completed) {
		Todo todo=new Todo(0,text,completed);
		dao.addTodo(todo);
		
	}

	@Override
	public void updateTotoComplete(Integer id, Boolean completed) {
		dao.updateTotoComplete(id, completed);
		
	}

	@Override
	public void updateTotoText(Integer id, String text) {
		dao.updateTotoText(id, text);
		
	}

	@Override
	public void deleteTodo(Integer id) {
		dao.deleteTodo(id);
		
	}
	private TodoDTO transferToDTO(Todo todo) {
		return new TodoDTO(todo.getId(),todo.getText(),todo.getCompleted());
	}
	private Todo transferToEntity(TodoDTO todoDTO) {
		return new Todo(todoDTO.getId(),todoDTO.getText(),todoDTO.getCompleted());
	}

}
