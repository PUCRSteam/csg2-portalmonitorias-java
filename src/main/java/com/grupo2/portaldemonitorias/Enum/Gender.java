//New Enum for Gender

package com.grupo2.portaldemonitorias.Enum;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import com.fasterxml.jackson.annotation.JsonView;

import java.util.HashMap;
import java.util.Map;

public class Gender {

    M("M","Male"),
    F("F","Female"),
    O("O", "Others");

    private final String chave;
    private final String descricao;

    private static final Map<String, Gender> byDescription = new HashMap<>();

    static{
        for(Gender g : values()){
            byGender.put(g.chave, g);
        }
    }

    Gender(String chave, String descricao) {
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
            case M:
            case F:
            case O:
                return valueOfDescription(getChave()).getDescricao();
        }
        return "Valor Inválido";
    }

    @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
    public static Gender valueOfDescription(String key){
        return byGender.get(key);
    }

}
