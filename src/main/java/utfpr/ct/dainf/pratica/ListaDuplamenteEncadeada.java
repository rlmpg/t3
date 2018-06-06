package utfpr.ct.dainf.pratica;

import java.util.Comparator;
import java.util.Iterator;
import java.util.Objects;

/**
 * Implementação de uma lista encadeada simples.
 * @author Wilson Horstmeyer Bogado <wilson@utfpr.edu.br>
 * @param <E> O tipo do elemento armazenado na lista encadeada
 */
public class ListaDuplamenteEncadeada<E> implements Iterable<E> {
    protected No<E> inicio;
    protected No<E> fim;
    protected Comparator<E> comparador;

    /**
     * Retorna {@code true} se a lista estiver vazia.
     * Uma lista é considerada vazia quanto tanto {@code inicio} quanto {@code fim}
     * são nulos.
     * @return {@code true} se a lista estiver vazia
     */
    public boolean isVazia() {
        throw new UnsupportedOperationException("Não implementado");
    }

    /**
     * Insere um valor no início da lista.
     * Este método cria um novo nó e este para a ocupar o início da lista.
     * @param valor O valor a ser inserido
     * @return A própria lista
     */
    public ListaDuplamenteEncadeada<E> insereInicio(E valor) {
        throw new UnsupportedOperationException("Não implementado");
    }
    
    /**
     * Verifica se a lista contém um determinado valor.
     * Executa uma pesquisa linear.
     * @param valor O valor procurado
     * @return {@code true} se o valor estiver na lista
     */
    public boolean contem(E valor) {
        throw new UnsupportedOperationException("Não implementado");
    }
    
    /**
     * Remove o nó final da lista e retorna o respectivo valor.
     * Lança uma exceção não verificada se a lista estiver vazia.
     * @return O valor armazenado no fim da lista
     */
    public E removeFim() {
        throw new UnsupportedOperationException("Não implementado");
    }
    
    /**
     * Remove o nó da lista contendo o valor especificado.
     * Caso haja mais de um nó com este valor, remove a primeira ocorrência.
     * Caso o valor não seja encontrado na lista, lança uma exceção não
     * verificada.
     * @param valor O valor a ser removido
     */
    public void remove(E valor) {
        throw new UnsupportedOperationException("Não implementado");
    }
    
    /**
     * Insere o valor especificado na lista ordenada.
     * Usa o comparador para determinar a posição do nó.
     * @param valor O valor a ser inserido
     * @return A própria lista
     */
    public ListaDuplamenteEncadeada<E> insereComparador(E valor) {
        throw new UnsupportedOperationException("Não implementado");
    }
    
    /**
     * Ordena os elementos da lista em ordem ascendente.
     * Utiliza o algoritmo bubble sort.
     * Usa o comparador especificado para estabelecer a ordem.
     */
    protected void ordenaComparador() {
        throw new UnsupportedOperationException("Não implementado");
    }

    /**
     * Retorna um iterador que permite percorrer a lista do inicio ao fim.
     * @return O iterador para esta lista
     */
    @Override
    public Iterator<E> iterator() {
        throw new UnsupportedOperationException("Não implementado");
    }
    
    /**
     * Classe interna que implementa um iterador para a lista encadeada.
     * @param <E> O tipo do elemento da lista
     */
    // implemente o seu iterador aqui 


    
    // QUALQUER ALTERAÇÃO DO CÓDIGO ABAIXO SERÁ POR SUA PRÓPRIA CONTA E RISCO!
    /**
     * Cria uma lista encadeada vazia
     */
    public ListaDuplamenteEncadeada() {
    }

    /**
     * Retorna o comparador usado para inserção ordenada e ordenação dos
     * elementos da lista.
     * @return O comparador
     */
    public Comparator<E> getComparador() {
        return comparador;
    }
    
    /**
     * Inicializa o comparador usado para inserção ordenada e ordenação dos
     * elementos da lista.
     * @param comparador O comparador
     */
    public void setComparador(Comparator<E> comparador) {
        this.comparador = comparador;
    }
    
    /**
     * Insere um valor no fim da lista.
     * Este método cria um novo nó e este passa a ocupar o fim da lista.
     * @param valor O valor a ser inserido
     * @return A própria lista
     */
    public ListaDuplamenteEncadeada<E> insere(E valor) {
        No<E> no = new No<>(valor);
        if (isVazia()) {
            inicio = fim = no;
        } else {
            fim.proximo = no;
            no.anterior = fim;
            fim = no;
        }
        return this;
    }

    /**
     * Insere um valor no fim da lista.
     * Este método cria um novo nó e este passa a ocupar o fim da lista.
     * @param valor O valor a ser inserido
     * @return A própria lista
     */
    public ListaDuplamenteEncadeada<E> insereFim(E valor) {
        return insere(valor);
    }

    /**
     * Insere o valor especificado na lista ordenada.
     * O valor a ser inserido é coparável, portanto, usa a ordem especificada
     * pela própria classe do valor.
     * @param valor O valor comparável a ser inserido
     * @return A própria lista
     */
    public ListaDuplamenteEncadeada<E> insereComparavel(Comparable<E> valor) {
        No<E> no = inicio;
        while (no != null && valor.compareTo(no.valor) > 0) {
            no = no.proximo;
        }
        if (no == null)
            insereFim((E)valor);
        else {
            No<E> novo = new No<>((E)valor);
            novo.anterior = no.anterior;
            novo.proximo = no;
            if (no.anterior == null)
                inicio = novo;
            else
                no.anterior.proximo = novo;
            no.anterior = novo;
        }
        return this;
    }
    
    /**
     * Insere o valor especificado na lista ordenada.
     * Caso o comparador esteja definido, usa o comparador, caso contrário
     * o valor deve ser comparável ou uma exceção será lançada.
     * @param valor O valor a ser inserido
     * @return A própria lista
     */
    public ListaDuplamenteEncadeada<E> insereOrdem(E valor) {
        if (comparador !=  null)
            insereComparador(valor);
        else 
            insereComparavel((Comparable<E>) valor);
        return this;
    }
    
    /**
     * Remove o nó inicial da lista e retorna o respectivo valor.
     * Lança uma exceção não verificada se a lista estiver vazia.
     * @return O valor armazenado no início da lista
     */
    public E removeInicio() {
        E valor;
        if (isVazia())
            throw new RuntimeException("Remove início: lista vazia");
        else {
            valor = inicio.valor;
            inicio = inicio.proximo;
            if (inicio == null) fim = null;
        }
        return valor;
    }
    
    /**
     * Troca os valores dos nós x e y na lista.
     * O inicio e o fim da lista são ajustados caso a troca envolva
     * algum destes nós.
     * @param x O mó a ser trocado pelo nó y
     * @param y O nó a ser trocado pelo nó x
     */
    protected void troca(No<E> x, No<E> y) {
        E temp = x.valor;
        x.valor = y.valor;
        y.valor = temp;
    }
    
    /**
     * Ordena os elementos da lista em ordem ascendente.
     * Assume que os elementos da lista são comparáveis e com tipos consistentes.
     * Lança uma exceção não verificada caso encontre um valor não comparável.
     */
    protected void ordenaComparavel() {
        No<E> no;
        No<E> ultimo = fim;
        
        boolean continua;
        do {
            continua = false;
            no = inicio;
            while (no != ultimo) {
                Comparable<E> v = (Comparable<E>) no.valor;
                if (v.compareTo(no.proximo.valor) > 0) {
                    troca(no, no.proximo);
                    continua = true;
                }
                no = no.proximo;
            }
            ultimo = ultimo.anterior;
        } while (continua);        
    }
    
    /**
     * Ordena os elementos da lista em ordem ascendente.
     * Usa o comparador, caso não haja comparador definido, assume que os valores
     * na lista comparáveis.
     * Lança uma exceção não verificada caso encontre um valor não comparável.
     */
    public void ordena() {
        if (comparador != null)
            ordenaComparador();
        else
            ordenaComparavel();
    }

    /**
     * Retorna uma representação textual da lista encadeada.
     * @return Uma representação textual da lista
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[ ");
        No<E> no = inicio;
        while (no != null) {
            sb.append(no).append(' ');
            no = no.proximo;
        }
        sb.append(']');
        return sb.toString();
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + Objects.hashCode(this.inicio);
        hash = 29 * hash + Objects.hashCode(this.fim);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        boolean equal = obj instanceof ListaDuplamenteEncadeada;
        ListaDuplamenteEncadeada<E> lista;
        if (equal)
            lista = (ListaDuplamenteEncadeada<E>) obj;
        else
            return equal;
        No<E> no1 = inicio;
        No<E> no2 = lista.inicio;
        while (equal && no1 != null && no2 != null) {
            equal = no1.valor.equals(no2.valor);
            no1 = no1.proximo;
            no2 = no2.proximo;
        }
        return equal && no1 == null && no2 == null;
    }
    
    /**
     * Classe interna que representa um nó na lista encadeada.
     * @param <E> O tipo do valor armazenado na lista
     */
    protected class No<E> {
        public E valor;
        public No<E> proximo;
        public No<E> anterior;

        public No(E valor) {
            this.valor = valor;
        }

        @Override
        public String toString() {
            return valor.toString();
        }
    }
    
}
