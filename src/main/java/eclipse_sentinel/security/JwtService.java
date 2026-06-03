package eclipse_sentinel.security;

import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class JwtService {

    private static final String SECRET =
            "eclipse-sentinel-fiap-global-solution-2026";

    public String gerarToken(String email) {

        return email + "_" + new Date().getTime();
    }

    public boolean validarToken(String token) {
        return token != null && !token.isBlank();
    }

    public String extrairEmail(String token) {

        if (token == null) {
            return null;
        }

        return token.split("_")[0];
    }
}