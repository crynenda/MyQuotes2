package de.sensis.crynenda.myquotes;

public class QuoteJava {

    private String text;
    private String author;
    private String year;

    // Konstruktor
    public QuoteJava(String text, String author, String year) {
        setText(text);
        setAuthor(author);
        setYear(year);
    }

    // Getter und Setter
    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }
}
