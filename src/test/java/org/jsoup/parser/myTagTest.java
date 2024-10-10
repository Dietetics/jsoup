package org.jsoup.parser;

import org.junit.jupiter.api.Test;
import com.github.javafaker.Faker;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Classe de test pour mes 8 tests unitaires dans la classe Tag.
 */
public class myTagTest {
    private final Faker faker = new Faker();

    /**
     * Teste la methode equals() avec un objet d'un type different.
     *
     * Ce test verifie que la methode equals() de la classe Tag retourne false
     * lorsqu'elle est comparee a un objet d'un autre type. Cela garantit que
     * la methode equals() ne retourne pas "true" par erreur lorsque l'objet
     * passe n'est pas une instance de Tag.
     */
    @Test
    void testEquals_withDifferentObjectType() {

        String motGenererParFaker = faker.lorem().word().toLowerCase();

        // Arrange
        Tag tag = new Tag(motGenererParFaker, "html");
        String differentObject = motGenererParFaker;

        // Act
        boolean areEqual = tag.equals(differentObject);

        // Assert
        assertFalse(areEqual, "Un tag ne devrait pas etre egal a un objet dun type different");
    }







    /**
     * Teste la méthode equals() avec deux tags ayant des champs "empty" différents.
     *
     *
     * Ce test vérifie que la méthode equals() de la classe Tag retourne false
     * lorsque deux instances de Tag ont les mêmes propriétés sauf le champ "empty".
     * Le but est de s'assurer que le champ "empty" est pris en compte dans la comparaison d'égalité.
     *
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
        assertFalse(areTagsEqual, "Les balises ne devraient pas être égales car leurs champs 'empty' sont différents.");
    }








    /**
     * Teste la méthode equals() avec deux tags ayant des champs "formatAsBlock" différents.
     *
     *
     * Ce test vérifie que la méthode equals() de la classe Tag retourne false
     * lorsque deux instances de Tag ont des propriétés identiques sauf pour le champ "formatAsBlock".
     * Le but est de s'assurer que le champ "formatAsBlock" est pris en compte dans la comparaison d'égalité.
     *
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
        assertFalse(areTagsEqual, "Les tags ne devraient pas être égaux car leurs champs 'formatAsBlock' diffèrent.");
    }

    /**
     * Teste la méthode equals() avec deux tags ayant des champs "isBlock" différents.
     *
     *
     * Ce test vérifie que la méthode equals() retourne false lorsque deux instances de Tag
     * ont des propriétés identiques sauf pour le champ "isBlock". Cela garantit que la comparaison
     * d'égalité prend bien en compte la propriété "isBlock".
     *
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
        assertFalse(areTagsEqual, "Les tags ne devraient pas être égaux car leurs champs 'isBlock' diffèrent.");
    }

    /**
     * Teste la méthode equals() avec deux tags ayant des champs "preserveWhitespace" différents.
     *
     *
     * Ce test garantit que la méthode equals() retourne false si deux tags ont
     * des propriétés identiques sauf pour le champ "preserveWhitespace". Cela permet de vérifier que
     * la comparaison prend bien en compte cette propriété spécifique.
     *
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
        assertFalse(areTagsEqual, "Les tags ne devraient pas être égaux car leurs champs 'preserveWhitespace' diffèrent.");
    }

    /**
     * Teste la méthode equals() avec deux tags ayant des champs "selfClosing" différents.
     *
     *
     * Ce test vérifie que la méthode equals() retourne false si deux instances de Tag
     * ont les mêmes propriétés sauf pour le champ "selfClosing". Cela permet de garantir que
     * cette propriété est bien prise en compte dans la comparaison.
     *
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
        assertFalse(areTagsEqual, "Les tags ne devraient pas être égaux car leurs champs 'selfClosing' diffèrent.");
    }

    /**
     * Teste la méthode equals() avec deux tags ayant des champs "formList" différents.
     *
     *
     * Ce test vérifie que la méthode equals() retourne false si deux tags ont
     * des propriétés identiques sauf pour le champ "formList". Cela permet de s'assurer que cette propriété
     * est bien prise en compte dans la comparaison d'égalité.
     *
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
        assertFalse(areTagsEqual, "Les tags ne devraient pas être égaux car leurs champs 'formList' diffèrent.");
    }

    /**
     * Teste la méthode equals() avec deux tags ayant des champs "formSubmit" différents.
     *
     *
     * Ce test vérifie que la méthode equals() retourne false si deux instances de Tag
     * ont des propriétés identiques sauf pour le champ "formSubmit". Cela permet de s'assurer que
     * ce champ est bien pris en compte lors de la comparaison.
     *
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
        assertFalse(areTagsEqual, "Les tags ne devraient pas être égaux car leurs champs 'formSubmit' diffèrent.");
    }
}
