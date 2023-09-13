package com.irs.patternsexamples.strategy.example2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DriverTest {

    FamilyMember[] allInTheFamily = new FamilyMember[] {
            new Dad(),
            new Mom(),
            new Kid()
    };

    @Test
    public void testLetUsGoForAMovie() {
        assertEquals("Dad", allInTheFamily[0].getName());
        assertEquals("guns, firing, fights, will chases etc.", allInTheFamily[0].getMovieGenre().describeABit());

        assertEquals("Mom", allInTheFamily[1].getName());
        assertEquals("some romantic flick", allInTheFamily[1].getMovieGenre().describeABit());

        assertEquals("Kid", allInTheFamily[2].getName());
        assertEquals("cartoons! What else?", allInTheFamily[2].getMovieGenre().describeABit());
    }
}