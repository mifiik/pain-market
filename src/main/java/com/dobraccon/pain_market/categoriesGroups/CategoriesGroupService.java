package com.dobraccon.pain_market.categoriesGroups;


import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CategoriesGroupService {
    private final CategoriesGroupRepository categoriesGroupRepository;

    public void create(CategoriesGroups categoriesGroups) {
        categoriesGroupRepository.create(categoriesGroups);
    }

    public CategoriesGroups getById(Long id) {
        return categoriesGroupRepository.getById(id);
    }

    public void update(CategoriesGroups categoriesGroups) {
        categoriesGroupRepository.update(categoriesGroups);
    }

    public void deleteById(Long id) {
        categoriesGroupRepository.deleteById(id);
    }

    public List<CategoriesGroups> getAllByCatalogId(long catalogId) {
        return categoriesGroupRepository.getAllByCatalogId(catalogId);
    }
}
