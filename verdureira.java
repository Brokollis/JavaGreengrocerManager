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
            System.out.println("Digite a cor do produto: ");
            String cor = scanner.next();

            new Produto(descricao, tamanho, cor);
        } catch (Exception e) {
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

    public static void cadastrarLocalEstoque(Scanner scanner) {
        try {
            System.out.println("Digite o ID do cliente: ");
            int idCliente = scanner.nextInt();
            System.out.println("Digite o numero da comanda: ");
            int numero = scanner.nextInt();
            System.out.println("Digite a data da comanda: ");
            String data = scanner.next();

            Comanda comanda = new Comanda(numero, data, Cliente.verificarId(idCliente));

            System.out.println("Digite a quantidade pizzas: ");
            int quantidade = scanner.nextInt();

            for (int i = 0; i < quantidade; i++) {
                System.out.println("Digite o tamanho da pizza: ");
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
                System.out.println("Digite o ID do sabor: ");
                int idSabor = scanner.nextInt();

                new Pizza(tamanho, Sabor.verificarId(idSabor), comanda);
            }
            
        } catch (Exception e) {
            System.out.println("Erro ao cadastrar comanda!");
        }
    }

    public static void listarlocalestoque() {
        for (Comanda comanda : Comanda.comandas) {
            System.out.println(
                "Id: " + comanda.id + "\n"
                + "Numero: " + comanda.numero + "\n"
                + "Data: " + comanda.data + "\n"
                + "Cliente: " + comanda.cliente.nome + "\n"
            );

            for (Pizza pizza : Pizza.pizzas) {
                if (pizza.comanda.id == comanda.id) {
                    System.out.println(
                        "  Id Pizza: " + pizza.id + "\n"
                        + " Tamanho: " + pizza.tamanho + "\n"
                        + " Sabor: " + pizza.sabor.descricao + "\n"
                    );
                }
            }
        }
    }
}
