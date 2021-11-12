package eam.edu.co.prestamolibro.prestamolibro.controllers

import eam.edu.co.prestamolibro.prestamolibro.Modelo.Author
import eam.edu.co.prestamolibro.prestamolibro.Modelo.Book
import eam.edu.co.prestamolibro.prestamolibro.servirces.AutorService
import eam.edu.co.prestamolibro.prestamolibro.servirces.BookServices
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
/**
 * todas las operaciones que se definan en este controlador empezaran por /person
 */
@RequestMapping("/author")
class AuthorControllers {
    @Autowired
    lateinit var autorService: AutorService

    @PostMapping //POST http://localhost:8081/persons
    fun createBook(@RequestBody author: Author) {
        autorService.createAutor(author)
    }
}