package com.example.lib


open class Cliente(nombre:String,direccion:String,frecunte: Boolean){

}

open class Producto(nombre: String,precioBase:Double){
    open fun calcularPrecioFinal(): Double{
        var PrecioFinal=0.0

        return PrecioFinal
    }
}

class Plato(
    nombre: String,
    precioBase: Double,
    val tamanoPorcion: String
): Producto(nombre,precioBase){
    override fun calcularPrecioFinal(): Double {
        if (tamanoPorcion=="Grande"){
            precioFinal
        }
    }
}

class Bebida(
    nombre: String,
    precioBase: Double,
    val esAlcoholica: Boolean
): Producto(nombre,precioBase){
    override fun calcularPrecioFinal(){
        PrecioFinal=precioBase+800
    }
}

fun main(){
    val hora=12
    val recargo =0
    val subTotal=0
    if (hora>=22||hora<6){
        val recargo = 1000
    }
    if(subTotal>=15000&&cliente.frecuente==1){
        println("Tiene envio gratis")
    }



}