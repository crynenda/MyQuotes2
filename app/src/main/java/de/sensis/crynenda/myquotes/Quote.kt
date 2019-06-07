package de.sensis.crynenda.myquotes

// data class liefert Konstruktor, Getter, Setter, equals, hashCode und copy mit
// in den () ist der primäre Konstruktor mit seinen membern angegeben
// val = value (immutable), var = variable (änderbar zur Laufzeit)

data class Quote(var text: String, var author: String, var year: String) {}
