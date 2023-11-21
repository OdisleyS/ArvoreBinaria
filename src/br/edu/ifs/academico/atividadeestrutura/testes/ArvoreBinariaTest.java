package br.edu.ifs.academico.atividadeestrutura.testes;

import br.edu.ifs.academico.atividadeestrutura.arvoredebusca.ArvoreBinaria;
import br.edu.ifs.academico.atividadeestrutura.excecoes.ArvoreVaziaException;
import br.edu.ifs.academico.atividadeestrutura.excecoes.ValorDuplicadoException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ArvoreBinariaTest {

    private ArvoreBinaria<Integer> arvore;

    //Antes de cada teste os Nos com seu valores serão inseridos na arvore para realização dos testes.
    @BeforeEach
    void setUp() throws ValorDuplicadoException {
        arvore = new ArvoreBinaria<>();
        arvore.inserir(10);
        arvore.inserir(8);
        arvore.inserir(5);
        arvore.inserir(9);
        arvore.inserir(7);
        arvore.inserir(18);
        arvore.inserir(13);
        arvore.inserir(20);
    }

    @Test
    void testInserir() throws ArvoreVaziaException {
        // Testando a inserção e verificando se os elementos existem na árvore.
        assertTrue(arvore.buscar(10) != null);
        assertTrue(arvore.buscar(8) != null);
        assertTrue(arvore.buscar(5) != null);
        assertTrue(arvore.buscar(9) != null);
        assertTrue(arvore.buscar(7) != null);
        assertTrue(arvore.buscar(18) != null);
        assertTrue(arvore.buscar(13) != null);
        assertTrue(arvore.buscar(20) != null);

    }

    @Test
    void testRemover() throws ArvoreVaziaException {
        // Testando a remoção de elementos e verificando se eles foram removidos com sucesso
        assertTrue(arvore.remover(20));
        assertNull(arvore.buscar(20));
        assertTrue(arvore.remover(5));
        assertNull(arvore.buscar(5));
        assertTrue(arvore.remover(8));
        assertNull(arvore.buscar(8));
        assertTrue(arvore.remover(9));
        assertNull(arvore.buscar(9));
        assertTrue(arvore.remover(13));
        assertNull(arvore.buscar(13));
        assertTrue(arvore.remover(7));
        assertNull(arvore.buscar(7));
        assertTrue(arvore.remover(18));
        assertNull(arvore.buscar(18));
    }

    @Test
    void testBuscar() throws ArvoreVaziaException {
        // Testando a busca de elementos.
        assertEquals(7, arvore.buscar(7).getValor());
        assertEquals(5, arvore.buscar(5).getValor());
        assertEquals(20, arvore.buscar(20).getValor());
        assertEquals(8, arvore.buscar(8).getValor());
        assertEquals(10, arvore.buscar(10).getValor());
        assertNull(arvore.buscar(30));
    }

    @Test
    void testEmOrdem() {
        // br.edu.ifs.academico.atividadeestrutura.Teste o percurso em ordem (inOrder)
        System.out.println("Em Ordem:");
        arvore.emOrdem(arvore.getRaiz());
    }

    @Test
    void testPreOrdem() {
        // br.edu.ifs.academico.atividadeestrutura.Teste o percurso em pré-ordem (preOrder)
        System.out.println("Pre-Ordem:");
        arvore.preOrdem(arvore.getRaiz());
    }

    @Test
    void testPosOrdem() {
        // br.edu.ifs.academico.atividadeestrutura.Teste o percurso em pós-ordem (postOrder)
        System.out.println("Pos-Ordem:");
        arvore.posOrdem(arvore.getRaiz());
    }

    @Test
    void testPercorrerEmLargura() throws ArvoreVaziaException {
        System.out.println("Percorrer em Largura");
        System.out.println("Valor esperado " +
                "\n" +
                "\n" +
                "10\n" +
                "8\n" +
                "18\n" +
                "5\n" +
                "9\n" +
                "13\n" +
                "20\n" +
                "7");
        arvore.percorrerEmLargura(arvore.getRaiz());

    }
}





