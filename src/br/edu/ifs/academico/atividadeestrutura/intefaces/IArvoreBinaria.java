package br.edu.ifs.academico.atividadeestrutura.intefaces;

import br.edu.ifs.academico.atividadeestrutura.intefaces.IArvore;

public interface IArvoreBinaria<T> extends IArvore {

    public void preOrdem(T atual);
    public void emOrdem(T atual);
    public void posOrdem(T atual);
}
