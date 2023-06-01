package com.alcohol.dionysus.config;

import com.alcohol.dionysus.alcohol.AlcoholController;
import com.alcohol.dionysus.drink.DrinkController;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.scheduling.annotation.EnableAsync;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Configuration
@EnableAsync
public class WebConfig {
    @Value("${firebase.credential.resource-path}")
    private String keyPath;

    @Bean("ackController")
    public Set<Class<?>> ackController() {
        List<Class<?>> classes = Arrays.asList(
                AlcoholController.class,
                DrinkController.class
        );

        return new HashSet<>(classes);
    }

    @Bean
    @Primary
    public void firebaseInitialization() throws IOException {
        Resource resource = new ClassPathResource(keyPath);
        FileInputStream serviceAccount = new FileInputStream(resource.getFile());
        FirebaseOptions options = FirebaseOptions.builder()
                .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                .build();

        FirebaseApp.initializeApp(options);
    }
}
