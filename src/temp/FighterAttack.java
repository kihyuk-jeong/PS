package temp;


public class FighterAttack extends PhysicalAttack {

    @Override
    int singleAttackDamage() {
        System.out.println("SU1");
        return super.singleAttackDamage() + 20;
    }

    @Override
    int doubleAttackDamage() {
        System.out.println("SU2");
        return super.doubleAttackDamage() + 10;
    }
}
