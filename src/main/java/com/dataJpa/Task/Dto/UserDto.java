package com.dataJpa.Task.Dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {

    private Long id;
    @NotEmpty(message = "first name cannot be empty")
    private String name;
    @Min(value = 1)
    private int price;
    @NotEmpty(message = "category cannot be empty")
    private String category;
}
