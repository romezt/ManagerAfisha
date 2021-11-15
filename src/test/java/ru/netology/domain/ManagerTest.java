package ru.netology.domain;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Array;

import static org.junit.jupiter.api.Assertions.*;

class ManagerTest {

    @Test
    void shouldAddMovie() {
        Manager mov = new Manager();
        NewMovie Avatar = new NewMovie(10, "pictureUrl10", "Аватар", "боевик" );
        mov.add(Avatar);
    }

    @Test
    void shouldGetAll() {
        Manager mov = new Manager(3);
        mov.getAll();

    }
}