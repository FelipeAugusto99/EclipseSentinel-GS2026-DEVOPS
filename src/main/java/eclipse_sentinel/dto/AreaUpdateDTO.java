package eclipse_sentinel.dto;

public record AreaUpdateDTO(

        String nome,
        Double latitude,
        Double longitude,
        String statusArea,
        String nivelRisco

) {
}