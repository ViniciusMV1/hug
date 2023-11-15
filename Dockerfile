# Use a imagem oficial do OpenJDK como base
FROM eclipse-temurin:20-jdk

# Variáveis de ambiente para o serviço
ENV APP_HOME=/app

# Copie todos os arquivos do seu projeto para a imagem Docker
COPY . ${APP_HOME}/

# Defina o diretório de trabalho
WORKDIR ${APP_HOME}

# Use o comando find para localizar o arquivo JAR
RUN find . -name '*.jar' -exec mv {} app.jar \;

# Exponha a porta padrão
EXPOSE 8080

# Comando de inicialização do aplicativo
CMD ["java", "-jar", "app.jar"]
