import java.util.ArrayList;

public class Produto {
    public int id;
    public String descricao;
    public String tamanho;
    public String cor;
    public Fabricante fabricante;
    public ArrayList<Fabricante> fabricantes;
    public ArrayList<Local> locais;
    public ArrayList<Movimentacao> movimentacoes;

    public static ArrayList<Produto> produtos = new ArrayList<>();

    public Produto(
        String descricao,
        String tamanho,
        String cor,
        Fabricante fabricante
    ) {
        this.id= this.getNextId();
        this.descricao = descricao;
        this.tamanho = tamanho;
        this.cor = cor;
        this.fabricante = fabricante;
        this.fabricantes = new ArrayList<>();
        this.locais = new ArrayList<>();
        this.movimentacoes = new ArrayList<>();

        
        produtos.add(this);
        fabricante.produtos.add(this);
    }

    public static Produto verificarId(int id) throws Exception {
        for (Produto produto : produtos) {
            if (produto.id == id) {
                return produto;
            }
        }
        throw new Exception("Produto não existe");
    }

    private int getNextId() {
        int id = 0;

        for (Produto produto : produtos) {
            if (produto.id > id) {
                id = produto.id;
            }
        }
        
        return id + 1;

    } 
}
