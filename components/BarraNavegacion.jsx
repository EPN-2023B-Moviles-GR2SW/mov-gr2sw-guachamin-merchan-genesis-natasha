import { View, Text, StyleSheet, Pressable, Alert } from "react-native"
styles = StyleSheet.create({
    contenedor: {
        paddingTop: 25,
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
        fontSize: 18,
    },
})
const BarraNavegacion = () => {
    return (
        <View style={styles.contenedor}>
            <Pressable onPressIn={() => { Alert.alert('Hola morlo') }}>
                <Text style={styles.textIconos}>Álbumes</Text></Pressable>
            <Pressable><Text style={styles.textIconos}>Artistas</Text></Pressable>
            <Text style={styles.textIconos}>Canciones</Text>
            <Text style={styles.textIconos}>Playlists</Text>
        </View>
    )
}

export default BarraNavegacion