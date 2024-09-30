/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.sql.SQLException;
import java.util.Scanner;

/**
 *
 * @author Pedro
 */
public class Main {
    public static void main(String[] args) throws SQLException {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite seu nome...: ");
        String nomeInput = scanner.nextLine();

        System.out.print("Digite sua senha..: ");
        String senhaInput = scanner.nextLine();

        Usuario usuario = Usuario.logar(nomeInput, senhaInput);

        if (usuario != null) {
            System.out.println("Login bem-sucedido!");
            usuario.exibirMenu();
        } else {
            System.out.println("Nome ou senha incorretos.");
        }

        scanner.close();
    }
}
