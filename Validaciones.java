package Clases;

// @author Luis Alberto Alonso Mendoza 1664442
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Validaciones {

    public int valFechaDia(int m, int a) {
        boolean val;
        int diaActual, mesActual, anioActual, diaNac;
        Scanner sc = new Scanner(System.in);
        Date date;
        date = new Date();
        Calendar cal;
        cal = new GregorianCalendar();
        cal.setTime(date);
        diaActual = cal.get(Calendar.DATE);
        mesActual = cal.get(Calendar.MONTH);
        anioActual = cal.get(Calendar.YEAR);
        do {
            val = true;
            System.out.println("Ingrese su día de nacimiento:");
            diaNac = sc.nextInt();
            if (diaNac < 1) {
                val = false;
            }
            switch (m) {
                case 1:
                case 3:
                case 5:
                case 7:
                case 8:
                case 10:
                case 12:
                    if (diaNac > 31) {

                        val = false;
                    }
                    break;
                case 2:
                    if (a % 4 == 0) {
                        if (diaNac > 29) {
                            val = false;
                        }
                    } else if (diaNac > 28) {
                        val = false;
                    }
                    break;
                case 4:
                case 6:
                case 9:
                case 11:
                    if (diaNac > 30) {
                        val = false;
                    }
                    break;
            }
            if (a == anioActual && m == mesActual + 1) {
                if (diaNac > diaActual) {
                    val = false;
                }
            }
            if (!val) {
                System.out.println("Error. Ingrese un día válido.");
            }
        } while (!val);
        return diaNac;
    }

    public int valFechaMes(int a) {
        boolean val;
        int mesNac, mesActual, anioActual;
        Scanner sc = new Scanner(System.in);
        Date date;
        date = new Date();
        Calendar cal;
        cal = new GregorianCalendar();
        cal.setTime(date);
        mesActual = cal.get(Calendar.MONTH);
        anioActual = cal.get(Calendar.YEAR);
        do {
            val = true;
            System.out.println("Ingrese su mes de nacimiento:");
            mesNac = sc.nextInt();
            if (mesNac > 12 | mesNac < 1) {
                val = false;
            }
            if (anioActual == a) {
                if (mesNac > mesActual + 1) {
                    val = false;
                }
            }
            if (!val) {
                System.out.println("Error. Ingrese un mes válido.");
            }
        } while (!val);
        return mesNac;
    }

    public int valFechaAnio() {
        boolean val;
        int anioNac, anioActual;
        Scanner sc = new Scanner(System.in);
        Date date;
        date = new Date();
        Calendar cal;
        cal = new GregorianCalendar();
        cal.setTime(date);
        anioActual = cal.get(Calendar.YEAR);
        do {
            val = false;
            System.out.println("Ingrese su año de nacimiento:");
            anioNac = sc.nextInt();
            if (anioNac > anioActual | anioNac < 1900) {
                System.out.println("Error. Ingrese un año válido.");
            } else {
                val = true;
            }
        } while (!val);
        return anioNac;
    }

    public String obtenerFecha() {
        int anioNac, mesNac, diaNac;
        anioNac = valFechaAnio();
        mesNac = valFechaMes(anioNac);
        diaNac = valFechaDia(mesNac, anioNac);
        String fecha = anioNac + "-" + mesNac + "-" + diaNac;
        return fecha;
    }

    public int readInteger() {
        Scanner sc = new Scanner(System.in);
        boolean vali = false;
        int num = 0;
        do {
            try {
                num = sc.nextInt();
                vali = true;
            } catch (InputMismatchException e) {
                System.out.println("Ingrese dato válido(Un numero).");
            } finally {
                sc.nextLine();
            }
        } while (vali == false);
        return num;
    }
}
