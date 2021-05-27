package pl.wsb.projekt.springmvcprojektapp.repository;

import org.springframework.data.repository.CrudRepository;
import pl.wsb.projekt.springmvcprojektapp.model.Position;

public interface PositionRepository extends CrudRepository<Position, Integer> {
}
