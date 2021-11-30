package ru.netology.domain;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Array;

import static org.junit.jupiter.api.Assertions.*;

class ManagerTest {
    NewMovie bloodshot = new NewMovie(1, "pictureUrl1", "Бладшот", "боевик");
    NewMovie forward = new NewMovie(2, "pictureUrl2", "Вперед", "мультфильм");
    NewMovie hotel = new NewMovie(3, "pictureUrl3", "Отель 'Белград'", "комедия");
    NewMovie avatar = new NewMovie(4, "pictureUrl4", "Аватар", "боевик");
    NewMovie gentlemen = new NewMovie(5, "pictureUrl5", "Джентельмены", "боевик");
    NewMovie invisible = new NewMovie(6, "pictureUrl6", "Человек-неведимка", "ужасы");
    NewMovie number = new NewMovie(7, "pictureUrl7", "Номер Один", "комедия");
    NewMovie spider = new NewMovie(8, "pictureUrl8", "Человек-паук", "боевик");
    NewMovie up = new NewMovie(9, "pictureUrl9", "Вверх", "мультфильм");
    NewMovie matrix = new NewMovie(10, "pictureUrl10", "Матрица", "боевик");
    NewMovie shrek = new NewMovie(11, "pictureUrl11", "Шрек", "мультфильм");
    NewMovie shrek2 = new NewMovie(12, "pictureUrl12", "Шрек2", "мультфильм");
    NewMovie shrek3 = new NewMovie(13, "pictureUrl13", "Шрек3", "мультфильм");

    @Test
    void shouldAddMovie() {
        Manager mov = new Manager();
        mov.add(avatar);
        NewMovie[] expected = mov.findAll();
        NewMovie[] actual = {avatar};
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldAddFewMovies() {
        Manager mov = new Manager();
        mov.add(avatar);
        mov.add(forward);
        NewMovie[] expected = mov.findAll();
        NewMovie[] actual = {avatar, forward};
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldGetAllBelowLimit() {
        Manager mov = new Manager(6);
        mov.add(avatar);
        mov.add(forward);
        mov.add(up);
        mov.add(shrek);
        NewMovie[] expected = mov.getAll();
        NewMovie[] actual = {shrek, up, forward, avatar};
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldGetAllAboveLimit() {
        Manager mov = new Manager(7);
        mov.add(bloodshot);
        mov.add(forward);
        mov.add(hotel);
        mov.add(avatar);
        mov.add(gentlemen);
        mov.add(invisible);
        mov.add(number);
        mov.add(spider);
        mov.add(up);
        mov.add(matrix);
        mov.add(shrek);
        NewMovie[] expected = mov.getAll();
        NewMovie[] actual = {number, invisible, gentlemen, avatar, hotel, forward, bloodshot};
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldGetAllAtLimit() {
        Manager mov = new Manager(11);
        mov.add(bloodshot);
        mov.add(forward);
        mov.add(hotel);
        mov.add(avatar);
        mov.add(gentlemen);
        mov.add(invisible);
        mov.add(number);
        mov.add(spider);
        mov.add(up);
        mov.add(matrix);
        mov.add(shrek);
        NewMovie[] expected = mov.getAll();
        NewMovie[] actual = {shrek, matrix, up, spider, number, invisible, gentlemen, avatar, hotel, forward, bloodshot};
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldGetAllWithNoArg() {
        Manager mov = new Manager();
        mov.add(bloodshot);
        mov.add(forward);
        mov.add(hotel);
        mov.add(avatar);
        mov.add(gentlemen);
        mov.add(invisible);
        mov.add(number);
        mov.add(spider);
        mov.add(up);
        mov.add(matrix);
        NewMovie[] expected = mov.getAll();
        NewMovie[] actual = {matrix, up, spider, number, invisible, gentlemen, avatar, hotel, forward, bloodshot};
        assertArrayEquals(expected, actual);
    }


    @Test
    void shouldGetAllWithArg() {
        Manager mov = new Manager(4);
        mov.add(bloodshot);
        mov.add(forward);
        mov.add(hotel);
        mov.add(avatar);
        NewMovie[] expected = mov.getAll();
        NewMovie[] actual = {avatar, hotel, forward, bloodshot};
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldGetAllAtBotLimit() {
        Manager mov = new Manager(1);
        mov.add(bloodshot);
        NewMovie[] expected = mov.getAll();
        NewMovie[] actual = {bloodshot};
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldGetAllLimitZero() {
        Manager mov = new Manager(0);
        mov.add(bloodshot);
        NewMovie[] expected = mov.getAll();
        NewMovie[] actual = new NewMovie[0];
        assertArrayEquals(expected, actual);
    }

}