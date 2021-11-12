package eam.edu.co.prestamolibro.prestamolibro.controllers

import eam.edu.co.prestamolibro.prestamolibro.Modelo.Publisher
import eam.edu.co.prestamolibro.prestamolibro.servirces.PublisherServices
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
/**
 * todas las operaciones que se definan en este controlador empezaran por /person
 */
@RequestMapping("/publishers")
class PublishersControllers {
    @Autowired
    lateinit var publisherServices: PublisherServices

    @PostMapping //POST http://localhost:8081/persons
    fun createBook(@RequestBody editorial: Publisher) {
        publisherServices.createPublisher(editorial)
    }
}