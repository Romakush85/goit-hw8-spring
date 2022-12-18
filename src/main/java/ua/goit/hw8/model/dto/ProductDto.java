package ua.goit.hw8.model.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.math.BigDecimal;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductDto {
    private UUID id;
    @NotNull(message = "Product name should not be null")
    private String name;
    @NotNull(message = "Product price should not be null")
    private BigDecimal price;

    private ProducerDto producerDto;
    @NotNull(message = "Producer id should not be null")
    private UUID producerId;

}
