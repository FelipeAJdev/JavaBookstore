
<div align="center">
  
# JavaBookStore - API Restful com Spring Boot

</div>

<div align="center">
    <img src="https://i.imgur.com/w8tTOuT.png" title="JavaBookStore Logo" />
</div>

## 💻 Tecnologias Utilizadas

- **Frameworks:** Spring Boot, Hibernate, JPA, Spring Security, JUnit.
- **Persistência de Dados:** MySQL para desenvolvimento, PostgreSQL para produção (Render).
- **Transmissão de Dados:** JSON padrão na API.
- **Arquitetura:** Padrão MVC.
- **Segurança:** Autenticação e Autorização com Spring Security e JWT.
- **Testes:** Testes unitários utilizando JUnit.
- **Dependências Principais:** Spring Web, Spring Boot Devtools, Spring Data JPA, MySQL Driver, JWT, JUnit, H2 Database, Spring Doc, PostgreSQL.
- **Documentação API:** Swagger UI para visualização dos endpoints.

## 📋 Explore a Documentação Swagger

- A documentação fornece informações detalhadas sobre os endpoints, modelos de dados e como interagir com a API.
- Explore a documentação Swagger para obter uma visão completa da API [aqui](https://github.com/FelipeAJdev/JavaBookstore/).

## 📚 Funcionalidades Principais

- **Gerenciamento de Livros:** Criação, atualização, listagem e exclusão de livros na loja.
- **Gerenciamento de Empréstimos:** Registro de empréstimos de livros, renovação e devolução.
- **Autenticação e Autorização:** Controle de acesso com base em JWT para proteger os endpoints da API.
- **Gerenciamento de Usuários:** Cadastro, login, atualização e remoção de usuários.

## 🚀 Executando o Projeto

### Pré-requisitos

- **Java 11** ou superior
- **Maven 3.6.3** ou superior
- **MySQL** ou **PostgreSQL** para o banco de dados

### Passos para Executar

1. Clone o repositório:
   \`\`\`bash
   git clone https://github.com/username/javabookstore.git
   \`\`\`
2. Navegue até o diretório do projeto:
   \`\`\`bash
   cd javabookstore
   \`\`\`
3. Configure o banco de dados no arquivo \`application.properties\` ou \`application.yml\`.
4. Execute o projeto:
   \`\`\`bash
   mvn spring-boot:run
   \`\`\`
5. Acesse a documentação Swagger em:
   \`\`\`
   http://localhost:8080/swagger-ui.html
   \`\`\`

## 🌐 Deploy

- A aplicação pode ser implantada em qualquer serviço de nuvem que suporte Java, como AWS, Heroku, ou Vercel.
- Para PostgreSQL em produção, você pode utilizar serviços como Render para hospedar o banco de dados.

## 🛠 Estrutura do Projeto

- **\`/src/main/java\`**: Contém a lógica de negócio, controladores, modelos e repositórios.
- **\`/src/main/resources\`**: Contém arquivos de configuração, como \`application.properties\`.
- **\`/src/test/java\`**: Contém testes unitários escritos com JUnit.

## 🤝 Agradecimentos

Este projeto foi desenvolvido como parte do aprendizado contínuo em desenvolvimento Java e Spring Boot.
