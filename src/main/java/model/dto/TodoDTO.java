package model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TodoDTO {
		private Integer id; //Integer default==null 可以知道有沒有被初始化
		private String text;
		private Boolean completed;
}
