# 💬 ForumHub — API REST

> Projeto final do programa **Oracle Next Education (ONE)** — Trilha Back-End Java + Spring Boot

---

## 📌 Sobre o projeto

O **ForumHub** é uma API REST que simula o back-end de um fórum de discussão, inspirado no Fórum da Alura. Usuários autenticados podem criar tópicos de dúvidas vinculados a cursos, responder tópicos de outros usuários e gerenciar seus próprios recursos.

O projeto foi desenvolvido como desafio final do programa ONE, mas vai além do escopo mínimo solicitado: enquanto o desafio pedia apenas o CRUD de tópicos com autenticação, este projeto implementa **quatro domínios completos** (usuários, cursos, tópicos e respostas), documentação OpenAPI via Swagger UI, um sistema de validações com interface strategy e migrations versionadas com Flyway.

---

## 📜 Funcionalidades

### Exigidas pelo desafio
- ✅ Cadastro, listagem, detalhamento e exclusão de **tópicos**
- ✅ Autenticação de usuários com **JWT (Bearer Token)**
- ✅ Proteção de rotas — apenas usuários autenticados podem criar, atualizar e deletar recursos
- ✅ Persistência em banco de dados relacional (**PostgreSQL**)
- ✅ Migrations com **Flyway**

### Extras implementados
- CRUD completo de **usuários** (cadastro público + detalhamento/exclusão autenticados)
- CRUD completo de **cursos** (criação, detalhamento e exclusão autenticados)
- CRUD completo de **respostas** (vinculadas a tópicos e usuários)
- Documentação interativa da API via **Swagger UI / SpringDoc OpenAPI**
- Sistema de validações desacoplado com **interfaces Strategy** por domínio
- Tratamento global de exceções com `@ControllerAdvice`
- Validação de duplicatas (tópico repetido no mesmo curso, usuário/e-mail já cadastrado, curso duplicado)

---

## 🛠️ Tecnologias utilizadas

| Tecnologia | Versão | Finalidade |
|---|---|---|
| Java | 17 | Linguagem principal |
| Spring Boot | 3.x | Framework back-end |
| Spring Security | — | Autenticação e autorização |
| Spring Data JPA | — | Persistência / ORM |
| PostgreSQL | — | Banco de dados relacional |
| Flyway | — | Versionamento de schema |
| Auth0 Java JWT | 4.5.1 | Geração e validação de tokens JWT |
| SpringDoc OpenAPI | 2.8.16 | Documentação Swagger UI |
| Lombok | — | Redução de boilerplate |
| Maven | — | Gerenciamento de dependências |

---

## 🗂️ Estrutura do projeto

```
src/main/java/br/com/luisEduardo/ForumHub/
│
├── controller/         # Endpoints REST (Topico, Resposta, Curso, Usuario, Autenticacao)
├── service/            # Regras de negócio por domínio
├── repository/         # Interfaces JPA (Spring Data)
├── model/              # Entidades JPA (Topico, Resposta, Curso, Usuario)
├── dto/                # Records de entrada e saída por domínio
│   ├── topicoDTOS/
│   ├── respostaDTOS/
│   ├── cursoDTOS/
│   ├── usuarioDTOS/
│   └── tokenDTOS/
├── validations/        # Validações via interface Strategy por domínio
│   ├── topico/
│   ├── resposta/
│   ├── curso/
│   └── usuario/
├── exceptions/         # GlobalExceptionHandler + ValidacaoException
└── infra/
    ├── security/       # SecurityConfig + SecurityFilter (JWT)
    └── springdoc/      # Configuração Swagger com suporte a Bearer Token
```

---

## 📡 Endpoints

### 🔐 Autenticação
| Método | Rota | Descrição | Auth |
|---|---|---|---|
| POST | `/login` | Autentica usuário e retorna token JWT | ❌ |

### 👤 Usuários
| Método | Rota | Descrição | Auth |
|---|---|---|---|
| POST | `/usuarios/cadastro` | Cadastra novo usuário | ❌ |
| GET | `/usuarios/{id}` | Detalha usuário por ID | ✅ |
| DELETE | `/usuarios/{id}` | Remove usuário por ID | ✅ |

### 📚 Cursos
| Método | Rota | Descrição | Auth |
|---|---|---|---|
| POST | `/cursos` | Cadastra novo curso | ✅ |
| GET | `/cursos/{id}` | Detalha curso por ID | ✅ |
| DELETE | `/cursos/{id}` | Remove curso por ID | ✅ |

### 💬 Tópicos
| Método | Rota | Descrição | Auth |
|---|---|---|---|
| POST | `/topicos` | Cria novo tópico | ✅ |
| GET | `/topicos/{id}` | Detalha tópico por ID | ✅ |
| DELETE | `/topicos/{id}` | Remove tópico por ID | ✅ |

### 💡 Respostas
| Método | Rota | Descrição | Auth |
|---|---|---|---|
| POST | `/respostas` | Cria resposta para um tópico | ✅ |
| GET | `/respostas/{id}` | Detalha resposta por ID | ✅ |
| DELETE | `/respostas/{id}` | Remove resposta por ID | ✅ |

> ✅ = requer Bearer Token no header `Authorization`

---

## 🔒 Segurança e autenticação

O sistema usa **JWT (JSON Web Token)** com o esquema **Bearer**. O fluxo é:

1. O usuário faz `POST /login` com e-mail e senha.
2. A API retorna um token JWT.
3. Todas as rotas protegidas exigem o header: `Authorization: Bearer <token>`

Rotas públicas (sem autenticação): `POST /login` e `POST /usuarios/cadastro`.

---

## 🧠 Regras de negócio

- Não é possível cadastrar dois cursos com o mesmo nome.
- Não é possível cadastrar dois usuários com o mesmo e-mail ou nome.
- Não é possível criar dois tópicos idênticos (mesmo título) no mesmo curso.
- Respostas são validadas para garantir que o tópico e o usuário referenciados existam.
- A data de criação dos tópicos é definida automaticamente pelo sistema no momento do cadastro.

---

## 🗄️ Banco de dados

O schema é gerenciado pelo **Flyway** com 8 migrations versionadas:

| Migration | Descrição |
|---|---|
| V1 | Criação da tabela `usuarios` |
| V2 | Criação da tabela `curso` |
| V3 | Criação da tabela `topicos` |
| V4 | Criação da tabela `respostas` |
| V5–V8 | Alterações incrementais nas tabelas |

---

## 📖 Documentação interativa

Com a aplicação rodando, acesse a documentação Swagger em:

```
http://localhost:8080/swagger-ui.html
```

A interface permite autenticar com o token JWT e testar todos os endpoints diretamente no navegador.

---

## 🚀 Como executar

### Pré-requisitos
- Java 17+
- Maven
- PostgreSQL rodando localmente

### Configuração

1. Clone o repositório:
```bash
git clone https://github.com/seu-usuario/ForumHub.git
cd ForumHub
```

2. Configure o banco de dados em `src/main/resources/application.properties`:
```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/forumhub
spring.datasource.username=seu_usuario
spring.datasource.password=sua_senha
api.security.token.secret=seu_segredo_jwt
```

3. Execute o projeto:
```bash
./mvnw spring-boot:run
```

O Flyway criará as tabelas automaticamente na primeira execução.

---

## 👨‍💻 Autor

Desenvolvido por **Luis Eduardo** como projeto final do programa **Oracle Next Education (ONE)** em parceria com a **Alura**.

---

*Programa Oracle Next Education — Trilha Back-End Java*
