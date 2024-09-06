//Diseña un sistema de gestión de biblioteca que incluya las siguientes clases e interfaces
//Ramiro Jesus Canqui Llamosas
//05/09/2024
//06/09/2024
// Clase abstracta Material
abstract class Material(
    val titulo: String,
    val autor: String,
    val anioPublicacion: Int
) {
    abstract fun mostrarDetalles()
}

// Subclase Libro
class Libro(
    titulo: String,
    autor: String,
    anioPublicacion: Int,
    val genero: String,
    val numeroPaginas: Int
) : Material(titulo, autor, anioPublicacion) {
    override fun mostrarDetalles() {
        println("Libro - Título: $titulo, Autor: $autor, Año: $anioPublicacion, Género: $genero, Páginas: $numeroPaginas")
    }
}

// Subclase Revista
class Revista(
    titulo: String,
    autor: String,
    anioPublicacion: Int,
    val issn: String,
    val volumen: Int,
    val numero: Int,
    val editorial: String
) : Material(titulo, autor, anioPublicacion) {
    override fun mostrarDetalles() {
        println("Revista - Título: $titulo, Autor: $autor, Año: $anioPublicacion, ISSN: $issn, Volumen: $volumen, Número: $numero, Editorial: $editorial")
    }
}

// Data class Usuario
data class Usuario(
    val nombre: String,
    val apellido: String,
    val edad: Int
)

// Interfaz IBiblioteca
interface IBiblioteca {
    fun registrarMaterial(material: Material)
    fun registrarUsuario(usuario: Usuario)
    fun prestarMaterial(usuario: Usuario, material: Material)
    fun devolverMaterial(usuario: Usuario, material: Material)
    fun mostrarMaterialesDisponibles()
    fun mostrarMaterialesReservados(usuario: Usuario)
}

// Clase Biblioteca que implementa la interfaz IBiblioteca
class Biblioteca : IBiblioteca {
    private val materialesDisponibles = mutableListOf<Material>()
    private val usuarios = mutableMapOf<Usuario, MutableList<Material>>()

    override fun registrarMaterial(material: Material) {
        materialesDisponibles.add(material)
        println("Material registrado: ${material.titulo}")
    }

    override fun registrarUsuario(usuario: Usuario) {
        if (!usuarios.containsKey(usuario)) {
            usuarios[usuario] = mutableListOf()
            println("Usuario registrado: ${usuario.nombre} ${usuario.apellido}")
        }
    }

    override fun prestarMaterial(usuario: Usuario, material: Material) {
        if (materialesDisponibles.contains(material)) {
            materialesDisponibles.remove(material)
            usuarios[usuario]?.add(material)
            println("${material.titulo} ha sido prestado a ${usuario.nombre}")
        } else {
            println("${material.titulo} no está disponible")
        }
    }

    override fun devolverMaterial(usuario: Usuario, material: Material) {
        if (usuarios[usuario]?.contains(material) == true) {
            usuarios[usuario]?.remove(material)
            materialesDisponibles.add(material)
            println("${material.titulo} ha sido devuelto por ${usuario.nombre}")
        } else {
            println("${usuario.nombre} no tiene prestado ${material.titulo}")
        }
    }

    override fun mostrarMaterialesDisponibles() {
        println("Materiales disponibles:")
        materialesDisponibles.forEach { it.mostrarDetalles() }
    }

    override fun mostrarMaterialesReservados(usuario: Usuario) {
        println("Materiales reservados por ${usuario.nombre}:")
        usuarios[usuario]?.forEach { it.mostrarDetalles() }
    }
}

// Función principal para probar el sistema de biblioteca
fun main() {
    val biblioteca = Biblioteca()

    val usuario1 = Usuario("Juan", "Pérez", 30)
    val usuario2 = Usuario("Ana", "López", 25)

    biblioteca.registrarUsuario(usuario1)
    biblioteca.registrarUsuario(usuario2)

    val libro1 = Libro("El Señor de los Anillos", "J.R.R. Tolkien", 1954, "Fantasía", 1200)
    val libro2 = Libro("1984", "George Orwell", 1949, "Distopía", 328)
    val revista1 = Revista("National Geographic", "Varios", 2023, "0027-9358", 67, 5, "NatGeo Editorial")

    biblioteca.registrarMaterial(libro1)
    biblioteca.registrarMaterial(libro2)
    biblioteca.registrarMaterial(revista1)

    biblioteca.mostrarMaterialesDisponibles()


    biblioteca.prestarMaterial(usuario1, libro1)
    biblioteca.prestarMaterial(usuario2, revista1)


    biblioteca.mostrarMaterialesDisponibles()

    biblioteca.mostrarMaterialesReservados(usuario1)
    biblioteca.mostrarMaterialesReservados(usuario2)

    biblioteca.devolverMaterial(usuario1, libro1)
    biblioteca.devolverMaterial(usuario2, revista1)

    biblioteca.mostrarMaterialesDisponibles()
}
