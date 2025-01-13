import kotlin.math.pow

class Persona(val peso: Double, val altura: Double) {

    var nombre: String = "Desconocido"
    val imc: Double = calcularImc()

    constructor(nombre: String, peso: Double, altura: Double) : this(peso, altura) {
        this.nombre = nombre
    }

    private fun calcularImc(): Double = peso*altura.pow(2)

    override fun toString(): String {
        return "Nombre: $nombre, Peso: $peso kg, Altura: $altura m, IMC: $imc"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is Persona) return false
        return this.nombre == other.nombre && this.peso == other.peso && this.altura == other.altura
    }
}

fun pedirNombre():String{
    var nombre:String? = null
    do{
        println("Dame tu nombre")
        print(">> ")
        nombre = readlnOrNull()
    }while(nombre.isNullOrBlank())
    return nombre
}

fun main(){
    val persona1 = Persona(pedirNombre(),60.0,1.80)
    val persona2 = Persona(60.0,1.80)
    val persona3 = Persona(60.0,1.80)

    println("Persona 1 -> ${persona1.nombre} ${persona1.peso} ${persona1.altura}")
    println("Persona 2 -> $persona2")
    println("Persona 3 -> $persona3")
    println("¿La persona 2 es igual a la persona 3? ${if(persona2 == persona3){"Si"}else{"No"}}") //He hecho función lambda para que diga si o no en vez de true o false
}