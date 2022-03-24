public class Link {
    public Link prev;
    public Link next;
    public char data;

    //Construtor que cria Link, recebe como argumento um char que sera armazenado em data.
    public Link (char data){
        this.data = data;
        prev = null;
        next = null;
    }
}

