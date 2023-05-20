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

| Campo | Tipo | Obrigatório | Descrição 
|-------|------|-------------|-----------
| nome | String | Sim | Aqui vai o nome do usuário
| email | String | Sim | Aqui vai o email do usuário
| senha | String | Sim | Aqui vai o senha do usuário
| data | LocalDate | Não | Aqui vai a data de nascimento do usuário
| foto | Foto | Não | Aqui vai a foto do perfil

### Cadastrar Usuário

`POST` /studit/api/usuario

**Exemplo de corpo do request**

```js

    {
        "nome": "Fulano de Tal",
        "email": "fulano@example.com",
        "senha": "senha123",
        "data": "1990-01-01",
        "foto": {
            "id": "1"
        }
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
        {
            "nome": "Fulano de Tal",
            "email": "fulano@example.com",
            "senha": "senha123",
            "data": "1990-01-01",
            "foto": {
                "id": "1",
                "url": "http://example.com/foto.jpg",
                "descricao": "Minha foto de perfil",
                "tamanho": 1024,
                "dataCriacao": "2023-04-06T10:00:00Z"
            },
            "id": "1"
        },
        {
            "nome": "Beltrano da Silva",
            "email": "beltrano@example.com",
            "senha": "senha456",
            "data": "1995-05-05",
            "foto": {
                "id": "2",
                "url": "http://example.com/foto2.jpg",
                "descricao": "Minha segunda foto de perfil",
                "tamanho": 2048,
                "dataCriacao": "2023-04-06T11:00:00Z"
            },
            "id": "2"
        }
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
        "nome": "Fulano de Tal",
        "email": "fulano@example.com",
        "senha": "senha123",
        "data": "1990-01-01",
        "foto": {
            "id": "1",
            "url": "http://example.com/foto.jpg",
            "descricao": "Minha foto de perfil",
            "tamanho": 1024,
            "dataCriacao": "2023-04-06T10:00:00Z"
        },
        "id": "1"
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
        "nome": "Beltrano de Tal",
        "email": "beltrano@example.com",
        "senha": "senha123",
        "data": "1995-05-05",
        "foto": {
            "id": "1"
        }
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
        "url": "http://example.com/foto.jpg",
        "descricao": "Minha foto de perfil",
        "tamanho": 1024,
        "dataCriacao": "2023-04-06T10:00:00Z"
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

    {
        {
            "id": "1",
            "url": "http://example.com/foto.jpg",
            "descricao": "Minha foto de perfil",
            "tamanho": 1024,
            "dataCriacao": "2023-04-06T10:00:00Z"
        },
        {
            "id": "2",
            "url": "http://example.com/foto2.jpg",
            "descricao": "Minha segunda foto de perfil",
            "tamanho": 2048,
            "dataCriacao": "2023-04-06T11:00:00Z"
        }
    }

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
        "id": "1",
        "url": "http://example.com/foto.jpg",
        "descricao": "Minha foto de perfil",
        "tamanho": 1024,
        "dataCriacao": "2023-04-06T10:00:00Z"
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
        "url": "http://example.com/foto.jpg",
        "descricao": "Minha foto de perfil atualizada",
        "tamanho": 2048,
        "dataCriacao": "2023-04-06T10:00:00Z"
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
        "titulo": "Título do resumo",
        "conteudo": "Conteúdo do resumo",
        "dataCriacao": "2023-04-07T10:00:00",
        "materia": "MATEMATICA"
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
        {        
            "id": 1,        
            "titulo": "Título do resumo 1",        
            "conteudo": "Conteúdo do resumo 1",        
            "dataCriacao": "2023-04-07T10:00:00",        
            "materia": "MATEMATICA"    
        },    
        {        
            "id": 2,        
            "titulo": "Título do resumo 2",        
            "conteudo": "Conteúdo do resumo 2",        
            "dataCriacao": "2023-04-08T14:00:00",        
            "materia": "PORTUGUES"    
        }
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
        "id": 1,        
        "titulo": "Título do resumo 1",        
        "conteudo": "Conteúdo do resumo 1",        
        "dataCriacao": "2023-04-07T10:00:00",        
        "materia": "MATEMATICA"    
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
        "titulo": "Título do resumo 1",
        "conteudo": "Novo conteúdo do resumo 1",
        "dataCriacao": "2023-04-07T10:00:00",
        "materia": "MATEMATICA"
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
        "pergunta": "Qual é a capital do Brasil?",
        "alternativaA": "São Paulo",
        "alternativaB": "Rio de Janeiro",
        "alternativaC": "Brasília",
        "alternativaD": "Belo Horizonte",
        "resposta": "C",
        "resolucao": "Em 1956, o então presidente Juscelino Kubitschek lançou o plano de construir uma nova capital para o Brasil, no centro do país, e em 21 de abril de 1960, Brasília foi oficialmente inaugurada como a nova capital do Brasil. A cidade foi projetada pelo arquiteto Oscar Niemeyer e pelo urbanista Lúcio Costa, e sua construção foi concluída em tempo recorde de apenas quatro anos. Desde então, Brasília tem sido a sede do governo federal e a capital do Brasil.",
        "resumo": {
            "id":"1"
        },
        "materia": "GEOGRAFIA"
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
        {   
            "id":"1",
            "pergunta": "Qual é a capital do Brasil?",
            "alternativaA": "São Paulo",
            "alternativaB": "Rio de Janeiro",
            "alternativaC": "Brasília",
            "alternativaD": "Belo Horizonte",
            "resposta": "C",
            "resolucao": "Em 1956, o então presidente Juscelino Kubitschek lançou o plano de construir uma nova capital para o Brasil, no centro do país, e em 21 de abril de 1960, Brasília foi oficialmente inaugurada como a nova capital do Brasil. A cidade foi projetada pelo arquiteto Oscar Niemeyer e pelo urbanista Lúcio Costa, e sua construção foi concluída em tempo recorde de apenas quatro anos. Desde então, Brasília tem sido a sede do governo federal e a capital do Brasil.",
            "resumo":{        
                "id": 1,        
                "titulo": "Título do resumo 1",        
                "conteudo": "Conteúdo do resumo 1",        
                "dataCriacao": "2023-04-07T10:00:00",        
                "materia": "GEOGRAFIA"    
            },
            "materia": "GEOGRAFIA"
        },
        {
            "id":"2",
            "pergunta": "Qual é a fórmula da água?",
            "alternativaA": "H2O",
            "alternativaB": "CO2",
            "alternativaC": "NO2",
            "alternativaD": "NaCl",
            "resposta": "A",
            "resolucao": "A fórmula da água é H2O, o que significa que uma molécula de água é composta por dois átomos de hidrogênio (H) e um átomo de oxigênio (O). Essa fórmula química representa a proporção dos átomos na molécula de água. A ligação química entre os átomos ocorre por meio de ligações covalentes, em que os átomos compartilham elétrons. A água é uma substância essencial para a vida, e suas propriedades únicas são devidas às ligações de hidrogênio entre as moléculas de água, que resultam em uma estrutura molecular tetraédrica e em propriedades como alta tensão superficial e ponto de fusão e ebulição elevados.",
            "resumo":{        
                "id": 1,        
                "titulo": "Título do resumo 1",        
                "conteudo": "Conteúdo do resumo 1",        
                "dataCriacao": "2023-04-07T10:00:00",        
                "materia": "QUIMICA"    
            },
            "materia": "QUIMICA"
        }
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
        "id":"1",
        "pergunta": "Qual é a capital do Brasil?",
        "alternativaA": "São Paulo",
        "alternativaB": "Rio de Janeiro",
        "alternativaC": "Brasília",
        "alternativaD": "Belo Horizonte",
        "resposta": "C",
        "resolucao": "Em 1956, o então presidente Juscelino Kubitschek lançou o plano de construir uma nova capital para o Brasil, no centro do país, e em 21 de abril de 1960, Brasília foi oficialmente inaugurada como a nova capital do Brasil. A cidade foi projetada pelo arquiteto Oscar Niemeyer e pelo urbanista Lúcio Costa, e sua construção foi concluída em tempo recorde de apenas quatro anos. Desde então, Brasília tem sido a sede do governo federal e a capital do Brasil.",
        "resumo":{        
            "id": 1,        
            "titulo": "Título do resumo 1",        
            "conteudo": "Conteúdo do resumo 1",        
            "dataCriacao": "2023-04-07T10:00:00",        
            "materia": "GEOGRAFIA"    
        },
        "materia": "GEOGRAFIA"
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
        "id":"1",
        "pergunta": "Qual foi a primeira capital do Brasil?",
        "alternativaA": "Salvador",
        "alternativaB": "Rio de Janeiro",
        "alternativaC": "Brasília",
        "alternativaD": "Belo Horizonte",
        "resposta": "A",
        "resolucao": "A primeira capital do Brasil foi a cidade de Salvador, localizada no estado da Bahia. Salvador foi fundada pelos portugueses em 1549, e se tornou a capital da colônia portuguesa no Brasil. Durante a época colonial, Salvador foi um importante centro administrativo, econômico e cultural, e sua influência pode ser vista até hoje na arquitetura, gastronomia e tradições da região. A capital do Brasil foi transferida para o Rio de Janeiro em 1763, durante o período colonial, e posteriormente para Brasília em 1960, após a construção da nova capital federal.",
        "resumo":{        
            "id": 1,        
            "titulo": "Título do resumo 1",        
            "conteudo": "Conteúdo do resumo 1",        
            "dataCriacao": "2023-04-07T10:00:00",        
            "materia": "GEOGRAFIA"    
        },
        "materia": "GEOGRAFIA"
    }

```

**Códigos de Resposta**

| Código | Descrição
|--------|-----------
| 201 | Exercício atualizado com sucesso
| 400 | Erro na validação dos dados da requisição

---
