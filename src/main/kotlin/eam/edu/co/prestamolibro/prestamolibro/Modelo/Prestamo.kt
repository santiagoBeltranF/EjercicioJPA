package eam.edu.co.prestamolibro.prestamolibro.Modelo

import java.io.Serializable
import java.util.*
import javax.persistence.*

@Entity
@Table(name="Prestamo")
data class Prestamo(
    @Id
    @Column(name="codigo_Prestamo")
    var id:Long,
    @ManyToOne
    @JoinColumn(name="id_libro")
    var libro:Libro,
    @ManyToOne
    @JoinColumn(name="id_usuario")
    var usuario:Usuario,
    @Column(name="fecha_hora")
    val dateTime:Date
):Serializable
