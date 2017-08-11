/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio;

import java.util.Arrays;
import java.util.*;

/**
 *
 * @author Mauricio Capua
 */
public class Date {

    private final int dia;
    private final int mes;
    private final int ano;
    protected static final ArrayList<Integer> MES30 = new ArrayList(Arrays.asList(4, 6, 9, 11));
    protected static final ArrayList<Integer> MES31 = new ArrayList(Arrays.asList(1, 3, 5, 7, 8, 10, 12));

    public Date() {
        this.ano = 1900;
        this.mes = 1;
        this.dia = 1;
    }

    public Date(int dia, int mes, int ano) {

        if (dia > 31) {
            this.dia = ano;
            this.mes = mes;
            this.ano = dia;
            //troquei validar e bissexto para static
            /*if (validardata(this.dia, this.mes, this.ano) == false) {
                throw new IllegalArgumentException("Data inválida");
            }*/
        } else {
            this.dia = dia;
            this.mes = mes;
            this.ano = ano;

        }
        if (validardata(this.dia, this.mes, this.ano) == false) {
            throw new IllegalArgumentException("Data inválida");
        }
    }

    public boolean before(Date d) {
        if (d.getAno() > this.ano
                || d.getMes() > this.mes
                || d.getDia() > this.dia) {
            return true;
        }
        return false;
    }

    public boolean after(Date d) {
        if ((d.getAno() < this.ano)
                || (d.getMes() < this.mes)
                || (d.getDia() < this.dia)) {
            return true;
        }
        return false;
    }

    public Date yesterday() {
        if (this.mes == 1) {
            if (this.dia == 1) {
                return new Date(31, 12, this.ano - 1);
            }
        } else if ((this.mes - 1) == 2) {
            if (this.dia == 1) {
                if (bissexto(this.ano) == true) {
                    return new Date(29, this.mes - 1, this.ano);
                } else {
                    return new Date(28, this.mes - 1, this.ano);
                }
            }
        } else if (MES30.contains(this.mes - 1) && (this.dia == 1)) {
            return new Date(30, this.mes - 1, this.ano);
        } else if (MES31.contains(this.mes - 1) && (this.dia == 1)) {
            return new Date(31, this.mes - 1, this.ano);
        }

        return new Date(
                this.dia - 1, this.mes, this.ano);
        //throw new IllegalArgumentException();
    }

    public Date tomorrow() {
        if (this.mes == 2) {
            if (bissexto(this.ano) == true) {
                if (this.dia == 29) {
                    return new Date(1, this.mes + 1, this.ano);
                }
            } else if (this.dia == 28) {
                return new Date(1, this.mes + 1, this.ano);
            }
        } else if (MES30.contains(this.mes) && (this.dia == 30)) {
            return new Date(1, this.mes + 1, this.ano);
        } else if (MES31.contains(this.mes) && this.dia == 31) {
            if (this.mes == 12) {
                return new Date(1, 1, this.ano + 1);
            } else {
                return new Date(1, this.mes + 1, this.ano);
            }
        }

        return new Date(
                this.dia + 1, this.mes, this.ano);
    }

    public Date plusday(int num) {
        if (num > 0) {
            Date d = new Date(this.dia, this.mes, this.ano);
            for (int i = 0; i < num; i++) {
                d = d.tomorrow();
            }
            return d;
        }
        throw new IllegalArgumentException("Valor inválido");
    }

    public Date minusday(int num) {
        if (num > 0) {
            Date d = new Date(this.dia, this.mes, this.ano);
            for (int i = 0; i < num; i++) {
                d = d.yesterday();
            }
            return d;
        }
        throw new IllegalArgumentException("Valor inválido");
    }

    public static boolean validardata(int dia, int mes, int ano) {

        if (ano >= 1900 && mes > 0 && mes < 13) {
            if (mes == 2) {
                if (bissexto(ano) == true) {
                    if (dia > 0 && dia < 30) {
                        return true;
                    }
                } else if (dia > 0 && dia < 29) {
                    return true;
                }
            } else if (MES30.contains(mes) && (dia > 0 && dia < 31)) {
                return true;
            } else if (MES31.contains(mes) && (dia > 0 && dia < 32)) {
                return true;
            }
        }
        return false;

    }

    public static boolean bissexto(int ano) {
        return (ano % 400 == 0) || ((ano % 4 == 0) && (ano % 100 != 0));
    }

    public int getDia() {
        return dia;
    }

    public int getMes() {
        return mes;
    }

    public int getAno() {
        return ano;
    }

    @Override
    public String toString() {
        if (dia < 10 && mes < 10) {
            return ("0" + dia + "/0" + mes + "/" + ano);
        } else if (dia < 10) {
            return ("0" + dia + "/" + mes + "/" + ano);
        } else if (mes < 10) {
            return (dia + "/0" + mes + "/" + ano);
        }
        return (dia + "/" + mes + "/" + ano);
    }

    public void print() {
        if (dia < 10 && mes < 10) {
            System.out.println("0" + dia + "/0" + mes + "/" + ano);
        } else if (dia < 10) {
            System.out.println("0" + dia + "/" + mes + "/" + ano);
        } else if (mes < 10) {
            System.out.println(dia + "/0" + mes + "/" + ano);
        } else {
            System.out.println(dia + "/" + mes + "/" + ano);
        }
    }

    /*
    public static Date yesterday(Date d) {
        if (d.getMes() == 1) {
            if (d.getDia() == 1) {
                return new Date(31, 12, d.getAno() - 1);
            }
        } else if ((d.getMes() - 1) == 2) {
            if (bissexto(d.getAno()) == true) {
                if (d.getDia() == 1) {
                    return new Date(29, d.getMes() - 1, d.getAno());
                }
            } else if (d.getDia() == 1) {
                return new Date(28, d.getMes() - 1, d.getAno());
            }
        } else if (MES30.contains(d.getMes() - 1)) {
            if (d.getDia() == 1) {
                return new Date(30, d.getMes() - 1, d.getAno());
            }
        } else if (MES31.contains(d.getMes() - 1)) {
            if (d.getDia() == 1) {
                return new Date(31, d.getMes() - 1, d.getAno());
            }
        }
        return new Date(d.getDia() - 1, d.getMes(), d.getAno());
        //throw new IllegalArgumentException();
    }
     */
}
