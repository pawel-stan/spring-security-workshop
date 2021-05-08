package edu.wsb.authdemo.auth;

import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/people")
public class PersonController {

    private final PersonService personService;
    private final PersonRepository personRepository;

    public PersonController(PersonService personService, PersonRepository personRepository) {
        this.personService = personService;
        this.personRepository = personRepository;
    }

    @GetMapping("/")
    @Secured("ROLE_USERS_TAB")
    ModelAndView index() {
        ModelAndView modelAndView = new ModelAndView("people/index");
        modelAndView.addObject("people", personRepository.findAll());

        return modelAndView;
    }

//    @GetMapping("/create")
//    @Secured("ROLE_CREATE_USER")
//    ModelAndView create() {
//        ModelAndView modelAndView = new ModelAndView("people/create");
//        modelAndView.addObject("person", new Person());
//        return modelAndView;
//    }

    @RequestMapping("/save")
    @Secured("ROLE_CREATE_USER")
    ModelAndView save(@ModelAttribute Person person) {
        personService.savePerson(person);

        return new ModelAndView("redirect:/people/");
    }
}
