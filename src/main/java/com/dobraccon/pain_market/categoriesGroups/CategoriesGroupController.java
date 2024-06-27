package com.dobraccon.pain_market.categoriesGroups;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categories-groups")
@AllArgsConstructor
public class CategoriesGroupController {
    private final CategoriesGroupService categoriesGroupService;

    @PostMapping
    public void create(@RequestBody CategoriesGroups categoriesGroups) {
        categoriesGroupService.create(categoriesGroups);
    }

    @GetMapping("/{id}")
    public CategoriesGroups getById(@PathVariable Long id) {
        return categoriesGroupService.getById(id);
    }

    @PutMapping
    public void update(@RequestBody CategoriesGroups categoriesGroups) {
        categoriesGroupService.update(categoriesGroups);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        categoriesGroupService.deleteById(id);
    }

    @GetMapping("/get-all-by-catalogId/{catalogId}")
    public List<CategoriesGroups> getAllByCatalogId(@PathVariable long catalogId) {
        return categoriesGroupService.getAllByCatalogId(catalogId);
    }
}
