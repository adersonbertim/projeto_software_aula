// ============================================================
// CAMADA 3 — INTERFACE ADAPTERS (porta de entrada)
// DTO = Data Transfer Object
// DTO: objeto simples que carrega os dados do formulário/HTTP
// Interface Adapters — o RegisterUserRequest (DTO) e a interface UserRepository fazem exatamente o papel de formatar e intermediar dados entre o mundo externo e o núcleo.
//
// ============================================================

package adapters;

public class RegisterUserRequest {
        public String nome;
        public String senha;
        public String email;

}
