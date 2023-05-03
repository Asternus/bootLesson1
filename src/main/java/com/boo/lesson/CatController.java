package com.boo.lesson;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Controller
public class CatController {
    private final CatService catService;

    @Autowired
    public CatController(CatService catService) {
        this.catService = catService;
    }

    @Value("${app.name}")
    private String appName;

    @Value("#{${valuesMap}}")
    private Map<String, Integer> valuesMap;

    @GetMapping("/")
    public String adminAddUser(Model model) {
        final Cat cat = new Cat();
        cat.setName("Tom");
        catService.saveCat(cat);

        final Integer integer = valuesMap.get("key1");
        model.addAttribute("name", appName);
        model.addAttribute("map", integer);
        return "hello";
    }

    @GetMapping("/cat")
    public String getCat(Model model) {
        final Cat catById = catService.getCatById(1);
        model.addAttribute("cat", catById);
        return "cat";
    }

    @GetMapping("/get-all-cats")
    public String getAllCats(Model model) {
        final List<Cat> allCats = catService.getAllCats();
        model.addAttribute("allCats", allCats);
        return "getAllCats";
    }

  /*  @PostMapping("/cat")
    public String add(@RequestParam Map<String, String> form) {
        catService.saveCat(form.get("name"), form.get("type"));
        return "redirect:/user";
    }*/

    @GetMapping("/form")
    public String showStudentForm(Model model) {
        return "addCat";
    }

    @GetMapping("/allCats")
    public String home(Model model) {
        return "allCats";
    }

    @PostMapping("/add")
    public String addStudent(@Valid Cat cat,
                             BindingResult bindingResult,
                             Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("errors", "name should be not null");
            return "allCats";
        }

        final Optional<Cat> byEmail = catService.getByEmail(cat.getEmail());

        if (byEmail.isPresent()) {
            model.addAttribute("emailError", "you should use original email");
            return "allCats";
        }

        catService.saveCat(cat);

        return "redirect:/allCats";
    }


}
