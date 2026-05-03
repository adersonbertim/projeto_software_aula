// ============================================================
// CAMADA 3 — INTERFACE ADAPTERS (porta de saída)
// Interface que define o "contrato" com o banco de dados.
// O Use Case depende DESTA interface, nunca da implementação.
// ============================================================

package domain.entities;

public interface UserRepository {
    void save(User user);
    boolean existsByEmail(String email);
}
