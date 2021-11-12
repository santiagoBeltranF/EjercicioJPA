package eam.edu.co.prestamolibro.prestamolibro.controllers

import eam.edu.co.prestamolibro.prestamolibro.Modelo.User
import eam.edu.co.prestamolibro.prestamolibro.servirces.UserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
import javax.persistence.EntityNotFoundException
@RestController
/**
 * todas las operaciones que se definan en este controlador empezaran por /person
 */
@RequestMapping("/users")
class UserControllers {
    @Autowired
    lateinit var userService: UserService

    /**
     * URI: persons: la reglas para definir la uri:
     *     1. los recursos se deben nombrar sustantivos en plural
     * Method: POST
     *
     * Params: Body
     *
     * Result: void
     *
     */
    //la URI aqui es lo que defina el requestMapping + la URI que defina el postmaping
    @PostMapping //POST http://localhost:8081/persons
    fun createPerson(@RequestBody user: User) {
        userService.createUser(user)
    }

    /**
     * /persons/{id} nos dice que llega un path parametro que se llama id
     * @PathVariable nos inidica que el parametro llega como patparam
     */
    @GetMapping("/{id}")  //uri = /persons/10 , buscando la persona 10
    fun findUserById(@PathVariable("identification") identification: String) =
        userService.findUser(identification) ?: throw EntityNotFoundException("User not found")


    /*@GetMapping("/persons")  //uri = /persons/10 , buscando la persona 10
    fun findPersonById2(@RequestParam("id") id: String?): Any? {
        return if (id == null) personService.getAllPerson() else personService.findPerson(id)
    }*/

    @GetMapping
    fun getAllUser() = userService.getAllUser()

    @PutMapping("/{id}") //el uri apunta a una persona especifica
    fun editUser(@PathVariable identification: String, @RequestBody usuario: User) {
        usuario.identification = identification
        userService.editUser(usuario)
    }

    @DeleteMapping("/{id}")
    fun deleteUser(@PathVariable id: String) = userService.deleteUser(id)

    //contacts/{{id}} ---> GET /contacts/1--> expresando es el contacto con id X
    //los contactos de una persona  GET /persons/{{id}}/contacts
    //todos los contactos  GET /persons/contacts (estaria esperando la info de las personas) , GET /contacts (solo la info de los contacts
    //agregar un contacto a una persona: POST  /persons/{{id}}/contacts


}