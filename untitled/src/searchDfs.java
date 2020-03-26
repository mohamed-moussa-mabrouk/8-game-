import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class searchDfs {
        public searchDfs() {

        }

    public List<Node> DFSsearch (Node root){
        List<Node> waytogoal=new ArrayList();
        List<Node> openlist=new ArrayList();
        List<Node> closelist=new ArrayList();
        Stack<Node> x =new Stack<>();
        x.push(root);
        boolean reachthegoal=false;
        while(x.size()>0&&!reachthegoal){
            Node currentNode=x.pop();
            closelist.add(currentNode);
            currentNode.Expandmove();
            currentNode.printpuzzel();
            for(int i=0;i<currentNode.getChildren().size();i++){
                if(!compleate(closelist, currentNode.children.get(i))) {
                    x.push(currentNode.children.get(i));

                }
            }
            Node currentchild=x.peek();
            if(currentchild.isgoal(currentchild.getData())) {
                System.out.println("the goal is found");
                reachthegoal=true;
                pathshow(waytogoal,currentchild);
            }
        }

        return waytogoal;

    }
        public void pathshow(List<Node>waytogoal,Node n) {
            System.out.println("the path is");
            Node current=n;
            waytogoal.add(current);
            while(current.parent!=null) {
                current=current.parent;
                waytogoal.add(current);
            }
        }
        public static boolean compleate(List<Node>LISTOfNODE,Node c) {
            boolean compleate=false;
            for(int i=0;i<LISTOfNODE.size();i++) {
                if(LISTOfNODE.get(i).IsSameArrayInLastNode(c.data))
                    compleate=true;
            }

            return compleate ;
        }
    }