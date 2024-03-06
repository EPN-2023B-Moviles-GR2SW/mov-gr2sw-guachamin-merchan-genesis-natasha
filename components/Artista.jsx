import { View, Text, StyleSheet, Pressable, Alert, FlatList, ScrollView } from "react-native"
import { Fontisto } from '@expo/vector-icons';
import { Ionicons } from '@expo/vector-icons';

styles = StyleSheet.create({
    contenedor1: {
        paddingTop: 80,
        paddingHorizontal: 10,
        flexDirection: 'row',
        justifyContent: 'space-between',
        backgroundColor: 'black',
    },
    contenedorIconos1: {
        flexDirection: 'row',
        justifyContent: 'flex-end',
    },
    textIconos1: {
        paddingHorizontal: 10
    },
    text: {
        fontSize: 20,
        color: '#ff4500'
    },
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
    listas: {
        height: 645,
        backgroundColor: 'black',
    },
})

const Artista = () => {
    return (
        <View>
            <View style={styles.contenedor1}>
                <Text style={styles.text}>Música</Text>
                <View style={styles.contenedorIconos1}>
                    <Ionicons name="diamond" size={18} color="#067857" />
                    <Text>     </Text>
                    <Fontisto name="music-note" size={20} color="gray" />
                </View>
            </View>
            <View style={styles.contenedor}>
                <Pressable onPressIn={() => { Alert.alert('Hola morlo') }}>
                    <Text style={styles.textIconos}>Álbumes</Text></Pressable>
                <Pressable><Text style={styles.textIconos}>Artistas</Text></Pressable>
                <Text style={styles.textIconos}>Canciones</Text>
                <Text style={styles.textIconos}>Playlists</Text>
            </View>
            <View style={styles.listas}>
                <FlatList>
                    <ScrollView contentContainerStyle={styles.container}>
                        <Text style={styles.texto}>Hola mundo</Text>
                    </ScrollView>
                </FlatList>
            </View>
        </View>
    )
}

export default Artista