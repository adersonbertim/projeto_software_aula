import application.useCases.RegisterUserUseCase;
import domain.entities.UserRepository;
import frameworks.UserController;
import frameworks.UserRepositoryImpl;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        // 1. Cria a implementação do repositório (camada externa)
        UserRepository repository = new UserRepositoryImpl();

        // 2. Injeta no Use Case (inversão de dependência!)
        RegisterUserUseCase useCase = new RegisterUserUseCase(repository);

        // 3. Cria o controller com o Use Case
        UserController controller = new UserController(useCase);

        // 4. Simula uma requisição HTTP chegando
        controller.register("João Silva", "joao@email.com", "senha123");

        // Fluxo:
        // Controller → UseCase → User (entity) → Repository (interface) → DB

    }
}