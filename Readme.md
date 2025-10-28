## Projeto API de Palavras
___
#### ⚠️ Cada dupla deve criar uma branch e fazer seus commits dentro dela
#### ⚠️ Na branch da dupla deve ter um Readme com pelo menos os nomes dos integrantes da dupla e os endpoints criados
___

#### Sobre o Projeto

✔️ CRUD de Palavras 
    Apenas um atributo (termo, por exemplo)

✔️ CRUD de Etiquetas 
    Apenas um atributo (nome, por exemplo)

✔️ Relacionamento muitos-pra-muitos entre Etiqueta e Palavra

✔️ Busca de Palavras por Etiqueta

✔️ Busca de Etiquetas por Palavra

✔️ TDD (Opcional)

✔️ Segurança com JWT 
    Acesso admin para o CRUD completo 
    Acesso usuario apenas para leituras (o que inclui as listas)

✔️ O que mais a dupla desejar fazer

____

**⚠️ De tempos em tempos farei alguma alteração no Readme do projeto... ⚠️**

**Não deixem de atualizar sua branch**
____
#### Links úteis
- [Guia Mega Prático - Git](https://rogerdudler.github.io/git-guide/index.pt_BR.html)
- [Curso de Git Para Iniciantes - Youtube](https://www.youtube.com/watch?v=WVLhm1AMeYE&list=PLInBAd9OZCzzHBJjLFZzRl6DgUmOeG3H0)

#### COMANDO BANCO DOCKER
```bash
docker run --name postgres-api-palavras -e POSTGRES_DB=api_palavras -e POSTGRES_USER=postgres -e POSTGRES_PASSWORD=admin -p 5433:5432 -d postgres:latest
```