package pl.sda.orange2.lambda;

public class LambdaExercises {
    public static void main(String[] args) {
        BoysDontCry boy = new ChłopakiNiePłaczą();
        boy.silnoreki();
        // boy.sing();

        ChłopakiNiePłaczą boy2 = new ChłopakiNiePłaczą();
        boy2.sing();

        //rzutowanie ((ChłopakiNiePłaczą) boy).sing();


        // anonymous class
        BoysDontCry anonymousClassReference = new BoysDontCry() {
            @Override
            public void silnoreki() {
                System.out.println("Anonimowy silnoreki:)");

            }
        };

        anonymousClassReference.silnoreki();

        // BoysDontCry stupid = new String("");
    }
}
