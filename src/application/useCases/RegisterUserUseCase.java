package application.useCases;


import adapters.RegisterUserRequest;
import domain.entities.User;
import domain.entities.UserRepository;


// ============================================================
//Use Cases — o RegisterUserUseCase tem a regra específica da aplicação ("e-mail já cadastrado?") e não conhece Spring nem JPA
// "não queremos que camadas mais externas afetem os casos de uso".
// ============================================================


public class RegisterUserUseCase {
    // Injeta a INTERFACE, não a implementação
    private final UserRepository userRepository;

// Regras especificas da aplicação
    public RegisterUserUseCase(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void execute(RegisterUserRequest request) {

        // Regra de negócio: e-mail já cadastrado? então faça ->
        if (userRepository.existsByEmail(request.email)) {
            throw new RuntimeException("E-mail já cadastrado!");
        }

        // Cria a entidade (a própria entidade valida os dados)
        User newUser = new User(request.nome, request.email, request.senha);

        // Persiste usando o repositório (via interface)
        userRepository.save(newUser);
    }
}
