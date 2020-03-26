
import java.util.ArrayList;
import java.util.List;

public class Node {

    public   int[][] data = null;
    public List<Node> children = new ArrayList<>();
    int IdColom;
    int IdRow;
    Node parent = null;

    public Node(int[][] data) {
        this.data = data;
    }
    public void setData(int[][] data) {
        this.data = data;
    }
    public int[][] getData() {
        return data;
    }
    private void setParent(Node parent) {
        this.parent = parent;
    }
    public Node getParent() {
        return parent;
    }
    public void addChild(Node x) {
        x.setParent(this);
        this.children.add(x);
    }
    public List<Node> getChildren() {
        return children;
    }
    public void copypuzzel(int x[][],int y[][]) {
        for (int i=0;i<y.length;i++) {
            for (int j=0;j<x.length;j++) {
                x[i][j]=y[i][j];
            }
        }
    }

    public void right(int i,int j,int [][]array){
        if(j<2) {
            int [][]array2=new int[3][3];
            copypuzzel(array2,array);
            int temp=array2[i][j];
            array2[i][j]=array2[i][j+1];
            array2[i][j+1]=temp;
            Node child=new Node (array2);
            children.add(child);
            child.parent=this;}
    }
    public  void left(int i,int j, int[][] array){
        if(j>0) {
            int [][]array2=new int[3][3];
            copypuzzel(array2,array);
            int temp=array2[i][j];
            array2[i][j]=array2[i][j-1];
            array2[i][j-1]=temp;
            Node child=new Node (array2);
            children.add(child);
            child.parent=this;}
    }
    public  void down(int i,int j, int[][] array){
        if(i<2) {
            int [][]array2=new int[3][3];
            copypuzzel(array2,array);
            int temp=array2[i][j];
            array2[i][j]=array2[i+1][j];
            array2[i+1][j]=temp;
            Node child=new Node (array2);
            children.add(child);
            child.parent=this;}
    }
    public  void up(int i,int j, int[][] array){
        if(i>0) {
            int [][]array2=new int[3][3];
            copypuzzel(array2,array);
            int temp=array2[i][j];
            array2[i][j]=array2[i-1][j];
            array2[i-1][j]=temp;
            Node child=new Node (array2);
            children.add(child);
            child.parent=this;}
    }
    public void Expandmove() {
        for(int i=0;i<3;i++) {
            for(int j=0;j<3;j++) {
                if (data[i][j]==0) {
                    IdColom=j;
                    IdRow=i;
                }
            }
        }
        right(IdRow, IdColom, data);
        left(IdRow, IdColom, data);
        down(IdRow, IdColom, data);
        up(IdRow, IdColom, data);
    }
    public void printpuzzel() {
        System.out.println();
        for(int i=0;i<3;i++) {
            for(int j=0;j<3;j++) {
                System.out.print(data[i][j]+"");
            }
            System.out.println();
        }
        System.out.println("**********************************");
    }
    public boolean IsSameArrayInLastNode(int [][]array) {
        for(int i=0;i<3;i++) {
            for(int j=0;j<3;j++) {
                if(data[i][j]!=array[i][j])
                    return false;
            }
        }
        return true;
    }
    public boolean isgoal(int[][] arr) {
        final int[][] arraygoal={{0,1,2},{3,4,5},{6,7,8}};
        int m=arr[0][0];
        if(m==0){
            for(int i=0;i<3;i++) {
                for(int j=0;j<3;j++) {
                    if(arr[i][j]==arraygoal[i][j]){

                                                  }
                    else{
                        return false;
                        }

                                     }
                                }
            return
                    true;
                }
        else{
            return false;
            }

                                      }



}