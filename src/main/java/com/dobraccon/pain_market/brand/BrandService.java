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

    public void deleteById(long brandId) {
        brandrepository.deleteById(brandId);
    }

    public void update(Brand brand) {
        brandrepository.update(brand);
    }

    public List<Brand> getByName(String nameSymbol) {
        return brandrepository.getByName(nameSymbol);
    }
}
