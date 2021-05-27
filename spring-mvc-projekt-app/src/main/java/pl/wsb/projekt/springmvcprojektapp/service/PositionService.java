package pl.wsb.projekt.springmvcprojektapp.service;

import org.springframework.stereotype.Service;
import pl.wsb.projekt.springmvcprojektapp.model.Position;
import pl.wsb.projekt.springmvcprojektapp.model.ToDoList;
import pl.wsb.projekt.springmvcprojektapp.repository.PositionRepository;
import pl.wsb.projekt.springmvcprojektapp.repository.ToDoListRepository;

import javax.transaction.Transactional;
import java.util.Date;

@Service
@Transactional
public class PositionService {
    private final PositionRepository positionRepository;

    public PositionService(PositionRepository positionRepository) {
        this.positionRepository = positionRepository;
    }

    public Iterable<Position> listAll(){
        return positionRepository.findAll();
    }

    public void save(Position position) {
        if (position.getModified() == null) {
            position.setModified(new Date());
        } //if
        positionRepository.save(position);
    }

    public Position find(Integer id) {
        return positionRepository.findById(id).orElse(null);
    }

    public void delete(Integer id) {
        positionRepository.deleteById(id);
    }
}
