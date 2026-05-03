// ============================================================
// CAMADA 1 — ENTITIES
// Não conhece nada do exterior.
// Entities — a classe User tem as validações de e-mail e senha diretamente nela.
// "contém as regras de negócio mais cruciais e gerais da empresa".
// ============================================================

package domain.entities;

public class User {
    private String nome;
    private String senha;
    private String email;

    public User(String nome, String senha, String email) {
        // No exemplo de Arquitetura Limpa as entidades possuem regras de negocio puras!
        if (!email.contains("@")) {
            throw new IllegalArgumentException("E-mail inválido!");
        }

        this.nome = nome;
        this.senha = senha;
        this.email = email;
    }

    public String getNome() {
        return nome;
    }
    public String getSenha() {
        return senha;
    }
    public String getEmail() {
        return email;
    }
}
