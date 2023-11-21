package br.edu.ifs.academico.atividadeestrutura.intefaces;

import br.edu.ifs.academico.atividadeestrutura.excecoes.ArvoreVaziaException;
import br.edu.ifs.academico.atividadeestrutura.arvoredebusca.No;
import br.edu.ifs.academico.atividadeestrutura.excecoes.ValorDuplicadoException;

public interface IArvore<T extends Comparable<T>>{


    public void inserir(T valor) throws ValorDuplicadoException;
    public boolean remover(T valor) throws ArvoreVaziaException;
    public No buscar(T valor) throws ArvoreVaziaException;
}
