package pl.wsb.projekt.springmvcprojektapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import pl.wsb.projekt.springmvcprojektapp.model.ToDoList;
import pl.wsb.projekt.springmvcprojektapp.service.ToDoListService;

@Controller
@RequestMapping("/toDoList")
public class ToDoListController {

    @Autowired
    private ToDoListService toDoListService;

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("listToDoLists", toDoListService.listAll());
        return "toDoList/index";
    }

    @RequestMapping("/new")
    public String create(Model model) {
        ToDoList toDoList = new ToDoList();
        model.addAttribute("toDoList", toDoList);
        return "toDoList/new";
    }

    @PostMapping("/save")
    public String saveToDoList(@ModelAttribute("toDoList") ToDoList toDoList) {
        toDoListService.save(toDoList);
        return "redirect:/toDoList/";
    }


    @RequestMapping("/edit/{id}")
    public ModelAndView edit(@PathVariable(name = "id") int id) {
        ModelAndView modelAndView = new ModelAndView("toDoList/edit");
        modelAndView.addObject("list", toDoListService.find(id));
        return modelAndView;
    }

    @RequestMapping("/delete/{id}")
    public String deleteToDoList(@PathVariable(name = "id") int id) {
        toDoListService.delete(id);
        return "redirect:/toDoList/";
    }
}
