package com.grupo2.portaldemonitorias.Enum;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import com.fasterxml.jackson.annotation.JsonView;

import java.util.HashMap;
import java.util.Map;

public enum StudentStatus {

    AV("AV","Aguradando Avaliação"),
    A("A", "Aceito"),
    R("R", "Rejeitado");

    private final String chave;
    private final String descricao;

    private static final Map<String, StudentStatus> byDescription = new HashMap<>();

    static{
        for(StudentStatus s : values()){
            byDescription.put(s.chave, s);
        }
    }

    StudentStatus(String chave, String descricao) {
        this.chave = chave;
        this.descricao = descricao;
    }

    public String getChave() {
        return chave;
    }

    public String getDescricao() {
        return descricao;
    }

    @JsonValue
    public String getValor() {
        switch (this) {
            case AV:
            case A:
            case R:
                return valueOfDescription(getChave()).getDescricao();
        }
        return "Valor Inválido";
    }

    @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
    public static StudentStatus valueOfDescription(String key){
        return byDescription.get(key);
    }
}

