package src;
import java.util.Scanner;

public class verdureira {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcao = 0;

        do {
            System.out.println("Digite a operação do menu: ");
            System.out.println("1 - Cadastrar fabricante");
            System.out.println("2 - Listar fabricante");
            System.out.println("3 - Cadastrar produto");
            System.out.println("4 - Listar produtos");
            System.out.println("5 - Cadastrar local de estoque");
            System.out.println("6 - Listar local de estoque");
            System.out.println("7 - Cadastrar movimentação");
            System.out.println("8 - Listar movimentação");

            try {
                opcao = scanner.nextInt();

                switch (opcao) {
                    case 1:
                    cadastrarFabricantes(scanner);
                    break;
                    case 2:
                        listarFabricantes();
                        break;
                    case 3:
                        cadastrarProdutos(scanner);
                        break;
                    case 4:
                        listarProdutos();
                        break;
                    case 5:
                        cadastrarLocalEstoque(scanner);
                        break;
                    case 6:
                        listarlocalestoque();
                        break;
                        case 7:
                        cadastrarMovimentação(scanner);
                        break;
                    case 8:
                        listarMovimentação();
                        break;
                    default:
                        System.out.println("Opção inválida!");
                }
            } catch (Exception e) {
                opcao = 9;
            }

        } while (opcao != 0);
        scanner.close();
    }

    public static void cadastrarFabricantes(Scanner scanner) {
        try {
            System.out.println("Digite o nome do fabricante: ");
            String nome = scanner.next();
            new Fabricante(nome);
        } catch (Exception e) {
            System.out.println("Erro ao cadastrar fabricante!");
        }
    }

    public static void listarFabricantes() {
        for (Fabricante fabricante : Fabricante.fabricantes) {
            System.out.println(
                "Id: " + fabricante.id + "\n"
                + "nome: " + fabricante.nome + "\n"
            );
        }    
    }

    public static void cadastrarProdutos(Scanner scanner) {
        try {
            System.out.println("Digite a descrição do produto: ");
            String descricao = scanner.next();
            System.out.println("Digite o tamanho do produto (g para grande/ m para medio/ p para pequeno): ");
            String tamanho = scanner.next();
            switch(tamanho) {
                case "p":
                    tamanho = "Pequena";
                    break;
                case "m":
                    tamanho = "Média";
                    break;
                case "g":
                    tamanho = "Grande";
                    break;
                default:
                throw new Exception("Tamanho inválido!");
            }
            System.out.println("Digite a cor do produto: ");
            String cor = scanner.next();
            System.out.println("Digite o id do fabricante: ");
            int idFabricante = scanner.nextInt();

           new Produto (descricao, tamanho, cor, Fabricante.verificarId(idFabricante));

        } catch (Exception e){
            System.out.println("Erro ao cadastrar produto!");
        }
    }

    public static void listarProdutos() {
        for (Produto produto : Produto.produtos) {
            System.out.println(
                "Id: " + produto.id + "\n"
                + "Descrição: " + produto.descricao + "\n"
                + "Tamanho: " + produto.tamanho + "\n"
                + "Cor: " + produto.cor + "\n"
                + "Fabricante: " + produto.fabricante.nome + "\n"
            );
        }
    }


    public static void cadastrarLocalEstoque(Scanner scanner) {
        try {
            System.out.println("Digite detalhes do Local: ");
            String detalhes = scanner.next();     
            System.out.println("Digite quantidade do Local: ");
            int quantidadeLoc = scanner.nextInt();  
            System.out.println("Digite o id do produto: ");
            int idProduto = scanner.nextInt();

             new Local(detalhes,quantidadeLoc, Produto.verificarId(idProduto));

        } catch (Exception e) {
            System.out.println("Erro ao cadastrar Local!");
        }
    }

    public static void listarlocalestoque() {
        for (Local local : Local.locais) { 
            System.out.println(
                "Id: " + local.id + "\n"
                + "Detalhes: " + local.detalhes + "\n"    
                + "Produto: " + local.produto.descricao + "\n"    
                + "Quantidade: " + local.quantidade + "\n"

            );

        }
    }

    public static void cadastrarMovimentação(Scanner scanner) {
        try {
            System.out.println("Digite a data da movimentação: ");
            String data = scanner.next();
            System.out.println("Digite o id produto que deseja realizar a movimentação: ");
            int idProduto = scanner.nextInt();
            System.out.println("Digite o id do local onde deseja movimentar o produto: ");
            int idLocal = scanner.nextInt();
            System.out.println("Digite o tipo da movimentação (e para entrada ou s para saida): ");
            String tipo = scanner.next(); 
            switch(tipo) {
                case "e":
                    tipo = "Entrada";
                    break;
                case "s":
                    tipo = "Saida";
                    break;
                default:
                throw new Exception("Movimentação inválido!");
            }  
            System.out.println("Digite a quantidade de produtos que irão ser movimentados: ");
            int quantidadeMov = scanner.nextInt();  

            new Movimentacao(data,Produto.verificarId(idProduto),Local.verificarId(idLocal),tipo,quantidadeMov);
        } catch (Exception e) {
            System.out.println("Erro ao cadastrar movimentação!");
        }
    }

    public static void listarMovimentação() {
        for (Movimentacao movimentacao : Movimentacao.movimentacoes) {
            System.out.println(
                "Id: " + movimentacao.id + "\n"
                + "Data: " + movimentacao.data + "\n"
                + "Produto: " + movimentacao.produto.descricao + "\n"  
                + "Local: " + movimentacao.local.detalhes + "\n" 
                + "Tipo: " + movimentacao.tipo + "\n" 
                + "Quantidade: " + movimentacao.quantidadeMov + "\n" 
            );
        }
    }
}
