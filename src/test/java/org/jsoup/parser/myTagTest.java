package org.jsoup.parser;

import org.junit.jupiter.api.Test;
import com.github.javafaker.Faker;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Classe de test pour la classe Tag.
 */
public class myTagTest {
    private final Faker faker = new Faker();

    /**
     * Teste la méthode equals() avec un objet d'un type différent.
     *
     * <p>
     * Ce test vérifie que la méthode equals() de la classe Tag retourne false
     * lorsqu'elle est comparée à un objet d'un autre type. Cela garantit que
     * la méthode equals() ne retourne pas "true" par erreur lorsque l'objet
     * passé n'est pas une instance de Tag.
     * </p>
     */
    @Test
    void testEquals_withDifferentObjectType() {
        // Arrange
        Tag tag = new Tag(faker.lorem().word().toLowerCase(), "html");
        String differentObject = "Not a Tag";

        // Act
        boolean areEqual = tag.equals(differentObject);

        // Assert
        assertFalse(areEqual, "Tag should not be equal to an object of a different type.");
    }

    /**
     * Teste la méthode equals() avec deux tags ayant des champs "empty" différents.
     *
     * <p>
     * Ce test vérifie que la méthode equals() de la classe Tag retourne false
     * lorsque deux instances de Tag ont les mêmes propriétés sauf le champ "empty".
     * Le but est de s'assurer que le champ "empty" est pris en compte dans la comparaison d'égalité.
     * </p>
     */
    @Test
    void testEquals_withDifferentEmptyFlag() {
        // Arrange
        Tag tag1 = new Tag("img", "html");
        Tag tag2 = new Tag("img", "html");
        tag1.empty = true;
        tag2.empty = false;

        // Act
        boolean areTagsEqual = tag1.equals(tag2);

        // Assert
        assertFalse(areTagsEqual, "Tags should not be equal because their 'empty' fields differ.");
    }

    /**
     * Teste la méthode equals() avec deux tags ayant des champs "formatAsBlock" différents.
     *
     * <p>
     * Ce test vérifie que la méthode equals() de la classe Tag retourne false
     * lorsque deux instances de Tag ont des propriétés identiques sauf pour le champ "formatAsBlock".
     * Le but est de s'assurer que le champ "formatAsBlock" est pris en compte dans la comparaison d'égalité.
     * </p>
     */
    @Test
    void testEquals_withDifferentFormatAsBlockFlag() {
        // Arrange
        Tag tag1 = new Tag("div", "html");
        Tag tag2 = new Tag("div", "html");
        tag1.formatAsBlock = true;
        tag2.formatAsBlock = false;

        // Act
        boolean areTagsEqual = tag1.equals(tag2);

        // Assert
        assertFalse(areTagsEqual, "Tags should not be equal because their 'formatAsBlock' fields differ.");
    }

    /**
     * Teste la méthode equals() avec deux tags ayant des champs "isBlock" différents.
     *
     * <p>
     * Ce test vérifie que la méthode equals() retourne false lorsque deux instances de Tag
     * ont des propriétés identiques sauf pour le champ "isBlock". Cela garantit que la comparaison
     * d'égalité prend bien en compte la propriété "isBlock".
     * </p>
     */
    @Test
    void testEquals_withDifferentIsBlockFlag() {
        // Arrange
        Tag tag1 = new Tag("div", "html");
        Tag tag2 = new Tag("div", "html");
        tag1.isBlock = true;
        tag2.isBlock = false;

        // Act
        boolean areTagsEqual = tag1.equals(tag2);

        // Assert
        assertFalse(areTagsEqual, "Tags should not be equal because their 'isBlock' fields differ.");
    }

    /**
     * Teste la méthode equals() avec deux tags ayant des champs "preserveWhitespace" différents.
     *
     * <p>
     * Ce test garantit que la méthode equals() retourne false si deux tags ont
     * des propriétés identiques sauf pour le champ "preserveWhitespace". Cela permet de vérifier que
     * la comparaison prend bien en compte cette propriété spécifique.
     * </p>
     */
    @Test
    void testEquals_withDifferentPreserveWhitespaceFlag() {
        // Arrange
        Tag tag1 = new Tag("pre", "html");
        Tag tag2 = new Tag("pre", "html");
        tag1.preserveWhitespace = true;
        tag2.preserveWhitespace = false;

        // Act
        boolean areTagsEqual = tag1.equals(tag2);

        // Assert
        assertFalse(areTagsEqual, "Tags should not be equal because their 'preserveWhitespace' fields differ.");
    }

    /**
     * Teste la méthode equals() avec deux tags ayant des champs "selfClosing" différents.
     *
     * <p>
     * Ce test vérifie que la méthode equals() retourne false si deux instances de Tag
     * ont les mêmes propriétés sauf pour le champ "selfClosing". Cela permet de garantir que
     * cette propriété est bien prise en compte dans la comparaison.
     * </p>
     */
    @Test
    void testEquals_withDifferentSelfClosingFlag() {
        // Arrange
        Tag tag1 = new Tag("img", "html");
        Tag tag2 = new Tag("img", "html");
        tag1.setSelfClosing(); // Le tag1 devient self-closing.
        tag2.selfClosing = false; // Le tag2 ne l'est pas.

        // Act
        boolean areTagsEqual = tag1.equals(tag2);

        // Assert
        assertFalse(areTagsEqual, "Tags should not be equal because their 'selfClosing' fields differ.");
    }

    /**
     * Teste la méthode equals() avec deux tags ayant des champs "formList" différents.
     *
     * <p>
     * Ce test vérifie que la méthode equals() retourne false si deux tags ont
     * des propriétés identiques sauf pour le champ "formList". Cela permet de s'assurer que cette propriété
     * est bien prise en compte dans la comparaison d'égalité.
     * </p>
     */
    @Test
    void testEquals_withDifferentFormListFlag() {
        // Arrange
        Tag tag1 = new Tag("input", "html");
        Tag tag2 = new Tag("input", "html");
        tag1.formList = true;
        tag2.formList = false;

        // Act
        boolean areTagsEqual = tag1.equals(tag2);

        // Assert
        assertFalse(areTagsEqual, "Tags should not be equal because their 'formList' fields differ.");
    }

    /**
     * Teste la méthode equals() avec deux tags ayant des champs "formSubmit" différents.
     *
     * <p>
     * Ce test vérifie que la méthode equals() retourne false si deux instances de Tag
     * ont des propriétés identiques sauf pour le champ "formSubmit". Cela permet de s'assurer que
     * ce champ est bien pris en compte lors de la comparaison.
     * </p>
     */
    @Test
    void testEquals_withDifferentFormSubmitFlag() {
        // Arrange
        Tag tag1 = new Tag("input", "html");
        Tag tag2 = new Tag("input", "html");
        tag1.formSubmit = true;
        tag2.formSubmit = false;

        // Act
        boolean areTagsEqual = tag1.equals(tag2);

        // Assert
        assertFalse(areTagsEqual, "Tags should not be equal because their 'formSubmit' fields differ.");
    }
}
