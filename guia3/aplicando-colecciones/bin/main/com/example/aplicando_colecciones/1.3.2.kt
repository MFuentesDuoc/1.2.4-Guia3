package com.example.aplicando_colecciones

open class Persona(val nombre: String, val edad: Int) {
    open fun presentarse() {
        println("Hola, mi nombre es $nombre.")
    }
}

class Empleado(
    nombre: String,
    edad: Int,
    val puesto: String,
    private val salario: Double
) : Persona(nombre, edad) {

    fun mostrarPuesto() {
        println("$nombre trabaja como $puesto.")
    }

    override fun presentarse() {
        println("Hola, soy $nombre y mi puesto es $puesto.")
    }
}

fun main() {
    val personaBase = Persona("Carlos", 45)
    val empleadoActivo = Empleado("Valeria", 32, "Ingeniera de Software", 2800000.0)

    personaBase.presentarse()
    empleadoActivo.presentarse()
    empleadoActivo.mostrarPuesto()
}