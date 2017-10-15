package me.xdrop.jrand.builders.basics

import me.xdrop.jrand.JRand
import me.xdrop.jrand.JRandTest

class BoolGeneratorTest extends GroovyTestCase {
    void testLikelihood() {
        def instance = new BoolGenerator()
        assertTrue instance.likelihood(100).gen()
        assertFalse instance.likelihood(0).gen()
        JRandTest.likelihoodTest(instance.&likelihood)
    }

    void testGen() {
        // Nothing for now..
    }
}
