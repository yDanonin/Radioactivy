package radioactivity.system;

public class TextAnimation implements Runnable {
    private String text;
    private boolean finished;
    private int writingSpeed;

    public TextAnimation(String text){
        this.text = text;
        this.writingSpeed = 50;
        this.finished = false;

    }

    public TextAnimation(String text, int writingSpeed){
        this.text = text;
        this.writingSpeed = writingSpeed;
        this.finished = false;
    }

    public String getText(){
        return this.text;
    }

    public boolean isFinished(){
        return finished;
    }

    public void stopAnimation() {
        finished = true;
        writingSpeed = 0;
        System.out.print("\r");
        Thread.currentThread().interrupt();
    }

    @Override
    public void run(){
        while(!finished){
            try{
                for(int i = 0; i < text.length(); i++){
                    System.out.print(text.charAt(i));
                    Thread.sleep(writingSpeed);
                }
                System.out.println();
                finished = true;
            } catch(InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}
