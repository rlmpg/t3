
import java.util.Comparator;
import utfpr.ct.dainf.pratica.Estudante;
import utfpr.ct.dainf.pratica.ListaDuplamenteEncadeada;

/**
 * UTFPR - Universidade Tecnológica Federal do Paraná
 * DAINF - Departamento Acadêmico de Informática
 * 
 * @author Wilson Horstmeyer Bogado <wilson@utfpr.edu.br>
 */
public class Pratica {

    public static void main(String[] args) {
        Pratica pratica = new Pratica();
        
        // para executar o teste, passe true como valor do argumento
        pratica.testeVazia(false);
        pratica.testeIterador(false);
        pratica.testeBusca(false);
        pratica.testeInsercaoFim(false);
        pratica.testeInsercaoInicio(false);
        pratica.testeInsercaoOrdenadaComparavel(false);
        pratica.testeInsercaoOrdenadaComparador(false);
        pratica.testeRemocaoInicio(false);
        pratica.testeRemocaoFim(false);
        pratica.testeRemocaoValor(false);
        pratica.testeOrdenacaoComparavel(false);
        pratica.testeOrdenacaoComparador(false);
    }
    
    
    private void testeVazia(boolean habilitado) {
        if (!habilitado) return;

        System.out.println("TESTE DE LISTA VAZIA");
        ListaDuplamenteEncadeada<Integer> lista = new ListaDuplamenteEncadeada<>();
        
        if (lista.isVazia())
            System.out.println("Lista vazia");
        else
            System.out.println("ERRO: lista não vazia");
        
        lista.insere(0);
        if (lista.isVazia())
            System.out.println("ERRO: lista vazia");
        else
            System.out.println("Lista não vazia");
        
    }
    
    private void testeIterador(boolean habilitado) {
        if (!habilitado) return;

        System.out.println("TESTE DO ITERADOR");
        ListaDuplamenteEncadeada<Integer> lista = new ListaDuplamenteEncadeada<>();
        lista.insere(90);
        lista.insere(10);
        lista.insere(30);
        lista.insere(50);
        lista.insere(70);
        System.out.println("Lista: " + lista);
        
        for (Integer i: lista) {
            System.out.println(i);
        }
    }
    
    private void testeBusca(boolean habilitado) {
        if (!habilitado) return;

        System.out.println("TESTE DE BUSCA");
        ListaDuplamenteEncadeada<Integer> lista = new ListaDuplamenteEncadeada<>();
        lista.insere(90);
        lista.insere(10);
        lista.insere(30);
        lista.insere(50);
        lista.insere(70);
        System.out.println("Lista: " + lista);

        Integer x = 50;
        if (lista.contem(x)) {
            System.out.println("Lista " + lista + " contém " + x);
        } else {
            System.out.println("Lista " + lista + " não contém " + x);
        }

        x = 20;
        if (lista.contem(x)) {
            System.out.println("Lista " + lista + " contém " + x);
        } else {
            System.out.println("Lista " + lista + " não contém " + x);
        }
    }
    
    private void testeInsercaoFim(boolean habilitado) {
        if (!habilitado) return;

        System.out.println("TESTE DE INSERÇÃO NO FINAL");
        ListaDuplamenteEncadeada<String> lista = new ListaDuplamenteEncadeada<>();
        lista.insere("Pedro").insere("Francisco").insere("Maria")
             .insere("Alexandre").insere("Paulo");
        System.out.println("Lista: " + lista);
    }
    
    private void testeInsercaoInicio(boolean habilitado) {
        if (!habilitado) return;

        System.out.println("TESTE DE INSERÇÃO NO INICIO");
        ListaDuplamenteEncadeada<String> lista = new ListaDuplamenteEncadeada<>();
        lista.insereInicio("Pedro").insereInicio("Francisco").insereInicio("Maria")
             .insereInicio("Alexandre").insereInicio("Paulo");
        System.out.println("Lista: " + lista);
    }
    
    private void testeInsercaoOrdenadaComparavel(boolean habilitado) {
        if (!habilitado) return;

        System.out.println("TESTE DE INSERÇÃO ORDENADA DE COMPARÁVEL");

        ListaDuplamenteEncadeada<String> lista = new ListaDuplamenteEncadeada<>();
        lista.insereOrdem("Pedro").insereOrdem("Francisco").insereOrdem("Maria")
             .insereOrdem("Alexandre").insereOrdem("Paulo");
        System.out.println("Lista: " + lista);
    }
    
    private void testeInsercaoOrdenadaComparador(boolean habilitado) {
        if (!habilitado) return;

        System.out.println("TESTE DE INSERÇÃO ORDENADA COM COMPARADOR");
        
        ListaDuplamenteEncadeada<Estudante> lista = new ListaDuplamenteEncadeada<>();
        boolean excecao = false; 
        try {
            lista.insereOrdem(new Estudante(90, "Pedro"));
        } catch (Exception e) {
            excecao = true;
            System.out.println("Exceção esperada: " + e.getLocalizedMessage());
        }
        if (!excecao) {
            System.out.println("ERRO: exceção esperada não ocorreu");
        }
        
        lista.setComparador(new Comparator<Estudante>() {
            @Override
            public int compare(Estudante e1, Estudante e2) {
                return e1.getMatricula() - e2.getMatricula();
            }
        });
        
        lista.insereOrdem(new Estudante(90, "Pedro")).insereOrdem(new Estudante(10, "Francisco"))
             .insereOrdem(new Estudante(30, "Maria")).insereOrdem(new Estudante(50, "Alexandre"))
             .insereOrdem(new Estudante(70, "Paulo"));
        System.out.println("Lista: " + lista);
    }

    private void testeRemocaoInicio(boolean habilitado) {
        if (!habilitado) return;
        
        System.out.println("TESTE DE REMOÇÃO NO INÍCIO");
        ListaDuplamenteEncadeada<Character> lista = new ListaDuplamenteEncadeada<>();

        boolean excecao = false; 
        try {
            lista.removeInicio();
        } catch (Exception e) {
            excecao = true;
            System.out.println("Exceção esperada: " + e.getLocalizedMessage());
        }
        if (!excecao) {
            System.out.println("ERRO: exceção esperada não ocorreu");
        }

        lista.insere('X').insere('K').insere('Y')
             .insere('A').insere('D');
        System.out.println("Lista: " + lista);
        
        lista.removeInicio();
        System.out.println("Lista resultante: " + lista);
        
    }
    
    private void testeRemocaoFim(boolean habilitado) {
        if (!habilitado) return;
        
        System.out.println("TESTE DE REMOÇÃO NO FIM");
        ListaDuplamenteEncadeada<Character> lista = new ListaDuplamenteEncadeada<>();
        
        boolean excecao = false; 
        try {
            lista.removeFim();
        } catch (Exception e) {
            excecao = true;
            System.out.println("Exceção esperada: " + e.getLocalizedMessage());
        }
        if (!excecao) {
            System.out.println("ERRO: exceção esperada não ocorreu");
        }
        
        lista.insere('X').insere('K').insere('Y')
             .insere('A').insere('D');
        System.out.println("Lista: " + lista);
        
        lista.removeFim();
        System.out.println("Lista resultante: " + lista);
        
    }
    
    private void testeRemocaoValor(boolean habilitado) {
        if (!habilitado) return;
        
        System.out.println("TESTE DE REMOÇÃO DE VALOR");
        ListaDuplamenteEncadeada<Character> lista = new ListaDuplamenteEncadeada<>();
        lista.insere('X').insere('K').insere('Y')
             .insere('A').insere('D');
        System.out.println("Lista: " + lista);
        
        boolean excecao = false; 
        try {
            lista.remove('F');
        } catch (Exception e) {
            excecao = true;
            System.out.println("Exceção esperada: " + e.getLocalizedMessage());
        }
        if (!excecao) {
            System.out.println("ERRO: exceção esperada não ocorreu");
        }
        
        lista.remove('Y');
        System.out.println("Lista resultante: " + lista);        
    }
    
    private void testeOrdenacaoComparavel(boolean habilitado) {
        if (!habilitado) return;
        
        System.out.println("TESTE DE ORDENACAO COM VALORES COMPARÁVEIS");
        ListaDuplamenteEncadeada<Character> lista = new ListaDuplamenteEncadeada<>();
        lista.insere('X').insere('K').insere('Y')
             .insere('A').insere('D');
        System.out.println("Lista: " + lista);
        
        lista.ordena();
        System.out.println("Lista resultante: " + lista);        
    }
    
    private void testeOrdenacaoComparador(boolean habilitado) {
        if (!habilitado) return;
        
        System.out.println("TESTE DE ORDENACAO COM COMPARADOR");
        ListaDuplamenteEncadeada<Estudante> lista = new ListaDuplamenteEncadeada<>();
        boolean excecao = false; 
        
        lista.insere(new Estudante(90, "Pedro")).insere(new Estudante(10, "Francisco"))
             .insere(new Estudante(30, "Maria")).insere(new Estudante(50, "Alexandre"))
             .insere(new Estudante(70, "Paulo"));
        
        try {
            lista.ordena();
        } catch (Exception e) {
            excecao = true;
            System.out.println("Exceção esperada: " + e.getLocalizedMessage());
        }
        if (!excecao) {
            System.out.println("ERRO: exceção esperada não ocorreu");
        }
        
        lista.setComparador(new Comparator<Estudante>() {
            @Override
            public int compare(Estudante e1, Estudante e2) {
                return e1.getMatricula() - e2.getMatricula();
            }
        });
        
        lista.ordena();
        System.out.println("Lista ordenada: " + lista);
    }
}
