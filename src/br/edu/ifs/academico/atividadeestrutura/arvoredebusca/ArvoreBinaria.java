package br.edu.ifs.academico.atividadeestrutura.arvoredebusca;

import br.edu.ifs.academico.atividadeestrutura.excecoes.ArvoreVaziaException;
import br.edu.ifs.academico.atividadeestrutura.excecoes.ValorDuplicadoException;
import br.edu.ifs.academico.atividadeestrutura.intefaces.IArvore;

import java.util.LinkedList;
import java.util.Queue;

public class ArvoreBinaria<T extends Comparable<T>> implements IArvore<T> {

    private No<T> raiz;

    public ArvoreBinaria() {
        this.raiz = null;
    }

    @Override
    public void inserir(T valor) throws ValorDuplicadoException {
        No<T> no = new No<T>(valor); //Cria o No

        if (raiz == null) {  // Primeiro No da arvore, caso a arvore esteja vazia, a Raiz recebe o no
            this.raiz = no;
        } else {   // caso a raix não esteja nula, vamos ter essas opções abaixo

            No<T> atual = this.raiz;   // "Atual" marca qual No esta testando no momento
                                      // começando da raiz

            while (true) {
                int comparacao = valor.compareTo(atual.getValor());   //Compara o valor fornecido com o valor do atual
                            /*    No compareTO, se o retorno dele for:
                                  0, os valores comparados são iguais
                                  1, o novo No é maior q o atual
                                 -1,o novo No é menor */

                if (comparacao == 0) { //Se o novo valor for igual ao atual, lança exceção
                    throw new ValorDuplicadoException("Valor duplicado: " + valor);

                } else if (comparacao < 0) { //Se o novo valor for menor que o atual

                    if (atual.getFilhoEsq() != null) { //Verifica se atual tem filho a esquerda para que ele possa adicionar o novo NO

                        atual = atual.getFilhoEsq(); //Enquanto atual tiver filho a esquerda,
                                                    // essa linha vai comparado esses filhos até a hr q não tiver mais filhos

                    } else { // Se o atual não tiver filho a esquerda

                        atual.setFilhoEsq(no);  //A esquerda do atual recebe o novo elemento
                        break;
                    }
                } else {  //Se o novo valor for maior q o atual

                    if (atual.getFilhoDir() != null) { //verifica se o atual tem direita

                        atual = atual.getFilhoDir();  //Enquanto atual tiver filho a direita,
                        // essa linha vai comparado esses filhos até a hr q não tiver mais filhos


                    } else {  // Se o atual não tiver filho a direita

                        atual.setFilhoDir(no);   //A direita do atual recebe o novo elemento
                        break;
                    }
                }
            }
        }
    }

    public No<T> getRaiz() { // mandando o programa começar pela raiz
        return raiz;
    }

    //Percorrimento da Árvore em PROFUNDIDADE
    public void emOrdem(No<T> atual) {
        if (atual != null) {
            emOrdem(atual.getFilhoEsq()); //vai para a esquerda do atual

            System.out.println(atual.getValor()); // imprime o numero
            emOrdem(atual.getFilhoDir()); //vai pra direita do atual
        }
    }
    public void preOrdem(No<T> atual) {
        if (atual != null) {
            System.out.println(atual.getValor()); //imprime o numero
            preOrdem(atual.getFilhoEsq()); // vai pra esquerda em pre ordem
            preOrdem(atual.getFilhoDir()); // vai pra direita em pre ordem
        }
    }
    public void posOrdem(No<T> atual) {
        if (atual != null) {
            posOrdem(atual.getFilhoEsq()); // faz em pos ordem a esquerda
            posOrdem(atual.getFilhoDir()); // faz em pos ordem a direita
            System.out.println(atual.getValor()); // imprime o numero
        }
    }

    @Override
    public boolean remover(T valor) throws ArvoreVaziaException {
        //Buscar o No na arvore

        No<T> atual = this.raiz;  //Cria a um No "atual" começando pela raiz

        No<T> paiAtual = null;  // Cria um No chamado "PaiAtual" para guardar o anterior do atual

        while (atual != null) {  //Enquanto o atual for diferente de Null

            //vai caminhando até encontrar o valor ou encontrar null

            if (atual.getValor().equals(valor)) {  // Se atual for igual ao valor procurado quer dizer que encontrou o elemento
                break;
            } else if (valor.compareTo(atual.getValor()) == -1) { //valor procurado é menor que o que o atual

                //se for menor vem pra esquerda

                paiAtual = atual;  // paiAtual recebe o valor do atual

                atual = atual.getFilhoEsq();  // atual anda para sua esquerda

            } else {  // se o valor procurado for maior que o atual

                //se for maior, vem pra direita

                paiAtual = atual;  //paiAtual recebe o valor do atual

                atual = atual.getFilhoDir();  // atual anda para sua esquerda
            }
        }
        //Verifica se o No existe
        if (atual != null) {  //Enquanto o atual for diferente de Null

            //No tem dois filhos ou tem filho somente a direita
            if (atual.getFilhoDir() != null) {
                No<T> substituto = atual.getFilhoDir();
                No<T> paiSubstituto = atual;
                while (substituto.getFilhoEsq() != null) {
                    paiSubstituto = substituto;
                    substituto = substituto.getFilhoEsq();
                }
                substituto.setFilhoEsq(atual.getFilhoEsq()); // essa linha é pra não perder a referencia do filho do atual,
                                                            // dps que o substituto ir pro lugar dele
                if (paiAtual != null) {
                    if (atual.getValor().compareTo(paiAtual.getValor()) == -1) { //atual menor que paiAtual
                        paiAtual.setFilhoEsq(substituto); //troca o atual pelo valor do substituto pela esquerda
                    } else {
                        paiSubstituto.setFilhoDir(substituto); //troca o atual pelo valor do substituto pela dirieita
                    }
                } else { //Se não tem paiAtual então o nó é a raiz
                    this.raiz = substituto;
                    paiSubstituto.setFilhoEsq(null);
                    this.raiz.setFilhoDir(paiSubstituto);
                    this.raiz.setFilhoEsq(atual.getFilhoEsq());
                }
                //Remove o elemento da arvore
                if (substituto.getValor().compareTo(paiSubstituto.getValor()) == -1) { //substituto < que paiSubstituto
                    paiSubstituto.setFilhoEsq(null);
                } else {
                    paiSubstituto.setFilhoDir(null);
                }


            } else if (atual.getFilhoEsq() != null) { //Tem filho só a esquerda

                No<T> substituto = atual.getFilhoEsq();
                No<T> paiSubstituto = atual;

                while (substituto.getFilhoDir() != null) { // vai andando com as duas variaveis
                    // ate o substituto achar o valor mais proximo do valor que vai ser removido

                    paiSubstituto = substituto;
                    substituto = substituto.getFilhoDir();  //vai descendo pela direita, dps de já ter passado pela esquerda
                }

                //colocar o substituto no lugar do atual
                if (paiAtual != null) {
                    if (atual.getValor().compareTo(paiAtual.getValor()) == -1) { //atual menor que paiAtual

                        paiAtual.setFilhoEsq(substituto); //troca o atual pelo valor do substituto pela esquerda

                    } else { //atual maior q paiAtual
                        paiSubstituto.setFilhoDir(substituto); //troca o atual pelo valor do substituto pela direita
                    }
                } else { //Se paiAtual for null,
                    // ent o elemento a ser substituido é a raiz

                    this.raiz = substituto;
                }

                //**Depos do while vem pra ca, pra remover
                //Remove o elemento da arvore, ou seja remover o substituto do lugar que ele estava
                if (substituto.getValor().compareTo(paiSubstituto.getValor()) == -1) { //substituto menor que paiSubstituto

                    paiSubstituto.setFilhoEsq(null); // apagou a referencia do substituto pela esquerda

                } else { //substituto maior q paiSubstituto
                    paiSubstituto.setFilhoDir(null); // apagou a referencia do substituto pela esquerda
                }


                //****começa a explicar por aqui na aula
                //os ifs de la de cima faz a busca do elemento, encontra ele,
                // mas ele não tem filhos
            } else { // Não tem filho
                if (paiAtual != null) {
                    if (atual.getValor().compareTo(paiAtual.getValor()) == -1) { //atual é menor que paiAtual
                        paiAtual.setFilhoEsq(null);  //apaga a esquerda do paiAtual, removendo o elemento desejado
                    } else {  //se atual for maior
                        paiAtual.setFilhoDir(null); // apaga a direira do paiAtual, removendo o elemento desejado
                    }
                    //como o elemento que desejamos remover não tem filhos, utilizamos
                    // o paiAtual pra remover o eelemento desejado


                } else { //É a raiz
                    this.raiz = null;
                    throw new ArvoreVaziaException("A árvore está vazia");

                }
            }
            return true;
        } else { //se o elemento não existe
            return false;
        }
    }

    public void percorrerEmLargura(No<Integer> raiz) throws ArvoreVaziaException {

        if (this.raiz == null) { // Verifica se a raiz é nula
            throw new ArvoreVaziaException(" A árvore está vazia!");
        }

        System.out.println("\nLargura da Árvore \n");

        Queue<No> fila = new LinkedList<>(); // Fila de No é criada
        fila.add(this.raiz); // Adiciona na fila a raiz

        while (!fila.isEmpty()) { //Enquanto a fila não ficar vazia
            No<T> atual = fila.poll(); // Joga o valor da fila em atual e remove da fila
            System.out.println(atual.getValor()); // printa o valor de atual

            if (atual.getFilhoEsq() != null) { // pega a esquerda do atual e joga na fila
                fila.add(atual.getFilhoEsq());
            }

            if (atual.getFilhoDir() != null) { // pega a dreita do atual e joga na fila
                fila.add(atual.getFilhoDir());
            }
        }
    }

    @Override
    public No<T> buscar(T valor) throws ArvoreVaziaException {
            No<T> atual = this.raiz;

            while (atual != null) {
                int comparacao = valor.compareTo(atual.getValor());

                if (comparacao == 0) { // Valor encontrado
                    System.out.println("Valor encontrado: " + valor);
                    return atual;
                } else if (comparacao < 0) { // Valor procurado é menor que o atual
                    atual = atual.getFilhoEsq();
                } else { // Valor procurado é maior que o atual
                    atual = atual.getFilhoDir();
                }
            }
            if (this.raiz == null){
                throw new ArvoreVaziaException("A árvore está vazia");

            }
            // Elemento não encontrado
            System.out.println("Valor nao encontrado: " + valor);
            return null;
        }
    }
    


