package SpringBoot.firebase.firebaseCrud.controller;


import SpringBoot.firebase.firebaseCrud.model.User;
import SpringBoot.firebase.firebaseCrud.service.CRUDService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.net.http.HttpResponse;
import java.util.concurrent.ExecutionException;

@RestController

public class UserController {
    private final CRUDService cruDservice ;


    public UserController(CRUDService cruDservice) {
        this.cruDservice = cruDservice;
    }
    @PostMapping("/create")
    public String createUser(@RequestBody User user)throws InterruptedException, ExecutionException {
        return cruDservice.createUser(user);
    }
    @GetMapping("/get/{document_id}")
    public User getUser(@PathVariable String document_id)throws InterruptedException, ExecutionException {
        return cruDservice.getUser(document_id);
    }
    @PutMapping("/update")
    public String updateUser(@RequestBody User user)throws InterruptedException, ExecutionException {
        return cruDservice.updateUser(user);
    }
    @DeleteMapping("/delete/{document_id}")
    public String deleteUser(@PathVariable String document_id)throws InterruptedException, ExecutionException {
        return cruDservice.deleteUser(document_id);
    }
}
