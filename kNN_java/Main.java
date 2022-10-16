import java.security.spec.RSAOtherPrimeInfo;
import java.sql.Array;
import java.sql.SQLOutput;
import java.util.*;


public class Main {

    public static List<List<Float>> distance(Node inputNode, List<OutputNode> outputLayer){
        List<List<Float>> distSet = new ArrayList<>();

        for (OutputNode outputNode : outputLayer){
            float diffSqareSum = 0;
            for (int i = 0; i < outputNode.data.size(); i++){
                float diff = inputNode.data.get(i) - outputNode.data.get(i);
                diffSqareSum = diffSqareSum + (diff * diff);
            }
            float dist = (float) Math.sqrt(diffSqareSum);
            List<Float> distValue = new ArrayList<>();
            distValue.add(outputNode.value);
            distValue.add(dist);

            distSet.add(distValue);
        }

        return distSet;
    }

    public static List<List<Float>> bubbleSort(List<List<Float>> arr){
        List<Float> smaller = new ArrayList<>();
        List<Float> bigger = new ArrayList<>();
        boolean run = true;


        for (int i = 0; i < arr.size() && run; i++) {
            run = false;

            for (int y = 0; y < arr.size()-1; y++) {
                System.out.println(arr.get(1));
                System.out.println(arr.get(1).get(1));


                if(arr.get(y).get(1) > arr.get(y + 1).get(1)) {
                    bigger = arr.get(y);
                    smaller = arr.get(y + 1);
                    arr.set(y, smaller);
                    arr.set(y + 1, bigger);
                    run = true;
                }
            }
        }


        return arr;
    }



    public static void main(String[] args) {
        Random random = new Random();
        int k = 10;
        List<OutputNode> outputLayer = new ArrayList<>();
        Node inputNode = new Node(0, 0.4f, 0.1f);

        for (int i = 0; i < 50; i++){
            OutputNode a = new OutputNode((float)random.nextInt(0, 5), random.nextFloat(-1, 1), random.nextFloat(-1, 1), random.nextFloat(-1, 1));
            outputLayer.add(a);
        }

        System.out.println(bubbleSort(distance(inputNode, outputLayer)));

    }
}