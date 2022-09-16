package com.decathlon.katas.progfunc.poker;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Dealer {

    public boolean containsPair(Hand myHand) {
        return hasNIdenticalCards(myHand,2);
    }

    public boolean containsThreeOfAKind(Hand myHand) {
        return hasNIdenticalCards(myHand,3);
    }

    public boolean containsFourOfAKind(Hand myHand) {
        return hasNIdenticalCards(myHand,4);
    }

    public boolean containsFullHouse(Hand myHand) {
        return containsPair(myHand) && containsThreeOfAKind(myHand);
    }

    public boolean containsHasTwoPair(Hand myHand) {
        return myHand.howManyNIdenticalCards(2)==2;
    }

    public boolean containsHasNotTwoPair(Hand myHand) {
        return myHand.howManyNIdenticalCards(2)==1;
    }

    private boolean hasNIdenticalCards(Hand myHand, int size) {
        Map<Rank, List<Card>> byRank = myHand.getCards().stream().collect(Collectors.groupingBy(Card::getRank));
        return byRank.values().stream().anyMatch(list -> list.size() == size);
    }
}
