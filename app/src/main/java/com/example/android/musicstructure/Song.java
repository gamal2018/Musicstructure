package com.example.android.musicstructure;

public class Song {

    /**
     * Song name
     */
    private String mSongName;

    /**
     * Artist name
     */
    private String mArtistName;

    /**
     * Image resource ID for the song
     */
    private int mAlbumArt = NO_IMAGE_PROVIDED;

    /**
     * Constant value that represents no image was provided for this song
     */
    private static final int NO_IMAGE_PROVIDED = -1;

    /**
     * Create a new song object
     */
    public Song(String songName, String artistName, int albumArt) {
        mSongName = songName;
        mArtistName = artistName;
        mAlbumArt = albumArt;
    }

    /**
     * Get the Song name.
     */
    public String getSongName() {
        return mSongName;
    }

    /**
     * Get the Artist name.
     */
    public String getArtistName() {
        return mArtistName;
    }

    /**
     * Return the image resource ID of the song.
     */
    public int getAlbumArt() {
        return mAlbumArt;
    }

    /**
     * Returns whether or not there is an image for this song.
     */
    public boolean hasImage() {
        return mAlbumArt != NO_IMAGE_PROVIDED;
    }

}
