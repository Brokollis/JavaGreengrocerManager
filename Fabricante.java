import java.util.ArrayList;

public class Fabricante extends Generic {
    public String nome;

    public static ArrayList<Fabricante> fabricantes = new ArrayList<>();

    public Fabricante(
         int id,
         String nome
    ) {
        super.id= id;
        this.nome = nome;
        
        fabricantes.add(this);
    }

    public static Fabricante verificarId(int id) throws Exception {
        for (Fabricante fabricante : fabricantes) {
            if (fabricante.id == id) {
                return fabricante;
            }
        }
        throw new Exception("Produto não existe");
    }

    // private int getNextId() {
    //     int id = 0;

    //     for (Fabricante fabricante : fabricantes) {
    //         if (fabricante.id > id) {
    //             id = fabricante.id;
    //         }
    //     }
        
    //     return id + 1;

    // } 
}
