import java.util.LinkedList;

public class Vertice {//bar
    public int id;
    public String cor;
    public LinkedList<Vertice> adj;
    public boolean colorido;

    public Vertice(int id){
        this.id = id;
        this.adj = new LinkedList<Vertice>();
        this.colorido = false;
    }
}
