package arrayops;

public class ArrayOperationCoordination {
    private int[][] zweidimension;

    public ArrayOperationCoordination(int[][] zweidimension){
        //shallow copy
        this.zweidimension=zweidimension;
    }

    public void printArray(){
        for (int i = 0; i<zweidimension.length;i++){
            System.out.print("\n|\t");
            for(int j =0; j<zweidimension[i].length;j++){
                System.out.print(zweidimension[i][j]+"\t");
            }
            System.out.println("|");
        }
    }

    public void performOperation(IArrayOperations operation){
        operation.getDescription();
        operation.arrayOperation(zweidimension);
        printArray();
    }

    public int[][] getArray(){
        int[][] deepCopy = new int[zweidimension.length][zweidimension[0].length];
        for(int i=0; i< zweidimension.length;i++){
            for (int j=0; j<zweidimension[i][j];j++){
                deepCopy[i][j]=zweidimension[i][j];
            }
        }
        return deepCopy;
    }

    public static void main(String[] args){
        int[][] zweidimension = {{1,2,3},{4,5,6}};
        ArrayOperationCoordination coordination = new ArrayOperationCoordination(zweidimension);

        coordination.printArray();
    }
}
