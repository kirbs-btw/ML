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
    public static float sigmoid(float num){
        return (float) (1 / (1 + Math.pow(100, (num -1))));
        // return (float) (1 / (1 + Math.pow(Math.E, (num * (-1))))); // classic sigmoid function
    }
    // normalize values
    public static List<List<Float>> normalize(List<List<Float>> distSetList){
        List<List<Float>> distSetListNrml = new ArrayList<>();

        for (List<Float> distSet : distSetList){
            List<Float> distSetNrml = new ArrayList<>();
            for (float dist : distSet){
                float distNrml = sigmoid(dist);
                distSetNrml.add(distNrml);
            }
            distSetListNrml.add(distSetNrml);
        }
        return distSetListNrml;
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

    public static void main(String[] args) {
        List<Node> outputLayer = new ArrayList<>();
        List<Node> inputLayer = new ArrayList<>();

        // output node
        Node a = new Node(1, 1, 1, 1, 1);
        Node b = new Node(-1, -1, -1, -1, -1);
        outputLayer.add(a);
        outputLayer.add(b);

        // input node
        Node aa = new Node(1, 1, 1, 1, 1);
        inputLayer.add(aa);

        // sigmoid is not the right function to normalize, but it gets it between 0 and 1

        List<List<Float>> distSetList = distance(inputLayer, outputLayer);
        System.out.println(normalize(distSetList));

        List<Integer> probabilities = classify(distSetList); // just chooses a winner
    }
}