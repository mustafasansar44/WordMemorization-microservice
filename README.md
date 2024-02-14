### Yapılan işlemler

- [x] EurekaServer implementasyonu
- [x] Gateway Server implementasyonu

### Yapılacak işlemler

- [] servislerin ip'leri random tanımlansın.
- [] Gateway Server implementasyonu
- [] pom.xml'leri düzenle
- [] lombok yerine kotlin ya da başka bir şey kullan. dto sınıflarını record'a çevir.
- [] neden vault kullandım readme.md'de tanımını yap
- [] global application.properties oluştur.

## Portlar
Eureka-Server : 8761
Gateway-Server : 1500
User-Service : 1300
Wordgroup-Service : 1301
PostgreSQL-User-Service-DB : 1400
PostgreSQL-Wordgroup-Service-DB : 1401
Zipkin: http://localhost:9411/zipkin

Unit Test
Integration Test



## Docker Komutları

Bu komut, PostgreSQL konteynerine bağlanmanızı sağlar.

> docker exec -it {ContainerId} bash



## PSQL Komutları

Bu komut, PostgreSQL konteynerine bağlanmanızı ve PostgreSQL'in interaktif terminaline erişmenizi sağlar.

> docker exec -it {ContainerId} psql -U postgres

Yukarıdaki komutla default postgres veritabanına bağlanırsın. Bunu değiştirmek için aşağıdaki komut (Switch Databases)

> \c <database_name>

Seçili database'in tablolarını gösterir.

> \dt

Tablo adına göre detaylı tablo rehberi.

> \d <table-name>

Tablo adı değişikliği için

> ALTER TABLE <table_name> RENAME TO <new_table_name>;

Veritabanı silme

> DROP DATABASE <database_name>;

PSQL'den çıkma komutu

> \q


## Zipkin eklemek için docker image'i indir

> docker run -p 9411:9411 openzipkin/zipkin 

Daha sonra gereken configurasyonları yapmak için loglarını toplamak istediğin server'a aşağıdaki dependency'leri
ekleyip ardından application.properties'e zipkin uri ekle.

<dependency> <!-- Servisi zipkin'e register etmek için gereken dependency 1/2 -->
    <groupId>org.springframework.cloud</groupId>
    <artifactId>spring-cloud-starter-sleuth</artifactId>
    <version>3.1.9</version>
</dependency>

<dependency> <!-- Servisi zipkin'e register etmek için gereken dependency 2/2 -->
    <groupId>org.springframework.cloud</groupId>
    <artifactId>spring-cloud-sleuth-zipkin</artifactId>
    <version>3.1.9</version>
</dependency>

spring.zipkin.base-url=http://localhost:9411

