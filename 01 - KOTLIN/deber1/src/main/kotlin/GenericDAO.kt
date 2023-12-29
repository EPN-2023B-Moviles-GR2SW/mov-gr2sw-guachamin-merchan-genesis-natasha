interface GenericDAO<T, NAME> {

    fun crear(entidad: T) {


    }

    fun obtenerPorNombre(name: NAME) {


    }

    fun eliminar(name: NAME) {


    }

    fun actualizar(name: NAME, entidad: T) {

    }
}