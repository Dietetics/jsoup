package org.jsoup.parser;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Classe de test pour la methode matchesAny().
 */
class myTokenQueueTest {

    private TokenQueue tokenQueue;
    private final Faker faker = new Faker();

    @BeforeEach
    void setUp() {
        // Initialisation de TokenQueue avec une chaîne de caractères de test.
        tokenQueue = new TokenQueue(faker.lorem().word().toLowerCase());
    }

    /**
     * Test unitaire pour la méthode matchesAny de la classe TokenQueue.
     *
     * Ce test vérifie que lorsque la TokenQueue est vide,
     * la méthode matchesAny retourne false, quel que soit le contenu
     * des caractères passés en argument. Cela garantit que la méthode
     * se comporte correctement dans le cas où il n'y a pas de caractères
     * à comparer dans la queue, ce qui est une condition importante
     * à valider pour s'assurer de la robustesse de la méthode.
     */
    @Test
    void testMatchesAny_withEmptyQueue_returnsFalse() {
        // Arrange
        TokenQueue emptyQueue = new TokenQueue(""); // Initialisation d'une TokenQueue vide
        // Act
        boolean result = emptyQueue.matchesAny('a', 'b', 'c');

        // Assert
        assertFalse(result, "matchesAny should return false for an empty queue.");
    }

}