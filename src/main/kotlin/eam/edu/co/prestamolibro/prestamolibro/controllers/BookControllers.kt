package eam.edu.co.prestamolibro.prestamolibro.controllers

import eam.edu.co.prestamolibro.prestamolibro.Modelo.Book
import eam.edu.co.prestamolibro.prestamolibro.servirces.BookServices
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
/**
 * todas las operaciones que se definan en este controlador empezaran por /person
 */
@RequestMapping("/books")
class BookControllers {
    @Autowired
    lateinit var bookServices: BookServices

    @PostMapping //POST http://localhost:8081/persons
    fun createBook(@RequestBody book: Book) {
        bookServices.createBook(book)
    }

    @PutMapping("/{id}") //el uri apunta a una persona especifica
    fun editLibro(@PathVariable("id") code: String, @RequestBody book: Book) {
        book.code = code
        bookServices.editLibro(book)
    }
}