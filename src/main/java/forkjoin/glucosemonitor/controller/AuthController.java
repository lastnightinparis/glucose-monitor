package forkjoin.glucosemonitor.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.context.HttpSessionSecurityContextRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@AllArgsConstructor
public class AuthController {

    private AuthenticationManager authenticationManager;
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    @GetMapping("/login")
    public ResponseEntity<String> login(HttpServletRequest request, @RequestParam(name = "login") String login, @RequestParam(name = "password") String password) {
        System.out.println(bCryptPasswordEncoder.encode(password));
        UsernamePasswordAuthenticationToken authRequest = new UsernamePasswordAuthenticationToken(login, password);
        Authentication authenticate = authenticationManager.authenticate(authRequest);
        SecurityContextHolder.getContext().setAuthentication(authenticate);
        HttpSession session = request.getSession(true);
        session.setAttribute(HttpSessionSecurityContextRepository.SPRING_SECURITY_CONTEXT_KEY, SecurityContextHolder.getContext());
        return ResponseEntity.ok().body("Successully login!");
    }
}
