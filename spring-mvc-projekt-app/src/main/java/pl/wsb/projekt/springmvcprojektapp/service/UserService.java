package pl.wsb.projekt.springmvcprojektapp.service;

import org.springframework.stereotype.Service;
import pl.wsb.projekt.springmvcprojektapp.model.ToDoList;
import pl.wsb.projekt.springmvcprojektapp.model.User;
import pl.wsb.projekt.springmvcprojektapp.repository.ToDoListRepository;
import pl.wsb.projekt.springmvcprojektapp.repository.UserRepository;

import javax.transaction.Transactional;
import java.util.Date;

@Service
@Transactional
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Iterable<User> listAll(){
        return userRepository.findAll();
    }

    public User find(Integer id) {
        return userRepository.findById(id).orElse(null);
    }

    public void delete(Integer id) {
        userRepository.deleteById(id);
    }
}
