#!/bin/bash

# heroisbackend
# ===================================
# API backend para gerenciamento de heróis, utilizando Spring Boot, JPA e banco de dados relacional.

# Link do frontend:
echo "Frontend disponível em: https://github.com/fravss/heroisfrontend"

# ===================================
# Pré-requisitos:
# - Java JDK 17 ou superior
# - Maven 3.x
# - Banco de dados MySQL

# ===================================
# 1. Clonar o repositório
echo "Clonando o repositório..."
git clone https://github.com/seuusuario/heroisbackend.git
cd heroisbackend || exit

# ===================================
# 2. Configuração do banco de dados
echo "Configure o arquivo src/main/resources/application.properties com suas credenciais:"
cat <<EOF > src/main/resources/application.properties
spring.datasource.url=jdbc:mysql://localhost:3306/seubanco
spring.datasource.username=seuusuario
spring.datasource.password=suasenha

# Porta da aplicação (opcional)
server.port=8080
EOF

echo "Arquivo application.properties criado! Edite com suas credenciais reais."

# ===================================
# 3. Rodando o projeto
echo "Rodando o projeto com Maven..."

# Compilar
mvn clean install

# Rodar aplicação
mvn spring-boot:run

# ===================================
# Acessar documentação Swagger (se configurado):
echo "Acesse http://localhost:8080/swagger-ui/index.html para ver a documentação da API (caso Swagger esteja configurado)"
