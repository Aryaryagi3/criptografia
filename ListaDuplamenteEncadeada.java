public class ListaDuplamenteEncadeada {
    Link head;

    //Inicia a lista atribuindo valor null a head.
    public ListaDuplamenteEncadeada() {
        head = null;
    }

    //Insere um Link na cauda da lista, recebe como argumento um char.
    public void insertTail(char elem) {
        Link link = new Link(elem);

        if(isEmpty()) {
            head = link;
        }
        else {
            Link aux = head;

            while(aux.next != null) {
                aux = aux.next;
            }
            aux.next  = link;
            link.prev = aux;
        }
    }

    //Insere um Link no head da lista, recebe como argumento um char.
    public void insertHead(char elem) {
        Link link = new Link(elem);

        if(isEmpty()){
            head = link;
        }
        else
        {
            Link aux = link;
            aux.next = head;
            head = aux;
        }
    }

    //remove o head atual da lista e troca seu valor pelo valor de next do head removido.
    public void removeHead(){
        if(head.next==null){
            head = null;
        }
        else{
            head = head.next;
            head.prev = null;
        }

    }

    //remove o ultimo Link da cauda
    public void removeTail(){
        Link aux = head;

        if(aux.next==null){
            head = head.next;
        }
        else {
            while(aux.next != null){
                aux = aux.next;
            }
            aux= aux.prev;
            aux.next = null;
        }
    }

    //Retorna os valores em data de cada link da lista.
    public String printList(){
        if(isEmpty()) return "Lista vazia\n";
        String str = "";

        for (Link aux = head; aux != null; aux = aux.next)
            str+= aux.data;
        return str + "\n";
    }

    //Retorna o tamanho da lista.
    public int length() {
        int length = 0;
        Link current = head;
        while(current != null) {
            length ++;
            current = current.next;
        }
        return length;
    }

    //Retorna se a lista ta vazia ou não.
    public boolean isEmpty() {
        return head == null;
    }

    //Deixa a lista vazia.
    public void makeItEmpty() {
        head = null;
    }
}

