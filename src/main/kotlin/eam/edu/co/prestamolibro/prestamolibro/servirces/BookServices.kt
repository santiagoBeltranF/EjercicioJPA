package eam.edu.co.prestamolibro.prestamolibro.servirces

import eam.edu.co.prestamolibro.prestamolibro.Modelo.Book
import eam.edu.co.prestamolibro.prestamolibro.exceptions.BusinessException
import eam.edu.co.prestamolibro.prestamolibro.repositorio.LibroRepo
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import javax.persistence.EntityManager
import javax.persistence.EntityNotFoundException

@Service
class BookServices {
    @Autowired
    lateinit var libroRepo: LibroRepo
    @Autowired
    lateinit var entityManager: EntityManager


    fun createBook(libro: Book) {
        val productById = libroRepo.findLirbo(libro.code?:"")

        if(productById != null){
            throw BusinessException("This Book already exists")
        }

        val productByNamE = libroRepo.findLirboName(libro.name)

        if(productByNamE != null){
            throw BusinessException("This Book name  already exists")
        }

        libroRepo.createLibro(libro)
    }
    fun editLibro(libro: Book){
        libroRepo.findLirbo(libro.code?:"") ?: throw EntityNotFoundException("This book does not exist")
        libroRepo.updateLibro(libro)
    }
}