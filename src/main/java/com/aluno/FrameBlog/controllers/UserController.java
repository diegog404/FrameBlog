package com.aluno.FrameBlog.controllers;


import com.aluno.FrameBlog.models.User;
import com.aluno.FrameBlog.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//mapeamento do java para aplicação web
@RestController
//caminho da entrada
@RequestMapping(path = "/users")
public class UserController {

    @Autowired
    private UserService userService;

    //mapeamento da operação save, envia e retorna os dados do usuário, usa o service para
    //realizar a operaçao, passando um user como parametro
    @PostMapping(path = "/save")
    private @ResponseBody User save(@RequestBody User user){
        return userService.save(user);
    }

    @GetMapping(path = "/getAll")
    private @ResponseBody List<User> getAll(){

        return userService.getAll();
    }

    @GetMapping(path = "/get")
    private @ResponseBody User get(@RequestParam final Long id){

        return userService.get(id);
    }

    @PostMapping(path = "/update")
    private @ResponseBody User update(@RequestParam final Long id, @RequestBody User user){

        return userService.update(id, user);
    }

    @DeleteMapping(path = "/delete")
    private ResponseEntity<?> delete(@RequestParam final Long id){

        userService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping(path = "/")
    public @ResponseBody String authentication(){

        return "Hello World";
    }
}
