package com.example.chaconborja1eva;

import java.util.regex.Matcher;
import java.util.regex.Pattern;



public class ExpresionRegular {

    /**
     * Resolver una expresion matematica por medio de Expresiones Regulares
     * @param expresionMatematica
     * @param operacionExpresion
     * @return
     */
    private   String resolver(String expresionMatematica, char operacionExpresion) {

        System.out.println("-------------------------------------------------------------");
        expresionMatematica = expresionMatematica.trim();
        System.out.println("Operación: " + operacionExpresion);
        System.out.println("Expresión actual: " + expresionMatematica);

        Pattern p = Pattern.compile("([-]{1}[\\d]+\\.[\\d]+|[\\d]+\\.[\\d]+|-[\\d]+|[\\d]+)(\\" + operacionExpresion + ")(-[\\d]+\\.[\\d]+|[\\d]+\\.[\\d]+|[\\d]+)");
        Matcher m = p.matcher(expresionMatematica);

        if ( m.find() ) {

            System.out.println("Fraccion:"+m.group());
            System.out.println("Num1:"+m.group(1));
            System.out.println("OperadorEncontrado:"+m.group(2));
            System.out.println("Num2:"+m.group(3));


            double num1 = Double.parseDouble(m.group(1));
            char operacion = m.group(2).charAt(0);
            double num2 = Double.parseDouble(m.group(3));

            double resultado = 0;
            switch (operacion) {
                case '/':
                    if (num2 == 0) {
                        return "ERRROR Division por CERO(0)";
                    }   resultado = num1 / num2;
                    break;
                case 'x':
                    resultado = num1 * num2;
                    break;
                case '+':
                    resultado = num1 + num2;
                    break;
                case '-':
                    resultado = num1 - num2;
                    break;
                default:
                    break;
            }
            String txtResultado = "0";
            if( Math.abs( resultado ) > 0 ){
                txtResultado = String.valueOf(resultado);
                if( (Math.abs( resultado )/(int)Math.abs( resultado )) == 1D){
                    //Eliminamos el .0
                    txtResultado = String.valueOf(resultado).replaceFirst("\\.0", "");
                }
                System.out.println("Cambios Rfinal:"+txtResultado);
            }else{
                System.out.println("Rfinal:"+txtResultado);
            }

            expresionMatematica = m.replaceFirst( txtResultado );
            System.out.println("Expresión final: " + expresionMatematica);
        }
        return expresionMatematica;
    }

    /**
     *
     * @param formula
     */
    public String resolverFormula( String formula ) {
        ExpresionRegular er = new ExpresionRegular();

        //Division y multiplica
        while( true ){
            int indiceDivision = formula.indexOf("/");
            int indiceMultiplica = formula.indexOf("x");

            if( indiceDivision == -1 && indiceMultiplica == -1){
                break;
            }else if( indiceDivision == -1 && indiceMultiplica >= 0){
                formula = er.resolver(formula, 'x');
            }else if( indiceDivision >= 0 && indiceMultiplica == -1){
                formula = er.resolver(formula, '/');
            }else if( indiceMultiplica < indiceDivision ){
                formula = er.resolver(formula, 'x');
            }else{
                formula = er.resolver(formula, '/');
            }
        }
        //Resta y Suma
        while( true ){
            int indiceResta = formula.indexOf("-",1);
            int indiceSuma = formula.indexOf("+");

            if( indiceResta == -1 && indiceSuma == -1){
                break;
            }else if( indiceResta == -1 && indiceSuma >= 0){
                formula = er.resolver(formula, '+');
            }else if( indiceResta >= 0 && indiceSuma == -1){
                formula = er.resolver(formula, '-');
            }else if( indiceSuma < indiceResta){
                formula = er.resolver(formula, '+');
            }else{
                formula = er.resolver(formula, '-');
            }
        }
        System.out.println("-------------------------------------------------------------");
        System.out.println("Respuesta final: "+formula);
        return formula;
    }

}