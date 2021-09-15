package eam.edu.co.prestamolibro.prestamolibro.Modelo

import java.io.Serializable
import javax.persistence.*

@Entity
@Table(name="Libro")
data class Libro(
    @Id
    @Column(name="codigo_autor")
    var code:String,
    @Column(name="isbn_libro")
    val isbn:String,
    @Column(name="nombre_libro")
    val name:String,
    @ManyToOne
    @JoinColumn(name ="codigo_editorial")
    var  Codigo_Editorial:Editorial
):Serializable
