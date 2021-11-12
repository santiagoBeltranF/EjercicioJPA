package eam.edu.co.prestamolibro.prestamolibro.servirces

import eam.edu.co.prestamolibro.prestamolibro.Modelo.Author
import eam.edu.co.prestamolibro.prestamolibro.Modelo.Borrow
import eam.edu.co.prestamolibro.prestamolibro.exceptions.BusinessException
import eam.edu.co.prestamolibro.prestamolibro.repositorio.AutorRepo
import eam.edu.co.prestamolibro.prestamolibro.repositorio.PrestamoRepo
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import javax.persistence.EntityManager

@Service

class BorrowServices {
    @Autowired
    lateinit var prestamoRepo: PrestamoRepo
    @Autowired
    lateinit var entityManager: EntityManager

    fun createBorrow(borrow: Borrow) {
        val autorById = prestamoRepo.findPrestamo(borrow.id)

        if(autorById != null){
            throw BusinessException("This Borrow already exists")
        }
        prestamoRepo.createPrestamo(borrow)

    }
}