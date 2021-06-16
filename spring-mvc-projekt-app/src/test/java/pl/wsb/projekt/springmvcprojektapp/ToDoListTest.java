package pl.wsb.projekt.springmvcprojektapp;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import pl.wsb.projekt.springmvcprojektapp.model.ToDoList;
import pl.wsb.projekt.springmvcprojektapp.repository.ToDoListRepository;
import pl.wsb.projekt.springmvcprojektapp.service.ToDoListService;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Date;
import java.util.Optional;
import java.util.stream.StreamSupport;

import static org.mockito.Mockito.doReturn;

@SpringBootTest
public class ToDoListTest {

    @Autowired
    private ToDoListService service;

    @MockBean
    private ToDoListRepository repository;

    @Test
    void listAll_whenFound_thenReturnResult() {
        ToDoList toDoList = new ToDoList(1,"tytul_1","opis_1","Praca",new Date(), new Date());
        ToDoList toDoList2 = new ToDoList(2,"tytul_2","opis_2","Dom",new Date(), new Date());

        doReturn(Arrays.asList(toDoList, toDoList2)).when(repository).findAll();

        Iterable<ToDoList> toDoLists = service.listAll();

        Assertions.assertEquals(2, StreamSupport.stream(toDoLists.spliterator(), false).count());

    }

    @Test
    void listAll_whenNotFound_thenReturnNotFound() {

        doReturn(Optional.empty()).when(repository).findById(100);

        ToDoList result = service.find(100);

        Assertions.assertTrue((result==null));

    }
}
