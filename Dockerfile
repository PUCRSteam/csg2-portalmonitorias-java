# Imagem base do OpenJDK como ponto de partida
FROM openjdk

# Diretório de trabalho dentro do contêiner
WORKDIR /app

# Copie o código-fonte da aplicação para o contêiner
COPY . .

# Copia o arquivo JAR do aplicativo para o contêiner
#COPY target/portal-de-monitorias-0.0.1-SNAPSHOT.jar aplicativo.jar

# Instalar o Maven para compilar o aplicativo
RUN apt-get update && apt-get install -y maven

# Compila o aplicativo
RUN mvn clean package

# Comando a ser executado quando o contêiner for iniciado
CMD [ "java", "-jar", "target/portal-de-monitorias-0.0.1-SNAPSHOT.jar" ]

# Comentário para testar que o Actions está disparando.


