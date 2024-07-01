package com.dobraccon.pain_market.catalog;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CatalogService {
    private final CatalogRepository catalogRepository;


    public void create(Catalog catalog) {
        catalogRepository.create(catalog);
    }

    public Catalog getById(long id) {
        return catalogRepository.getById(id);
    }

    public void update(Catalog catalog) {
        catalogRepository.update(catalog);
    }

    public void deleteById(long id) {
        catalogRepository.deleteById(id);
    }

    public List<Catalog> getAll() {
        return catalogRepository.getAll();
    }
}
