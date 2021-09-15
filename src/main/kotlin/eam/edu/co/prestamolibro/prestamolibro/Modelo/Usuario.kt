package eam.edu.co.prestamolibro.prestamolibro.Modelo

import java.io.Serializable
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name="Usuarios")
data class Usuario(
    @Id
    @Column(name="cedula")
    var identification:String,
    @Column(name="nombre")
    val name:String,
    @Column(name="apellido")
    val lastname:String
):Serializable
