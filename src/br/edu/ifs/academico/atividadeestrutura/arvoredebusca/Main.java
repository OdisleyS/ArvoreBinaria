package br.edu.ifs.academico.atividadeestrutura.arvoredebusca;

import br.edu.ifs.academico.atividadeestrutura.excecoes.ArvoreVaziaException;
import br.edu.ifs.academico.atividadeestrutura.excecoes.ValorDuplicadoException;

public class Main {
    public static void main(String[] args) throws ValorDuplicadoException, ArvoreVaziaException {

        ArvoreBinaria<Integer> arvore = new ArvoreBinaria<Integer>();

        arvore.inserir(10);
        arvore.inserir(8);
        arvore.inserir(5);
        arvore.inserir(9);
        arvore.inserir(7);
        arvore.inserir(18);
        arvore.inserir(13);
        arvore.inserir(20);

        System.out.println("\n\n Em-ordem");
        arvore.emOrdem(arvore.getRaiz());

        arvore.remover(10);
        System.out.println("\n\nEm-ordem");
        arvore.emOrdem(arvore.getRaiz());

        arvore.remover(20);
        System.out.println("\n\nEm-ordem");
        arvore.emOrdem(arvore.getRaiz());

        arvore.buscar(13);
        arvore.buscar(20);

        System.out.println("\n\n pre-ordem");
        arvore.preOrdem(arvore.getRaiz());

        System.out.println("\n\n pos-ordem");
        arvore.posOrdem(arvore.getRaiz());

        arvore.percorrerEmLargura(arvore.getRaiz());

    }
}

//Odisley Nascimento Santos
