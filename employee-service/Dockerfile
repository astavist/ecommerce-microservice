# Base image olarak openjdk kullanıyoruz
FROM openjdk:21

# Çalışma dizinini oluşturuyoruz
WORKDIR /app

# Maven build sonucu oluşan jar dosyasını çalışma dizinine kopyalıyoruz
COPY target/employee-service-0.0.1-SNAPSHOT.jar app.jar

# Kapsayıcı çalıştığında jar dosyasını çalıştırıyoruz
ENTRYPOINT ["java", "-jar", "app.jar"]
