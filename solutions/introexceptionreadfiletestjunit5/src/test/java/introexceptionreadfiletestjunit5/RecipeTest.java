package introexceptionreadfiletestjunit5;

import org.junit.jupiter.api.Test;

import java.nio.file.Path;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class RecipeTest {

    Recipe recipe = new Recipe();

    @Test
    void testAddIngredients() {
        Path path = Paths.get("src/test/resources/recipe.txt");
        recipe.addIngredients(path);

        assertEquals(10, recipe.getIngredients().size());
        assertEquals("kristálycukor", recipe.getIngredients().get(2));
    }

    @Test
    void testAddIngredientsNotExistingFile() {
        Path path = Paths.get("src/test/resources/xyz.txt");

        IllegalStateException exception = assertThrows(IllegalStateException.class,
                () -> recipe.addIngredients(path));
        assertEquals("Can not read file.", exception.getMessage());
    }
}