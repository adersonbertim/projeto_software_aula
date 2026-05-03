package frameworks;

import adapters.RegisterUserRequest;
import application.useCases.RegisterUserUseCase;


// ============================================================
//O UserController também está aqui, cobrindo o MVC.
// ============================================================


public class UserController {
    private final RegisterUserUseCase registerUserUseCase;

    public UserController(RegisterUserUseCase registerUserUseCase) {
        this.registerUserUseCase = registerUserUseCase;
    }

    // @PostMapping("/register")
    public String register(String nome, String email, String senha) {
        // Monta o DTO com os dados da requisição HTTP
        RegisterUserRequest request = new RegisterUserRequest();
        request.nome = nome;
        request.email = email;
        request.senha = senha; // Em situações reais esse dado pode ser ofuscado

        registerUserUseCase.execute(request);
        return "Usuario Cadastrado com sucesso!";
    };


}
