/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;
import DAO.PassageiroDAO;
import DAO.UsuarioDAO;
import java.util.Scanner;


public class Administrador extends Usuario{
    String cpf;
    public Administrador(String nome,String email,String senha,String telefone,String grupo){
        super(nome,email,senha,telefone,grupo);
    }

    public void menuGerenciarUsuarios(){
        Scanner listening = new Scanner(System.in);
        System.out.println("---------------------------------------------");
        System.out.println("|            GERENCIAR USUARIOS              |");
        System.out.println("---------------------------------------------");
        System.out.println("1. Cadastrar Usuário");
        System.out.println("2. Alterar dados do Usuário");
        System.out.println("3. Excluir Usuário");
        System.out.println("4. Listar Usuários");
        System.out.println("0. Voltar para o Menu de gerenciamento.");
        System.out.println("---------------------------------------------");
        int resposta = 5;
        while(resposta == 5){
        System.out.print("Escolha uma das opçoes: ");
        resposta = listening.nextInt();
        switch(resposta){
            case 1:
                cadastroUsuario();
                break;
            case 2:
                alterandoUsuario();
                break;
            case 3:
                exclusaoUsuario();
                break;
            case 4:
                listandousuarios();
                break;
            case 0:
                new Usuario("","","","","").exibirMenuAdministrador();
                break;
            default:
                resposta = 5;
                System.out.println("Numero escolhido nao é uma opçao!");   
            }
        menuGerenciarUsuarios();
        }
    }
    private void cadastroUsuario(){
        
        Usuario usuario = coletandoDados();
        sanitizarUsuario(usuario);
    }
    private void exclusaoUsuario(){
        
        Scanner listening2 = new Scanner(System.in);
        String email = "";
        while(email.equals("")){
        System.out.print("Digite o email do usuario que deseja Excluir: ");
            email = listening2.next();
        if(!"".equals(email)){
        new UsuarioDAO().excluirUsuario(email);}
        else{
            System.out.print("Digite um Email valido.");
            }
        }   
    }
    private void alterandoUsuario(){
        Scanner list = new Scanner(System.in);
        System.out.println("Digite o email do usuario que deseja alterar os dados: ");
        String emailReferencia = list.nextLine();
        Usuario usuario = coletandoDados();
        new UsuarioDAO().alterarDadosUsuario(usuario, emailReferencia);
    }
    private void listandousuarios(){
        Scanner listeningg = new Scanner(System.in);
        System.out.print("Digite o email para pesquisar dados de um usuario em expecifico, ou \"TODOS\" para listar todos os usuarios existentes: ");
        String resposta = listeningg.nextLine();
        if(resposta.equals("TODOS")){
            new UsuarioDAO().listarDadosDeTodosUsuarios();
        }else{
            new UsuarioDAO().listarDadosDeUmUsuario(resposta);
        }
        
    }
    //-----------------------------------------------------------------------------------------------------------------------------
    //-----------------------------------------------------------------------------------------------------------------------------
    //-----------------------------------------------------------------------------------------------------------------------------
    //-----------------------------------------------------------------------------------------------------------------------------
    //-----------------------------------------------------------------------------------------------------------------------------

    public void menuGerenciarOnibus(){
        Scanner listening = new Scanner(System.in);
        System.out.println("---------------------------------------------");
        System.out.println("|             GERENCIAR ONIBUS               |");
        System.out.println("---------------------------------------------");
        System.out.println("1. Cadastrar Onibus");
        System.out.println("2. Alterar dados do Onibus");
        System.out.println("3. Excluir Onibus");
        System.out.println("4. Listar Onibus");
        System.out.println("0. Voltar para o Menu de gerenciamento.");
        System.out.println("---------------------------------------------");
        int resposta = 5;
        while(resposta == 5){
        System.out.print("Escolha uma das opçoes: ");
        resposta = listening.nextInt();
        switch(resposta){
            case 1:
                Onibus.cadastroOnibus();
                break;
            case 2:
                Onibus.alterandoOnibus();
                break;
            case 3:
                Onibus.exclusaoOnibus();
                break;
            case 4:
                Onibus.listandoOnibus();
                break;
            case 0:
                new Usuario("","","","","").exibirMenuAdministrador();
                break;
            default:
                resposta = 5;
                System.out.println("Numero escolhido nao é uma opçao!");   
            }
        menuGerenciarOnibus();
        }
    }
    //-----------------------------------------------------------------------------------------------------------------------------
    //-----------------------------------------------------------------------------------------------------------------------------
    //-----------------------------------------------------------------------------------------------------------------------------
    //-----------------------------------------------------------------------------------------------------------------------------
    //-----------------------------------------------------------------------------------------------------------------------------

    public void menuGerenciarViagens(){
        Scanner listening = new Scanner(System.in);
        System.out.println("---------------------------------------------");
        System.out.println("|            GERENCIAR VIAGENS               |");
        System.out.println("---------------------------------------------");
        System.out.println("1. Cadastrar Viagem");
        System.out.println("2. Alterar dados do Viagem");
        System.out.println("3. Excluir Viagem");
        System.out.println("4. Listar Viagem");
        System.out.println("0. Voltar para o Menu de gerenciamento.");
        System.out.println("---------------------------------------------");
        int resposta = 5;
        while(resposta == 5){
        System.out.print("Escolha uma das opçoes: ");
        resposta = listening.nextInt();
        switch(resposta){
            case 1:
                Viagem.cadastroViagem();
                break;
            case 2:
                Viagem.alterandoDadosViagem();
                break;
            case 3:
                Viagem.exclusaoViagem();
                break;
            case 4:
                Viagem.listandoViagem();
                break;
            case 0:
                new Usuario("","","","","").exibirMenuAdministrador();
                break;
            default:
                resposta = 5;
                System.out.println("Numero escolhido nao é uma opçao!");   
            }
        menuGerenciarViagens();
        }
    }
    //-----------------------------------------------------------------------------------------------------------------------------
    //-----------------------------------------------------------------------------------------------------------------------------
    //-----------------------------------------------------------------------------------------------------------------------------
    //-----------------------------------------------------------------------------------------------------------------------------
    //-----------------------------------------------------------------------------------------------------------------------------

    public static void menuGerenciarPassageiros(){
        Scanner listening = new Scanner(System.in);
        System.out.println("---------------------------------------------");
        System.out.println("|           GERENCIAR PASSAGEIRO             |");
        System.out.println("---------------------------------------------");
        System.out.println("1. Cadastrar Passageiro");
        System.out.println("2. Alterar dados do Passageiro");
        System.out.println("3. Excluir Passageiro");
        System.out.println("4. Listar Passageiro");
        System.out.println("0. Voltar para o Menu de gerenciamento.");
        System.out.println("---------------------------------------------");
        int resposta = 5;
        while(resposta == 5){
        System.out.print("Escolha uma das opçoes: ");
        resposta = listening.nextInt();
        switch(resposta){
            case 1:
                PassageiroDAO.cadastrarPassageiro();
                break;
            case 2:
                Passageiro.alterandoDadosPassageiro();
                break;
            case 3:
                Passageiro.exclusaoPassageiro();
                break;
            case 4:
                Passageiro.listandoPassageiro();
                break;
            case 0:
                new Usuario("","","","","").exibirMenuAdministrador();
                break;
            default:
                resposta = 5;
                System.out.println("Numero escolhido nao é uma opçao!");   
            }
        menuGerenciarPassageiros();
        }
    }
    
    //-----------------------------------------------------------------------------------------------------------------------------
    //-----------------------------------------------------------------------------------------------------------------------------
    //-----------------------------------------------------------------------------------------------------------------------------
    //-----------------------------------------------------------------------------------------------------------------------------
    //-----------------------------------------------------------------------------------------------------------------------------

    private void sanitizarUsuario(Usuario u){
        boolean sanitizado = false;

        while(sanitizado == false){
            if (u.getNome() == null || u.getNome().isEmpty() ||
                u.getEmail() == null || u.getEmail().isEmpty() ||
                u.getSenha() == null || u.getSenha().isEmpty() ||
                u.getTelefone() == null || u.getTelefone().isEmpty() ||
                u.getGrupo() == null || u.getGrupo().isEmpty() ||
                cpf == null || cpf.isEmpty()) {
                    System.out.println("=============================================================================");
                    System.out.println("Os dados solicitados para cadastro estão incompletos!!!");
                    System.out.println("Tente novamente,cadastrar usuario.");
                    System.out.println("=============================================================================");
                    cadastroUsuario();
                    break;
            }else{
                new UsuarioDAO().cadastrarUsuario(u);
                sanitizado = true;
                break;
                
                
            }
        }
    }
    
    //==============================================================================================
    //==============================================================================================
    //==============================================================================================
    //==============================================================================================
    
    public Usuario coletandoDados(){
        Scanner listening = new Scanner(System.in);
        
        System.out.print("Digite o nome do usuario:");
        String nome = listening.nextLine();
        System.out.print("Digite o email do usuario:");
        String email = listening.next();
        System.out.print("Digite a senha do usuario:");
        String senha = listening.next();
        System.out.print("Digite o telefone do usuario:");
        String telefone = listening.next();
        System.out.print("Digite o grupo do usuario:");
        String grupo = listening.next();
        System.out.print("Digite o cpf do usuario:");
        cpf = listening.next();
        
        Usuario usuario = new Usuario(nome,email,senha,telefone,grupo);
        
        return usuario;
    }
}
