import { View, Text, StyleSheet } from "react-native"
import { Fontisto } from '@expo/vector-icons';
import { Ionicons } from '@expo/vector-icons';

styles = StyleSheet.create({
    contenedor: {
        paddingTop: 50,
        paddingHorizontal: 10,
        flexDirection: 'row',
        justifyContent: 'space-between',
        backgroundColor: 'black',
    },
    contenedorIconos: {
        flexDirection: 'row',
        justifyContent: 'flex-end',
    },
    textIconos: {
        paddingHorizontal: 10
    },
    text: {
        fontSize: 20,
        color: '#ff4500'
    }
})
const Titulo = () => {
    return (<View style={styles.contenedor}>
        <Text style={styles.text}>Música</Text>
        <View style={styles.contenedorIconos}>
            <Ionicons name="diamond" size={18} color="#067857" />
            <Text>     </Text>
            <Fontisto name="music-note" size={20} color="gray" />
        </View>
    </View>)
}

export default Titulo