package Role;

import Etape.Phase;

public class Reine extends Role {

    public Reine() {
        this.age = 0;
        this.dureeDeVie = (int)(4 + (Math.random() * (10 - 4)) * 525600);
    }
}