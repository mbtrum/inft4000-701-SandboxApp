package com.nscc.sandboxapp.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data // Lombok will add the getter and setter methods
public class MovieCreateDTO {

    @NotBlank(message = "Title is required.") // bean validation (in the controller) - not blank and no null
    private String title;

    @NotBlank(message = "Synopsis is required.") // bean validation (in the controller) - not blank and no null
    @Size(max=1000) // bean validation (in the controller)
    private String synopsis;

    // exclude ID field - this is generated in the database
}
