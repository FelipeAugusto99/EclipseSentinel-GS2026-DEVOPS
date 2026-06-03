package eclipse_sentinel.dto;

public record SensorDTO(
        Long id,
        String tipoSensor,
        String statusSensor,
        Long areaId
) {
}