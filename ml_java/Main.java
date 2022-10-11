import java.util.*;

public class Main {

    public static List<List<Float>> distance( List<Node> inputLayer,List<Node>outputLayer){
        List<List<Float>> distSetList = new ArrayList<>();

        for (Node nodeInput : inputLayer){

            List<Float> distSet = new ArrayList<>();
            for (Node nodeOutput : outputLayer){
                float diffSqareSum = 0f;
                for (int i = 0; i < nodeInput.data.size(); i++){
                    float opinionDiff = nodeInput.data.get(i) - nodeOutput.data.get(i);
                    diffSqareSum = diffSqareSum + opinionDiff * opinionDiff;
                }
                float dist = (float) Math.sqrt(diffSqareSum);
                distSet.add(dist);
            }
            distSetList.add(distSet);
        }
        return distSetList;
    }

    public static float min(List<Float> arr){
        int small = 0;
        for (int i = 1; i < arr.size(); i++){
            if (arr.get(i) < arr.get(small)) small = i;
        }
        return small;
    }

    public static List<Integer> classify(List<List<Float>> distSetList){
        List<Integer> probability = new ArrayList<>();

        for (List<Float> distSet : distSetList){
            probability.add((int) min(distSet));
        }

        return probability;
    }

    public static List<Integer> analyze(List<Integer> choices, int candidateCount){
        List<Integer> data = new ArrayList<>();

        for (int i = 0; i < candidateCount; i++){
            int count = 0;
            for (int choice : choices){
                if (i == choice){
                       count++;
                }
            }
            data.add(count);
        }
        return data;
    }

    public static void main(String[] args) {
        List<Node> outputLayer = new ArrayList<>();
        List<Node> inputLayer = new ArrayList<>();

        //
        Node a = new Node(1, 1, 1, 1, 1);
        Node b = new Node(-1, -1, -1, -1, -1);
        outputLayer.add(a);
        outputLayer.add(b);

        Node aa = new Node(0, -0.5f, 0, 0, 0);
        inputLayer.add(aa);

        List<List<Float>> distSetList = distance(inputLayer, outputLayer);
        System.out.println(distSetList); // distances could be normalized with the max value of the square root
        List<Integer> probabilities = classify(distSetList); // just chooses a winner
    }
}