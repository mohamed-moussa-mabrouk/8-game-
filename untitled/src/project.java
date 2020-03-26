import java.util.*;
public class project {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Scanner imput =new Scanner(System.in);
        int arr [][]=new int [3][3];
        for (int i=0 ;i<3;i++) {
            for (int j=0 ;j<3;j++) {
                arr [i][j]=imput.nextInt();
            }
        }
        System.out.print("the sloution by bfs");
        long time0pen1=System.currentTimeMillis();
        Node Root=new Node(arr);

        searchBfs sbd=new searchBfs();
        List<Node> solution=sbd.BFSsearch(Root);
        if(solution.size()>0) {
            solution=reverse(solution);
            for (int i=0;i<solution.size();i++) {
                solution.get(i).printpuzzel();
            }
        }
        else {
            System.out.print("no sloution for this statment");}
        long endtime1=System.currentTimeMillis();
        System.out.print("the time of bfs search in millis seconde is :"+(endtime1-time0pen1));
        /*System.out.println("the sloution by dfs");
    long time0pen=System.currentTimeMillis();
        Node Root2=new Node(arr);

    searchDfs FCDS=new searchDfs();
    List<Node> solution2=FCDS.DFSsearch(Root2);
        if(solution2.size()>0) {
      solution2=reverse(solution2);
        for (int i=0;i<solution2.size();i++) {
            solution2.get(i).printpuzzel();
        }
    }
        else {
        System.out.print("no sloution for this statment");}
        long endtime=System.currentTimeMillis();
        System.out.print("the time of dfs search in millis seconde is :"+(endtime-time0pen));
    */}

    public static List<Node> reverse(List<Node> solution){
        Object[]array=solution.toArray();
        List<Node> solution2=new ArrayList<>();
        for(int i=0;i<array.length/2;i++) {
            Node temp=solution.get(i);
            Node temp2=solution.get(array.length-1-i);
            array[i]=temp2;
            array[array.length-i-1]=temp;
        }
        for(int i=0;i<array.length;i++){
            solution2.add((Node) array[i]);
        }
        return solution2;
    }

}
