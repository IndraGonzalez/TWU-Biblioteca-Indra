package com.twu.biblioteca;

public class Movie extends CheckableItem {

    private String name;
    private String director;
    private int rating;

    public Movie(int id, String name, String director, int rating) {
        super(id);
        this.name = name;
        this.director = director;
        this.rating = rating;
    }

    public Movie(int id, String name, String director) {
        super(id);
        this.name = name;
        this.director = director;
    }

    public String getName() {
        return name;
    }

    public String getDirector() {
        return director;
    }

    public int getRating() {
        return rating;
    }

    @Override
    public String getPrint() {
        if((rating <= 10) && (rating >= 1)) return (this.getId() + "\t\t" + name + "\t\t" + director + "\t\t" + rating);
        else return (this.getId() + "\t\t" + name + "\t\t" + director + "\t\t" + "unrated");
    }
}
