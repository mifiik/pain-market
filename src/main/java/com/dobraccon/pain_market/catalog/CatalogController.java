package com.dobraccon.pain_market.catalog;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/catalog")
@AllArgsConstructor
public class CatalogController {
    private final CatalogService catalogService;

    @PostMapping
    public void create(@RequestBody Catalog catalog) {
        catalogService.create(catalog);
    }

    @GetMapping("/{id}")
    public Catalog getById(@PathVariable Long id) {
        return catalogService.getById(id);
    }

    @PutMapping
    public void update(@RequestBody Catalog catalog) {
        catalogService.update(catalog);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        catalogService.deleteById(id);
    }

    @GetMapping()
    public List<Catalog> getAll() {
        return catalogService.getAll();
    }
}
