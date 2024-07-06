package com.dobraccon.pain_market.brand;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class BrandService {
    private final BrandRepository brandRepository;

    public void create(Brand brand) {
        brandRepository.save(brand);
    }

    public Brand getById(long id) {
        Optional<Brand> brand = brandRepository.findById(id);
        return brand.orElse(null);
    }

    public void deleteById(long id) {
        brandRepository.deleteById(id);
    }

    public void update(Brand brand) {
        brandRepository.save(brand);
    }

    public List<Brand> getByNameLike(String name) {
        return brandRepository.findByNameContainingIgnoreCase(name);
    }
}

