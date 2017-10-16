package dk.jarry.todo.boundary;

import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;
import javax.ejb.Stateless;

import dk.jarry.todo.entity.ToDo;

@Stateless
public class ToDoService {

	private static Map<String, ToDo> toDos = new ConcurrentHashMap<>();
	
	public ToDoService() {
		
	}
	
	@PostConstruct
	public void init() {
		
	}
	
	public ToDo create(ToDo toDo) {
		
		if(toDo.getId() == null) {
			toDo.setId(UUID.randomUUID().toString());
		}
		
		toDos.put(toDo.getId(), toDo);
		
		return toDo;
		
	}
	
	
	public ToDo read(String id) {
		
		ToDo toDo = toDos.get(id);
		
		return toDo;
	}
	
	public ToDo update(ToDo toDo) {
		
		toDos.put(toDo.getId(), toDo);
		
		return toDo;
	}
	
	public void delete(String id) {
		
		toDos.remove(id);
		
	}
	
	public List<ToDo> list(Long from , Long limit){
	
		if(limit == null) {
			limit = Long.valueOf(50);
		}
		
		List<ToDo> list = toDos.values().stream().limit(limit).collect(Collectors.toList());
		
		return list;
		
	}
}
