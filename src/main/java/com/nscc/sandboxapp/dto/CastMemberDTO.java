package com.nscc.sandboxapp.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class CastMemberDTO {
    @NotBlank
    private String actorName;

    @NotBlank
    private String characterName;

    @NotBlank
    private int movieId; // foreign key of related Movie

    // no castMember id (primary key)
}
