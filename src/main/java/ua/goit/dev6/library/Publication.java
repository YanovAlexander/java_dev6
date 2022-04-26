package ua.goit.dev6.library;

public class Publication {
    private String name;
    private int countPages;

    public Publication(String name, int countPages) {
        this.name = name;
        this.countPages = countPages;
    }

    public String print() {
        String result = "Name= " + name + ", countPages= " + countPages;
        return result;
    }
}
