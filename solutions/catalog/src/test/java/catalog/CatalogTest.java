package catalog;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;

import static catalog.SearchCriteria.*;
import static org.junit.jupiter.api.Assertions.*;

class CatalogTest {

    CatalogItem catalogItem = new CatalogItem("R-1", 13,
            new AudioBook("Bárány Boldizsár", new ArrayList<>(Arrays.asList("Szabó Magda")), new ArrayList<>(Arrays.asList("Szombathy Gyula")), 83),
            new Book("Bárány Boldizsár", 96, new ArrayList<>(Arrays.asList("Szabó Magda"))),
            new CourseBook("Bárány Boldizsár feladatgyűjtemény", 24, new ArrayList<>(Arrays.asList("Szabó Magda")), "Kiss József")
    );

    CatalogItem otherCatalogItem = new CatalogItem("R-2", 8,
            new Book("Lakberendezés a Feng-shui elvei szerint", 257, new ArrayList<>(Arrays.asList("Lengyel Regina", "Joó Gabriella", "Kiss József")))
    );

    CatalogItem anotherCatalogItem = new CatalogItem("R-3", 5,
            new MusicAlbum("Ride the Lightning", 300, new ArrayList<>(Arrays.asList("Metallica")))
    );

    Catalog catalog = new Catalog();

    @BeforeEach
    void init() {
        catalog.addItem(catalogItem);
        catalog.addItem(otherCatalogItem);
        catalog.addItem(anotherCatalogItem);
    }

    @Test
    void testAddItem() {
        assertEquals(3, catalog.getCatalogItems().size());
    }

    @Test
    void testAddItemWrongItem() {
        Exception ex = assertThrows(IllegalArgumentException.class,
                () -> catalog.addItem(null));
        assertEquals("Catalog item is empty", ex.getMessage());
    }

    @Test
    void testDeleteItem() {
        catalog.deleteItemByRegistrationNumber("R-1");

        assertEquals(2, catalog.getCatalogItems().size());
    }

    @Test
    void testDeleteItemWithEmptyRegistrationNumber() {
        Exception ex = assertThrows(IllegalArgumentException.class,
                () -> catalog.deleteItemByRegistrationNumber("   "));
        assertEquals("Empty registration number", ex.getMessage());
    }

    @Test
    void testGetAudioLibraryItems() {
        assertEquals(2, catalog.getAudioLibraryItems().size());
    }

    @Test
    void testGetPrintedLibraryItems() {
        assertEquals(2, catalog.getPrintedLibraryItems().size());
    }

    @Test
    void testGetAllPageNumber() {
        assertEquals(377, catalog.getAllPageNumber());
    }

    @Test
    void testGetAveragePageWithIllegalArgument() {
        Exception ex = assertThrows(IllegalArgumentException.class,
                () -> catalog.getAveragePageNumberMoreThan(-1));
        assertEquals("Page number must be positive", ex.getMessage());
    }

    @Test
    void testGetAveragePageNumberMoreThanTooMuchPage() {
        Exception ex = assertThrows(IllegalArgumentException.class,
                () -> catalog.getAveragePageNumberMoreThan(2000));
        assertEquals("No such book", ex.getMessage());
    }

    @Test
    void testGetAveragePageNumberMoreThan() {
        assertEquals(188.5, catalog.getAveragePageNumberMoreThan(100));
        assertEquals(257.0, catalog.getAveragePageNumberMoreThan(200));
    }

    @Test
    void testFindByCriteriaBoth() {
        SearchCriteria searchCriteria = createByBoth("Ride the Lightning", "Metallica");

        assertEquals(1, catalog.findByCriteria(searchCriteria).size());
        assertEquals("R-3", catalog.findByCriteria(searchCriteria).get(0).getRegistrationNumber());
    }

    @Test
    void testFindByCriteriaContributor() {
        SearchCriteria searchCriteria = createByContributor("Kiss József");

        assertEquals(2, catalog.findByCriteria(searchCriteria).size());
        assertEquals("R-1", catalog.findByCriteria(searchCriteria).get(0).getRegistrationNumber());
        assertEquals("R-2", catalog.findByCriteria(searchCriteria).get(1).getRegistrationNumber());
    }

    @Test
    void testFindByCriteriaTitle() {
        SearchCriteria searchCriteria = createByTitle("Bárány Boldizsár");

        assertEquals(1, catalog.findByCriteria(searchCriteria).size());
        assertEquals("R-1", catalog.findByCriteria(searchCriteria).get(0).getRegistrationNumber());
    }

    @Test
    void testFindByCriteriaEmptyCriteria() {
        Exception ex = assertThrows(IllegalArgumentException.class,
                () -> catalog.findByCriteria(null));
        assertEquals("Empty criteria", ex.getMessage());
    }

    @Test
    void testReadBooksFromFile() {
        catalog.readBooksFromFile(Paths.get("src/test/resources/books.csv"));

        assertEquals(7, catalog.getCatalogItems().size());
        assertEquals("R-6", catalog.getCatalogItems().get(5).getRegistrationNumber());
        assertEquals(1, catalog.getCatalogItems().get(5).getContributors().size());
        assertEquals("Gárdonyi Géza", catalog.getCatalogItems().get(5).getContributors().get(0));
        assertEquals("Egri csillagok", catalog.getCatalogItems().get(5).getLibraryItems().get(0).getTitle());
    }

    @Test
    void testReadBooksFromWrongFile() {
        Exception ex = assertThrows(IllegalStateException.class,
                () -> catalog.readBooksFromFile(Paths.get("src/test/resources/xyz.csv")));
        assertEquals("Can not read from file", ex.getMessage());
    }

    @Test
    void testReadBooksFromWrongNumberFile() {
        Exception ex = assertThrows(WrongFormatException.class,
                () -> catalog.readBooksFromFile(Paths.get("src/test/resources/wrongnumber.csv")));
        assertEquals("Line format in file is wrong", ex.getMessage());
    }

    @Test
    void testReadBooksFromEmptyTitleFile() {
        Exception ex = assertThrows(WrongFormatException.class,
                () -> catalog.readBooksFromFile(Paths.get("src/test/resources/emptytitle.csv")));
        assertEquals("Line format in file is wrong", ex.getMessage());
    }
}