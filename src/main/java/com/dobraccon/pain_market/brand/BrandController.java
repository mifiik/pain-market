package com.dobraccon.pain_market.brand;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("brand")
@AllArgsConstructor
public class BrandController {
    private final BrandService brandService;

    @PostMapping
    public void create(@RequestBody Brand brand) {
        brandService.create(brand);
    }

    @GetMapping("/{id}")
    public Brand getById(@PathVariable Long id) {
        return brandService.getById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        brandService.deleteById(id);
    }

    @PutMapping
    public void update(@RequestBody Brand brand) {
        brandService.update(brand);
    }

    @GetMapping("/by-name-like/{name}")
    public List<Brand> getByNameLike(@PathVariable String name) {
        return brandService.getByNameLike(name);
    }
}
