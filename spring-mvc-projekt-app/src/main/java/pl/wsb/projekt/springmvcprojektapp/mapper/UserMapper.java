package pl.wsb.projekt.springmvcprojektapp.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import pl.wsb.projekt.springmvcprojektapp.dto.UserDTO;
import pl.wsb.projekt.springmvcprojektapp.model.User;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {

    @Mappings({
            @Mapping(target="id", source="entity.id"),
            @Mapping(target="email", source="entity.email"),
            @Mapping(target="lists", source="entity.toDoLists"),

    })
    UserDTO userToUserDTO(User entity);
    @Mappings({
            @Mapping(target="id", source="dto.id"),
            @Mapping(target="email", source="dto.email"),
            @Mapping(target="toDoLists", source="dto.lists"),
    })
    User toDoListDTOToToDoList(UserDTO dto);
    List<UserDTO> map(Iterable<User> users);
}
