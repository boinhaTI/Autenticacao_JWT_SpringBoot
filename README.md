# 🔐 API de Autenticação com JWT – Spring Boot

Este projeto é uma **API REST de autenticação e autorização** desenvolvida com **Spring Boot**, utilizando **JWT (JSON Web Token)** e **PostgreSQL**. O objetivo é fornecer um sistema seguro de login, controle de acesso por roles e base reutilizável para projetos acadêmicos ou profissionais.

---

## 📌 Funcionalidades

* Cadastro de usuários
* Login com geração de token JWT
* Autenticação Stateless
* Autorização por roles (`ADMIN`, `USER`)
* Criptografia de senha com BCrypt
* Integração com PostgreSQL
* Segurança com Spring Security

---

## 🛠️ Tecnologias Utilizadas

* Java 17+
* Spring Boot
* Spring Security
* JWT
* JPA / Hibernate
* PostgreSQL
* Lombok
* Maven

---

## 📂 Estrutura do Projeto

```
src/main/java
 └── io.github.boinhaTI.auth_api
     ├── config        # Configurações de segurança e JWT
     ├── controller    # Controllers REST
     ├── enums         # Enum de roles
     ├── model         # Entidades JPA
     ├── repository    # Repositórios JPA
     └── service       # Regras de negócio
```

---

## ⚙️ Configuração do Banco de Dados

### application.properties

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/auth_db
spring.datasource.username=postgres
spring.datasource.password=postgres

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.format_sql=true

api.security.token.secret=MINHA_CHAVE_SECRETA
```

---

## 👤 Entidade Usuário

```java
@Entity
@Table(name = "usuarios")
public class Usuario implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String login;
    private String senha;

    @Enumerated(EnumType.STRING)
    private EnumRole role;
}
```

---

## 🔑 Autenticação JWT

### Fluxo de autenticação

1. Usuário envia login e senha
2. Spring Security autentica
3. Token JWT é gerado
4. Token é retornado ao cliente
5. Token é enviado no header `Authorization`

```
Authorization: Bearer <token>
```

---

## 🔐 Configuração de Segurança

```java
.authorizeHttpRequests(authorize -> authorize
    .requestMatchers(HttpMethod.POST, "/auth").permitAll()
    .requestMatchers(HttpMethod.POST, "/usuarios").permitAll()
    .requestMatchers(HttpMethod.GET, "/usuarios").hasRole("ADMIN")
    .anyRequest().authenticated()
)
```

---

## 📡 Endpoints

### 🔓 Login

**POST** `/auth`

```json
{
  "login": "admin",
  "senha": "123456"
}
```

**Resposta:**

```json
{
  "token": "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9..."
}
```

---

### 📝 Cadastro de Usuário

**POST** `/usuarios`

```json
{
  "nome": "Cristofer",
  "login": "cristof",
  "senha": "123456",
  "role": "ADMIN"
}
```

---

## ✅ Boas Práticas Aplicadas

* Stateless Authentication
* Senhas criptografadas
* Separação de responsabilidades
* Uso de DTOs
* Controle de acesso por roles

---

## 🚀 Possíveis Melhorias

* Refresh Token
* Logout com blacklist
* Auditoria de login
* Swagger / OpenAPI
* Testes automatizados

---

## 👨‍💻 Autor

Projeto desenvolvido para fins **acadêmicos** e **prática em backend com Spring Boot**.

---

⭐ Se este projeto te ajudou, deixe uma estrela no repositório!
