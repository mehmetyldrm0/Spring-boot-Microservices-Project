package com.eleiatech.stockmanagement.productservice.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration // konfigürasyon sayfası olduğunun belirtir.Spring Boot, uygulamanın yapılandırması için bu tür sınıfları tanıyarak gerekli ayarları gerçekleştirir.
@EnableSwagger2 // Swagger etkinleştiren bir annotasyondur. Bu annotasyon, Swagger UI'nin ve Swagger JSON belgesinin oluşturulmasını sağlar.
public class SwaggerConfiguration {

    @Bean // Bu yöntem, Swagger'ın Docket nesnesini oluşturan bir fabrika yöntemidir.
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select() // Swagger 2 belgesi tipini kullanır.
                .apis(RequestHandlerSelectors.basePackage("com.eleiatech")) //  API'ların taranacağı temel paketi belirler. Bu örnekte, "com.eleiatech" paketi altındaki sınıflar taranacaktır.
                .paths(PathSelectors.any()) // tüm yolları belgelendirmeyi ifade eder.
                .build(); //  Docket nesnesini oluşturur ve yapılandırmayı tamamlar.

        // Bu yapılandırma, Swagger UI'ı kullanarak API belgesine erişim sağlar.
        // Uygulamanızı çalıştırdıktan sonra http://localhost:port/swagger-ui.html adresine giderek Swagger UI'ı görüntüleyebilir
        // ve API'nizin belgesini inceleyebilirsiniz.
    }

}
