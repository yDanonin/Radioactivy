package radioactivity.entities;

public class Item {
    private Interval damage;

    private Double attackSpeed;
    private Integer size;
    private String name;
    private Integer usages;
    private Integer healing;

    public Item(Interval damage, Double attackSpeed, Integer size, String name, Integer usages) {
        this.damage = damage;
        this.attackSpeed = attackSpeed;
        this.size = size;
        this.name = name;
        this.usages = usages;
    }
    public Item(Interval damage, Double attackSpeed, Integer size, String name) {
        this.damage = damage;
        this.attackSpeed = attackSpeed;
        this.size = size;
        this.name = name;
    }
    public Item(Integer size, String name, Integer usages, Integer healing) {
        this.healing = healing;
        this.size = size;
        this.name = name;
        this.usages = usages;
    }

    public Interval getDamage() {
        return damage;
    }

    public Double getAttackSpeed() {
        return attackSpeed;
    }

    public Integer getSize() {
        return size;
    }

    public String getName() {
        return name;
    }

    public Integer getUsages() {
        return usages;
    }

    public Integer getHealing() {
        return healing;
    }
    
    public boolean isNull(){
        if(damage.min == null && damage.max == null && attackSpeed == null && size == null && name == null && usages == null && healing == null){
            return true;
        }
        return false;
    }

    public boolean healingIsNull(){
        return healing == null;
    }
    
}
