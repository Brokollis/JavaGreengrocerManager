import java.util.ArrayList;

public class Movimentacao {
    public int id;
    public String data;
    public ArrayList<Produto> produtos;
    public ArrayList<Local> locais;
    public String tipo;
    public String quantidade;

    public static ArrayList<Movimentacao> movimentacoes = new ArrayList<>();

    public Movimentacao(
         String data,
         String tipo,
         String quantidade
    ) {
        this.id = this.getNextId();
        this.data;
        this.tipo;
        this.quantidade;
        this.locais= new ArrayList<>();
        this.produtos= new ArrayList<>();
        
        
        movimentacoes.add(this);
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
