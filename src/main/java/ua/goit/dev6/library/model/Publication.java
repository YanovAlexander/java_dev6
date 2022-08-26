package ua.goit.dev6.library.model;

import java.util.Objects;

public class Publication {
    private Integer id;
    private String name;
    private Integer countPages;

    public Publication(Integer id, String name, Integer countPages) {
        this.id = id;
        this.name = name;
        this.countPages = countPages;
    }

    public Publication(String name, Integer countPages) {
        this.name = name;
        this.countPages = countPages;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCountPages() {
        return countPages;
    }

    public void setCountPages(Integer countPages) {
        this.countPages = countPages;
    }

    public String print() {
        String result = "name= " + name + ", countPages= " + countPages;
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Publication that = (Publication) o;
        return countPages == that.countPages && name.equals(that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, countPages);
    }
}
