package com.boo.lesson;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CatService {

    private final CatRepo catRepo;

    @Autowired
    public CatService(CatRepo catRepo) {
        this.catRepo = catRepo;
    }

    public void saveCat(final Cat cat) {
        catRepo.save(cat);
    }

    public Cat getCatById(final int id) {
        return catRepo.findById(id).orElse(null);
    }

    public Optional<Cat> getByEmail(final String email) {
        return catRepo.findAllByEmail(email);
    }

    public List<Cat> getAllCats() {
        return catRepo.findAll();
    }
}
