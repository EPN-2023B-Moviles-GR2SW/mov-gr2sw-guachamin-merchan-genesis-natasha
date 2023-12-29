import java.io.*

class ArtistaDAO : GenericDAO<Artista, String> {
    val archivo = File("artistas.txt")

    override fun crear(artista: Artista) {
        val fileWriter1 = FileWriter(archivo, true)
        val printWriter1 = PrintWriter(fileWriter1)
        printWriter1.println(artista)
        printWriter1.close()
    }


    override fun obtenerPorNombre(nombreArtista: String) {
        try {
            val fileReader = FileReader(archivo)
            val bufferReader = BufferedReader(fileReader)

            var linea = bufferReader.readLine()
            var coincidencia: String? = null
            while (linea != null) {
                if (linea.contains(nombreArtista)) {
                    coincidencia = linea
                }
                linea = bufferReader.readLine()
            }
            if (coincidencia != null) {
                println(" Coincidencia: $coincidencia")
            }else{
                println("No se encontraron coincidencias")
            }
            bufferReader.close()
            fileReader.close()

        } catch (ex: IOException) {
            ex.printStackTrace()
        }

    }

    override fun eliminar(nombreArtista: String) {
        val archivoTemp = File("artistas_temp.txt")

        try {
            val fileReader = FileReader(archivo)
            val bufferReader = BufferedReader(fileReader)
            val fileWriter = FileWriter(archivoTemp)
            val printWriter = PrintWriter(fileWriter)

            var linea = bufferReader.readLine()
            var coincidencia: String? = null

            while (linea != null) {
                if (linea.contains(nombreArtista)) {
                    coincidencia = linea
                    println("Se ha eliminado el artista $linea")
                    printWriter.println("")
                } else {

                    printWriter.println(linea)

                }
                linea = bufferReader.readLine()
            }
            if(coincidencia == null){
                println("No se ha eliminado nada")
            }

            bufferReader.close()
            printWriter.close()
            fileReader.close()
            fileWriter.close()

            archivo.delete()
            archivoTemp.renameTo(archivo)

        } catch (ex: IOException) {
            ex.printStackTrace()
        }


    }

    override fun actualizar(nombreArtista: String, nuevoArtista: Artista) {
        val archivoTemp = File("artistas_temp.txt")

        try {
            val fileReader = FileReader(archivo)
            val bufferReader = BufferedReader(fileReader)
            val fileWriter = FileWriter(archivoTemp)
            val printWriter = PrintWriter(fileWriter)

            var linea = bufferReader.readLine()

            while (linea != null) {
                if (linea.contains(nombreArtista)) {
                    printWriter.println(nuevoArtista)
                } else {
                    printWriter.println(linea)
                }
                linea = bufferReader.readLine()
            }

            bufferReader.close()
            printWriter.close()
            fileReader.close()
            fileWriter.close()

            archivo.delete()
            archivoTemp.renameTo(archivo)

        } catch (ex: IOException) {
            ex.printStackTrace()
        }
    }
}