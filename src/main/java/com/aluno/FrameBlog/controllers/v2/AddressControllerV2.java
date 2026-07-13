package com.aluno.FrameBlog.controllers.v2;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.aluno.FrameBlog.models.v2.AddressV2;
import com.aluno.FrameBlog.services.v2.AddressServiceV2;

@RestController
@RequestMapping(path = "/v2/address")
public class AddressControllerV2 {

    @Autowired
    private AddressServiceV2 addressServiceV2;
    @PostMapping(path = "/save")
    private @ResponseBody AddressV2 save(@RequestBody AddressV2 address) {
        return addressServiceV2.save(address);
    }

    @GetMapping(path = "/getAll")
    private @ResponseBody List<AddressV2> getAll() {
        return addressServiceV2.getAll();
    }

    @GetMapping(path = "/get")
    private @ResponseBody AddressV2 get(@RequestParam final Long id) {
        return addressServiceV2.get(id);
    }

    @PostMapping(path = "/update")
    private @ResponseBody AddressV2 update(@RequestParam final Long id, @RequestBody AddressV2 address) {
        return addressServiceV2.update(id, address);
    }

    @DeleteMapping(path = "/delete")
    private void delete(@RequestParam final Long id) {
        addressServiceV2.delete(id);
    }
}
