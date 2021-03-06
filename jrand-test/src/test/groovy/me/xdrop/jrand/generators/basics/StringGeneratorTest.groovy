package me.xdrop.jrand.generators.basics

import com.google.common.base.CharMatcher
import me.xdrop.jrand.JRand

class StringGeneratorTest extends GroovyTestCase {

    def instance = {-> JRand.string() }

    void testPool() {
        def pool = "qwz"
        def parts = ["q","w","z"]

        def cgen = instance().pool(pool).gen()
        for (def ch : cgen) {
            assertTrue ch in parts
        }
    }

    void testSymbols() {
        assertFalse CharMatcher.javaLetterOrDigit().matchesAllOf(instance().symbols().gen())
    }

    void testAlpha() {
        assertTrue CharMatcher.javaLetter().matchesAllOf(instance().alpha().gen())
    }

    void testUpperCase() {
       assertTrue CharMatcher.javaUpperCase().matchesAllOf(instance().alpha().casing("upper").gen())
    }

    void testNumber() {
        assertTrue CharMatcher.javaDigit().matchesAllOf(instance().digits().gen())
    }

    void testLowerCase() {
        assertTrue CharMatcher.javaLowerCase().matchesAllOf(instance().alpha().casing("lower").gen())
    }

    void testRange() {
        def res = instance().range(3,5).gen()
        assertTrue res.length() <= 5 && res.length() >= 3
    }

    void testLength() {
        assertTrue instance().length(7).gen().length() == 7
        assertTrue instance().length(1).gen().length() == 1
    }
}
