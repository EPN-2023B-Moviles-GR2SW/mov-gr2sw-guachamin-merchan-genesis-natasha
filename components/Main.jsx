import { View, Text } from "react-native"
import Titulo from "./Titulo"
import BarraNavegacion from "./BarraNavegacion"
import ListaAlbumes from "./ListaAlbumes"
import BarraInferior from "./BarraInferior"


const Main = () => {
    return (<View>
        <Titulo></Titulo>
        <BarraNavegacion></BarraNavegacion>
        <ListaAlbumes></ListaAlbumes>
        <BarraInferior></BarraInferior>
    </View>)
}

export default Main