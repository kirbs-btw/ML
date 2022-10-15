import java.util.ArrayList;
import java.util.List;
import java.util.*;


public class Main {

    public static List<List<Float>> distance(List<Node> inputLayer, List<Node> outputLayer){
        List<List<Float>> distSetList = new ArrayList<>();

        for (Node inputNode : inputLayer){
            List<Float> distSet = new ArrayList<>();
            for (Node outputNode : outputLayer){
                float diffSqareSum = 0f;
                for (int i = 0; i < inputNode.data.size(); i++){
                    float diff = inputNode.data.get(i) - outputNode.data.get(i);
                    diffSqareSum = diffSqareSum + (diff * diff);
                }
                float dist = (float) Math.sqrt(diffSqareSum);
                distSet.add(dist);
            }
            distSetList.add(distSet);
        }
        return distSetList;
    }


    public static void main(String[] args) {
        int k = 50;
        List<Node> outputLayer = new ArrayList<>();
        List<Node> inputLayer = new ArrayList<>();

        for (int i = 0; i < 50; i++){
            Node a = new Node(0, 1, 2, 3);
            Node b = new Node(0, 1, 5, 3);

            outputLayer.add(a);
            inputLayer.add(b);
        }
        System.out.println(distance(inputLayer, outputLayer));

    }
}