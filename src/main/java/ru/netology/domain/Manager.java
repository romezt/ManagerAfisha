package ru.netology.domain;

public class Manager {

    private NewMovie[] movies = new NewMovie[0];

    private int movieLimit = 10;

    public Manager(int movieLimit) {
        this.movieLimit = movieLimit;
    }

    public Manager() {
    }

    public void add(NewMovie movie) {
        int length = movies.length + 1;
        NewMovie[] tmp = new NewMovie[length];
        System.arraycopy(movies, 0, tmp, 0, movies.length);
        int lastIndex = tmp.length - 1;
        tmp[lastIndex] = movie;
        movies = tmp;
    }

    public NewMovie[] findAll() {
        return movies;
    }

    public NewMovie[] getAll() {
        NewMovie[] movies = findAll();
        int resultLength;
        if (movieLimit > findAll().length) {
            resultLength = findAll().length;
        } else {
            resultLength = movieLimit;
        }
        NewMovie[] result = new NewMovie[resultLength];
        for (int i = 0; i < result.length; i++) {
            int index = resultLength - i - 1;
            result[i] = movies[index];
        }
        return result;
    }
}
