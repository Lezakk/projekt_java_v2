package pl.wsb.projekt.springmvcprojektapp.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.wsb.projekt.springmvcprojektapp.dto.UserDTO;
import pl.wsb.projekt.springmvcprojektapp.mapper.UserMapper;
import pl.wsb.projekt.springmvcprojektapp.model.User;
import pl.wsb.projekt.springmvcprojektapp.service.UserService;

@CrossOrigin(origins = {"http://localhost:8080"})
@RestController
@RequestMapping("${url.prefix.api.v1}/users")
public class RestUserController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserMapper userMapper;

    @GetMapping("/")
    public ResponseEntity<Iterable<UserDTO>> index() {
        try {
            return new ResponseEntity<>(
                    userMapper.map(
                            userService.listAll()
                    ),
                    HttpStatus.OK
            );
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDTO> findUser(@PathVariable("id") Integer id)  {
        try {
            User userEntity = userService.find(id);
            if (userEntity == null) {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            } //if
            return new ResponseEntity<>(
                    userMapper.userToUserDTO(
                            userEntity
                    ), HttpStatus.OK
            );
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserDTO> updateUser(@PathVariable("id") Integer id,
                                                      @RequestBody UserDTO userDTO) {
        try {
            User userEntity = userService.find(id);
            if (userEntity == null) {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            } //if
            userService.save(
                    userMapper.userDTOToUser(
                            userDTO
                    )
            );
            return new ResponseEntity<>(
                    userMapper.userToUserDTO(
                            userEntity
                    ),
                    HttpStatus.OK
            );
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable("id") Integer id) {
        try {
            User userEntity = userService.find(id);
            if (userEntity == null) {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            } //if
            userService.delete(id);
            return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
