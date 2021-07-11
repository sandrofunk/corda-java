package com.template.states;

import com.template.contracts.TemplateContract;
import net.corda.core.contracts.BelongsToContract;
import net.corda.core.contracts.ContractState;
import net.corda.core.identity.AbstractParty;
import net.corda.core.identity.Party;

import java.util.Arrays;
import java.util.List;

// *********
// * State *
// *********
/* IOUState definido para representar Estados de entrada e saída compartilhados.*/

@BelongsToContract(TemplateContract.class)
public class IOUState implements ContractState {

    /* Variáveis Privadas
    * Utilizadas como exemplos de transação financeira dentro de uma rede corda.
    * Banco e Cliente
    * */
    private final int value;
    private final Party banco;
    private final Party cliente;


    /* Construtor dos Estado Corda
    * Suas Party serão Banco e Cliente
    * */
    public IOUState(int value, Party banco, Party cliente) {
        this.value = value;
        this.banco = banco;
        this.cliente = cliente;
    }

    //getters
    public int getValue() {
        return value;
    }

    public Party getBanco() {
        return banco;
    }

    public Party getCliente() {
        return cliente;
    }

    /* Este método irá mostrar quem são os participantes e assinantes em uma transação, quando for executada.
    * Participantes são uma lista de todas as partes que devem ser notificadas da criação ou de alguma alteração
    * de estado na rede.
    * */
    @Override
    public List<AbstractParty> getParticipants() {

        return Arrays.asList(banco,cliente);
    }
}