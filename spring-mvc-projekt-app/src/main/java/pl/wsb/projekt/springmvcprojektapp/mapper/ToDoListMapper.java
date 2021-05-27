package pl.wsb.projekt.springmvcprojektapp.mapper;


import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import pl.wsb.projekt.springmvcprojektapp.dto.ToDoListDTO;
import pl.wsb.projekt.springmvcprojektapp.model.ToDoList;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ToDoListMapper {
    @Mappings({
            @Mapping(target="id", source="entity.id"),
            @Mapping(target="title", source="entity.title"),
            @Mapping(target="description", source="entity.description"),
            @Mapping(target="listType", source="entity.listType"),
            @Mapping(target="created", source="entity.created"),
            @Mapping(target="modified", source="entity.modified")
    })
    ToDoListDTO toDoListToToDoListDTO(ToDoList entity);
    @Mappings({
            @Mapping(target="id", source="dto.id"),
            @Mapping(target="title", source="dto.title"),
            @Mapping(target="description", source="dto.description"),
            @Mapping(target="listType", source="dto.listType"),
            @Mapping(target="created", source="dto.created"),
            @Mapping(target="modified", source="dto.modified")
    })
    ToDoList toDoListDTOToToDoList(ToDoListDTO dto);
    List<ToDoListDTO> map(Iterable<ToDoList> toDoLists);
}