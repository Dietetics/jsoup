package org.jsoup.parser;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class myParserTest {

    /**
     * Test de la méthode setTreeBuilder.
     *
     * Intention : Vérifier que la méthode setTreeBuilder met correctement à jour le TreeBuilder,
     * renvoie la même instance de Parser pour permettre l'enchaînement de méthodes, et s'assure que le
     * nouveau TreeBuilder contient une référence au Parser. Ce test garantit que :
     * 1. Le nouveau TreeBuilder est correctement défini dans le Parser.
     * 2. La méthode renvoie la même instance de Parser pour l'enchaînement de méthodes.
     * 3. Le nouveau TreeBuilder a une référence à l'instance du Parser.
     */
    @Test
    public void testSetTreeBuilder() {
        // Créer un TreeBuilder initial et un nouveau TreeBuilder
        TreeBuilder initialTreeBuilder = new HtmlTreeBuilder();
        TreeBuilder newTreeBuilder = new HtmlTreeBuilder();

        // Créer une instance de Parser avec le TreeBuilder initial
        Parser parser = new Parser(initialTreeBuilder);

        // Appeler setTreeBuilder avec le nouveau TreeBuilder
        Parser returnedParser = parser.setTreeBuilder(newTreeBuilder);

        // Vérifier que le nouveau TreeBuilder est bien défini dans le Parser
        assertEquals(newTreeBuilder, parser.getTreeBuilder(),
                "Le TreeBuilder devrait être mis à jour avec celui passé à setTreeBuilder.");

        // Vérifier que la méthode retourne la même instance de Parser pour l'enchaînement de méthodes
        assertSame(parser, returnedParser,
                "La méthode setTreeBuilder devrait retourner la même instance de Parser pour l'enchaînement de méthodes.");

        // Vérifier que le nouveau TreeBuilder a une référence au Parser
        assertSame(parser, newTreeBuilder.parser,
                "Le nouveau TreeBuilder devrait avoir son champ parser défini avec le Parser mis à jour.");
    }
}
