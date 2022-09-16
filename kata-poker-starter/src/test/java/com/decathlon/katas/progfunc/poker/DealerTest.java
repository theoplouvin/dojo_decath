package com.decathlon.katas.progfunc.poker;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


public class DealerTest {

    @Test
    void isHandAFullHouse(){
        //Given
        Dealer dealer = new Dealer();
        //When
        boolean hasFullOfKind = dealer.containsFullHouse(new Hand(List.of(
                new Card(Rank.KING, Color.DIAMOND),
                new Card(Rank.KING, Color.DIAMOND),
                new Card(Rank.KING, Color.DIAMOND),
                new Card(Rank.TEN, Color.DIAMOND),
                new Card(Rank.TEN, Color.DIAMOND)
        )));
        //Then
        assertTrue(hasFullOfKind);
    }

    @Test
    void isHandNotAFullHouse(){
        //Given
        Dealer dealer = new Dealer();
        //When
        boolean hasFullOfKind = dealer.containsFullHouse(new Hand(List.of(
                new Card(Rank.KING, Color.DIAMOND),
                new Card(Rank.KING, Color.DIAMOND),
                new Card(Rank.KING, Color.DIAMOND),
                new Card(Rank.TEN, Color.DIAMOND),
                new Card(Rank.NINE, Color.DIAMOND)
        )));
        //Then
        assertFalse(hasFullOfKind);
    }

    @Test
    void a_hand_is_a_four_of_kind(){
        //Given
        Dealer dealer = new Dealer();
        //When
        boolean hasFourOfAKind = dealer.containsFourOfAKind(new Hand(List.of(
                new Card(Rank.FIVE, Color.DIAMOND),
                new Card(Rank.FIVE, Color.DIAMOND),
                new Card(Rank.FIVE, Color.DIAMOND),
                new Card(Rank.FIVE, Color.DIAMOND),
                new Card(Rank.NINE, Color.HEART)
        )));
        //Then
        assertTrue(hasFourOfAKind);
    }

    @Test
    void a_hand_is_not_a_four_of_kind(){
        //Given
        Dealer dealer = new Dealer();
        //When
        boolean hasFourNotOfAKind = dealer.containsFourOfAKind(new Hand(List.of(
                new Card(Rank.JACK,Color.DIAMOND),
                new Card(Rank.NINE,Color.HEART),
                new Card(Rank.TEN,Color.HEART),
                new Card(Rank.FIVE,Color.DIAMOND),
                new Card(Rank.NINE,Color.HEART)
        )));
        //Then
        assertFalse(hasFourNotOfAKind);
    }

    @Test
    void a_hand_is_a_three_of_kind(){
        //Given
        Dealer dealer = new Dealer();
        //When
        boolean hasThreeOfaKind = dealer.containsThreeOfAKind(new Hand(List.of(
                new Card(Rank.JACK,Color.DIAMOND),
                new Card(Rank.FIVE,Color.DIAMOND),
                new Card(Rank.FIVE,Color.DIAMOND),
                new Card(Rank.FIVE,Color.DIAMOND),
                new Card(Rank.NINE,Color.HEART)
        )));
        //Then
        assertTrue(hasThreeOfaKind);
    }

    @Test
    void a_hand_is_a_not_three_of_kind(){
        //Given
        Dealer dealer = new Dealer();
        //When
        boolean hasNotThreeOfaKind = dealer.containsThreeOfAKind(new Hand(List.of(
                 new Card(Rank.JACK,Color.DIAMOND),
                 new Card(Rank.NINE,Color.HEART),
                 new Card(Rank.TEN,Color.HEART),
                 new Card(Rank.FIVE,Color.DIAMOND),
                 new Card(Rank.NINE,Color.HEART)
                )));
        //Then
        assertFalse(hasNotThreeOfaKind);
    }

    @Test
    void a_hand_is_a_pair(){
        //Given
        Dealer dealer = new Dealer();
        //When
        boolean hasAPair = dealer.containsPair(new Hand(List.of(
                new Card(Rank.SEVEN,Color.DIAMOND),
                new Card(Rank.SIX,Color.HEART)
        )));
        //Then
        assertFalse(hasAPair);
    }

    @Test
    void a_hand_is_a_pair_2(){
        //Given
        Dealer dealer = new Dealer();
        //When
        boolean hasNotAPair2 = dealer.containsPair(new Hand(List.of(
                new Card(Rank.JACK, Color.DIAMOND),
                new Card(Rank.NINE, Color.HEART)
        )));
        //Then
        assertFalse(hasNotAPair2);
    }

    @Test
    void a_hand_is_a_pair_3(){
        //Given
        Dealer dealer = new Dealer();
        //When
        boolean hasNotAPair3 = dealer.containsPair(new Hand(List.of(
                new Card(Rank.JACK,Color.DIAMOND),
                new Card(Rank.TWO,Color.HEART),
                new Card(Rank.TEN,Color.HEART),
                new Card(Rank.FIVE,Color.DIAMOND),
                new Card(Rank.NINE,Color.HEART)
        )));
        //Then
        assertFalse(hasNotAPair3);
    }
}
