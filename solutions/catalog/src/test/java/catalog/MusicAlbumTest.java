package catalog;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class MusicAlbumTest {

    @Test
    void testCreate() {
        MusicAlbum musicAlbum = new MusicAlbum("Ride the Lightning", 300, Arrays.asList("Metallica"));

        assertEquals("Ride the Lightning", musicAlbum.getTitle());
        assertEquals(300, musicAlbum.getLength());
        assertEquals(1, musicAlbum.getContributors().size());
        assertEquals("Metallica", musicAlbum.getContributors().get(0));
    }

    @Test
    void testCreateWithComposer() {
        MusicAlbum musicAlbum = new MusicAlbum("Ride the Lightning", 300, Arrays.asList("James Hetfield"), Arrays.asList("Metallica"));

        assertEquals("Ride the Lightning", musicAlbum.getTitle());
        assertEquals(300, musicAlbum.getLength());
        assertEquals(2, musicAlbum.getContributors().size());
        assertEquals("Metallica", musicAlbum.getContributors().get(1));
    }

    @Test
    void testMissingTitle() {
        Exception ex = assertThrows(IllegalArgumentException.class,
                () -> new MusicAlbum("", 300, Arrays.asList("Metallica")));
        assertEquals("Empty title", ex.getMessage());
    }

    @Test
    void testInvalidLength() {
        Exception ex = assertThrows(IllegalArgumentException.class,
                () -> new MusicAlbum("Ride the Lightning", -2, Arrays.asList("Metallica")));
        assertEquals("Illegal length: -2", ex.getMessage());
    }

    @Test
    void testNoPerformer() {
        Exception ex = assertThrows(IllegalArgumentException.class,
                () -> new MusicAlbum("Ride the Lightning", 300, new ArrayList<>()));
        assertEquals("No performer", ex.getMessage());
    }
}