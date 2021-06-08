package pl.wsb.projekt.springmvcprojektapp.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.wsb.projekt.springmvcprojektapp.dto.UserDTO;
import pl.wsb.projekt.springmvcprojektapp.mapper.UserMapper;
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
}
