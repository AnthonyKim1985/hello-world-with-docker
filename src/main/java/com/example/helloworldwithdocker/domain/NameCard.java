package com.example.helloworldwithdocker.domain;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

@ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
@Document(collection = "name_cards")
public class NameCard implements Serializable {
    @Id
    @Getter
    @Setter
    private String id;

    @Getter
    @Setter
    private String name;

    public NameCard(@NotBlank String name) {
        this.name = name;
    }
}
