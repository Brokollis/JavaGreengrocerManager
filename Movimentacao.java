import java.util.ArrayList;

public class Movimentacao extends Generic{
    public String data;
    public  Produto produto;
    public  Local local;
    public char tipo;
    public int quantidadeMov;

    public static ArrayList<Movimentacao> movimentacoes = new ArrayList<>();

    public Movimentacao(int id,String data,Produto produto,Local local,char tipo,int quantidadeMov){ 
        super.id= id;
        this.data= data;
        this.tipo= tipo;
        this.quantidadeMov= quantidadeMov;
        this.local= local;
        this.produto= produto;
        
        
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

    // private int getNextId() {
    //     int id = 0;

    //     for (Movimentacao movimentacao : movimentacoes) {
    //         if (movimentacao.id > id) {
    //             id = movimentacao.id;
    //         }
    //     }
         
    //     return id + 1;

    // }
}
