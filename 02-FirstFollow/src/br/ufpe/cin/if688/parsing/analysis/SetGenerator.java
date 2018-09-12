package br.ufpe.cin.if688.parsing.analysis;

import java.util.*;

import br.ufpe.cin.if688.parsing.grammar.*;


public final class SetGenerator {

    public static Map<Nonterminal, Set<GeneralSymbol>> getFirst(Grammar g) {

        if (g == null) throw new NullPointerException("g nao pode ser nula.");

        Map<Nonterminal, Set<GeneralSymbol>> first = initializeNonterminalMapping(g);
        /*
         * Implemente aqui o método para retornar o conjunto first
         */
        Collection<Nonterminal> n = g.getNonterminals();
        Set[] teste = new Set[n.size()];
        Collection<Production> regras = g.getProductions();//lista das regras

        for(Production p : regras){//o for que percorre todas as regras
            List<GeneralSymbol> producao = p.getProduction();//regra atual
            if((producao.get(0) instanceof Terminal) || (producao.get(0) instanceof SpecialSymbol)){
                Set<GeneralSymbol> aux = new HashSet<GeneralSymbol>();
                aux.add(producao.get(0));
                first.merge(p.getNonterminal(),aux);
            }
        }
        return first;

    }


    public static Map<Nonterminal, Set<GeneralSymbol>> getFollow(Grammar g, Map<Nonterminal, Set<GeneralSymbol>> first) {

        if (g == null || first == null)
            throw new NullPointerException();

        Map<Nonterminal, Set<GeneralSymbol>> follow = initializeNonterminalMapping(g);

        /*
         * implemente aqui o método para retornar o conjunto follow
         */

        return follow;
    }

    //método para inicializar mapeamento nãoterminais -> conjunto de símbolos
    private static Map<Nonterminal, Set<GeneralSymbol>>
    initializeNonterminalMapping(Grammar g) {
        Map<Nonterminal, Set<GeneralSymbol>> result =
                new HashMap<Nonterminal, Set<GeneralSymbol>>();

        for (Nonterminal nt: g.getNonterminals())
            result.put(nt, new HashSet<GeneralSymbol>());

        return result;
    }

}
