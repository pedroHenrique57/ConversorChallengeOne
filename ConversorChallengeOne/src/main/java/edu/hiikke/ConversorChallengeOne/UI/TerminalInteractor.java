package edu.hiikke.ConversorChallengeOne.UI;

import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class TerminalInteractor {
  private final Scanner scanner = new Scanner(System.in);
  private final String mensagemTerminal = """
      ############################################################################################
        Olá, Seja bem vindo ao BanKiikkie!
        Vejo que tem interesse em realizar um cambio, Por favor me informe qual conversão deseja:
          1. USD
          2. CSD
          3. BRL
          4. BAM
          5. ARS
          6. ALL
          7. Cancelar Operação.
          8. Fechar Sistema
      ############################################################################################
      """;
  private Boolean loopIteracao = true;

  public void run() {
    // Mantém o loop até o usuário finalizar
    do {
      // Pergunta e salva a moeda base e a moeda final.
      for (int i = 0; i < 2; i++) {
        Integer entradaUsuario;
        Integer moedaBase;
        Integer moedaFinal;

        // Exibe Mensagem de interação para guiar o usuário
        System.out.println(mensagemTerminal);

        // Interpreta a resposta e redireciona para o consumo correto.
        entradaUsuario = scanner.nextInt();
        if (entradaUsuario == 8) {
          i = 2;
          loopIteracao = false;
        } else if (entradaUsuario == 7) {
          i = 2;
        } else if (i == 0) {
          moedaBase = entradaUsuario;
          System.out.println(moedaBase);
        } else if (i == 1) {
          moedaFinal = entradaUsuario;
          System.out.println(moedaFinal);
        }
      }
      // Joga os dados das moedas para o consumo
    } while (loopIteracao);
  }
}
