package com.entregas.modulopessoa.enums;

public enum TipoPessoa {

    F("Física"), J("Jurídica");

    private String descricao;

    TipoPessoa(String descricao) {
        this.descricao = descricao;
    }

    public String toString() {
        return descricao;
    }

}
