package catalog;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SearchCriteriaTest {

    @Test
    void testCreateByTitle() {
        SearchCriteria searchCriteria = SearchCriteria.createByTitle("Imagine Dragons");

        assertEquals("Imagine Dragons", searchCriteria.getTitle());
        assertTrue(searchCriteria.hasTitle());
        assertFalse(searchCriteria.hasContributor());
    }

    @Test
    void testCreateByContributor() {
        SearchCriteria searchCriteria = SearchCriteria.createByContributor("Metallica");

        assertEquals("Metallica", searchCriteria.getContributor());
        assertFalse(searchCriteria.hasTitle());
        assertTrue(searchCriteria.hasContributor());
    }

    @Test
    void testCreateByBoth() {
        SearchCriteria searchCriteria = SearchCriteria.createByBoth("Ride the Lightning", "Metallica");

        assertEquals("Ride the Lightning", searchCriteria.getTitle());
        assertEquals("Metallica", searchCriteria.getContributor());
        assertTrue(searchCriteria.hasTitle());
        assertTrue(searchCriteria.hasContributor());
    }

    @Test
    void testInvalidTitle() {
        Exception ex = assertThrows(IllegalArgumentException.class, () -> SearchCriteria.createByTitle(null));
        assertEquals("Title should be given", ex.getMessage());
    }

    @Test
    void testInvalidContributor() {
        Exception ex = assertThrows(IllegalArgumentException.class, () -> SearchCriteria.createByContributor(null));
        assertEquals("Contributor should be given", ex.getMessage());
    }

    @Test
    void testInvalid() {
        Exception ex = assertThrows(IllegalArgumentException.class, () -> SearchCriteria.createByBoth(null, "Metallica"));
        assertEquals("Title and contributor should be given", ex.getMessage());
    }
}
