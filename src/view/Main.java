package view;

import model.*;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Cliente cliente1 = new PessoaFisica(1000,
                new Endereco("Rua A", 30, "Cajazeiras"),
                "111.111.111-01", "João",
                LocalDate.of(1990,1,1));

        ContaCorrente contaCorrente1 = new ContaCorrente(1,1,
                0, LocalDate.now(), cliente1,20);

        Cliente cliente2 = new PessoaFisica(2000, new Endereco("Rua A", 30, "Cajazeiras"),
                "222.222.222-01", "Messyas",
                LocalDate.of(2004, 10, 13));

        ContaCorrente contaCorrente2 = new ContaCorrente(2, 2, 200,
                LocalDate.now(), cliente2, 20);

        double valorTransferencia = 200;
        if(contaCorrente2.getSaldo()-valorTransferencia<0){
            System.out.println("Saldo insuficiente");
        }
        else {
            double saldoTemp = contaCorrente2.getSaldo() - valorTransferencia;
            contaCorrente2.setSaldo(saldoTemp);
            contaCorrente2.transferir(contaCorrente1, valorTransferencia);
            System.out.println(contaCorrente1.getSaldo());
            System.out.println(contaCorrente2.getSaldo());
        }

       //DateTimeFormatter formatter = DateTimeFormatter
       //        .ofPattern("dd/MM/yyyy");
       //String string = "29/02/2000";
       //LocalDate localDate = LocalDate.parse(string, formatter);
    }
}