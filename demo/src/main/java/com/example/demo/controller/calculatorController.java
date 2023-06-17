package com.example.demo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

import com.example.demo.models.info;

@RestController
@RequestMapping(path = "/calculator")
public class calculatorController {


//    @GetMapping("/hola")
//    String Calcu(){
//        return "Bienvenido a la calculadora";
//    }

    @PostMapping("/suma")
    public ResponseEntity<info> suma(@RequestBody Map<String, Object> dat){
        info request = new info("OK","Suma", (Integer) dat.get("num1"), (Integer) dat.get("num2"));
        return ResponseEntity.status(HttpStatus.OK).body(request);
    }
    @PostMapping("/resta")
    public ResponseEntity<info> resta(@RequestBody Map<String, Object> dat){
        info request = new info("OK","Resta", (Integer) dat.get("num1"), (Integer) dat.get("num2"));
        return ResponseEntity.status(HttpStatus.OK).body(request);

    }

    @PostMapping("/multiplicacion")
    public ResponseEntity<info> multiplicacion(@RequestBody Map<String, Object> dat){
        info request = new info("OK","Multiplicacion", (Integer) dat.get("num1"), (Integer) dat.get("num2"));
        return ResponseEntity.status(HttpStatus.OK).body(request);

    }

    @PostMapping("/division")
    public ResponseEntity<info> division(@RequestBody Map<String, Object> dat){
        info request = new info("OK","Division", (Integer) dat.get("num1"), (Integer) dat.get("num2"));
        if(request.status == "ERROR"){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(request);
        }else{
            return ResponseEntity.status(HttpStatus.OK).body(request);
        }
    }
}
