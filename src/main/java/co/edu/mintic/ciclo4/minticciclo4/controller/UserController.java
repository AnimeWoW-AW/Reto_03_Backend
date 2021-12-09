package co.edu.mintic.ciclo4.minticciclo4.controller;

import co.edu.mintic.ciclo4.minticciclo4.model.User;
import co.edu.mintic.ciclo4.minticciclo4.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/user")
@CrossOrigin(origins = "*",methods = {RequestMethod.PUT,RequestMethod.GET,RequestMethod.POST,RequestMethod.DELETE})
public class UserController {


    @Autowired
    private UserService service;

    /**
     * Metodo para obtener todo
     */
    @GetMapping("/all")
    public List<User> getAll() {
        return service.findAll();
    }

    /**
     * Metodo por id
     */
    @GetMapping("/{id}")
    public User getUserById(@PathVariable("id") Integer id) {
        return service.getUserById(id);
    }

    /**
     * Metodo para crear
     */
    @PostMapping("/new")
    @ResponseStatus(HttpStatus.CREATED)
    public User save(@RequestBody User user) {
        return service.save(user);
    }

    /**
     * Metodo para actualizar
     */
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public User update(@RequestBody User user) {
        return service.update(user);
    }

    /**
     * Metodo para verificar
     */
    @GetMapping("/emailexist/{email}")
    public boolean isEmailPresent(@PathVariable("email") String email) {
        return service.isEmailPresent(email);
    }

    /**
     * Metodo para validar
     */
    @GetMapping("/{email}/{password}")
    public Optional<User> getUserByEmailAndPassword(@PathVariable("email") String email, @PathVariable("password") String password) {
        return service.getUserByEmailAndPassword(email, password);
    }

    /**
     * Metodo para eliminar
     */
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") Integer id) { return service.delete(id); }
}
