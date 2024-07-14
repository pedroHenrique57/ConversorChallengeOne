package edu.hiikke.ConversorChallengeOne.application;

import edu.hiikke.ConversorChallengeOne.UI.TerminalInteractor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Description;
import org.springframework.stereotype.Component;

@Component
public class MainApplication {
  TerminalInteractor terminalInteractor;

  @Autowired
  public MainApplication(TerminalInteractor terminalInteractor) {
    this.terminalInteractor = terminalInteractor;
  }

  public void run(){
    terminalInteractor.run();
  }
}