package com.dobraccon.pain_market.brand;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class BrandService {
    private final Brandrepository brandrepository;

    public void create(Brand brand) {
        brandrepository.create(brand);
    }

    public Brand getById(long id) {
        return brandrepository.getById(id);
    }

    public void deleteById(long id) {
        brandrepository.deleteById(id);
    }

    public void update(Brand brand) {
        brandrepository.update(brand);
    }

    public List<Brand> getByNameLike(String name) {
        return brandrepository.getByNameLike(name);
    }
}
