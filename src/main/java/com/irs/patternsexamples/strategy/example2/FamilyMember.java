package com.irs.patternsexamples.strategy.example2;

/**
 * Clase padre abstracta de los mienbros de la familia.
 *
 * @author IRS
 * @version 1.0.0
 */
public abstract class FamilyMember {

    private final String name;
    private final MovieGenre movieGenre;

    public FamilyMember(String name, MovieGenre movieGenre) {
        super();
        this.name = name;
        this.movieGenre = movieGenre;
    }

    public String getName() {
        return name;
    }

    public MovieGenre getMovieGenre() {
        return movieGenre;
    }

    public void letUsGoForAMovie() {
        System.out.println(getName() + " would love to watch " + movieGenre.describeABit());
    }
}
