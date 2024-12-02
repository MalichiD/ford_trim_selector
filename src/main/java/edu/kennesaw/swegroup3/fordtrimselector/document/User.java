package edu.kennesaw.swegroup3.fordtrimselector.document;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document("user")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    private String authid;
    private String email;
    private List<String> favorites;
}
