package catalog;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CatalogItemTest {

    CatalogItem catalogItem = new CatalogItem("R-1", 13,
            new AudioBook("Bárány Boldizsár", new ArrayList<>(Arrays.asList("Szabó Magda")), new ArrayList<>(Arrays.asList("Szombathy Gyula")), 83),
            new Book("Bárány Boldizsár", 96, new ArrayList<>(Arrays.asList("Szabó Magda"))),
            new CourseBook("Bárány Boldizsár feladatgyűjtemény", 24, new ArrayList<>(Arrays.asList("Szabó Magda")), "Kiss József")
    );

    CatalogItem anotherCatalogItem = new CatalogItem("R-2", 5,
            new MusicAlbum("Ride the Lightning", 300, new ArrayList<>(Arrays.asList("Metallica")))
    );

    @Test
    void testCreate() {
        assertEquals("R-1", catalogItem.getRegistrationNumber());
        assertEquals(13, catalogItem.getPieces());
        assertEquals(3, catalogItem.getLibraryItems().size());
    }

    @Test
    void testCreateWithEmptyRegistrationNumber() {
        Exception ex = assertThrows(IllegalArgumentException.class,
                () -> new CatalogItem("", 2));
        assertEquals("Empty registration number", ex.getMessage());
    }

    @Test
    void testCreateWithWrongPieces() {
        Exception ex = assertThrows(IllegalArgumentException.class,
                () -> new CatalogItem("R-4", -2));
        assertEquals("Pieces must be at least 0", ex.getMessage());
    }

    @Test
    void testHasAudioFeature() {
        assertEquals(true, catalogItem.hasAudioFeature());
        assertEquals(true, anotherCatalogItem.hasAudioFeature());
    }

    @Test
    void testHasPrintedFeature() {
        assertEquals(true, catalogItem.hasPrintedFeature());
        assertEquals(false, anotherCatalogItem.hasPrintedFeature());
    }

    @Test
    void testGetNumberOfPagesAtOneItem() {
        assertEquals(120, catalogItem.getNumberOfPagesAtOneItem());
        assertEquals(0, anotherCatalogItem.getNumberOfPagesAtOneItem());
    }

    @Test
    void testGetContributors() {
        List<String> expected = Arrays.asList("Szabó Magda", "Szombathy Gyula", "Kiss József");

        assertEquals(expected, catalogItem.getContributors());
    }

    @Test
    void testGetTitles() {
        List<String> expected = Arrays.asList("Bárány Boldizsár", "Bárány Boldizsár", "Bárány Boldizsár feladatgyűjtemény");

        assertEquals(expected, catalogItem.getTitles());
    }
}
