import java.util.ArrayList;

public class Movimentacao extends Generic{
    public String data;
    public Produto produto;
    public Local local;
    public String tipo;
    public int quantidadeMov;
    public ArrayList<Produto> produtos;
    public ArrayList<Local> locais;


    public static ArrayList<Movimentacao> movimentacoes = new ArrayList<>();

    public Movimentacao(
        int id,
        String data,
        Produto produto,
        Local local,
        String tipo,
        int quantidadeMov) 
        {
        this.id = this.getNextId();
        this.data= data;
        this.produto = produto;
        this.local = local;
        this.tipo= tipo;
        this.quantidadeMov= quantidadeMov;
        this.produtos =  new ArrayList<>();
        this.locais = new ArrayList<>();

        
        movimentacoes.add(this);
        produto.movimentacoes.add(this);
        local.movimentacoes.add(this);
    }
       

    public static Movimentacao verificarId(int id) throws Exception {
        for (Movimentacao movimentacao : movimentacoes) {
            if (movimentacao.id == id) {
                return movimentacao;
            }
        }
        throw new Exception("Produto não existe");
    }

    private int getNextId() {
        int id = 0;

        for (Movimentacao movimentacao : movimentacoes) {
            if (movimentacao.id > id) {
                id = movimentacao.id;
            }
        }
         
        return id + 1;

    }
}
