package com.colini.controllers;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.function.UnaryOperator;

import javafx.beans.property.ReadOnlyIntegerProperty;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import com.colini.models.Aluno;

public class telaCadastroController {

    @FXML
    private Button btnRegistrar;

    @FXML
    private Pane paneTela;

    @FXML
    private Text textTextoCadastro;

    @FXML
    private TextField textfieldCPF;

    @FXML
    private TextField textfieldEmail;

    @FXML
    private TextField textfieldNascimento;

    @FXML
    private TextField textfieldNome;

    Aluno aluno;
    String caminho = "src/main/java/com/colini/arquivo-de-texto.txt";

    public void initialize() {

        // Configurando o TextFormatter para aceitar apenas números
        UnaryOperator<TextFormatter.Change> filter = change -> {
            String newText = change.getControlNewText();
            if (newText.matches("\\d*")) { // Aceita apenas dígitos
                return change;
            }
            return null; // Ignora a mudança
        };
        TextFormatter<String> textFormatter = new TextFormatter<>(filter);
        textfieldCPF.setTextFormatter(textFormatter);

    }

    public void escreveArquivo(Aluno aluno) {

        try {

            // FileReader file = new FileReader(caminho);
            FileWriter fileWriter = new FileWriter(caminho, true);
            fileWriter.write(aluno.getNome() + "\n");
            fileWriter.write(aluno.getNascimento() + "\n");
            fileWriter.write(aluno.getCpf() + "\n");
            fileWriter.write(aluno.getEmail() + "\n");
            fileWriter.write(";" + "\n");

            fileWriter.close();
        } catch (Exception e) {
            System.out.println("Ocorreu um Erro: " + e.getMessage());
        } finally {
            // fileWriter.close();
        }
    }

    public void cadastrarDados() {

        String nomeAluno = textfieldNome.getText();
        String nascimentoAluno = textfieldNascimento.getText();
        String cpfAlunoTexto = textfieldCPF.getText();
        Integer cpfAlunoNumero = Integer.parseInt(cpfAlunoTexto);
        String emailAluno = textfieldEmail.getText();

        aluno = new Aluno(nomeAluno, nascimentoAluno, cpfAlunoNumero, emailAluno);
        escreveArquivo(aluno);

    }

}
