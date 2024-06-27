package com.dobraccon.pain_market.categories;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categories")
@AllArgsConstructor
public class CategoriesController {
    private final CategoriesService categoriesService;

    @PostMapping
    public void create(@RequestBody Categories categories) {
        categoriesService.create(categories);
    }

    @GetMapping("/{id}")
    public Categories getById(@PathVariable Long id) {
        return categoriesService.getById(id);
    }

    @PutMapping
    public void update(@RequestBody Categories categories) {
        categoriesService.update(categories);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        categoriesService.deleteById(id);
    }

    @GetMapping("/get-by-category-group-id/{categoriesGroupsId}")
    public List<Categories> getByGroupId(@PathVariable long categoriesGroupsId) {
        return categoriesService.getByGroupId(categoriesGroupsId);
    }

    @GetMapping("/get-by-catalog-id/{catalogId}")
    public List<Categories> getByCatalogId(@PathVariable long catalogId) {
        return categoriesService.getByCatalogId(catalogId);
    }
}
