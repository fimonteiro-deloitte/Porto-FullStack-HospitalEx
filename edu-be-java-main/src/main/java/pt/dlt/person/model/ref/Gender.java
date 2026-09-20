package pt.dlt.person.model.ref;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum Gender {
    MALE("Male"),
    FEMALE("Female"),
    OTHER("Other");

    private final String description;

    Gender(String description) {
        this.description = description;
    }

    @JsonProperty("label")
    public String getDescription() {
        return description;
    }

    @JsonProperty("value")
    public String getValue() {
        return name();
    }
}
