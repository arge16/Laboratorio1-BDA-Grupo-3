package cl.tbd.proyecto.service;

import cl.tbd.proyecto.controllers.DTO.LoginDTO;
import cl.tbd.proyecto.entities.UsuarioEntity;
import cl.tbd.proyecto.repositories.UsuarioRepository;
import cl.tbd.proyecto.utils.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    @Autowired
    UsuarioRepository usuarioRepository;

    @Autowired
    JwtUtils jwtUtils;

    public UsuarioEntity registerUser(UsuarioEntity usuario, String actualUser) {
        // Verificar si el usuario ya está registrado
        if (usuarioRepository.findByUsername(usuario.getUsername()) != null) {
            throw new RuntimeException("El nombre de usuario ya está en uso.");
        }
        return usuarioRepository.create(usuario, actualUser);  /*Los argumentos de los metodos no coinciden*/
    }

    public String login(LoginDTO loginRequest){
        if(usuarioRepository.Login(loginRequest.getUsername(),loginRequest.getPassword())){
            return jwtUtils.generateToken(usuarioRepository.findByUsername(loginRequest.getUsername()));
        }else{
            return null;
        }
    }

    public String getUser(String token){
        if (token != null && token.startsWith("Bearer ")) {
        String jwtToken = token.substring(7);
        if (jwtUtils.validateToken(jwtToken)) {
            return jwtUtils.extractUsername(jwtToken);
        }
    }
        return null;
    }
}
