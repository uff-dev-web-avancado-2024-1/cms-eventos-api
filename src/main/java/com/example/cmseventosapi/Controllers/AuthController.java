package com.example.cmseventosapi.Controllers;


import com.example.cmseventosapi.Auth.JwtUtil;
import com.example.cmseventosapi.Model.Requests.LoginReq;
import com.example.cmseventosapi.Model.Requests.RegisterReq;
import com.example.cmseventosapi.Model.Responses.ErrorRes;
import com.example.cmseventosapi.Model.Responses.LoginResp;
import com.example.cmseventosapi.Model.User;
import com.example.cmseventosapi.Services.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
@Tag(name = "Autenticação")
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserService userService;

    private final JwtUtil jwtUtil;

    public AuthController(JwtUtil jwtUtil) {
        this.jwtUtil = jwtUtil;
    }

    @Operation(summary = "Realiza login", method = "POST")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200",description = "Login realizado com sucesso"),
        @ApiResponse(responseCode = "400",description = "Parametro para login inválidos"),
        @ApiResponse(responseCode = "500",description = "Erro ao realizar login")
    })
    @PostMapping(value = "/login")
    public ResponseEntity login(@RequestBody LoginReq loginReq) {
        try {
            Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginReq.getLogin(), loginReq.getPassword()));
            String login = authentication.getName();
            User user = new User();
            user.setLogin(login);
            String token = jwtUtil.createToken(user);
            LoginResp loginResp = new LoginResp();
            loginResp.setToken(token);
            loginResp.setLogin(login);
            return ResponseEntity.ok(loginResp);

        } catch (BadCredentialsException e) {
            ErrorRes errorResponse = new ErrorRes();
            errorResponse.setStatus(HttpStatus.UNAUTHORIZED);
            errorResponse.setMessage("Credenciais inválidas");
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(errorResponse);
        } catch (Exception e) {
            ErrorRes errorResponse = new ErrorRes();
            errorResponse.setStatus(HttpStatus.INTERNAL_SERVER_ERROR);
            errorResponse.setMessage("Erro ao realizar login");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorResponse);
        }
    }

    @PostMapping(value = "/register")
    public ResponseEntity register (@RequestBody RegisterReq registerReq) {
        try {
            User user = new User();
            user.setPassword(registerReq.getPassword());
            user.setLogin(registerReq.getLogin());
            user.setName(registerReq.getName());
            user.setEmail(registerReq.getEmail());
            User newUser = userService.createUser(user);
            return ResponseEntity.status(HttpStatus.CREATED).body(null);

        } catch (Exception e) {
            ErrorRes errorResponse = new ErrorRes();
            errorResponse.setStatus(HttpStatus.INTERNAL_SERVER_ERROR);
            errorResponse.setMessage("Erro ao realizar cadastro");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorResponse);
        }
    }

}
