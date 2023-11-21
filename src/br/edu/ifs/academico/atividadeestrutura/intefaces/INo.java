package br.edu.ifs.academico.atividadeestrutura.intefaces;

import br.edu.ifs.academico.atividadeestrutura.arvoredebusca.No;

public interface INo<T extends Comparable<T>>{

    T getValor();
    void setValor(T valor);

    No getFilhoEsq();
    void setFilhoEsq(No<T> filhoEsq);

    No getFilhoDir();
    void setFilhoDir(No<T> filhoDir);
}
