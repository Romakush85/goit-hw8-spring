package ua.goit.hw8.model.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProducerDto {
    private UUID id;
    @NotNull(message = "Producer name should not be null")
    private String name;

    @Override
    public String toString() {
        return "ProducerDto(id=" + id + ", name=" + name + ")";
    }

}
