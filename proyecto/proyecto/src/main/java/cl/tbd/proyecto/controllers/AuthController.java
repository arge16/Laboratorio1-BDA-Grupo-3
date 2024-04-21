package cl.tbd.proyecto.controllers;

import cl.tbd.proyecto.controllers.DTO.LoginDTO;
import cl.tbd.proyecto.entities.UsuarioEntity;
import cl.tbd.proyecto.service.UsuarioService;
import cl.tbd.proyecto.utils.JwtUtils;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/")
public class AuthController {
    @Autowired
    UsuarioService usuarioService;

    @Autowired
    JwtUtils jwtUtils;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginDTO request) {
        Map<String, String> response = new HashMap<>();
        response.put("Authorization", usuarioService.login(request));
        return  ResponseEntity.ok(response);
    }

    @GetMapping("/activeUser")
    public String getUserProfile(@RequestHeader("Authorization") String token) {
        String user = usuarioService.getUser(token);
        if (user != null){
            return "El usuario activo es: " + user;
        }
        return "Token inválido";
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody UsuarioEntity usuario, String actualUser){
        return ResponseEntity.ok(usuarioService.registerUser(usuario, actualUser));
    }

}
