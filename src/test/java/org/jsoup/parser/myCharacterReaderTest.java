package org.jsoup.parser;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.StringReader;

import static org.junit.jupiter.api.Assertions.assertNull;


public class myCharacterReaderTest {
    private CharacterReader characterReader;

    /**
     * Verifiant que la methode close() n'essaie pas de fermer un reader deja nul.
     *
     * Intention: S'assurer que si la methode close() est appelee plusieurs fois,
     * ou si le reader est deja nul, elle retourne immédiatement sans generer d'exception.
     */
    @Test
    public void testClose_WhenReaderIsNull_ReturnsImmediately() {

        // Initialisation correcte de characterReader
        characterReader = new CharacterReader(new StringReader("test input"));

        // Appel de la methode close une premiere fois pour rendre le reader null
        characterReader.close();

        // Simule une tentative de fermeture alors que reader est deja null
        characterReader.close();

        // Verification : characterReader doit etre null
        assertNull(characterReader.getReader(), "Le reader devrait rester null apres un appel supplementaire a close().");
    }
}
