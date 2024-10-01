package org.jsoup.parser;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class myTagTest {

    @Test
    void testEquals_withDifferentObjectType() {
        // Arrange
        // Créez une instance de la classe Tag
        Tag tag = new Tag("div", "html");

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
        Tag tag1 = new Tag("img", "html");
        Tag tag2 = new Tag("img", "html");

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
    void testEquals_withDifferentIsBlockFlag() {
        // Arrange
        // Créez deux instances de Tag avec des propriétés identiques sauf pour "isBlock".
        Tag tag1 = new Tag("div", "html");
        Tag tag2 = new Tag("div", "html");

        // Le tag1 est un block (isBlock), mais pas le tag2.
        tag1.isBlock = true;   // Le tag1 est un block.
        tag2.isBlock = false;  // Le tag2 n'est pas un block.

        // Act
        // On vérifie l'égalité des deux tags.
        boolean areTagsEqual = tag1.equals(tag2);

        // Assert
        // On s'attend à ce que les deux tags ne soient pas égaux car leurs flags "isBlock" sont différents.
        assertFalse(areTagsEqual, "Tags should not be equal because their 'isBlock' fields differ.");
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


    @Test
    void testEquals_withDifferentSelfClosingFlag() {
        // Arrange
        // Créez deux instances de Tag avec des propriétés identiques sauf pour "selfClosing".
        Tag tag1 = new Tag("img", "html");
        Tag tag2 = new Tag("img", "html");

        // Le tag1 est auto-fermable (self-closing), mais pas le tag2.
        tag1.setSelfClosing(); // Le tag1 devient self-closing.
        tag2.selfClosing = false; // Le tag2 ne l'est pas.

        // Act
        // On vérifie l'égalité des deux tags.
        boolean areTagsEqual = tag1.equals(tag2);

        // Assert
        // On s'attend à ce que les deux tags ne soient pas égaux car leurs flags "selfClosing" sont différents.
        assertFalse(areTagsEqual, "Tags should not be equal because their 'selfClosing' fields differ.");
    }


    @Test
    void testEquals_withDifferentFormListFlag() {
        // Arrange
        // Créez deux instances de Tag avec des propriétés identiques sauf pour "formList".
        Tag tag1 = new Tag("input", "html");
        Tag tag2 = new Tag("input", "html");

        // Le tag1 est une liste de formulaire (formList), mais pas le tag2.
        tag1.formList = true;   // Le tag1 est une liste de formulaire.
        tag2.formList = false;  // Le tag2 ne l'est pas.

        // Act
        // On vérifie l'égalité des deux tags.
        boolean areTagsEqual = tag1.equals(tag2);

        // Assert
        // On s'attend à ce que les deux tags ne soient pas égaux car leurs flags "formList" sont différents.
        assertFalse(areTagsEqual, "Tags should not be equal because their 'formList' fields differ.");
    }

    @Test
    void testEquals_withDifferentFormSubmitFlag() {
        // Arrange
        // Créez deux instances de Tag avec des propriétés identiques sauf pour "formSubmit".
        Tag tag1 = new Tag("input", "html");
        Tag tag2 = new Tag("input", "html");

        // Le tag1 est soumis dans un formulaire (formSubmit), mais pas le tag2.
        tag1.formSubmit = true;   // Le tag1 est un élément soumis dans un formulaire.
        tag2.formSubmit = false;  // Le tag2 ne l'est pas.

        // Act
        // On vérifie l'égalité des deux tags.
        boolean areTagsEqual = tag1.equals(tag2);

        // Assert
        // On s'attend à ce que les deux tags ne soient pas égaux car leurs flags "formSubmit" sont différents.
        assertFalse(areTagsEqual, "Tags should not be equal because their 'formSubmit' fields differ.");
    }
}
