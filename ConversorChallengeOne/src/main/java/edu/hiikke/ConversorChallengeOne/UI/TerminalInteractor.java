package edu.hiikke.ConversorChallengeOne.UI;

import edu.hiikke.ConversorChallengeOne.services.ExchangeRateAPIConnection.ExchangeRateAPIConsumo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class TerminalInteractor {
  private final Scanner scanner = new Scanner(System.in);
  private final String listaDeOpcoes =
      """
              USD
              CSD
              BRL
              BAM
              ARS
              ALL
              1. Cancelar Operação
              2. Fechar Sistema
          ############################################################################################""";
  private final String mensagemIteracao1 =
      """
          \n############################################################################################
            Olá, Seja bem vindo ao BanKiikkie!
            Vejo que tem interesse em realizar um cambio! Por favor me escreva qual a moeda inicial da conversão:""";
  private final String mensagemIteracao2 =
      """
          ############################################################################################
              Ótimo! Agora por favor, escreva o valor base que você tem interesse em converter.
              !!! Informe somente valores inteiros, sem casas decimais !!!
          ############################################################################################""";
  private final String mensagemIteracao3 =
      """
          ############################################################################################
              Perfeito! Agora por favor me informe qual a moeda final da conversão""";
  private Boolean loopIteracao = true;
  private ExchangeRateAPIConsumo exchangeRateAPIConsumo;

  // Injeção de dependências
  @Autowired
  public TerminalInteractor(ExchangeRateAPIConsumo exchangeRateAPIConsumo) {
    this.exchangeRateAPIConsumo = exchangeRateAPIConsumo;
  }

  public void run() {
    // Mantém o loop até o usuário finalizar
    do {
      String entradaUsuario = "";
      String moedaBase = "";
      String moedaFinal = "";
      int montanteInicial = 0;

      // Pergunta e salva a moeda base e a moeda final.
      for (int i = 0; i < 3; i++) {
        // Cria iterações para cada ciclo diferente para personalizar mensagens e salvamentos de dados.
        if (i == 0) {
          System.out.println(mensagemIteracao1);
          System.out.println(listaDeOpcoes);
          entradaUsuario = scanner.nextLine().toUpperCase();
          moedaBase = entradaUsuario;
        } else if (i == 1) {
          System.out.println(mensagemIteracao2);
          montanteInicial = scanner.nextInt();
          scanner.nextLine();
        } else if (i == 2) {
          System.out.println(mensagemIteracao3);
          System.out.println(listaDeOpcoes);
          moedaFinal = scanner.nextLine().toUpperCase();
        }

        // Caso a opção seja a 1 ou a 2
        if (entradaUsuario.equals("1")) {
          i = 3;
        } else if (entradaUsuario.equals("2")) {
          i = 3;
          loopIteracao = false;
        }
      }

      // Faz a conversão das moedas e exibe para o usuário
      try {
        System.out.printf("Sua moeda inicial foi: " + moedaBase +
                          "\nSua moeda final foi: " + moedaFinal +
                          "\nSeu montante inicial foi: " + montanteInicial +
                          "\nSeu montante final foi: %.2f", (exchangeRateAPIConsumo.realizarConversao(moedaBase, moedaFinal, montanteInicial)));
      } catch (Exception e) {
      }
    } while (loopIteracao);
  }
}
