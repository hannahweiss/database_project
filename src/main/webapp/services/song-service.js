const FIND_ALL_SONGS  = "http://localhost:8080/findAllSongs"
const FIND_SONG_BY_ID = "http://localhost:8080/findSongById"
const CREATE_SONG_URL = "http://localhost:8080/createSong"
const DELETE_SONG_URL = "http://localhost:8080/deleteSong"
const ADD_SONG_TO_PLAYLIST = "http://localhost:8080/addSongToPlaylist"

const findAllSongs = () =>
    fetch(`${FIND_ALL_SONGS}`)
    .then(response => response.json())

const findSongById = (id) =>
    fetch(`${FIND_SONG_BY_ID}/${id}`)
    .then(response => response.json())

const createSong = (artistId, songName) =>
    fetch(`${CREATE_SONG_URL}/${artistId}/${songName}`)
    .then(response => response.json())

const deleteSong = (id) =>
    fetch(`${DELETE_SONG_URL}/${id}`)

const addSongToPlaylist = (playlistId, songId) =>
    fetch(`${ADD_SONG_TO_PLAYLIST}/${playlistId}/${songId}`)
    .then(response => response.json())