import java.util.ArrayList;

public class Local {
    public int id;
    public String detalhes;
    public int quantidade;
    public Produto produto;
    public ArrayList<Produto> produtos;
    public ArrayList<Movimentacao> movimentacoes;

    public static ArrayList<Local> locais = new ArrayList<>();

    public Local( 
         String detalhes,
         int quantidade,
         Produto produto
    ) {
        this.id = this.getNextId();
        this.detalhes = detalhes;
        this.quantidade = quantidade;
        this.produto = produto;
        this.produtos = new ArrayList<>();
        this.movimentacoes = new ArrayList<>();
        
        locais.add(this);
        produto.locais.add(this);
    }

    public static Local verificarId(int id) throws Exception {
        for (Local local : locais) {
            if (local.id == id) {
                return local;
            }
        }
        throw new Exception("Local não existe");
    }

    private int getNextId() {
        int id = 0;

        for (Local local : locais) {
            if (local.id > id) {
                id = local.id;
            }
        }
        
        return id + 1;

    } 
}
