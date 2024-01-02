import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.ArrayList;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        // Press Alt+Intro with your caret at the highlighted text to see how
        // IntelliJ IDEA suggests fixing it.
        System.out.println("Hello and welcome!");

        String myString = "Hola";
        Integer myInt = 10;             // clases (recomendable)
        Boolean myBoolean = true;
        Double myDouble = 10.4;
        final String miStringconstant = "mi string constante";


        int myInt2 = 10;                //tipos de variables
        boolean myBoolean2 = true;
        double myDouble2 = 10.4;

        System.out.println(myInt + myDouble);
        System.out.println(myDouble + Double.valueOf(myInt));
        System.out.println(myString + myInt );


        List myList = new ArrayList();
        myList.add(myString);
        myList.add(myInt);
        System.out.println(myList);

        Map<String, String> myMap1 = new HashMap(); // declaro que la clave es string y el dato tambien
        myMap1.put("string", myString);
        myMap1.put("int", myInt.toString());
        System.out.println(myMap1);

        Map myMap = new HashMap();
        myMap.put("string", myString);
        myMap.put("int", myInt);                //funcionamiento de los mapas
        System.out.println(myMap);
        System.out.println(myMap.get("string"));



        for (int index = 0; index < myList.size(); index ++){
            System.out.println(myList.get(index));
        }

        Main myMain = new Main(); //creo un objeto main llamado myMain
        myMain.myFunction(1, 2);
        //como llamar a un metodo de myMain, por lo cual solo se puede llamar cuando se cree un metodo main
        System.out.println(myMain.suma(2, 5));


        funcion(1, 5);//metodo se puede llamar sin crear un metodo main

        //sobrecarga de metodos
        double dato1 = sumatoria(9.4, 2.4);
        int dato2 = sumatoria(9, 3);
        System.out.println("dato1: " + dato1 + " dato2: " + dato2);

    }
    static double sumatoria(double uno, double dos){
        return uno + dos;
    }

    static int sumatoria(int uno, int dos){
        return uno + dos;
    }


    static void funcion (int myFirstNumber, int mySecondNumber){ //funcion
        System.out.println(myFirstNumber + mySecondNumber);
    }
    public void myFunction(int myFirstNumber, int mySecondNumber) { //metodo de main
        System.out.println(myFirstNumber + mySecondNumber);
    }

    public Integer suma(int myFirstNumber, int mySecondNumber){
        return myFirstNumber + mySecondNumber;
    }
}

