package eclipse_sentinel.dto;

public record AreaDTO(
        Long id,
        String nome,
        Double latitude,
        Double longitude,
        String statusArea,
        String nivelRisco
) {
}