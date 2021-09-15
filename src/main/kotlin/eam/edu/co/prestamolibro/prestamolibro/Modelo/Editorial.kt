package eam.edu.co.prestamolibro.prestamolibro.Modelo

import java.io.Serializable
import javax.persistence.*

@Entity
@Table(name="Editorial")
data class Editorial(
    @Id
    @Column(name="codigo_editorial")
    var code:Long,
    @Column(name="nombre_editorial")
    val name:String

):Serializable
