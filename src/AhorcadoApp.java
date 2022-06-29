import java.util.Arrays;
import java.util.Scanner;

public class AhorcadoApp {

    static int CONT_INTENTOS = 6;
    static int PTS_JUG_1 = 0;
    static int PTS_JUG_2 = 0;
    static int TURNO = 1;
    public static void main(String[] args) throws Exception {
        String jugador1, jugador2;

        System.out.println("Jugador 1 introduce tu nombre.");
        jugador1 = IntroducirCadena();
        System.out.println("Jugador 2 introduce tu nombre.");
        jugador2 = IntroducirCadena();

        JugarAhorcado(jugador1, jugador2);

    }

    public static void JugarAhorcado(String jugador1, String jugador2){

        String letra, palabra;
        Boolean encontrada;

        while(PTS_JUG_1 < 3 && PTS_JUG_2 < 3){
            if(TURNO % 2 != 0){
                System.out.println(jugador1 + " Introduce una palabra.");
                palabra = IntroducirCadena();
                char[] cadaux = new char[palabra.length()];
                Arrays.fill(cadaux, '-');
                while(CONT_INTENTOS > 0 && TURNO % 2 != 0){
                    System.out.println(jugador2 + " Introduce una letra.");
                    letra = IntroducirCadena();
                    encontrada = BuscarLetra(palabra, cadaux, letra);
                    if(encontrada){
                        for (int i = 0; i < cadaux.length; i++) {
                            System.out.print(cadaux[i]);
                        }
                        System.out.println("\n");
                        if(Arrays.equals(palabra.toCharArray(), cadaux)){
                            System.out.println("Correcto. +1 punto para " + jugador2);
                            TURNO++;
                            PTS_JUG_2++;
                            CONT_INTENTOS = 6;
                        }
                    }else{
                        CONT_INTENTOS--;
                        System.out.println("Letra incorrecta. Tienes " + CONT_INTENTOS + " intentos.");
                        if(CONT_INTENTOS == 0){
                            System.out.println("Ahorcado. Punto para " + jugador1);
                            PTS_JUG_1++;
                        }
                    }
                }
                CONT_INTENTOS = 6;

            }else{
                System.out.println(jugador2 + " Introduce una palabra.");
                palabra = IntroducirCadena();
                char[] cadaux = new char[palabra.length()];
                Arrays.fill(cadaux, '-');
                while(CONT_INTENTOS > 0 && TURNO % 2 == 0){
                    System.out.println(jugador1 + " Introduce una letra.");
                    letra = IntroducirCadena();
                    encontrada = BuscarLetra(palabra, cadaux, letra);
                    if(encontrada){
                        for (int i = 0; i < cadaux.length; i++) {
                            System.out.print(cadaux[i]);
                        }
                        System.out.println("\n");
                        if(Arrays.equals(palabra.toCharArray(), cadaux)){
                            System.out.println("Correcto. +1 punto para " + jugador1);
                            TURNO++;
                            PTS_JUG_1++;
                        }
                    }else{
                        CONT_INTENTOS--;
                        System.out.println("Letra incorrecta. Tienes " + CONT_INTENTOS + " intentos.");
                        if(CONT_INTENTOS == 0){
                            System.out.println("Ahorcado. Punto para " + jugador2);
                            PTS_JUG_2++;
                        }
                    }
                }
                CONT_INTENTOS = 6;
            }
        }
    }
    public static Boolean BuscarLetra(String palabra, char[] cadaux, String letra){
        Boolean encontrada = false;

        for (int i = 0; i < palabra.length(); i++) {
            if(palabra.charAt(i) == letra.charAt(0)){
                cadaux[i] = letra.charAt(0);
                encontrada = true;
            }
        }

        return encontrada;
    }

    public static String IntroducirCadena(){
        String texto;
        Scanner sc = new Scanner(System.in);
        texto = sc.nextLine();
        return texto;
    }
}
