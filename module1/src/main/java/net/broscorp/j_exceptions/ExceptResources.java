package net.broscorp.j_exceptions;

import java.io.*;

public class ExceptResources {

    void catchIOException(String file) {
        try (Reader reader = new FileReader(file)) {
        } catch (IOException e) {
        } finally {
            System.out.println("Bye bye!!!");
        }
    }

    void catchException() {
        try (Reader reader = new FileReader("file")) {
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    void catchThrowable() {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
        } catch (Throwable e) {
            e.printStackTrace();
        }
    }

}
