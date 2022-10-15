import java.util.Scanner;

public class verdureira {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcao = 0;

        do {
            System.out.println("Digite a operação do menu: ");
            System.out.println("1 - Cadastrar produto");
            System.out.println("2 - Listar produtos");
            System.out.println("3 - Cadastrar fabricante");
            System.out.println("4 - Listar fabricante");
            System.out.println("5 - Cadastrar local de estoque");
            System.out.println("6 - Listar local de estoque");
            System.out.println("7 - Cadastrar movimentação");
            System.out.println("8 - Listar movimentação");

            try {
                opcao = scanner.nextInt();

                switch (opcao) {
                    case 1:
                        cadastrarProdutos(scanner);
                        break;
                    case 2:
                        listarProdutos();
                        break;
                    case 3:
                        cadastrarFabricantes(scanner);
                        break;
                    case 4:
                        listarFabricantes();
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

    public static void cadastrarProdutos(Scanner scanner) {
        try {
            System.out.println("Digite a descrição do produto: ");
            String descricao = scanner.next();
            System.out.println("Digite o tamanho do produto (grande, medio e ou pequeno): ");
            String tamanho = scanner.next();
            switch(tamanho) {
                case "P":
                    tamanho = "Pequena";
                    break;
                case "M":
                    tamanho = "Média";
                    break;
                case "G":
                    tamanho = "Grande";
                    break;
                default:
                throw new Exception("Tamanho inválido!");
            }
            System.out.println("Digite a cor do produto: ");
            String cor = scanner.next();

            new Produto(descricao, tamanho, cor);
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
            );
        }
    }

    public static void cadastrarFabricantes(Scanner scanner) {
        try {
            System.out.println("Digite o id do fabricante: ");
            int id = scanner.nextInt();
            System.out.println("Digite o nome do fabricante: ");
            String nome = scanner.next();
            new Fabricante(id,nome);
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

    public static void cadastrarLocalEstoque(Scanner scanner) {
        try {
            System.out.println("Digite id do Local: ");
            int id = scanner.nextInt();
            System.out.println("Digite quantidade do Local: ");
            int quantidade = scanner.nextInt();
            System.out.println("Digite detalhes do Local: ");
            int detalhes = scanner.nextInt();       

             new Local(id,quantidade,detalhes));

        } catch (Exception e) {
            System.out.println("Erro ao cadastrar Local!");
        }
    }

    public static void listarlocalestoque() {
        for (Local local : Local.locais) {
            System.out.println(
                "Id: " + local.id + "\n"
                + "Quantidade: " + local.quantidade + "\n"
                + "Detalhes: " + local.detalhes + "\n"    
            );

        }
    }

    public static void cadastrarMovimentação(Scanner scanner) {
        try {
            System.out.println("Digite id da movimentação: ");
            int id = scanner.nextInt();
            System.out.println("Digite a data da movimentação: ");
           String data = scanner.next();
            System.out.println("Digite o tipo da movimentação: ");
            char detalhes = scanner.next(); 
            for  
            System.out.println("Digite a quantidade da movimentação: ");
            int quantidadeMov = scanner.nextInt();  

            new Movimentacao(id, data,detalhes,quantidadeMov);
        } catch (Exception e) {
            System.out.println("Erro ao cadastrar movimentação!");
        }
    }

    public static void listarMovimentação() {
        for (Movimentacao movimentacao : Movimentacao.movimentacoes) {
            System.out.println(
                "Id: " + movimentacao.id + "\n"
                + "Data: " + movimentacao.data + "\n"
                + "Detalhes: " + movimentacao.detalhes + "\n"  
                + "Quantidade: " + movimentacao.quantidadeMov + "\n" 
            );
        }
    }
    foreach(Produto produto : Produto.produtos){
        System.out.println(produto.id);
    }
}
