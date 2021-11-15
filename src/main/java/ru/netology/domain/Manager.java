package ru.netology.domain;

public class Manager {

    public NewMovie[] movies = new NewMovie[0];
    NewMovie Bloodshot = new NewMovie(1, "pictureUrl1", "Бладшот", "боевик");
    NewMovie Forward = new NewMovie(2, "pictureUrl2", "Вперед", "мультфильм");
    NewMovie Hotel = new NewMovie(3, "pictureUrl3", "Отель 'Белград'", "комедия");

    //movies[0] = Hotel;

    int movieLimit = 10;

    public Manager(int movieLimit) {
        this.movieLimit = movieLimit;
    }

    public Manager(){
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
        if (movieLimit > 10) {
            resultLength = 10;
        } else {
            resultLength = movieLimit;
        }
        NewMovie[] result = new NewMovie[resultLength];
        for (int i = 0; i < result.length; i++) {
            int index = resultLength - i - 1 ;
            result[i] = movies[index];
        }
        return result;
    }
}
