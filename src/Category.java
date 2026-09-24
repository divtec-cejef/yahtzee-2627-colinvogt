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

    /**
     * Construit une category
     * @param nom
     */
    Category(String nom) {
        this.nom = nom;
    }

    /**
     * Obtient le nom de la category
     * @return le nom de la category
     */
    public String getNom () {
        return nom;
    }

    /**
     * Obtient le score corespondant au differente category
     * @param dice la liste de dé traité
     * @return le score
     */
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
