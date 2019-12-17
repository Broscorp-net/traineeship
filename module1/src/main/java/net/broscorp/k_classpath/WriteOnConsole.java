package net.broscorp.k_classpath;

class WriteOnConsole {

    void returnConsoleText() {
        ReadConsole readConsole = new ReadConsole();
        System.out.println("Your text is... " + readConsole.getReadConsoleText());
    }
}
