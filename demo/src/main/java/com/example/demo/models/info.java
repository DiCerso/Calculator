package com.example.demo.models;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

public class info {
    public String status;
    public int numero1;
    public int numero2;
    public String operation;
    public double information;

    public info(String status, String operation, Integer numero1, Integer numero2){
        this.status = status;
        this.operation = operation;
        this.numero1 = numero1;
        this.numero2 = numero2;
        switch (operation){
            case "Resta":
                this.information = (numero1 - numero2);
                break;
            case "Suma":
                this.information = (numero1 + numero2);
                break;
            case "Multiplicacion":
                this.information = (numero1 * numero2);
                break;
            case "Division":
                if(numero2 != 0){
                    this.information = (double) numero1 / numero2;
                }else{
                    this.status = "ERROR";
                }
                break;
        }
    }


}
