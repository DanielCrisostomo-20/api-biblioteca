# API de Biblioteca — IFPI

API REST desenvolvida com Spring Boot, Spring Data JPA e banco H2 em arquivo.

## Requisitos

- Java 21
- Maven

## Como executar

Na pasta raiz do projeto, execute:

```bash
mvn spring-boot:run
```

A API ficará disponível em `http://localhost:8080`.

## Endpoints

| Método | Endereço | Função |
|---|---|---|
| POST | `/livros` | Cadastrar um livro |
| GET | `/livros` | Listar todos os livros |
| GET | `/livros/{id}` | Buscar um livro pelo ID |
| GET | `/livros/disponiveis` | Listar livros disponíveis (extra) |

## Exemplo de cadastro

Envie um POST para `http://localhost:8080/livros`, com o cabeçalho `Content-Type: application/json` e o corpo:

```json
{
  "titulo": "Dom Casmurro",
  "autor": "Machado de Assis",
  "anoPublicacao": 1899,
  "disponivel": true
}
```

Não informe o campo `id`: ele é gerado automaticamente.

## Banco H2

O banco é salvo na pasta `data`, com o nome `bibliotecadb`. A configuração `jdbc:h2:file:./data/bibliotecadb` permite manter os dados depois de encerrar e iniciar a aplicação novamente.

Console H2: `http://localhost:8080/h2-console`

- JDBC URL: `jdbc:h2:file:./data/bibliotecadb`
- User Name: `sa`
- Password: deixe em branco

## Testes necessários para a entrega

1. Inicie a aplicação.
2. Cadastre três livros usando POST.
3. Consulte `GET /livros` e `GET /livros/1` (ajuste o ID se necessário).
4. Consulte um ID inexistente, por exemplo `GET /livros/9999`, e verifique o status 404.
5. Opcional: consulte `GET /livros/disponiveis`.
6. Encerre a aplicação e inicie novamente.
7. Consulte `GET /livros` e confirme que os livros continuam salvos.

> Antes de entregar, tire as capturas de tela dos testes e do console H2. Não envie a pasta `target`.
