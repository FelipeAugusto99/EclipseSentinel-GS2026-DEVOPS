package eclipse_sentinel.controller;

import eclipse_sentinel.dto.LoginDTO;
import eclipse_sentinel.dto.TokenDTO;
import eclipse_sentinel.service.AuthService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService service;

    @PostMapping("/login")
    public ResponseEntity<TokenDTO> login(
            @RequestBody @Valid LoginDTO dto) {

        return ResponseEntity.ok(service.login(dto));
    }
}