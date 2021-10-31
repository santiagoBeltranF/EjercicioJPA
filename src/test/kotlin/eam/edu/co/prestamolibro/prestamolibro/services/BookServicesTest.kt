package eam.edu.co.prestamolibro.prestamolibro.services

import eam.edu.co.prestamolibro.prestamolibro.Modelo.Publisher
import eam.edu.co.prestamolibro.prestamolibro.Modelo.Book
import eam.edu.co.prestamolibro.prestamolibro.exceptions.BusinessException
import eam.edu.co.prestamolibro.prestamolibro.servirces.BookServices
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.transaction.annotation.Transactional
import javax.persistence.EntityManager

@SpringBootTest
@Transactional
class BookServicesTest {
    @Autowired
    lateinit var bookServices: BookServices

    @Autowired
    lateinit var entityManager: EntityManager

    @Test
    fun testCreateBookName() {
        val editorial= Publisher("1","nacho")
        entityManager.persist(editorial)
        entityManager.persist(Book("1","1","harryPotter", editorial))

        val exception = Assertions.assertThrows(BusinessException::class.java,
            {bookServices.createBook(Book("2","1","harryPotter", editorial))
            }
        )

        Assertions.assertEquals("This Book name  already exists", exception.message)

    }
    @Test
    fun testCreateBookCode() {
        val editorial= Publisher("1","nacho")
        entityManager.persist(editorial)
        entityManager.persist(Book("3","1","harryPotter", editorial))
        try {
            bookServices.createBook(Book("3","1","harryPotter", editorial))
            Assertions.fail()
        } catch (e: BusinessException) {
            Assertions.assertEquals("This Book already exists", e.message)

        }

    }



}
