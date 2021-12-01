package model;

public class SongArtist {

    private String artistName;
    private String albumName;
    private int track;

    public String getArtistName() {
        return artistName;
    }

    public void setArtistName(String artistName) {
        this.artistName = artistName;
    }

    public String getAlbumName() {
        return albumName;
    }

    public void setAlbumName(String albumName) {
        this.albumName = albumName;
    }

    public int getTrack() {
        return track;
    }

    public void setTrack(int track) {
        this.track = track;
    }
}

/*
SELECT * FROM songs WHERE title = "Heartless"
SELECT * FROM albums WHERE _id = 308
SELECT * FROM artists WHERE _id = 39

SELECT artists.name, albums.name, songs.track FROM songs

INNER JOIN albums ON songs.album = albums._id
INNER JOIN artists ON albums.artist = artists._id WHERE songs.title="Go Your Own Way"
ORDER BY artists.name, albums.name COLLATE NOCASE ASC
 */