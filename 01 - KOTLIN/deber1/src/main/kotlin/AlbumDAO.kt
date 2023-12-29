import java.io.*


class AlbumDAO : GenericDAO<Album, String> {
    val archivo = File("albumes.txt")

    override fun crear(album: Album) {
        val fileWriter1 = FileWriter(archivo, true)
        val printWriter1 = PrintWriter(fileWriter1)
        printWriter1.println(album)
        printWriter1.close()
    }


    override fun obtenerPorNombre(nombreAlbum: String) {
        try {
            val fileReader = FileReader(archivo)
            val bufferReader = BufferedReader(fileReader)

            var linea = bufferReader.readLine()
            var coincidencia: String? = null
            while (linea != null) {
                if (linea.contains(nombreAlbum)) {
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

    override fun eliminar(nombreAlbum: String) {
        val archivoTemp = File("albumes_temp.txt")

        try {
            val fileReader = FileReader(archivo)
            val bufferReader = BufferedReader(fileReader)
            val fileWriter = FileWriter(archivoTemp)
            val printWriter = PrintWriter(fileWriter)

            var linea = bufferReader.readLine()
            var coincidencia: String? = null

            while (linea != null) {
                if (linea.contains(nombreAlbum)) {
                    coincidencia = linea
                    println("Se ha eliminado el album $linea")
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

    override fun actualizar(nombreAlbum: String, nuevoAlbum: Album) {
        val archivoTemp = File("albumes_temp.txt")

        try {
            val fileReader = FileReader(archivo)
            val bufferReader = BufferedReader(fileReader)
            val fileWriter = FileWriter(archivoTemp)
            val printWriter = PrintWriter(fileWriter)

            var linea = bufferReader.readLine()

            while (linea != null) {
                if (linea.contains(nombreAlbum)) {
                    printWriter.println(nuevoAlbum)
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