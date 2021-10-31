package eam.edu.co.prestamolibro.prestamolibro.controllers

import com.fasterxml.jackson.databind.ObjectMapper
import eam.edu.co.prestamolibro.prestamolibro.Modelo.User
import eam.edu.co.prestamolibro.prestamolibro.exceptions.ErrorResponse
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import org.springframework.test.web.servlet.result.MockMvcResultMatchers
import org.springframework.transaction.annotation.Transactional
import javax.persistence.EntityManager

@SpringBootTest
@Transactional
//arrancar el servidor web
@AutoConfigureMockMvc
class UserControllersTest {
    @Autowired
    lateinit var mocMvc: MockMvc

    @Autowired
    lateinit var objectMapper: ObjectMapper

    @Autowired
    lateinit var entityManager: EntityManager


        //prerequisitos..
        @Test
        fun createUserHappyPathTest() {
            val body = """
           {
            "identification": "1",
            "name": "Rodriguez",
            "lastname": "Javier"
            }
        """.trimIndent()

            val request = MockMvcRequestBuilders
                .post("/users")
                .contentType(MediaType.APPLICATION_JSON)
                .content(body)

            val response = mocMvc.perform(request)
            val resp = response.andReturn().response
            //println(resp.contentAsString)
            Assertions.assertEquals(200, resp.status)

        }
    @Test
    fun createUserNotFoundTest() {
            entityManager.persist(User("1","Rodriguez","Javier"))

        val body = """
           {
            "identification": "1",
            "name": "Rodriguez",
            "lastname": "Javier"
            }
        """.trimIndent()

        val request = MockMvcRequestBuilders
            .post("/users")
            .contentType(MediaType.APPLICATION_JSON)
            .content(body)

        val response = mocMvc.perform(request)
        val resp = response.andReturn().response
        //println(resp.contentAsString)
        Assertions.assertEquals(412, resp.status)
        Assertions.assertEquals("{\"message\":\"This User already exists\",\"code\":412}".trimIndent(),
            resp.contentAsString)
    }
    }



