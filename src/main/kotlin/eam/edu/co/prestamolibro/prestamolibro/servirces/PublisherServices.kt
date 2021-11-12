package eam.edu.co.prestamolibro.prestamolibro.servirces

import eam.edu.co.prestamolibro.prestamolibro.Modelo.Publisher
import eam.edu.co.prestamolibro.prestamolibro.exceptions.BusinessException
import eam.edu.co.prestamolibro.prestamolibro.repositorio.EditorialRepo
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import javax.persistence.EntityManager
@Service
class PublisherServices {
    @Autowired
    lateinit var editorialRepo: EditorialRepo
    @Autowired
    lateinit var entityManager: EntityManager


    fun createPublisher(editorial:Publisher) {
        val publisherById = editorialRepo.findEditorial(editorial.code?:"")

        if(publisherById != null){
            throw BusinessException("This Publisher already exists")
        }
        editorialRepo.createEditorial(editorial)
    }
}