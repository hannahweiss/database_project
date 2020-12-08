class SongList extends React.Component {
  state = {
    songs: []
  }

  findSongArtists = (songId) =>
      findSongArtists(songId)
      .then(response => response)

  findAllSongs = () =>
      findAllSongs()
      .then((songs) => {
        songs.map((song) =>
            this.findSongArtists(song.id).then((response) => song.artists = response))
        this.setState({songs: songs})
      })

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
    return(
        <div className="container-fluid">
          <button
              onClick={() => this.createSong()}>
            Create
          </button>
          <a  href="../../index.html">
            Home
          </a>
          <h1>Songs</h1>
          <table>
            <tbody>
            {
              this.state.songs.map((song) =>
                  <tr key={song.id}>
                    <td>{song.name}</td>
                    {song.artists}.map((artist) =>
                    <td>{song.artists[artist]}</td>
                    )
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