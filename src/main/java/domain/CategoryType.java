package domain;

public enum CategoryType {
    ACTION("ACTION"),
    ADVENTURE(" ADVENTURE"),
    ANIMATED("ANIMATED"),
    COMEDY("COMEDY"),
    DRAMA("DRAMA"),
    FANTASY(" FANTASY"),
    HISTORICAL(" HISTORICAL"),
    SCIENCE("SCIENCE"),
    ROMANCE("ROMANCE"),
    HORROR("HORROR");

    private final String typeName;

    CategoryType(String typeName) {
        this.typeName = typeName;
    }
}
