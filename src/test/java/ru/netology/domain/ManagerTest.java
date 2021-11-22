package ru.netology.domain;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Array;

import static org.junit.jupiter.api.Assertions.*;

class ManagerTest {
    NewMovie Bloodshot = new NewMovie(1, "pictureUrl1", "Бладшот", "боевик");
    NewMovie Forward = new NewMovie(2, "pictureUrl2", "Вперед", "мультфильм");
    NewMovie Hotel = new NewMovie(3, "pictureUrl3", "Отель 'Белград'", "комедия");
    NewMovie Avatar = new NewMovie(4, "pictureUrl4", "Аватар", "боевик" );
    NewMovie Gentlemen = new NewMovie(5, "pictureUrl5", "Джентельмены", "боевик" );
    NewMovie Invisible = new NewMovie(6, "pictureUrl6", "Челоаек-неведимка", "ужасы" );
    NewMovie Number = new NewMovie(7, "pictureUrl7", "Номер Один", "комедия" );
    NewMovie Spider = new NewMovie(8, "pictureUrl8", "Челоаек-паук", "боевик" );
    NewMovie Up = new NewMovie(9, "pictureUrl9", "Вверх", "мультфильм" );
    NewMovie Matrix = new NewMovie(10, "pictureUrl10", "Матрица", "боевик" );
    NewMovie Shrek = new NewMovie(11, "pictureUrl11", "Шрек", "мультфильм");
    NewMovie Shrek2 = new NewMovie(12, "pictureUrl12", "Шрек2", "мультфильм");
    NewMovie Shrek3 = new NewMovie(13, "pictureUrl13", "Шрек3", "мультфильм");

    @Test
    void shouldAddMovie() {
        Manager mov = new Manager();
        mov.add(Avatar);
        NewMovie[] expected = mov.findAll();
        NewMovie[] actual = {Avatar};
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldAddMovieFewMovies() {
        Manager mov = new Manager();
        mov.add(Avatar);
        mov.add(Forward);
        NewMovie[] expected = mov.findAll();
        NewMovie[] actual = {Avatar, Forward};
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldGetAllWithNoArg() {
        Manager mov = new Manager();
        mov.add(Bloodshot);
        mov.add(Forward);
        mov.add(Hotel);
        mov.add(Avatar);
        mov.add(Gentlemen);
        mov.add(Invisible);
        mov.add(Number);
        mov.add(Spider);
        mov.add(Up);
        mov.add(Matrix);
        NewMovie[] expected = mov.getAll();
        NewMovie[] actual = {Matrix, Up, Spider, Number, Invisible, Gentlemen,Avatar, Hotel, Forward, Bloodshot};
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldGetAllOverTopLimit() {
        Manager mov = new Manager(11);
        mov.add(Bloodshot);
        mov.add(Forward);
        mov.add(Hotel);
        mov.add(Avatar);
        mov.add(Gentlemen);
        mov.add(Invisible);
        mov.add(Number);
        mov.add(Spider);
        mov.add(Up);
        mov.add(Matrix);
        mov.add(Shrek);
        NewMovie[] expected = mov.getAll();
        NewMovie[] actual = {Matrix, Up, Spider, Number, Invisible, Gentlemen,Avatar, Hotel, Forward, Bloodshot};
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldGetAllAtTopLimit() {
        Manager mov = new Manager(9);
        mov.add(Bloodshot);
        mov.add(Forward);
        mov.add(Hotel);
        mov.add(Avatar);
        mov.add(Gentlemen);
        mov.add(Invisible);
        mov.add(Number);
        mov.add(Spider);
        mov.add(Up);
        mov.add(Matrix);
        mov.add(Shrek);
        NewMovie[] expected = mov.getAll();
        NewMovie[] actual = {Up, Spider, Number, Invisible, Gentlemen,Avatar, Hotel, Forward, Bloodshot};
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldGetAllWithArg() {
        Manager mov = new Manager(4);
        mov.add(Bloodshot);
        mov.add(Forward);
        mov.add(Hotel);
        mov.add(Avatar);
        NewMovie[] expected = mov.getAll();
        NewMovie[] actual = {Avatar, Hotel, Forward, Bloodshot};
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldGetAllAtBotLimit() {
        Manager mov = new Manager(1);
        mov.add(Bloodshot);
        NewMovie[] expected = mov.getAll();
        NewMovie[] actual = {Bloodshot};
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldGetAllLimitZero() {
        Manager mov = new Manager(0);
        mov.add(Bloodshot);
        NewMovie[] expected = mov.getAll();
        NewMovie[] actual = new NewMovie[0];
        assertArrayEquals(expected, actual);
    }

}