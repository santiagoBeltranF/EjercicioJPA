package eam.edu.co.prestamolibro.prestamolibro.Modelo

import java.io.Serializable
import javax.persistence.*

@Entity
@Table(name="Libro")
data class Book(
    @Id
    @Column(name="codigo_autor")
    var code:String,
    @Column(name="isbn_libro")
    var isbn:String,
    @Column(name="nombre_libro")
    var name:String,
    @ManyToOne
    @JoinColumn(name ="id_editorial")
    val  editorial:Publisher
):Serializable
