package eclipse_sentinel.service;

import eclipse_sentinel.dto.LoginDTO;
import eclipse_sentinel.dto.TokenDTO;
import eclipse_sentinel.security.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final JwtService jwtService;

    public TokenDTO login(LoginDTO dto) {

        String token = jwtService.gerarToken(dto.email());

        return new TokenDTO(token, "Bearer");
    }
}