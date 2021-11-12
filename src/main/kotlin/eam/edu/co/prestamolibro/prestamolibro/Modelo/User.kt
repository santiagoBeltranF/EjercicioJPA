package eam.edu.co.prestamolibro.prestamolibro.Modelo

import java.io.Serializable
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name="Usuarios")
data class User(
    @Id
    @Column(name="user_identification")
    var identification:String,
    @Column(name="nombre_usuario")
    var name:String,
    @Column(name="apellido_usuario")
    var lastname:String
):Serializable
