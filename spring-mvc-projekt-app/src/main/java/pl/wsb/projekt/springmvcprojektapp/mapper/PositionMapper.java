package pl.wsb.projekt.springmvcprojektapp.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import pl.wsb.projekt.springmvcprojektapp.dto.PositionDTO;
import pl.wsb.projekt.springmvcprojektapp.model.Position;


import java.util.List;

@Mapper(componentModel = "spring")
public interface PositionMapper {

    @Mappings({
            @Mapping(target="id", source="entity.id"),
            @Mapping(target="title", source="entity.title"),
            @Mapping(target="description", source="entity.description"),
            @Mapping(target="created", source="entity.created"),
            @Mapping(target="modified", source="entity.modified"),
            @Mapping(target="listId", source="entity.toDoList.id")
    })
    PositionDTO positionToPositionDTO(Position entity);
    @Mappings({
            @Mapping(target="id", source="dto.id"),
            @Mapping(target="title", source="dto.title"),
            @Mapping(target="description", source="dto.description"),
            @Mapping(target="created", source="dto.created"),
            @Mapping(target="modified", source="dto.modified"),
            @Mapping(target="toDoList.id", source="dto.listId")
    })
    Position positionDTOToPosition(PositionDTO dto);
    List<PositionDTO> map(Iterable<Position> toDoLists);
}
