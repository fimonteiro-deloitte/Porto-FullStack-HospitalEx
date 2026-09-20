package pt.dlt.person.model.ref;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum DocumentType {
    CITIZEN_CARD ("Citizen Card"),
    PASSPORT ("Passport");

    private final String description;

    DocumentType(String description) {
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
