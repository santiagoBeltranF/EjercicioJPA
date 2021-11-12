package eam.edu.co.prestamolibro.prestamolibro.controllers

import eam.edu.co.prestamolibro.prestamolibro.Modelo.Author
import eam.edu.co.prestamolibro.prestamolibro.Modelo.AuthorBook
import eam.edu.co.prestamolibro.prestamolibro.servirces.AuthorBookServices
import eam.edu.co.prestamolibro.prestamolibro.servirces.AutorService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
@RestController
/**
 * todas las operaciones que se definan en este controlador empezaran por /person
 */
@RequestMapping("/authorbook")
class AuthorBookController {
    @Autowired
    lateinit var authorBookServices: AuthorBookServices

    @PostMapping //POST http://localhost:8081/persons
    fun createAthorBook(@RequestBody authorBook: AuthorBook) {
        authorBookServices.createAutorBook(authorBook)
    }

}