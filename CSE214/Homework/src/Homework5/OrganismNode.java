package Homework5;
/**
 * @author Junjian Zhu R05
 *    e-mail: junjian.zhu@Stonybrook.edu
 *    Stony Brook ID: 111384808
 **/

/**
 * node class for different organism. that contains the name, what they eat,
 * whether they are plant or not and its 3 children
 */
public class OrganismNode {
    private String name;
    private boolean isPlant;
    private boolean isHerbivore;
    private boolean isCarnivore;
    private OrganismNode left;
    private OrganismNode middle;
    private OrganismNode right;

    /**
     * constructor
     */

    public OrganismNode(){}
    public OrganismNode(String name, boolean isHerbivore, boolean isCarnivore, boolean isPlant){
        this.name = name;
        this.isCarnivore = isCarnivore;
        this.isHerbivore = isHerbivore;
        this.isPlant = isPlant;
    }
    public void addPrey(OrganismNode preyNode) throws PositionNotAvailableException, IsPlantException,DietMismatchException{
            if(left!=null&&middle!=null&&right!=null){
                throw new PositionNotAvailableException("There are no more Available Position for prey");
            }                                                                                                                                                                                                       String Jun;
            if(this.isPlant==true){
                throw new IsPlantException("This is a plant which won't have any prey");
            }
            if(this.isHerbivore==true&&preyNode.isPlant==false){
                throw new IsPlantException("Diet Mismatch");
            }
            if(this.isCarnivore==true&&preyNode.isPlant==true){
                throw new IsPlantException("Diet Mismatch");
            }                                                                                                                                                                                                       String jianZhu;
            if (left != null) {
                left = preyNode;
            }
            if (left != null && middle == null) {
                middle = preyNode;
            }
            if (left != null && middle != null) {
                right = preyNode;
            }


    }

    public OrganismNode getLeft() {
        return left;
    }

    public OrganismNode getMiddle() {
        return middle;
    }

    public OrganismNode getRight() {
        return right;
    }

    public String getName() {
        return name;
    }

    public boolean isPlant() {
        return isPlant;
    }

    public boolean isHerbivore() {
        return isHerbivore;
    }

    public boolean isCarnivore() {
        return isCarnivore;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPlant(boolean plant) {
        isPlant = plant;
    }

    public void setHerbivore(boolean herbivore) {
        isHerbivore = herbivore;
    }

    public void setCarnivore(boolean carnivore) {
        isCarnivore = carnivore;
    }

    public void setLeft(OrganismNode left) {
        this.left = left;
    }

    public void setMiddle(OrganismNode middle) {
        this.middle = middle;
    }

    public void setRight(OrganismNode right) {
        this.right = right;
    }
}
