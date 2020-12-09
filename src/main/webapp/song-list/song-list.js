class SongList extends React.Component {
  state = {
    songs: [],
    artistLoading: true,
    genreLoading: true,
    newSongArtist: '',
    newSongName: ''
  }

  findSongArtists = (songId) =>
      findSongArtists(songId)
      .then(response => response)

  findSongGenres = (songId) =>
      findSongGenres(songId)
      .then(response => response)

  findAllSongs = () => {
    return findAllSongs()
    .then((songs) => {
      songs.map((song, i) => {
          this.findSongArtists(song.id).then(
              response => song.artists = response).finally(
                  () => this.setState({artistLoading: false}))
          this.findSongGenres(song.id).then(
              response => song.genres = response).finally(
              () => this.setState({genreLoading: false}))
      })
      this.setState({songs: songs})
    })
  }

  createSong = (artistId, songName) =>
      createSong(artistId, songName)
      .then(() => this.findAllSongs())

  deleteSong = (id) =>
      deleteSong(id)
      .then(() => this.findAllSongs())

  componentDidMount = () => {
    this.findAllSongs()
  }

  render() {
    console.log(this.state)
      return (
            this.state.artistLoading ?
                <div>Loading...</div> :
                <div className="container-fluid">
                  <a href="../../index.html">
                    Home
                  </a>
                  <h1>Songs</h1>
                  <table>
                    <tbody>
                    {
                      this.state.songs.map((song) =>
                          <tr key={song.id}>
                            <td>{song.name}</td>
                            { song.artists ?
                            <td>{song.artists.map((artist) =>
                              <p key={artist.id}>{artist.firstName} {artist.lastName}</p>
                            )}</td>
                                : <td></td> }
                            <td>{song.duration}</td>
                            { song.genres ?
                                <td>{song.genres.map((genre) =>
                                    <p key={genre.id}>{genre.name}</p>
                                )}</td> : <td></td> }
                            <td>
                              {/*<a className="btn btn-primary float-right"*/}
                              {/*   href={`/course-editor/course-editor.html?courseId=${course.courseId}`}>*/}
                              {/*  Edit*/}
                              {/*</a>*/}
                              <button className="btn btn-danger float-right"
                                      onClick={() => this.deleteSong(song.id)}>
                                Delete
                              </button>
                            </td>
                          </tr>
                      )
                    }
                    </tbody>
                  </table>
                </div>
      )
  }
}

ReactDOM.render(
    <SongList />,
    document.getElementById('root')
)