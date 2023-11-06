package service;

import domain.Film;
import domain.Language;
import repository.LanguageRepo;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LanguageService {
    private Scanner scanner = new Scanner(System.in);

    private LanguageRepo languageRepo=new LanguageRepo();

    public LanguageService(LanguageRepo languageRepo) {
        this.languageRepo = languageRepo;
    }


    public List<Language> displayAllFilmInLanTable() {
        List<Language> languageList=languageRepo.findAll();

        if(!languageList.isEmpty()){
            System.out.println("--------List Of Language--------");
            languageList.forEach(System.out::println);
        }else System.out.println("Language List is Empty ");

        return languageList;
    }
}
