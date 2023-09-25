package SpringBoot.firebase.firebaseCrud.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

public class User {


    private String documentId;
    private String name;
    private String profession;

    public String getDocumentId() {
        return documentId;
    }

    public void setDocumentId(String document_id) {
        this.documentId = document_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }
}
