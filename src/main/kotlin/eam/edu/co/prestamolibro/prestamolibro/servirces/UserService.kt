package eam.edu.co.prestamolibro.prestamolibro.servirces


import eam.edu.co.prestamolibro.prestamolibro.Modelo.User
import eam.edu.co.prestamolibro.prestamolibro.exceptions.BusinessException
import eam.edu.co.prestamolibro.prestamolibro.repositorio.UsuarioRepo
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import javax.persistence.EntityManager
import javax.persistence.EntityNotFoundException

@Service
class UserService {
    @Autowired
    lateinit var usuarioRepo: UsuarioRepo



    fun createUser(user: User) {
        val userById = usuarioRepo.findUsuario(user.identification?:"")

        if(userById != null){
            throw BusinessException("This User already exists")
        }
        usuarioRepo.createUsuario(user)
    }
    fun editUser(user: User) {
        // ?: elvis operator nos indica que queremos hacer si esto retorna null
        /*
        val res = personRepository.find(person.id) ?: Person()
        //en caso de que personRepository.find(person.id) retorne null, se asigna a res Person()

        val res = a ?: 1 //si a es null, res = 1
         */
        usuarioRepo.findUsuario(user.identification?:"") ?: throw EntityNotFoundException("This user does not exist")
        usuarioRepo.updateUsuario(user)
    }

    fun deleteUser(identification: String) {
        usuarioRepo.findUsuario(identification) ?: throw EntityNotFoundException("This user does not exist")
        usuarioRepo.deleteUsuario(identification)
    }

    fun findUser(identification: String) = usuarioRepo.findUsuario(identification) // ?: throw EntityNotFoundException("Not found")

    fun getAllUser() = usuarioRepo.findAll()
}
