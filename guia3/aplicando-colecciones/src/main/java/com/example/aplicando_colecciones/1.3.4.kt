package com.example.aplicando_colecciones

import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking

// 1. Modelado de Datos y Estados
data class PerfilUsuario(val nombreUsuario: String, val email: String)

sealed class ResultadoLogin {
    data class Exito(val perfil: PerfilUsuario) : ResultadoLogin()
    data class Error(val mensaje: String) : ResultadoLogin()
    object Autenticando : ResultadoLogin()
}

// 2. Creación de la Función Asíncrona
suspend fun autenticarUsuario(usuario: String, contrasena: String): ResultadoLogin {
    delay(2000L) 
    return if (usuario == "admin" && contrasena == "1234") {
        ResultadoLogin.Exito(PerfilUsuario("AdminUser", "admin@correo.cl"))
    } else {
        ResultadoLogin.Error("Credenciales incorrectas")
    }
}

// 3. Ejecución y Manejo de Resultados
fun main() = runBlocking {
    
    // Prueba 1: Credenciales correctas
    println("Estado: Autenticando...")
    val resultadoCorrecto = autenticarUsuario("admin", "1234")
    
    when (resultadoCorrecto) {
        is ResultadoLogin.Exito -> {
            // 4. Aplicando Funciones de Ámbito
            resultadoCorrecto.perfil.let {
                println("Acceso concedido. Usuario: ${it.nombreUsuario} | Correo: ${it.email}")
            }
        }
        is ResultadoLogin.Error -> println("Error al ingresar: ${resultadoCorrecto.mensaje}")
        ResultadoLogin.Autenticando -> println("El sistema está procesando sus datos...")
    }

    println("\n-----------------------------------\n")

    // Prueba 2: Credenciales incorrectas
    println("Estado: Autenticando...")
    val resultadoIncorrecto = autenticarUsuario("usuario", "0000")
    
    when (resultadoIncorrecto) {
        is ResultadoLogin.Exito -> {
            resultadoIncorrecto.perfil.let {
                println("Acceso concedido. Usuario: ${it.nombreUsuario} | Correo: ${it.email}")
            }
        }
        is ResultadoLogin.Error -> println("Error al ingresar: ${resultadoIncorrecto.mensaje}")
        ResultadoLogin.Autenticando -> println("El sistema está procesando sus datos...")
    }
}