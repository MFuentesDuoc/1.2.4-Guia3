package com.example.aplicando_colecciones

open class persona(val nombre: String,val rut: String,val fechanacimiento: String,val edad: Int){

    fun mostrarInfo(){
        println(nombre)
        println(rut)
        println(fechanacimiento)
        println(edad)
    }
}

class empleado(nombre: String, rut: String, fechanacimiento: String, edad: Int, val cargo: String, val sueldo: Int): persona(nombre, rut, fechanacimiento, edad){
    fun calculabonificacion(){
        val bonificacion=1.3
        println("su bonidicacion es: "+ sueldo*bonificacion)
    }


}



fun main(){
    val primerapersona=persona("martin","3151fag","22/06/2004",22)
    primerapersona.mostrarInfo()
    val primerempleado= empleado("juan","af0afia","22/22/22",35,"jefe",35000)
    primerempleado.mostrarInfo()
    primerempleado.calculabonificacion()



}
