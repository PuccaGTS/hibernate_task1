package ru.netology.netolhiber1.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.netology.netolhiber1.entity.Person;
import ru.netology.netolhiber1.repository.PersonRepository;

import javax.annotation.security.RolesAllowed;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/")
@RequiredArgsConstructor
public class NewController {
    private final PersonRepository personRepository;
    @GetMapping("persons/by-city")
    @Secured("ROLE_READ")
    public List<Person> getPersonByCity(@RequestParam String city){
        return personRepository.getPersonByCity(city);
    }

    @GetMapping("persons/by-age")
    @RolesAllowed("ROLE_WRITE")
    public List<Person> getPersonByAge(@RequestParam int age){
        return personRepository.getPersonByAgeBeforeOrderByAge(age);
    }

    @GetMapping("persons/by-name-surname")
    @PreAuthorize("hasAnyRole('ROLE_WRITE') or hasAnyRole('ROLE_DELETE')")
    public Optional<Person> getPersonByNameSurname(@RequestParam String name, @RequestParam String surname){
        return personRepository.getPersonByNameAndSurname(name, surname);
    }

    @GetMapping("get")
    public String helloUsername(@RequestParam String username){
        var authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication.getName().equals(username)){
            return "Hello " + username;
        } else {
            return null;
        }
    }


}
