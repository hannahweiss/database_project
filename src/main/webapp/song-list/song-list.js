class SongList extends React.Component {
  state = {
    songs: [],
    artistLoading: true,
    genreLoading: true
  }

  findSongArtists = (songId) =>
      findSongArtists(songId)
      .then(response => response)

  findSongGenre = (songId) =>
      findSongGenre(songId)
      .then(response => response)

  findAllSongs = () => {
    return findAllSongs()
    .then((songs) => {
      songs.map((song, i) => {
          this.findSongArtists(song.id).then(
              response => song.artists = response).finally(
                  () => this.setState({artistLoading: false}))
          this.findSongGenre(song.id).then(
              response => song.genre = response).finally(
              () => this.setState({genreLoading: false}))
      })
      this.setState({songs: songs})
    })
  }

  createSong = () =>
      createSong(artistId, songName)
      .then(() => this.findAllSongs())

  deleteSong = (id) =>
      deleteSong(id)
      .then(() => this.findAllSongs())

  componentDidMount = () => {
    this.findAllSongs()
  }

  render() {
    console.log('this is song list state', this.state.songs)
      return (
            this.state.artistLoading ?
                <div>Loading...</div> :
                <div className="container-fluid">
                  <button
                      onClick={() => this.createSong()}>
                    Create
                  </button>
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
                              <p>{artist.firstName} {artist.lastName}</p>
                            )}</td>
                                : <td></td> }
                            <td>{song.duration}</td>
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