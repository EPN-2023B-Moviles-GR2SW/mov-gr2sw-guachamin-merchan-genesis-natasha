import { View, Text, StyleSheet } from "react-native";
//Para importar estas librerías se utiliza el link:
//https://docs.expo.dev/guides/icons/
//https://icons.expo.fyi/Index
import { Foundation } from '@expo/vector-icons';
import Ionicons from '@expo/vector-icons/Ionicons';
import Octicons from '@expo/vector-icons/Octicons';
import AntDesign from '@expo/vector-icons/AntDesign';
import { FontAwesome5 } from '@expo/vector-icons';
import { Entypo } from '@expo/vector-icons';


const styles = StyleSheet.create({
    contenedor: {
        height: 60,
        borderColor: 'red',
        flexDirection: 'row',
        justifyContent: 'space-around',
        backgroundColor: '#151c1e',
    },
    textoFooter: {
        fontSize: 10,
        textAlign: 'center',
        paddingTop: 4,
    },
    iconCenter: {
        alignItems: 'center',
        paddingTop: 7,
    }

});

const BarraInferior = () => {
    return (
        <View style={styles.contenedor}>
            <View style={styles.iconCenter}>
                <Foundation name="home" size={24} color="white" />
                <Text style={styles.textoFooter}>Inicio</Text>
            </View>
            <View style={styles.iconCenter}>
                <Ionicons name="musical-note" size={22} color="white" />
                <Text style={styles.textoFooter}>Inicio</Text>
            </View>
            <View style={styles.iconCenter}>
                <AntDesign name="pluscircleo" size={21} color="white" />
                <Text style={styles.textoFooter}>Inicio</Text>
            </View>
            <View style={styles.iconCenter}>
                <FontAwesome5 name="dot-circle" size={22} color="black" />
                <Text style={styles.textoFooter}>Inicio</Text>
            </View>
            <View style={styles.iconCenter}>
            <Entypo name="magnifying-glass" size={22} color="black" />
                <Text style={styles.textoFooter}>Inicio</Text>
            </View>
            <View style={styles.iconCenter}>
            <Entypo name="magnifying-glass" size={22} color="black" />
                <Text style={styles.textoFooter}>Inicio</Text>
            </View>
            
            {/* <Ionicons name="home" size={32} color="green" /> */}

        </View>
    );
};

export default BarraInferior;
