package com.dobraccon.pain_market.categories;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CategoriesService {
    private final CategoriesRepository categoriesRepository;

    public void create(Categories categories) {
        categoriesRepository.create(categories);
    }

    public Categories getById(long id) {
        return categoriesRepository.getById(id);
    }

    public void update(Categories categories) {
        categoriesRepository.update(categories);
    }

    public void deleteById(long id) {
        categoriesRepository.deleteById(id);
    }

    public List<Categories> getByCategoryGroupId(long categoryGroupId) {
        return categoriesRepository.getByCategoryGroupId(categoryGroupId);
    }

    public List<Categories> getByCatalogId(long catalogId) {
        return categoriesRepository.getByCatalogId(catalogId);
    }
}
