package eam.edu.co.prestamolibro.prestamolibro.Modelo

import java.io.Serializable
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name="Autor")
data class Autor(
    @Id
    @Column(name="Codigo_Autor")
    val codigoAutor:Long,
    @Column(name="nombre")
    var name:String,
    @Column(name="apellido")
    var lastname:String
):Serializable
