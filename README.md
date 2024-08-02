
# Best Petshop Finder

## Instruções para Executar o Sistema

1. **Clone o repositório:**
   ```sh
   git clone <URL_DO_REPOSITORIO>
   cd <NOME_DO_REPOSITORIO>
   ```

2. **Configure o ambiente:**
   - Certifique-se de ter o JDK 17 instalado.
   - Configure seu IDE para usar o JDK 17.

3. **Compile e execute o backend:**
   No terminal, navegue até o diretório do projeto e execute:
   
   (ou apenas execute o arquivo `PetshopApplication.java`)
   ```sh
   ./mvnw spring-boot:run
   ```

5. **Execute o frontend:**
   - Certifique-se de que você tenha um servidor HTTP simples (por exemplo, Live Server do VSCode) para servir os arquivos HTML.
   - Abra o arquivo `index.html` no navegador.

## Lista de Premissas Assumidas

- O sistema foi desenvolvido para rodar localmente.
- O banco de dados H2 é usado para simplificação durante o desenvolvimento e testes.
- A data deve ser fornecida no formato `dd/MM/yyyy`.
- Os valores de preços e distâncias dos petshops são assumidos como corretos e constantes.

## Decisões de Projeto

### Tecnologias Utilizadas
- Backend: Spring Boot, Spring Data JPA, H2 Database.
- Frontend: HTML, CSS, JavaScript.

### Estrutura do Projeto
- O projeto segue uma arquitetura de camadas (Controller, Service, Repository).
- O sistema de persistência utiliza JPA com o banco de dados H2 em memória.

### CORS
- Configurado para permitir requisições do frontend local.

### Validação de Data
- A data é validada no frontend para garantir que o ano possui 4 dígitos.

## O que Mais Você Achar Importante Compartilhar Sobre o Projeto

### Configuração CORS
- Configurado para permitir requisições de qualquer origem, facilitando o desenvolvimento local.

### Detalhes do Petshop
- Os preços dos petshops são diferentes durante os dias úteis e finais de semana.
- O algoritmo escolhe o petshop com o menor preço, priorizando a proximidade em caso de empate.

### Resiliência e Tratamento de Erros
- O frontend está preparado para lidar com erros de rede e exibir mensagens amigáveis aos usuários.

### Responsividade
- A interface foi estilizada para ser amigável e responsiva, garantindo uma boa experiência do usuário.
