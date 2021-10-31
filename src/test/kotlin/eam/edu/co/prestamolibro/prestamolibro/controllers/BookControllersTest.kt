package eam.edu.co.prestamolibro.prestamolibro.controllers

import com.fasterxml.jackson.databind.ObjectMapper
import eam.edu.co.prestamolibro.prestamolibro.Modelo.Book
import eam.edu.co.prestamolibro.prestamolibro.Modelo.Publisher
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import org.springframework.transaction.annotation.Transactional
import javax.persistence.EntityManager
@SpringBootTest
@Transactional
//arrancar el servidor web
@AutoConfigureMockMvc

class BookControllersTest {
    @Autowired
    lateinit var mocMvc: MockMvc

    @Autowired
    lateinit var objectMapper: ObjectMapper

    @Autowired
    lateinit var entityManager: EntityManager


    @Test
    fun createBookHappyPathTest() {
        //prerequisitos..
        val publisher = Publisher("1", "Castellana")
        entityManager.persist(publisher)
        val body = """
           {
            "code": "6",
            "isbn": "5454654",
            "name":  "Harry",
            "editorial":{
                "code": "1",
                "name": "Castellana"
            }
            }
        """.trimIndent()

        val request = MockMvcRequestBuilders
            .post("/books")
            .contentType(MediaType.APPLICATION_JSON)
            .content(body)
        val response = mocMvc.perform(request)
        val resp = response.andReturn().response
        //println(resp.contentAsString)
        Assertions.assertEquals(200, resp.status)
    }
    @Test
    fun createBookNotFoundTest() {
        val publisher= Publisher("1","Norma")
        entityManager.persist(publisher)
        entityManager.persist((Book("6","5454654","Harry",publisher)))
        val body = """
           {
            "code": "6",
            "isbn": "5454654",
            "name":  "Harry",
            "editorial":{
                "code": "1",
                "name": "Castellana"
            }
            }
        """.trimIndent()
        val request = MockMvcRequestBuilders
            .post("/books")
            .contentType(MediaType.APPLICATION_JSON)
            .content(body)
        val response = mocMvc.perform(request)
        val resp = response.andReturn().response
        //println(resp.contentAsString)
        Assertions.assertEquals(412, resp.status)
        Assertions.assertEquals("{\"message\":\"This Book already exists\",\"code\":412}".trimIndent(),
            resp.contentAsString)
    }

    @Test
    fun editBookHappyPathTest() {
        //prerequisitos..
        val publisher= Publisher("1","Norma")
        entityManager.persist(publisher)
        entityManager.persist((Book("6","5454654","Harry",publisher)))

        val body = """
           {
            "code": "6",
            "isbn": "5454654",
            "name":  "Harry",
            "editorial":{
                "code": "1",
                "name": "Castellana"
            }
            }
        """.trimIndent()

        val request = MockMvcRequestBuilders
            .put("/books/6")
            .contentType(MediaType.APPLICATION_JSON)
            .content(body)

        val response = mocMvc.perform(request)
        val resp = response.andReturn().response
        //println(resp.contentAsString)
        Assertions.assertEquals(200, resp.status)
    }
}