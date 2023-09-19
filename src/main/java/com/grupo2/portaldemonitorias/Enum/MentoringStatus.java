package com.grupo2.portaldemonitorias.Enum;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import com.fasterxml.jackson.annotation.JsonView;

import java.util.HashMap;
import java.util.Map;

public enum MentoringStatus {

    AC("AC","Aceitando Inscricoes"),
    AV("AV","Avaliando Inscricoes"),
    M("M", "Monitorando"),
    F("F", "Fechada");

    private final String chave;
    private final String descricao;

    private static final Map<String, MentoringStatus> byDescription = new HashMap<>();

    static{
        for(MentoringStatus s : values()){
            byDescription.put(s.chave, s);
        }
    }

    MentoringStatus(String chave, String descricao) {
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
            case AC:
            case AV:
            case M:
            case F:
                return valueOfDescription(getChave()).getDescricao();
        }
        return "Valor Inválido";
    }

    @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
    public static MentoringStatus valueOfDescription(String key){
        return byDescription.get(key);
    }
}

