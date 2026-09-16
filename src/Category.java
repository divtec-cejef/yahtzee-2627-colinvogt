public enum Category {
    unePaire("Une Paire"),
    deuxPaire("Deux Paire"),
    brelan("Brelan"),
    carre("Carre"),
    fullHouse("Full House"),
    petiteSuite("Petite Suite"),
    grandeSuite("Grande Suite"),
    yatzee("Yatzee");

    private String nom;

    Category(String nom) {
        this.nom = nom;
    }

    public String getNom () {
        return nom;
    }


    public int getScore(DiceHand dice) {
        int[] occurrences = DiceHand.compteNbreOccurences(dice.getValue());
        return switch (this) {
            case unePaire -> DiceHand.unePaire(occurrences);
            case deuxPaire -> DiceHand.deuxPaire(occurrences);
            case brelan -> DiceHand.brelan(occurrences);
            case carre -> DiceHand.carre(occurrences);
            case fullHouse -> DiceHand.fullHouse(occurrences);
            case petiteSuite -> DiceHand.petiteSuite(occurrences);
            case grandeSuite -> DiceHand.grandeSuite(occurrences);
            case yatzee -> DiceHand.yahtzee(occurrences);
        };
    }
}
