import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Snake {
    private char[][] snakeboard=null;
    private Queue<Node> food=new LinkedList<Node>();
    private Queue<Node> queue=new LinkedList<Node>();

    Snake(int row,int col){
        snakeboard=new char[row][col];
        queue.add(new Node(0, 0));
        food.add(new Node(1,0));
        food.add(new Node(2,1));
        food.add(new Node(3,2));
        food.add(new Node(4,3));
        food.add(new Node(5,4));
        printFood(queue.poll());
        

    }
    public void snakeMove(int row,int col){
        if(row>=0 && row<snakeboard.length &&col>=0 && col<snakeboard.length){
            if(snakeboard[row][col]=='*'){
                System.out.print("Game Over!");
                System.exit(0);
            }
            queue.add(new Node(row, col));
            if(snakeboard[row][col]!='.'){
                Node node=queue.poll();
                int r=node.getrow();
                int c=node.getcol();
                snakeboard[r][c]='\0';

            }
            if(snakeboard[row][col]=='.'){
                if(food.isEmpty()){
                    moveAndPrint(row,col);
                    System.out.println("Game Over!");
                    System.exit(0);
                }
                printFood(food.poll());
            }
            moveAndPrint(row,col);
            if(!queue.isEmpty()){
                Scanner s=new Scanner(System.in);
                System.out.print("Enter Direction: ");
                char dir=s.next().charAt(0);
                if(dir=='U'){
                    snakeMove(--row, col);
                }
                else if(dir=='D'){
                    snakeMove(++row, col);
                }
                else if(dir=='R'){
                    snakeMove(row, ++col);

                }
                else if(dir=='L'){
                    snakeMove(row, --col);
                }
            }
        }else{
            System.out.println("INVALID MOVE");
            System.exit(0);
        }
        }
    
        public void printFood(Node node){
            int r=node.getrow();
            int c=node.getcol();
            snakeboard[r][c]='.';
        }
        public void moveAndPrint(int row,int col){
            snakeboard[row][col]='*';
            printBorad();
        }
        public void printBorad(){
            for(char[] c:snakeboard){
                for(int j=0;j<snakeboard[0].length;j++){
                    System.out.print(c[j]+" ");
                }
            System.out.println();
            }
        }
    
    }   
    
