package baseball.domain;

public class Game {

    private boolean playing = false;

    public boolean isPlaying() {
        return playing;
    }

    public void start() {
        this.playing = true;
    }
}
