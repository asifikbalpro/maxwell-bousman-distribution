import java.io.*;
import java.util.Random;
import java.util.Scanner;


class Maxwell{
    int size_of = 100000000; // Box size
    int[] box = new int[100]; // this is the box.and number of box.
    int[] marble = new int[10000000]; // this is the marvel and number of marvel.
    int[] inside_box = new int[box.length]; // this is for finding how many marvel inside the box.
    Random random = new Random(); // random function
    int[] rand = new int[box.length];
    Scanner scanner = new Scanner(System.in);

    File file = new File("Data1.txt"); // this is get file name for data to write and create file for data

    // this is the box.
    // this is where box's size has defined.
    // and for testing it also print.
    public void box(){
        for (int i = 0; i < box.length; i++){
            box[i] = 1+random.nextInt(size_of); // this line put random value to box element.
        }
        for (int i = 0; i < rand.length; i++){
            rand[i] = 1+random.nextInt(size_of);
        }
//
//        System.out.println(box[0]);
//        System.out.println(box[1]);
//        System.out.println(box[2]);
//        System.out.println(box[3]);
//        System.out.println(box[4]);
        return;
    }

    //this is the marvel function.
    //this is where marvel size has defined.
    public void marble(){
        for(int i = 0; i < marble.length; i++){
            marble[i] = 1;
        }
    }

    //this is where i tested if working
    public void test(){
        for (int i = 0; i < marble.length; i++){
            int random2 = random.nextInt(box.length);
            int rand1 = 1+random.nextInt(size_of);
            if (box[random2] > rand[rand1]){
                inside_box[random2] += marble[i];
            }else if (box[random2] <= rand[rand1]){
                if (inside_box[random2] == 0){
                    inside_box[random2] += marble[i];
                }else if (inside_box[random2] != 0){
//                    inside_box[random2] += marble[i];
                    continue;
                }
            }
        }
    }
    

    // this where marvel add to inside the box randomly.
    public void adding_marvel_to_inside_box(){

        for (int i = 0; i < marble.length; i++){
            int rand = random.nextInt(box.length);
            inside_box[rand] += marble[i];
        }

    }

    // this where marvel add to inside the box randomly.
    public void adding_marvel_to_inside_box2(){
        for (int i = 0; i < marble.length; i++){
            int random2 = random.nextInt(box.length);
            int rand1 = 1+random.nextInt(size_of);

            if (box[random2] > rand1){
                inside_box[random2] += marble[i];
            }else if (box[random2] <= rand1){
                if (inside_box[random2] == 0){
                    inside_box[random2] += marble[i];
                }else if (inside_box[random2] != 0){
//                    inside_box[random2] += marble[i];
                    continue;
                }
            }
        }
    }


    public void view()  {
//        Scanner scanner = new Scanner(System.in);
//        System.out.println("give me a box number from : ");
//        int ask = scanner.nextInt();
//        System.out.println("box "+ ask + " Size " + box[ask] + " has " + inside_box[ask]);

        for(int i = 0; i < inside_box.length; i++){
            System.out.println("box "+ i + " Size " + box[i] + " has " + inside_box[i]);
        }
    }

    // this will write data on file
    public void Data() throws IOException {
//        RandomAccessFile writer = new RandomAccessFile("Data.txt", "rw");
        FileWriter fileWriter = new FileWriter(file.getAbsoluteFile()); //
//        fileWriter.write("box" + "\t" + "Box_Size" + "\t" + "Marble \n");

        for (int i = 0; i < inside_box.length; i++){
//            writer.writeInt(box[i] + inside_box[i]);
//            fileWriter.write(i + "\t" + box[i] +"\n");
//            fileWriter.write(i + "\t" + inside_box[i] +"\n");
            fileWriter.write(box[i] + "\t" + inside_box[i] +"\n"); //write data "box size" and how many marble inside that box


        }
        fileWriter.close();
    }

    public void find(){
        System.out.println("You have "+ box.length +" Number of Box.");
        System.out.println("You have "+ marble.length +" Number of Marble.");
        System.out.println("to find the specific Box's Size Enter number of your Box: ");
        int Box_num = scanner.nextInt();
        System.out.println("Box size is "+ box[Box_num] + " and inside number of Marble " + inside_box[Box_num]);
    }

}




public class Main {
    public static void main(String argc[]) throws IOException {
        System.out.println("welcome");

        Maxwell maxwell = new Maxwell();
        maxwell.box();
        maxwell.marble();
//        maxwell.test();
//        maxwell.adding_marvel_to_inside_box();
        maxwell.adding_marvel_to_inside_box2();
//        maxwell.view();
        maxwell.Data(); // if new data needed
        maxwell.find();

    }

}
