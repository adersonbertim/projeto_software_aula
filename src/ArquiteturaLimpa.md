============================================================

#  **RESUMO: Por que isso é Clean Architecture?**

* User (entity) não sabe que existe Spring, JPA ou HTTP.

* RegisterUserUseCase depende de uma INTERFACE, não do banco.
* Se trocar MySQL por MongoDB, só muda a camada de Frameworks.
* Se tirar o Spring e usar outro framework, o Use Case não muda.
* A regra "e-mail deve ter @" está na Entity, testável isolada.

1. A dependência sempre aponta para dentro:
2. Frameworks → Adapters → Use Cases → Entities
============================================================

## Entities
A classe `User` contém as validações de e-mail e senha diretamente nela.  
Ela **contém as regras de negócio mais cruciais e gerais da empresa**.

## Use Cases
O `RegisterUserUseCase` possui a regra específica da aplicação, como:
- "e-mail já cadastrado?"

Ele não conhece **Spring** nem **JPA**, pois:
> "não queremos que camadas mais externas afetem os casos de uso".

## Interface Adapters
- `RegisterUserRequest` (DTO)
- Interface `UserRepository`
- `UserController`

Esses elementos têm o papel de:
- Formatar dados
- Intermediar a comunicação entre o mundo externo e o núcleo

Além disso, o `UserController` também cobre o padrão **MVC**.

## Frameworks & Drivers
O `UserRepositoryImpl`, junto com o uso de **JPA/MySQL**, representa bem o conceito de que:

> Banco de dados e frameworks são apenas detalhes da camada mais externa.

## Regra de Dependência
O fluxo correto das dependências é:
O ponto mais importante do código é que:

- O `RegisterUserUseCase` depende da **interface `UserRepository`**
- E não da sua implementação

Isso demonstra, na prática, o princípio da **Inversão de Dependência**.