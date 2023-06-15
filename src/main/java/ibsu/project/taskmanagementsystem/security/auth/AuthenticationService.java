package ibsu.project.taskmanagementsystem.security.auth;


import ibsu.project.taskmanagementsystem.entities.User;
import ibsu.project.taskmanagementsystem.repositories.UserRepository;
import ibsu.project.taskmanagementsystem.security.config.JwtService;
import ibsu.project.taskmanagementsystem.security.token.Token;
import ibsu.project.taskmanagementsystem.security.token.TokenRepository;
import ibsu.project.taskmanagementsystem.utils.GeneralUtil;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {

    private final UserRepository repository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    private final TokenRepository tokenRepository;

    public AuthenticationService(UserRepository repository, PasswordEncoder passwordEncoder, JwtService jwtService, AuthenticationManager authenticationManager, TokenRepository tokenRepository) {
        this.repository = repository;
        this.passwordEncoder = passwordEncoder;
        this.jwtService = jwtService;
        this.authenticationManager = authenticationManager;
        this.tokenRepository = tokenRepository;
    }

    public AuthenticationResponse register(RegisterRequest request) throws Exception {
        User user = new User();
        GeneralUtil.getCopyOf(request, user, "password");
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        repository.save(user);
        var jwtToken = jwtService.generateToken(user);
        tokenRepository.save(new Token(jwtToken, user));
        return new AuthenticationResponse(jwtToken);
    }

    public AuthenticationResponse authenticate(AuthenticationRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(),
                        request.getPassword()
                )
        );
        var user = repository.findByEmail(request.getEmail())
                .orElseThrow();
        var jwtToken = jwtService.generateToken(user);
        tokenRepository.save(new Token(jwtToken, user));
        return new AuthenticationResponse(jwtToken);
    }
}
