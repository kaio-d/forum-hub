
# ForumHub

Projeto consiste na criação de uma API Rest utilizando a linguagem de programação Java e o Spring Frameworl, nosso projeto consiste na simulação de um Fórum, na qual foi implmentadas algumas funcionalidades de autenticação via token JWT, buscar por determinado tópicos, criação de tópicos e exclusão do mesmo.
Para exemplos de funcionalidade foi utilizado o postman.

<div align="center">
    <img src="/imagens/Badge-Spring.png" alt="Badge do desafio">
</div>

## Stack utilizada

**Back-end:** Java, Spring boot

**Depedências:** Lombok
Spring Web,
Spring Boot DevTools,
Spring Data JPA,
Flyway Migration,
MySQL Driver,
Validation,
Spring Security,
swagger io


## Referência

- [Spring Initializr](https://start.spring.io/)
- [OpenAPI](https://springdoc.org/)



## 🧠 Exemplos

Listando todos os tópicos, utilizando a requisição GET, o campo tópico pode ser substituído por algum tópico que já exista, caso o mesmo não seja encontrado será disparado uma mensagem informando que não existe o ID informado.

```
http//localhost:8080/{topico}

```

Deletando os tópicos, utilizando o DELETE, para fins de teste onde está o ID deverá ser substituído pelo número do tópico que deseja deletar, caso o mesmo não exista será disparado uma exceção

```
http//localhost:8080/topicos/{id}
```

Atualizando os tópicos utilizando o PUT, para que a atualização ocorra deverá ser realizado junto com a requisição o corpo informando quais os dados que serão atualizados, por exemplo, no tópico de id 3 será atualizado o assunto do fórum.

```
http//localhost:8080/topicos/{id}

{
	"id": 1
	"título": Certificação Oracle
	"mensagem": "Como se preparar para o exame de certificação da Oracle"
}

Para a criação da data eu optei por utilizar o LocalDate.now(), toda vez que determinado assunto for modificado a data será atualizada sem o usuário se preocupar em preencher o campo.
```

**OBS:** A aplicação utiliza de Autenticação por meio de Tokens JWT, somente alguns usuários cadastrados no banco de dados podem realizar o processo de criar um novo tópico, e deletar o tópico criado pelo mesmo, usuários moderadores tem permição total, usuários que não possuem registro conseguem buscar e filtrar tópicos.



## ✨ Autores e Conclusão

- [@kaio-d](https://github.com/kaio-d)
- [@Gamma](https://gamma.app/)


Todas os recursos gerados no desenvolvimentos do projeto estarão separados em uma pasta, desde imagens até o banner utilizado na construção do artigo, o mesmo será públicado no meu Linkedin com as melhorias que eu realizei durante o desenvolvimento do projeto.
## 📝 Licença

[MIT](https://choosealicense.com/licenses/mit/)


[![MIT License](https://img.shields.io/badge/License-MIT-green.svg)](https://choosealicense.com/licenses/mit/)
[![GPLv3 License](https://img.shields.io/badge/License-GPL%20v3-yellow.svg)](https://opensource.org/licenses/)
[![AGPL License](https://img.shields.io/badge/license-AGPL-blue.svg)](http://www.gnu.org/licenses/agpl-3.0)

