package com.decathlon.katas.progfunc.poker;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * hand of cards (5)
 * use  this as you want, refactor it as often as needed
 * @author deadbrain
 */
public class Hand {
    private List<Card> cards;

    public Hand(List<Card> cards) {
        this.cards = cards;
    }

    public List<Card> getCards() {
        return cards;
    }

    public int howManyNIdenticalCards(int size) {
        Map<Rank, Long> cardRankNumbers = this.getCards()
                .stream()
                .map(Card::getRank)
                .collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));

        return (int) cardRankNumbers.values()
                .stream()
                .filter(numberOfCard -> numberOfCard == size)
                .count();
    }
}
