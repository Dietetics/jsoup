package org.jsoup.parser;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import com.github.javafaker.Faker;

import java.io.StringReader;

import static org.junit.jupiter.api.Assertions.assertNull;

/**
 * Classe de test pour la methode close().
 */
public class myCharacterReaderTest {
    private CharacterReader characterReader;
    private final Faker faker = new Faker();

    /**
     * on verifie que la methode close() n'essaie pas de fermer un reader deja nul.
     *
     * Intention: S'assurer que si la methode close() est appelee plusieurs fois,
     * ou si le reader est deja nul, elle retourne immédiatement sans generer d'exception.
     */
    @Test
    public void testClose_WhenReaderIsNull_ReturnsImmediately() {

        // Arrange
        characterReader = new CharacterReader(new StringReader(faker.lorem().word().toLowerCase()));

        // On appel de la methode close une premiere fois pour rendre le reader null
        characterReader.close();

        // Act
        // On simule une tentative de fermeture alors que reader est deja null
        characterReader.close();

        // Assert
        assertNull(characterReader.getReader(), "Le reader devrait rester null apres un appel supplementaire a close().");
    }
}
