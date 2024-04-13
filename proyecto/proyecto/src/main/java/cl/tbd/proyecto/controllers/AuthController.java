package cl.tbd.proyecto.controllers;

import cl.tbd.proyecto.controllers.DTO.LoginDTO;
import cl.tbd.proyecto.entities.UsuarioEntity;
import cl.tbd.proyecto.service.UsuarioService;
import cl.tbd.proyecto.utils.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
public class AuthController {
    @Autowired
    UsuarioService usuarioService;

    @Autowired
    JwtUtils jwtUtils;

    @PostMapping("/login")
    public String login(@RequestBody LoginDTO request) {
        return  usuarioService.login(request);
    }

    @GetMapping("/activeUser")
    public String getUserProfile(@RequestHeader("Authorization") String token) {
        // Verifica y valida el token JWT
        if (token != null && token.startsWith("Bearer ")) {
            String jwtToken = token.substring(7);
            if (jwtUtils.validateToken(jwtToken)) {
                // Extrae el nombre de usuario del token
                String username = jwtUtils.extractUsername(jwtToken);
                // Aquí puedes cargar el perfil del usuario y devolverlo
                return "El usuario activo es: " + username;
            }
        }
        // Si el token no es válido, devuelve un mensaje de error o realiza otra acción apropiada
        return "Token inválido";
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody UsuarioEntity usuario){
        return ResponseEntity.ok(usuarioService.registerUser(usuario));
    }

}
