package service;

import domain.Actor;
import domain.Gender;
import exceptions.ActorNotFoundException;
import repository.ActorRepository;

import java.util.List;
import java.util.Scanner;

public class ActorService {

    private Scanner scanner=new Scanner(System.in);

    private final ActorRepository actorRepository;

    public ActorService(ActorRepository actorRepository) {
        this.actorRepository = actorRepository;
    }
    public Actor findActorById(Long id) {
        try {
            Actor foundActor = actorRepository.findById(id);
            if(foundActor!=null){
                System.out.println("*-----------------------------*");
                System.out.println(foundActor);
                return foundActor;
            }else{
                throw new ActorNotFoundException("Actor not found with id : "+id);
            }
        }catch (ActorNotFoundException e){
            System.out.println(e.getMessage());
        }
        return null;

    }

    public List<Actor> findAllActors() {
        List<Actor> actors = actorRepository.findAll();
        if (!actors.isEmpty()) {
            for (Actor actor : actors) {
                System.out.println(actor);
            }
        } else {
            System.out.println("Actor not found");
        }
        return actors;
    }

    public void saveActor() {
        Actor actor=new Actor();
        //id otomatik generate edilecek
        System.out.println("Enter full name : ");
        actor.setFullName(scanner.nextLine());

        System.out.println("Enter age : ");
        actor.setAge(scanner.nextInt());
        scanner.nextLine();

        System.out.println("Enter gender : ");
        actor.setGender(Gender.valueOf(scanner.nextLine()));

        actorRepository.save(actor);
        System.out.println("Actor is saved successfully... Actor id"+actor.getActorId());

    }

    public void deleteActorById(Long id) {
        try {
            Actor existingActor =findActorById(id);
            if (existingActor != null) {
                actorRepository.deleteById(existingActor);
                System.out.println("Actor  delete successfully  with ID: " + id);
            }
        } catch (ActorNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

}
