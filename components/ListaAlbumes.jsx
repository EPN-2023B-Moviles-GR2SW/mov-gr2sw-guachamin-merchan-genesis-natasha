import { FlatList, Text, View, StyleSheet, Image } from "react-native"
import { Entypo } from '@expo/vector-icons';

styles = StyleSheet.create({
    listas: {
        height: 645,
        backgroundColor: 'black',
    },
    contenedor: {
        flexDirection: 'row',
        paddingTop: 10,
        paddingHorizontal: 10,
        justifyContent: 'space-between',
    },
    contAlbumes: {
        justifyContent: 'space-around',
        paddingHorizontal: 15,
        paddingVertical: 15,
        borderWidth: 0,
        width: 170,
    },
    contImagen: {

        width: 150,
        height: 150,
        borderRadius: 9,
    },
    iconText: {
        justifyContent: 'space-between',
        flexDirection: 'row'
    }
})
const ListaAlbumes = () => {

    const albums = [
        {
            id: 1,
            title: "Iron Maiden",
            artist: "Iron Maiden",
            year: 1977,
            tracks: [
                { id: 1, title: "Second Hand News" },
                { id: 2, title: "Dreams" },
                { id: 3, title: "Never Going Back Again" },
            ],
        },
        {
            id: 2,
            title: "The Number of the Beast",
            artist: "Iron Maiden",
            year: 1982,
            tracks: [
                { id: 1, title: "Wanna Be Startin' Somethin'" },
                { id: 2, title: "Thriller" },
                { id: 3, title: "Beat It" },
            ],
        },
        {
            id: 3,
            title: "Fear of the Dark",
            artist: "Iron Maiden",
            year: 1980,
            tracks: [
                { id: 1, title: "Hells Bells" },
                { id: 2, title: "Shoot to Thrill" },
                { id: 3, title: "Back in Black" },
            ],
        },
        {
            id: 4,
            title: "Piece of Mind",
            artist: "Iron Maiden",
            year: 1973,
            tracks: [
                { id: 1, title: "Speak to Me" },
                { id: 2, title: "Breathe" },
                { id: 3, title: "On the Run" },
            ],
        },
        {
            id: 5,
            title: "Led Zeppelin IV",
            artist: "Iron Maiden",
            year: 1971,
            tracks: [
                { id: 1, title: "Black Dog" },
                { id: 2, title: "Rock anl" },
                { id: 3, title: "Stairway to Heaven" },
            ],
        },
        {
            id: 6,
            title: "Hotel California",
            artist: "Eagles",
            year: 1976,
            tracks: [
                { id: 1, title: "Hotel California" },
                { id: 2, title: "New Kid in Town" },
                { id: 3, title: "Life in the Fast Lane" },
            ],
        },
        {
            id: 7,
            title: "Abbey Road",
            artist: "The Beatles",
            year: 1969,
            tracks: [
                { id: 1, title: "Coe Together" },
                { id: 2, title: "Something" },
                { id: 3, title: "Here Comes the Sun" },
            ],
        },
        {
            id: 8,
            title: "Born to Run",
            artist: "Bruce Springsteen",
            year: 1975,
            tracks: [
                { id: 1, title: "Thunder Road" },
                { id: 2, title: "Tenth Avenue Freeze-Out" },
                { id: 3, title: "Born to Run" },
            ],
        },
        {
            id: 9,
            title: "Sgt. Pepper's Lonely Hearts Club Band",
            artist: "The Beatles",
            year: 1967,
            tracks: [
                { id: 1, title: "Sgt. Pepper's Lonely Hearts Club Band" },
                { id: 2, title: "With a Little Help from My Friends" },
                { id: 3, title: "Lucy in the Sky with Diamonds" },
            ],
        },
        {
            id: 10,
            title: "The Wall",
            artist: "Pink Floyd",
            year: 1979,
            tracks: [
                { id: 1, title: "In the Flesh?" },
                { id: 2, title: "The Thin Ice" },
                { id: 3, title: "Another Brick in the Wall, Part 1" },
            ],
        },
        {
            id: 11,
            title: "Led Zeppelin IV",
            artist: "Led Zeppelin",
            year: 1971,
            tracks: [
                { id: 1, title: "Black Dog" },
                { id: 2, title: "Rock and Roll" },
                { id: 3, title: "Stairway to Heaven" },
            ],
        },
        {
            id: 12,
            title: "Hotel California",
            artist: "Eagles",
            year: 1976,
            tracks: [
                { id: 1, title: "Hotel California" },
                { id: 2, title: "New Kid in Town" },
                { id: 3, title: "Life in the Fast Lane" },
            ],
        },
        {
            id: 13,
            title: "Abbey Road",
            artist: "The Beatles",
            year: 1969,
            tracks: [
                { id: 1, title: "Come Together" },
                { id: 2, title: "Something" },
                { id: 3, title: "Here Comes the Sun" },
            ],
        },
        {
            id: 14,
            title: "Born to Run",
            artist: "Bruce Springsteen",
            year: 1975,
            tracks: [
                { id: 1, title: "Thunder Road" },
                { id: 2, title: "Tenth Avenue Freeze-Out" },
                { id: 3, title: "Born to Run" },
            ],
        },
        {
            id: 15,
            title: "Sgt. Pepper's Lonely Hearts Club Band",
            artist: "The Beatles",
            year: 1967,
            tracks: [
                { id: 1, title: "Sgt. Pepper's Lonely Hearts Club Band" },
                { id: 2, title: "With a Little Help from My Friends" },
                { id: 3, title: "Lucy in the Sky with Diamonds" },
            ],
        },
        {
            id: 16,
            title: "The Wall",
            artist: "Pink Floyd",
            year: 1979,
            tracks: [
                { id: 1, title: "In the Flesh?" },
                { id: 2, title: "The Thin Ice" },
                { id: 3, title: "Another Brick in the Wall, Part 1" },
            ],
        },
    ];

    return (

        <View style={styles.listas}>
            <FlatList data={albums}
                renderItem={({ item }) => (<View style={styles.contenedor}>
                    <View style={styles.contAlbumes}>
                        <Image style={styles.contImagen} source={{ uri: 'https://www.iheartradio.ca/image/policy:1.15627947:1626374192/twotw-packshot-800.jpg?f=default&$p$f=2bd4403' }}></Image>
                        <View style={styles.iconText}>
                            <Text>{item.title}</Text>
                            <Entypo name="dots-three-vertical" size={18} color="black" />
                        </View>

                        <Text>{item.artist}</Text>
                    </View>
                    <View style={styles.contAlbumes}>
                        <Image style={styles.contImagen} source={{ uri: 'https://th.bing.com/th/id/OIP.QV0l5fQmDb9zqjKIO6387gHaGx?rs=1&pid=ImgDetMain' }}></Image>
                        <View style={styles.iconText}>
                            <Text>{item.title}</Text>
                            <Entypo name="dots-three-vertical" size={18} color="black" />
                        </View>
                        <Text>{item.artist}</Text>
                    </View>
                </View>)}
                keyExtractor={({ id }) => id}>
            </FlatList>
        </View>
        



    )
}

export default ListaAlbumes