package pl.wsb.projekt.springmvcprojektapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.wsb.projekt.springmvcprojektapp.dto.PositionDTO;
import pl.wsb.projekt.springmvcprojektapp.dto.ToDoListDTO;
import pl.wsb.projekt.springmvcprojektapp.mapper.PositionMapper;
import pl.wsb.projekt.springmvcprojektapp.mapper.ToDoListMapper;
import pl.wsb.projekt.springmvcprojektapp.model.Position;
import pl.wsb.projekt.springmvcprojektapp.model.ToDoList;
import pl.wsb.projekt.springmvcprojektapp.service.PositionService;
import pl.wsb.projekt.springmvcprojektapp.service.ToDoListService;

@CrossOrigin(origins = { "http://localhost:8080" })
@RestController
@RequestMapping("${url.prefix.api.v1}/position")
public class RestPositionController {

    @Autowired
    private PositionService positionService;

    @Autowired
    private PositionMapper positionMapper;

    @GetMapping("/")
    public ResponseEntity<Iterable<PositionDTO>> index() {
        try {
            return new ResponseEntity<>(
                    positionMapper.map(
                            positionService.listAll()
                    ),
                    HttpStatus.OK
            );
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/")
    public ResponseEntity<Void> createPosition(@RequestBody PositionDTO positionDTO) {
        try {
            positionService.save(
                    positionMapper.positionDTOToPosition(
                            positionDTO
                    )
            );
            return new ResponseEntity<>(null, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<PositionDTO> updatePosition(@PathVariable("id") Integer id,
                                                      @RequestBody PositionDTO positionDTO) {
        try {
            Position positionEntity = positionService.find(id);
            if (positionEntity == null) {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            } //if
            positionService.save(
                    positionMapper.positionDTOToPosition(
                            positionDTO
                    )
            );
            return new ResponseEntity<>(
                    positionMapper.toDoListToToDoListDTO(
                            positionEntity
                    ),
                    HttpStatus.OK
            );
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePosition(@PathVariable("id") Integer id) {
        try {
            Position positionEntity = positionService.find(id);
            if (positionEntity == null) {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            } //if
            positionService.delete(id);
            return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
