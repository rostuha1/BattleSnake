package user_interface.account.content.intelligence;

import javafx.scene.image.Image;

public enum Role {
    OWN_HEAD, OWN_BODY, OWN_TAIL, ENEMY_HEAD, ENEMY_BODY, ENEMY_TAIL, BARRIER, EMPTY;

    private static Image ownHead = new Image(IntelligenceContent.cardElementImagesPath + "own_head.png");
    private static Image ownBody = new Image(IntelligenceContent.cardElementImagesPath + "own_body.png");
    private static Image ownTail = new Image(IntelligenceContent.cardElementImagesPath + "own_tail.png");
    private static Image enemyHead = new Image(IntelligenceContent.cardElementImagesPath + "enemy_head.png");
    private static Image enemyBody = new Image(IntelligenceContent.cardElementImagesPath + "enemy_body.png");
    private static Image enemyTail = new Image(IntelligenceContent.cardElementImagesPath + "enemy_tail.png");
    private static Image barrier = new Image(IntelligenceContent.cardElementImagesPath + "barrier.png");
    private static Image empty = new Image(IntelligenceContent.cardElementImagesPath + "empty.png");

    public static Image getElementImage(Role role) {
        switch (role) {
            case OWN_HEAD: return ownHead;
            case OWN_BODY: return ownBody;
            case OWN_TAIL: return ownTail;
            case ENEMY_HEAD: return enemyHead;
            case ENEMY_BODY: return enemyBody;
            case ENEMY_TAIL: return enemyTail;
            case BARRIER: return barrier;
            case EMPTY: return empty;
            default: return null;
        }
    }

}
