package org.jsoup.parser;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.StringReader;

import static org.junit.jupiter.api.Assertions.assertNull;


public class myCharacterReaderTest {
    private CharacterReader characterReader;

    @BeforeEach
    public void setUp() {
        characterReader = new CharacterReader(new StringReader("test input"));
    }


    @Test
    public void testClose_WhenReaderIsNull_DoesNotThrowException() {
        characterReader.close();
        characterReader = new CharacterReader(new StringReader("test input"));

        characterReader.close();

        assertNull(characterReader.getReader(), "Le reader devrait etre null apres la fermeture.");
    }
}
