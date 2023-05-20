# StudIt

Uma api para o projeto StudIt onde geramos material de estudo para alunos de escola sob demanda.

## Endpoints

- [Usuários](#usuários)
    - [Cadastrar](#cadastrar-usuário)
    - [Listar todos](#listar-usuários)
    - [Mostrar detalhes](#listar-usuário)
    - [Apagar](#apagar-usuário)
    - [Alterar](#atualizar-usuário)
- [Foto](#foto)
    - [Cadastrar](#cadastrar-foto)
    - [Listar todos](#listar-fotos)
    - [Mostrar detalhes](#listar-foto)
    - [Apagar](#apagar-foto)
    - [Alterar](#atualizar-foto)
- [Resumo](#resumo)
    - [Cadastrar](#cadastrar-resumo)
    - [Listar todos](#listar-resumos)
    - [Mostrar detalhes](#listar-resumo)
    - [Apagar](#apagar-resumo)
    - [Alterar](#atualizar-resumo)
- [Exercício](#exercício)
    - [Cadastrar](#cadastrar-exercício)
    - [Listar todos](#listar-exerícios)
    - [Mostrar detalhes](#listar-exercício)
    - [Apagar](#apagar-exercício)
    - [Alterar](#atualizar-exercício)
    
---

## Usuários

| Campo | Tipo          | Obrigatório | Descrição 
|-------|---------------|-------------|-----------
| nome | String        | Sim | Aqui vai o nome do usuário
| email | String        | Sim | Aqui vai o email do usuário
| senha | String        | Sim | Aqui vai o senha do usuário
| data | LocalDateTime | Não | Aqui vai a data de nascimento do usuário
| foto | List<Foto>    | Não | Aqui vai a foto do perfil

### Cadastrar Usuário

`POST` /studit/api/usuario

**Exemplo de corpo do request**

```js

    {
      "nome": "Carlos Santos",
      "email": "carlos.santos@example.com",
      "senha": "senha321",
      "dataNascimento": "1995-06-25T11:30:00"
    }


```

**Códigos de Repsosta**

| Código | Descrição
|--------|-----------
| 201 | Usuário cadastrada com sucesso
| 400 | Erro na validação dos dados da requisição

---

### Listar Usuários

`GET` /studit/api/usuario

```js

    {
        "content": [
            {
                "id": 22,
                "nome": "Pedro Souza",
                "email": "pedro.souza@example.com",
                "senha": "senha789",
                "dataNascimento": "1985-12-10T08:45:00"
            },
            {
                "id": 21,
                "nome": "Maria Santos",
                "email": "maria.santos@example.com",
                "senha": "senha456",
                "dataNascimento": "1990-05-15T14:30:00"
            },
            {
                "id": 24,
                "nome": "Carlos Santos",
                "email": "carlos.santos@example.com",
                "senha": "senha321",
                "dataNascimento": "1995-06-25T11:30:00"
            },
            {
                "id": 23,
                "nome": "Ana Oliveira",
                "email": "ana.oliveira@example.com",
                "senha": "senha987",
                "dataNascimento": "1998-09-20T09:15:00"
            },
            {
                "id": 2,
                "nome": "João Silva",
                "email": "joao.silva@example.com",
                "senha": "senha123",
                "dataNascimento": "2022-01-01T10:00:00"
            },
            {
                "id": 1,
                "nome": "João Silva",
                "email": "joao.silva@example.com",
                "senha": "senha123",
                "dataNascimento": "2022-01-01T10:00:00"
            }
        ],
        "pageable": {
            "sort": {
                "empty": false,
                "sorted": true,
                "unsorted": false
            },
            "offset": 0,
            "pageSize": 10,
            "pageNumber": 0,
            "unpaged": false,
            "paged": true
        },
        "totalElements": 6,
        "totalPages": 1,
        "last": true,
        "size": 10,
        "number": 0,
        "sort": {
            "empty": false,
            "sorted": true,
            "unsorted": false
        },
        "numberOfElements": 6,
        "first": true,
        "empty": false
    }

```

**Códigos de Resposta**

| Código | Descrição
|--------|-----------
| 200 | Dados retornados no corpo da resposta
| 404 | Dados não encontrado

---

### Listar Usuário

`GET` /studit/api/usuario/{id}

```js

    {
        "id": 1,
        "nome": "João Silva",
        "email": "joao.silva@example.com",
        "senha": "senha123",
        "dataNascimento": "2022-01-01T10:00:00"
    }

```

**Códigos de Resposta**

| Código | Descrição
|--------|-----------
| 200 | Dados retornados no corpo da resposta
| 404 | Dados não encontrado

---

### Apagar Usuário

`DELETE` /studit/api/usuario/{id}

**Códigos de Resposta**

| Código | Descrição
|--------|-----------
| 202 | Usuário apagado com sucesso
| 404 | Usuário não encontrado

---

### Atualizar Usuário

`PUT` /studit/api/usuario/{id}

```js

    {
        "email": "beltrano@example.com"
    }

```

**Códigos de Resposta**

| Código | Descrição
|--------|-----------
| 201 | Usuário atualizado com sucesso
| 400 | Erro na validação dos dados da requisição

---

## Foto

| Campo | Tipo | Obrigatório | Descrição 
|-------|------|-------------|-----------
| url | String | Sim | Aqui vai a url da foto
| descricao | String | Não | Aqui vai a descrição da foto
| tamanhoBytes | int | Sim | Aqui vai o tamanho em bytes da foto
| dataCriacao | LocalDateTime | Sim | Aqui vai a data criação da foto

### Cadastrar Foto

`POST` /studit/api/foto

**Exemplo de corpo do request**

```js

    {
      "url": "https://example.com/foto5.jpg",
      "descricao": "Foto de comida",
      "tamanhoBytes": 5120,
      "dataCriacao": "2023-05-20T18:30:00",
      "usuario": {
        "id": 24
      }
    }


```

**Códigos de Repsosta**

| Código | Descrição
|--------|-----------
| 201 | Foto cadastrada com sucesso
| 400 | Erro na validação dos dados da requisição

---

### Listar Fotos

`GET` /studit/api/foto

```js

    [
        {
            "id": 21,
            "url": "https://example.com/foto1.jpg",
            "descricao": "Foto de paisagem",
            "tamanhoBytes": 1024,
            "dataCriacao": "2023-05-20T15:30:00",
            "usuario": {
                "id": 1,
                "nome": "João Silva",
                "email": "joao.silva@example.com",
                "senha": "senha123",
                "dataNascimento": "2022-01-01T10:00:00"
            }
        },
        {
            "id": 22,
            "url": "https://example.com/foto2.jpg",
            "descricao": "Retrato em preto e branco",
            "tamanhoBytes": 2048,
            "dataCriacao": "2023-05-20T16:45:00",
            "usuario": {
                "id": 21,
                "nome": "Maria Santos",
                "email": "maria.santos@example.com",
                "senha": "senha456",
                "dataNascimento": "1990-05-15T14:30:00"
            }
        },
        {
            "id": 23,
            "url": "https://example.com/foto3.jpg",
            "descricao": "Foto de arquitetura",
            "tamanhoBytes": 3072,
            "dataCriacao": "2023-05-20T17:15:00",
            "usuario": {
                "id": 22,
                "nome": "Pedro Souza",
                "email": "pedro.souza@example.com",
                "senha": "senha789",
                "dataNascimento": "1985-12-10T08:45:00"
            }
        },
        {
            "id": 24,
            "url": "https://example.com/foto4.jpg",
            "descricao": "Foto de animais",
            "tamanhoBytes": 4096,
            "dataCriacao": "2023-05-20T18:00:00",
            "usuario": {
                "id": 23,
                "nome": "Ana Oliveira",
                "email": "ana.oliveira@example.com",
                "senha": "senha987",
                "dataNascimento": "1998-09-20T09:15:00"
            }
        },
        {
            "id": 25,
            "url": "https://example.com/foto5.jpg",
            "descricao": "Foto de comida",
            "tamanhoBytes": 5120,
            "dataCriacao": "2023-05-20T18:30:00",
            "usuario": {
                "id": 24,
                "nome": "Carlos Santos",
                "email": "carlos.santos@example.com",
                "senha": "senha321",
                "dataNascimento": "1995-06-25T11:30:00"
            }
        },
        {
            "id": 1,
            "url": "https://example.com/image.jpg",
            "descricao": "Foto de paisagem",
            "tamanhoBytes": 1024,
            "dataCriacao": "2022-01-01T15:00:00",
            "usuario": {
                "id": 1,
                "nome": "João Silva",
                "email": "joao.silva@example.com",
                "senha": "senha123",
                "dataNascimento": "2022-01-01T10:00:00"
            }
        }
    ]

```

**Códigos de Resposta**

| Código | Descrição
|--------|-----------
| 200 | Dados retornados no corpo da resposta
| 404 | Dados não encontrado

---

### Listar Foto

`GET` /studit/api/foto/{id}

```js

    {
        "id": 1,
        "url": "https://example.com/image.jpg",
        "descricao": "Foto de paisagem",
        "tamanhoBytes": 1024,
        "dataCriacao": "2022-01-01T15:00:00",
        "usuario": {
            "id": 1,
            "nome": "João Silva",
            "email": "joao.silva@example.com",
            "senha": "senha123",
            "dataNascimento": "2022-01-01T10:00:00"
        }
    }

```

**Códigos de Resposta**

| Código | Descrição
|--------|-----------
| 200 | Dados retornados no corpo da resposta
| 404 | Dados não encontrado

---

### Apagar Foto

`DELETE` /studit/api/foto/{id}

**Códigos de Resposta**

| Código | Descrição
|--------|-----------
| 202 | Foto apagada com sucesso
| 404 | Foto não encontrado

---

### Atualizar Foto

`PUT` /studit/api/foto/{id}

```js

    {
        "tamanhoBytes": 2048
    }

```

**Códigos de Resposta**

| Código | Descrição
|--------|-----------
| 201 | Foto atualizada com sucesso
| 400 | Erro na validação dos dados da requisição

---

## Resumo

| Campo | Tipo | Obrigatório | Descrição 
|-------|------|-------------|-----------
| titulo | String | Sim | Aqui vai o título do resumo
| conteudo | String | Sim | Aqui vai o conteúdo do resumo
| dataCriacao | LocalDateTime | Sim | Aqui vai a data de criação do resumo
| materia | Materia | Sim | Aqui vai matéria que vai para o resumo

### Cadastrar Resumo

`POST` /studit/api/resumo

**Exemplo de corpo do request**

```js

    {
        "conteudo": "A mudança da capital do Brasil para Brasília está relacionada a uma série de fatores históricos, políticos e geográficos.",
        "dataCriacao": "2022-01-01T14:30:00",
        "materiaEnum": "Geografia",
        "usuario": {
            "id": 1
        }
    }

```

**Códigos de Repsosta**

| Código | Descrição
|--------|-----------
| 201 | Resumo cadastrada com sucesso
| 400 | Erro na validação dos dados da requisição

---

### Listar Resumos

`GET` /studit/api/resumo

```js

    {
        "content": [
            {
                "id": 1,
                "conteudo": "A mudança da capital do Brasil para Brasília está relacionada a uma série de fatores históricos, políticos e geográficos.",
                "dataCriacao": "2022-01-01T14:30:00",
                "materiaEnum": "Geografia",
                "usuario": {
                    "id": 1,
                    "nome": "João Silva",
                    "email": "joao.silva@example.com",
                    "senha": "senha123",
                    "dataNascimento": "2022-01-01T10:00:00"
                }
            },
            {
                "id": 21,
                "conteudo": "A independência do Brasil ocorreu em 1822, quando Dom Pedro proclamou a separação de Portugal. Dizenda a iconica frase 'Diga ao povo que fico'.",
                "dataCriacao": "2022-02-15T09:45:00",
                "materiaEnum": "Historia",
                "usuario": {
                    "id": 2,
                    "nome": "João Silva",
                    "email": "jf.silva@example.com",
                    "senha": "senha753",
                    "dataNascimento": "2002-01-01T10:00:00"
                }
            },
            {
                "id": 22,
                "conteudo": "A Lei da Gravidade, formulada por Isaac Newton, descreve a força de atração entre corpos massivos.",
                "dataCriacao": "2022-03-10T16:20:00",
                "materiaEnum": "Fisica",
                "usuario": {
                    "id": 21,
                    "nome": "Maria Santos",
                    "email": "maria.santos@example.com",
                    "senha": "senha456",
                    "dataNascimento": "1990-05-15T14:30:00"
                }
            },
            {
                "id": 23,
                "conteudo": "A Revolução Industrial teve início na Inglaterra durante o século XVIII e trouxe grandes transformações sociais e econômicas.",
                "dataCriacao": "2022-04-20T11:00:00",
                "materiaEnum": "Historia",
                "usuario": {
                    "id": 23,
                    "nome": "Ana Oliveira",
                    "email": "ana.oliveira@example.com",
                    "senha": "senha987",
                    "dataNascimento": "1998-09-20T09:15:00"
                }
            },
            {
                "id": 24,
                "conteudo": "A célula é a menor unidade estrutural e funcional dos seres vivos.",
                "dataCriacao": "2022-05-05T14:15:00",
                "materiaEnum": "Biologia",
                "usuario": {
                    "id": 22,
                    "nome": "Pedro Souza",
                    "email": "pedro.souza@example.com",
                    "senha": "senha789",
                    "dataNascimento": "1985-12-10T08:45:00"
                }
            }
        ],
        "pageable": {
            "sort": {
                "empty": false,
                "sorted": true,
                "unsorted": false
            },
            "offset": 0,
            "pageSize": 5,
            "pageNumber": 0,
            "unpaged": false,
            "paged": true
        },
        "last": false,
        "totalElements": 7,
        "totalPages": 2,
        "size": 5,
        "number": 0,
        "sort": {
            "empty": false,
            "sorted": true,
            "unsorted": false
        },
        "first": true,
        "numberOfElements": 5,
        "empty": false
    }

```

**Códigos de Resposta**

| Código | Descrição
|--------|-----------
| 200 | Dados retornados no corpo da resposta
| 404 | Dados não encontrado

---

### Listar Resumo

`GET` /studit/api/resumo/{id}

```js

    {
        "id": 23,
        "conteudo": "A Revolução Industrial teve início na Inglaterra durante o século XVIII e trouxe grandes transformações sociais e econômicas.",
        "dataCriacao": "2022-04-20T11:00:00",
        "materiaEnum": "Historia",
        "usuario": {
            "id": 23,
            "nome": "Ana Oliveira",
            "email": "ana.oliveira@example.com",
            "senha": "senha987",
            "dataNascimento": "1998-09-20T09:15:00"
        }
}

```

**Códigos de Resposta**

| Código | Descrição
|--------|-----------
| 200 | Dados retornados no corpo da resposta
| 404 | Dados não encontrado

---

### Apagar Resumo

`DELETE` /studit/api/resumo/{id}

**Códigos de Resposta**

| Código | Descrição
|--------|-----------
| 202 | Resumo apagado com sucesso
| 404 | Resumo não encontrado

---

### Atualizar Resumo

`PUT` /studit/api/resumo/{id}

```js

    {
        "dataCriacao": "2023-04-07T10:00:00"
    }


```

**Códigos de Resposta**

| Código | Descrição
|--------|-----------
| 201 | Resumo atualizado com sucesso
| 400 | Erro na validação dos dados da requisição

---

## Exercício

| Campo | Tipo | Obrigatório | Descrição 
|-------|------|-------------|-----------
| pergunta | String | Sim | Aqui vai a pergunta do exercício
| alternativaA | String | Sim | Aqui vai a Alternativa 'A' do exercício
| alternativaB | String | Sim | Aqui vai a Alternativa 'B' do exercício
| alternativaC | String | Sim | Aqui vai a Alternativa 'C' do exercício
| alternativaD | String | Sim | Aqui vai a Alternativa 'D' do exercício
| resposta | String | Sim | Aqui vai a resposta do exercício
| resolucao | Stirng | Sim | Aqui vai a solução do exercíco
| resumo | Resumo | Não | Aqui vai o resumo do conteúdo do exercício
| materia | Materia | Sim | Aqui vai a matéria do exercício

### Cadastrar Exercício

`POST` /studit/api/exercicio

**Exemplo de corpo do request**

```js

    {    
        "pergunta": "Qual é o resultado da seguinte equação: 8 + 22 * 0?",
        "alternativas": [
            "4",
            "6",
            "8",
            "10"
        ],
        "resposta": "8",
        "resolucao": "A resposta correta é 8. A multiplicação tem precedência sobre a adição na ordem de operações.",
        "materiaEnum": "Matematica",
        "usuario": {
            "id": 1
        }
    }


```

**Códigos de Repsosta**

| Código | Descrição
|--------|-----------
| 201 | Usuário cadastrada com sucesso
| 400 | Erro na validação dos dados da requisição

---

### Listar Exerícios

`GET` /studit/api/exercicio

```js
    {
        "content": [
            {
                "id": 1,
                "pergunta": "Qual é a capital do Brasil?",
                "alternativas": [
                    "Rio de Janeiro",
                    "São Paulo",
                    "Brasília",
                    "Salvador",
                    "Curitiba"
                ],
                "resposta": "Brasília",
                "resolucao": "A resposta correta é Brasília, que é a capital do Brasil.",
                "materiaEnum": "Geografia",
                "usuario": {
                    "id": 1,
                    "nome": "João Silva",
                    "email": "joao.silva@example.com",
                    "senha": "senha123",
                    "dataNascimento": "2022-01-01T10:00:00"
                }
            },
            {
                "id": 2,
                "pergunta": "Qual é a capital da França?",
                "alternativas": [
                    "Paris",
                    "Londres",
                    "Berlim",
                    "Roma",
                    "Madri"
                ],
                "resposta": "Paris",
                "resolucao": "A resposta correta é Paris, que é a capital da França.",
                "materiaEnum": "Geografia",
                "usuario": {
                    "id": 1,
                    "nome": "João Silva",
                    "email": "joao.silva@example.com",
                    "senha": "senha123",
                    "dataNascimento": "2022-01-01T10:00:00"
                }
            },
            {
                "id": 3,
                "pergunta": "Qual é o resultado da seguinte equação: 8 + 22 * 0?",
                "alternativas": [
                    "4",
                    "6",
                    "8",
                    "10"
                ],
                "resposta": "8",
                "resolucao": "A resposta correta é 8. A multiplicação tem precedência sobre a adição na ordem de operações.",
                "materiaEnum": "Matematica",
                "usuario": {
                    "id": 1,
                    "nome": "João Silva",
                    "email": "joao.silva@example.com",
                    "senha": "senha123",
                    "dataNascimento": "2022-01-01T10:00:00"
                }
            },
            {
                "id": 21,
                "pergunta": "Qual é o principal gás constituinte da atmosfera terrestre?",
                "alternativas": [
                    "Nitrogênio",
                    "Oxigênio",
                    "Dióxido de carbono",
                    "Hidrogênio"
                ],
                "resposta": "Nitrogênio",
                "resolucao": "O nitrogênio é o gás mais abundante na atmosfera terrestre, compreendendo cerca de 78% do volume total.",
                "materiaEnum": "Quimica",
                "usuario": {
                    "id": 21,
                    "nome": "Maria Santos",
                    "email": "maria.santos@example.com",
                    "senha": "senha456",
                    "dataNascimento": "1990-05-15T14:30:00"
                }
            },
            {
                "id": 22,
                "pergunta": "Quem foi o primeiro presidente do Brasil?",
                "alternativas": [
                    "Getúlio Vargas",
                    "Juscelino Kubitschek",
                    "Fernando Henrique Cardoso",
                    "Deodoro da Fonseca"
                ],
                "resposta": "Deodoro da Fonseca",
                "resolucao": "Deodoro da Fonseca foi o primeiro presidente do Brasil, assumindo o cargo em 1889.",
                "materiaEnum": "Historia",
                "usuario": {
                    "id": 23,
                    "nome": "Ana Oliveira",
                    "email": "ana.oliveira@example.com",
                    "senha": "senha987",
                    "dataNascimento": "1998-09-20T09:15:00"
                }
            }
        ],
        "pageable": {
            "sort": {
                "empty": false,
                "sorted": true,
                "unsorted": false
            },
            "offset": 0,
            "pageSize": 5,
            "pageNumber": 0,
            "unpaged": false,
            "paged": true
        },
        "last": false,
        "totalElements": 11,
        "totalPages": 3,
        "size": 5,
        "number": 0,
        "sort": {
            "empty": false,
            "sorted": true,
            "unsorted": false
        },
        "first": true,
        "numberOfElements": 5,
        "empty": false
    }

```

**Códigos de Resposta**

| Código | Descrição
|--------|-----------
| 200 | Dados retornados no corpo da resposta
| 404 | Dados não encontrado

---

### Listar Exercício

`GET` /studit/api/exercicio/{id}

```js

    {
        "id": 3,
        "pergunta": "Qual é o resultado da seguinte equação: 8 + 22 * 0?",
        "alternativas": [
            "4",
            "6",
            "8",
            "10"
        ],
        "resposta": "8",
        "resolucao": "A resposta correta é 8. A multiplicação tem precedência sobre a adição na ordem de operações.",
        "materiaEnum": "Matematica",
        "usuario": {
            "id": 1,
            "nome": "João Silva",
            "email": "joao.silva@example.com",
            "senha": "senha123",
            "dataNascimento": "2022-01-01T10:00:00"
        }
    }

```

**Códigos de Resposta**

| Código | Descrição
|--------|-----------
| 200 | Dados retornados no corpo da resposta
| 404 | Dados não encontrado

---

### Apagar Exercício

`DELETE` /studit/api/exercicio/{id}

**Códigos de Resposta**

| Código | Descrição
|--------|-----------
| 202 | Exercício apagado com sucesso
| 404 | Exercício não encontrado

---

### Atualizar Exercício

`PUT` /studit/api/exercicio/{id}
```js

    {   
        "pergunta": "Qual é o resultado da seguinte equação: 2 + 2 * 3?"
    }

```

**Códigos de Resposta**

| Código | Descrição
|--------|-----------
| 201 | Exercício atualizado com sucesso
| 400 | Erro na validação dos dados da requisição

---
