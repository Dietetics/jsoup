package org.jsoup.parser;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class myTagTest {

    @Test
    void testEquals_withDifferentObjectType() {
        // Arrange
        // Créez une instance de la classe Tag
        // Use factory method to create instance
        Tag tag = Tag.createTag("div", "html");

        // Créez un objet d'une classe différente (ici String)
        String differentObject = "Not a Tag";

        // Act
        // On vérifie l'égalité de l'instance Tag avec un objet de type différent
        boolean areEqual = tag.equals(differentObject);

        // Assert
        // On s'attend à ce que les deux objets ne soient pas égaux car "differentObject" n'est pas une instance de Tag
        assertFalse(areEqual, "Tag should not be equal to an object of a different type.");
    }

    @Test
    void testEquals_withDifferentEmptyFlag() {
        // Arrange
        // Créez deux instances de Tag avec des propriétés identiques sauf pour "empty".
        // Use factory method to create instance
        Tag tag1 = Tag.createTag("img", "html");
        // Use factory method to create instance
        Tag tag2 = Tag.createTag("img", "html");

        // Le tag1 est vide (empty), alors que le tag2 ne l'est pas.
        tag1.empty = true;
        tag2.empty = false;

        // Act
        // On vérifie l'égalité des deux tags.
        boolean areTagsEqual = tag1.equals(tag2);

        // Assert
        // On s'attend à ce que les deux tags ne soient pas égaux car leurs flags "empty" sont différents.
        assertFalse(areTagsEqual, "Tags should not be equal because their 'empty' fields differ.");
    }

    @Test
    void testEquals_withDifferentFormatAsBlockFlag() {
        // Arrange
        // Créez deux instances de Tag avec des propriétés identiques sauf pour "formatAsBlock".
        Tag tag1 = new Tag("div", "html");
        Tag tag2 = new Tag("div", "html");

        // Le tag1 doit être formaté comme un block, mais pas le tag2.
        tag1.formatAsBlock = true;
        tag2.formatAsBlock = false;

        // Act
        // On vérifie l'égalité des deux tags.
        boolean areTagsEqual = tag1.equals(tag2);

        // Assert
        // On s'attend à ce que les deux tags ne soient pas égaux car leurs flags "formatAsBlock" sont différents.
        assertFalse(areTagsEqual, "Tags should not be equal because their 'formatAsBlock' fields differ.");
    }

    @Test
    void testEquals_withDifferentPreserveWhitespaceFlag() {
        // Arrange
        // Créez deux instances de Tag avec des propriétés identiques sauf pour "preserveWhitespace".
        Tag tag1 = new Tag("pre", "html");
        Tag tag2 = new Tag("pre", "html");

        // Le tag1 doit préserver les espaces blancs, mais pas le tag2.
        tag1.preserveWhitespace = true;
        tag2.preserveWhitespace = false;

        // Act
        // On vérifie l'égalité des deux tags.
        boolean areTagsEqual = tag1.equals(tag2);

        // Assert
        // On s'attend à ce que les deux tags ne soient pas égaux car leurs flags "preserveWhitespace" sont différents.
        assertFalse(areTagsEqual, "Tags should not be equal because their 'preserveWhitespace' fields differ.");
    }

}
