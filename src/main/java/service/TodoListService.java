package service;

import java.util.List;

import model.dto.TodoDTO;
import model.entity.Todo;

public interface TodoListService {
	//1.查詢所有 Todo 資料
		List<TodoDTO> findAllTodos();
		//2.查詢單筆 Todo 資料
		TodoDTO getTodo(Integer id);
		//3.新增	 Todo 資料
		void addTodo(String text,Boolean completed);
		//4.修改指定 Todo 完成與否
		void updateTotoComplete(Integer id,Boolean completed);
		//5.修改指定 Todo Text
		void updateTotoText(Integer id,String text);
		//6.刪除指定 Todo 紀錄
		void deleteTodo(Integer id);
}
