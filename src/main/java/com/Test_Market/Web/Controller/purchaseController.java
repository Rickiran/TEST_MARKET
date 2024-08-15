package com.Test_Market.Web.Controller;

import com.Test_Market.Domain.purchase;
import com.Test_Market.Domain.service.purchaseService;
import com.Test_Market.Persistance.Entity.purchasing;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/purchases")
public class purchaseController {
    @Autowired
    private purchaseService pService;

    @GetMapping("/all")
    public ResponseEntity<List<purchase>> getAll(){
        return new ResponseEntity<>(pService.getAll(), HttpStatus.OK) ;
    }

    @GetMapping("/{clientId}")
    public ResponseEntity<Optional<purchase>> getByClient(@PathVariable ("clientId") int clientId){
        return new ResponseEntity<>(pService.getByClient(clientId),HttpStatus.OK);
    }

    @GetMapping("/save")
    public ResponseEntity<purchase> save(@RequestBody purchase prchs){
        return new ResponseEntity<>(pService.save(prchs),HttpStatus.CREATED);
    }

    }
