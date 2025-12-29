package com.university.library.emprunt.client;

import com.university.library.emprunt.model.Livre;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "GS-CATALOGUE")
public interface LivreRestClient {

    @GetMapping("/api/books/{id}")
    Livre getBookById(@PathVariable Long id);
}
