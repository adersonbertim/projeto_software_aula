package frameworks;

import domain.entities.User;
import domain.entities.UserRepository;


//Frameworks & Drivers — o UserRepositoryImpl representa bem o conceito de que banco de dados e
// frameworks "viram um detalhe" na camada mais externa.


public class UserRepositoryImpl implements UserRepository {
    // (Aqui entraria o JPA, por exemplo)

    @Override
    public void save(User user) {
        //Simulando o salvamento no banco
        System.out.println("Salvando usuário: " + user.getEmail());
    }

    public boolean existsByEmail(String email) {
        // Regras de busca no banco
        // SELECT * FROM users WHERE ***
        return false;
    }


}
