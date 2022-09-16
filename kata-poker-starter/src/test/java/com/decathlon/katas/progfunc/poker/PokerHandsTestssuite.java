package com.decathlon.katas.progfunc.poker;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.groupingBy;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * tests suite for poker hands evaluation
 * @author deadbrain
 */
public class PokerHandsTestssuite {
    private static final List<Card> fooCards= new ArrayList<>(5);
    private  Hand fooHand;

    private static final  List<Card> basicPair = new ArrayList<>(5);
    private Hand basicPairHand;

    private static final List<Card> twoPairs = new ArrayList<>(5);
    private Hand twoPairsHand;

    private static final List<Card> threeOfAKind = new ArrayList<>(5);
    private Hand threeOfAKindHand;

    private static final List<Card> fourOfAKind = new ArrayList<>(5);
    private Hand fourAKindHand;


    private static final List<Card> fullHouse = new ArrayList<>(5);
    private Hand fullHouseHand;


    private static final List<Card> flush = new ArrayList<>(5);
    private Hand flushHand;

    private static final List<Card> straight = new ArrayList<>(5);
    private Hand straightHand;

    private static final List<Card> royalFlush = new ArrayList<>(5);
    private Hand royalFlushHand;

    @BeforeAll
    void setupTests(){
        fooCards.add(new Card(Rank.FIVE,Color.DIAMOND));
        fooCards.add(new Card(Rank.SEVEN,Color.DIAMOND));
        fooCards.add(new Card(Rank.SIX,Color.HEART));
        fooCards.add(new Card(Rank.EIGHT,Color.DIAMOND));
        fooCards.add(new Card(Rank.QUEEN,Color.HEART));
        fooHand=new Hand(fooCards);

        basicPair.add(new Card(Rank.QUEEN,Color.HEART));
        basicPair.add(new Card(Rank.QUEEN,Color.SPADE));
        basicPair.add(new Card(Rank.FOUR,Color.SPADE));
        basicPair.add(new Card(Rank.FIVE,Color.SPADE));
        basicPair.add(new Card(Rank.KING,Color.SPADE));
        basicPairHand=new Hand(basicPair);

        twoPairs.add(new Card(Rank.FIVE,Color.SPADE));
        twoPairs.add(new Card(Rank.FIVE,Color.HEART));
        twoPairs.add(new Card(Rank.SIX,Color.HEART));
        twoPairs.add(new Card(Rank.SIX,Color.SPADE));
        twoPairs.add(new Card(Rank.TWO,Color.TREFLE));
        twoPairsHand=new Hand(twoPairs);

        threeOfAKind.add(new Card(Rank.NINE,Color.SPADE));
        threeOfAKind.add(new Card(Rank.NINE,Color.HEART));
        threeOfAKind.add(new Card(Rank.NINE,Color.DIAMOND));
        threeOfAKind.add(new Card(Rank.FOUR,Color.SPADE));
        threeOfAKind.add(new Card(Rank.JACK,Color.TREFLE));
        ThreeAKindHand=new Hand(threeOfAKind);

        fourOfAKind.add(new Card(Rank.JACK,Color.TREFLE));
        fourOfAKind.add(new Card(Rank.JACK,Color.SPADE));
        fourOfAKind.add(new Card(Rank.JACK,Color.DIAMOND));
        fourOfAKind.add(new Card(Rank.JACK,Color.HEART));
        fourOfAKind.add(new Card(Rank.ACE,Color.TREFLE));
        fourAKindHand=new Hand(fourOfAKind);


        fullHouse.add(new Card(Rank.NINE,Color.TREFLE));
        fullHouse.add(new Card(Rank.NINE,Color.HEART));
        fullHouse.add(new Card(Rank.NINE,Color.SPADE));
        fullHouse.add(new Card(Rank.KING,Color.TREFLE));
        fullHouse.add(new Card(Rank.KING,Color.SPADE));
        fullHouseHand=new Hand(fullHouse);

        flush.add(new Card(Rank.SEVEN,Color.TREFLE));
        flush.add(new Card(Rank.EIGHT,Color.TREFLE));
        flush.add(new Card(Rank.NINE,Color.TREFLE));
        flush.add(new Card(Rank.TEN,Color.TREFLE));
        flush.add(new Card(Rank.JACK,Color.TREFLE));
        flushHand=new Hand(flush);

        straight.add(new Card(Rank.SEVEN,Color.TREFLE));
        straight.add(new Card(Rank.EIGHT,Color.DIAMOND));
        straight.add(new Card(Rank.NINE,Color.SPADE));
        straight.add(new Card(Rank.TEN,Color.TREFLE));
        straight.add(new Card(Rank.JACK,Color.HEART));
        straightHand=new Hand(straight);

        royalFlush.add(new Card(Rank.ACE,Color.TREFLE));
        royalFlush.add(new Card(Rank.KING,Color.TREFLE));
        royalFlush.add(new Card(Rank.QUEEN,Color.TREFLE));
        royalFlush.add(new Card(Rank.JACK,Color.TREFLE));
        royalFlush.add(new Card(Rank.TEN,Color.TREFLE));
        royalFlushHand=new Hand(royalFlush);

    }
    private boolean handIsValid(Hand hand){
        return hand !=null && hand .getCards()!=null && hand.getCards().size()==5;
    }

    private Map<Rank,List<Card>> groupeByRank(Hand hand){
        return hand.getCards()
                .stream().collect(groupingBy(Card::getRank));
    }

    private long howManyCount(Hand hand, int count){
        var groupByRank = groupeByRank(hand);
        return groupByRank.entrySet().stream()
                .filter(entry -> entry.getValue().size()==count).count();
    }

    /*Test*/
    @Test
    void hand_has_two_pair(){
        var numberOfPair = howManyCount(twoPairsHand,2);
        assertEquals(numberOfPair,2);

        numberOfPair = howManyCount(fourAKindHand,4);
        assertFalse(numberOfPair>0);
    }

    @Test
    void hand_has_flush(){
        //flushHand
        Map<Color, List<Card>> groupByColor = flushHand.getCards().stream().collect(groupingBy(card -> card.getColor()));

        long numberOfFlush = groupByColor.entrySet().stream().filter(entry -> entry.getValue().size() == 5).count();
        assertTrue(numberOfFlush==1);
    }

    @Test
    void hand_has_no_flush(){
        //flushHand
        Map<Color, List<Card>> groupByColor = flushHand.getCards().stream().collect(groupingBy(card -> card.getColor()));

        long numberOfFlush = groupByColor.entrySet().stream().filter(entry -> entry.getValue().size() == 5).count();
        assertFalse(numberOfFlush==1);
    }
}
