package pl.wsb.projekt.springmvcprojektapp.service;

import org.springframework.stereotype.Service;
import pl.wsb.projekt.springmvcprojektapp.model.ToDoList;
import pl.wsb.projekt.springmvcprojektapp.repository.ToDoListRepository;

import javax.transaction.Transactional;
import java.util.Date;

@Service
@Transactional
public class ToDoListService {

    private final ToDoListRepository toDoListRepository;

    public ToDoListService(ToDoListRepository toDoListRepository) {
        this.toDoListRepository = toDoListRepository;
    }

    public Iterable<ToDoList> listAll(){
        return toDoListRepository.findAll();
    }

    public void save(ToDoList toDoList) {
        if (toDoList.getModified() == null) {
            toDoList.setModified(new Date());
        } //if
        toDoListRepository.save(toDoList);
    }

    public ToDoList find(Integer id) {
        return toDoListRepository.findById(id).orElse(null);
    }

    public void delete(Integer id) {
        toDoListRepository.deleteById(id);
    }

}
