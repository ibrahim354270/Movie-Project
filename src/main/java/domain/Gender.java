package domain;


public enum Gender {
    MALE("MALE"),
    FEMALE("FEMALE"),
    OTHER("OTHER");

    private final String genderType;

    Gender(String genderType) {
        this.genderType = genderType;
    }


}