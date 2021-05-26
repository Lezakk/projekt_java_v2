package pl.wsb.projekt.springmvcprojektapp.repository;

import org.springframework.data.repository.CrudRepository;
import pl.wsb.projekt.springmvcprojektapp.model.ToDoList;

public interface ToDoListRepository extends CrudRepository<ToDoList, Integer> {
}
