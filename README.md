
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
- Explore a documentação Swagger para obter uma visão completa da API [aqui](https://github.com/FelipeAJdev/blog_pessoal-spring/blob/main/blogpessoal_swagger_docs/Projeto%20Blog%20Pessoal.pdf).

## 📚 Funcionalidades Principais

- **Gerenciamento de Livros:** Criação, atualização, listagem e exclusão de livros na loja.
- **Gerenciamento de Empréstimos:** Registro de empréstimos de livros, renovação e devolução.
- **Autenticação e Autorização:** Controle de acesso com base em JWT para proteger os endpoints da API.
- **Gerenciamento de Usuários:** Cadastro, login, atualização e remoção de usuários.

## 🔎 Diagrama de Classes

![Diagrama de Classes](https://www.planttext.com/api/plantuml/svg/jLD1JiCm4Bpd5JuQeNoW1rHGBqWz8D4-O6KlmSAnaRsMA8Y-7TknawP4HKXmIRAJyUpiPBFs18v2hnkXmNksmnxOHyDOovHaAxQrfikLH2-S4c0Z-4XE5VZLHe4E-qHLdjZneG37-FgQTKYtMlEhMjmTxYLFcb7z1DnKSJv8Jzq6KkgIdF5iZ-Abu64HbgYHCByPUtqsPS9gS75AKXJqsOY4RsHdY0I2T4Y0ta1if7eip6XZbJFCTV01d4fo--7fDvdiifKQo61iIgDEmSTnwfSOa_c9SZ6bOdWn96Dxd4Sq3Ne2UZJFC8UUBFtr_a0WD1HNnHNBlDotjbEcEil5S42014_k6xzIYom5qEhz0kiygjpYl-CY-u9cWgA7lFfjUpFkTLETpi0r6fd-yYy0)

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

Este projeto foi desenvolvido como parte do aprendizado contínuo em desenvolvimento Java e Spring Boot. A
"""

# Save this content to a README.md file
file_path = '/mnt/data/README.md'

with open(file_path, 'w') as file:
    file.write(readme_content)

file_path
