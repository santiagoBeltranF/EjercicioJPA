package eam.edu.co.prestamolibro.prestamolibro.repositorio

import eam.edu.co.prestamolibro.prestamolibro.Modelo.User
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component
import org.springframework.transaction.annotation.Transactional
import javax.persistence.EntityManager
import javax.persistence.Query

@Component //anotacion que nos dice que esta es una clase manejada por springboot
@Transactional //para que las operaciones sobre la BD funcionen.
class UsuarioRepo {
    //inyeccion de depencia...... el framework se encarga de asignarle valor a la depencia
    @Autowired //esta anotacion indica que springboot se encargara de instanciar esta clase.
    lateinit var em: EntityManager //clase que nos da JPA para manipular las entidades.
    fun createUsuario(user: User){
        em.persist(user) //inserta en la tabla que define la entidad.
    }
    //? quiere decir q algo puede ser null
    fun findUsuario(identification:String): User?{
        //se el envia la clase que quiero buscar y el valor de la llave primaria que quiero buscar.
        return em.find(User::class.java,identification) //busca en la bd por llave primaria
    }
    fun updateUsuario(usuario: User) {
        em.merge(usuario) //actualizar un registro sobre la BD
    }
    fun deleteUsuario(identification: String) {
        //buscan por id la entidad que quiero borrar
        val user = findUsuario(identification)

        //solo puedo borrar una persona que exista...
        if (user!=null) {
            //borra la entidad de la BD, recibe por parametro la entidad a borrrar
            em.remove(user)
        }
    }
    fun findAll(): List<User> {
        /*
        Estructura de una consulta:
        SELECT <proyeccion> FROM <entidad> <objeto> WHERE <predicados>
        proyeccion: que quiero retornar en la consulta
        entidad: la entidad que va participar en la consulta
        objeto: el objeto sobre el cual se van hacer la proyecciones y los predicados, le pueden poner el nombre que quieran
        predicados: las condiciones de la consulta
         */
        val query: Query = em.createQuery("SELECT usr FROM User usr")

        //ejecutar la consulta...
        return query.resultList as List<User>
    }
}