package Watki;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class JasIMalgosiaTest {

    @Test
    public void shouldDoTasks() throws InterruptedException {
        //given
        //symullujemy konsole mockiem
        PrintStream ps = Mockito.mock(PrintStream.class);
        //ustawiamy nasz mock konsoli jako systemową konsolę w srodku
        System.setOut(ps);

        //when
        JasIMalgosia.main(null);

        //then
        //za pomoca verify zweryfikowac czy na ekranie pokazalo sie ze Jas je sniadanie
        Mockito.verify(ps).println("Jas je sniadanie...");
        Mockito.verify(ps).println("Malgosia ubiera sie...");


    }
}