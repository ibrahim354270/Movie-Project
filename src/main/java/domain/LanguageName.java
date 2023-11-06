package domain;

public enum LanguageName {
    ENGLISH("ENGLISH"),
    TURKISH("TURKISH"),
    JAPANESE("JAPANESE"),
    CHINESE("CHINESE"),
    GERMAN("GERMAN"),
    FRENCH("FRENCH"),
    ARABIC("ARABIC"),
    KOREAN("KOREAN");
private final String languageName;

    LanguageName(String languageName) {
        this.languageName = languageName;
    }
}
