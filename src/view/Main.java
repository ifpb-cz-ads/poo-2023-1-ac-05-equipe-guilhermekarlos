package view;

import model.*;

import java.time.LocalDate;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Cliente cliente1 = new PessoaFisica(1000,
                new Endereco("Rua A", 30, "Cajazeiras"),
                "111.111.111-01", "João",
                LocalDate.of(1990,1,1));

        ContaCorrente contaCorrente1 = new ContaCorrente(1,1,
                300, LocalDate.now(), cliente1,20);

        Cliente cliente2 = new PessoaFisica(2000, new Endereco("Rua A", 30, "Cajazeiras"),
                "222.222.222-01", "Messyas",
                LocalDate.of(2004, 10, 13));

        ContaCorrente contaCorrente2 = new ContaCorrente(2, 2, 200,
                LocalDate.now(), cliente2, 20);

        int opcao;
                do {
                    System.out.println("O que deseja fazer:");
                    System.out.println("1-Sacar\n2-Depositar\n3-Transferir\n4-Ver saldo\n5-Encerrar o programa");
                    opcao = scanner.nextInt();

                    switch (opcao) {
                        case 1:
                            System.out.println("Informe o valor a ser sacado:");
                            double saque = scanner.nextDouble();
                            boolean control = contaCorrente1.sacar(saque);
                            if (control) {
                                System.out.println("Saque efetuado com sucesso!");
                                System.out.println("Saldo atual R$" + contaCorrente1.getSaldo());
                            } else {
                                System.out.println("Saldo insuficiente!");
                            }
                            break;
                        case 2:
                            System.out.println("Informe o valor a ser depositado:");
                            double deposito = scanner.nextDouble();
                            boolean retorno = contaCorrente1.depositar(deposito);
                            System.out.println("Depósito efetuado com sucesso");
                            System.out.println("Saldo atual R$" + contaCorrente1.getSaldo());
                            break;
                        case 3:
                            System.out.println("Informe o valor da transferência");
                            double valorTransferencia = scanner.nextDouble();
                            if (contaCorrente1.getSaldo() - valorTransferencia <= 0) {
                                System.out.println("Saldo insuficiente");
                            } else {
                                double saldoTemp = contaCorrente1.getSaldo() - valorTransferencia;
                                contaCorrente1.setSaldo(saldoTemp);
                                contaCorrente1.transferir(contaCorrente2, valorTransferencia);
                                System.out.println("Saldo conta origem R$" + contaCorrente1.getSaldo());
                                System.out.println("Saldo conta destino R$" + contaCorrente2.getSaldo());
                            }
                            break;
                        case 4:
                            System.out.println("Saldo atual R$" + contaCorrente1.getSaldo());
                            break;
                        case 5:
                            break;
                        default:
                            System.out.println("Opção inválida. Tente novamente.");
                            break;
                    }
                } while (opcao > 0 && opcao < 5);

                scanner.close();
            }
        }
       //DateTimeFormatter formatter = DateTimeFormatter
       //        .ofPattern("dd/MM/yyyy");
       //String string = "29/02/2000";
       //LocalDate localDate = LocalDate.parse(string, formatter);