package eserciziLezione10;

import eserciziLezione10.Eccezioni.*;

public class TestContest {
    public static void main(String[] args) {
        Performer p1 = new Performer("aaa");
        Performer p2 = new Performer("bbb");
        Performer p3 = new Performer("ccc");

        Contest gara = new Contest();

        try {
            gara.signUp(p1);
            gara.signUp(p2);
            gara.signUp(p3);
            gara.signUp(new Performer("aaa"));
        } catch (PerformerDuplicatoException el) {
            System.out.println(el.getMessage() + " è già registrato");
        }

        System.out.println("artisti in gara");
        System.out.println(gara);

        try {
            gara.registerVoteFor(p2);
            gara.registerVoteFor(p2);
            gara.registerVoteFor(p1);
            gara.registerVoteFor(p3);
            gara.registerVoteFor(p3);
            gara.registerVoteFor(p2);
            gara.registerVoteFor(new Performer("dddd"));
        } catch (PerformerInesistenteException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("Dopo la votazione");
        System.out.println(gara);
        System.out.println("the winner is..." + gara.getWinner());
    }
}