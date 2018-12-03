package modele;

public class Reine extends Phase {

    public Reine() {
        this.age = 0;
        this.dureeDeVie = (int)(4 + (Math.random() * (10 - 4)) * 525600);
    }
}
