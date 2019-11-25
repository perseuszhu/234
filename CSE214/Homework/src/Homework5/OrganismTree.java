package Homework5;
/**
 * @author Junjian Zhu R05
 *    e-mail: junjian.zhu@Stonybrook.edu
 *    Stony Brook ID: 111384808
 **/
public class OrganismTree {
    private OrganismNode root;
    private OrganismNode cursor;

    public OrganismTree(){}
    public OrganismTree(OrganismNode apexPredator){
        this.root = apexPredator;
    }

    /**
     * reset cursor to root
     */
    public void cursorReset(){
        cursor = root;
    }

    /**
     * move cursor to the assign child of the curret cursor
     * @param name the name for the next cursor
     * @throws IllegalArgumentException
     */
    public void moveCursor(String name) throws IllegalArgumentException{
        if(cursor.getLeft() != null){
            if(cursor.getLeft().getName().equalsIgnoreCase(name)){
                cursor = cursor.getLeft();
                System.out.println("Cursor successfully moved to "+name);
            }
            if(cursor.getMiddle()!=null){
                if(cursor.getMiddle().getName().equalsIgnoreCase(name)){
                    cursor = cursor.getMiddle();
                    System.out.println("Cursor successfully moved to "+name);
                }
                if(cursor.getRight() !=null){
                    if(cursor.getRight().getName().equalsIgnoreCase(name)){
                        cursor = cursor.getRight();
                        System.out.println("Cursor successfully moved to "+name);
                    }
                    else{
                        throw new IllegalArgumentException ("Name not found. ");
                    }
                }
            }

        }

    }

    /**
     * list all prey of the current cursor
     * @return a string varible that contains all prey
     * @throws IsPlantException
     */
    public String listPrey() throws IsPlantException{
        String prey = " ";
        prey += cursor.getName()+"-->";
        if(cursor.getLeft()!=null){
            prey += cursor.getLeft().getName()+", ";
        }
        if(cursor.getMiddle()!=null){
            prey += cursor.getMiddle().getName()+", ";
        }
        if(cursor.getRight()!=null){
            prey += cursor.getRight().getName()+", ";
        }

        if (cursor.isPlant() == true){
            System.out.println("Current cursor is a Plant, there are no predators for this cursor.");
            return null;
        }
        return prey;
    }

    /**
     * have some sort of idea how to write this but Java Api and creating a parent variable is not
     * allowed. So temporarily disable this method to ensure that the system will run without error
     * @return
     */
    public String listFoodChain(){
        String trace = preordertrace(root);
        return trace;
    }
    public String preordertrace(OrganismNode root){
        String name = cursor.getName();
        String trace = "";
        boolean found = false;
        while(!found){
        if (root != null) {
            trace += root.getName()+" -> ";
            trace += preordertrace(root.getLeft());
            if(root.getName().equalsIgnoreCase(name)){
                found = true;
                return trace;
            }
            trace += preordertrace(root.getMiddle());
            if(root.getName().equalsIgnoreCase(name)){
                found = true;
                return trace;
            }
            trace += preordertrace(root.getRight());
            if(root.getName().equalsIgnoreCase(name)){
                found = true;
                return trace;
            }


        }}


        return null;
    }

    /**
     * print the current foodpyramid below the cursor. everytime depth +1, 3 more spaces are added to create
     * indentation (helper method)
     * @param node cursor
     * @param n 0 for depth
     */
    public void print(OrganismNode node, int n){
        if(node != null){
        int s = 3*n;
        for(int i = 0; i < s; i++){
            System.out.print(" ");
        }
        System.out.print("|- ");
            System.out.println(node.getName());
            print(node.getLeft(),n+1);
            print(node.getMiddle(),n+1);
            print(node.getRight(),n+1);
        }
    }

    /**
     * print the food chain via the method above.
     */
    public void printOrganismTree(){
       print(cursor,0);
        }

    /**
     * add a animalchild for current cursor. throw exception if current cursor cannot have a animal child.
     * also throws exception if curret cursor's child is full.
     * @param name name of the child that is about to be added.
     * @param isHerbivore child type
     * @param isCarnivore child type
     * @throws IllegalArgumentException
     * @throws PositionNotAvailableException
     */
    public void addAnimalChild(String name, boolean isHerbivore, boolean isCarnivore) throws IllegalArgumentException, PositionNotAvailableException{
        if(cursor.isHerbivore()&&!cursor.isCarnivore()){
            throw new IllegalArgumentException("Current cursor is a Herbivore");
        }
        else{
            OrganismNode node = new OrganismNode();
            node.setName(name);
            node.setCarnivore(isCarnivore);
            node.setHerbivore(isHerbivore);
            if (cursor.getLeft() == null) {
                cursor.setLeft(node);
            }
            else if (cursor.getLeft() != null && cursor.getMiddle() == null) {
                cursor.setMiddle(node);
            }
            else if (cursor.getRight() == null) {
                cursor.setRight(node);
            } else {
                throw new PositionNotAvailableException("All child node of the current cursor is taken");
            }
        }

    }

    /**
     * same as method above. but only requires name because plant will be leaf node and there
     * wont be any prey for a plant
     * @param name
     * @throws IllegalArgumentException
     * @throws PositionNotAvailableException
     */
    public void addPlantChild(String name)throws IllegalArgumentException, PositionNotAvailableException{
        if(cursor.isCarnivore()&&!cursor.isHerbivore()){
            throw new IllegalArgumentException("Current cursor is a Carnivore");
        }
        OrganismNode node = new OrganismNode();
        node.setName(name);
        node.setPlant(true);
        if(cursor.isHerbivore()){
            if (cursor.getLeft() == null) {
                cursor.setLeft(node);
            }
            else if (cursor.getMiddle() == null) {
                cursor.setMiddle(node);
            }
            else if (cursor.getRight() == null) {
                cursor.setRight(node);
            } else {
                throw new PositionNotAvailableException("All child node of the current cursor is taken");
            }
        }
    }

    /**
     * although called inorder, but its a preorder traverse to go through the entire tree to find out all
     * the plant node.
     * @param root
     * @return
     */
    public String inOrderTraverse(OrganismNode root){
        String inorder = "";
        if(root != null){
            if(root.isPlant()){
                inorder += root.getName()+", ";
            }
            inorder += inOrderTraverse(root.getLeft());
            inorder += inOrderTraverse(root.getMiddle());
            inorder += inOrderTraverse(root.getRight());
        }
        return inorder;
    }

    /**
     * print out all the plant node's name via the method above.
     * @return
     */
    public String listAllPlants(){
        String allPlants = inOrderTraverse(root);
        return allPlants;
    }

    /**
     * remove a assigned child of the current cursor
     * @param name the name of the child that is about to be removed.
     * @throws IllegalArgumentException
     */
    public void removeChild(String name)throws IllegalArgumentException{
        if(cursor.getLeft().getName().equalsIgnoreCase(name)){
            cursor.setLeft(cursor.getMiddle());
            cursor.setMiddle(cursor.getRight());
            cursor.setRight(null);
        }
        else if(cursor.getMiddle().getName().equalsIgnoreCase(name)){
            cursor.setMiddle(cursor.getRight());
            cursor.setRight(null);
        }
        else if(cursor.getRight().getName().equalsIgnoreCase(name)){
            cursor.setRight(null);
        }
        else throw new IllegalArgumentException("name not found");
    }

    public OrganismNode getCursor() {
        return cursor;
    }

    public OrganismNode getRoot() {
        return root;
    }

    public void setRoot(OrganismNode root) {
        this.root = root;
    }

    public void setCursor(OrganismNode cursor) {
        this.cursor = cursor;
    }
}
