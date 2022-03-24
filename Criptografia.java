import java.util.Scanner;

public class Criptografia {
    private Scanner scanner;
    private ListaDuplamenteEncadeada listA, listB, listAux;
    private int k = 0;

    //Construtor que cria objetos essenciais na execução do programa.
    public Criptografia() {
        scanner = new Scanner(System.in);
        listA = new ListaDuplamenteEncadeada();
        listB = new ListaDuplamenteEncadeada();
        listAux = new ListaDuplamenteEncadeada();
    }

    //Esse método executa o programa de acordo com o que o usuário inserir, utiliza-se um scanner para obter essas informações.
    public void start() {
        int e = 0;

        while (e != 2) {
            System.out.println("Digite 0 para encriptar uma mensagem, 1 para decriptar uma mensagem ou 2 para sair do programa:");
            e = scanner.nextInt();

            if (e == 0) {
                System.out.println("Insira a mensagem a ser encriptada:");
                entradaString();

                System.out.println("Insira a chave simétrica a ser utilizada na encriptação da mensagem:");
                entradaK();
                encriptar();

                System.out.println("Tamanho da mensagem de entrada: " + listA.length());
                System.out.println("Tamanho da mensagem encriptada: " + listB.length());
                System.out.println("Mensagem encriptada: " + listB.printList());
            }

            if (e == 1) {
                System.out.println("Insira a mensagem a ser decriptada:");
                entradaString();

                System.out.println("Insira a chave simétrica a ser utilizada na decriptação da mensagem:");
                entradaK();
                decriptar();

                System.out.println("Tamanho da mensagem de entrada: " + listA.length());
                System.out.println("Tamanho da mensagem decriptada: " + listB.length());
                System.out.println("Mensagem decriptada: " + listB.printList());

            }
            listA.makeItEmpty();
            listB.makeItEmpty();
            listAux.makeItEmpty();
        }
    }

    //Método que usa scanner para receber a mensagem a ser encriptada ou decriptada.
    public void entradaString() {
        scanner.nextLine();
        String s = scanner.nextLine();

        if (!listA.isEmpty())
            listA.removeHead();

        for (int i = 0; i < s.length(); i++) {
            int a = (int) s.charAt(i);

            if (a >= 97 && a <= 122 || a == 32 || a == 44 || a == 46 || a == 59 || a == 58 || a == 33 || a == 63 || a == 45)
                listA.insertTail(s.charAt(i));
        }
    }

    //Mensagem que usa scanner para receber a chave simétrica para ser utilizado na encriptação ou decriptação da mensagem.
    public void entradaK() {
        k = scanner.nextInt();
        while (k > 26) {
            k = k - 26;
        }
    }

    //Método responsável pela encriptação da mensagem inserida.
    public void encriptar() {
        Link aux = listA.head;
        int sizeA = listA.length();

        for (int i = 0; i < sizeA; i++) {
            int a = (int) aux.data;

            if (a == 32) {
                itAux('w');
                itAux('b');
                itAux('r');
                itAux('w');
            } else if (a == 44) {
                itAux('w');
                itAux('v');
                itAux('r');
                itAux('w');
            } else if (a == 46) {
                itAux('w');
                itAux('p');
                itAux('t');
                itAux('w');
            } else if (a == 59) {
                itAux('w');
                itAux('p');
                itAux('v');
                itAux('w');
            } else if (a == 58) {
                itAux('w');
                itAux('d');
                itAux('p');
                itAux('w');
            } else if (a == 33) {
                itAux('w');
                itAux('e');
                itAux('x');
                itAux('w');
            } else if (a == 63) {
                itAux('w');
                itAux('i');
                itAux('n');
                itAux('w');
            } else if (a == 45) {
                itAux('w');
                itAux('h');
                itAux('f');
                itAux('w');
            } else {
                itAux(aux.data);
            }

            if (aux.next != null)
                aux = aux.next;
        }

        Link aux2 = listAux.head;

        for (int i = 0; i < listAux.length(); i++) {

            int a = (int) aux2.data;

            if (a + k > 122) {
                int u = (a + k) - 122;
                it((char) (96 + u));
            } else {
                it((char) (a + k));
            }

            if (aux2.next != null)
                aux2 = aux2.next;
        }
    }

    //Método responsável pela decriptação da mensagem inserida.
    public void decriptar() {
        Link aux = listA.head;
        int a = 0;

        for (int i = 0; i < listA.length(); i++) {
            a = (int) aux.data;

            if ((a - k) < 97) {
                int u = 97 - (a - k);
                itAux((char) (123 - u));
            } else {
                itAux((char) (a - k));
            }
            if (aux.next != null)
                aux = aux.next;
        }
        Link aux2 = listAux.head;
        int sizeA = listAux.length(), sizeR = sizeA, b = 0, c = 0, d = 0;

        for (int i = 0; i < sizeA; i++) {
            if (sizeR >= 4) {
                b = (int) aux2.next.data;
                c = (int) aux2.next.next.data;
                d = (int) aux2.next.next.next.data;
            }
            a = (int) aux2.data;

            if (a == 119) {
                if (d == 119) {
                    if (b == 98) {
                        if (c == 114) {
                            it(' ');
                            i = i + 3;
                            aux2 = aux2.next.next.next;
                            sizeR = sizeR - 3;
                        }
                    } else if (b == 118) {
                        if (c == 114) {
                            it(',');
                            i = i + 3;
                            aux2 = aux2.next.next.next;
                            sizeR = sizeR - 3;
                        }
                    } else if (b == 112) {
                        if (c == 116) {
                            it('.');
                            i = i + 3;
                            aux2 = aux2.next.next.next;
                            sizeR = sizeR - 3;
                        }
                        if (c == 118) {
                            it(';');
                            i = i + 3;
                            aux2 = aux2.next.next.next;
                            sizeR = sizeR - 3;
                        }
                    } else if (b == 100) {
                        if (c == 112) {
                            it(':');
                            i = i + 3;
                            aux2 = aux2.next.next.next;
                            sizeR = sizeR - 3;
                        }
                    } else if (b == 101) {
                        if (c == 120) {
                            it('!');
                            i = i + 3;
                            aux2 = aux2.next.next.next;
                            sizeR = sizeR - 3;
                        }
                    } else if (b == 105) {
                        if (c == 110) {
                            it('?');
                            i = i + 3;
                            aux2 = aux2.next.next.next;
                            sizeR = sizeR - 3;
                        }
                    } else if (b == 104) {
                        if (c == 102) {
                            it('-');
                            i = i + 3;
                            aux2 = aux2.next.next.next;
                            sizeR = sizeR - 3;
                        }
                    }
                }
            } else{
                it(aux2.data);
            }

            sizeR--;
            if (aux2.next != null)
                aux2 = aux2.next;
        }
    }

    //Método criado para melhorar a legibilidade e evitar um pouco a repetição de código, insere um elemento na cauda de ListB, recebe um char como argumento.
    public void it(char elem) {
        listB.insertTail(elem);
    }

    //Método criado para melhorar a legibilidade e evitar um pouco a repetição de código, insere um elemento na cauda de ListAux, recebe um char como argumento.
    public void itAux(char elem) {
        listAux.insertTail(elem);
    }
}