package pl.wsb.projekt.springmvcprojektapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.wsb.projekt.springmvcprojektapp.dto.ToDoListDTO;
import pl.wsb.projekt.springmvcprojektapp.mapper.ToDoListMapper;
import pl.wsb.projekt.springmvcprojektapp.model.ToDoList;
import pl.wsb.projekt.springmvcprojektapp.service.ToDoListService;

@CrossOrigin(origins = { "http://localhost:8080" })
@RestController
@RequestMapping("${url.prefix.api.v1}/toDoList")
public class RestToDoListController {

    @Autowired
    private ToDoListService toDoListService;

    @Autowired
    private ToDoListMapper toDoListMapper;

    @GetMapping("/")
    public ResponseEntity<Iterable<ToDoListDTO>> index() {
        try {
            return new ResponseEntity<>(
                    toDoListMapper.map(
                            toDoListService.listAll()
                    ),
                    HttpStatus.OK
            );
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/")
    public ResponseEntity<Void> createActor(@RequestBody ToDoListDTO toDoListDTO) {
        try {
            toDoListService.save(
                    toDoListMapper.toDoListDTOToToDoList(
                            toDoListDTO
                    )
            );
            return new ResponseEntity<>(null, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<ToDoListDTO> updateToDoList(@PathVariable("id") Integer id,
                                                @RequestBody ToDoListDTO toDoListDTO) {
        try {
            ToDoList toDoListEntity = toDoListService.find(id);
            if (toDoListEntity == null) {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            } //if
            toDoListService.save(
                    toDoListMapper.toDoListDTOToToDoList(
                            toDoListDTO
                    )
            );
            return new ResponseEntity<>(
                    toDoListMapper.toDoListToToDoListDTO(
                            toDoListEntity
                    ),
                    HttpStatus.OK
            );
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteToDoList(@PathVariable("id") Integer id) {
        try {
            ToDoList toDoListEntity = toDoListService.find(id);
            if (toDoListEntity == null) {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            } //if
            toDoListService.delete(id);
            return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


}
