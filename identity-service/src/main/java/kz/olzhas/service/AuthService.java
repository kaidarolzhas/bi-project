package kz.olzhas.service;

import kz.olzhas.dto.UserDto;
import kz.olzhas.entity.UserCredential;
import kz.olzhas.mapper.UserMapper;
import kz.olzhas.repository.UserCredentialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    @Autowired
    private UserCredentialRepository repository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtService jwtService;

    @Autowired
    private UserMapper userMapper;

    public String saveUser(UserCredential credential) {
        credential.setPassword(passwordEncoder.encode(credential.getPassword()));
        repository.save(credential);
        return "user added to the system";
    }

    public String generateToken(String username) {
        return jwtService.generateToken(username);
    }

    public void validateToken(String token) {
        jwtService.validateToken(token);
    }


    public UserDto getUserIdByToken(String token) {
        if (token != null && token.startsWith("Bearer ")) {
            token = token.substring(7);
        }
        String email = jwtService.decodeToken(token);
        return userMapper.toDto(repository.findByName(email).orElse(null));
    }

    public UserDto getUserByUserId(Long userId) {
        return userMapper.toDto(repository.findById(userId).orElse(null));
    }

}
