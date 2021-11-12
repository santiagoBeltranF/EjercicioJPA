package eam.edu.co.prestamolibro.prestamolibro.servirces


import eam.edu.co.prestamolibro.prestamolibro.Modelo.AuthorBook
import eam.edu.co.prestamolibro.prestamolibro.exceptions.BusinessException
import eam.edu.co.prestamolibro.prestamolibro.repositorio.AutorLibroRepo
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import javax.persistence.EntityManager

@Service
class AuthorBookServices {
    @Autowired
    lateinit var autorLibroRepo: AutorLibroRepo
    @Autowired
    lateinit var entityManager: EntityManager

    fun createAutorBook(authorBook: AuthorBook) {
        val autorById = autorLibroRepo.findAutorLibro(authorBook.id)

        if(autorById != null){
            throw BusinessException("This AuthorBook already exists")
        }
        autorLibroRepo.createAutorLibro(authorBook)

    }
}