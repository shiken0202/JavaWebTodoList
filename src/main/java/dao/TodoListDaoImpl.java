package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.entity.Todo;

public class TodoListDaoImpl extends BaseDao implements TodoListDao {

	@Override
	public List<Todo> findAllTodos() {
		List<Todo>todos=new ArrayList<>();
		String sql="select id,text,completed from todo order by id";
		try(Statement stmt=conn.createStatement();
			ResultSet rs=stmt.executeQuery(sql)) {
			//逐一尋訪rs 中的每筆紀錄，並將每筆記錄轉成Todo物件加入todos集合。
		while(rs.next()) {
			Todo todo=new Todo();
			todo.setId(rs.getInt("id"));
			todo.setText(rs.getString("text"));
			todo.setCompleted(rs.getBoolean("completed"));
			todos.add(todo);
		}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return todos;
	}

	@Override
	public Todo getTodo(Integer id) {
		String sql="select id,text,completed from todo where id=?";
		try (PreparedStatement pstmt=conn.prepareStatement(sql)){
			pstmt.setInt(1,id);
			try(ResultSet rs=pstmt.executeQuery()){
				if(rs.next()) {
					Todo todo =new Todo();
					todo.setId(rs.getInt("id"));
					todo.setText(rs.getString("text"));
					todo.setCompleted(rs.getBoolean("completed"));
					return todo;
				}
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void addTodo(Todo todo) {
		String sql="insert into todo(text,completed)values(?,?)";
		try(PreparedStatement pstmt=conn.prepareStatement(sql)){
			pstmt.setString(1, todo.getText());
			pstmt.setBoolean(2, todo.getCompleted());
			int rowcount=pstmt.executeUpdate();
			System.out.println("新增todo筆數"+rowcount);
		}catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void updateTotoComplete(Integer id, Boolean completed) {
		String sql="update todo set completed=? where id=?";
		try (PreparedStatement pstmt=conn.prepareStatement(sql)){
			pstmt.setBoolean(1, completed);
			pstmt.setInt(2, id);
			int rowcount=pstmt.executeUpdate();
			System.out.println("修改todo筆數"+rowcount);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void updateTotoText(Integer id, String text) {
		String sql="update todo set text=? where id=?";
		try(PreparedStatement pstmt=conn.prepareStatement(sql)){
			pstmt.setString(1, text);
			pstmt.setInt(2, id);
			int rowcount=pstmt.executeUpdate();
			System.out.println("修改todo筆數"+rowcount);
		}catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void deleteTodo(Integer id) {
		String sql="delete from todo where id=?";
		try(PreparedStatement pstmt=conn.prepareStatement(sql)) {
			pstmt.setInt(1, id);
			int rowcount=pstmt.executeUpdate();
			System.out.println("刪除todo筆數"+rowcount);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	

}
